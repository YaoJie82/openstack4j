package org.openstack4j.api.gnocchi;

import java.util.List;

import org.openstack4j.common.RestService;
import org.openstack4j.model.gnocchi.Eq;
import org.openstack4j.openstack.gnocchi.domain.GnocchiInstResource;

public interface InstanceResourceService extends RestService {
    List<? extends GnocchiInstResource> list();

    GnocchiInstResource getDetail(Eq condtion);
}
