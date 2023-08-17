package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class TermsAndConditionsOperations extends SetupInit {
	By verifyNaviTermsConditions = By.xpath("//*[contains(@class,'graph_area')]//*[text()='Terms & Conditions']");
	By verifytxtApplicationAcc = By.xpath("//*[contains(text(),'APPLICATION FOR ACCOUNT')]");
	By verifytxtLycamoneyUganda = By.xpath("//*[contains(text(),'Lycamoney Uganda')]");
	By verifytextwebsiteLink = By.xpath("//*[contains(text(),'www.lycamobile.ug')]");
	elasticwrite log;

	public TermsAndConditionsOperations(WebDriver driver, elasticwrite log) {	
		this.log = log;
		this.driver = driver;
	}

	public void isNavigateToTermsConditionPage(int... args) {
		verifyVisible(verifyNaviTermsConditions, args);
		setLogSteps(log, "Naviagte To Terms & Conditions Page");
		verifyVisible(verifytxtApplicationAcc, args);
		setLogSteps(log, "VerifyContent >> APPLICATION FOR ACCOUNT");
		verifyVisible(verifytxtLycamoneyUganda, args);
		setLogSteps(log, "VerifyContent >> Lycamoney Uganda");
//		scrollToElement(driver.findElement(By.xpath("")));
//		verifyVisible(verifytextwebsiteLink, args);
//		setLogSteps(log, "VerifyContent >> www.lycamobile.ug");
	}
}
