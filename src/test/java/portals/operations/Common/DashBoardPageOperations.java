package portals.operations.Common;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class DashBoardPageOperations extends SetupInit {
	// Edit profile locators
	By btnEdit = By.xpath("//*[text()='Edit']");
	String textData = "(.//label[text()='%s']//following::input[@type='text'])[1]";
	String uploadFileData = "(.//label[text()='%s']//following::input[@type='file'])[1]";
	By btnNext = By.xpath("//*[text()='Next']");
	By btnNEXTforLogin = By.xpath("//*[text()='NEXT' and @name='submit']");
	String drpArrow = "(.//label[text()='%s']//following::div[@class=' css-tlfecz-indicatorContainer'])[1]";
	// String txtdrp =
	// "(//label[text()='%s']//following::input[@id='react-select-3-input'])[1]";
	String txtdrp = "//*[text()='%s']";
	String inputDate = "(//label[text()='%s']//following::input[@type='date'])[1]";
	public String verifyLabel = "//label[text()='%s']";

	// Change Password Locators
	By changePassword = By.xpath("//*[text()='Change Password']");
	By changeMPin = By.xpath("//*[text()='Change MPIN']");
	By txtCurrentPassword = By.id("frm_text_oldPasswordid");
	By txtNewPassword = By.id("frm_text_passwordid");
	By txtConfirmNewPassword = By.id("frm_text_confirmpasswordid");
	By txtConfirmNewPassword_CapitalP = By.id("frm_text_confirmPasswordid");
	// Change MPIN locators
	By txtCurrentMpin = By.id("frm_text_oldTransactionPinid");
	By txtNewMpin = By.id("frm_text_transactionPinid");
	By txtConfirmNewMpin = By.id("frm_text_confirmTransactionPinid");
	By txtenterRegisteredMobileNumber = By.id("frm_text_userIdentifierid");
	public By btnSubmit = By.xpath("//button[text()='SUBMIT']");
	By btnCancel = By.xpath("//button[text()='Cancel']");
	By txtRemark = By.id("frm_text_Remarksid");
	By txtremark = By.id("frm_text_remarksid");
	By txtRegisteredMobileNumber = By.id("frm_text_usernameid");
	By txtMPINfromLogin = By.id("frm_text_passwordid");
	By txtSecretWord = By.id("frm_text_secretWordid");
	By txtConfirmSecretWord = By.id("frm_text_ConfirmSecretWordid");
	By txtveriyactivationSuccess = By
			.xpath("//*[normalize-space(text())='Activation process has been completed successfully']");
	By txtverifyMPINChangesucess = By.xpath("//*[normalize-space(text())='MPIN has been changed successfully']");
	By txtverifyPasswordSucess = By.xpath("//*[normalize-space(text())='Password has been changed successfully']");
	By txtverifySWChangesucess = By.xpath("//*[normalize-space(text())='Secret word has been changed successfully']");

	By btnBacktoLogin = By.xpath("//*[text()='Back To Login']");

	public By secretMpin = By.id("frm_text_transactionPinid");
	public By secretMpintoCheckBalance = By.id("otpid");
//	public By BalanceafterPaymentText = By.xpath("//p[contains(text(),'Balance after Payment (UGX)')]");
//	public By AvailableBalanceText = By.xpath("//p[contains(text(),'Available Balance (UGX)')]");
//	public By Amounttext  = By.xpath("//span[contains(text(),'Amount (UGX)')]");
	// Reset MPIN locators

	public By resetPinLabel = By.xpath("//*[text()='Reset Secret PIN']");
	By resetMpin = By.xpath("//*[text()='Reset MPIN']");
	By resendOTP = By.xpath("//*[text()='Resend']");
	String OTPLoc = "//input[@type='tel'][%s]";
	public By pwdTextBox = By.id("frm_text_passwordid");
	public By successLogo = By.xpath("//img[contains(@src,'Success')]");
	public By transaction = By.xpath("//div[contains(@class,'trasction-notification-text')]");
	public By loginBtn = By.xpath("//button[text()='Login']");
	public By code = By.xpath("//*[text()='Code']//following-sibling::*");
	By btnClose = By.xpath("//*[text()='Close']");

	// Verify profile details locators
	// String closedAggregator =
	// "//*[text()='%s']/ancestor::*[@aria-expanded='true']";
	// String openedAggregator =
	// "//*[text()='%s']/ancestor::*[@aria-expanded='false']";
	String openedAggregator = "//*[text()='%s']/ancestor::*[@aria-expanded='true']";
	String aggregatorValue = "//*[text()='%s']/ancestor::*[@aria-expanded='true']//following-sibling::*//*[text()='%s']//following-sibling::*[text()='%s']";
	String closedAggregator = "//*[text()='%s']/ancestor::*[@aria-expanded='false']";
	By drpRequestType = By.id("frm_select_requestTypeid");
	public By successMessage = By.xpath("(//img[contains(@src,'Success')]//parent::div//following-sibling::p)[last()]");
	public By alert = By.id("alert-dialog-slide-description");

	// P2PTransfer locators tangerine s
	By txtMobileNumber = By.id("frm_text_toUserid");
	By txtAmount = By.id("frm_text_amountid");
	By txtRemarks = By.id("frm_text_remarksid");
	By txtSeceretPIN = By.id("frm_text_transactionPinid");

	// P2POffnetTransfer locators tangerine s
	By txtMobileNumberp2poffnet = By.id("frm_text_mobileid");
	//

	// Cash Withdraw Tangereinne
	public By verifyOTPSent = By.xpath("//*[contains(text(),'OTP sent')]");
	public By otpPin = By.id("frm_text_otpid");
	public String verifyMobileNumberSuperAgentforWithdrawCash = "//*[text()='Mobile Number']//following-sibling::*[text()='%s']";
	public String verifyRemarksforWithdrawCash = "//*[text()='Reference']//following-sibling::*[text()='%s']";
	public String verifyAmountforWithdrawCash = "//*[text()='Amount (UGX)']//following-sibling::*[contains(text(),'%s')]";
	//

	public By btnConfirm = By.xpath("//*[normalize-space(text())='Confirm']//parent::button");
	public String verifyMobileNumber = "//*[text()='Mobile Number']//following-sibling::*[text()='%s']";
	public String verifyReceiverMobileNumber = "//*[text()='Receiver Mobile Number']//following-sibling::*[text()='%s']";
	public String verifyReceiverIDNumber = "//*[text()='Receiver ID Number']//following-sibling::*[text()='%s']";
	public String verifyReceiverIDType = "//*[text()='Receiver ID Type']//following-sibling::*[text()='%s']";
	public String verifyRemarks = "//*[text()='Reference']//following-sibling::*[text()='%s']";
	public String verifyAmount = "//*[text()='Amount (UGX)']//following-sibling::*[contains(text(),'%s')]";
	public By verifyTransaction = By.xpath("(//*[contains(@class,'text-success')])[1]");
	public By clickOnPassbook = By.xpath("//*[contains(@class,'Passbook')]");
	public String verifyTransactionStatus = "(//*[text()='%s']//..//parent::tr//span[contains(@class,'sucess')])[1]";
	public By getTransactionID = By.xpath("//*[contains(@class,'text-success')]//..//div");
	public String verifyfromCashout = "//*[@id='frm_text_toUserid' and @value='%s']";
	public String verifyagentcashoutAmount = "//*[text()='Amount (UGX)']//following::div//label//span[text()='%s']";

	// support locators
	By drprequestType = By.id("frm_select_requestTypeid");
	public String drpRequestTypeValue = "//*[text()='%s']";
	By txtMessage = By.id("frm_textarea_messageid");
	public By verifySupport = By.xpath("//*[@alt='Responsive image']");
	// Wallet Balance
	public By getTextofMainwallet = By.xpath("//*[text()='Main Wallet']//following-sibling::span");
	public By getTextofLoylatyPoint = By.xpath("//*[text()='Loyalty Points']//following-sibling::span");

	// BuyQPower
	By drpNickName = By.id("frm_select_meterNumberid");
	// Pay Bills locators
	By textAccountNumber = By.id("frm_text_customerAccountNumberid");
	public String verifyBusinessCode = "//*[text()='Business Code']//following-sibling::*[text()='%s']";
	public String verifyAccountNumber = "//*[text()='Account Number']//following-sibling::*[text()='%s']";

	// Dash board check balance locators
	By CHECK_BALANACE = By.xpath("//*[contains(text(),'Check Balance')]");
	By REFRESH_BALANCE = By.xpath("//*[contains(text(),'Main Balance')]//i");
	By viewBalance = By.xpath("//*[contains(text(),'Check') and contains(text(),'Balance')][last()]");
	By viewBalance_profile = By.xpath("(//*[contains(text(),'Check') and contains(text(),'Balance')][last()])[2]");

	By refreshBalance = By.xpath("//*[contains(text(),'Wallet Balance')]//i");
	By MAIN_BALANCE = By.xpath("//*[contains(text(),'Main Balance')]//span");
	By Commission_BALANCE = By.xpath("//*[contains(text(),'Main Balance')]//following-sibling::ul//span");

	By POINTS_EARN = By.xpath("//*[contains(text(),'Point') and contains(text(),'Earn')]//span");

	// QR code locators
	By QR_CODE_POPUP = By.xpath("//*[@class='qr_area dropdown-menu show' and @aria-hidden='false']");
	String QR_CODE_USERNAME = "//*[@class='qr_area dropdown-menu show' and @aria-hidden='false']//*[text()='%s']";
	String QR_CODE_USER_NUMBER = "//*[@class='qr_area dropdown-menu show' and @aria-hidden='false']//*[text()='%s']";

	// Last QPower Token
	public By getLastQPowerToken = By.xpath("(//*[contains(text(),'Get Last QPower Token')])[1]");
	public By printSection = By.xpath(".//*[@class='PrintSection']");

	// Manage beneficiary
	By btnAdd = By.xpath(".//*[text()='Add Beneficiary']");
	By nickName = By.id("frm_text_nickNameid");
	By meterNumber = By.id("frm_text_meterNumberid");
	By drpStatus = By.id("frm_select_statusid");
	By btnDelete = By.xpath("//*[text()='Delete']");
	public String verifyBeneficiaryName = ".//*[@class='account-number'][text()='%s']";
	public String verifyMeterNumber = ".//*[@class='account-number'][text()='Meter No : : '][text()='%s']";
	public String verifyBeneficiaryStatus = "(//*[@class='account-number'][text()='%s']//following::*[text()='%s'])[1]";
	String drpStatusValue = "//*[text()='%s']";

	// Recent Transctions
	By btnrefresh = By.xpath("//*[@class='fa fa-refresh']");
	public By recentTransaction = By.xpath("//*[@class='recent_item']//preceding::*[contains(@class,'slick-active')]");
	public String verifyRecentTransaction = "(//*[@class='recent_item']//preceding::*[contains(@class,'slick-active')])[%d]";
	public By verifyRecentTransactionLabel = By
			.xpath("//*[contains(text(),'Recent') and contains(text(),'Transactions')]");

	// Passbook
	By btnPassbook = By.xpath("//*[@class='moon-Passbook-with-dollar']");
	By btnFilter = By.xpath("//*[@class='ti-filter']");
	String filterValue = "(//*[text()='%s']//preceding::input)[last()]";
	String durationFilter = "(//*[text()='Duration']//following::span[text()='%s']//preceding::input[@type='checkbox'])[last()]";
	String statusFilter = "(//*[text()='Status']//following::span[text()='%s']//preceding::input[@type='checkbox'])[last()]";
	String serviceFilter = "(//*[text()='Services']//following::span[text()='%s']//preceding::input[@type='checkbox'])[last()]";
	public By verifyTable = By.xpath(".//table[@role='grid']");
	public String verifyServices = ".//td[text()='Product']//following::td[text()='%s']";
	public String verifyStatus = ".//td[text()='Status']//following::span[text()='%s']";
	public String verifyAllServices = "(.//td[text()='Product']//following::td[text()='%s'])[%d]";
	public String verifyAllStatus = "(.//td[text()='Status']//following::span[text()='%s'])[%d]";
	By btnYes = By.xpath("//button[text()='Yes']");
	By btnClear = By.xpath("//*[text()='Clear']");
	By btnSearch = By.xpath("//button[@aria-label='Search']");
	By txtSearch = By.xpath("//*[@aria-label='Search']//input");
	public String verifyTransactionID = ".//td[text()='Transaction ID']//following::td[text()='%s']";
	public String verifyAllTransactionID = "(.//td[text()='Transaction ID']//following::td[text()='%s'])[%d]";
	public By noRecords = By.xpath(".//*[text()='No records found']");

	// RedeemQMoneyPoints
	String selectValue = "//*[text()='%s']";
	By textRedeemPoint = By.id("Demo_text_conversion");
	By btnRedeem = By.xpath("//button[text()='REDEEM']");
	public By verifyRedeemPoint = By.xpath("//*[@class='header_logo']");

	// checkQMoney Point
	public By getTextofQMOneyPoint = By.xpath("//*[text()='QMoney Points']//following-sibling::*");
	public By verifyQmoneyPointOpen = By.xpath("//*[@class='text-success']");

	// Blink
	By drpBank = By.id("frm_select_bankid");
	By selectBankLinkAccount = By.xpath("//*[text()='Link Bank Account']");
	By selectBankLink = By
			.xpath("//*[contains(text(),'Link') and contains(text(),'Bank') and contains(text(),'Account')]");
	By textTINNumber = By.id("frm_text_TIN_NUMBERid");
	public By verifyOTPScreen = By.xpath("//*[text()='Enter OTP']");
	String clickOnBankNameForEdit = "(//*[contains(@class,'edit_link')]//*[text()='%s']//parent::div//parent::div//*[text()='%s'])[1]";
	By BtnEdit = By.xpath("//*[text()='Edit']");
	By BtnDelete = By.xpath("//*[text()='Delete']");
	By selectBankBalanceInquiry = By.xpath("//*[text()='Balance Inquiry']");
	By selectTransferToBank = By.xpath("//*[text()='Transfer To Bank']");
	By selectTransferFromBank = By.xpath("//*[text()='Transfer From Bank']");
	By txtSelectBank = By.xpath("//*[text()='Select Bank']");
	By btnSubmitforBank = By.xpath("//button[text()='Submit']");
	By btnSaveBtn = By.xpath("//button[text()='Save']");
	By selectCashOutTransferToBank = By.xpath("//*[text()='Cash Out From Bank']");
	By selectCashInTransferFromBank = By.xpath("//*[text()='Cash In From Bank']");

	// common locator
	By btnCommonSubmit = By.xpath("//button[text()='Submit']");

	// Qcell Post paid locator
	By btnCheckOutStandingBalance = By.xpath(".//button[text()='Check Outstanding Balance']");

	// Register Customer
	public By errorMsg = By.xpath(".//*[@class='validation_error']");
	public String errorMsgText = "(.//*[@class='validation_error'])[%d]";

	// Assistant onboarding
	By btnOnboardNewAssistant = By.xpath(".//*[@class='btn_general btn-manage-bank'][text()='Onboard New Assistant']");
	public By verifyOnboarding = By.xpath(".//*[normalize-space(text())='Onboarded Successfully.']");
	public By verifyOnboardingMerchant = By.xpath(".//*[normalize-space(text())='On boarded successfully.']");

	// RedeemSubScriber Point
	By redemptionCode = By.id("frm_text_tokenid");
	By productToSell = By.id("frm_text_productcodeid");
	By getNameAndAmount = By.xpath(".//*[text()='Click to get Redemption Points and Name']");

	// Reports
	By resellerTransactionReport = By.xpath(".//*[text()='Reseller Transaction Report']");
	By myFloatHistory = By.xpath(".//*[text()='My Float History']");
	By commissionSummary = By.xpath(".//*[text()='Commission Summary']");
	By paymentHistory = By.xpath(".//*[text()='Payment History']");
	By startDate = By.id("frm_datepicker_FromDateid");
	By endDate = By.id("frm_datepicker_ToDateid");
	By drpAssistant = By.id("frm_select_AssistantIdentifierid");
	By txtReference = By.id("frm_text_TxReferenceid");
	String drpValue = ".//*[text()='%s']";
	String drpLastValue = "(.//*[text()='%s'])[last()]";
	By drpTransactionFlag = By.id("rm_select_TransactionStatusid");

	// cash Transfer
	By txtSenderName = By.id("frm_text_nameid");
	By txtReceiverName = By.id("frm_text_toUserNameid");
	By txtSenderMobileNumber = By.id("frm_text_mobileid");
	By drpSenderIDType = By.id("frm_select_IdTypeid");
	By txtIDNumber = By.id("frm_text_IdNumberid");
	By drpReceiverIDType = By.id("frm_select_toUserIdTypeid");
	public By txtReceiverIDNumber = By.id("frm_text_toUserIdNumberid");

	// redeem cash Token
	By linkGetTokenDetails = By.xpath("//*[text()='Click to get Token Details']");

	// Sell Power
	By linkgetLanloardName = By.xpath("//*[text()='Click to get Landlord Name']");

	// Agent Onbaording
	By btnOnboardNewAgent = By.xpath(".//*[@class='btn_general btn-manage-bank'][text()='Onboard New Agent']");

	// Accept Payments
	String label = "//*[text()='%s']";
	By payForBills = By.xpath("//*[text()='Pay For Bills']");
	By upComing = By.xpath("//*[text()='Up Coming']");
	By btnCheckOutStanding = By.xpath("//*[@name='checkOutStandingButton']");
	By txtAmountForPostpaid = By.id("frm_text_amount_1id");
	String buyQPowerdrpvalue = "//*[normalize-space(text())='%s']";
	public String verifyMeterNumberInSellQPower = "//*[text()='Meter Number']//following-sibling::*[text()='%s']";
	By btnDownLoad = By.xpath(".//*[contains(@class,'cloud-down')]");
	public By clickOnLogo = By.xpath("//*[@class='logo-main']");
	public String verifyNickName = "//*[text()='Nick Name']//following-sibling::*[text()='%s']";
	public By verifyOnboardingForMerchant = By.xpath(".//*[normalize-space(text())='On boarded successfully.']");
	By btnSearchForReport = By.xpath("//button[text()='Search']");
	public By insufficientBalanceText = By.xpath("//*[contains(text(),'Insufficient') and contains(text(),'balance')]");
	public By btnServiceSubmit = By.xpath("//div[@class='item']//button[text()='Submit']");
	public By btnServiceSUBMIT = By.xpath("//div[@class='item']//button[text()='SUBMIT']");
	public By btnchekbalancesubmit = By.xpath("//div[@class='input-group']//button[text()='Submit']");
	// *[translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')
	// = 'submit']
	By verifyNaviTermsConditions = By.xpath("//*[contains(@class,'graph_area')]//*[text()='Terms Of Service']");
	By verifyChatOptionHeader = By.id("shortMessage");
	By UGX_text = By.xpath("//Span[. = 'UGX']");
	By UGX_passbook = By.xpath("//*[contains(text(),'Amount (UGX)')]");

	By successOnboardText = By.xpath("//*[contains(text(),'Successfully')]");
	By drpOnboardUserType = By.id("frm_select_operatingEntityIDid");
	By txtAgentName = By.id("frm_text_nameid");
	elasticwrite log;
	CommonOperations common;

	public By BalanceafterPaymentText = By.xpath("//p[contains(text(),'Balance after Payment (UGX)')]");
	public By AvailableBalanceText = By.xpath("//p[contains(text(),'Available Balance (UGX)')]");
	public By Amounttext = By.xpath("//span[contains(text(),'Amount (UGX)')]");
	public By ConfirmationScreen = By.xpath("//*[normalize-space(text())='Confirmation Details']");

	By balance = By.xpath("//span[contains(@class,'main-bal')]");

	public DashBoardPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		common = new CommonOperations(driver, log);
	}

	
	public void otpPIN(String otp, int... args) {
		sendKeys(otpPin, otp, 0);
		setLogSteps(log, "Enter OTP: " + otp);
	}

	public void enterCurrentMPin(String currentMpin, int... args) {
		sendKeys(txtCurrentMpin, currentMpin, args);
		setLogSteps(log, "Enter Current MPIN:" + currentMpin);
	}

	public void enterNewMpin(String newMpin, int... args) {
		sendKeys(txtNewMpin, newMpin, args);
		setLogSteps(log, "Enter New MPIN:" + newMpin);
	}

	public void enterConfirmNewMpin(String newMpin, int... args) {
		sendKeys(txtConfirmNewMpin, newMpin, args);
		setLogSteps(log, "Enter Confirm New MPIN:" + newMpin);
	}

	public void clickOnSubmitButton(int... args) {
		clickOnElement(btnSubmit, args);
		setLogSteps(log, "Click On Submit Button");
	}

	public void clickOnCloseButton(int... args) {
		clickOnElement(btnClose, args);
		setLogSteps(log, "Click On Close Button");
	}

	public void enterMobileNumber(String mobileNumber, int... args) {
		sendKeys(txtMobileNumber, mobileNumber, 0);
		setLogSteps(log, "Enter Mobile Number : " + mobileNumber);
	}

	public void enterRegisteredMobileNumber(String mobileNumber, int... args) {
		sendKeys(txtRegisteredMobileNumber, mobileNumber, 0);
		setLogSteps(log, "Enter Registered Mobile Number : " + mobileNumber);
	}

	public void enterRegisteredMobileNumberForgotMpin(String mobileNumber, int... args) {
		sendKeys(txtenterRegisteredMobileNumber, mobileNumber, 0);
		setLogSteps(log, "Enter Registered Mobile Number : " + mobileNumber);
	}

	public void enterMPINInLogin(String mpin, int... args) {
		sendKeys(txtMPINfromLogin, mpin, 0);
		setLogSteps(log, "Enter MPIN from Login : " + mpin);
	}

	public void enterSecretWord(String secretWord, int... args) {
		sendKeys(txtSecretWord, secretWord, 0);
		setLogSteps(log, "Enter secretWord from Login : " + secretWord);
	}

	public void enterConfirmSecretWord(String secretWord, int... args) {
		sendKeys(txtConfirmSecretWord, secretWord, 0);
		setLogSteps(log, "Entered Confirmed secretWord: " + secretWord);
	}

	public void verifyActivationSuccessMessage(int... args) {
		verifyVisible(txtveriyactivationSuccess, 0);
		setLogSteps(log, "Verify message: Activation of new user is successfully done.");
	}

	public void verifyMPINChangeSuccessMessage(int... args) {
		verifyVisible(txtverifyMPINChangesucess, 0);
		setLogSteps(log, "Verify message: MPIN has been changed successfully.");
	}
	
	public void verifyPasswordChangeSuccessMessage(int... args) {
		verifyVisible(txtverifyPasswordSucess, 0);
		setLogSteps(log, "Verify message: Password has been changed successfully.");
	}

	public void verifySWChangeSuccessMessage(int... args) {
		verifyVisible(txtverifySWChangesucess, 0);
		setLogSteps(log, "Verify message: Secret word has been changed successfully");
	}

	public void clickonBacktoLoginBtn(int... args) {
		clickOnElement(btnBacktoLogin, args);
		setLogSteps(log, "Click on Back to Login button");
	}

	public void enterMobileNumberp2poffnet(String mobileNumber, int... args) {
		sendKeys(txtMobileNumberp2poffnet, mobileNumber, 0);
		setLogSteps(log, "Enter Mobile Number for p2p offnet : " + mobileNumber);
	}

	public void enterAmount(String amount, int... args) {
		sendKeys(txtAmount, amount, 0);
		setLogSteps(log, "Enter Amount : " + amount);
	}

	public void enterRemark(String remark, int... args) {
		sendKeys(txtRemark, remark, 0);
		setLogSteps(log, "Enter Remarks : " + remark);
	}

	public void enterRemarkfromCashout(String remark, int... args) {
		sendKeys(txtRemark, remark, 0);
		setLogSteps(log, "Enter Remarks : " + remark);
	}

	public void enterSecretPIN(String secretPIN, int... args) {
		sendKeys(secretMpin, secretPIN, 0);
		setLogSteps(log, "Enter Secret PIN : " + secretPIN);
	}

	public void enterSecretPINtocheckbalance(String secretPIN, int... args) {
		sendKeys(secretMpintoCheckBalance, secretPIN, 0);
		setLogSteps(log, "Enter Secret PIN : " + secretPIN);
	}

	public void clickOnConfirmButton(int... args) {
		pauseInSeconds(2);
		scrollToElement_Tangereine(driver.findElement(btnConfirm));
		pauseInSeconds(2);
		clickOnElement(btnConfirm, args);
		setLogSteps(log, "Click On Confirm Button");
	}

	public void clickOnLoginButton(int... args) {
		clickOnElement(loginBtn, args);
		setLogSteps(log, "Click on Login Button");
	}

	public void clickOnResendOTP(int... args) {
		clickOnElement(resendOTP, args);
		setLogSteps(log, "Click on Resend OTP");
	}

	public void typeOTP(String OTP, int... args) {
		char[] OTPchars = OTP.toCharArray();
		int i = 0;
		for (char OTPchar : OTPchars) {
			sendKeys(By.xpath(String.format(OTPLoc, i)), Character.toString(OTPchar), args);
			i++;
		}
		setLogSteps(log, "Type OTP which you got: " + OTP);
	}

	public void openAggregator(String aggregatorValue, int... args) {
		if (verifyVisible(By.xpath(String.format(closedAggregator, aggregatorValue)), 3)) {
			clickOnElement(By.xpath(String.format("(//*[text()='%s'])[last()]", aggregatorValue)), args);
		}
	}

	public void closeAggregator(String aggregatorValue, int... args) {
		if (verifyVisible(By.xpath(String.format(openedAggregator, aggregatorValue)), 3)) {
			clickOnElement(By.xpath(String.format("(//*[text()='%s'])[last()]", aggregatorValue)), args);
		}
	}

	public Map<String, String> getAggregatorData(String data) {
		Map<String, String> map = new HashMap<>();
		String[] aggData = data.split("####");
		String aggregatorName = aggData[0];
		String[] data1 = aggData[1].split(",");
		map.put("aggregator", aggregatorName.trim());
		for (String s : data1) {
			String[] info = s.split("##");
			map.put(info[0].trim(), info[1].trim());
		}
		return map;
	}

	public void verifyAggregatorData(Map<String, String> map, int... args) {
		String aggregator = map.get("aggregator");
		openAggregator(aggregator);
		map.remove("aggregator");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String aggrigator_loc = String.format(aggregatorValue, aggregator, entry.getKey().trim(),
					entry.getValue().trim(), entry.getValue().trim());
			verifyVisible(By.xpath(aggrigator_loc), args);
			setLogSteps(log,
					aggregator + " > " + entry.getKey().trim() + " > " + entry.getValue().trim() + " is Visible");
		}
	}

	public void enterMessage(String message, int... args) {
		sendKeys(log, txtMessage, message, args);
		setLogSteps(log, "Enter Message : " + message);
	}

	public void clickOnEditButton(int... args) {
		clickOnElement(btnEdit);
		setLogSteps(log, "Click On Edit Button");
	}

	public void clickOnChangePassword(int... args) {
		clickOnElement(changePassword, args);
		setLogSteps(log, "Click On Change Password");
	}

	public void clickOnSelectRedemption(String selectRedemption, int... args) {
		clickOnElement(log, By.xpath(String.format(selectValue, selectRedemption)), args);
		setLogSteps(log, "Select Redemption:" + selectRedemption);
	}

	public void clickOnSelectReceipient(String selectReceipient, int... args) {
		clickOnElement(log, By.xpath(String.format(selectValue, selectReceipient)), args);
		setLogSteps(log, "Select Receipient:" + selectReceipient);
	}

	public void sendTextInQMoneyPointsToBeRedeem(String redeemPoint, int... args) {
		sendKeys(textRedeemPoint, redeemPoint, args);
		setLogSteps(log, "Enter QMoney Points To Be Redeem:" + redeemPoint);
	}

	public void clickOnRedeemButton(int... args) {
		clickOnElement(btnRedeem, args);
		setLogSteps(log, "Click On Redeem Button");
	}

	public void enterCurrentPassword(String currentPASSWORD, int... args) {
		sendKeys(txtCurrentPassword, currentPASSWORD, args);
		setLogSteps(log, "Enter Current Password:" + currentPASSWORD);
	}

	public void enterNewPassword(String newPASSWORD, int... args) {
		sendKeys(txtNewPassword, newPASSWORD, args);
		setLogSteps(log, "Enter New Password:" + newPASSWORD);
	}

	public void enterConfirmNewPassword(String newPASSWORD, int... args) {
		sendKeys(txtConfirmNewPassword, newPASSWORD, args);
		setLogSteps(log, "Enter Confirm New Password:" + newPASSWORD);
	}
	
	public void enterConfirmNewPasswordd(String newPASSWORD, int... args) {
		sendKeys(txtConfirmNewPassword_CapitalP, newPASSWORD, args);
		setLogSteps(log, "Enter Confirm New Password:" + newPASSWORD);
	}

	public void sendTextInRemarks(String remarks, int... args) {
		sendKeys(txtRemarks, remarks, args);
		setLogSteps(log, "Enter Remarks:" + remarks);
	}

	public void clickOnConfirmBtn(int... args) {
		clickOnElement(btnConfirm, args);
		setLogSteps(log, "Click On Confirm button");
	}

	public void selectRequestType(String requestType, int... args) {
		selectFromDropDown(log, drprequestType, By.xpath(String.format(drpRequestTypeValue, requestType)), args);
		setLogSteps(log, "Select Request Type:" + requestType);
	}

	public void selectNickName(String nickName, int... args) {
		selectFromDropDown(log, drpNickName, By.xpath(String.format(buyQPowerdrpvalue, nickName)), args);
		setLogSteps(log, "Select NickName:" + nickName);
	}

	public void sendTextInBusinessCode(String businessCode, int... args) {
		sendKeys(txtMobileNumber, businessCode, args);
		setLogSteps(log, "Enter Business Code:" + businessCode);
	}

	public void sendTextInAccountNumber(String accountNumber, int... args) {
		sendKeys(textAccountNumber, accountNumber, args);
		setLogSteps(log, "Enter Account Number:" + accountNumber);
	}

	public void sendTextInBLinkAccountNumber(String accountNumber, int... args) {
		sendKeys(By.id("frm_text_ACCOUNT_NUMBERid"), accountNumber, args);
		setLogSteps(log, "Enter Account Number:" + accountNumber);
	}

	public void clickOnChangeMpin(int... args) {
		clickOnElement(log, changeMPin, args);
		setLogSteps(log, "Click On Change MPIN");
	}

	public void clickOnResetMPIN(int... args) {
		clickOnElement(log, resetMpin, args);
		setLogSteps(log, "Click On Reset MPIN");
	}

	public void clickOnCheckBalance(int... args) {
		try {
			clickOnElement(log, viewBalance, 2);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "check balance");
		}
		setLogSteps(log, "Click On Check Balance");
	}

	public void clickOnCheckBalanceFromProfile(int... args) {
		try {
			clickOnElement(log, viewBalance_profile, 2);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "check balance");
		}
		setLogSteps(log, "Click On Check Balance");
	}

	public void clickOnRefreshBalance(int... args) {
		try {
			clickOnElement(log, refreshBalance, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "refresh balance");
		}
		setLogSteps(log, "Click On Refresh Button");
	}

	public String getMainBalance(int... args) {
		pauseInSeconds(3);
		;
		String mainBalance = getElementText(log, MAIN_BALANCE, args).trim();
		return mainBalance.split(" ")[0];
	}

	public String getCommissionBalance(int... args) {
		String mainBalance = getElementText(log, Commission_BALANCE, args).trim();
		return mainBalance.split(" ")[0];
	}

	public String getPointsEarn(int... args) {
		// setLogSteps(log, "Getting Earned points");
		String points = getElementText(log, POINTS_EARN, args).trim();
		setLogSteps(log, "Earned points are: " + points);
		return points;
	}

	public boolean isQRCodePopupOpened(int... args) {
		boolean res = isVisible(QR_CODE_POPUP, args);
		setLogSteps(log, "QR Code Popup is Opened");
		return res;
	}

	public void verifyUserNameInQRCode(String userName, int... args) {
		isVisible(By.xpath(String.format(QR_CODE_USERNAME, userName)), args);
		setLogSteps(log, "User name: " + userName + " is present in QR code popup");
	}

	public void verifyUserNumberInQRCode(String number, int... args) {
		isVisible(By.xpath(String.format(QR_CODE_USER_NUMBER, number)), args);
		setLogSteps(log, "User number: " + number + " is present in QR code popup");
	}

	public void sendTextInStringField(String label, String value, int... args) {
		sendKeys(By.xpath(String.format(textData, label.trim())), value.trim(), args);
		setLogSteps(log, "Send Text in Field: " + label + "And Value is: " + value);
	}

	public void enterFileUploadData(String label, String fileName, int... args) {
		File file = new File(".\\TestData\\resources\\" + fileName);
		String absolute = file.getAbsolutePath();
		moveToElement(By.xpath(String.format(uploadFileData, label.trim())));
		sendKeys(By.xpath(String.format(uploadFileData, label.trim())), absolute, args);
		setLogSteps(log, "Upload File in Field: " + label + "And File is: " + absolute);
	}

	public void clickOnNextButton(int... args) {
		clickOnElement(btnNext, args);
		setLogSteps(log, "Click On Next button");
	}

	public void clickOnNextButtonUserActivation(int... args) {
		clickOnElement(btnNEXTforLogin, args);
		setLogSteps(log, "Click On Next button");
	}

	public void selctValueFromDropDown(String label, String value, int... args) {
		clickOnElement(By.xpath(String.format(drpArrow, label.trim())), args);
		clickOnElement(By.xpath(String.format(txtdrp, value.trim())), args);
		// selectFromDropDownUsingSelectTag(log,
		// By.xpath(String.format(drpArrow,
		// label.trim())), value, args);
		setLogSteps(log, "Select Value From  Field: " + label + "And Value is: " + value);
	}

	public void selectDate(String label, String value, int... args) {
		WebElement date = findVisibleElement(By.xpath(String.format(inputDate, label.trim())), 0);
		sendKeysToElement(log, date, value.trim());
		setLogSteps(log, "Select Date From  Field: " + label + "And Date is: " + value);
	}

	public void clickOnAddBeneficiary(int... args) {
		clickOnElement(btnAdd);
		setLogSteps(log, "Click On Add Beneficiary Button");
	}

	public void sendTextInNickName(String name, int... args) {
		sendKeys(nickName, name, 0);
		setLogSteps(log, "Enter Nick Name: " + name);
	}

	public void sendTextInBLinkNickName(String name, int... args) {
		sendKeys(By.id("frm_text_NICK_NAMEid"), name, 0);
		setLogSteps(log, "Enter Nick Name: " + name);
	}

	public void sendTextInMeterNumber(String number, int... args) {
		sendKeys(meterNumber, number, 0);
		setLogSteps(log, "Enter Meter Number: " + number);
	}

	public void selectStatus(String status, int... args) {
		selectFromDropDown(this.log, drpStatus, By.xpath(String.format(drpStatusValue, status)), args);
		setLogSteps(log, "Select Status: " + status);
	}

	public void clickOnDeleteButton(int... args) {
		clickOnElement(btnDelete, args);
		if (verifyVisible(btnYes, 3)) {
			clickOnElement(btnYes, 3);
		}
		setLogSteps(log, "Click On Delete Button");
	}

	public void clickOnRefreshButton(int... args) {
		pauseInSeconds(2);
		clickOnElement(btnrefresh, args);
		setLogSteps(log, "Click On Refresh Button");
	}

	public void clickOnPassbookButton(int... args) {
		clickOnElement(btnPassbook, args);
		setLogSteps(log, "Click On Passbook Button");
	}

	public void clickOnFilterButton(int... args) {
		clickOnElement(btnFilter, args);
		setLogSteps(log, "Click On Filter Button");
	}

	public void SelectDurationFilter(String filterValue, int... args) {
		clickOnElement(By.xpath(String.format(durationFilter, filterValue.trim())), args);
		setLogSteps(log, "Select Duration Filter: " + filterValue.trim());
	}

	public void SelectServiceFilter(String filterValue, int... args) {
		clickOnElement(By.xpath(String.format(serviceFilter, filterValue.trim())), args);
		setLogSteps(log, "Select Service Filter: " + filterValue.trim());
	}

	public void SelectStatusFilter(String filterValue, int... args) {
		clickOnElement(By.xpath(String.format(statusFilter, filterValue.trim())), args);
		setLogSteps(log, "Select Status Filter: " + filterValue.trim());
	}

	public void clickOnClearButton(int... args) {
		clickOnElement(btnClear, args);
		setLogSteps(log, "Click On Clear Button");
	}

	public void clickOnSearchButton(int... args) {
		clickOnElement(btnSearch, args);
		setLogSteps(log, "Click On Search Button");
	}

	public void sendTextInSearch(String tranctionId, int... args) {
		sendKeys(txtSearch, tranctionId, 0);
		setLogSteps(log, "Enter Transactio ID in Search Filter: " + tranctionId);
	}

	public void clickOnCommonSubmitButton(int... args) {
		clickOnElement(btnCommonSubmit, args);
		setLogSteps(log, "Click On Submit Button");
	}

	public void selectBank(String bankName, int... args) {
		selectFromDropDown(log, drpBank, By.xpath(String.format(drpRequestTypeValue, bankName)), args);
		clickOnElement(txtSelectBank, 0);
		setLogSteps(log, "Select Bank:" + bankName);
	}

	public void clickOnLinkBankAccount(int... args) {
		clickOnElement(selectBankLinkAccount, args);
		setLogSteps(log, "Click On Link Bank Account");
	}

	public void clickOnBLinkBankAccountNew(int... args) {
		clickOnElement(selectBankLink, args);
		setLogSteps(log, "Click On Link Bank Account");
	}

	public void enterTINNumber(String tinName, int... args) {
		clearText(textTINNumber, tinName, args);
		sendKeys(textTINNumber, tinName, args);
		setLogSteps(log, "Enter TIN Number:" + tinName);
	}

	public void enterBLinkTINNumber(String tinName, int... args) {
		clearText(By.id("frm_text_TIN_NUMBERid"), tinName, args);
		sendKeys(By.id("frm_text_TIN_NUMBERid"), tinName, args);
		setLogSteps(log, "Enter TIN Number:" + tinName);
	}

	public void selectBankForManage(String bankname, String accountNumber, int... args) {
		clickOnElement(By.xpath(String.format(clickOnBankNameForEdit, bankname, accountNumber)), 0);
		setLogSteps(log, "Click On Bank Name For Edit Bank Detail:" + bankname);
	}

	public void clickOnEditBtn(int... args) {
		clickOnElement(BtnEdit, args);
		setLogSteps(log, "Click On Bank Account Edit Button");
	}

	public void clickOnDeleteBtn(int... args) {
		clickOnElement(BtnDelete, args);
		setLogSteps(log, "Click On Bank Account Delete Button");
	}

	public void clickOnBankBalanceInquiry(int... args) {
		clickOnElement(selectBankBalanceInquiry, args);
		setLogSteps(log, "Click On Bank Account Balance Inquiry");
	}

	public void clickOnTransferToBank(int... args) {
		clickOnElement(selectTransferToBank, args);
		setLogSteps(log, "Click On Transfer To Bank");
	}

	public void clickOnTransferFromBank(int... args) {
		clickOnElement(selectTransferFromBank, args);
		setLogSteps(log, "Click On Transfer From Bank");
	}

	public void clickOnSubmitBtn(int... args) {
		clickOnElement(btnSubmitforBank, args);
		setLogSteps(log, "Click On Submit Button");
	}

	public void clickOnSaveBtn(int... args) {
		clickOnElement(btnSaveBtn, args);
		setLogSteps(log, "Click On Save Button");
	}

	public String getTransactionID() {
		String transactionString = getElementText(this.log, transaction, 5);
		String[] transactonId = transactionString.split(":");
		return transactonId[1].replaceAll(" ", "");
	}

	public void clickOnPassbook(int... args) {
		if (!verifyVisible(clickOnPassbook, 2)) {
			reloadCurrentPage();
		}
		clickOnElement(clickOnPassbook, 0);
		setLogSteps(log, "Click On Passbook");
	}

	public void sendTextInAccountNumberInEdit(String accountNumber, int... args) {
		clearText(textAccountNumber, accountNumber, args);
		sendKeys(textAccountNumber, accountNumber, args);
		setLogSteps(log, "Enter Account Number:" + accountNumber);
	}

	public void sendTextInNickNameInEdit(String name, int... args) {
		clearText(nickName, name, args);
		sendKeys(nickName, name, 0);
		setLogSteps(log, "Enter Nick Name: " + name);
	}

	public void selectRequestTypeForPostPaid(String requestType, int... args) {
		clickOnElement(log, By.xpath(String.format(selectValue, requestType)), args);
		setLogSteps(log, "Enter Request Type: " + requestType);
	}

	public void clickOnOnboardNewAssistant(int... args) {
		clickOnElement(btnOnboardNewAssistant, 0);
		setLogSteps(log, "Click On Onboard New Assistant");
	}

	public void sendTextInRedemptionCode(String number, int... args) {
		sendKeys(redemptionCode, number, 0);
		setLogSteps(log, "Enter Redemption Code: " + number);
	}

	public void sendTextInProdctToSell(String product, int... args) {
		sendKeys(productToSell, product, 0);
		setLogSteps(log, "Enter Product To Sell: " + product);
	}

	public void ClickOnLinkGetRedemptionAmountAndName(int... args) {
		clickOnElement(log, getNameAndAmount, 0);
		setLogSteps(log, "Click  On Link Get Redemption Amount And Name");
	}

	public void ClickOnResellerTransactionReport(int... args) {
		clickOnElement(log, resellerTransactionReport, 0);
		setLogSteps(log, "Click  On Reseller Transaction Report");
	}

	public void ClickOnMyFloatHistory(int... args) {
		clickOnElement(log, myFloatHistory, 0);
		setLogSteps(log, "Click  On My Float History");
	}

	public void ClickOnCommissionSummary(int... args) {
		clickOnElement(log, commissionSummary, 0);
		setLogSteps(log, "Click  On Commission Summary");
	}

	public void ClickOnPaymentHistory(int... args) {
		clickOnElement(log, paymentHistory, 0);
		setLogSteps(log, "Click  On Payment History");
	}

	public void SelectStartDate(String date, int... args) {
		sendKeysWithOutClear(startDate, date, 0);
		setLogSteps(log, "Enter Start Date: " + date);
	}

	public void SelectEndDate(String date, int... args) {
		sendKeysWithOutClear(endDate, date, 0);
		setLogSteps(log, "Enter End Date: " + date);
	}

	public void SelectAssistant(String assistant, int... args) {
		selectFromDropDown(log, drpAssistant, By.xpath(String.format(drpValue, assistant)), args);
		setLogSteps(log, "Select Assistant: " + assistant);
	}

	public void SendTextInTxReference(String reference, int... args) {
		sendKeys(log, txtReference, reference, args);
		setLogSteps(log, "Enter Tx Reference: " + reference);
	}

	public void SelectTransactionFlag(String flag, int... args) {
		selectFromDropDown(log, drpTransactionFlag, By.xpath(String.format(drpValue, flag)), args);
		setLogSteps(log, "Select Transaction Flag: " + flag);
	}

	public void sendTextInSenderName(String name, int... args) {
		sendKeys(log, txtSenderName, name, args);
		setLogSteps(log, "Enter Sender Name: " + name);
	}

	public void sendTextInReceiverName(String name, int... args) {
		sendKeys(log, txtReceiverName, name, args);
		setLogSteps(log, "Enter Receiver Name: " + name);
	}

	public void sendTextInSenderMobileNumber(String number, int... args) {
		sendKeys(log, txtSenderMobileNumber, number, args);
		setLogSteps(log, "Enter Sender Mobile Number: " + number);
	}

	public void selectSenderIDType(String id, int... args) {
		selectFromDropDown(log, drpSenderIDType, By.xpath(String.format(drpValue, id)), args);
		setLogSteps(log, "Select Sender ID Type: " + id);

	}

	public void selectReceiverIDType(String id, int... args) {
		// moveToElement(drpReceiverIDType);
		// moveToElement(drpReceiverIDType);
		// JavascriptExecutor jse = (JavascriptExecutor)driver;
		// jse.executeScript("window.scrollBy(0,1000)", "");
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// jse.executeScript("document.getElementByClass('jbs-scroll').setAttribute('attr',
		// '10')");
		// jse.executeScript("arguments[0].style='overflow:visible;'",By.className("jbs-scroll"));
		selectFromDropDown(log, drpReceiverIDType, By.xpath(String.format(drpLastValue, id)), args);
		setLogSteps(log, "Select Receiver ID Type: " + id);
	}

	public void sendTextInIDNumber(String number, int... args) {
		sendKeys(log, txtIDNumber, number, args);
		setLogSteps(log, "Enter ID number: " + number);
	}

	public void sendTextInReceiverIDNumber(String number, int... args) {
		sendKeys(log, txtReceiverIDNumber, number, args);
		setLogSteps(log, "Enter Receiver ID number: " + number);
	}

	public void sendTextInCashToken(String token, int... args) {
		sendKeys(log, redemptionCode, token, args);
		setLogSteps(log, "Enter Cash Token: " + token);
	}

	public void clickOnGetTokenDetails(int... args) {
		clickOnElement(log, linkGetTokenDetails, args);
		setLogSteps(log, "Click On Link Get Token Details");
	}

	public void clickOnGetLanloardName(int... args) {
		clickOnElement(log, linkgetLanloardName, args);
		setLogSteps(log, "Click On Link Get Lanloard Name");
	}

	public void clickOnOnboardNewAgent(int... args) {
		clickOnElement(btnOnboardNewAgent, 0);
		setLogSteps(log, "Click On Onboard New Agent");
	}

	public void clickOnElement(String value) {
		clickOnElement(By.xpath(String.format(label, value.trim())), 0);
		setLogSteps(log, "Click On: " + value);
	}

	public void clickOnPayForBills(int... args) {
		clickOnElement(payForBills, args);
		setLogSteps(log, "Click On Pay For Bills");
	}

	public void clickOnUpComing(int... args) {
		clickOnElement(upComing, args);
		setLogSteps(log, "Click On Up Coming");
	}

	public void clickOnCheckOutStandingBalanceButton(int... args) {
		clickOnElement(btnCheckOutStandingBalance, args);
		setLogSteps(log, "Click On Check Out Standing Balance Button");
	}

	public void clickOnTransferToBankForMerchant(int... args) {
		clickOnElement(selectCashOutTransferToBank, args);
		setLogSteps(log, "Click On Transfer To Bank");
	}

	public void clickOnTransferFromBankForMerchant(int... args) {
		clickOnElement(selectCashInTransferFromBank, args);
		setLogSteps(log, "Click On Transfer From Bank");
	}

	public void enterReceiverMobileNumber(String mobileNumber, int... args) {
		sendKeys(txtMobileNumber, mobileNumber, 0);
		setLogSteps(log, "Enter Mobile Number : " + mobileNumber);
	}

	public void verifySuccessLogo(int... args) {
		verifyVisible(successLogo, args);
		setLogSteps(log, "Verify Success Logo Is Present");
	}

	public void verifyTransactionStatus(String Trnsid, int... args) {
		verifyVisible(By.xpath(String.format(verifyTransactionStatus, Trnsid)), 0);
		setLogSteps(log, "Verify Transaction Status in Passbook");
	}

	public void clickOnCheckOutStandingBtn(int... args) {
		clickOnElement(btnCheckOutStanding, args);
		setLogSteps(log, "Click On Check Out Standing Button");
	}

	public void enterAmountForQCellPostPaid(String amount, int... args) {
		sendKeys(txtAmountForPostpaid, amount, 0);
		setLogSteps(log, "Enter Amount : " + amount);
	}

	public void clickOnDownloadButton(int... args) {
		clickOnElement(btnDownLoad, args);
		setLogSteps(log, "Click On DownLoad Icon");
	}

	public void verifyDetails(String aggregatorName, String lable, String value, int... args) {
		verifyVisible(By.xpath(String.format(aggregatorValue, aggregatorName, lable, value)), args);
		setLogSteps(log, "Verify" + lable);
	}

	public void verifyTransactionIDInPassbook(String transactionID) {
		clickOnPassbook(0);
		verifyTransactionStatus(transactionID, 0);
	}

	public void clickOnSearchButtonForReport(int... args) {
		clickOnElement(btnSearchForReport, args);
		setLogSteps(log, "Click On Search Button");
	}

	public void selectCreditFor(String value, int... args) {
		clickOnElement(By.xpath(String.format(txtdrp, value)), args);
		setLogSteps(log, "Click On Credit On :" + value);
	}

	public void clickOnServiceSubmitButton(int... args) {
		clickOnElement(btnServiceSubmit, args);
		setLogSteps(log, "Click On Submit Button");
	}

	public void clickOnChkBalanceSubmitButton(int... args) {
		clickOnElement(btnchekbalancesubmit, args);
		setLogSteps(log, "Click On Submit Button for Check Balance");
	}

	public void clickOnServiceSUBMITButton(int... args) {
		clickOnElement(btnServiceSUBMIT, args);
		setLogSteps(log, "Click On Submit Button");
	}

	public String getBalance(int... args) {
		String mainBalance = null;
		try {
			mainBalance = getElementText(log, balance, args).trim();
		} catch (Exception e) {
			throw new RuntimeException(GET_TEXT_ERROR_MESSAGE + "balance");
		}
		return mainBalance;
	}

	public void isChatOptionsAvailable(int... args) {
		verifyVisible(verifyChatOptionHeader, args);
		setLogSteps(log, "Chat Options Are Available");
	}

	public void UGX_textSignAvailable(int... args) {
		verifyVisible(UGX_text, args);
		setLogSteps(log, "UGX doller Sign Are Available in Dashboard");
	}

	public void UGX_InPassbookSignAvailable(int... args) {
		verifyVisible(UGX_passbook, args);
		setLogSteps(log, "UGX doller Sign Are Available in Passbook");
	}

	public String getMainBalanceAfterTransaction(int... args) {
		pauseInSeconds(3);
		clickOnElement(btnrefresh, 0);
		enterSecretPINtocheckbalance(pin, 0);
		clickOnChkBalanceSubmitButton(0);
		pauseInSeconds(4);
		String mainBalance = getElementText(log, MAIN_BALANCE, args).trim();
		return mainBalance.split(" ")[0];
	}

	public void verifyOnboardSuccessText(int... args) {
		verifyVisible(successOnboardText, args);
		setLogSteps(log, "Verify Onboard Success Text Is Present");
	}

	public void passbookVerification(String serviceName, String transactionId) {
		clickOnPassbook(0);
		pauseInSeconds(1);
		clickOnFilterButton(0);
		pauseInSeconds(4);
		clickOnClearButton(0);
		pauseInSeconds(3);
		clickOnFilterButton(0);
		SelectDurationFilter("Last 5 Transaction", 0);
		SelectStatusFilter("Success", 0);
		pauseInSeconds(2);
		if (!serviceName.isEmpty())
			SelectServiceFilter(serviceName, 5);
		clickOnCommonSubmitButton(0);
		pauseInSeconds(3);
		verifyTransactionStatus(transactionId, 0);
	}

	public void verifyOTPScreen(int... args) {
		verifyVisible(verifyOTPScreen, args);
		setLogSteps(log, "Verified that OTP Screen is Present");
	}

	public void enterOTPOnScreen(String otp, int... args) {
		sendKeys(By.xpath("(//*[@type='password'])[1]"), "" + otp.charAt(0), 0);
		sendKeys(By.xpath("(//*[@type='password'])[2]"), "" + otp.charAt(1), 0);
		sendKeys(By.xpath("(//*[@type='password'])[3]"), "" + otp.charAt(2), 0);
		sendKeys(By.xpath("(//*[@type='password'])[4]"), "" + otp.charAt(3), 0);
		setLogSteps(log, "OTP entered from DB");
	}

	public void selectOnboardUserType(String id, int... args) {
		selectFromDropDown(log, drpOnboardUserType, By.xpath(String.format(drpValue, id)), args);
		setLogSteps(log, "Select Onboard User Type: " + id);

	}

	public void enterAgentName(String name, int... args) {
		try {
			sendKeys(txtAgentName, name, 0);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "Agent name");
		}
		setLogSteps(log, "Enter Agent Name : " + name);
	}

	public void verifyUGXSign(int... args) {
		verifyVisible(ConfirmationScreen, args);
		setLogSteps(log, "Confirmation Screen is Present");
		verifyVisible(BalanceafterPaymentText, args);
		setLogSteps(log, "Verify Balance after Payment with UGX Sign");
		verifyVisible(Amounttext, args);
		setLogSteps(log, "Verify Amount with UGX Sign");
	}

	public void verifyUGXSignConfirmationScreen(int... args) {
		verifyVisible(AvailableBalanceText, args);
		setLogSteps(log, "Verify Available Balance with UGX Sign");
		verifyVisible(Amounttext, args);
		setLogSteps(log, "Verify Amount with UGX Sign");
	}
}
