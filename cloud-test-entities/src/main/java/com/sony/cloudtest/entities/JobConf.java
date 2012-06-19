package com.sony.cloudtest.entities;

import com.sony.cloudtest.entities.annotation.NotNull;
import com.sony.cloudtest.entities.annotation.StringPattern;

/**
 * Job Configuration entry
 *
 * @author 28851470
 *
 */
public class JobConf extends BaseJobConf{

    /**
     * software project used for build, e.g. nozomi
     */
    @NotNull
    @StringPattern("\\S+")
    String softwareProject;

    /**
     * software labels like 6.0.B.2.123
     */
    @NotNull
    @StringPattern("\\S+")
    String softwareVersion;

    /**
     * Optional, branch is needed if softwareVersion is lastSuccessfulBuild.
     * e.g. ics-mogomi
     */
    String branch;

    /**
     * CDF file path in SMB format.
     * e.g.\\corpusers.net\cnbj\CDA\LT29i\Generic_GLOBAL\Generic\1261-7933_R4F_Generic_GGL_Released.zip
     */
    @NotNull
    @StringPattern("\\S+")
    String cdfPath;

    public JobConf() {
    }

    
    public String getSoftwareProject() {
        return softwareProject;
    }

    public void setSoftwareProject(String softwareProject) {
        this.softwareProject = softwareProject;
    }


    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCdfPath() {
        return cdfPath;
    }

    public void setCdfPath(String cdfPath) {
        this.cdfPath = cdfPath;
    }

}
