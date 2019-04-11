package org.openstack4j.api.appcontainer;

import org.openstack4j.common.RestService;
import org.openstack4j.model.appcontainer.Appcontainer;
import org.openstack4j.model.common.ActionResponse;

import java.util.List;

public interface AppcontainerService extends RestService{

    Appcontainer get(String containerId);

    Appcontainer create(Appcontainer appcontainer);

    ActionResponse delete(String containerId);

    ActionResponse start(String containerId);

    ActionResponse stop(String containerId);

    List<? extends  Appcontainer> list();
}
