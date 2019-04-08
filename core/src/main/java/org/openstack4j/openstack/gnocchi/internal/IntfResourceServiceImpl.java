package org.openstack4j.openstack.gnocchi.internal;

import java.util.Date;
import java.util.List;

import org.openstack4j.api.gnocchi.InterfaceResourceService;
import org.openstack4j.model.gnocchi.Eq;
import org.openstack4j.openstack.gnocchi.domain.GnocchiIntfResource;
import org.openstack4j.openstack.internal.Parser;

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
    public List<? extends GnocchiIntfResource> getByInstId(Eq condtion) {
        checkNotNull(condtion.getEq().getInstanceId());
        GnocchiIntfResource[] resources = post(GnocchiIntfResource[].class, uri("/search/resource/instance_network_interface"))
                .entity(condtion).execute();
        return wrapList(resources);
    }

    @Override
    public List<? extends GnocchiIntfResource> getDetail(Eq condtion) {
        checkNotNull(condtion.getEq().getId());
        GnocchiIntfResource[] resources = post(GnocchiIntfResource[].class, uri("/search/resource/instance_network_interface"))
                .entity(condtion).execute();
        return wrapList(resources);
    }

    @Override
    public List<? extends GnocchiIntfResource> getIntfInBytes(String intfId, Date value) {
        checkNotNull(intfId);
        GnocchiIntfResource[] resources;

        if (value != null) {
            resources = put(GnocchiIntfResource[].class, uri("/metric/%s/measures?start=%s", intfId, Parser.toISO8601DateFormat(value))).execute();
        } else {
            resources = put(GnocchiIntfResource[].class, uri("/metric/%s/measures", intfId)).execute();
        }

        return wrapList(resources);
    }
}
