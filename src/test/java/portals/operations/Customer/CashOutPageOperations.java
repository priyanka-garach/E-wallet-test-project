package portals.operations.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.elasticUtils.elasticwrite;

public class CashOutPageOperations extends SetupInit {
	By drpType = By.id("frm_select_typeid");
	public String drpRequestTypeValue = "//*[normalize-space(text())='%s']";
	By btnSubmit = By.name("submit");
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public CashOutPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void selectType(String type, int... args) {
		try {
			selectFromDropDown(log, drpType, By.xpath(String.format(drpRequestTypeValue, type)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Type");
		}
		setLogSteps(log, "Select Type :" + type);
	}

	public void clickOnServiceSubmitButton(int... args) {
		clickOnElement(btnSubmit, args);
		setLogSteps(log, "Click On Submit Button");
	}
}
