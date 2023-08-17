package portals.operations.SubAgent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import utils.elasticUtils.elasticwrite;

public class ChangePasswordPageOperations extends SetupInit {
	
	CommonOperations common;
	elasticwrite log; 
	 
	By oldPassword = By.id("frm_text_oldPasswordid");
	By newPassword = By.id("frm_text_passwordid");
	By confirmPassword = By.id("frm_text_confirmPasswordid");
	By btnSubmit = By.name("submit");
	
	public ChangePasswordPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		common = new CommonOperations(this.driver, log);
	}
	
	public void enterOldPassword(String currentpwd, int... args) {
		sendKeys(oldPassword, currentpwd, 0);
		setLogSteps(log, "Enter Old Password : " + currentpwd);
	}
	
	public void enternewPassword(String currentpwd, int... args) {
		sendKeys(newPassword, currentpwd, 0);
		setLogSteps(log, "Enter New Password : " + currentpwd);
	}
	
	public void enterconfirmPassword(String currentpwd, int... args) {
		sendKeys(confirmPassword, currentpwd, 0);
		setLogSteps(log, "Enter Confirm Password : " + currentpwd);
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
