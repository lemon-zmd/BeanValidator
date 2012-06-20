package com.sony.cloudtest.entities;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import com.sony.cloudtest.entities.exception.CTDataValidationException;
import com.sony.cloudtest.entities.util.ContentConverter;

public class ValidationTest {

    @Test
    public void testValidatePrototype() {
        Prototype normalPrototype = new Prototype();
        normalPrototype.setDeviceId("a_fake_id");
        normalPrototype.setHost("a_dummy_host");
        normalPrototype.setPrototype("prototype_Nozi");
        normalPrototype.setStatus(Status.IDLE);
        try {
            Assert.assertTrue(ContentConverter.marshal(normalPrototype).indexOf("prototype_Nozi") > 0);
            Assert.assertTrue(ContentConverter.marshal(normalPrototype).indexOf("a_dummy_host") > 0);
            Assert.assertTrue(ContentConverter.marshal(normalPrototype).indexOf("IDLE") > 0);
        } catch (CTDataValidationException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Ignore
    @Test(expected=CTDataValidationException.class)
    public void testValidatePrototypeOutputFail() throws CTDataValidationException {
        Prototype exceptionPrototype = new Prototype();
        exceptionPrototype.setDeviceId("id");
        ContentConverter.marshal(exceptionPrototype);
    }

    @Test(expected=CTDataValidationException.class)
    public void testValidatePrototypeInputFail() throws CTDataValidationException {
        String jsonStr = "{\"host\":\"host\",\"status\":\"IDLE\",\"prototype\":\"prototype\"}";
        ContentConverter.unmarshal(jsonStr, Prototype.class);
    }

    @Test
    public void testValidateJob() {
        JobConf jobCf = new JobConf();
        jobCf.setPrototype("test_prototype");
        jobCf.setSoftwareProject("test_softwareproject");
        jobCf.setSoftwareVersion("softwareversion");
        jobCf.setCdfPath("cdfpath");
        try {
            String marshaledStr = ContentConverter.marshal(jobCf);
            System.out.println(marshaledStr);
            Assert.assertTrue(marshaledStr.indexOf("test_prototype") > 0);
            Assert.assertTrue(marshaledStr.indexOf("test_softwareproject") > 0);
        } catch (CTDataValidationException e) {
            e.printStackTrace();
            fail();
        }
    }
    @Ignore
    @Test(expected=CTDataValidationException.class)
    public void testValidateJobOutputFail() throws CTDataValidationException {
        JobConf jobCf = new JobConf();
        jobCf.setSoftwareVersion("softwareversion");
        jobCf.setCdfPath("cdfpath");
        ContentConverter.marshal(jobCf);
    }

    @Test(expected=CTDataValidationException.class)
    public void testValidateJobInputFail() throws CTDataValidationException {
        String jsonStr = "{\"softwareProject\":\"\",\"softwareVersion\":\"softwareversion\"," +
                "\"branch\":null,\"cdfPath\":\"cdfpath\",\"jobName\":null," +
                "\"cronTime\":null,\"prototype\":\"prototype\",\"testType\":null,\"params\":null,\"builtOn\":null}";
        ContentConverter.unmarshal(jsonStr, JobConf.class);
    }
}
