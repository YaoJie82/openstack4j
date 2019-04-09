package org.openstack4j.api.gnocchi;

import java.util.Date;
import java.util.List;

import org.openstack4j.common.RestService;
import org.openstack4j.model.gnocchi.SearchCondition;
import org.openstack4j.openstack.gnocchi.domain.GnocchiIntfResource;

/**
 * Gnocchi allows collection of Intf and Measurements.
 *
 * @author Jerry
 */
public interface InterfaceResourceService extends RestService {

    /**
     * Access to Intf (Measurements) API
     *
     * @return the list GnocchiIntfResource
     */
    List<? extends GnocchiIntfResource> list();

    /**
     * Access to resource API
     *
     * @return the Intf Resource
     */
    List<? extends GnocchiIntfResource> getByInstId(SearchCondition condition);

    List<? extends GnocchiIntfResource> getDetail(SearchCondition condition);

    List<? extends GnocchiIntfResource> getIntfInBytes(String intfId, Date value);
}