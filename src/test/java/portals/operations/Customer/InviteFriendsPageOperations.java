package portals.operations.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import utils.elasticUtils.elasticwrite;

public class InviteFriendsPageOperations extends SetupInit {
	
	CommonOperations common;
	elasticwrite log; 
	 
	By txtmobilenumber = By.id("frm_text_mobileid");
	By pin = By.id("frm_text_transactionPinid");
	By btnSubmit = By.name("Submit");
	
	public InviteFriendsPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		//changeMpinPage = new ChangeMpinPageOperations(this.driver, log);
		common = new CommonOperations(this.driver, log);
	}
	
	public void enterMobieNumber(String mobno, int... args) {
		sendKeys(txtmobilenumber, mobno, 0);
		setLogSteps(log, "Enter Non-registered Mobile Number : " + mobno);
	}
	
	public void enterMpin(String mpin, int... args) {
		sendKeys(pin, mpin, 0);
		setLogSteps(log, "Enter MPIN : " + mpin);
	}

	public void clickOnsubmitButton() {
		try {
			clickOnElement(this.log, btnSubmit, 0);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Submit Button");
		}
		setLogSteps(log, "Click On Submit Button");
	}
}
