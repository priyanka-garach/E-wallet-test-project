package portals.operations.Agent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.elasticUtils.elasticwrite;

public class CustomerOnboardingPageOperationsA extends SetupInit {
	By txtEmail = By.id("frm_text_EMAIL_IDid");

	By txtInformationCard = By.id("frm_text_INFORMATION_CARDid");
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public CustomerOnboardingPageOperationsA(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void clickOnPersonal(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Personal']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Personal");
		}
		setLogSteps(log, "Click On Personal");
	}

	public void clickOnAddress(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Address']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Address");
		}
		setLogSteps(log, "Click On Address");
	}

	public void clickOnBank(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Bank']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Bank");
		}
		setLogSteps(log, "Click On Bank");
	}

	public void clickOnGovernment(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Government']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Government");
		}
		setLogSteps(log, "Click On Government");
	}

	public void clickOnNationality(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Nationality']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Nationality");
		}
		setLogSteps(log, "Click On Nationality");
	}

	public void clickOnBusiness(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Business']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Business");
		}
		setLogSteps(log, "Click On Business");
	}

	public void enterEmailID(String emailID, int... args) {
		try {
			sendKeys(log, txtEmail, emailID, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "EmailID");
		}
		setLogSteps(log, "Enter Email : " + emailID);
	}

	public void enterFullNameInArabic(String fullNameInArabic, int... args) {
		try {
			sendKeys(log, txtEmail, fullNameInArabic, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "FullNameInArabic");
		}
		setLogSteps(log, "Enter FullNameInArabic : " + fullNameInArabic);
	}

	public void enterInformationCard(String value, int... args) {
		try {
			sendKeys(log, txtInformationCard, value, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "Information Card");
		}
		setLogSteps(log, "Enter InformationCard :" + value);
	}

	By txtMobileNumber = By.id("frm_text_PHONEid");

	public void enterMobileNumber(String mobileNumber, int... args) {
		try {
			sendKeys(txtMobileNumber, mobileNumber, 0);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "Nasswallet Sigup Date");
		}
		setLogSteps(log, "Enter Mobile Number : " + mobileNumber);
	}
}
