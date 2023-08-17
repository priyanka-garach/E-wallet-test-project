package portals.pages.Customer;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.Customer.WithdrawCashPageOperations;
import utils.DBUtils;
import utils.elasticUtils.elasticwrite;

public class WithdrawCashPage extends SetupInit {
	WithdrawCashPageOperations cashOutOperations;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public WithdrawCashPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		cashOutOperations = new WithdrawCashPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public Map<Object, Object> WithdrawCash(Map<Object, Object> map) {

		openNewTabInBrowser();
		String parentTab = getMainWindow();
		switchToTab();
		//String childTab = getMainWindow();
		common.webPortalLoginforNewTab(map, "to", 0);
		cashOutOperations.clickOntxtAgentAssistedWithdrawfromDashboard();
		Map<Object, Object> data = new HashMap<Object, Object>();
		String OTPpin = "";
		dashboardPageCommon.clickOnCheckBalance(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(map.get(FromMpin).toString(), 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		pauseInSeconds(2);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(this.log, "Current Balance is: " + currentBalance);
		double latestBalance = 0.0;
		String transactionId = null;
		dashboardPageCommon.enterMobileNumber(map.get(FromUserName).toString(), 0);
		switchToMainTab(parentTab);
		dashboardPageCommon.enterAmount(map.get(Amount).toString(), 0);
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
				switchToTab();

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
								String.format(dashboardPageCommon.verifyfromCashout, map.get(FromUserName).toString())),
								0);
						setLogSteps(this.log,
								"Verify Mobile Number on Confirmation Screen: " + map.get(FromUserName).toString());
						verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyagentcashoutAmount,
								map.get(Amount).toString())), 0);
						setLogSteps(this.log, "Verify Amount on Confirmation Screen: " + map.get(Amount).toString());
						dashboardPageCommon.sendTextInRemarks(map.get(Remarks).toString(), 0);
						dashboardPageCommon.enterSecretPIN(map.get(ToMpin).toString(), null);
						cashOutOperations.clickOnServiceSubmitButton(0);
						pauseInSeconds(3);
						
						dashboardPageCommon.clickOnConfirmButton(0);

						setLogSteps(log, "Verify Transaction is Success");
						pauseInSeconds(2);
					
						latestBalance = Double
								.parseDouble(dashboardPageCommon.getMainBalanceAfterTransaction(0).trim());
						transactionId = dashboardPageCommon.getTransactionID();
						setLogSteps(this.log, "Updated Balance is: " + latestBalance);

					}
				}
				data.putAll(map);
				data.put(TransactionID, transactionId);
				data.put(UpdatedBal, latestBalance);
				data.put(ServiceName, "");
			}
			cashOutOperations.clickOnLogoutButton(0);
			pauseInSeconds(3);
			closeCurrentTab(parentTab);
			switchToMainTab(parentTab);
		}
		return data;
		
	}

	public Map<Object, Object> WithdrawCashFromFooter(Map<Object, Object> map) {

		openNewTabInBrowser();
		String parentTab = getMainWindow();
		switchToTab();
		common.webPortalLoginforNewTab(map, "to", 0);
		cashOutOperations.clickOntxtAgentAssistedWithdrawFromFooter();
		Map<Object, Object> data = new HashMap<Object, Object>();
		String OTPpin = "";
		dashboardPageCommon.clickOnCheckBalance(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(map.get(FromMpin).toString(), 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		pauseInSeconds(2);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(this.log, "Current Balance is: " + currentBalance);
		double latestBalance = 0.0;
		String transactionId = null;
		dashboardPageCommon.enterMobileNumber(map.get(FromUserName).toString(), 0);
		switchToMainTab(parentTab);
		dashboardPageCommon.enterAmount(map.get(Amount).toString(), 0);
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
				switchToTab();

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
								String.format(dashboardPageCommon.verifyfromCashout, map.get(FromUserName).toString())),
								0);
						setLogSteps(this.log,
								"Verify Mobile Number on Confirmation Screen: " + map.get(FromUserName).toString());
						verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyagentcashoutAmount,
								map.get(Amount).toString())), 0);
						setLogSteps(this.log, "Verify Amount on Confirmation Screen: " + map.get(Amount).toString());
						dashboardPageCommon.sendTextInRemarks(map.get(Remarks).toString(), 0);
						dashboardPageCommon.enterSecretPIN(map.get(ToMpin).toString(), null);
						cashOutOperations.clickOnServiceSubmitButton(0);
						pauseInSeconds(3);
						
						dashboardPageCommon.clickOnConfirmButton(0);

						setLogSteps(log, "Verify Transaction is Success");
						pauseInSeconds(2);
					
						latestBalance = Double
								.parseDouble(dashboardPageCommon.getMainBalanceAfterTransaction(0).trim());
						transactionId = dashboardPageCommon.getTransactionID();
						setLogSteps(this.log, "Updated Balance is: " + latestBalance);

					}
				}
				data.putAll(map);
				data.put(TransactionID, transactionId);
				data.put(UpdatedBal, latestBalance);
				data.put(ServiceName, "");
			}
			cashOutOperations.clickOnLogoutButton(0);
			pauseInSeconds(3);
			closeCurrentTab(parentTab);
			switchToMainTab(parentTab);
		}
		return data;
		
	}
	
	public Map<Object, Object> WithdrawCashFromSideMenu(Map<Object, Object> map) {

		openNewTabInBrowser();
		String parentTab = getMainWindow();
		switchToTab();
		common.webPortalLoginforNewTab(map, "to", 0);
		cashOutOperations.clickOntxtAgentAssistedWithdrawFromSideMenu();
		Map<Object, Object> data = new HashMap<Object, Object>();
		String OTPpin = "";
		dashboardPageCommon.clickOnCheckBalance(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(map.get(FromMpin).toString(), 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		pauseInSeconds(2);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(this.log, "Current Balance is: " + currentBalance);
		double latestBalance = 0.0;
		String transactionId = null;

		dashboardPageCommon.enterMobileNumber(map.get(FromUserName).toString(), 0);
		switchToMainTab(parentTab);
		dashboardPageCommon.enterAmount(map.get(Amount).toString(), 0);
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
				switchToTab();

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
								String.format(dashboardPageCommon.verifyfromCashout, map.get(FromUserName).toString())),
								0);
						setLogSteps(this.log,
								"Verify Mobile Number on Confirmation Screen: " + map.get(FromUserName).toString());
						verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyagentcashoutAmount,
								map.get(Amount).toString())), 0);
						setLogSteps(this.log, "Verify Amount on Confirmation Screen: " + map.get(Amount).toString());
						dashboardPageCommon.sendTextInRemarks(map.get(Remarks).toString(), 0);
						dashboardPageCommon.enterSecretPIN(map.get(ToMpin).toString(), null);
						cashOutOperations.clickOnServiceSubmitButton(0);
						pauseInSeconds(3);
						
						dashboardPageCommon.clickOnConfirmButton(0);

						setLogSteps(log, "Verify Transaction is Success");
						pauseInSeconds(2);
					
						latestBalance = Double
								.parseDouble(dashboardPageCommon.getMainBalanceAfterTransaction(0).trim());
						transactionId = dashboardPageCommon.getTransactionID();
						setLogSteps(this.log, "Updated Balance is: " + latestBalance);

					}
				}
				data.putAll(map);
				data.put(TransactionID, transactionId);
				data.put(UpdatedBal, latestBalance);
				data.put(ServiceName, "");
			}
			cashOutOperations.clickOnLogoutButton(0);
			pauseInSeconds(3);
			closeCurrentTab(parentTab);
			switchToMainTab(parentTab);
		}
		return data;
		
	}
	
	public Map<Object, Object> WithdrawCashAgenttoAgent(Map<Object, Object> map) {
		Map<Object, Object> data = new HashMap<Object, Object>();
		String OTPpin = "";
		dashboardPageCommon.clickOnCheckBalance(0);
		dashboardPageCommon.enterSecretPINtocheckbalance(map.get(FromMpin).toString(), 0);
		dashboardPageCommon.clickOnChkBalanceSubmitButton(0);
		pauseInSeconds(2);
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
		data.put(ServiceName, "Withdraw Cash");
		String trnFile = "";
		try {
			trnFile = setTransactionCalculator("Withdraw Cash", map.get(FromUserName).toString(),
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

	public void Logout(Map<Object, Object> map) {
		common.webPortalLogin(map, "From", 0);
		
	}
	
	

	
}
