package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.FAQsOperations;
import utils.elasticUtils.elasticwrite;

public class FAQsPage extends SetupInit {
	FAQsOperations fAQsOperations;
	elasticwrite log;

	public FAQsPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		fAQsOperations = new FAQsOperations(this.driver, log);
	}

	public void verifyFAQs() {
		fAQsOperations.isNavigateToFAQsPage(0);
	}
}
