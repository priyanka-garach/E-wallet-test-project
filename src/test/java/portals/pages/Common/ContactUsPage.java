package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.ContactUsOperations;
import utils.elasticUtils.elasticwrite;

public class ContactUsPage extends SetupInit {
	ContactUsOperations contactUsOperations;
	elasticwrite log;

	public ContactUsPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		contactUsOperations = new ContactUsOperations(this.driver, this.log);
	}

	public void verifyContactUs() {
		contactUsOperations.isNavigateToContactUsPage(0);
	}
}
