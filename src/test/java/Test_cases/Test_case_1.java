package Test_cases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.Assert;
import org.testng.annotations.Test;

import Test_objects.Test_object;

public class Test_case_1 extends Baseclass {
	
	@Test
	public void StartTest() throws IOException{
		logger.info("put baseurl");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseurl);
		driver.manage().window().maximize();
		
		Test_object testobject = new Test_object(driver);
		logger.info("put username");
		testobject.getUserName(uname);
		logger.info("put password");
		testobject.getUserPassword(upassword);
		testobject.getSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("Login Test is passed");
		}
		else{
			getScreenshot(driver,"StartTest");
			Assert.assertTrue(false);
			logger.info("Login Test is failed");
		}
	}

	
}
