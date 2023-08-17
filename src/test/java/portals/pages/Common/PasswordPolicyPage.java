package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.PasswordPolicyOperations;
import utils.elasticUtils.elasticwrite;

public class PasswordPolicyPage extends SetupInit {
	PasswordPolicyOperations passwordPolicyOperations;
	elasticwrite log;

	public PasswordPolicyPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		passwordPolicyOperations = new PasswordPolicyOperations(this.driver, log);
	}

	public void verifyPasswordPolicy() {
		passwordPolicyOperations.isNavigateToPasswordPolicyPage(0);
	}
}
