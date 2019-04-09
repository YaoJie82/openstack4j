package org.openstack4j.model.gnocchi;

import java.util.Map;

import org.openstack4j.model.ModelEntity;

public interface InstanceResource extends ModelEntity {
    /**
     * @return the identifier for the inst
     */
    String getId();

    String getUserId();

    String getProjectId();

    String getDisplayName();

    /**
     * @return the flavor name to boot into
     */
    String getFlavorName();

    Map<String, String> getMetrics();

    String getHost();

    String getStartedAt();

    String getEndedAt();

    String getServerGroup();
}
