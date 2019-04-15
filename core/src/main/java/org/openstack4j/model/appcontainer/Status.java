package org.openstack4j.model.appcontainer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    CREATED,
    RUNNING,
    STOPPED,
    ERROR,
    UNRECOGNIZED;


    @JsonCreator
    public static Status forValue(String value) {
        if (value != null)
        {
            for (Status s : Status.values()) {
                if (s.name().equalsIgnoreCase(value))
                    return s;
            }
        }
        return Status.UNRECOGNIZED;
    }

    @JsonValue
    public String value() {
        return name().toLowerCase();
    }
}
