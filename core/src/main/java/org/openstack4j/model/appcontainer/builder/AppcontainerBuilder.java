package org.openstack4j.model.appcontainer.builder;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.appcontainer.Appcontainer;
import org.openstack4j.model.appcontainer.RestartPolicy;

import java.util.List;
import java.util.Map;

public interface AppcontainerBuilder extends Buildable.Builder<AppcontainerBuilder, Appcontainer> {
    AppcontainerBuilder name(String name);

    AppcontainerBuilder image(String image);

    AppcontainerBuilder imageDriver(String imageDriver);

    AppcontainerBuilder cmd(String cmd);

    AppcontainerBuilder workDir(String dir);

    AppcontainerBuilder hostname(String hostName);

//    AppcontainerBuilder imagePullPolicy(String policy);

    AppcontainerBuilder cpu(Float cpuCount);

    AppcontainerBuilder memory(String memorySize);

    AppcontainerBuilder interactive(boolean interactive);

    AppcontainerBuilder autoRemove(boolean autoRemove);

    AppcontainerBuilder securityGroups(List<String> groups);

    AppcontainerBuilder environment(Map<String, String> envs);

    AppcontainerBuilder labels(Map<String, String> labels);

    AppcontainerBuilder network(String net);

//    AppcontainerBuilder port(String port);  //need kuryr first

//    AppcontainerBuilder restartPolicy(RestartPolicy policy);
}
