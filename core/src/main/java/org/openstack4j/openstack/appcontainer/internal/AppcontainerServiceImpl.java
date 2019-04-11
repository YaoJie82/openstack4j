package org.openstack4j.openstack.appcontainer.internal;

import org.openstack4j.api.appcontainer.AppcontainerService;
import org.openstack4j.model.appcontainer.Appcontainer;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.openstack.appcontainer.domain.ZunAppcontainer;

import static com.google.common.base.Preconditions.checkNotNull;
import java.util.List;

public class AppcontainerServiceImpl extends BaseAppcontainerServices implements AppcontainerService {
    @Override
    public Appcontainer get(String containerId) {
        checkNotNull(containerId);
        return get(ZunAppcontainer.class, uri("/containers/%s", containerId)).execute();
    }

    @Override
    public Appcontainer create(Appcontainer appcontainer) {
        checkNotNull(appcontainer);
        return post(ZunAppcontainer.class, uri("/containers")).entity(appcontainer).execute();
    }

    @Override
    public ActionResponse delete(String containerId) {
        checkNotNull(containerId);
        return deleteWithResponse(uri("/containers/%s", containerId)).execute();
    }

    @Override
    public ActionResponse start(String containerId) {
        return post(ActionResponse.class, uri("/containers/%s/start", containerId)).execute();
    }

    @Override
    public ActionResponse stop(String containerId) {
        return post(ActionResponse.class, uri("/containers/%s/stop", containerId)).execute();
    }

    @Override
    public List<? extends Appcontainer> list() {
        return get(ZunAppcontainer.Appcontainers.class, uri("/containers")).execute().getList();
    }
}
