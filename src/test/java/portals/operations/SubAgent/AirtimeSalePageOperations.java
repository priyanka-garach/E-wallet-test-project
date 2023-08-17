package portals.operations.SubAgent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.elasticUtils.elasticwrite;

public class AirtimeSalePageOperations extends SetupInit {
	By drpTopupAmount = By.id("frm_select_productIdid");
	public String drpRequestTypeValue = "//*[normalize-space(text())='%s']";
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public AirtimeSalePageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void selectTopupAmount(String type, int... args) {
		try {
			selectFromDropDown(log, drpTopupAmount, By.xpath(String.format(drpRequestTypeValue, type)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Topup Amount");
		}
		setLogSteps(log, "Select Topup Amount :" + type);
	}

	public void selectTopupFor(String type, int... args) {
		try {
			clickOnElement(log, By.xpath(String.format(drpRequestTypeValue, type)), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Topup For");
		}
		setLogSteps(log, "Select Topup For :" + type);
	}
}
