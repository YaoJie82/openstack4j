package org.openstack4j.openstack.gnocchi.domain;

import java.util.Map;


import org.openstack4j.model.gnocchi.InterfaceResource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * A single measurement for interface sample.
 *
 * @author Jerry
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GnocchiIntfResource implements InterfaceResource {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("project_id")
    private String projectId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("instance_id")
    private String instanceId;

    @JsonProperty("metrics")
    private Map<String, Object> metrics;

    @JsonProperty("started_at")
    private String startedAt;

    @JsonProperty("ended_at")
    private String endedAt;

    @Override
    public String getUserId(){
        return this.userId;
    }

    @Override
    public String getProjectId(){
        return this.projectId;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public Map<String, Object> getMetrics(){
        return this.metrics;
    }

    @Override
    public String getEndedAt(){
        return this.endedAt;
    }

    @Override
    public String getStartedAt(){
        return this.startedAt;
    }

    @Override
    public String getId(){
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("Id", id).add("userId", userId)
                .add("projectId", projectId).add("name", name)
                .add("startedAt", startedAt).add("endedAt", endedAt).toString();
    }
}
