package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.MPINPolicyOperations;
import utils.elasticUtils.elasticwrite;

public class MPINPolicyPage extends SetupInit {
	MPINPolicyOperations mpinPolicyOperations;
	elasticwrite log;

	public MPINPolicyPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		mpinPolicyOperations = new MPINPolicyOperations(this.driver, this.log);
	}

	public void verifyMpinPolicy() {
		mpinPolicyOperations.isNavigateToMpinPolicyPage(0);
	}
}
