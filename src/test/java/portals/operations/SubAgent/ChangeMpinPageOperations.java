package portals.operations.SubAgent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import utils.elasticUtils.elasticwrite;

public class ChangeMpinPageOperations extends SetupInit {
	
	CommonOperations common;
	elasticwrite log; 
	 
	By currentMpin = By.id("frm_text_oldtransactionPinid");
	By newMpin = By.id("frm_text_transactionPinid");
	By confirmMpin = By.id("frm_text_confirmTransactionPinid");
	By btnSubmit = By.name("submit");
	
	public ChangeMpinPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		//changeMpinPage = new ChangeMpinPageOperations(this.driver, log);
		common = new CommonOperations(this.driver, log);
	}
	
	public void entercurrentMpin(String currentmpin, int... args) {
		sendKeys(currentMpin, currentmpin, 0);
		setLogSteps(log, "Enter Current MPIN : " + currentmpin);
	}
	
	public void enternewMpin(String currentmpin, int... args) {
		sendKeys(newMpin, currentmpin, 0);
		setLogSteps(log, "Enter New MPIN : " + newMpin);
	}
	
	public void enterconfirmMpin(String currentmpin, int... args) {
		sendKeys(confirmMpin, currentmpin, 0);
		setLogSteps(log, "Enter Confirm MPIN : " + confirmMpin);
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
