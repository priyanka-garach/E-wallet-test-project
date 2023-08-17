package portals.operations.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import utils.elasticUtils.elasticwrite;

public class ChangeSecretWordPageOperations extends SetupInit {
	
	CommonOperations common;
	elasticwrite log; 
	 
	By entersecretWord = By.id("frm_text_secretWordid");
	By currentSecretWord = By.id("frm_text_secretWordid");
	By confirmSecretWord = By.id("frm_text_confirmsecretWordid");
	By btnSubmit = By.name("submit");
	
	public ChangeSecretWordPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		common = new CommonOperations(this.driver, log);
	}
	
	public void entersecretWord(String entersecretWord1, int... args) {
		sendKeys(entersecretWord, entersecretWord1, 0);
		setLogSteps(log, "Enter Secret Word : " + entersecretWord1);
	}
	
	public void enternewSecretWord(String newsecretWord, int... args) {
		sendKeys(currentSecretWord, newsecretWord, 0);
		setLogSteps(log, "Enter New Secret Word: " + newsecretWord);
	}
	
	public void enterconfirmSecretWord(String confirmsecretword, int... args) {
		sendKeys(confirmSecretWord, confirmsecretword, 0);
		setLogSteps(log, "Enter Confirm Secret Word : " + confirmsecretword);
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
