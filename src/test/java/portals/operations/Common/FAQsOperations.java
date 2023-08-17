package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class FAQsOperations extends SetupInit {
	By verifyNaviFAQs = By.xpath("//*[contains(@class,'graph_area')]//*[text()='FAQs']");
	By verifytxtMobileAcc = By.xpath("//*[contains(text(),'How do I get a Lycamobile account?')]");
	By verifytxtLycamobile = By.xpath("//*[contains(text(),'Lycamobile')]");
	By verifyLycaAccountText = By.xpath("//*[contains(text(),'National or Civil ID and Residency Card')]");
	By btnLycamobileAccount = By.xpath("//*[@class='MuiButtonBase-root MuiIconButton-root MuiExpansionPanelSummary-expandIcon MuiIconButton-edgeEnd'][1]");
	elasticwrite log;

	public FAQsOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		WebElement e1;
	}

	public void isNavigateToFAQsPage(int... args) {
		verifyVisible(verifyNaviFAQs, args);
		setLogSteps(log, "Naviagte To FAQs Page");
		verifyVisible(verifytxtMobileAcc, args);
		setLogSteps(log, "VerifyContent >> How do I get a Lycamobile account?");
		verifyVisible(verifytxtLycamobile, args);
		setLogSteps(log, "VerifyContent >> Lycamobile");
		clickOnElement(verifytxtLycamobile, args);
//		scrollToElement(driver.findElement(By.xpath("")));
		verifyVisible(verifyLycaAccountText, args);
		setLogSteps(log, "VerifyContent >> National or Civil ID and Residency Card");
	}
}
