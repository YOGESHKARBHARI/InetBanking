package Test_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test_object {

	public WebDriver ldriver;

	public Test_object(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	WebElement userName;

	@FindBy(name = "password")
	WebElement userPassword;

	@FindBy(name = "btnLogin")
	WebElement button;

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement logout;

	public void getUserName(String uname) {
		userName.sendKeys(uname);

	}

	public void getUserPassword(String upassword) {
		userPassword.sendKeys(upassword);

	}

	public void getSubmit() {
		button.click();

	}

	public void getLogout() {
		logout.click();
	}
}
