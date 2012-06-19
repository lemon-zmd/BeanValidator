package com.sony.cloudtest.entities;

import java.util.Map;

import com.sony.cloudtest.entities.annotation.NotNull;
import com.sony.cloudtest.entities.annotation.StringPattern;

/**
 * Prototype Software Project. (optional) SW version (optional) Branch. (
 * optional, needed if SW version is lastsuccessfulbuild) CDF path (optional)
 * Private build file path (optional) Test type, e.g. HSSS Specific parameters,
 * e.g. Test suite, test count
 *
 * @author 28851451
 *
 */
public class BaseJobConf {
    // prototype name, like Nozome
    @NotNull
    @StringPattern("\\S+")
    String prototype;

    /**
     * Template job name in cloud test. API is provided to get all of the test types in cloud test.
     * Also you can add your self test type.
     * e.g. HSSS_template
     */
    
    String testType;

    /**
     * Only used for nightly job. The finally nightly job name would be like Nightly_testTemplate_${jobname}
     */
    String jobName;

    /**
     * Nightly job running period in linux cron time format.
     */
    String cronTime;

    /**
     * Parameters for specific test type.
     * e.g. for Monkey_template, there are parameters like SEED_INTERVAL=1-100 WHITE_LIST_FILE=whitelist.txt etc.
     */
    Map<String, String> params;

    /**
     * Name of the slave this project was built on.
     * Null or "" if built by the master. (null happens when we read old record that didn't have this information.)
     */
    private String builtOn;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCronTime() {
        return cronTime;
    }

    public void setCronTime(String cronTime) {
        this.cronTime = cronTime;
    }

    public BaseJobConf() {
    }

    public String getPrototype() {
        return prototype;
    }

    public void setPrototype(String prototype) {
        this.prototype = prototype;
    }
    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getBuiltOn() {
        return builtOn;
    }

    public void setBuiltOn(String builtOn) {
        this.builtOn = builtOn;
    }
}
