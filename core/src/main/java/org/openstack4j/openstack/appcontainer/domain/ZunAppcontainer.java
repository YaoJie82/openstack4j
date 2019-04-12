package org.openstack4j.openstack.appcontainer.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import org.openstack4j.model.appcontainer.Appcontainer;
import org.openstack4j.model.appcontainer.builder.AppcontainerBuilder;
import org.openstack4j.model.common.builder.BasicResourceBuilder;
import org.openstack4j.openstack.common.ListResult;

import java.util.List;
import java.util.Map;

public class ZunAppcontainer implements Appcontainer {

    private static final long serialVersionUID = 1L;

    @JsonProperty("uuid")
    private String id;

    private String name;

    private String image;

    @JsonProperty("image_driver")
    private String imageDriver;

    @JsonProperty("command")
    private String cmd;

    @JsonProperty("workdir")
    private String workDir;

    @JsonProperty("hostname")
    private String hostName;

    @JsonProperty("image_pull_policy")
    private String imagePullPolicy;

    private Float cpu;

    private String memory;

//    private Boolean run;

    private Boolean interactive;

    @JsonProperty("auto_remove")
    private Boolean autoRemove;

    @JsonProperty("security_groups")
    private List<String> securityGroups;

    private Map<String, String> environment;

    private Map<String, String> labels;

    private List<Integer> ports;

    private Map<String, List<AppSubnet>> addresses;

    public static class AppSubnet{
        public String addr;

        public String port;

        public Boolean preserve_on_delete;

        public String subnet_id;

        public Integer version;

        public String toString(){
            return MoreObjects.toStringHelper(this)
                    .add("addr", addr)
                    .add("port", port)
                    .add("preserve_on_delete", preserve_on_delete)
                    .add("subnet_id", subnet_id)
                    .add("version", version)
                    .toString();
        }
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getImageDriver() {
        return imageDriver;
    }

    @Override
    public String getCmd() {
        return cmd;
    }

    @Override
    public String getWorkDir() {
        return workDir;
    }

    @Override
    public String getHostName() {
        return hostName;
    }

    @Override
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    @Override
    public Float getCpu() {
        return cpu;
    }

    @Override
    public String getMemory() {
        return memory;
    }

//    @Override
//    public boolean isRun() {
//        return false;
//    }

    @Override
    public boolean isInteractive() {
        return interactive;
    }

    @Override
    public boolean isAutoRemove() {
        return autoRemove;
    }

    @Override
    public Map<String, String> getLabels() {
        return labels;
    }

    @Override
    public List<String> getSecurityGroups() {
        return securityGroups;
    }

    @Override
    public Map<String, String> getEnvironment() {
        return environment;
    }

    @Override
    public List<Integer> getPorts() {
        return ports;
    }

    @Override
    public Map<String, List<AppSubnet>> getAddresses() {
        return addresses;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Appcontainers extends ListResult<ZunAppcontainer> {
        private static final long serialVersionUID = 1L;
        @JsonProperty("containers")
        private List<ZunAppcontainer> appcontainers;

        @Override
        protected List<ZunAppcontainer> value() {
            return appcontainers;
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("image", image)
                .add("imageDriver", imageDriver)
//                .add("status", status)
//                .add("labels", labels)
                .add("cmd", cmd)
//                .add("runtime", runtime)
                .add("workdir", workDir)
                .add("hostname", hostName)
                .add("imagePullPolicy", imagePullPolicy)
                .add("cpu", cpu)
                .add("memory", memory)
                .add("interactive", interactive)
                .add("autoremove", autoRemove)
                .add("securityGroups", securityGroups)
                .add("environment", environment)
                .add("label", labels)
                .add("ports", ports)
                .add("addresses", addresses)
//                .add("restartPolicy", restartPolicy)
                .toString();
    }


    public static AppcontainerBuilder builder() {
        return new AppcontainerConcreteBuilder();
    }

    @Override
    public AppcontainerBuilder toBuilder() {
        return new AppcontainerConcreteBuilder(this);
    }

    public static class AppcontainerConcreteBuilder
            extends BasicResourceBuilder<Appcontainer, AppcontainerConcreteBuilder>
            implements AppcontainerBuilder {
        private ZunAppcontainer m;

        AppcontainerConcreteBuilder() {
            this(new ZunAppcontainer());
        }

        AppcontainerConcreteBuilder(ZunAppcontainer m) {
            this.m = m;
        }



        @Override
        public AppcontainerBuilder image(String image) {
            m.image = image;
            return this;
        }

        @Override
        public AppcontainerBuilder imageDriver(String imageDriver) {
            //TODO: HARD CODE
            m.imageDriver = "glance";
            return this;
        }

        @Override
        public AppcontainerBuilder cmd(String cmd) {
            m.cmd = cmd;
            return this;
        }

        @Override
        public AppcontainerBuilder workDir(String dir) {
            m.workDir = dir;
            return this;
        }

        @Override
        public AppcontainerBuilder hostname(String hostName) {
            m.hostName = hostName;
            return this;
        }

        @Override
        public AppcontainerBuilder imagePullPolicy(String policy) {
            m.imagePullPolicy = policy;
            return this;
        }

        @Override
        public AppcontainerBuilder cpu(Float cpuCount) {
            m.cpu = cpuCount;
            return this;
        }

        @Override
        public AppcontainerBuilder memory(String memorySize) {
            m.memory = memorySize;
            return this;
        }

        @Override
        public AppcontainerBuilder interactive(boolean interactive) {
            m.interactive = interactive;
            return this;
        }

        @Override
        public AppcontainerBuilder autoRemove(boolean autoRemove) {
            m.autoRemove = autoRemove;
            return this;
        }

        @Override
        public AppcontainerBuilder securityGroups(List<String> groups) {
            m.securityGroups = groups;
            return this;
        }

        @Override
        public AppcontainerBuilder environment(Map<String, String> envs) {
            m.environment = envs;
            return this;
        }

        @Override
        public AppcontainerBuilder labels(Map<String, String> labels) {
            m.labels = labels;
            return this;
        }

        @Override
        public AppcontainerBuilder ports(List<Integer> ports) {
            m.ports = ports;
            return this;
        }

        //BUILD

        @Override
        public Appcontainer build() {
            return m;
        }

        @Override
        public AppcontainerBuilder from(Appcontainer in) {
            this.m = (ZunAppcontainer)in;
            return this;
        }

        @Override
        protected Appcontainer reference() {
            return m;
        }
    }
}
