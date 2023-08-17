package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class NavigationPageOperations extends SetupInit {

	/////////////////// Tangerine start /////////////////////////
	public By txtDashP2PTranfer = By.xpath("//div[text()='P2P Transfer']");
	public By txtP2PTransferSideMenu = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='P2P Transfer']");
	public By txtP2POffnetTransferSideMenu = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='P2P Off Net']");
	public By txtP2PTransferfromFooter = By.xpath("//a[contains(text(),'P2P Transfer')]");
	public By txtP2POffnetTransferfromFooter = By.xpath("//a[contains(text(),'P2P Off Net')]");
	public By txtDashP2POffnet = By.xpath("//div[text()='P2P Off Net']");
	public By txtSend = By.xpath("//*[text()='Send']");
	public By txtChangeMPINSideMenu = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Change MPIN']");
	public By txtResetMPINSideMenu = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Reset MPIN']");
	public By txtInviteFriendsSideMenu = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Invite Friends']");
	public By txtChangeSecretWordSideMenu = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Change secret word']");
	public By txtA2ATransfer = By.xpath("//div[text()='Agent Transfer']");
	
	public By txtAgentAssistedDeposit = By.xpath("//div[text()='Agent Assisted Deposit']");
	public By txtAgentAssistedDepositIcon = By.xpath("//div[contains(text(),'Send')]");
	public By txtAgentAssistedDepositFooter = By.xpath("//a[contains(text(),'Agent Assisted Deposit')]");
	public By txtAgentAssistedDepositSideMenu = By.xpath("//span[contains(text(),'Agent Assisted Deposit')]");
	
	public By txtMenuA2ATransfer = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Agent Transfer']");
	public By txtCashOut = By.xpath("//div[text()='Withdraw Cash']");
	public By txtWithdrawCashSideMenu = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Withdraw Cash']");
	public By txtWithdrawCashFromFooter = By.xpath("//a[contains(text(),'Withdraw Cash')]");
	public By txtAgentAssistedWithdraw = By.xpath("(//div[text()='Agent Assisted Withdraw'])[1]");
	public By txtAgentAssistedWithdrawSideMenu = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Agent Assisted Withdraw']");
	public By txtAgentAssistedWithdrawFromFooter = By.xpath("//a[contains(text(),'Agent Assisted Withdraw')]");
	public By txtDashTermsAndConditions = By.xpath("//a[normalize-space(text())='Terms & Conditions']");
	public By CustomerCashinicon = By.xpath("//i[@class=\"moon-Agent-Cashin-fill-dual\"]");
	public By CustomerP2PTransfericon = By.xpath("//i[@class=\"moon-p2nr-transfer\"]");
	public By CustomerWithdrawCashicon = By.xpath("//i[@class=\"moon-Withdraw-Money\"]");
	public By CustomerTopUpBundleicon = By.xpath("(//i[@class=\" moon-Mobile-Topup\"])[1]");
	public By CustomerBillPaymenticon = By.xpath("//i[@class=\"moon-Bill-Payment2\"]");
	public By CustomerTopUpAirtimeicon = By.xpath("(//i[@class=\" moon-Mobile-Topup\"])[2]");
	public By CustomerP2pOffneticon = By.xpath("(//i[@class=\"moon-p2p-transfer\"])");
	public By CustomerFinancialServiceicon = By.xpath("(//i[@class=\"moon-Internal-Transfer\"])");
	By ForgotMpinfromLogin = By.xpath("//a[text()='Forgot MPIN?']");
	public By UserNotActive = By.xpath("//span[contains(text(),'Transaction not allowed. User is not active.')]");
	public By ProfileIconDashboard = By.xpath("//*[@id='profileSection']//a//img");

	public By txtfooterA2ATransfer = By.xpath("//*[@id='footer']//*[text()='Agent Transfer']");
	public By sideMenu = By.xpath("//*[contains(@class,'humburger') and not(@title)]//i[contains(@class,'moon-menu')]");
	By sideMenuServices = By.xpath("//*[@class='modal-content']//*[text()='Services']");
	By sideMenuSettings = By.xpath("//*[@class='modal-content']//*[text()='Settings']");
	By sideMenuWallets = By.xpath("//*[@class='modal-content']//*[text()='Wallets']");
	public By sideMenuProfile = By.xpath("//*[@class='modal-content']//*[text()='Profile']");
	public By navBarQRCode = By
			.xpath("//*[contains(@class,'humburger')]//i[contains(@class,'moon-menu-icon-QR-code')]");
	public By navBarPassbook = By.xpath("//*[contains(@class,'humburger') ]//i[contains(@class,'moon-Passbook')]");
	public By navBarLogOut = By.xpath("//*[contains(@class,'humburger') ]//i[contains(@class,'power')]");
	public By dashBoardCheckBalance = By.xpath("//*[text()='Check Balance']");
	public By sendQMoney = By.xpath("//*[@class='modal-content']//*[text()='Send Qmoney']");
	public By buyCredit = By.xpath("//*[@class='modal-content']//*[text()='Buy Credit']");
	public By bLink = By.xpath("//*[@class='modal-content']//*[text()='B-link']");
	public By buyQPower = By.xpath("//*[@class='modal-content']//*[text()='Buy Qpower']");
	public By quickPay = By.xpath("//*[@class='modal-content']//*[text()='Quick Pay']");
	public By payBills = By.xpath("//*[@class='modal-content']//*[text()='Pay Bills']");
	public By changeSecretPin = By.xpath("//*[@class='modal-content']//*[text()='Change Secret PIN']");
	public By resetSecretPin = By.xpath("//*[@class='modal-content']//*[text()='Reset Secret PIN']");
	public By changeLoginPassword = By.xpath("//*[@class='modal-content']//*[text()='Change Login Password']");
	public By support = By.xpath("//*[@class='modal-content']//*[text()='Support']");
	By walletBalances = By.xpath("//*[text()='Wallet balances']");
	public By profileDetails = By.xpath("//*[@class='modal-content']//*[text()='Profile Detail']");
	By changePassword = By.xpath("//*[text()='Change Password']");
	By changeMpin = By.xpath("//*[text()='Change MPIN']");
	By resetMpin = By.xpath("//*[text()='Reset MPIN']");
	By faqs = By.xpath("//*[@class='modal-content']//*[text()='FAQs']");
	By myProfile = By.xpath("//*[@class='modal-content']//*[text()='My Profile']");
	By myProfileDashboard = By.xpath("//a[contains(@href,'/app/profile')]");
	public By checkBalance = By.xpath("//*[contains(text(),'Check') and contains(text(),'Balance')]");
	public By faqsTitle = By.xpath("//*[contains(text(),'FAQs')]");
	public By PersonalinfoProfile = By.xpath("//p[contains(text(),'Personal info religious worship')]");
	public By AgentAssistedDepositicon = By.xpath("//i[@class=\"moon-Agent-Cashin-fill-dual\"]");
	public By AgentAssistedWithdrawicon = By.xpath("//i[@class=\"moon-Agent-Cash-Out-fill-dual\"]");
	public By AgentTransfericon = By.xpath("//i[@class=\"moon-Cashout-thr-Agent\"]");
	public By FinancialServicesicon = By.xpath("//i[@class=\"moon-Internal-Transfer\"]");

	public By DocumentinforeligiousworshipProfile = By.xpath("//p[contains(text(),'Document info religious worship')]");

	public By qrCode = By.xpath("//*[text()='QR Code']");
	public By passbook = By.xpath("//*[text()='Passbook']");
	public By logOut = By.xpath("//*[@title='Logout']");
	By reccentTransaction = By.xpath("//*[text()='Recent Transaction']");
	public By checkQMoneyPoints = By.xpath("//*[text()='Check QMoney Points']");
	public By redeemQMoneyPoints = By.xpath("//*[text()='Redeem QMoney Points']");
	public By redeemQMoneyPointsMerchant = By.xpath("(//*[text()='Redeem Qmoney Points'])[last()]");
	public By registerCustomer = By.xpath("//*[@class='modal-content']//*[text()='Register Customer']");
	public By reports = By.xpath("//*[@class='modal-content']//*[text()='Reports']");
	public By withdraw = By.xpath("//*[@class='modal-content']//*[text()='Withdraw']");
	public By dashboardCashOut = By.xpath("//div[text()='Cash Out']");
	public By sideMenucashOut = By.xpath("//*[@class='modal-content']//*[text()='Cash Out']");
	public By walletTopup = By.xpath("//*[@class='modal-content']//*[text()='Wallet Topup']");
	public By sellQPower = By.xpath("//*[@class='modal-content']//*[text()='Sell Qpower']");
	public By agentToAgentTransfer = By.xpath("//*[@class='modal-content']//*[text()='Agent To Agent Transfer']");
	public By acceptPayments = By.xpath("//*[@class='modal-content']//*[text()='Accept Payments']");
	public By redeemSubscriberPoints = By.xpath("//*[@class='modal-content']//*[text()='Redeem Subscriber Points']");
	public By cashIn = By.xpath("//*[@class='modal-content']//*[text()='Cash In']");
	public By cashTransfer = By.xpath("//*[@class='faqsTitlemodal-content']//*[text()='Cash Transfer']");
	public By callSupport = By.xpath("//*[text()='Call Support']");
	public By assistantOnboarding = By.xpath("//*[@class='modal-content']//*[text()='Assistant Onboarding']");
	public By receivePayment = By.xpath("//*[@class='modal-content']//*[text()='Receive Payment']");
	public By editProfile = By.xpath("//*[text()='Edit Profile']");
	// By editProfile = By.xpath("//*[text()='Edit']");
	public By qcellPostPaid = By.xpath("//*[@class='modal-content']//*[text()='Qcell Post Paid']");
	public By getLastQPowerToken = By.xpath("//*[@class='modal-content']//*[text()='Get Last QPower Token']");
	public By manageBeneficciary = By.xpath("//*[@class='modal-content']//*[text()='Manage Beneficiary']");
	public By merchantSettlment = By.xpath("//*[@class='modal-content']//*[text()='Marchant Settlement']");
	public By merchantSettlment_dasboard = By.xpath("//*[text()='Merchant Settlement']");
	public By mobileTopUp = By.xpath("//*[@class='modal-content']//*[text()='Mobile Topup']");
	public By redeemToken = By.xpath("//*[@class='modal-content']//*[text()='Redeem Token']");
	public By redeemCashToken = By.xpath("//*[text()='Redeem Cash Token']");
	public By agentOnboarding = By.xpath("//div[text()='Agent Onboarding']");
	public By cashTransferDashboard = By.xpath("//*[text()='Cash Transfer']");
	public By cashInDashboard = By.xpath("//*[text()='Cash In']");
	public By withdrawDashboard = By.xpath("//*[@class='service_area box_area dashboard-class']//*[text()='Withdraw']");
	public By walletTopupDashboard = By.xpath("//*[text()='Wallet Topup']");
	public By sellQPowerDashboard = By.xpath("//*[text()='Sell Qpower']");
	public By agentToAgentTransferDashboard = By.xpath("//*[text()='Agent To Agent Transfer']");
	public By acceptPaymentsDashboard = By.xpath("//*[text()='Accept Payments']");
	public By assistantOnboardingDashboard = By.xpath("//a[normalize-space(text())='Assistant Onboarding']");
	public By bLinkForMerchant = By.xpath("//*[@class='modal-content']//*[text()='B-Link']");
	// public By qrCodeForMerchant = By.xpath("//*[@title='My QR Code']");
	public By qrCodeForMerchant = By
			.xpath("//*[contains(@title,'My') and contains(@title,'QR') and contains(@title,'Code')]");
	public By passbookForMerchant = By.xpath("//*[@title='Passbook']");
	public By logOutForMerchant = By.xpath("//*[@title='Logout']");
	public By P2PUnRegisteredTransfer = By
			.xpath("//*[@class='modal-content']//*[text()='P2P Unregistered User Transfer']");
	public By dashboardBuyCredit = By.xpath("//div[text()='Buy Credit']");
	public By dashboardSendQMoney = By.xpath("//div[text()='Send QMoney']");
	public By dashboardBuyQPower = By.xpath("//div[text()='Buy QPower']");
	public By dashboardQuickPay = By.xpath("//div[text()='Quick Pay']");
	public By dashboardPayBills = By.xpath("//div[text()='Pay Bills']");
	public By dashboardQcellPostPaid = By.xpath("//div[text()='Qcell - Post Paid']");
	public By servicesRedeemPoints = By.xpath("//*[@class='modal-content']//*[text()='Redeem QMoney Points']");
	public By dashboardBLink = By.xpath("//div[text()='B-Link']");
	public By dashboardProfileDetails = By.xpath("//*[@id='profileSection']//*[contains(@class,'row my-account')]//a");
	public By productInformation = By.xpath("//*[@class='modal-content']//*[text()='Product Information']");
	public By dashboardRegisterCustomer = By.xpath("//*[text()='Register Customer']");
	public By dashboardRedeemSubscriberpoint = By.xpath("//*[text()='Redeem Subscriber Points']");
	public By dashboardReceivePayment = By.xpath("//div[text()='Receive Payment']");
	public By dashboardCustomer = By.xpath("//div[text()='Register Customer']");
	public By clickActivate = By.xpath("//*[@index='link_area_id']");
	// Nass Enterprise
	public By withdrawMoney = By.xpath("//*[@class='modal-content']//*[text()='Withdraw Money']");
	public By txtSalaryDisbursement = By.xpath("//*[text()='Salary Disbursement']");
	public By txtDisbursementRequestList = By.xpath("//*[text()='Disbursement Request List']");
	public By txtB2BTransfer = By.xpath("//div[text()='B2B Transfer']");
	public By txtWithdrawMoney = By.xpath("//div[text()='Withdraw Money']");
	public By txtDisbursementReport = By.xpath("//*[contains(@class,'title') and text()='Disbursement Report']");
	public By txtTransactionDetail = By.xpath("//*[text()='Transactions']//parent::*[@class='card_area']");
