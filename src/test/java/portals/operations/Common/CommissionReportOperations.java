package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class CommissionReportOperations extends SetupInit {
	By commissionReportHeader = By.xpath("(//*[text()='Commission Report'])[1]");
	By backArrow = By.xpath("//*[contains(@class,'arrow-left')]");
	elasticwrite log;

	public CommissionReportOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void isDetailsDisplay(int... args) {
		verifyVisible(commissionReportHeader, args);
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
