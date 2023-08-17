package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class AboutUsOperations extends SetupInit {
	By verifyNaviAboutUs = By.xpath("//*[contains(@class,'graph_area')]//*[text()='About Us']");
	elasticwrite log;

	public AboutUsOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void isNavigateToAboutUsPage(int... args) {
		verifyVisible(verifyNaviAboutUs, args);
		setLogSteps(log, "Naviagte To About Us Page");
	}
}