/*	public By txtDashBulkPayment = By.xpath("//a[text()='Bulk Payment']");
	public By txtDashDisbursementReport = By.xpath("//a[text()='Disbursement Report']");
	public By txtDashTransactionDetail = By.xpath("//a[text()='Transactions']");
	public By txtDashOnboardingReport = By.xpath("//a[text()='Onboarding Report']");
	public By txtDashMyProfile = By.xpath("//a[text()='My Profile']");
	public By txtDashMyTransaction = By.xpath("//a[text()='My Transactions']");
	public By txtDashChangeMPIN = By.xpath("//a[text()='Change MPIN']");
	public By txtDashChangeLoginPassword = By.xpath("//a[text()='Change Login Password']");
	

	public By txtDashChangeLanguage = By.xpath("//a[text()='Change Language']");
	public By txtDashAboutUs = By.xpath("//a[text()='About Us']");
	public By txtDashContactUs = By.xpath("//a[text()='Contact Us']");
	public By txtDashPasswordPolicy = By.xpath("//a[text()='Password Policy'][1]");
	public By txtDashMPINPolicy = By.xpath("//a[text()='MPIN Policy']");
//	public By txtDashTermsAndConditions = By.xpath("//a[text()='Terms & Conditions']");
	public By txtDashPrivacyPolicy = By.xpath("//a[text()='Privacy Policy']"); */

	public By txtProfileLoginPassword = By.xpath("//span[text()='Change Password']");
	public By txtDashBulkPayment = By.xpath("//a[normalize-space(text())='Bulk Payment']");
	public By txtDashDisbursementReport = By.xpath("//a[normalize-space(text())='Disbursement Report']");
	public By txtDashTransactionDetail = By.xpath("//a[normalize-space(text())='Transactions']");
	public By txtDashOnboardingReport = By.xpath("//a[normalize-space(text())='Onboarding Report']");
	public By txtDashMyProfile = By.xpath("//a[normalize-space(text())='My Profile']");
	public By txtDashMyTransaction = By.xpath("//a[normalize-space(text())='My Transactions']");
	public By txtDashChangeMPIN = By.xpath("//a[normalize-space(text())='Change MPIN']");
	public By txtDashChangeLoginPassword = By.xpath("//a[normalize-space(text())='Change Login Password']");
	public By txtDashChangeLanguage = By.xpath("//a[normalize-space(text())='Change Language']");
	public By txtDashAboutUs = By.xpath("//a[normalize-space(text())='About Us']");
	public By txtDashContactUs = By.xpath("//a[normalize-space(text())='Contact Us']");
	public By txtDashPasswordPolicy = By.xpath("//a[normalize-space(text())='Password Policy']");
	public By txtDashMPINPolicy = By.xpath("//a[normalize-space(text())='MPIN Policy']");
	public By txtMyProfilePasswordPolicy = By.xpath("//a[normalize-space(text())='Password Policy']");
	
	public By txtDashPrivacyPolicy = By.xpath("//a[normalize-space(text())='Privacy Policy']");

	public By txtMenuSalaryDisbursement = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Salary Disbursement']");
	public By txtMenuDisbursementRequestList = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Disbursement Request List']");
	public By txtMenuB2BTransfer = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='B2B Transfer']");
	public By txtMenuWithdrawMoney = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Withdraw Money']");
	public By txtMenuDisbursementReport = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Disbursement Report']");
	public By txtMenuTransactionDetail = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Transactions']");
	public By txtMenuOnboardingDetail = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Onboarding Detail']");
	public By txtMenuChangeMPIN = By.xpath("//*[@class='modal-content']//*[text()='Change MPIN']");

	public By btnChangeMPIN = By.xpath("//a[contains(text(),'MPIN Policy')]");

	public By txtMenuChangePassword = By.xpath("//*[@class='modal-content']//*[text()='Change Password']");

	public By txtMenuResetMPIN = By.xpath("//*[@class='modal-content']//*[text()='Reset MPIN']");
	public By txtMenuChangeLoginPassword = By.xpath("//*[@class='modal-content']//*[text()='Change Login Password']");
	public By txtMenuPasswordPolicy = By.xpath("//*[@class='modal-content']//*[text()='Password Policy']");
	public By txtMenuMPINPolicy = By.xpath("//*[@class='modal-content']//*[text()='MPIN Policy']");
	public By txtMenuTermsAndConditions = By.xpath("//*[@class='modal-content']//*[text()='Terms & Conditions']");
	public By txtMenuPrivacyPolicy = By.xpath("//*[@class='modal-content']//*[text()='Privacy Policy']");
	public By txtMenuChangeLanguage = By.xpath("//*[@class='modal-content']//*[text()='Change Language']");
	public By txtMenuAboutUs = By.xpath("//*[@class='modal-content']//*[text()='About Us']");
	public By txtMenuContactUs = By.xpath("//*[@class='modal-content']//*[text()='Contact Us']");
	public By txtMenuViewProfile = By.xpath("//*[@class='modal-content']//*[text()='My Profile']");
	public By txtMainWallet = By.xpath("//*[@class='modal-content']//*[text()='Main Wallet']");
	public By txtChangeMpinFromProfile = By.xpath("//*[contains(@class,'manage-profile')]//*[text()='Change MPIN']");
	public By txtChangePasswordFromProfile = By
			.xpath("//*[contains(@class,'manage-profile')]//*[text()='Change Password']");
	public By txtResetMpinFromProfile = By.xpath("//*[contains(@class,'manage-profile')]//*[text()='Reset MPIN']");
	public By logOutForNass = By.xpath("//*[contains(@class,'power')]");
	public By txtMoneyTranfer = By.xpath("//div[contains(text(),'Money Transfer')]");

	public By txtMerchantPayment = By.xpath("//*[text()='Merchant Payment']");
	public By txtMenuMerchantPayment = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Merchant Payment']");
	public By txtDashMerchantPayment = By.xpath("//a[normalize-space(text())='Merchant Payment']");
	public By txtEnterprisePayment = By.xpath("//*[text()='Enterprise Payment']");
	public By txtMenuEnterprisePayment = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Enterprise Payment']");
	public By txtDashEnterprisePayment = By.xpath("//a[normalize-space(text())='Merchant Payment']");
	public By txtMobileTopup = By.xpath("//*[text()='Mobile Top up']");
	public By txtMenuMobileTopup = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Mobile Top up']");
	public By txtDashMobileTopup = By.xpath("//a[normalize-space(text())='Top Up']");
	public By txtMobilePostpaid = By.xpath("//*[text()='Mobile Postpaid']");
	public By txtMenuMobilePostpaid = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Mobile Postpaid']");
	public By txtDashMobilePostpaid = By.xpath("//a[normalize-space(text())='Bill Payment']");

	public By txtNasswalletAccountHolder = By
			.xpath("//*[contains(text(),'NassWallet') and contains(text(),'Account Holder')]");
	public By txtNasswalletMerchant = By
			.xpath("(//*[contains(text(),'NassWallet') and contains(text(),'Merchant')])[last()]");
	By homeLogo = By.xpath("//img[@alt='logo']");
	By chat = By.id("maximizeChat");
	public By txtDashB2BTranfer = By.xpath("//a[normalize-space(text())='B2B Transfer']");
	public By txtDashWithdrawMoney = By.xpath("//a[normalize-space(text())='Withdraw Money']");
	public By txtM2MTransfer = By.xpath("//div[text()='M2M Transfer']");
	public By txtMenuM2MTransfer = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='M2M Transfer']");
	public By txtDashM2MTransfer = By.xpath("//a[normalize-space(text())='M2M Transfer']");
	public By txtMerchantRefund = By.xpath("//div[text()='Merchant Refund']");
	public By txtMenuMerchantRefund = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Merchant Refund']");
	public By txtDashMerchantRefund = By.xpath("//a[normalize-space(text())='Merchant Refund']");
	public By txtAssistantOnboarding = By.xpath("//div[text()='Assistant Onboarding']");
	public By txtMenuAssistantOnboarding = By.xpath("//*[@class='modal-content']//*[text()='Assistant Onboarding']");
	public By txtManageAssistant = By.xpath("//div[text()='Manage Assistant']");
	public By txtMenuManageAssistant = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Manage Assistant']");
	public By txtDashManageAssistant = By.xpath("//a[normalize-space(text())='Manage Assistant']");
	public By txtTellerOnboarding = By.xpath("//div[text()='Teller Onboarding']");
	public By txtMenuTellerOnboarding = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Teller Onboarding']");
	public By txtDashTellerOnboarding = By.xpath("//a[normalize-space(text())='Teller Onboarding']");
	public By txtManageTeller = By.xpath("//div[text()='Manage Teller']");
	public By txtMenuManageTeller = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Manage Teller']");
	public By txtDashManageTeller = By.xpath("//a[normalize-space(text())='Manage Teller']");
	public By commissionReport = By.xpath("//a[normalize-space(text())='Commission Report']");

	public By txtCashInByAgent = By.xpath("//div[text()='Cash In By Agent']");
	public By txtMenuCashInByAgent = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Cash In By Agent']");
	public By txtDashCashInByAgent = By.xpath("//a[normalize-space(text())='Cash In By Agent']");
	public By txtUpdateCustomerKYC = By.xpath("//div[text()='Update KYC']");
	public By txtMenuUpdateCustomerKYC = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Update Customer KYC']");
	public By txtDashUpdateCustomerKYC = By.xpath("//a[normalize-space(text())='Update Customer KYC']");
	public By txtCustomerOnboarding = By.xpath("//div[text()='Customer Onboarding']");
	public By txtMenuCustomerOnboarding = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Customer Onboarding']");
	public By txtDashCustomerOnboarding = By.xpath("//a[normalize-space(text())='Customer Onboarding']");
	public By txtManageAgent = By.xpath("//div[text()='Manage Agent']");
	public By txtMenuManageAgent = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Manage Agent']");
	public By txtDashManageAgent = By.xpath("//a[normalize-space(text())='Manage Agent']");
	public By txtMenuAgentOnboarding = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Agent Onboarding']");
	public By txtDashAgentOnboarding = By.xpath("//a[normalize-space(text())='Agent Onboarding']");
	public By txtMenuCommissionReport = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Commission Report']");
	public By txtTransactionSummary = By.xpath("//*[text()='Transaction Summary']//parent::*[@class='card_area']");
	public By txtDashTransactionSummary = By.xpath("//a[normalize-space(text())='Transaction Summary']");
	public By txtMenuTransactionSummary = By
			.xpath("//*[contains(@activeclassname,'active')]//*[text()='Transaction Summary']");
	elasticwrite log;
	By forgottenMPIN = By.xpath("//*[text()='Forgotten MPIN ?']");
	public By txtCommissionReport = By.xpath("//div[text()='Commission Report']");
	public By txtDashCommissionReport = By.xpath("//a[normalize-space(text())='Commission Report']");
	By forgottenPassword = By.xpath("//*[text()='Forgotten Password?']");
	By newUser = By.xpath("//*[text()='New User?']");
	public By txteVoucher = By.xpath("//*[text()='eVoucher']");
	public By txteArbelaStore = By.xpath("//*[text()='Arbela Store']");
	public By txtMenueVoucher = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='eVoucher']");
	public By txtMenuArbelaStore = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Arbela Store']");
	public By txteVoucherCustomer = By.xpath("//*[text()='eVoucher Sale']");
	public By txtAirtimeSale = By.xpath("//*[text()='Airtime Sale']");
	public By txtMenuAirtimeSale = By.xpath("//*[contains(@activeclassname,'active')]//*[text()='Airtime Sale']");
	public By txtDashAirtimeSale = By.xpath("//a[text()='Airtime Sale']");

	public void clickOnInviteFriendsfromSideMenu(int... args) {
		try {
			clickOnElement(sideMenu, args);
			clickOnElement(sideMenuSettings, args);
			clickOnElement(this.log, txtInviteFriendsSideMenu, args);
			setLogSteps(log, "Click On Invite Friends");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Click On Invite Friends");
		}
	}

	public NavigationPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void clickOnSideMenu(int... args) {
		try {
			clickOnElement(sideMenu, args);
			setLogSteps(log, "Click On Side Menu");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu");
		}
	}

	public void clickOnSideMenuServices(int... args) {
		clickOnSideMenu(args);
		try {
			clickOnElement(sideMenuServices, args);
			setLogSteps(log, "Click On Services");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - services");
		}
	}

	public void clickOnSideMenuWallets(int... args) {
		clickOnSideMenu(args);
		try {
			clickOnElement(sideMenuWallets, args);
			setLogSteps(log, "Click On Walltes");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - wallets");
		}
	}

	public void clickOnSideMenuProfile(int... args) {
		clickOnSideMenu(args);
		try {
			clickOnElement(sideMenuProfile, args);
			setLogSteps(log, "Click On Profile");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - profile");
		}
	}
	
	public void clickOnMenuProfile(int... args) {
		try {
			clickOnElement(sideMenuProfile, args);
			setLogSteps(log, "Click On Profile");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - profile");
		}
	}

	public void clickOnNavBarQRCode(int... args) {
		try {
			clickOnElement(navBarQRCode, args);
			setLogSteps(log, "Click On QR Code");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "qr code");
		}
	}

	public void clickOnNavBarPassbook(int... args) {
		try {
			clickOnElement(navBarPassbook, args);
			setLogSteps(log, "Click On Passbook");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "passbook");
		}
	}

	public void clickOnNavBarLogOut(int... args) {
		try {
			clickOnElement(navBarLogOut, args);
			setLogSteps(log, "Click On Logout");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "logout");
		}
	}

	public void clickOnDashBoardCheckBalance(int... args) {
		try {
			clickOnElement(dashBoardCheckBalance, args);
			setLogSteps(log, "Click On Check Balance");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "view balance");
		}
	}

	public void clickOnSideMenuServicesSendQMoney(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(sendQMoney, args);
			setLogSteps(log, "Click On Send QMoney");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - services - send qmoney");
		}
	}

	public void clickOnSideMenuServicesBuyCredit(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(buyCredit, args);
			setLogSteps(log, "Click On Buy Credit");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - services - buy credit");
		}
	}

	public void clickOnSideMenuServicesBLink(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(bLink, args);
			setLogSteps(log, "Click On BLink");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - services - blink");
		}
	}

	public void clickOnSideMenuServicesBuyQPower(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(buyQPower, args);
			setLogSteps(log, "Click On Buy QPower");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - services - buy qpower");
		}
	}

	public void clickOnSideMenuServicesQuickPay(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(quickPay, args);
			setLogSteps(log, "Click On Quick Pay");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - services - quick pay");
		}
	}

	public void clickOnSideMenuServicesPayBills(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(payBills, args);
			setLogSteps(log, "Click On Pay Bills");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - services - pay bills");
		}
	}

	public void clickOnSideMenuSettingsChangeSecretPin(int... args) {
		clickOnSideMenuSettings(args);
		try {
			clickOnElement(changeSecretPin, args);
			setLogSteps(log, "Click On Change Secret Pin");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - settings - change secret pin");
		}
	}

	public void clickOnSideMenuSettingsResetSecretPin(int... args) {
		clickOnSideMenuSettings(args);
		try {
			clickOnElement(resetSecretPin, args);
			setLogSteps(log, "Click On Reset Secret Pin");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - settings - reset secret pin");
		}
	}

	public void clickOnSideMenuSettingsChangeLoginPassword(int... args) {
		clickOnSideMenuSettings(args);
		try {
			clickOnElement(changeLoginPassword, args);
			setLogSteps(log, "Click On Change Login Password");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - settings - change login password");
		}
	}

	public void clickOnSideMenuSettingsSupport(int... args) {
		clickOnSideMenuSettings(args);
		try {
			clickOnElement(support, args);
			setLogSteps(log, "Click On Support");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - settings - support");
		}
	}

	public void clickOnWalletBalances(int... args) {
		try {
			clickOnElement(walletBalances, args);
			setLogSteps(log, "Click On Wallet");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "wallet balance");
		}
	}

	public void clickOnSideMenuProfileProfileDetails(int... args) {
		clickOnSideMenuProfile(args);
		try {
			clickOnElement(profileDetails, args);
			setLogSteps(log, "Click On Profile Details");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "side menu - profile - profile details");
		}
	}

	public void clickOnChangePassword(int... args) {
		try {
			clickOnElement(changePassword, args);
			setLogSteps(log, "Click On Change Password");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change password");
		}
	}

	public void clickOnChangeMPin(int... args) {
		try {
			clickOnElement(changeMpin, args);
			setLogSteps(log, "Click On Change MPin");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change mpin");
		}
	}

	public void clickOnResetMPin(int... args) {
		try {
			clickOnElement(resetMpin, args);
			setLogSteps(log, "Click On Reset MPin");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "reset mpin");
		}
	}

	public void clickOnSideMenuProfileFAQs(int... args) {
		clickOnSideMenuProfile(args);
		try {
			clickOnElement(faqs, args);
			setLogSteps(log, "Click On FAQs");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "faqs");
		}
	}

	public void clickOnCheckBalance(int... args) {
		try {
			clickOnElement(checkBalance, args);
			setLogSteps(log, "Click On Check Balance");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "view balance");
		}
	}

	public void clickOnQRCode(int... args) {
		try {
			clickOnElement(qrCode, args);
			setLogSteps(log, "Click On QR Code");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "qr code");
		}
	}

	public void clickOnPassbook(int... args) {
		try {
			clickOnElement(passbook, args);
			setLogSteps(log, "Click On Passbook");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "passbook");
		}
	}

	public void clickOnLogOut(int... args) {
		reloadCurrentPage(driver);
		if (!verifyVisible(logOut, 3)) {
			reloadCurrentPage(driver);

		}
		try {
			clickOnElement(logOut);
			if (verifyVisible(logOut, 3)) {
				clickOnElementUsingJS(logOut, args);
			}
			setLogSteps(log, "Click On Logout");
		} catch (Exception e) {
			try {
				if (verifyVisible(logOut, 3)) {
					clickOnElementUsingJS(logOut, args);
				}
				setLogSteps(log, "Click On Logout");
			} catch (Exception e1) {
				System.out.println(e1);
				throw new RuntimeException(CLICK_ERROR_MESSAGE + "logout");
			}

		}
	}

	public void clickOnRecentTransaction(int... args) {
		try {
			clickOnElement(reccentTransaction, args);
			setLogSteps(log, "Click On Recent Transaction");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "recent transaction");
		}
	}

	public void clickOnCheckQMoneyPoints(int... args) {
		moveToElement(checkQMoneyPoints);
		try {
			clickOnElement(checkQMoneyPoints, args);
			setLogSteps(log, "Click On Check QMoney Points");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "check qmoney points");
		}
	}

	public void clickOnRedeemQMoneyPoints(int... args) {
		moveToElement(checkQMoneyPoints);
		try {
			clickOnElement(redeemQMoneyPoints, args);
			setLogSteps(log, "Click On Redeem QMoney Points");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "redeem qmoney points");
		}
	}

	public void clickOnRegisterCustomer(int... args) {
		try {
			clickOnElement(registerCustomer, args);
			setLogSteps(log, "Click On Register Customer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "register customer");
		}
	}

	public void clickOnReports(int... args) {
		try {
			clickOnElement(reports, args);
			setLogSteps(log, "Click On Reports");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "reports");
		}
	}

	public void clickOnWithDraw(int... args) {
		try {
			clickOnElement(withdraw, args);
			setLogSteps(log, "Click On Withdraw");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "withdraw");
		}
	}

	public void clickOnSideMenuCashOut(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(sideMenucashOut, args);
			setLogSteps(log, "Click On Withdraw Cash");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Withdraw Cash");
		}
	}

	public void clickOnWalletTopup(int... args) {
		try {
			clickOnElement(walletTopup, args);
			setLogSteps(log, "Click On Wallet TopUp");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "wallet topup");
		}
	}

	public void clickOnSellQPower(int... args) {
		try {
			clickOnElement(sellQPower, args);
			setLogSteps(log, "Click On Sell QPower");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "sell qpower");
		}
	}

	public void clickOnAgentToAgentTransfer(int... args) {
		try {
			clickOnElement(agentToAgentTransfer, args);
			setLogSteps(log, "Click On Agent to Agent Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "agent to agent transfer");
		}
	}

	public void clickOnAcceptPayments(int... args) {
		try {
			clickOnElement(acceptPayments, args);
			setLogSteps(log, "Click On Accept Payment");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "accept payments");
		}
	}

	public void clickOnRedeemSubscriberPoints(int... args) {
		try {
			clickOnElement(redeemSubscriberPoints, args);
			setLogSteps(log, "Click On Redeem Sunscriber Points");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "redeem subscriber points");
		}
	}

	public void clickOnCashIn(int... args) {
		try {
			clickOnElement(cashIn, args);
			setLogSteps(log, "Click On Cash In");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "cash in");
		}
	}

	public void clickOnCashTransfer(int... args) {
		try {
			clickOnElement(cashTransfer, args);
			setLogSteps(log, "Click On Cash Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "cash transfer");
		}
	}

	public void clickOnCallSupport(int... args) {
		// moveToElement(callSupport);
		try {
			clickOnElement(callSupport, args);
			setLogSteps(log, "Click On Call Support");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "call support");
		}
	}

	public void clickOnAssistantOnboarding(int... args) {
		try {
			clickOnElement(txtAssistantOnboarding, args);
			setLogSteps(log, "Click On Assistant Onboarding");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "assistant onboarding");
		}
	}

	public void clickOnReceivePayment(int... args) {
		try {
			clickOnElement(receivePayment, args);
			setLogSteps(log, "Click On Receiver Payment");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "receive payment");
		}
	}

	public void clickOnEditProfile(int... args) {
		try {
			clickOnElement(editProfile, args);
			setLogSteps(log, "Click On Edit Profile");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "edit profile");
		}
	}

	public void clickOnSideMenuServicesQCellPostPaid(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(qcellPostPaid, args);
			setLogSteps(log, "Click On QCell PostPaid");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "qcell post paid");
		}
	}

	public void clickOnSideMenuServicesGetLastQPowerToken(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(getLastQPowerToken, args);
			setLogSteps(log, "Click On get Last QPower Token");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "get last qpower token");
		}
	}

	public void clickOnSideMenuServicesManageBeneficiary(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(manageBeneficciary, args);
			setLogSteps(log, "Click On Manage Beneficiary");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "manage beneficiary");
		}
	}

	public void clickOnSideMenuSettings(int... args) {
		clickOnSideMenu(args);
		try {
			clickOnElement(this.log, sideMenuSettings, 0);
			setLogSteps(log, "Click On Setting");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "settings");
		}
	}

	public void clickOnSideMenuServicesMerchantSettlement(int... args) {
		try {
			clickOnElement(this.log, merchantSettlment, args);
			setLogSteps(log, "Click On Merchant Settlement");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "merchant settlement");
		}
	}

	public void clickOnSideMenuServicesMobileTopUp(int... args) {
		try {
			clickOnElement(this.log, mobileTopUp, args);
			setLogSteps(log, "Click On Mobile TopUp");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "mobile topup");
		}
	}

	public void clickOnSideMenuServicesCashTransfer(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(this.log, cashTransfer, args);
			setLogSteps(log, "Click On Cash Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "cash transfer");
		}
	}

	public void clickOnSideMenuServicesCashIn(int... args) {
		try {
			clickOnElement(this.log, cashIn, args);
			setLogSteps(log, "Click On CashIn");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "cash in");
		}
	}

	public void clickOnSideMenuServicesWithdraw(int... args) {
		try {
			clickOnElement(this.log, withdraw, args);
			setLogSteps(log, "Click On Withdraw");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "withdraw");
		}
	}

	public void clickOnSideMenuServicesWalletTopup(int... args) {
		try {
			clickOnElement(this.log, walletTopup, args);
			setLogSteps(log, "Click On Wallet TopUp");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "wallet topup");
		}
	}

	public void clickOnSideMenuServicesAgentToAgentTransfer(int... args) {
		try {
			clickOnElement(this.log, agentToAgentTransfer, args);
			setLogSteps(log, "Click On Agent To Agent Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "agent to agent transfer");
		}
	}

	public void clickOnSideMenuServicesRedeemToken(int... args) {
		try {
			clickOnElement(this.log, redeemToken, args);
			setLogSteps(log, "Click On Rdeem Token");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "redeem token");
		}
	}

	public void clickOnRedeemCashToken(int... args) {
		try {
			clickOnElement(this.log, redeemCashToken, args);
			setLogSteps(log, "Click On Redeem Cash Token");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "cash token");
		}
	}

	public void clickOnAgentOnboarding(int... args) {
		try {
			clickOnElement(this.log, agentOnboarding, args);
			setLogSteps(log, "Click On Agent Onboarding");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "agent onboarding");
		}
	}

	public void clickOnDashboardCashTransfer(int... args) {
		try {
			clickOnElement(cashTransferDashboard, args);
			setLogSteps(log, "Click On Cash Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "cash transfer");
		}
	}

	public void clickOnDashboardCashIn(int... args) {
		try {
			clickOnElement(cashInDashboard, args);
			setLogSteps(log, "Click On CashIn");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "cash in");
		}
	}

	public void clickOnDashboardWithdraw(int... args) {
		try {
			clickOnElement(withdrawDashboard, args);
			setLogSteps(log, "Click On Withdraw");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "withdraw");
		}
	}

	public void clickOnDashboardWalletTopup(int... args) {
		try {
			clickOnElement(walletTopupDashboard, args);
			setLogSteps(log, "Click On Wallet TopUp");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "wallet topup");
		}
	}

	public void clickOnDashboardSellQPower(int... args) {
		try {
			clickOnElement(sellQPowerDashboard, args);
			setLogSteps(log, "Click On Sell QPower");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "sell qpower");
		}
	}

	public void clickOnDashboardAgentToAgentTransfer(int... args) {
		try {
			clickOnElement(agentToAgentTransferDashboard, args);
			setLogSteps(log, "Click On Agent To Agent Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "agent to agent transfer");
		}
	}

	public void clickOnDashboardAcceptPayments(int... args) {
		try {
			clickOnElement(acceptPaymentsDashboard, args);
			setLogSteps(log, "Click On Accept Payments");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "accept payments");
		}
	}

	public void clickOnDashboardAssistantOnboarding(int... args) {
		try {
			clickOnElement(assistantOnboardingDashboard, args);
			setLogSteps(log, "Click On Assistant Onboarding");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "assistant onboarding");
		}
	}

	public void clickOnSideMenuServicesBLinkForMerchant(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(bLinkForMerchant, args);
			setLogSteps(log, "Click On BLink");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "blink");
		}
	}

	public void clickOnLogOutForMerchant(int... args) {
		try {
			clickOnElement(logOutForMerchant, args);
			setLogSteps(log, "Click On Logout");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "logout");
		}
	}

	public void clickOnSideMenuServicesP2PUnRegisteredUserTransfer(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(P2PUnRegisteredTransfer, args);
			setLogSteps(log, "Click On P2P UnRegistered User Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "p2p unregistered user transfer");
		}
	}

	public void clickOnDashboardBuyCredit(int... args) {
		try {
			clickOnElement(dashboardBuyCredit, args);
			setLogSteps(log, "Click On Buy Credit");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "buy credit");
		}
	}

	public void clickOnDashboardSendQMoney(int... args) {
		try {
			clickOnElement(dashboardSendQMoney, args);
			setLogSteps(log, "Click On Send QMoney");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "send qmoney");
		}
	}

	public void clickOnDashboardBuyQpower(int... args) {
		try {
			clickOnElement(dashboardBuyQPower, args);
			setLogSteps(log, "Click On Buy QPower");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "buy qpower");
		}
	}

	public void clickOnDashboardQuickPay(int... args) {
		try {
			clickOnElement(dashboardQuickPay, args);
			setLogSteps(log, "Click On Quick Pay");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "quick pay");
		}
	}

	public void clickOnDashboardPayBills(int... args) {
		try {
			clickOnElement(dashboardPayBills, args);
			setLogSteps(log, "Click On Pay Bills");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "pay bills");
		}
	}

	public void clickOnDashboardQcellPostPaid(int... args) {
		try {
			clickOnElement(dashboardQcellPostPaid, args);
			setLogSteps(log, "Click On Qcell Post Paid");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "qcell post paid");
		}
	}

	public void clickOnSideMenuRedeemQMoneyPoints(int... args) {
		try {
			clickOnElement(servicesRedeemPoints, args);
			setLogSteps(log, "Click On Redeem QMoney Points");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "redeem qmoney points");
		}
	}

	public void clickOnDashboardBLink(int... args) {
		try {
			clickOnElement(dashboardBLink, args);
			setLogSteps(log, "Click On BLink");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "blink");
		}
	}

	public void clickOnDashboardProfileDetail(int... args) {
		try {
			clickOnElement(dashboardProfileDetails, args);
			setLogSteps(log, "Click On Profile Details");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "profile details");
		}
	}

	public void clickOnRegisterCustomerFromDashboard(int... args) {
		try {
			clickOnElement(dashboardRegisterCustomer, args);
			setLogSteps(log, "Click On Register Customer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "register customer");
		}
	}

	public void clickOnRedeemSubscriberPointsFromDashboard(int... args) {
		try {
			clickOnElement(dashboardRedeemSubscriberpoint, args);
			setLogSteps(log, "Click On Redeem Sunscriber Points");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "redeem subscriber points");
		}
	}

	public void clickOnReceivePaymentFromDashboard(int... args) {
		try {
			clickOnElement(dashboardReceivePayment, args);
			setLogSteps(log, "Click On Receiver Payment");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "receive payment");
		}
	}

	public void clickOnActivateNowLink(int... args) {
		try {
			clickOnElement(clickActivate, args);
			setLogSteps(log, "Click On Activate User Link");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "activate user link");
		}
	}

	public void clickOnDashboardMerchantSettlement(int... args) {
		try {
			clickOnElement(this.log, merchantSettlment_dasboard, args);
			setLogSteps(log, "Click On Merchant Settlement");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "merchant settlement");
		}
	}

	public void clickOnSideMenuServicesAcceptPayments(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(acceptPayments, args);
			setLogSteps(log, "Click On Accept Payment");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "accept payment");
		}
	}

	public void clickOnSideMenuServicesWithdrawMoney(int... args) {
		try {
			clickOnElement(this.log, withdrawMoney, args);
			setLogSteps(log, "Click On Withdraw Money");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "withdraw money");
		}
	}

	public void clickOnSideMenuServicesB2BTransfer(int... args) {
		try {
			clickOnElement(this.log, txtMenuB2BTransfer, args);
			setLogSteps(log, "Click On B2B Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "b2b transfer");
		}
	}

	public void clickOnChangePasswordForEnterpriseFromProfile(int... args) {
		try {
			clickOnElement(txtChangePasswordFromProfile, args);
			setLogSteps(log, "Click On Change Password");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change password");
		}
	}

	public void clickOnChangeMPinForEnterpriseFromProfile(int... args) {
		try {
			clickOnElement(txtChangeMpinFromProfile, args);
			setLogSteps(log, "Click On Change MPin");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change mpin");
		}
	}

	public void clickOnResetMPinForEnterpriseFromProfile(int... args) {
		try {
			clickOnElement(txtResetMpinFromProfile, args);
			setLogSteps(log, "Click On Reset MPin");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "reset mpin");
		}
	}

	public void clickOnChangePasswordForEnterpriseFromDashLink(int... args) {
		try {
			clickOnElement(txtDashChangeLoginPassword, args);
			setLogSteps(log, "Click On Change Password");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change password");
		}
	}

	public void clickOnChangeMPinForEnterpriseFromDashLink(int... args) {
		try {
			clickOnElement(txtDashChangeMPIN, args);
			setLogSteps(log, "Click On Change MPin");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change mpin");
		}
	}

	public void clickOnSideMenuProfileViewProfile(int... args) {
		clickOnSideMenuProfile(args);
		try {
			clickOnElement(txtMenuViewProfile, args);
			setLogSteps(log, "Click On View Profile");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "view profile");
		}
	}
	
	public void clickOnMenuProfileViewProfile(int... args) {
		try {
			clickOnElement(txtMenuViewProfile, args);
			setLogSteps(log, "Click On View Profile");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "view profile");
		}
	}

	public void clickOnSideMenuSettingsChangeMPIN(int... args) {
		clickOnSideMenuSettings(args);
		try {
			clickOnElement(btnChangeMPIN, args);
			setLogSteps(log, "Click On Change MPIN");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change mpin");
		}
	}

	public void clickOnChangeLoginPassword(int... args) {
		try {
			clickOnElement(txtMenuChangeLoginPassword, args);
			setLogSteps(log, "Click On Change Login Password");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change login password");
		}
	}

	public void clickOnChangeMPIN(int... args) {
		try {
			clickOnElement(txtMenuChangeMPIN, args);
			setLogSteps(log, "Click On Change MPIN");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change mpin");
		}
	}

	public void clickOnSideMenuPasswordPolicyFromSettings(int... args) {
		try {
			clickOnElement(txtMenuPasswordPolicy, args);
			setLogSteps(log, "Click On Password Policy");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "password policy");
		}
	}

	public void clickOnSideMenuMPINPolicyFromSettings(int... args) {
		try {
			clickOnElement(btnChangeMPIN, args);
			setLogSteps(log, "Click On Change MPIN");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "mpin policy");
		}
	}

	public void clickOnSideMenuMPINPolicyChangeMPIN(int... args) {
		try {
			clickOnElement(btnChangeMPIN, args);
			clickOnElement(txtMenuChangeMPIN, args);
			clickOnElement(By.xpath("//*[normalize-space(text())='MPIN Policy']"), args);
			setLogSteps(log, "Click On Change MPIN");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "mpin policy");
		}
	}

	public void clickOnDashboardPasswordPolicy(int... args) {
		try {
			clickOnElement(txtDashPasswordPolicy, args);
			setLogSteps(log, "Click On Password Policy");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "password policy");
		}
	}

	public void clickOnDashboardMPINPolicy(int... args) {
		try {
			clickOnElement(txtDashMPINPolicy, args);
			setLogSteps(log, "Click On MPIN Policy");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "mpin policy");
		}
	}

	public void clickOnSideMenuPrivacyPolicyFromSettings(int... args) {
		try {
			clickOnElement(txtMenuPrivacyPolicy, args);
			setLogSteps(log, "Click On Privacy Policy");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "privacy policy");
		}
	}


	public void clickOnSideMenuTermsAndConditionsFromSideMenu(int... args) {
		clickOnSideMenuProfile(args);
		try {
			clickOnElement(txtMenuTermsAndConditions, args);
			setLogSteps(log, "Click On Terms And Conditions");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "terms and conditions");
		}
	}

	public void clickOnDashboardPrivacyPolicy(int... args) {
		try {
			clickOnElement(txtDashPrivacyPolicy, args);
			setLogSteps(log, "Click On Privacy Policy");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "privacy policy");
		}
	}

	public void clickOnDashboardTermsAndConditions(int... args) {
		try {
			clickOnElement(txtDashTermsAndConditions, args);
			setLogSteps(log, "Click On Terms And Conditions");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "terms and conditions");
		}
	}

	public void clickOnSideMenuChangeLanguageFromProfile(int... args) {
		try {
			clickOnElement(txtMenuChangeLanguage, args);
			setLogSteps(log, "Click On Change Language");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change language");
		}
	}

	public void clickOnSideMenuContactUsFromProfile(int... args) {
		try {
			clickOnElement(txtMenuContactUs, args);
			setLogSteps(log, "Click On Contact Us");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "contact us");
		}
	}

	public void clickOnSideMenuAboutUsFromProfile(int... args) {
		try {
			clickOnElement(txtMenuAboutUs, args);
			setLogSteps(log, "Click On About Us");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "about us");
		}
	}

	public void clickOnDashboardChangeLanguage(int... args) {
		try {
			clickOnElement(txtDashChangeLanguage, args);
			setLogSteps(log, "Click On Change Language");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change language");
		}
	}

	public void clickOnDashboardContactUs(int... args) {
		try {
			clickOnElement(txtDashContactUs, args);
			setLogSteps(log, "Click On Contact Us");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "contact us");
		}
	}

	public void clickOnDashboardAboutUs(int... args) {
		try {
			clickOnElement(txtDashAboutUs, args);
			setLogSteps(log, "Click On About Us");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "about us");
		}
	}

	public void clickOnDashboardChangeMPIN(int... args) {
		try {
			clickOnElement(txtDashChangeMPIN, args);
			setLogSteps(log, "Click On Change MPIN");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change mpin");
		}
	}

	public void clickOnDashboardChangePassword(int... args) {
		try {
			clickOnElement(txtDashChangeLoginPassword, args);
			setLogSteps(log, "Click On Change Login Password");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change password");
		}
	}

	public void clickOnProfileChangePassword(int... args) {
		try {
			clickOnElement(txtProfileLoginPassword, args);
			setLogSteps(log, "Click On Change Login Password");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "change password");
		}
	}

	public void clickOnNavBarMyTransactions(int... args) {
		try {
			clickOnElement(txtDashMyTransaction, args);
			setLogSteps(log, "Click On My Transactions");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "my transactions");
		}
	}

	public void clickOnSideMenuServicesSalaryDisbursement(int... args) {
		try {
			clickOnElement(txtMenuSalaryDisbursement, args);
			setLogSteps(log, "Click On Salary Disbursement");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "salary disbursement");
		}
	}

	public void clickOnSideMenuServicesDisbursementRequestList(int... args) {
		try {
			clickOnElement(txtMenuDisbursementRequestList, args);
			setLogSteps(log, "Click On Disbursement Request List");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "disbursement request list");
		}
	}

	public void clickOnSideMenuServicesDisbursementReport(int... args) {
		try {
			clickOnElement(txtMenuDisbursementReport, args);
			setLogSteps(log, "Click On Disbursement Report");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "disbursement report");
		}
	}

	public void clickOnSideMenuServicesTransactionDetail(int... args) {
		try {
			clickOnElement(txtMenuTransactionDetail, args);
			setLogSteps(log, "Click On Transaction Detail");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "transaction detail");
		}
	}

	public void clickOnB2BTransfer(int... args) {
		try {
			clickOnElement(this.log, txtB2BTransfer, args);
			setLogSteps(log, "Click On B2B Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "b2b transfer");
		}
	}

	public void clickOnDisbursementReport(int... args) {
		try {
			clickOnElement(txtDisbursementReport, args);
			setLogSteps(log, "Click On Disbursement Report");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "disbursement report");
		}
	}

	public void clickOnDashboardDisbursementReport(int... args) {
		try {
			clickOnElement(txtDashDisbursementReport, args);
			setLogSteps(log, "Click On Disbursement Report");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "disbursement report");
		}
	}

	public void clickOnDisbursementRequestList(int... args) {
		try {
			clickOnElement(txtDisbursementRequestList, args);
			setLogSteps(log, "Click On Disbursement Request List");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "disbursement request list");
		}
	}

	public void clickOnSalaryDisbursement(int... args) {
		try {
			clickOnElement(txtSalaryDisbursement, args);
			setLogSteps(log, "Click On Salary Disbursement");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "salary disbursement");
		}
	}

	public void clickOnDashboardSalaryDisbursement(int... args) {
		try {
			clickOnElement(txtDashBulkPayment, args);
			setLogSteps(log, "Click On Salary Disbursement");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "salary disbursement");
		}
	}

	public void clickOnTransactionDetail(int... args) {
		try {
			clickOnElement(txtTransactionDetail, args);
			setLogSteps(log, "Click On Transaction Detail");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "transaction details");
		}
	}

	public void clickOnDashboardTransactionDetail(int... args) {
		try {
			clickOnElement(txtDashTransactionDetail, args);
			setLogSteps(log, "Click On Transaction Detail");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "transaction details");
		}
	}

	public void clickOnWithdrawMoney(int... args) {
		try {
			clickOnElement(this.log, txtWithdrawMoney, args);
			setLogSteps(log, "Click On Withdraw Money");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "withdraw money");
		}
	}

	public void clickOnChangeMpinfromSideMenu(int... args) {
		try {
			clickOnElement(sideMenu, args);
			clickOnElement(sideMenuSettings, args);
			clickOnElement(this.log, txtChangeMPINSideMenu, args);
			setLogSteps(log, "Click On Change Mpin");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Click On Change Mpin");
		}
	}
	
	public void clickOnResetMpinfromSideMenu(int... args) {
		try {
			clickOnElement(sideMenu, args);
			clickOnElement(sideMenuSettings, args);
			clickOnElement(this.log, txtResetMPINSideMenu, args);
			setLogSteps(log, "Click On Reset Mpin");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Click On Reset Mpin");
		}
	}

	public void clickOnChangeMpinfromSideMenuWorngInput(int... args) {
		try {
			clickOnElement(sideMenu, args);
			clickOnElement(sideMenuSettings, args);
			clickOnElement(this.log, txtChangeMPINSideMenu, args);
			setLogSteps(log, "Click On Change Mpin with Wrong Input");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Click On Change Mpin");
		}
	}

	public void clickOnChangeSecretWordfromSideMenu(int... args) {
		try {
			clickOnElement(sideMenu, args);
			clickOnElement(sideMenuSettings, args);
			clickOnElement(this.log, txtChangeSecretWordSideMenu, args);
			setLogSteps(log, "Click On Change SecretWord");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Click On Change SecretWord");
		}
	}

	public void clickOnChangeSecretWordfromLogin(int... args) {
		try {
			clickOnElement(By.xpath("//*[text()='Forgot Secret Word?']"), args);
			setLogSteps(log, "Click On Change SecretWord");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Click On Change SecretWord");
		}
	}
	
	public void clickOnForgotPasswordfromLogin(int... args) {
		try {
			clickOnElement(By.xpath("//*[text()='Forgot Password?']"), args);
			setLogSteps(log, "Click On Password");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Click On Change Password");
		}
	}
	
	

	public void clickOnLogOutForNass(int... args) {
		if (!verifyVisible(logOutForNass, 3)) {
			reloadCurrentPage(driver);
		}
		try {
			clickOnElement(logOutForNass, args);
			setLogSteps(log, "Click On Logout");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "logout");
		}
	}

	public void clickOnP2PTransferfromFooter(int... args) {
		try {
			clickOnElement(txtP2PTransferfromFooter, args);
			setLogSteps(log, "Click On Money Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Money Transfer");
		}
	}

	public void clickOnP2POffnetTransferfromFooter(int... args) {
		try {
			clickOnElement(txtP2POffnetTransferfromFooter, args);
			setLogSteps(log, "Click On P2POffnet Transfer from Footer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Click On P2POffnet Transfer from Footer");
		}
	}

	public void clickOnSideP2PTransfer(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(txtP2PTransferSideMenu, args);
			setLogSteps(log, "Click On P2P Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "P2P Transfer");
		}
	}

	public void clickOnSideP2POffnetTransfer(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(txtP2POffnetTransferSideMenu, args);
			setLogSteps(log, "Click On P2P Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "P2P Transfer");
		}
	}

	public void clickOnDashboardP2PTransfer(int... args) {
		try {
			clickOnElement(txtDashP2PTranfer, args);
			setLogSteps(log, "Click On P2P Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "P2P Transfer");
		}
	}

	public void verifyUserNotActive(int args) {
		try {
			verifyVisible(UserNotActive, args);
		} catch (Exception e) {
			throw new RuntimeException(GET_TEXT_ERROR_MESSAGE + "User Not Active Message Not Found");
		}
		setLogSteps(log, "verify User Not Active Message Found");
	}

	public void verifyLoggedIn(int args) {
		try {
			verifyVisible(logOut, args);
		} catch (Exception e) {
			throw new RuntimeException(
					GET_TEXT_ERROR_MESSAGE + "LoggedIn successfull with username starting with zero.");
		}
		setLogSteps(log, "LoggedIn successfull with username starting with zero.");
	}

	public void verifyInvalidCredentials(int args) {
		try {
			verifyVisible(By.xpath("//span[contains(text(),'Invalid Credentials')]"), args);
		} catch (Exception e) {
			throw new RuntimeException(GET_TEXT_ERROR_MESSAGE + "Message verified: Invalid Credentials");
		}
		setLogSteps(log, "Message verified: Invalid Credentials");
	}

	public void verifyAccountTempBlocked(int args) {
		try {
			verifyVisible(By.xpath(
					"//span[contains(text(),'Your account has been temporary blocked due to multiple failure login attempts')]"),
					args);
		} catch (Exception e) {
			throw new RuntimeException(GET_TEXT_ERROR_MESSAGE
					+ "FAILED: Your account has been temporary blocked due to multiple failure login attempts");
		}
		setLogSteps(log,
				"Message verified: Your account has been temporary blocked due to multiple failure login attempts");
	}

	public void clickOnDashboardP2POffnet(int... args) {
		try {
			clickOnElement(txtDashP2POffnet, args);
			setLogSteps(log, "Click On P2P Offnet Transfer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "P2P Offnet Transfer");
		}
	}

	public void clickOnMerchantPayment(int... args) {
		try {
			clickOnElement(txtMerchantPayment, args);
			setLogSteps(log, "Click On Merchant Payment");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Merchant Payment");
		}
	}

	public void clickOnSideMenuMerchantPayment(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(txtMenuMerchantPayment, args);
			setLogSteps(log, "Click On Merchant Payment");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Merchant Payment");
		}
	}

	public void clickOnDashboardMerchantPayment(int... args) {
		try {
			clickOnElement(txtDashMerchantPayment, args);
			setLogSteps(log, "Click On Merchant Payment");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Merchant Payment");
		}
	}

	public void clickOnEnterprisePayment(int... args) {
		try {
			clickOnElement(txtEnterprisePayment, args);
			setLogSteps(log, "Click On C2E");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "EnterprisePayment");
		}
		setLogSteps(log, "Click On EnterprisePayment");
	}

	public void clickOnSideMenuEnterprisePayment(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(txtMenuEnterprisePayment, args);
			setLogSteps(log, "Click On C2E");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "EnterprisePayment");
		}
		setLogSteps(log, "Click On EnterprisePayment");
	}

	public void clickOnDashboardEnterprisePayment(int... args) {
		try {
			clickOnElement(txtDashEnterprisePayment, args);
			setLogSteps(log, "Click On C2E");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "EnterprisePayment");
		}
		setLogSteps(log, "Click On EnterprisePayment");
	}

	public void clickOnCashOut(int... args) {
		try {
			clickOnElement(txtCashOut, args);
			setLogSteps(log, "Click On WithDraw Cash");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "WithDraw Cash");
		}
	}

	public void clickOnWithdrawCashFromFooter(int... args) {
		try {
			clickOnElement(txtWithdrawCashFromFooter, args);
			setLogSteps(log, "Click On WithdrawCash From Footer");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Withdraw Cash From Footer");
		}
	}

	public void clickOnWithdrawCashFromSideMenu(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(txtWithdrawCashSideMenu, args);
			setLogSteps(log, "Click On WithdrawCash From Side Menu");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Withdraw Cash From Side Menu");
		}
	}

	public void clickOntxtAgentAssistedWithdraw(int... args) {
		try {
			clickOnElement(txtAgentAssistedWithdraw, args);
			setLogSteps(log, "Click On Agent Assisted Withdraw");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Assisted Withdraw");
		}
	}

	public void goToHome(int... args) {
		try {
			clickOnElement(homeLogo, args);
			setLogSteps(log, "Click On Home");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "home logo");
		}
	}

	public void clickOnChatOption(int... args) {
		try {
			clickOnElement(chat, args);
			setLogSteps(log, "Click On Chat");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "chat");
		}
	}

	public void clickOnMobileTopup(int... args) {
		try {
			clickOnElement(txtMobileTopup, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Mobile Topup");
		}
		setLogSteps(log, "Click On Mobile Topup");
	}

	public void clickOnSideMenuMobileTopup(int... args) {
		try {
			clickOnElement(txtMenuMobileTopup, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Mobile Topup");
		}
		setLogSteps(log, "Click On Mobile Topup");
	}

	public void clickOnDashboardMobileTopup(int... args) {
		try {
			// clickOnElement(txtDashMoneyTranfer, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Mobile Topup");
		}
		setLogSteps(log, "Click On Mobile Topup");
	}

	public void clickOnMobilePostpaid(int... args) {
		try {
			clickOnElement(txtMobilePostpaid, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Mobile Postpaid");
		}
		setLogSteps(log, "Click On Mobile Postpaid");
	}

	public void clickOnSideMenuMobilePostpaid(int... args) {
		try {
			clickOnElement(txtMenuMobilePostpaid, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Mobile Postpaid");
		}
		setLogSteps(log, "Click On Mobile Postpaid");
	}

	public void clickOnDashboardMobilePostpaid(int... args) {
		try {
			clickOnElement(txtDashMobilePostpaid, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Mobile Postpaid");
		}
		setLogSteps(log, "Click On Mobile Postpaid");
	}

	public void clickOnSend(int... args) {
		try {
			clickOnElement(txtSend, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Send");
		}
		setLogSteps(log, "Click On Send");
	}

	public void clickOnNasswalletAccountHolder(int... args) {
		try {
			clickOnElement(txtNasswalletAccountHolder, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Nasswallet Account Holder");
		}
		setLogSteps(log, "Click On Nasswallet Account Holder");
	}

	public void clickOnNasswalletMerchant(int... args) {
		try {
			clickOnElement(txtNasswalletMerchant, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Nasswallet Merchant");
		}
		setLogSteps(log, "Click On Nasswallet Merchant");
	}

	public void clickOnDashboardB2BTransfer(int... args) {
		try {
			moveToElement(txtDashB2BTranfer);
			clickOnElement(txtDashB2BTranfer, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "B2B Transfer");
		}
		setLogSteps(log, "Click On B2B Transfer");
	}

	public void clickOnSideMenuB2BTransfer(int... args) {
		try {
			clickOnElement(txtMenuB2BTransfer, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "B2B Transfer");
		}
		setLogSteps(log, "Click On B2B Transfer");
	}

	public void clickOnDashboardWithdrawMoney(int... args) {
		try {
			clickOnElement(txtDashWithdrawMoney, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Withdraw Money");
		}
		setLogSteps(log, "Click On Withdraw Money");
	}

	public void clickOnSideMenuWithdrawMoney(int... args) {
		try {
			clickOnElement(txtMenuWithdrawMoney, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Withdraw Money");
		}
		setLogSteps(log, "Click On Withdraw Money");
	}

	public void clickOnM2MTransfer(int... args) {
		try {
			clickOnElement(txtM2MTransfer, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "M2M Transfer");
		}
		setLogSteps(log, "Click On M2M Transfer");
	}

	public void clickOnSideMenuM2MTransfer(int... args) {
		try {
			clickOnElement(txtMenuM2MTransfer, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "M2M Transfer");
		}
		setLogSteps(log, "Click On M2M Transfer");
	}

	public void clickOnDashboardM2MTransfer(int... args) {
		try {
			clickOnElement(txtDashM2MTransfer, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "M2M Transfer");
		}
		setLogSteps(log, "Click On M2M Transfer");
	}

	public void clickOnMerchantRefund(int... args) {
		try {
			clickOnElement(txtMerchantRefund, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Merchant Refund");
		}
		setLogSteps(log, "Click On Merchant Refund");
	}

	public void clickOnSideMenuMerchantRefund(int... args) {
		try {
			clickOnElement(txtMenuMerchantRefund, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Merchant Refund");
		}
		setLogSteps(log, "Click On Merchant Refund");
	}

	public void clickOnDashboardMerchantRefund(int... args) {
		try {
			clickOnElement(txtDashMerchantRefund, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Merchant Refund");
		}
		setLogSteps(log, "Click On Merchant Refund");
	}

	public void clickOnSideMenuAssistantOnboarding(int... args) {
		try {
			clickOnElement(txtMenuAssistantOnboarding, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Assistant Onboarding");
		}
		setLogSteps(log, "Click On Assistant Onboarding");
	}

	public void clickOnManageAssistant(int... args) {
		try {
			clickOnElement(txtManageAssistant, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Manage Assistant");
		}
		setLogSteps(log, "Click On Manage Assistant");
	}

	public void clickOnSideMenuManageAssistant(int... args) {
		try {
			clickOnElement(txtMenuManageAssistant, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Manage Assistant");
		}
		setLogSteps(log, "Click On Manage Assistant");
	}

	public void clickOnDashboardManageAssistant(int... args) {
		try {
			clickOnElement(txtDashManageAssistant, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Manage Assistant");
		}
		setLogSteps(log, "Click On Manage Assistant");
	}

	public void clickOnTellerOnboarding(int... args) {
		try {
			clickOnElement(txtTellerOnboarding, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Teller Onboarding");
		}
		setLogSteps(log, "Click On Teller Onboarding");
	}

	public void clickOnSideMenuTellerOnboarding(int... args) {
		try {
			clickOnElement(txtMenuTellerOnboarding, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Teller Onboarding");
		}
		setLogSteps(log, "Click On Teller Onboarding");
	}

	public void clickOnDashboardTellerOnboarding(int... args) {
		try {
			clickOnElement(txtDashTellerOnboarding, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Teller Onboarding");
		}
		setLogSteps(log, "Click On Teller Onboarding");
	}

	public void clickOnManageTeller(int... args) {
		try {
			clickOnElement(txtManageTeller, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Manage Teller");
		}
		setLogSteps(log, "Click On Manage Teller");
	}

	public void clickOnSideMenuManageTeller(int... args) {
		try {
			clickOnElement(txtMenuManageTeller, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Manage Teller");
		}
		setLogSteps(log, "Click On Manage Teller");
	}

	public void clickOnDashboardManageTeller(int... args) {
		try {
			clickOnElement(txtDashManageTeller, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Manage Teller");
		}
		setLogSteps(log, "Click On Manage Teller");
	}

	public void clickOnSideMenuServicesCommissionReport(int... args) {
		try {
			clickOnElement(txtMenuCommissionReport, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "commission report");
		}
		setLogSteps(log, "Click On Commission Report");
	}

	public void clickOnA2ATransfer(int... args) {
		try {
			clickOnElement(txtA2ATransfer, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Transfer");
		}
		setLogSteps(log, "Click On Agent Transfer");
	}

	public void clickOnSideMenuA2ATransfer(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(txtMenuA2ATransfer, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Transfer");
		}
		setLogSteps(log, "Click On Agent Transfer");
	}
	
	

	public void clickOnFooterOptionA2ATransfer(int... args) {
		try {
			clickOnElement(txtfooterA2ATransfer, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Transfer");
		}
		setLogSteps(log, "Click On Agent Transfer");
	}

	public void clickOnCashInByAgent(int... args) {
		try {
			clickOnElement(txtCashInByAgent, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Cash In By Agent");
		}
		setLogSteps(log, "Click On Cash In By Agent");
	}

	public void clickOnSideMenuCashInByAgent(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(txtMenuCashInByAgent, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Cash In By Agent");
		}
		setLogSteps(log, "Click On Cash In By Agent");
	}

	public void clickOnDashboardCashInByAgent(int... args) {
		try {
			clickOnElement(txtDashCashInByAgent, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Cash In By Agent");
		}
		setLogSteps(log, "Click On Cash In By Agent");
	}

	public void clickOnUpdateCustomerKYC(int... args) {
		try {
			clickOnElement(txtUpdateCustomerKYC, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Update CustomerKYC");
		}
		setLogSteps(log, "Click On Update CustomerKYC");
	}

	public void clickOnSideMenuUpdateCustomerKYC(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(txtMenuUpdateCustomerKYC, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Update CustomerKYC");
		}
		setLogSteps(log, "Click On Update CustomerKYC");
	}

	public void clickOnDashboardUpdateCustomerKYC(int... args) {
		try {
			clickOnElement(txtDashUpdateCustomerKYC, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Update CustomerKYC");
		}
		setLogSteps(log, "Click On Update CustomerKYC");
	}

	public void clickOnCustomerOnboarding(int... args) {
		try {
			clickOnElement(txtCustomerOnboarding, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Customer Onboarding");
		}
		setLogSteps(log, "Click On Customer Onboarding");
	}

	public void clickOnSideMenuCustomerOnboarding(int... args) {
		try {
			clickOnElement(txtMenuCustomerOnboarding, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Customer Onboarding");
		}
		setLogSteps(log, "Click On Customer Onboarding");
	}

	public void clickOnDashboardCustomerOnboarding(int... args) {
		try {
			clickOnElement(txtDashCustomerOnboarding, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Customer Onboarding");
		}
		setLogSteps(log, "Click On Customer Onboarding");
	}

	public void clickOnManageAgent(int... args) {
		try {
			clickOnElement(txtManageAgent, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Manage Agent");
		}
		setLogSteps(log, "Click On Manage Agent");
	}

	public void clickOnSideMenuManageAgent(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(txtMenuManageAgent, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Manage Agent");
		}
		setLogSteps(log, "Click On Manage Agent");
	}

	public void clickOnDashboardManageAgent(int... args) {
		try {
			clickOnElement(txtDashManageAgent, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Manage Agent");
		}
		setLogSteps(log, "Click On Manage Agent");
	}

	public void clickOnSideMenuAgentOnboarding(int... args) {
		try {
			clickOnElement(txtMenuAgentOnboarding, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Onboarding");
		}
		setLogSteps(log, "Click On Agent Onboarding");
	}

	public void clickOnDashboardAgentOnboarding(int... args) {
		try {
			clickOnElement(txtDashAgentOnboarding, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Onboarding");
		}
		setLogSteps(log, "Click On Agent Onboarding");
	}

	public void clickOnTransactionSummary(int... args) {
		try {
			clickOnElement(txtTransactionSummary, args);
			setLogSteps(log, "Click On Transaction Summary");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Transaction Summary");
		}
	}

	public void clickOnDashboardTransactionSummary(int... args) {
		try {
			clickOnElement(txtDashTransactionSummary, args);
			setLogSteps(log, "Click On Transaction Summary");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Transaction Summary");
		}
	}

	public void clickOnSideMenuTransactionSummary(int... args) {
		try {
			clickOnElement(txtMenuTransactionSummary, args);
			setLogSteps(log, "Click On Transaction Summary");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Transaction Summary");
		}
	}

	public void clickOnForgottenMPIN(int... args) {
		try {
			clickOnElement(forgottenMPIN, args);
			setLogSteps(log, "Click On Forgotten MPIN");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Forgotten MPIN");
		}
	}

	public void clickOnCommissionReport(int... args) {
		try {
			clickOnElement(txtCommissionReport, args);
			setLogSteps(log, "Click On Commission Report");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Commission Report");
		}
	}

	public void clickOnDashboardCommissionReport(int... args) {
		try {
			clickOnElement(txtDashCommissionReport, args);
			setLogSteps(log, "Click On Commission Report");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Commission Report");
		}
	}

	public void clickOnForgottenPassword(int... args) {
		try {
			clickOnElement(forgottenPassword, args);
			setLogSteps(log, "Click On Forgotten Password");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Forgotten Password");
		}
	}

	public void clickOnNewUser(int... args) {
		try {
			clickOnElement(newUser, args);
			setLogSteps(log, "Click On New User");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "New User");
		}
	}

	public void clickOneVoucher(int... args) {
		try {
			clickOnElement(txteVoucher, args);
			setLogSteps(log, "Click On eVoucher");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "eVoucher");
		}
	}

	public void clickOnArbelaStore(int... args) {
		try {
			clickOnElement(txteArbelaStore, args);
			setLogSteps(log, "Click On ArbelaStore");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "ArbelaStore");
		}
	}

	public void clickOnSideMenueVoucher(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(txtMenueVoucher, args);
			setLogSteps(log, "Click On eVoucher");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "eVoucher");
		}
	}

	public void clickOnSideMenuArbelaStore(int... args) {
		clickOnSideMenuServices(args);
		try {
			clickOnElement(txtMenuArbelaStore, args);
			setLogSteps(log, "Click On Arbela Store");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Arbela Store");
		}
	}

	public void clickOnCustomereVoucher(int... args) {
		try {
			clickOnElement(txteVoucherCustomer, args);
			setLogSteps(log, "Click On eVoucher Sale");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "eVoucher Sale");
		}
	}

	public void clickOnAirtimeSale(int... args) {
		try {
			clickOnElement(txtAirtimeSale, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Airtime Sale");
		}
		setLogSteps(log, "Click On Airtime Sale");
	}

	public void clickOnDashboardAirtimeSale(int... args) {
		try {
			clickOnElement(txtDashAirtimeSale, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Airtime Sale");
		}
		setLogSteps(log, "Click On Airtime Sale");
	}

	public void clickOnSideMenuAirtimeSale(int... args) {
		try {
			clickOnElement(txtMenuAirtimeSale, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Airtime Sale");
		}
		setLogSteps(log, "Click On Airtime Sale");
	}

	public void clickOnclickOnAgentAssistedDeposit(int... args) {
		try {
			clickOnElement(txtAgentAssistedDeposit, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Transfer");
		}
		setLogSteps(log, "Click On Agent Transfer");

	}
	
	public void clickOnclickOnAgentAssistedDepositIcon(int... args) {
		try {
			clickOnElement(txtAgentAssistedDepositIcon, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Assisted Deposit Icon");
		}
		setLogSteps(log, "Click On Agent Assisted Deposit Icon");
		
	}
	
	
	public void clickOnclickOnAgentAssistedDepositFooter(int... args) {
		try {
			clickOnElement(txtAgentAssistedDepositFooter, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Assisted Deposit From Footer");
		}
		setLogSteps(log, "Click On Agent Assisted Deposit From Footer");
		
	}
	
	public void clickOnclickOnAgentAssistedDepositFromSidemenu(int... args) {
		try {
			clickOnElement(txtAgentAssistedDepositSideMenu, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Agent Assisted Deposit From Side menu");
		}
		setLogSteps(log, "Click On Agent Assisted Deposit From Side menu");
		
	}

	public void clickOnPersonalinfoProfile(int args) {
		try {
			clickOnElement(PersonalinfoProfile, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Personal info Profile");
		}
		setLogSteps(log, "Click On Personal info Profile");
	}

	public void clickOnDocumentinforeligiousworshipProfile(int args) {
		try {
			clickOnElement(DocumentinforeligiousworshipProfile, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Personal info Profile");
		}
		setLogSteps(log, "Click On Personal info Profile");
	}

	public void clickOnSideMenuProfileMyProfile(int... args) {
		clickOnSideMenuProfile(args);
		pauseInMilliSeconds(2);
		try {
			clickOnElement(myProfile, args);
			setLogSteps(log, "Click On My Profile");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "myProfile");
		}
	}

	public void clickOnMyProfile(int... args) {
		try {
			clickOnElement(myProfileDashboard, args);
			setLogSteps(log, "Click On My Profile");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "myProfile");
		}
	}
	
	public void clickOPasswordPolicyFromChangePassword(int... args) {
		try {
			clickOnElement(txtMyProfilePasswordPolicy, args);
			setLogSteps(log, "Click On Password Policy");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "password policy");
		}
	}
	
	public void clickOnSideMenuMPINPolicyFromMyProfile(int... args) {
		try {
			clickOnElement(By.xpath("//*[normalize-space(text())='MPIN Policy']"), args);
			setLogSteps(log, "Click On Change MPIN");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "mpin policy");
		}
	}
	public void clickOnForgetMpinfromLogin(int ... args) {
		try {
			clickOnElement(ForgotMpinfromLogin, args);
			setLogSteps(log, "Click On Forgot Mpin");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Forgot Mpin");
		}
	}
	
	public void clickOnProfileIconSubAgent(int ... args) {
		try {
			clickOnElement(ProfileIconDashboard, args);
			setLogSteps(log, "Click On Profile Icon SubAgent");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Profile Icon SubAgent");
		}
	}

}
