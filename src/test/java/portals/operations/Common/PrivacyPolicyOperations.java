package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class PrivacyPolicyOperations extends SetupInit {
	By verifyNaviPrivacyPolicy = By.xpath("//*[contains(@class,'graph_area')]//*[text()='Privacy Policy']");
	By verifyTextLycaUganda = By.xpath("//*[contains(text(),'Lycamoney Uganda')]");
	By verifytextwebsiteLink = By.xpath("//*[contains(text(),'www.lycamobile.ug')]");
	elasticwrite log;

	public PrivacyPolicyOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void isNavigateToPrivacyPolicyPage(int... args) {
		verifyVisible(verifyNaviPrivacyPolicy, args);
		setLogSteps(log, "Naviagte To Privacy Policy Page");
		verifyVisible(verifyTextLycaUganda, args);
		setLogSteps(log, "Verify text present >> Lycamoney Uganda");
		verifyVisible(verifytextwebsiteLink, args);
		setLogSteps(log, "Verify text present >> www.lycamobile.ug");
		
	}
}
