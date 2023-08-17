package portals.pages.Common;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.Utility;
import utils.elasticUtils.elasticwrite;

public class DashboardPage extends SetupInit {
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public DashboardPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		dashboardPageCommon = new DashBoardPageOperations(this.driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void changeMPIN(Map<Object, Object> map) {
		dashboardPageCommon.enterCurrentMPin(map.get(SecretPIN).toString(), 0);
		dashboardPageCommon.enterNewMpin(map.get(NewSecretPIN).toString(), 0);
		dashboardPageCommon.enterConfirmNewMpin(map.get(NewSecretPIN).toString(), 0);
		dashboardPageCommon.clickOnCommonSubmitButton(0);
		if (verifyVisible(dashboardPageCommon.alert, 5)) {
			setLogSteps(this.log, getElementText(this.log, dashboardPageCommon.alert, 5));
			dashboardPageCommon.clickOnCloseButton(0);
		}
	}

	public void verifyChangeMPIN() {
		dashboardPageCommon.verifySuccessLogo(0);
	}

	public String verifyCashOut(Map<Object, Object> map) {
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount, map.get(Amount).toString())), 0);
		setLogSteps(this.log, "Verify Amount on Success Screen : " + map.get(Amount).toString());
		String transactionId = dashboardPageCommon.getTransactionID();
		String code = getElementText(this.log, dashboardPageCommon.code, 5);
		setLogSteps(this.log, "Cash Out Success Code is : " + code);
		return transactionId;
	}

	public void resetMPIN(Map<Object, Object> map) {
		verifyVisible(dashboardPageCommon.resetPinLabel, 0);
		setLogSteps(log, "Verify OTP Screen Is Present</b>");
	}

	public void verifyResetMPIN() {
		dashboardPageCommon.verifySuccessLogo(0);
	}

	public void verifyProfileDetails(Map<Object, Object> map) {
		String[] aggregators = map.get(ProfileDetails).toString().split("/");
		for (int i = 0; i < aggregators.length; i++) {
			String[] singleAggregatorValues = aggregators[i].split(";");
			String[] values = singleAggregatorValues[1].split(",");
			for (int j = 0; j < values.length; j++) {
				String[] value = values[j].split(":");
				dashboardPageCommon.openAggregator(singleAggregatorValues[0], 0);
				dashboardPageCommon.verifyDetails(singleAggregatorValues[0], value[0], value[1]);
				if (j == values.length - 1)
					dashboardPageCommon.closeAggregator(singleAggregatorValues[0], 0);
			}
		}
	}

	public void callSupport(Map<Object, Object> map) {
		dashboardPageCommon.selectRequestType(map.get(RequestType).toString());
		dashboardPageCommon.enterMessage(map.get(Message).toString());
		dashboardPageCommon.clickOnCommonSubmitButton(0);
	}

	public void verifyCallSupport(Map<Object, Object> map) {
		dashboardPageCommon.verifySuccessLogo(0);
		String message = getElementText(this.log, dashboardPageCommon.successMessage, 5);
		setLogSteps(this.log, message);
	}

	public void changePassword(Map<Object, Object> map) {
		dashboardPageCommon.enterCurrentPassword(map.get(Password).toString(), 0);
		dashboardPageCommon.enterNewPassword(map.get(NewPassword).toString(), 0);
		dashboardPageCommon.enterConfirmNewPassword(map.get(NewPassword).toString(), 0);
		dashboardPageCommon.clickOnCommonSubmitButton(0);
	}

	public void verifyChangePassword() {
		dashboardPageCommon.verifySuccessLogo(0);
	}

	public void support(Map<Object, Object> map) {
		dashboardPageCommon.selectRequestType(map.get(RequestType).toString(), 0);
		dashboardPageCommon.enterMessage(map.get(Message).toString(), 0);
		dashboardPageCommon.clickOnCommonSubmitButton(0);
		// dashboardPageCommon.clickOnConfirmBtn(0);
	}

	public void verifySupport(Map<Object, Object> map) {
		verifyVisible(dashboardPageCommon.verifySupport, 0);
		setLogSteps(log, "Verify Support Detail");
	}

	public void walletBalance(Map<Object, Object> map) {
		setLogSteps(log, "Wallet Balance is:" + getElementText(log, dashboardPageCommon.getTextofMainwallet, 0));
		setLogSteps(log, "Loyalty Points is:" + getElementText(log, dashboardPageCommon.getTextofLoylatyPoint, 0));
		pauseInSeconds(2);
	}

	public String verifyBuyQPower(Map<Object, Object> map) {
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyNickName, map.get(NickName).toString())), 0);
		setLogSteps(this.log, "Verify Nick Name on Confirmation Screen: " + map.get(NickName).toString());
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyRemarks, map.get(Remarks).toString())), 0);
		setLogSteps(this.log, "Verify Remarks on Success Screen: " + map.get(Remarks).toString());
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount, map.get(Amount).toString())), 0);
		setLogSteps(this.log, "Verify Amount on Success Screen: " + map.get(Amount).toString());
		String transactionId = dashboardPageCommon.getTransactionID();
		setLogSteps(log, "Transaction ID is: " + transactionId);
		return transactionId;
	}

	public void verifyBalanceAndPoints(Map<Object, Object> map) {
		dashboardPageCommon.clickOnCheckBalance(0);
		dashboardPageCommon.getMainBalance(0);
		dashboardPageCommon.getPointsEarn(0);
	}

	public void verifyQRcodeData(Map<Object, Object> map) {
		dashboardPageCommon.isQRCodePopupOpened(0);
		dashboardPageCommon.verifyUserNameInQRCode(map.get(QRUserName).toString(), 0);
		dashboardPageCommon.verifyUserNameInQRCode(map.get(QRNumber).toString(), 0);
	}

	public void verifyGetLastQPowerToken() {
		verifyVisible(dashboardPageCommon.getLastQPowerToken, 0);
		setLogSteps(log, "Verify Get Last QPower Token");
		dashboardPageCommon.verifySuccessLogo(0);
		reloadCurrentPage();
	}

	public void AddManageBeneficiary(Map<Object, Object> map) {
		if (veifyElementIsNotVisible(
				By.xpath(String.format(dashboardPageCommon.verifyBeneficiaryName, map.get(NickName).toString())), 5)) {
			setLogSteps(log, "Verify Manage Beneficiary is display" + map.get(NickName).toString());
			dashboardPageCommon.clickOnAddBeneficiary(0);
			dashboardPageCommon.sendTextInNickName(map.get(NickName).toString(), 0);
			dashboardPageCommon.sendTextInMeterNumber(map.get(MeterNumber).toString(), 0);
			dashboardPageCommon.selectStatus(map.get(Status).toString(), 0);
			dashboardPageCommon.clickOnCommonSubmitButton(0);
		}
	}

	public void EditManageBeneficiary(Map<Object, Object> map) {
		if (verifyVisible(
				By.xpath(String.format(dashboardPageCommon.verifyBeneficiaryName, map.get(NickName).toString())), 0)) {
			setLogSteps(log, "Verify Manage Beneficiary is display" + map.get(NickName).toString());
			dashboardPageCommon.clickOnElement(
					By.xpath(String.format(dashboardPageCommon.verifyBeneficiaryName, map.get(NickName).toString())),
					0);
			setLogSteps(log, "Click On " + map.get(NickName).toString());
			dashboardPageCommon.clickOnEditButton(0);
			dashboardPageCommon.sendTextInNickName(map.get(NickName).toString(), 0);
			dashboardPageCommon.selectStatus(map.get(Status).toString(), 0);
			dashboardPageCommon.clickOnCommonSubmitButton(0);
		}
	}

	public boolean DeleteManageBeneficiary(Map<Object, Object> map) {
		if (verifyVisible(
				By.xpath(String.format(dashboardPageCommon.verifyBeneficiaryName, map.get(NickName).toString())), 5)) {
			setLogSteps(log, "Verify Manage Beneficiary is display" + map.get(NickName).toString());
			dashboardPageCommon.clickOnElement(
					By.xpath(String.format(dashboardPageCommon.verifyBeneficiaryName, map.get(NickName).toString())),
					0);
			setLogSteps(log, "Click On " + map.get(NickName).toString());
			dashboardPageCommon.clickOnDeleteButton(0);
			return true;
		} else {
			setLogSteps(log, "Record already deleted" + map.get(NickName).toString());
			return false;
		}
	}

	public void verifyRecentTransactions() {
		clickOnElement(dashboardPageCommon.clickOnLogo, 0);
		moveToElement(dashboardPageCommon.verifyRecentTransactionLabel);
		verifyVisible(dashboardPageCommon.verifyRecentTransactionLabel, 0);
		setLogSteps(log, "Verify Recent Transactions");
		List<WebElement> element = getElementList(dashboardPageCommon.recentTransaction, 0);
		int total = element.size();
		for (int i = 1; i <= total; i++) {
			isPresent(By.xpath(String.format(dashboardPageCommon.verifyRecentTransaction, i)), 0);
		}
		reloadCurrentPage();
	}

	public void selectPassbookFilter(Map<Object, Object> map) {
		dashboardPageCommon.clickOnFilterButton(0);
		// dashboardPageCommon.clickOnClearButton(0);
		if (!map.get(Durations).toString().isEmpty()) {
			dashboardPageCommon.SelectDurationFilter(map.get(Durations).toString(), 0);
		}
		if (!map.get(Status).toString().isEmpty()) {
			dashboardPageCommon.SelectStatusFilter(map.get(Status).toString(), 0);
		}
		if (!map.get(Services).toString().isEmpty()) {
			dashboardPageCommon.SelectServiceFilter(map.get(Services).toString(), 0);
		}
		dashboardPageCommon.clickOnCommonSubmitButton(0);
	}

	public void verifyPassbook(Map<Object, Object> map) {

		if (verifyVisible(dashboardPageCommon.noRecords, 3)) {
			setLogSteps(log, "No Records Found");
		} else {
			if (!map.get(Status).toString().isEmpty()) {
				List<WebElement> element = getElementList(
						By.xpath(String.format(dashboardPageCommon.verifyStatus, map.get(Status).toString())), 0);
				int total = element.size();
				for (int i = 1; i <= total; i++) {
					verifyVisible(
							By.xpath(String.format(dashboardPageCommon.verifyAllStatus, map.get(Status).toString(), i)),
							0);
					setLogSteps(log, "Verify Transaction Status is: " + map.get(Status).toString());
				}
			}
			if (!map.get(Services).toString().isEmpty()) {
				List<WebElement> element = getElementList(
						By.xpath(String.format(dashboardPageCommon.verifyServices, map.get(Services).toString())), 0);
				int total = element.size();
				for (int i = 1; i <= total; i++) {
					verifyVisible(By.xpath(
							String.format(dashboardPageCommon.verifyAllServices, map.get(Services).toString(), i)), 0);
					setLogSteps(log, "Verify Transaction Service is: " + map.get(Services).toString());
				}
			}
			verifyVisible(dashboardPageCommon.verifyTable, 0);
			setLogSteps(log, "Verify Transaction Table");
			reloadCurrentPage();
		}
	}

	public void verifyPassbookSearch(Map<Object, Object> map) {
		/*
		 * dashboardPageCommon.clickOnSearchButton(0);
		 * dashboardPageCommon.sendTextInSearch(map.get(TransactionID).toString( ), 0);
		 */
		if (verifyVisible(dashboardPageCommon.noRecords, 3)) {
			setLogSteps(log, "No Records Found of Transaction ID:" + map.get(TransactionID).toString());
		} else {
			List<WebElement> element = getElementList(
					By.xpath(String.format(dashboardPageCommon.verifyTransactionID, map.get(TransactionID).toString())),
					0);
			int total = element.size();
			for (int i = 1; i <= total; i++) {
				verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAllTransactionID,
						map.get(TransactionID).toString(), i)), 0);
				setLogSteps(log, "Verify Transaction ID is: " + map.get(TransactionID).toString());

			}
		}
		reloadCurrentPage();
	}

	public void verifyAddedManageBeneficiary(Map<Object, Object> map) {
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyBeneficiaryName, map.get(NickName).toString())),
				0);
		setLogSteps(log, " Verify Nick Name : " + map.get(NickName).toString());
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyMeterNumber, map.get(MeterNumber).toString())),
				0);
		setLogSteps(log, " Verify Meter Number : " + map.get(MeterNumber).toString());
		// verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyBeneficiaryStatus,
		// map.get(NickName).toString(),
		// map.get(Status).toString())), 0);
		// setLogSteps(log, " Verify Status Of Beneficiary : " +
		// map.get(Status).toString());
	}

	public void verifyEditedManageBeneficiary(Map<Object, Object> map) {
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyBeneficiaryName, map.get(NickName).toString())),
				0);
		setLogSteps(log, " Verify Beneficiary Nick Name : " + map.get(NickName).toString());
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyBeneficiaryStatus, map.get(NickName).toString(),
				map.get(Status).toString())), 0);
		setLogSteps(log, " Verify Beneficiary Status : " + map.get(Status).toString());
		verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyBeneficiaryName, map.get(NickName).toString())),
				0);
	}

	public boolean verifyDeletedManageBeneficiary(Map<Object, Object> map) {
		if (verifyVisible(
				By.xpath(String.format(dashboardPageCommon.verifyBeneficiaryName, map.get(NickName).toString())), 3)) {
			setLogSteps(log, "Beneficiary not Deleted: " + map.get(NickName).toString());
			return false;
		}
		setLogSteps(log, "Beneficiary Deleted Sucessfully: " + map.get(NickName).toString());
		return true;
	}

	public void verifyFAQS(Map<Object, Object> map) {

	}

	public void verifyCheckQMoneyPoints(Map<Object, Object> map) {
		verifyVisible(dashboardPageCommon.verifyQmoneyPointOpen, 0);
		setLogSteps(log, "QMoney Point is:" + getElementText(log, dashboardPageCommon.getTextofQMOneyPoint, 0));
		// reloadCurrentPage();
	}

	public void verifyRedeemQMoneyPoints(Map<Object, Object> map) {
		if (!map.get(SelectRedemption).toString().toLowerCase().equals("merchandise")) {
			verifyVisible(dashboardPageCommon.verifyTransaction, 0);
			String transactionId = dashboardPageCommon.getTransactionID();
			setLogSteps(log, "Transaction ID is: " + transactionId);
			clickOnElement(dashboardPageCommon.clickOnPassbook, 0);
			dashboardPageCommon.verifyTransactionStatus(transactionId, 0);
		}
	}

	public void bLinkBankAccount(Map<Object, Object> map) {
		dashboardPageCommon.selectBank(map.get(SelectBank).toString(), 0);
		dashboardPageCommon.clickOnLinkBankAccount(0);
		dashboardPageCommon.clickOnBLinkBankAccountNew(0);
		dashboardPageCommon.sendTextInBLinkAccountNumber(map.get(AccountNumber).toString(), 0);
		if (!map.get(TINNumber).toString().isEmpty()) {
			dashboardPageCommon.enterBLinkTINNumber(map.get(TINNumber).toString(), 0);
		}
		dashboardPageCommon.sendTextInBLinkNickName(map.get(NickName).toString(), 0);
		dashboardPageCommon.enterSecretPIN(pin, 0);
		dashboardPageCommon.clickOnSubmitBtn(0);
	}

	public void verifyBLinkBankAccount(Map<Object, Object> map) {
		verifyVisible(dashboardPageCommon.verifyOTPScreen, 0);
		setLogSteps(log, "Verify OTP Screen - Enter OTP");
	}

	public void bLinkBankAccountEdit(Map<Object, Object> map) {
		dashboardPageCommon.selectBank(map.get(SelectBank).toString(), 0);
		dashboardPageCommon.clickOnLinkBankAccount(0);
		// dashboardPageCommon.selectBankForManage(map.get(NickName).toString(),
		// map.get(AccountNumber).toString(), 0);
		// dashboardPageCommon.clickOnEditBtn(0);
		// dashboardPageCommon.sendTextInNickNameInEdit(map.get(NewNickName).toString(),
		// 0);
		// dashboardPageCommon.enterSecretPIN(pin, 0);
		// dashboardPageCommon.clickOnSaveBtn(0);
	}

	public void verifyBLinkBankAccountEdit(Map<Object, Object> map) {
		// verifyVisible(dashboardPageCommon.verifyOTPScreen, 0);
		// setLogSteps(log, "Verify OTP Screen - Enter OTP");
	}

	public void bLinkBankAccountDelete(Map<Object, Object> map) {
		dashboardPageCommon.selectBank(map.get(SelectBank).toString(), 0);
		dashboardPageCommon.clickOnLinkBankAccount(0);
		// dashboardPageCommon.selectBankForManage(map.get(NickName).toString(),
		// map.get(AccountNumber).toString(), 0);
		// dashboardPageCommon.clickOnDeleteBtn(0);
		// dashboardPageCommon.enterSecretPIN(pin, 0);
		// dashboardPageCommon.clickOnSaveBtn(0);
	}

	public void verifyBLinkBankAccountDelete(Map<Object, Object> map) {
		// verifyVisible(dashboardPageCommon.verifyOTPScreen, 0);
		// setLogSteps(log, "Verify OTP Screen - Enter OTP");
	}

	public void bLinkBalanceInquiry(Map<Object, Object> map) {
		dashboardPageCommon.selectBank(map.get(SelectBank).toString(), 0);
		dashboardPageCommon.clickOnBankBalanceInquiry(0);
		// dashboardPageCommon.selectBankForManage(map.get(NickName).toString(),
		// map.get(AccountNumber).toString(), 0);
		// dashboardPageCommon.enterSecretPIN(pin, 0);
		// dashboardPageCommon.clickOnSubmitButton(0);
	}

	public void verifyBLinkBalanceInquiry(Map<Object, Object> map) {
		// dashboardPageCommon.verifySuccessLogo(0);
	}

	public void bLinkTransferToBank(Map<Object, Object> map) {
		dashboardPageCommon.clickOnCheckBalance(0);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(log, "Current Balance is: " + currentBalance);
		dashboardPageCommon.selectBank(map.get(SelectBank).toString(), 0);
		dashboardPageCommon.clickOnTransferToBank(0);
		// dashboardPageCommon.selectBankForManage(map.get(NickName).toString(),
		// map.get(AccountNumber).toString(), 0);
		// if (map.get(TransactionType).toString().equalsIgnoreCase("negative"))
		// {
		// dashboardPageCommon
		// .enterAmount(String.valueOf(currentBalance +
		// Double.parseDouble(map.get(Amount).toString())));
		// } else {
		// dashboardPageCommon.enterAmount(map.get(Amount).toString(), 0);
		// }
		// dashboardPageCommon.sendTextInRemarks(map.get(Remarks).toString(),
		// 0);
		// dashboardPageCommon.enterSecretPIN(pin, 0);
		// dashboardPageCommon.clickOnSubmitBtn(0);
		// if (verifyVisible(dashboardPageCommon.insufficientBalanceText, 5)) {
		// setLogSteps(this.log, getElementText(this.log,
		// dashboardPageCommon.insufficientBalanceText, 5));
		// map.put("validation", true);
		// } else {
		// map.put("validation", false);
		// if (verifyVisible(dashboardPageCommon.alert, 5)) {
		// setLogSteps(this.log, getElementText(this.log,
		// dashboardPageCommon.alert, 5));
		// dashboardPageCommon.clickOnCloseButton(0);
		// } else {
		// verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount,
		// map.get(Amount).toString())), 0);
		// setLogSteps(this.log, "Verify Amount on Confirmation Screen: " +
		// map.get(Amount).toString());
		// verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyRemarks,
		// map.get(Remarks).toString())),
		// 0);
		// setLogSteps(this.log, "Verify Remarks on Confirmation Screen: " +
		// map.get(Remarks).toString());
		// dashboardPageCommon.clickOnConfirmBtn(0);
		// dashboardPageCommon.verifySuccessLogo(0);
		// double latestBalance =
		// Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		// setLogSteps(log, "Updated Balance is: " + latestBalance);
		// if (!(currentBalance > latestBalance)) {
		// throw new RuntimeException("Before balance: " + currentBalance + " is
		// > "
		// + " After transaction balance" + latestBalance);
		// }
		// }
		// }
	}

	public String verifyBLinkTransferToBank(Map<Object, Object> map) {
		String transactionId = dashboardPageCommon.getTransactionID();
		setLogSteps(log, "Transaction ID is: " + transactionId);
		return transactionId;
	}

	public void bLinkTransferFromBank(Map<Object, Object> map) {
		dashboardPageCommon.clickOnCheckBalance(0);
		double currentBalance = Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		setLogSteps(log, "Current Balance is: " + currentBalance);
		dashboardPageCommon.selectBank(map.get(SelectBank).toString(), 0);
		dashboardPageCommon.clickOnTransferFromBank(0);
		// dashboardPageCommon.selectBankForManage(map.get(NickName).toString(),
		// map.get(AccountNumber).toString(), 0);
		// if (map.get(TransactionType).toString().equalsIgnoreCase("negative"))
		// {
		// dashboardPageCommon
		// .enterAmount(String.valueOf(currentBalance +
		// Double.parseDouble(map.get(Amount).toString())));
		// } else {
		// dashboardPageCommon.enterAmount(map.get(Amount).toString(), 0);
		// }
		// dashboardPageCommon.sendTextInRemarks(map.get(Remarks).toString(),
		// 0);
		// dashboardPageCommon.enterSecretPIN(pin, 0);
		// dashboardPageCommon.clickOnSubmitBtn(0);
		// if (verifyVisible(dashboardPageCommon.insufficientBalanceText, 5)) {
		// setLogSteps(this.log, getElementText(this.log,
		// dashboardPageCommon.insufficientBalanceText, 5));
		// map.put("validation", true);
		// } else {
		// map.put("validation", false);
		// if (verifyVisible(dashboardPageCommon.alert, 5)) {
		// setLogSteps(this.log, getElementText(this.log,
		// dashboardPageCommon.alert, 5));
		// dashboardPageCommon.clickOnCloseButton(0);
		// } else {
		// verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyAmount,
		// map.get(Amount).toString())), 0);
		// setLogSteps(this.log, "Verify Amount on Confirmation Screen: " +
		// map.get(Amount).toString());
		// verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyRemarks,
		// map.get(Remarks).toString())),
		// 0);
		// setLogSteps(this.log, "Verify Remarks on Confirmation Screen: " +
		// map.get(Remarks).toString());
		// dashboardPageCommon.clickOnConfirmBtn(0);
		// dashboardPageCommon.verifySuccessLogo(0);
		// double latestBalance =
		// Double.parseDouble(dashboardPageCommon.getMainBalance(0).trim());
		// setLogSteps(log, "Updated Balance is: " + latestBalance);
		// if (!(currentBalance > latestBalance)) {
		// throw new RuntimeException("Before balance: " + currentBalance + " is
		// > "
		// + " After transaction balance" + latestBalance);
		// }
		// }
		// }
	}

	public String verifyBLinkTransferFromBank(Map<Object, Object> map) {
		String transactionId = dashboardPageCommon.getTransactionID();
		setLogSteps(log, "Transaction ID is: " + transactionId);
		return transactionId;
	}

	public void verifyReceivePayment() {
		dashboardPageCommon.verifySuccessLogo(0);
	}

	public String verifyMerchantSettlement(Map<Object, Object> map) {
		String transactionId = dashboardPageCommon.getTransactionID();
		setLogSteps(this.log, "Transaction ID is: " + transactionId);
		return transactionId;
	}

	public boolean registerCustomer(Map<Object, Object> map) {
		String[] navigationList = map.get(Navigation).toString().split("/");
		for (int i = 0; i < navigationList.length; i++) {
			if (i == 0) {
				String phone = String.valueOf(Utility.getRandomInt(11111, 99999))
						+ String.valueOf(Utility.getRandomInt(11111, 99999));
				sendKeys(By.id("frm_text_PHONE_NUMBERid"), phone, 0);
			}
			// Dropdown data
			if (!map.get(Dropdown).toString().isEmpty()) {
				String[] pageWiseInput = map.get(Dropdown).toString().split("/");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyLabel, input[0].trim())),
								2)) {
							dashboardPageCommon.selctValueFromDropDown(input[0].trim(), input[1].trim(), 0);
						}
					}
				}
			}
			// String data
			if (!map.get(StringData).toString().isEmpty()) {
				String[] pageWiseInput = map.get(StringData).toString().split("/");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyLabel, input[0].trim())),
								2)) {
							dashboardPageCommon.sendTextInStringField(input[0].trim(), input[1].trim(), 0);
						}
					}
				}
			}
			// File Upload data
			if (!map.get(FileUpload).toString().isEmpty()) {
				String[] pageWiseInput = map.get(FileUpload).toString().split("/");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyLabel, input[0].trim())),
								2)) {
							dashboardPageCommon.enterFileUploadData(input[0].trim(), input[1].trim(), 0);
						}
					}
				}
			}

			// Date data
			if (!map.get(Date).toString().isEmpty()) {
				String[] pageWiseInput = map.get(Date).toString().split("####");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyLabel, input[0].trim())),
								2)) {
							dashboardPageCommon.selectDate(input[0].trim(), input[1].trim(), 0);
						}
					}
				}
			}
			if (i != navigationList.length - 1)
				dashboardPageCommon.clickOnNextButton(0);
			if (verifyVisible(dashboardPageCommon.errorMsg, 2)) {

				List<WebElement> errors = getElementList(dashboardPageCommon.errorMsg, 0);
				int size = errors.size();
				for (int e = 1; e <= size; e++) {
					WebElement t = findVisibleElement(By.xpath(String.format(dashboardPageCommon.errorMsgText, e)), 0);
					String message = getElementText(t, 0);
					setLogSteps(log, message);
				}
				return false;
			}

		}
		dashboardPageCommon.clickOnCommonSubmitButton(0);
		dashboardPageCommon.clickOnConfirmBtn(0);
		if (verifyVisible(dashboardPageCommon.alert, 5)) {
			setLogSteps(this.log, getElementText(this.log, dashboardPageCommon.alert, 5));
			dashboardPageCommon.clickOnCloseButton(0);
			return false;
		}
		return true;
	}

	public boolean assistantOnboarding(Map<Object, Object> map) {
		dashboardPageCommon.clickOnOnboardNewAssistant(0);
		String[] navigationList = map.get(Navigation).toString().split("/");
		for (int i = 0; i < navigationList.length; i++) {
			if (i == 0) {
				String phone = String.valueOf(Utility.getRandomInt(11111, 99999))
						+ String.valueOf(Utility.getRandomInt(11111, 99999));
				sendKeys(By.id("frm_text_PHONE_NUMBERid"), phone, 0);
			}
			// Dropdown data
			if (!map.get(Dropdown).toString().isEmpty()) {
				String[] pageWiseInput = map.get(Dropdown).toString().split("/");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyLabel, input[0].trim())),
								2)) {
							dashboardPageCommon.selctValueFromDropDown(input[0].trim(), input[1].trim(), 0);
						}
					}
				}
			}
			// String data
			if (!map.get(StringData).toString().isEmpty()) {
				String[] pageWiseInput = map.get(StringData).toString().split("/");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyLabel, input[0].trim())),
								2)) {
							dashboardPageCommon.sendTextInStringField(input[0].trim(), input[1].trim(), 0);
						}
					}
				}
			}
			// File Upload data
			if (!map.get(FileUpload).toString().isEmpty()) {
				String[] pageWiseInput = map.get(FileUpload).toString().split("/");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyLabel, input[0].trim())),
								2)) {
							dashboardPageCommon.enterFileUploadData(input[0].trim(), input[1].trim(), 0);
						}
					}
				}
			}

			// Date data
			if (!map.get(Date).toString().isEmpty()) {
				String[] pageWiseInput = map.get(Date).toString().split("####");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(dashboardPageCommon.verifyLabel, input[0].trim())),
								2)) {
							dashboardPageCommon.selectDate(input[0].trim(), input[1].trim(), 0);
						}
					}
				}
			}
			if (i != navigationList.length - 1)
				dashboardPageCommon.clickOnNextButton(0);
			// if (verifyVisible(dashboardPageCommon.errorMsg, 2)) {
			//
			// List<WebElement> errors =
			// getElementList(dashboardPageCommon.errorMsg, 0);
			// int size = errors.size();
			// for (int e = 1; e <= size; e++) {
			// WebElement t =
			// findVisibleElement(By.xpath(String.format(dashboardPageCommon.errorMsgText,
			// e)), 0);
			// String message = getElementText(t, 0);
			// setLogSteps(log, message);
			// }
			// return false;
			// }

		}
		dashboardPageCommon.clickOnCommonSubmitButton(0);
		dashboardPageCommon.clickOnConfirmBtn(0);
		if (verifyVisible(dashboardPageCommon.alert, 5)) {
			String message = getElementText(this.log, dashboardPageCommon.alert, 5);
			setLogSteps(this.log, message);
			dashboardPageCommon.clickOnCloseButton(0);
			if (message.contains("Account Identifier already exist")) {
				setLogSteps(this.log, "Account Identifier already exist");
				return true;
			} else {
				return false;
			}
		} else {
			dashboardPageCommon.verifySuccessLogo(0);
			setLogSteps(log, "Verify Onboarded Successfully");
			return true;
		}

	}

	public void verifyAssistantOnboarding() {
		dashboardPageCommon.verifySuccessLogo(0);
		verifyVisible(dashboardPageCommon.verifyOnboarding, 0);
		setLogSteps(log, "Verify Onboarded Successfully message is Present");
		reloadCurrentPage();
	}

	public void redeemSubcriberPoints(Map<Object, Object> map) {
		dashboardPageCommon.clickOnCheckBalance(0);
		String beforePoint = dashboardPageCommon.getPointsEarn(0);
		setLogSteps(log, "Current Earn Point is: " + beforePoint);
		dashboardPageCommon.sendTextInRedemptionCode(map.get(RedemptionCode).toString(), 0);
		dashboardPageCommon.ClickOnLinkGetRedemptionAmountAndName(3);
		dashboardPageCommon.sendTextInProdctToSell(map.get(ProductToSell).toString(), 0);
		dashboardPageCommon.sendTextInRemarks(map.get(ProductDescription).toString(), 0);
		dashboardPageCommon.enterSecretPIN(pin, 0);
		dashboardPageCommon.clickOnSubmitButton(0);
		// String afterPoints = dashboardPageCommon.getPointsEarn(0);
		// setLogSteps(log, "After Earn Point is: " + afterPoints);
		// if (beforePoint.equals(afterPoints)) {
		// throw new RuntimeException("Before Points: " + beforePoint + " is > "
		// + " After Points: " + afterPoints);
		// }
	}

	public void verifyRedeemSubcriberPoints() {
		dashboardPageCommon.verifySuccessLogo(0);
		reloadCurrentPage();
	}

	public void reports(Map<Object, Object> map) {
		if (map.get(Reports).toString().equals("Reseller Transaction Report")) {
			dashboardPageCommon.ClickOnResellerTransactionReport(0);
			dashboardPageCommon.clickOnFilterButton(0);
			// dashboardPageCommon.clickOnClearButton(0);
			dashboardPageCommon.SelectStartDate(map.get(StartDate).toString(), 0);
			dashboardPageCommon.SelectEndDate(map.get(EndDate).toString(), 0);
			if (!map.get(Assistant).toString().isEmpty()) {
				dashboardPageCommon.SelectAssistant(map.get(Assistant).toString(), 0);
			}
			if (!map.get(TxReference).toString().isEmpty()) {
				dashboardPageCommon.SendTextInTxReference(map.get(TxReference).toString(), 0);
			}
			dashboardPageCommon.clickOnSearchButtonForReport(0);
		} else if (map.get(Reports).toString().equals("My Float History")) {
			dashboardPageCommon.ClickOnMyFloatHistory(0);
			dashboardPageCommon.clickOnFilterButton(0);
			// dashboardPageCommon.clickOnClearButton(0);
			dashboardPageCommon.SelectStartDate(map.get(StartDate).toString(), 0);
			dashboardPageCommon.SelectEndDate(map.get(EndDate).toString(), 0);
			if (!map.get(TransactionFlag).toString().isEmpty()) {
				dashboardPageCommon.SelectTransactionFlag(TransactionFlag, 0);
			}
			dashboardPageCommon.clickOnSearchButtonForReport(0);
		} else if (map.get(Reports).toString().equals("Commission Summary")) {
			dashboardPageCommon.ClickOnCommissionSummary(0);
			dashboardPageCommon.clickOnFilterButton(0);
			// dashboardPageCommon.clickOnClearButton(0);
			dashboardPageCommon.SelectStartDate(map.get(StartDate).toString(), 0);
			dashboardPageCommon.SelectEndDate(map.get(EndDate).toString(), 0);
			dashboardPageCommon.clickOnSearchButtonForReport(0);
		} else if (map.get(Reports).toString().equals("Payment History")) {
			dashboardPageCommon.ClickOnPaymentHistory(0);
			dashboardPageCommon.clickOnFilterButton(0);
			// dashboardPageCommon.clickOnClearButton(0);
			dashboardPageCommon.SelectStartDate(map.get(StartDate).toString(), 0);
			dashboardPageCommon.SelectEndDate(map.get(EndDate).toString(), 0);
			dashboardPageCommon.clickOnSearchButtonForReport(0);
		}
	}

	public void verifyReport() {

		if (verifyVisible(dashboardPageCommon.noRecords, 3)) {
			setLogSteps(log, "No Records Found");
		} else {
			verifyVisible(dashboardPageCommon.verifyTable, 0);
			setLogSteps(log, "verify Transaction History Table");
		}
		reloadCurrentPage();
	}

	public void verifySuccessLogo() {
		dashboardPageCommon.verifySuccessLogo(0);
	}

	public void verifyDownloadPassbook() {
		dashboardPageCommon.clickOnPassbook(0);
		dashboardPageCommon.clickOnDownloadButton(0);
		common.verifyDownloadedFileWithExtension("passbook.csv");
		setLogSteps(this.log, "Verify Downloaded Passbook File");
	}

	public void verifyTransactionIDInPassbook(String transactionID) {
		dashboardPageCommon.clickOnPassbook(0);
		dashboardPageCommon.verifyTransactionStatus(transactionID, 0);
	}

	public void verifyAssistantOnboardingMerchant() {
		dashboardPageCommon.verifySuccessLogo(0);
		verifyVisible(dashboardPageCommon.verifyOnboardingMerchant, 0);
		setLogSteps(log, "Verify Onboarded Successfully message is Present");
		reloadCurrentPage();
	}

	/*
	 * public String checkBalance() { //dashboardPageCommon.clickOnViewBalance(5);
	 * clickOnElement(log, viewBalance, 2);
	 * dashboardPageCommon.clickOnRefreshBalance(0); return
	 * dashboardPageCommon.getBalance(0); }
	 */

	public void verifyChatOption() {
		dashboardPageCommon.isChatOptionsAvailable(0);
	}

	public void verifyUGX_SignAvailable() {
		dashboardPageCommon.UGX_textSignAvailable(0);
		dashboardPageCommon.clickOnPassbook(0);
		dashboardPageCommon.UGX_InPassbookSignAvailable();

	}

	public void passbookVerification(String serviceName, String trnId) {
		dashboardPageCommon.passbookVerification(serviceName, trnId);
	}
}