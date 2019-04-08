package org.openstack4j.api.gnocchi;

import java.util.List;

import org.openstack4j.api.AbstractTest;
import org.openstack4j.openstack.gnocchi.domain.GnocchiInstResource;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@Test(suiteName = "gnocchi/instances")
public class InstanceResourceServiceTest extends AbstractTest {
    private static final String JSNO_INSTACNCES = "/gnocchi/list_instances.json";

    public void instGetListTest() throws Exception {
        respondWith(JSNO_INSTACNCES);

        List<? extends GnocchiInstResource> instList = osv3().gnocchi().instances().list();

        assertFalse(instList.isEmpty());
        assertEquals(2, instList.size());
        assertEquals(instList.get(0).getDisplayName(), "ubuntu-18.10-yaojie");
        assertEquals(instList.get(0).getFlavorName(), "m1.large");

    }

    @Override
    protected Service service() {
        return Service.GNOCCHI;
    }
}
