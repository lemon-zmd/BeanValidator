package com.sony.cloudtest.entities;

/**
 * the slave information.
 * @author 28851451
 *
 */
public class SlaveInfo {
    /**
     * the display name of the slave.
     */
    private String displayName;
    /**
     * the label string of the slave.
     */
    private String labelString;
    /**
     * the description of this slave.
     */
    private String nodeDescription;
    /**
     * the number of executors on this slave.
     */
    private int numExecutors;
    /**
     * the number of busy executors on this slave.
     */
    private int numBusy;
    /**
     * whether the slave is online or not.
     */
    private boolean online;

    public SlaveInfo(String displayNm, String labelStr, String nodeDesc, int numExe, int numBz, boolean oL) {
        displayName = displayNm;
        labelString = labelStr;
        nodeDescription = nodeDesc;
        numExecutors = numExe;
        numBusy = numBz;
        online = oL;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLabelString() {
        return labelString;
    }

    public void setLabelString(String labelString) {
        this.labelString = labelString;
    }

    public String getNodeDescription() {
        return nodeDescription;
    }

    public void setNodeDescription(String nodeDescription) {
        this.nodeDescription = nodeDescription;
    }

    public int getNumExecutors() {
        return numExecutors;
    }

    public void setNumExecutors(int numExecutors) {
        this.numExecutors = numExecutors;
    }

    public int getNumBusy() {
        return numBusy;
    }

    public void setNumBusy(int numBusy) {
        this.numBusy = numBusy;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
