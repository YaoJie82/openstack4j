package org.openstack4j.openstack.gnocchi.domain;

import org.openstack4j.model.gnocchi.Eq;
import org.openstack4j.model.gnocchi.builder.CondtionBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Condtion implements Eq {
    @JsonProperty("id")
    private String id;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("instance_id")
    private String instanceId;

    @JsonProperty("eq")
    private Condtion eq;


    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getInstanceId() {
        return instanceId;
    }

    public void setDisplayName(String display_name) {
        this.displayName = display_name;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    public Condtion getEq() {
        return eq;
    }

    public void setEq(Condtion eq) {
        this.eq = eq;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues().add("id", id)
                .add("display_name", displayName).add("instance_id", instanceId).toString();
    }

    public static CondtionBuilder builder() {
        return new CondtionSearchBuilder();
    }

    @Override
    public CondtionBuilder toBuilder() {
        return new CondtionSearchBuilder(this);
    }

    public static class CondtionSearchBuilder implements CondtionBuilder {

        private Condtion model;

        CondtionSearchBuilder() {
            this(new Condtion());
        }

        CondtionSearchBuilder(Condtion model) {
            this.model = model;
        }

        public CondtionBuilder name() {
            return this;
        }

        @Override
        public Condtion build() {
            return model;
        }

        @Override
        public CondtionBuilder from(Condtion in) {
            model = (Condtion) in;
            return this;
        }
    }
}
