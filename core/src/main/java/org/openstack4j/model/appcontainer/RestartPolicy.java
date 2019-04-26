package org.openstack4j.model.appcontainer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RestartPolicy {
    NO,
    ALWAYS,
    ON_FAILURE,
    UNLESS_STOPPED,
    UNRECOGNIZED;

    @JsonValue
    public String value() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static RestartPolicy value(String rp) {
        if (rp == null || rp.isEmpty()) return UNRECOGNIZED;
        try
        {
            return valueOf(rp.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            return UNRECOGNIZED;
        }
    }
}
