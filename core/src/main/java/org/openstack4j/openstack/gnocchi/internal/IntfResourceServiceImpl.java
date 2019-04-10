package org.openstack4j.openstack.gnocchi.internal;

import java.util.List;

import org.openstack4j.api.gnocchi.InterfaceResourceService;
import org.openstack4j.model.gnocchi.SearchCondition;
import org.openstack4j.openstack.gnocchi.domain.GnocchiIntfResource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Provides Measurements for Gnocchi instance resources within an OpenStack deployment
 *
 * @author Jerry
 */
public class IntfResourceServiceImpl extends BaseGnocchiServices implements InterfaceResourceService {
    @Override
    public List<? extends GnocchiIntfResource> list() {
        GnocchiIntfResource[] resources = get(GnocchiIntfResource[].class, uri("/resource/instance_network_interface")).execute();
        return wrapList(resources);
    }

    @Override
    public List<? extends GnocchiIntfResource> getByInstId(SearchCondition condition) {
        checkNotNull(condition.getEq().getInstanceId());
        GnocchiIntfResource[] resources = post(GnocchiIntfResource[].class, uri("/search/resource/instance_network_interface"))
                .entity(condition).execute();
        return wrapList(resources);
    }

    @Override
    public GnocchiIntfResource getDetail(String interfaceId) {
        checkNotNull(interfaceId);
        GnocchiIntfResource resource = get(GnocchiIntfResource.class, uri("/resource/instance_network_interface/%s", interfaceId)).execute();
        return resource;
    }
}
