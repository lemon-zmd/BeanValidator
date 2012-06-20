package com.sony.cloudtest.entities;

import java.util.Map;

/**
 * Prototype Software Project. (optional) SW version (optional) Branch. (
 * optional, needed if SW version is lastsuccessfulbuild) CDF path (optional)
 * Private build file path (optional) Test type, e.g. HSSS Specific parameters,
 * e.g. Test suite, test count
 *
 * @author 28851451
 *
 */
public class PrivateBuildJobConf extends BaseJobConf {

    String[] privateBuildFilePath;


    public PrivateBuildJobConf() {
    }

    public String[] getPrivateBuildFilePath() {
        return privateBuildFilePath;
    }

    public void setPrivateBuildFilePath(String[] privateBuildFilePath) {
        this.privateBuildFilePath = privateBuildFilePath;
    }

}
