package Test_cases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Test_objects.Test_object;
import Utilities.XLUtils;

public class Test_case_2 extends Baseclass {
	@Test(dataProvider="LoginData")
	public void checkData(String uname,String upassword) {
		logger.info("URL is open");
		driver.get(baseurl);
		driver.manage().window().maximize();
		Test_object test_object = new Test_object(driver);
		logger.info("User is put name");
		test_object.getUserName(uname);
		logger.info("User is put password");
		test_object.getUserPassword(upassword);
		test_object.getSubmit();
		if(isAlertPresent()==true){
			driver.switchTo().alert();	
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login is not successful");
		}
		else{
			test_object.getLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.info("Login is successful");
		}

	}
	
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getdatafromExcel() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/java/Test_data/Book.xlsx";
		int row_count = XLUtils.getRowCount(path, "Sheet1");
		int column_count = XLUtils.getCellCount(path, "Sheet1", 1);
		String[][] logindata = new String[row_count][column_count];
		for (int i = 1; i <= row_count; i++) {
			for (int j = 0; j < column_count; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);

			}

		}
		return logindata;
	}

}
