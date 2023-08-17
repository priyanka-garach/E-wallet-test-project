package portals.pages.Customer;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.Customer.CashOutPageOperations;
import utils.DBUtils;
import utils.elasticUtils.elasticwrite;

public class CashOutPage extends SetupInit {
	CashOutPageOperations cashOutOperations;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public CashOutPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		cashOutOperations = new CashOutPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public Map<Object, Object> cashOut(Map<Object, Object> map) {
		Map<Object, Object> data = new HashMap<Object, Object>();
		dashboardPageCommon.clickOnCheckBalance(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(password, 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(this.log, "Current Balance is: " + currentBalance);
		// double latestBalance = 0.0;
		// String transactionId = null;
		// cashOutOperations.selectType(map.get(Type).toString(), 0);
		dashboardPageCommon.enterAmount(map.get(Amount).toString(), 0);
		// dashboardPageCommon.sendTextInRemarks(map.get(Remarks).toString(), 0);
		dashboardPageCommon.enterSecretPIN(map.get(FromMpin).toString(), 0);
		cashOutOperations.clickOnServiceSubmitButton(0);
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
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount, map.get(Amount).toString())), 0);
				setLogSteps(this.log, "Verify Amount on Confirmation Screen: " + map.get(Amount).toString());
				dashboardPageCommon.clickOnConfirmButton(0);
				verifyVisible(dashboardPageCommon.verifyOTPSent, 0);
				/*
				 * setLogSteps(log, "Verify Transaction is Success"); verifyVisible(
				 * By.xpath(String.format(dashboardPageCommon.verifyMobileNumber,
				 * map.get(ToUserName).toString())), 0); setLogSteps(log,
				 * "Verify Mobile Number on Success Screen: " + map.get(ToUserName).toString());
				 * verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyRemarks,
				 * map.get(Remarks).toString())), 0); setLogSteps(log,
				 * "Verify Remarks on Success Screen: " + map.get(Remarks).toString());
				 * verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount,
				 * map.get(Amount).toString())), 0); setLogSteps(log,
				 * "Verify Amount on Success Screen: " + map.get(Amount).toString());
				 * latestBalance =
				 * Double.parseDouble(dashboardPageCommon.getMainBalanceAfterTransaction(0).trim
				 * ()); setLogSteps(this.log, "Updated Balance is: " + latestBalance);
				 * transactionId = dashboardPageCommon.getTransactionID(); setLogSteps(log,
				 * "Transaction ID is: " + transactionId); if (!(currentBalance >
				 * latestBalance)) { throw new RuntimeException("Before balance: " +
				 * currentBalance + " is > " + " After transaction balance" + latestBalance); }
				 */
			}
		}
		data.putAll(map);
		// data.put(TransactionID, transactionId);
		// data.put(UpdatedBal, latestBalance);
		data.put(ServiceName, "Withdraw Cash");
		/*
		 * String trnFile = ""; try { trnFile = setTransactionCalculator("CashOut",
		 * map.get(FromUserName).toString(), map.get(ToUserName).toString(),
		 * String.valueOf(currentBalance), map.get(Amount).toString(),
		 * map.get(FromSurchrge).toString(), map.get(FromCommission).toString(),
		 * map.get(ToSurcharge).toString(), map.get(ToCommission).toString(),
		 * transactionId, String.valueOf(latestBalance)); } catch (Exception e) {
		 * setLogSteps(this.log, "Unable to generate transaction verification file"); }
		 * data.put(TransactionFile, trnFile);
		 */
		return data;
	}

	public Map<Object, Object> cashOutfromAgentLogin(Map<Object, Object> map) {
		Map<Object, Object> data = new HashMap<Object, Object>();
		String OTPpin = "";
		dashboardPageCommon.clickOnCheckBalance(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(pin, 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		dashboardPageCommon.clickOnCheckBalance(0);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(this.log, "Current Balance is: " + currentBalance);
		// double latestBalance = 0.0;
		// String transactionId = null;
		dashboardPageCommon.enterMobileNumber(map.get(FromUserName).toString(), 0);
		try {
			OTPpin = DBUtils.getOTPforWithdrawCash();
		} catch (Exception e) {
			System.out.println("OTP not generated....");
		}
		dashboardPageCommon.otpPIN(OTPpin, 0);
		cashOutOperations.clickOnServiceSubmitButton(0);
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
				verifyVisible(By.xpath(
						String.format(dashboardPageCommon.verifyMobileNumber, map.get(FromUserName).toString())), 0);
				setLogSteps(this.log,
						"Verify Mobile Number on Confirmation Screen: " + map.get(FromUserName).toString());
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount, map.get(Amount).toString())), 0);
				setLogSteps(this.log, "Verify Amount on Confirmation Screen: " + map.get(Amount).toString());
				dashboardPageCommon.clickOnConfirmButton(0);
				// verifyVisible(dashboardPageCommon.verifyTransaction, 0);
				// setLogSteps(log, "Verify Transaction is Success");
				// verifyVisible(
				// By.xpath(String.format(dashboardPageCommon.verifyMobileNumber,
				// map.get(ToUserName).toString())),
				// 0);
				// setLogSteps(log, "Verify Mobile Number on Success Screen: " +
				// map.get(ToUserName).toString());
				// verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyRemarks,
				// map.get(Remarks).toString())),
				// 0);
				// setLogSteps(log, "Verify Remarks on Success Screen: " +
				// map.get(Remarks).toString());
				// verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount,
				// map.get(Amount).toString())), 0);
				// setLogSteps(log, "Verify Amount on Success Screen: " +
				// map.get(Amount).toString());
				// latestBalance =
				// Double.parseDouble(dashboardPageCommon.getMainBalanceAfterTransaction(0).trim());
				// setLogSteps(this.log, "Updated Balance is: " + latestBalance);
				// transactionId = dashboardPageCommon.getTransactionID();
				// setLogSteps(log, "Transaction ID is: " + transactionId);
				// if (!(currentBalance > latestBalance)) {
				// throw new RuntimeException("Before balance: " + currentBalance + " is > "
				// + " After transaction balance" + latestBalance);
				// }
			}
		}
		data.putAll(map);
		// data.put(TransactionID, transactionId);
		// data.put(UpdatedBal, latestBalance);
		// data.put(ServiceName, "Cash Out Thr. Agent");
		// String trnFile = "";
		// try {
		// trnFile = setTransactionCalculator("CashOut",
		// map.get(FromUserName).toString(),
		// map.get(ToUserName).toString(), String.valueOf(currentBalance),
		// map.get(Amount).toString(),
		// map.get(FromSurchrge).toString(), map.get(FromCommission).toString(),
		// map.get(ToSurcharge).toString(), map.get(ToCommission).toString(),
		// transactionId,
		// String.valueOf(latestBalance));
		// } catch (Exception e) {
		// setLogSteps(this.log, "Unable to generate transaction verification file");
		// }
		// data.put(TransactionFile, trnFile);
		return data;
	}

	public Map<Object, Object> agentCashOut(Map<Object, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
}
