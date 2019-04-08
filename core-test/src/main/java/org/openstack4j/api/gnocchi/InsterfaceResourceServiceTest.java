package org.openstack4j.api.gnocchi;

import java.util.List;

import org.openstack4j.api.AbstractTest;
import org.openstack4j.openstack.gnocchi.domain.GnocchiIntfResource;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@Test(suiteName = "gnocchi/interfaces")
public class InsterfaceResourceServiceTest extends AbstractTest {
    private static final String JSNO_INSTACNCES = "/gnocchi/list_interfaces.json";

    public void intfGetListTest() throws Exception {
        respondWith(JSNO_INSTACNCES);

        List<? extends GnocchiIntfResource> instList = osv3().gnocchi().interfaces().list();

        assertFalse(instList.isEmpty());
        assertEquals(3, instList.size());
        assertEquals(instList.get(0).getName(), "tap003227a0-87");
        assertEquals(instList.get(0).getMetrics().size(), 12);

    }

    @Override
    protected Service service() {
        return Service.GNOCCHI;
    }
}
