package org.openstack4j.model.gnocchi;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.gnocchi.builder.SearchConditionBuilder;

public interface SearchCondition extends ModelEntity, Buildable<SearchConditionBuilder> {
    void setId(String id);

    String getId();

    String getDisplayName();

    String getInstanceId();

    SearchCondition getEq();
}
