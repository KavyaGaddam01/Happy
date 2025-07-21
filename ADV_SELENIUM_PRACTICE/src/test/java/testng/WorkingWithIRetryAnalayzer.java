package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWithIRetryAnalayzer {

	@Test
	public void test() {
		
		if("hdfc".equals("hfdc"))
		 System.out.println("pass");
		else
		System.out.println("Fail");
		

	}
}














//System.out.println("test");
//SoftAssert soft=new SoftAssert();
//soft.assertEquals("hdfc", "hfdc");
//
//System.out.println("asdfghjkl;");
//soft.assertAll();