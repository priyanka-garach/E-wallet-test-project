package portals.operations.Agent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.elasticUtils.elasticwrite;

public class UpdateCustomerKYCPageOperations extends SetupInit {
	By txtRegisteredNumber = By.id("frm_text_userIdentifierid");
	By btnNext = By.xpath("//button[text()='NEXT']");

	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public UpdateCustomerKYCPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void enterRegisteredMobileNumber(String mobileNumber, int... args) {
		try {
			sendKeys(txtRegisteredNumber, mobileNumber, 0);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "Registered Mobile Number");
		}
		setLogSteps(log, "Enter Registered Mobile Number : " + mobileNumber);
	}

	public void clickOnNextButton(int... args) {
		try {
			clickOnElement(btnNext, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Next Button");
		}
		setLogSteps(log, "Click On Next button");
	}
}
