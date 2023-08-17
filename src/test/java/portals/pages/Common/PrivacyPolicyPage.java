package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.PrivacyPolicyOperations;
import utils.elasticUtils.elasticwrite;

public class PrivacyPolicyPage extends SetupInit {
	PrivacyPolicyOperations privacyPolicyOperations;
	elasticwrite log;

	public PrivacyPolicyPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		privacyPolicyOperations = new PrivacyPolicyOperations(this.driver, log);
	}

	public void verifyPrivacyPolicy() {
		privacyPolicyOperations.isNavigateToPrivacyPolicyPage(0);
	}
}
