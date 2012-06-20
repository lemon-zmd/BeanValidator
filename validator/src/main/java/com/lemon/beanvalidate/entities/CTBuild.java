package com.sony.cloudtest.entities;
/**
 *{"displayName":"#33","status":"Success","buildNumber":33,"durationString":"2 min 0 sec",
 *"jobName":"testTemplate","timeSince":"2012-05-31T05:43:06Z","jobStatusDes":"stable"}
 * @author 28851451
 *
 */
public class CTBuild {

    String jobName;

    Integer buildNumber;

    String timeSince; //trigger time in string format

    String DurationString; //build running time

    String DisplayName; // build display name, normally it is "#"buildNumber

    String status; // build result in string

    String jobStatusDes; // job status up until now, e.g.back to normal/stable/aborted

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(Integer buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getTimeSince() {
        return timeSince;
    }

    public void setTimeSince(String timeSince) {
        this.timeSince = timeSince;
    }

    public String getDurationString() {
        return DurationString;
    }

    public void setDurationString(String durationString) {
        DurationString = durationString;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobStatusDes() {
        return jobStatusDes;
    }

    public void setJobStatusDes(String jobStatusDes) {
        this.jobStatusDes = jobStatusDes;
    }

    public CTBuild() {
    }


}
