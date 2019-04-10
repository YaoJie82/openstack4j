package org.openstack4j.api.gnocchi;

import org.openstack4j.common.RestService;
import org.openstack4j.model.gnocchi.MeasureSearchInput;
import org.openstack4j.model.gnocchi.SearchCondition;
import org.openstack4j.openstack.gnocchi.domain.MeasureMetric;

public interface AggregateService extends RestService {
    MeasureMetric getMetric(SearchCondition condition, String timestamps,
                            MeasureSearchInput.IntfMetricType metricType,
                            MeasureSearchInput.ResouceType resourceType);
}
