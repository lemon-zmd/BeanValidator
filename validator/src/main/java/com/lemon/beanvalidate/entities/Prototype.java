package com.sony.cloudtest.entities;

import com.sony.cloudtest.entities.annotation.NotNull;
import com.sony.cloudtest.entities.annotation.StringPattern;

public class Prototype {
    @NotNull
    @StringPattern("\\S+")
    private String deviceId;
    @NotNull
    private String prototype;
    @NotNull
    private Status status;
    @NotNull
    private String host;

    public Prototype() {}
    public Prototype(String id, String pro, String sta, String host) {
        this.deviceId = id;
        this.prototype = pro;
        this.status = Status.valueOf(sta);
        this.host = host;
    }

    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPrototype() {
        return prototype;
    }
    public void setPrototype(String prototype) {
        this.prototype = prototype;
    }
 
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
   
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }

}
