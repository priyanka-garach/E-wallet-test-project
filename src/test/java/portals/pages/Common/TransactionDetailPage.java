package portals.pages.Common;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.TransactionDetailOperations;
import utils.elasticUtils.elasticwrite;

public class TransactionDetailPage extends SetupInit {
	TransactionDetailOperations transactionDetailOperations;
	elasticwrite log;

	public TransactionDetailPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		transactionDetailOperations = new TransactionDetailOperations(this.driver, this.log);
	}

	public void verifyTransactionDetailReport() {
		transactionDetailOperations.isDetailsDisplay(0);
		transactionDetailOperations.clickOnBackArrow(0);
	}
}
