package org.openstack4j.model.gnocchi;

import java.util.Map;

import org.openstack4j.model.ModelEntity;

public interface InstanceResource extends ModelEntity {
    String getId();

    String getUserId();

    String getProjectId();

    String getDisplayName();

    String getFlavorName();

    Map<String, Object> getMetrics();

    String getHost();

    String getStartedAt();

    String getEndedAt();

    String getServerGroup();
}
