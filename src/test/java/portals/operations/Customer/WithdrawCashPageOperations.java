package portals.operations.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.Common.NavigationPageOperations;
import utils.elasticUtils.elasticwrite;

public class WithdrawCashPageOperations extends SetupInit {
	By drpType = By.id("frm_select_typeid");
	public String drpRequestTypeValue = "//*[normalize-space(text())='%s']";
	By btnSubmit = By.name("submit");
	By btnConfirm = By.name("confirm");
	By btnlogOut = By.xpath("//*[@title='Logout']");
	DashBoardPageOperations dashboardPageCommon;
	public By txtAgentAssistedWithdraw = By.xpath("(//div[text()='Agent Assisted Withdraw'])[1]");
	public By txtAgentAssistedWithdrawSideMenu = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Agent Assisted Withdraw']");
	public By txtAgentAssistedWithdrawFromFooter = By.xpath("//a[contains(text(),'Agent Assisted Withdraw')]");
	CommonOperations common;
	NavigationPageOperations navigationpageOperations;
	elasticwrite log;

	public WithdrawCashPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		navigationpageOperations = new NavigationPageOperations(driver, log);
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

	public void clickOntxtAgentAssistedWithdrawfromDashboard(int... args) {
		try {
			clickOnElement(txtAgentAssistedWithdraw, args);
			setLogSteps(log, "Click On Agent Assisted Withdraw");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Assisted Withdraw");
		}
	}
	
	public void clickOntxtAgentAssistedWithdrawFromFooter(int... args) {
		try {
			clickOnElement(txtAgentAssistedWithdrawFromFooter, args);
			setLogSteps(log, "Click On Agent Assisted Withdraw from Footer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Assisted Withdraw from Footer");
		}
	}
	
	public void clickOntxtAgentAssistedWithdrawFromSideMenu(int... args) {
		try {
			navigationpageOperations.clickOnSideMenuServices(args);
			clickOnElement(txtAgentAssistedWithdrawSideMenu, args);
			setLogSteps(log, "Click On Agent Assisted Withdraw from Side Menu");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Assisted Withdraw from Side Menu");
		}
	}

	public void clickOnServiceSubmitButton(int... args) {
		clickOnElement(btnSubmit, args);
		setLogSteps(log, "Click On Submit Button");
	}

	public void clickOnConfirmButton(int... args) {
		clickOnElement(btnConfirm, args);
		setLogSteps(log, "Click On Confirm Button");
	}
	
	public void clickOnLogoutButton(int... args) {
		clickOnElement(btnlogOut, args);
		setLogSteps(log, "Click On LogOut Button");
	}
}
