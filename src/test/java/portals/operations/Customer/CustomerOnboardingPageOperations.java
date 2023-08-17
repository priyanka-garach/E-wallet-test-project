package portals.operations.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.elasticUtils.elasticwrite;

public class CustomerOnboardingPageOperations extends SetupInit {
	By txtEmail = By.id("frm_text_EMAIL_IDid");

	By btnSubmit = By.name("submit");
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public CustomerOnboardingPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	
}
