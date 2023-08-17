package portals.pages.Customer;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.Customer.P2POffnetPageOperations;
import utils.DBUtils;
import utils.elasticUtils.elasticwrite;

public class P2POffnetPage extends SetupInit {
	P2POffnetPageOperations p2pOffnetOperations;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public P2POffnetPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		p2pOffnetOperations = new P2POffnetPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public Map<Object, Object> P2POffnetTransfer(Map<Object, Object> map) {
		Map<Object, Object> data = new HashMap<Object, Object>();
		dashboardPageCommon.clickOnCheckBalance(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(password, 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(this.log, "Current Balance is: " + currentBalance);
		double latestBalance = 0.0;
		String transactionId = null;
		
		dashboardPageCommon.enterMobileNumberp2poffnet(map.get(ToUserName).toString(), 0);
		dashboardPageCommon.enterAmount(map.get(Amount).toString(), 0);
		dashboardPageCommon.sendTextInRemarks(map.get(Remarks).toString(), 0);
		dashboardPageCommon.enterSecretPIN(password, 0);
		pauseInSeconds(3);
		dashboardPageCommon.clickOnServiceSubmitButton(0);
		if (verifyVisible(dashboardPageCommon.insufficientBalanceText, 2)) {
			String alertMessage = getElementText(this.log, dashboardPageCommon.insufficientBalanceText, 2);
			setLogSteps(this.log, alertMessage);
			throw new RuntimeException(alertMessage);
		} else {
			if (verifyVisible(dashboardPageCommon.alert, 2)) {
				String alertMessage = getElementText(this.log, dashboardPageCommon.alert, 2);
				setLogSteps(this.log, alertMessage);
				dashboardPageCommon.clickOnCloseButton(0);
				throw new RuntimeException(alertMessage);
			} else {
				pauseInSeconds(2);
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyMobileNumber, map.get(ToUserName).toString())),0);
				setLogSteps(this.log, "Verify Mobile Number on Confirmation Screen: " + map.get(ToUserName).toString());
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyRemarks, map.get(Remarks).toString())),0);
				setLogSteps(this.log, "Verify Remarks on Confirmation Screen: " + map.get(Remarks).toString());
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount, map.get(Amount).toString())), 0);
				setLogSteps(this.log, "Verify Amount on Confirmation Screen: " + map.get(Amount).toString());
				pauseInSeconds(3);
				dashboardPageCommon.clickOnConfirmButton(0);
				verifyVisible(dashboardPageCommon.verifyTransaction, 0);
				setLogSteps(log, "Verify Transaction is Success");
				pauseInSeconds(2);
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyMobileNumber, map.get(ToUserName).toString())),0);
				setLogSteps(log, "Verify Mobile Number on Success Screen: " + map.get(ToUserName).toString());
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyRemarks, map.get(Remarks).toString())),0);
				setLogSteps(log, "Verify Remarks on Success Screen: " + map.get(Remarks).toString());
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount, map.get(Amount).toString())), 0);
				setLogSteps(log, "Verify Amount on Success Screen: " + map.get(Amount).toString());
				
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
		data.put(ServiceName, "P2P Off Net");
		data.put(ToUserName, map.get(ToUserName).toString());
		data.put(FromUserName, map.get(FromUserName).toString());
		data.put(Amount, map.get(Amount).toString());
		
		String trnFile = "";
		try {
			trnFile = setTransactionCalculator("P2POffnetTransfer", map.get(FromUserName).toString(),
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

	public void P2pTouser(Map<Object, Object> map) {	
		try {
			String message = DBUtils.getValuefromMessage(map.get(ToUserName).toString());
			if(message.contains(map.get(FromUserName).toString()) && message.contains(map.get(Amount).toString())) {
				setLogSteps(this.log, "Successfully verified P2POffnet notification in Database for to user: " + map.get(ToUserName).toString());
			}
		} catch (SQLException e) {
			setLogSteps(this.log, "Unable to do verification for ToUser in DB");
		}
	}
}
