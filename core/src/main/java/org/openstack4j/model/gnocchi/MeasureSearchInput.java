package org.openstack4j.model.gnocchi;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.gnocchi.builder.MeasureSearchBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public interface MeasureSearchInput extends ModelEntity, Buildable<MeasureSearchBuilder> {
    String getOperations();

    String getResourceType();

    SearchCondition getSearch();

    /**
     * Measure contain a resource attribute that can be used as an indication of the current measure.
     */
    enum ResouceType {
        /**
         * The SWITCH_PORT
         */
        SWITCH_PORT,
        /**
         * The VOLUME_PROVIDER_POOL
         */
        VOLUME_PROVIDER_POOL,
        IMAGE,
        HOST_DISK,
        PORT,
        NETWORK,
        GENERIC,
        VOLUME_PROVIDER,
        INSTANCE,
        CEPH_ACCOUNT,
        HOST_NETWORK_INTERFACE,
        IPMI,
        SWIFT_ACCOUNT,
        SWITCH_TABLE,
        VOLUME,
        HOST,
        NOVA_COMPUTE,
        STACK,
        IDENTITY,
        /**
         * The interface
         */
        INSTANCE_NETWORK_INTERFACE,
        MANILA_SHARE,
        SWITCH,
        INSTANCE_DISK,
        UNRECOGNIZED;

        @JsonCreator
        public static ResouceType forValue(String value) {
            if (value != null) {
                for (ResouceType s : ResouceType.values()) {
                    if (s.name().equalsIgnoreCase(value)) {
                        return s;
                    }
                }
            }
            return ResouceType.UNRECOGNIZED;
        }

        @JsonValue
        public String value() {
            return name().toLowerCase();
        }
    }


    enum IntfMetricType {
        /**
         * network metric info
         */
        OUT_PACKET("network.outgoing.packets"),
        OUT_PACKET_RATE("network.outgoing.packets.rate"),
        OUT_PACKET_DROP("network.outgoing.packets.drop"),
        OUT_PACKET_ERROR("network.outgoing.packets.error"),
        OUT_BYTE("network.outgoing.bytes"),
        OUT_BYTE_RATE("network.outgoing.bytes.rate"),
        IN_PACKET("network.incoming.packets"),
        IN_PACKET_RATE("network.incoming.packets.rate"),
        IN_PACKET_DROP("network.incoming.packets.drop"),
        IN_PACKET_ERROR("network.incoming.packets.error"),
        IN_BYTE("network.incoming.bytes"),
        IN_BYTE_RATE("network.incoming.bytes.rate"),
        UNKNOWN("NA");

        private final String serviceName;

        IntfMetricType(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getServiceName() {
            return this.serviceName;
        }

        public static IntfMetricType forName(String name) {
            if (name == null || name.isEmpty()) {
                return IntfMetricType.UNKNOWN;
            }
            for (IntfMetricType s : IntfMetricType.values()) {
                if (s.name().equalsIgnoreCase(name)) {
                    return s;
                }
            }
            return IntfMetricType.UNKNOWN;
        }


        @JsonCreator
        public static IntfMetricType forValue(String value) {
            if (value != null) {
                for (IntfMetricType s : IntfMetricType.values()) {
                    if (s.name().equalsIgnoreCase(value)) {
                        return s;
                    }
                }
            }
            return IntfMetricType.UNKNOWN;
        }

        @JsonValue
        public String value() {
            return name().toLowerCase();
        }
    }

}
