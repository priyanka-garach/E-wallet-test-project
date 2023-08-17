package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class TransactionDetailOperations extends SetupInit {
	By transactionDeatilHeader = By.xpath("(//*[text()='Transaction Details'])[1]");
	By backArrow = By.xpath("//*[contains(@class,'arrow-left')]");
	elasticwrite log;

	public TransactionDetailOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void isDetailsDisplay(int... args) {
		verifyVisible(transactionDeatilHeader, args);
		setLogSteps(log, "Transaction Detail Header Is Present");
	}

	public void clickOnBackArrow(int... args) {
		try {
			clickOnElement(log, backArrow, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Back Arrow");
		}
		setLogSteps(log, "Click On Back Arrow of Report");
	}
}
