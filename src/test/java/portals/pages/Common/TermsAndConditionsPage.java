package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.TermsAndConditionsOperations;
import utils.elasticUtils.elasticwrite;

public class TermsAndConditionsPage extends SetupInit {
	TermsAndConditionsOperations termsAndConditionsOperations;
	elasticwrite log;

	public TermsAndConditionsPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		termsAndConditionsOperations = new TermsAndConditionsOperations(this.driver, log);
	}

	public void verifyTermsAndConditions() {
		termsAndConditionsOperations.isNavigateToTermsConditionPage(0);
	}
}
