package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class NewUserOperations extends SetupInit {
	By verifyNewUser = By.xpath("//*[text()='Register']");
	elasticwrite log;

	public NewUserOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void isNavigateToNewUserPage(int... args) {
		verifyVisible(verifyNewUser, args);
		setLogSteps(log, "Naviagte To New Page");
	}
}
