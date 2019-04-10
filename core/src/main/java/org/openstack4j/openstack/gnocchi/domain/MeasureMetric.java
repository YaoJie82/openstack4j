package org.openstack4j.openstack.gnocchi.domain;

import org.openstack4j.model.gnocchi.Metric;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

/**
 * A single measurement for instance resource.
 *
 * @author Jerry
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeasureMetric implements Metric {
    private static final long serialVersionUID = 1L;

    private Measure measures;


    public Measure getMeasures() {
        return measures;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("aggregated.length", measures.getAggregated().size())
                .toString();
    }
}
