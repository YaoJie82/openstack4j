package org.openstack4j.api.gnocchi;

import org.openstack4j.api.AbstractTest;
import org.openstack4j.api.Builders;
import org.openstack4j.model.gnocchi.MeasureSearchInput;
import org.openstack4j.model.gnocchi.SearchCondition;
import org.openstack4j.openstack.gnocchi.domain.MeasureMetric;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@Test(suiteName = "Gnocchi")
public class MeasurMetricTest extends AbstractTest {
    private static final String JSON_INSTACNCES = "/gnocchi/measure.json";

    /**
     * list all gnocchi instance metrics id
     *
     * @throws Exception
     */
    @Test
    public void gnocchiMeasureMetricGetTest() throws Exception {
        respondWith(JSON_INSTACNCES);

        SearchCondition condition = Builders.gnocchi().searchCondition(Builders.gnocchi()
                .instanceId("29e2e84f-7a4b-45ff-bd8f-e554fe593e1e").build()).build();

        MeasureMetric measureMetric = osv3().gnocchi().measureMetric().getMetric(condition,
                "-30 minutes", MeasureSearchInput.IntfMetricType.IN_BYTE_RATE,
                MeasureSearchInput.ResouceType.INSTANCE_NETWORK_INTERFACE);

        assertFalse(measureMetric.getMeasures().getAggregated().isEmpty());
        assertEquals(4, measureMetric.getMeasures().getAggregated().size());
        assertEquals(measureMetric.getMeasures().getAggregated().get(0).get(0), "2019-04-10T11:30:00+00:00");
        assertEquals(measureMetric.getMeasures().getAggregated().get(3).get(2), "10");
    }

    @Override
    protected Service service() {
        return Service.GNOCCHI;
    }
}
