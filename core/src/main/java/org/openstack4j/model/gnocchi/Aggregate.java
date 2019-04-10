package org.openstack4j.model.gnocchi;

import java.util.List;

import org.openstack4j.model.ModelEntity;

public interface Aggregate extends ModelEntity {
    List<List<String>> getAggregated();
}
