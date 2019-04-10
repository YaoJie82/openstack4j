package org.openstack4j.openstack.gnocchi.internal;

import org.openstack4j.api.gnocchi.AggregateService;
import org.openstack4j.model.gnocchi.MeasureSearchInput;
import org.openstack4j.model.gnocchi.SearchCondition;
import org.openstack4j.openstack.gnocchi.domain.MeasureMetric;
import org.openstack4j.openstack.gnocchi.domain.MetricMeasureSearch;

import static com.google.common.base.Preconditions.checkNotNull;

public class AggregateServiceImpl extends BaseGnocchiServices implements AggregateService {
    @Override
    public MeasureMetric getMetric(SearchCondition condition, String timestamps,
                                   MeasureSearchInput.IntfMetricType metricType,
                                   MeasureSearchInput.ResouceType resourceType) {
        checkNotNull(condition.getEq().getInstanceId());

        MeasureSearchInput mertic = MetricMeasureSearch.builder()
                .operations(uri("(* (aggregate mean (metric %s " +
                        "mean)) 4)", metricType.getServiceName()))
                .resourceType(resourceType).search(condition).build();

        MeasureMetric resources = post(MeasureMetric.class, uri("aggregates?start=-%s", timestamps))
                .entity(mertic).execute();
        return resources;
    }
}
