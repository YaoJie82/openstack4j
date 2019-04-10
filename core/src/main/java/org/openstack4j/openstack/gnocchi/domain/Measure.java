package org.openstack4j.openstack.gnocchi.domain;

import java.util.List;

import org.openstack4j.model.gnocchi.Aggregate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

/**
 * A single measurement for instance resource.
 *
 * @author Jerry
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Measure implements Aggregate {
    private static final long serialVersionUID = 1L;

    private List<List<String>> aggregated;

    @Override
    public List<List<String>> getAggregated() {
        return aggregated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("aggregated.length", aggregated.size())
                .toString();
    }
}
