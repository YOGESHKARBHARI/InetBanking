package Test_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement NewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement customerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement customerGender;

	@FindBy(how = How.ID, using = "dob")
	@CacheLookup
	WebElement customerDOB;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement customerAddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement customerCity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement customerState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement customerPin;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement customerNumber;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement customerEmail;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement customerPassword;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement customerSubmit;

	public void getCustomer() {
		NewCustomer.click();
	}

	public void getName(String cname) {
		customerName.sendKeys(cname);
	}

	public void getGender(String cgender) {
		customerGender.click();
	}

	public void getDob(String cdate, String cmonth, String cyear) {
		customerDOB.sendKeys(cdate);
		customerDOB.sendKeys(cmonth);
		customerDOB.sendKeys(cyear);
	}
	
	

	public void getAdd(String cadd) {
		customerAddress.sendKeys(cadd);
	}

	public void getCity(String ccity) {
		customerCity.sendKeys(ccity);
	}

	public void getState(String cstate) {
		customerState.sendKeys(cstate);
	}

	public void getPin(String cpin) {
		customerPin.sendKeys(String.valueOf(cpin));
	}

	public void getNumber(String cnumber) {
		customerNumber.sendKeys(cnumber);
	}

	public void getEmail(String cemail) {
		customerEmail.sendKeys(cemail);
	}

	public void getPassword(String cpassword) {
		customerPassword.sendKeys(cpassword);
	}

	public void getsubmit() {
		customerSubmit.click();
	}

}
