package org.openstack4j.model.appcontainer.builder;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.appcontainer.Appcontainer;
import org.openstack4j.model.appcontainer.RestartPolicy;

import java.util.List;

public interface AppcontainerBuilder extends Buildable.Builder<AppcontainerBuilder, Appcontainer> {
    AppcontainerBuilder name(String name);
//
//    AppcontainerBuilder id(String id);
//
    AppcontainerBuilder image(String image);
//
//    AppcontainerBuilder labels(List<String> labels);
//
//    AppcontainerBuilder cmd(String cmd);
//
//    AppcontainerBuilder workdir(String dir);
//
//    AppcontainerBuilder hostname(String hostName);
//
//    AppcontainerBuilder cpu(Integer cpuCount);
//
//    AppcontainerBuilder memory(Integer memorySize);
//
//    AppcontainerBuilder interactive(boolean interactive);
//
//    AppcontainerBuilder autoremove(boolean autoremove);
//
//    AppcontainerBuilder ports(List<Integer> ports);
//
//    AppcontainerBuilder restartPolicy(RestartPolicy policy);
//
//    AppcontainerBuilder nets();

    //environment, image_pull_policy
}
