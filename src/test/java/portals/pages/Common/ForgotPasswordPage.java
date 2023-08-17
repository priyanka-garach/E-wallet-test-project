package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.ForgotMPinOperations;
import portals.operations.Common.ForgotPasswordOperations;
import utils.elasticUtils.elasticwrite;

public class ForgotPasswordPage extends SetupInit {
	ForgotPasswordOperations forgotPasswordOperations;
	elasticwrite log;

	public ForgotPasswordPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		forgotPasswordOperations = new ForgotPasswordOperations(this.driver, this.log);
	}

	public void forgotPassword() {
		forgotPasswordOperations.isNavigateToForgotPasswordPage(0);
	}
}
