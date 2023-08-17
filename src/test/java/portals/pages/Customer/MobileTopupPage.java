package portals.pages.Customer;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.Customer.MobileTopupPageOperations;
import utils.elasticUtils.elasticwrite;

public class MobileTopupPage extends SetupInit {
	MobileTopupPageOperations mobileTopupOperations;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public MobileTopupPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		mobileTopupOperations = new MobileTopupPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public Map<Object, Object> mobileTopup(Map<Object, Object> map) {
		Map<Object, Object> data = new HashMap<Object, Object>();
		dashboardPageCommon.clickOnCheckBalance(0);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(this.log, "Current Balance is: " + currentBalance);
		double latestBalance = 0.0;
		String transactionId = null;
		mobileTopupOperations.selectTopupFor(map.get(TopupFor).toString(), 0);
		if (!map.get(MobileNumber).toString().isEmpty())
			dashboardPageCommon.enterMobileNumber(map.get(MobileNumber).toString(), 0);
		mobileTopupOperations.selectTopupAmount(map.get(Amount).toString(), 0);
		dashboardPageCommon.sendTextInRemarks(map.get(Remarks).toString(), 0);
		dashboardPageCommon.enterSecretPIN(password, 0);
		dashboardPageCommon.clickOnServiceSUBMITButton(0);
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
				if (!map.get(MobileNumber).toString().isEmpty())
					verifyVisible(By.xpath(
							String.format(dashboardPageCommon.verifyMobileNumber, map.get(MobileNumber).toString())),
							0);
				setLogSteps(this.log,
						"Verify Mobile Number on Confirmation Screen: " + map.get(MobileNumber).toString());
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyRemarks, map.get(Remarks).toString())),
						0);
				setLogSteps(this.log, "Verify Remarks on Confirmation Screen: " + map.get(Remarks).toString());
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount, map.get(Amount).toString())), 0);
				setLogSteps(this.log, "Verify Amount on Confirmation Screen: " + map.get(Amount).toString());
				dashboardPageCommon.clickOnConfirmButton(0);

//					verifyVisible(dashboardPageCommon.verifyTransaction, 0);
//					setLogSteps(log, "Verify Transaction is Success");
				latestBalance = Double.parseDouble(dashboardPageCommon.getMainBalanceAfterTransaction(0).trim());
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
		data.put(ServiceName, "Mobile Topup");
		String trnFile = "";
		try {
			trnFile = setTransactionCalculator("MobileTopup", map.get(FromUserName).toString(),
					map.get(MobileNumber).toString(), String.valueOf(currentBalance), map.get(Amount).toString(),
					map.get(FromSurchrge).toString(), map.get(FromCommission).toString(),
					map.get(ToSurcharge).toString(), map.get(ToCommission).toString(), transactionId,
					String.valueOf(latestBalance));
		} catch (Exception e) {
			setLogSteps(this.log, "Unable to generate transaction verification file");
		}
		data.put(TransactionFile, trnFile);
		return data;

	}

	public String verifyMobileTopup(Map<Object, Object> map) {
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyMobileNumber, map.get(ToUserName).toString())),
				0);
		setLogSteps(log, "Verify Mobile Number on Success Screen: " + map.get(ToUserName).toString());
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyRemarks, map.get(Remarks).toString())), 0);
		setLogSteps(log, "Verify Remarks on Success Screen: " + map.get(Remarks).toString());
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount, map.get(Amount).toString())), 0);
		setLogSteps(log, "Verify Amount on Success Screen: " + map.get(Amount).toString());
		String transactionId = dashboardPageCommon.getTransactionID();
		setLogSteps(log, "Transaction ID is: " + transactionId);
		dashboardPageCommon.clickOnPassbook(0);
		dashboardPageCommon.verifyTransactionStatus(transactionId, 0);
		return transactionId;
	}
}
