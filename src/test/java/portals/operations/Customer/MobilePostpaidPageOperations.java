package portals.operations.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.elasticUtils.elasticwrite;

public class MobilePostpaidPageOperations extends SetupInit {
	By drpMobilePostpaidFor = By.id("frm_select_operatorid");
	public String drpRequestTypeValue = "//*[normalize-space(text())='%s']";
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public MobilePostpaidPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void selectMobilePostpaidFor(String type, int... args) {
		try {
			selectFromDropDown(log, drpMobilePostpaidFor, By.xpath(String.format(drpRequestTypeValue, type)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Mobile Postpaid");
		}
		setLogSteps(log, "Select Mobile Postpaid :" + type);
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
