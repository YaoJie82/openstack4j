package org.openstack4j.api.appcontainer;

import okhttp3.mockwebserver.RecordedRequest;
import org.openstack4j.api.Builders;
import org.openstack4j.common.Buildable;
import org.openstack4j.model.appcontainer.Appcontainer;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.openstack.appcontainer.domain.ZunAppcontainer;
import org.testng.annotations.Test;
import org.openstack4j.api.AbstractTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openstack4j.model.appcontainer.Status;

import java.util.List;
import java.util.Map;

@Test(suiteName = "Appcontainer")
public class AppcontainerTests extends AbstractTest {
    private static final String JSON_APPCONTAINER = "/appcontainer/appcontainer.json";
    private static final String JSON_APPCONTAINERS = "/appcontainer/appcontainers.json";

    private static final String APPCONTAINER_NAME = "n2";
    private static final String APPCONTAINER_NAME_FIRST = "n1";
    private static final String APPCONTAINER_ID = "4b70056f-033f-4ea1-8707-3e313aa6bd05";

    private static final String APPCONTAINER_ID_FIRST = "c581c990-63ce-4b18-8e0f-2401e4be4ac4";
    private static final String APPCONTAINER_NETWORK_ID_FIRST = "f7805b20-b380-469e-afd7-16d824b80000";
    private static final String APPCONTAINER_NETWORK_ADDR_FIRST = "10.0.0.5";

    private static final String JSON_APPCONTAINER_NEW = "/appcontainer/appcontainer-new.json";
    private static final String APPCONTAINER_NAME_NEW = "n6";
    private static final String APPCONTAINER_IMAGE_NEW = "nginx-docker";
    private static final String APPCONTAINER_SECURITY_GROUP_NEW = "2dd9b1bc-c293-49f8-b904-6ab752171de1";

    @Override
    protected Service service() {
        return Service.APP_CONTAINER;
    }

    @Test
    public void getAppcontainer() throws Exception {
        respondWith(JSON_APPCONTAINER);
        Appcontainer a = osv3().appcontainer().get(APPCONTAINER_ID);
        server.takeRequest();
        assertEquals(a.getName(), APPCONTAINER_NAME);
        assertEquals(a.getStatus(), Status.RUNNING);
        assertEquals(a.isInteractive(), true);
    }

    @Test
    public void listAppcontainer() throws Exception {
        respondWith(JSON_APPCONTAINERS);
        List<? extends Appcontainer> apps = osv3().appcontainer().list();
        assertEquals(apps.size(), 11);


        RecordedRequest listRequest = server.takeRequest();
        assertNotNull(listRequest.getHeader("X-Auth-Token"));

        assertEquals(apps.get(0).getName(), APPCONTAINER_NAME_FIRST);
        assertEquals(apps.get(0).getStatus(), Status.STOPPED);
        assertEquals(apps.get(0).getId(), APPCONTAINER_ID_FIRST);

        assertEquals(apps.get(0).getAddresses()
                .get(APPCONTAINER_NETWORK_ID_FIRST).get(0).addr,
                APPCONTAINER_NETWORK_ADDR_FIRST);
    }

    @Test
    public void startAppcontainer() throws Exception {
        respondWith(202);
        ActionResponse result = osv3().appcontainer().start(APPCONTAINER_ID);
        server.takeRequest();
        assertTrue(result.isSuccess());
    }

    @Test
    public void stopAppcontainer() throws Exception {
        respondWith(202);
        ActionResponse result = osv3().appcontainer().stop(APPCONTAINER_ID);
        server.takeRequest();
        assertTrue(result.isSuccess());
    }

    @Test
    public void deleteAppcontainer() throws Exception {
        respondWith(204);
        ActionResponse result = osv3().appcontainer().delete(APPCONTAINER_ID);
        server.takeRequest();
        assertTrue(result.isSuccess());
    }

    @Test
    public void createAppcontainer() throws Exception {
        respondWith(JSON_APPCONTAINER_NEW);

        Appcontainer appcontainer = Builders.appcontainer()
                .name(APPCONTAINER_NAME_NEW)
                .image(APPCONTAINER_IMAGE_NEW)
                .interactive(true)
                .build();

        Appcontainer a = osv3().appcontainer().create(appcontainer);
        server.takeRequest();
        assertEquals(a.getName(), APPCONTAINER_NAME_NEW);
        assertEquals(a.getImage(), APPCONTAINER_IMAGE_NEW);
        assertEquals(a.isInteractive(), true);
        assertEquals(a.getSecurityGroups().get(0), APPCONTAINER_SECURITY_GROUP_NEW);

    }

}
