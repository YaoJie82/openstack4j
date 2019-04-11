package org.openstack4j.openstack.appcontainer.internal;

import org.openstack4j.api.types.ServiceType;
import org.openstack4j.openstack.internal.BaseOpenStackService;
import org.openstack4j.openstack.common.functions.EnforceVersionToURL;

public class BaseAppcontainerServices extends BaseOpenStackService{
    protected BaseAppcontainerServices(){super(ServiceType.APPCONTAINER, EnforceVersionToURL.instance("/v1", true));}
}
