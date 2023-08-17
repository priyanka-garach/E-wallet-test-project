package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class ForgotPasswordOperations extends SetupInit {
	By verifyForgotPassword = By.xpath("//*[text()='Forgotten Password']");
	elasticwrite log;

	public ForgotPasswordOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void isNavigateToForgotPasswordPage(int... args) {
		verifyVisible(verifyForgotPassword, args);
		setLogSteps(log, "Naviagte To Forgot Password Page");
	}
}
