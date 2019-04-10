package org.openstack4j.openstack.gnocchi.domain;

import org.openstack4j.model.gnocchi.MeasureSearchInput;
import org.openstack4j.model.gnocchi.SearchCondition;
import org.openstack4j.model.gnocchi.builder.MeasureSearchBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * A single measurement for instance resource.
 *
 * @author Jerry
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetricMeasureSearch implements MeasureSearchInput {
    private static final long serialVersionUID = 1L;

    private String operations;
    @JsonProperty("resource_type")
    private String resourceType;

    private SearchCondition search;

    @Override
    public String getOperations() {
        return operations;
    }

    @Override
    public String getResourceType() {
        return resourceType;
    }

    @Override
    public SearchCondition getSearch() {
        return search;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("operations", operations).add("resourceType", resourceType).toString();
    }

    public static MetricMeasureSearchBuilder builder() {
        return new MetricMeasureSearchBuilder();
    }

    @Override
    public MetricMeasureSearchBuilder toBuilder() {
        return new MetricMeasureSearchBuilder(this);
    }

    public static class MetricMeasureSearchBuilder implements MeasureSearchBuilder {
        private MetricMeasureSearch model;

        MetricMeasureSearchBuilder() {
            this(new MetricMeasureSearch());
        }

        MetricMeasureSearchBuilder(MetricMeasureSearch model) {
            this.model = model;
        }


        @Override
        public MeasureSearchBuilder operations(String operations) {
            model.operations = operations;
            return this;
        }

        @Override
        public MeasureSearchBuilder resourceType(ResouceType resouceType) {
            model.resourceType = resouceType.value();
            return this;
        }

        @Override
        public MeasureSearchBuilder search(SearchCondition searchCondition) {
            model.search = searchCondition;
            return this;
        }

        @Override
        public MeasureSearchInput build() {
            return model;
        }

        @Override
        public MeasureSearchBuilder from(MeasureSearchInput in) {
            model = (MetricMeasureSearch)in;
            return this;
        }
    }
}
