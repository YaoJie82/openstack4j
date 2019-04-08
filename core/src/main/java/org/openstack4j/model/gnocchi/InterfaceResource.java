package org.openstack4j.model.gnocchi;

import java.util.Map;

import org.openstack4j.model.ModelEntity;

public interface InterfaceResource extends ModelEntity {
    String getId();

    String getUserId();

    String getProjectId();

    String getName();

    Map<String, Object> getMetrics();

    String getEndedAt();

    String getStartedAt();
}
