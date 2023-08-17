package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class PasswordPolicyOperations extends SetupInit {
	By verifyNaviPasswordPolicy = By.xpath("//*[contains(@class,'graph_area')]//*[text()='Password Policy']");
	By verifyTextPass = By.xpath("//*[contains(text(),'Password must have minimum 8 characters.')]");
	By verifytextPasswordExample = By.xpath("//*[contains(@class,'copy_pin_area')]");
	elasticwrite log;

	public PasswordPolicyOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void isNavigateToPasswordPolicyPage(int... args) {
		verifyVisible(verifyNaviPasswordPolicy, args);
		setLogSteps(log, "Naviagte To Password Policy Page");
		verifyVisible(verifyTextPass, args);
		setLogSteps(log, "Verify text present >> Password must have minimum 8 characters.");
		verifyVisible(verifytextPasswordExample, args);
		setLogSteps(log, "Verify text Password Example >> An1@54cd");
		
	}
}
