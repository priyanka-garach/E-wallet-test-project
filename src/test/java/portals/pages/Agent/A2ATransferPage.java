package portals.pages.Agent;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Agent.A2ATransferPageOperations;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.elasticUtils.elasticwrite;

public class A2ATransferPage extends SetupInit {
	A2ATransferPageOperations a2aTransferPageOperations;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public A2ATransferPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		a2aTransferPageOperations = new A2ATransferPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	
	public Map<Object, Object> a2aTransfer(Map<Object, Object> map) {
		Map<Object, Object> data = new HashMap<Object, Object>();
		dashboardPageCommon.clickOnCheckBalance(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(pin, 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(this.log, "Current Balance is: " + currentBalance);
		double latestBalance = 0.0;
		String transactionId = null;
		dashboardPageCommon.enterMobileNumber(map.get(ToUserName).toString(), 0);
		dashboardPageCommon.enterAmount(map.get(Amount).toString(), 0);
		
		dashboardPageCommon.sendTextInRemarks(map.get(Remarks).toString(), 0);
		dashboardPageCommon.enterSecretPIN(pin, 0);
		dashboardPageCommon.clickOnServiceSubmitButton(0);
		if (verifyVisible(dashboardPageCommon.insufficientBalanceText, 2)) {
			setLogSteps(this.log, getElementText(this.log, dashboardPageCommon.insufficientBalanceText, 2));
		} else {
			if (verifyVisible(dashboardPageCommon.alert, 2)) {
				setLogSteps(this.log, getElementText(this.log, dashboardPageCommon.alert, 2));
				dashboardPageCommon.clickOnCloseButton(0);
			} else {
				verifyVisible(
						By.xpath(String.format(dashboardPageCommon.verifyMobileNumber, map.get(ToUserName).toString())),
						0);
				setLogSteps(this.log, "Verify Mobile Number on Confirmation Screen: " + map.get(ToUserName).toString());
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyRemarks, map.get(Remarks).toString())),
						0);
				setLogSteps(this.log, "Verify Remarks on Confirmation Screen: " + map.get(Remarks).toString());
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount, map.get(Amount).toString())), 0);
				setLogSteps(this.log, "Verify Amount on Confirmation Screen: " + map.get(Amount).toString());
				
				dashboardPageCommon.verifyUGXSign(0);
				dashboardPageCommon.clickOnConfirmButton(0);
				verifyVisible(dashboardPageCommon.verifyTransaction, 0);
				setLogSteps(log, "Verify Transaction is Success");
				verifyVisible(
						By.xpath(String.format(dashboardPageCommon.verifyMobileNumber, map.get(ToUserName).toString())),
						0);
				setLogSteps(log, "Verify Mobile Number on Success Screen: " + map.get(ToUserName).toString());
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyRemarks, map.get(Remarks).toString())),
						0);
				setLogSteps(log, "Verify Remarks on Success Screen: " + map.get(Remarks).toString());
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount, map.get(Amount).toString())), 0);
				setLogSteps(log, "Verify Amount on Success Screen: " + map.get(Amount).toString());
				dashboardPageCommon.verifyUGXSignConfirmationScreen();
				latestBalance = Double.parseDouble(dashboardPageCommon.getMainBalanceAfterTransaction(0).trim());
				transactionId = dashboardPageCommon.getTransactionID();
				setLogSteps(this.log, "Updated Balance is: " + latestBalance);
				if (!(currentBalance > latestBalance)) {
					throw new RuntimeException("Before balance: " + currentBalance + " is > "
							+ " After transaction balance" + latestBalance);
				}
			}
		}
		data.putAll(map);
		data.put(TransactionID, transactionId);
		data.put(UpdatedBal, latestBalance);
		data.put(ServiceName, "A2A Transfer");
		String trnFile = "";
		try {
			trnFile = setTransactionCalculator("A2ATransfer", map.get(FromUserName).toString(),
					map.get(ToUserName).toString(), String.valueOf(currentBalance), map.get(Amount).toString(),
					map.get(FromSurchrge).toString(), map.get(FromCommission).toString(),
					map.get(ToSurcharge).toString(), map.get(ToCommission).toString(), transactionId,
					String.valueOf(latestBalance));
		} catch (Exception e) {
			setLogSteps(this.log, "Unable to generate transaction verification file");
		}
		data.put(TransactionFile, trnFile);
		
		return data;
	}


	public double clickOnCheckBalanceFromProfile() {
		dashboardPageCommon.clickOnCheckBalanceFromProfile(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(pin, 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		pauseInSeconds(2);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(this.log, "Current Balance is: " + currentBalance);
		return  currentBalance;		
	}
	
	
	
	public double clickOnCheckBalance() {
		dashboardPageCommon.clickOnCheckBalance(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(pin, 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		pauseInSeconds(2);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(this.log, "Current Balance is: " + currentBalance);
		return  currentBalance;
	}

	public double clickOnCheckCommissionBalance() {
		dashboardPageCommon.clickOnCheckBalance(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(pin, 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		pauseInSeconds(2);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getCommissionBalance(0).trim());
		setLogSteps(this.log, "Current Commission Balance is: " + currentBalance);
		return  currentBalance;
	}
	
	public double clickOnCheckCommissionBalanceFromProfile() {
		dashboardPageCommon.clickOnCheckBalanceFromProfile(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(pin, 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		pauseInSeconds(2);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getCommissionBalance(0).trim());
		setLogSteps(this.log, "Current Commission Balance is: " + currentBalance);
		return  currentBalance;		
	}

	// public void verifyPerformedMoneyTransferInAdmin(Map<Object, Object> map) {
	// String transactionId = map.get(TransactionID).toString();
	// common.adminLogin(env);
	// if (!map.get(ToUserType).toString().replaceAll("\\s",
	// "").equalsIgnoreCase("enterprise")
	// && !map.get(ToUserType).toString().replaceAll("\\s",
	// "").equalsIgnoreCase("trustaccount")) {
	// common.verifyTransaction(map.get(ToPortalName).toString(), transactionId, 0);
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
	// public void verifyPerformedMoneyTransferInWebPortalForFromUser(Map<Object,
	// Object> map) {
	// common.webPortalLogin(map, "from", 0);
	// dashboardPageCommon.passbookVerification(map.get(ServiceName).toString(),
	// map.get(TransactionID).toString());
	// setLogSteps(log, "Successfully Transaction verify in To User");
	// }
}
