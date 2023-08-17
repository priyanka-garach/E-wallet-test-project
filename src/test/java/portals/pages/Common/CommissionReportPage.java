package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommissionReportOperations;
import utils.elasticUtils.elasticwrite;

public class CommissionReportPage extends SetupInit {
	CommissionReportOperations commissionReportOperations;
	elasticwrite log;

	public CommissionReportPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		commissionReportOperations = new CommissionReportOperations(this.driver, this.log);
	}

	public void verifyCommissionReport() {
		commissionReportOperations.isDetailsDisplay(0);
		commissionReportOperations.clickOnBackArrow(0);
	}
}
