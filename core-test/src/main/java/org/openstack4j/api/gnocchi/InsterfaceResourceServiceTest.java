package org.openstack4j.api.gnocchi;

import java.util.List;

import org.openstack4j.api.AbstractTest;
import org.openstack4j.api.Builders;
import org.openstack4j.openstack.gnocchi.domain.GnocchiIntfResource;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@Test(suiteName = "Gnocchi")
public class InsterfaceResourceServiceTest extends AbstractTest {
    private static final String JSON_INTERFACES = "/gnocchi/list_interfaces.json";
    private static final String JSON_INTERFACE = "/gnocchi/interface.json";

    /**
     * search gnocchi interface
     *
     * @throws Exception
     */
    @Test
    public void gnocchiIntfGetListTest() throws Exception {
        respondWith(JSON_INTERFACES);

        List<? extends GnocchiIntfResource> intfs = osv3().gnocchi().interfaces().list();

        assertFalse(intfs.isEmpty());
        assertEquals(3, intfs.size());
        assertEquals(intfs.get(0).getName(), "tap003227a0-87");
        assertEquals(intfs.get(0).getMetrics().size(), 12);

    }

    /**
     * search gnocchi interface
     *
     * @throws Exception
     */
    @Test
    public void gnocchiIntfGetByInstanceIdTest() throws Exception {
        respondWith(JSON_INTERFACE);

        List<? extends GnocchiIntfResource> intf = osv3().gnocchi().interfaces()
                .getByInstId(Builders.gnocchi().searchCondition(Builders.gnocchi()
                        .instanceId("29e2e84f-7a4b-45ff-bd8f-e554fe593e1e").build()).build());

        assertFalse(intf.isEmpty());
        assertEquals(1, intf.size());
        assertEquals(intf.get(0).getName(), "tap003227a0-87");
        assertEquals(intf.get(0).getMetrics().size(), 12);

    }

    @Override
    protected Service service() {
        return Service.GNOCCHI;
    }
}
