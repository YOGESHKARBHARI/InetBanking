package Test_cases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import Test_objects.AddCustomerPage;
import Test_objects.Test_object;

public class Test_case_3 extends Baseclass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		driver.get(baseurl);
		driver.manage().window().maximize();
		Test_object test_object = new Test_object(driver);
		logger.info("User insert name");
		test_object.getUserName(uname);
		logger.info("User insert password");
		test_object.getUserPassword(upassword);
		test_object.getSubmit();

		Thread.sleep(3000);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.getCustomer();
		logger.info("User insert personal information details:");
	
		addcust.getName("yogesh");
	
		addcust.getGender("male");
		
		addcust.getDob("27", "11", "1984");
		
		addcust.getAdd("Thane");
		
		addcust.getCity("Mumbai");
		
		addcust.getState("Maharashtra");
		
		addcust.getPin("400075");
		
		addcust.getNumber("8108480469");
		
		addcust.getEmail(randomString() + "@gmail.com");
		
		addcust.getPassword("yogesh1234");
		addcust.getsubmit();

		boolean page_source = (driver.getPageSource().contains("Customer Registered Successfully!!!"));
		if (page_source == true) {
			Assert.assertTrue(true);
			logger.info("User account created successfully!!");
		} else {
			getScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("User account is not created !!");
		}
	}

	public String randomString() {
		String randomAlphabet = RandomStringUtils.randomAlphabetic(8);
		return randomAlphabet;
	}
	
	public String randomNumeric() {
		String randomNumber = RandomStringUtils.randomNumeric(6);
		return randomNumber;
	}
}
