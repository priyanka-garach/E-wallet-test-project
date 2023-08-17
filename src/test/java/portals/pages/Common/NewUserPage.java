package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.ForgotMPinOperations;
import portals.operations.Common.ForgotPasswordOperations;
import portals.operations.Common.NewUserOperations;
import utils.elasticUtils.elasticwrite;

public class NewUserPage extends SetupInit {
	NewUserOperations newUserOperations;
	elasticwrite log;

	public NewUserPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		newUserOperations = new NewUserOperations(this.driver, this.log);
	}

	public void newUser() {
		newUserOperations.isNavigateToNewUserPage(0);
	}
}
