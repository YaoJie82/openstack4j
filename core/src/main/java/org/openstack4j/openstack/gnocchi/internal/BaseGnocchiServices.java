package org.openstack4j.openstack.gnocchi.internal;

import java.util.Collections;
import java.util.List;

import org.openstack4j.api.types.ServiceType;
import org.openstack4j.openstack.internal.BaseOpenStackService;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * Base class for Gnocchi services
 *
 * @author Jerry
 */
public class BaseGnocchiServices extends BaseOpenStackService {

    protected BaseGnocchiServices() {
        super(ServiceType.GNOCCHI, EndpointFunction.instance);
    }

    /**
     * Sometimes the endpoint does not contain the API version which is required.  This insures that
     */
    private static class EndpointFunction implements Function<String, String> {

        static final EndpointFunction instance = new EndpointFunction();

        @Override
        public String apply(String input) {
            if (input == null || input.contains("/v"))
                return input;
            return input.concat(input.endsWith("/") ? "v1" : "/v1");
        }
    }

    protected <T> List<T> wrapList(T[] type) {
        if (type != null)
            return Lists.newArrayList(type);
        return Collections.emptyList();

    }
}
