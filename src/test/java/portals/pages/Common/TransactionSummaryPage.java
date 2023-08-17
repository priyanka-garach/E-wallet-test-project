package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.TransactionSummaryOperations;
import utils.elasticUtils.elasticwrite;

public class TransactionSummaryPage extends SetupInit {
	TransactionSummaryOperations transactionSummaryOperations;
	elasticwrite log;

	public TransactionSummaryPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		transactionSummaryOperations = new TransactionSummaryOperations(this.driver, this.log);
	}

	public void verifyTransactionSummaryReport() {
		transactionSummaryOperations.isDetailsDisplay(0);
		transactionSummaryOperations.clickOnBackArrow(0);
	}
}
