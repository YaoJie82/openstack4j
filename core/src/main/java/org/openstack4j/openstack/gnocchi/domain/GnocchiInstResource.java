package org.openstack4j.openstack.gnocchi.domain;

import java.util.Map;

import org.openstack4j.model.gnocchi.InstanceResource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * A single measurement for instance resource.
 *
 * @author Jerry
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GnocchiInstResource implements InstanceResource {
    private static final long serialVersionUID = 1L;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("project_id")
    private String projectId;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("flavor_name")
    private String flavorName;

    @JsonProperty("metrics")
    private Map<String, Object> metrics;

    @JsonProperty("host")
    private String host;

    @JsonProperty("server_group")
    private String serverGroup;

    @JsonProperty("started_at")
    private String startedAt;

    @JsonProperty("ended_at")
    private String endedAt;

    @JsonProperty("id")
    private String id;

    public String getUserId() {
        return this.userId;
    }


    public String getProjectId() {
        return this.projectId;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public String getFlavorName() {
        return this.flavorName;
    }

    @Override
    public Map<String, Object> getMetrics() {
        return this.metrics;
    }

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public String getEndedAt() {
        return this.endedAt;
    }

    @Override
    public String getServerGroup() {
        return this.serverGroup;
    }

    @Override
    public String getStartedAt() {
        return this.startedAt;
    }

    @Override
    public String getId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("Id", id).add("userId", userId)
                .add("projectId", projectId).add("instanceName", displayName)
                .add("startedAt", startedAt).add("endedAt", endedAt).toString();
    }

}
