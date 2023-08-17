package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.ForgotMPinOperations;
import utils.elasticUtils.elasticwrite;

public class ForgotMPinPage extends SetupInit {
	ForgotMPinOperations forgotMPinOperations;
	elasticwrite log;

	public ForgotMPinPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		forgotMPinOperations = new ForgotMPinOperations(this.driver, this.log);
	}

	public void forgotMpin() {
		forgotMPinOperations.isNavigateToForgotMPinPage(0);
	}
}
