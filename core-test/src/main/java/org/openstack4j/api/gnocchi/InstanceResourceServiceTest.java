package org.openstack4j.api.gnocchi;

import java.util.List;

import org.openstack4j.api.AbstractTest;
import org.openstack4j.api.Builders;
import org.openstack4j.openstack.gnocchi.domain.GnocchiInstResource;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

@Test(suiteName = "Gnocchi")
public class InstanceResourceServiceTest extends AbstractTest {
    private static final String JSON_INSTACNCES = "/gnocchi/list_instances.json";
    private static final String JSON_INSTACNCE = "/gnocchi/instance.json";

    /**
     * list all gnocchi instance metrics id
     *
     * @throws Exception
     */
    @Test
    public void gnocchiInstanceListGetTest() throws Exception {
        respondWith(JSON_INSTACNCES);

        List<? extends GnocchiInstResource> instList = osv3().gnocchi().instances().list();

        assertFalse(instList.isEmpty());
        assertEquals(2, instList.size());
        assertEquals(instList.get(0).getDisplayName(), "ubuntu-18.10-yaojie");
        assertEquals(instList.get(0).getFlavorName(), "m1.large");

    }

    /**
     * search gnocchi instance
     *
     * @throws Exception
     */
    @Test
    public void gnocchiInstanceGetByNameTest() throws Exception {
        respondWith(JSON_INSTACNCE);
        GnocchiInstResource inst = osv3().gnocchi().instances()
                .getDetail("c33658e1-bee2-4785-b189-0c2cdf64c94f");

        assertNotNull(inst);
        assertEquals(inst.getDisplayName(), "demo1");
        assertEquals(inst.getFlavorName(), "m1.tiny");
    }

    @Override
    protected Service service() {
        return Service.GNOCCHI;
    }
}
