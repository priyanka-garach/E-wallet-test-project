package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class ContactUsOperations extends SetupInit {
	By verifyHeaderContactUs = By.xpath("//*[text()='Contact Our Support']");
	By verifyNaviContactUs = By.xpath("//*[contains(@class,'graph_area')]//*[text()='Contact Us']");
	elasticwrite log;

	public ContactUsOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void isNavigateToContactUsPage(int... args) {
		verifyVisible(verifyNaviContactUs, args);
		setLogSteps(log, "Naviagte To Contact Us Page");
	}

	public void isContactUsHeaderDisplay(int... args) {
		verifyVisible(verifyHeaderContactUs, args);
		setLogSteps(log, "Contact Us Page Header Is Displaying");
	}
}
