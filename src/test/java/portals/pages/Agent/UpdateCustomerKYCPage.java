package portals.pages.Agent;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Agent.A2ATransferPageOperations;
import portals.operations.Agent.CashInByAgentPageOperations;
import portals.operations.Agent.UpdateCustomerKYCPageOperations;
import portals.operations.Agent.WithdrawMoneyPageOperations;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.Customer.P2PPageOperations;
import utils.elasticUtils.elasticwrite;

public class UpdateCustomerKYCPage extends SetupInit {
	UpdateCustomerKYCPageOperations updateCustomerKYCPageOperations;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public UpdateCustomerKYCPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		updateCustomerKYCPageOperations = new UpdateCustomerKYCPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public Map<Object, Object> updateCustomerKYC(Map<Object, Object> map) {
		Map<Object, Object> data = new HashMap<Object, Object>();
		dashboardPageCommon.clickOnCheckBalance(0);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(this.log, "Current Balance is: " + currentBalance);
		double latestBalance = 0.0;
		String transactionId = null;
		updateCustomerKYCPageOperations.enterRegisteredMobileNumber(map.get(ToUserName).toString(), 0);
		updateCustomerKYCPageOperations.clickOnNextButton(0);
		if (verifyVisible(dashboardPageCommon.insufficientBalanceText, 2)) {
			setLogSteps(this.log, getElementText(this.log, dashboardPageCommon.insufficientBalanceText, 2));
		} else {
			if (verifyVisible(dashboardPageCommon.alert, 2)) {
				setLogSteps(this.log, getElementText(this.log, dashboardPageCommon.alert, 2));
				dashboardPageCommon.clickOnCloseButton(0);
			} else {
				dashboardPageCommon.verifyOTPScreen(0);
			}
		}
		data.putAll(map);
		data.put(ServiceName, "Update Customer KYC");
		return data;
	}

	// public void verifyPerformedMoneyTransferInAdmin(Map<Object, Object> map)
	// {
	// String transactionId = map.get(TransactionID).toString();
	// common.adminLogin(env);
	// if (!map.get(ToUserType).toString().replaceAll("\\s",
	// "").equalsIgnoreCase("enterprise")
	// && !map.get(ToUserType).toString().replaceAll("\\s",
	// "").equalsIgnoreCase("trustaccount")) {
	// common.verifyTransaction(map.get(ToPortalName).toString(), transactionId,
	// 0);
	// setLogSteps(log, "Search Transaction from Filter Search");
	// }
	// setLogSteps(log, "Successfully Transaction verify in Admin");
	// common.adminLogOut();
	// }
	//
	// public void verifyPerformedMoneyTransferInWebPortalForToUser(Map<Object,
	// Object> map) {
	// common.verifyT
	// }
	//
	// public void
	// verifyPerformedMoneyTransferInWebPortalForFromUser(Map<Object,
	// Object> map) {
	// common.webPortalLogin(map, "from", 0);
	// dashboardPageCommon.passbookVerification(map.get(ServiceName).toString(),
	// map.get(TransactionID).toString());
	// setLogSteps(log, "Successfully Transaction verify in To User");
	// }
}
