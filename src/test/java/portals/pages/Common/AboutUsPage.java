package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.AboutUsOperations;
import utils.elasticUtils.elasticwrite;

public class AboutUsPage extends SetupInit {
	AboutUsOperations aboutUsOperations;
	elasticwrite log;

	public AboutUsPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		aboutUsOperations = new AboutUsOperations(this.driver, this.log);
	}

	public void verifyAboutUs() {
		aboutUsOperations.isNavigateToAboutUsPage(0);
	}
}
