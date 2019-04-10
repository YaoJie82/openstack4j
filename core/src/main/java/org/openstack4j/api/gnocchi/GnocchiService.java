package org.openstack4j.api.gnocchi;

import org.openstack4j.common.RestService;

/**
 * Gnocchi allows collection of Intf and Inst Measurements.
 *
 * @author Jerry
 */
public interface GnocchiService extends RestService {
    /**
     * Access to Inst (Measurements) API
     *
     * @return the Inst Service
     */
    InstanceResourceService instances();

    /**
     * Access to Intf API
     *
     * @return the Intf Service
     */
    InterfaceResourceService interfaces();


    AggregateService measureMetric();
}
