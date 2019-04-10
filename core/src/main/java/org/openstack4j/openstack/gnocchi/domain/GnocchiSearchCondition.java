package org.openstack4j.openstack.gnocchi.domain;

import org.openstack4j.model.gnocchi.SearchCondition;
import org.openstack4j.model.gnocchi.builder.SearchConditionBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GnocchiSearchCondition implements SearchCondition {
    @JsonProperty("id")
    private String id;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("instance_id")
    private String instanceId;

    @JsonProperty("eq")
    private SearchCondition eq;

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

    @Override
    public SearchCondition getEq() {
        return eq;
    }

    public void setEq(GnocchiSearchCondition eq) {
        this.eq = eq;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues().add("id", id)
                .add("display_name", displayName).add("instance_id", instanceId).toString();
    }

    public static SearchConditionBuilder builder() {
        return new GnocchiSearchConditionBuilder();
    }

    @Override
    public SearchConditionBuilder toBuilder() {
        return new GnocchiSearchConditionBuilder(this);
    }

    public static class GnocchiSearchConditionBuilder implements SearchConditionBuilder {

        private GnocchiSearchCondition model;

        GnocchiSearchConditionBuilder() {
            this(new GnocchiSearchCondition());
        }

        GnocchiSearchConditionBuilder(GnocchiSearchCondition model) {
            this.model = model;
        }

        public SearchConditionBuilder name() {
            return this;
        }

        @Override
        public GnocchiSearchCondition build() {
            return model;
        }

        @Override
        public SearchConditionBuilder from(SearchCondition in) {
            model = (GnocchiSearchCondition) in;
            return this;
        }

        @Override
        public SearchConditionBuilder id(String id) {
            model.id = id;
            return this;
        }

        @Override
        public SearchConditionBuilder displayName(String displayName) {
            model.displayName = displayName;
            return this;
        }

        @Override
        public SearchConditionBuilder instanceId(String instId) {
            model.instanceId = instId;
            return this;
        }

        @Override
        public SearchConditionBuilder searchCondition(SearchCondition eq) {
            model.eq = eq;
            return this;
        }
    }
}
