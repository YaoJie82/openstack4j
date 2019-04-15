package org.openstack4j.model.appcontainer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openstack4j.common.Buildable;
import org.openstack4j.model.appcontainer.builder.AppcontainerBuilder;
import org.openstack4j.model.common.BasicResource;
import org.openstack4j.openstack.appcontainer.domain.ZunAppcontainer;

import java.util.List;
import java.util.Map;


public interface Appcontainer extends BasicResource, Buildable<AppcontainerBuilder> {

    //    public enum AppcontainerStatus{
//        UNRECOGNIZED,
//        Creating,
//        Created,
//        Stopping,
//        Stopped,
//        Starting,
//        Running;
//
//        @JsonCreator
//        public static AppcontainerStatus value(String v)
//        {
//            if (v == null) return UNRECOGNIZED;
//            try {
//                return valueOf(v.toUpperCase());
//            } catch (IllegalArgumentException e) {
//                return UNRECOGNIZED;
//            }
//        }
//
//        @JsonValue
//        public String value() {
//            return name().toLowerCase();
//        }
//    }
//
//
    Status getStatus();

    String getName();

    String getImage();

    String getImageDriver();

    String getCmd();

    String getWorkDir();

    String getHostName();

    String getImagePullPolicy();

    Float getCpu();

    String getMemory();

    //    boolean isRun();
    boolean isInteractive();

    boolean isAutoRemove();

    Map<String, String> getLabels();

    List<String> getSecurityGroups();

    Map<String, String> getEnvironment();

    List<Integer> getPorts();

    Map<String, List<ZunAppcontainer.AppSubnet>> getAddresses();

//    RestartPolicy getRestartPolicy();
//    AppcontainerStatus getStatus();
}
