package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWithAssertions {

	
	@Test
	public void test() {
		
		//Assert.assertNotEquals("hdfc","hfdc");
	    
    	SoftAssert soft = new SoftAssert();
//		soft.assertEquals("hdfc",true);
    	soft.assertTrue(true);
		System.out.println("next line");
		soft.assertAll();

	}
}
