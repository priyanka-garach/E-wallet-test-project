package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class ForgotMPinOperations extends SetupInit {
	By verifyForgotMPin = By.xpath("//*[text()='Forgotten MPIN']");
	elasticwrite log;

	public ForgotMPinOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void isNavigateToForgotMPinPage(int... args) {
		verifyVisible(verifyForgotMPin, args);
		setLogSteps(log, "Naviagte To Forgot MPin Page");
	}
}
