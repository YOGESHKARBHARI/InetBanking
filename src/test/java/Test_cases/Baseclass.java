package Test_cases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.Reading;

public class Baseclass {
	
	
	Reading reading = new Reading();
	public String baseurl = reading.getBaseurl();
	public String uname= reading.getusername();
	public String upassword =reading.getuserpassword();
	public WebDriver driver;
	public Logger logger ;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br){
		if(br.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", reading.getChrome());
		driver = new ChromeDriver();
		}
		else if (br.equals("gecko")){
		System.setProperty("webdriver.gecko.driver", reading.getgecko());
		driver = new FirefoxDriver();
		}
		else if (br.equals("edge")){
			System.setProperty("webdriver.edge.driver", reading.getedge());
			driver = new EdgeDriver();
			}
		
		 logger = Logger.getLogger("InetBanking");
		PropertyConfigurator.configure("log4j.properties");
	}
	@AfterClass
	public void close(){
		driver.close();
	}
	public void getScreenshot(WebDriver driver,String testcaseName) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+testcaseName+".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot taken!");
	}

}
