package portals.pages.Agent;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Agent.CustomerOnboardingPageOperationsA;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.Utility;
import utils.elasticUtils.elasticwrite;

public class CustomerOnboardingPage extends SetupInit {
	CustomerOnboardingPageOperationsA customerOnboardingPageOperations;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public CustomerOnboardingPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		customerOnboardingPageOperations = new CustomerOnboardingPageOperationsA(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

}
