package org.openstack4j.openstack.gnocchi.internal;

import java.util.List;

import org.openstack4j.api.gnocchi.InstanceResourceService;
import org.openstack4j.model.gnocchi.SearchCondition;
import org.openstack4j.openstack.gnocchi.domain.GnocchiInstResource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Provides Measurements for Gnocchi instance resources within an OpenStack deployment
 *
 * @author Jerry
 */
public class InstResourceServiceImpl extends BaseGnocchiServices implements InstanceResourceService {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends GnocchiInstResource> list() {
        GnocchiInstResource[] resources = get(GnocchiInstResource[].class, uri("/resource/instance")).execute();
        return wrapList(resources);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends GnocchiInstResource> getDetail(SearchCondition condition) {
        checkNotNull(condition.getEq().getId());
        GnocchiInstResource[] resources = post(GnocchiInstResource[].class, uri("/search/resource/instance")).entity(condition).execute();
        return wrapList(resources);
    }
}
