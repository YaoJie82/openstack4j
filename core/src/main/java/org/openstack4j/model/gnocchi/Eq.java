package org.openstack4j.model.gnocchi;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.gnocchi.builder.CondtionBuilder;
import org.openstack4j.openstack.gnocchi.domain.Condtion;

public interface Eq extends ModelEntity, Buildable<CondtionBuilder> {
    void setId(String id);

    String getId();

    String getDisplayName();

    String getInstanceId();

    Condtion getEq();
}
