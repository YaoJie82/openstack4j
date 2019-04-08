package org.openstack4j.openstack.gnocchi.internal;

import org.openstack4j.api.Apis;
import org.openstack4j.api.gnocchi.GnocchiService;
import org.openstack4j.api.gnocchi.InstanceResourceService;
import org.openstack4j.api.gnocchi.InterfaceResourceService;

/**
 * Provides Measurements against Meters within an OpenStack deployment
 *
 * @author Jerry
 */
public class GnocchiServiceImpl implements GnocchiService {
    @Override
    public InstanceResourceService instances() {
        return Apis.get(InstanceResourceService.class);
    }

    @Override
    public InterfaceResourceService interfaces() {
        return Apis.get(InterfaceResourceService.class);
    }
}
