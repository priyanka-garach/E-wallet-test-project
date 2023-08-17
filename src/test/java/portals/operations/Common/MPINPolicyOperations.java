package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class MPINPolicyOperations extends SetupInit {
	By verifyNaviMPINPolicy = By.xpath("//*[contains(@class,'graph_area')]//*[text()='MPIN Policy']");
	By verifyMPINNumbertext = By.xpath("//*[contains(text(),'MPIN number')]");
	By verifyMPINExampletext = By.xpath("//*[contains(text(),'MPIN Example')]");
	By verifyMPIN4digitstext = By.xpath("//*[contains(text(),'4 digits')]");
	elasticwrite log;

	public MPINPolicyOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void isNavigateToMpinPolicyPage(int... args) {
		verifyVisible(verifyNaviMPINPolicy, args);
		setLogSteps(log, "Naviagte To MPIN Policy Page");
		verifyVisible(verifyMPINNumbertext, args);
		setLogSteps(log, "Verify text as present >> MPIN Number");
		verifyVisible(verifyMPINExampletext, args);
		setLogSteps(log, "Verify text as present >> MPIN Example");
		verifyVisible(verifyMPIN4digitstext, args);
		setLogSteps(log, "Verify text as present >> MPIN 4 digits");
		
		
	}
}
