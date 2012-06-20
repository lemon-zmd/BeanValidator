package lemon.tool;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lemon.tool.validation.entities.Foo;
import lemon.tool.validation.exception.CTDataValidationException;
import lemon.tool.validation.util.ValidatorUtil;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        Foo f = new Foo();
        f.setDoo("d");
        try {
			ValidatorUtil.validate(f);
		} catch (CTDataValidationException e) {
			e.printStackTrace();
		}
    }
}
