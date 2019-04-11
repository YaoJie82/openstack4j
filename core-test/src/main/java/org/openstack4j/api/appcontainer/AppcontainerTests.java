package org.openstack4j.api.appcontainer;

import org.openstack4j.api.AbstractTest;

public class AppcontainerTests extends AbstractTest {
    @Override
    protected Service service() {
        return Service.APP_CONTAINER;
    }


}
