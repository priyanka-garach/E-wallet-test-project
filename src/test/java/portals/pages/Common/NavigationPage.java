package portals.pages.Common;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.NavigationPageOperations;
import utils.elasticUtils.elasticwrite;

public class NavigationPage extends SetupInit {

	NavigationPageOperations navigationPageOperations;
	elasticwrite log;

	/////////// tangerine starts ////////////////////////

	public void clickOnDashboardP2PTransfer() {
		navigationPageOperations.clickOnDashboardP2PTransfer(0);
	}

	public void verifyUserNotActive() {
		navigationPageOperations.verifyUserNotActive(0);
	}

	public void verifyLoggedIn() {
		navigationPageOperations.verifyLoggedIn(0);
	}

	public void verifyInvalidCredentials() {
		navigationPageOperations.verifyInvalidCredentials(0);
	}

	public void verifyAccountTempBlocked() {
		navigationPageOperations.verifyAccountTempBlocked(0);
	}

	public void clickOnDashboardP2POffnet() {
		navigationPageOperations.clickOnDashboardP2POffnet(0);
	}

	public void clickOnChangeInviteFriendsfromSideMenu() {
		navigationPageOperations.clickOnInviteFriendsfromSideMenu(0);
	}

	public void clickOnWithdrawCashFroomFooter() {
		navigationPageOperations.clickOnWithdrawCashFromFooter(0);
	}

	public void clickOnWithdrawCashFromSideMenu() {
		navigationPageOperations.clickOnWithdrawCashFromSideMenu(0);
	}

	public void clickOnSideMenuCashOut() {
		navigationPageOperations.clickOnSideMenuCashOut(0);
	}

	/////////// tangerine ends ////////////////////////

	public NavigationPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		navigationPageOperations = new NavigationPageOperations(this.driver, log);
	}

	public void clickOnSideMenuWallets() {
		navigationPageOperations.clickOnSideMenuWallets(0);
	}

	public void clickOnSideMenuProfile() {
		navigationPageOperations.clickOnSideMenuProfile(0);
	}

	public void clickOnNavBarQRCode() {
		pauseInSeconds(2);
		navigationPageOperations.clickOnNavBarQRCode(0);
	}

	public void clickOnNavBarPassbook() {
		navigationPageOperations.clickOnNavBarPassbook(0);
	}

	public void clickOnNavBarLogOut() {
		navigationPageOperations.clickOnNavBarLogOut(0);
	}

	public void clickOnDashBoardCheckBalance() {
		navigationPageOperations.clickOnDashBoardCheckBalance(0);
	}

	public void clickOnSideMenuServicesBuyCredit() {
		navigationPageOperations.clickOnSideMenuServicesBuyCredit(0);
	}

	public void clickOnSideMenuServicesBLink() {
		navigationPageOperations.clickOnSideMenuServicesBLink(0);
	}

	public void clickOnSideMenuServicesBuyQPower() {
		navigationPageOperations.clickOnSideMenuServicesBuyQPower(0);
	}

	public void clickOnSideMenuServicesQuickPay() {
		navigationPageOperations.clickOnSideMenuServicesQuickPay(0);
	}

	public void clickOnSideMenuServicesPayBills() {
		navigationPageOperations.clickOnSideMenuServicesPayBills(0);
	}

	public void clickOnSideMenuSettingsChangeSecretPin() {
		navigationPageOperations.clickOnSideMenuSettingsChangeSecretPin(0);
	}

	public void clickOnSideMenuSettingsResetSecretPin() {
		navigationPageOperations.clickOnSideMenuSettingsResetSecretPin(0);
	}

	public void clickOnSideMenuSettingsChangeLoginPassword() {
		navigationPageOperations.clickOnSideMenuSettingsChangeLoginPassword(0);
	}

	public void clickOnSideMenuSettingsSupport() {
		navigationPageOperations.clickOnSideMenuSettingsSupport(0);
	}

	public void clickOnWalletBalances() {
		navigationPageOperations.clickOnWalletBalances(0);
	}

	public void clickOnSideMenuProfileProfileDetails() {
		navigationPageOperations.clickOnSideMenuProfileProfileDetails(0);
	}

	public void clickOnChangePassword() {
		navigationPageOperations.clickOnChangePassword(0);
	}

	public void clickOnChangeMPin() {
		navigationPageOperations.clickOnChangeMPin(0);
	}

	public void clickOnResetMPin() {
		navigationPageOperations.clickOnResetMPin(0);
	}

	public void clickOnSideMenuProfileFAQs() {
		navigationPageOperations.clickOnSideMenuProfileFAQs(0);
	}

	public void clickOnCheckBalance() {
		navigationPageOperations.clickOnCheckBalance(0);
	}

	public void clickOnQRCode() {
		navigationPageOperations.clickOnQRCode(0);
	}

	public void clickOnPassbook() {
		navigationPageOperations.clickOnPassbook(0);
	}

	public void clickOnLogOut() {
		navigationPageOperations.clickOnLogOut(0);
	}

	public void clickOnRecentTransaction() {
		navigationPageOperations.clickOnRecentTransaction(0);
	}

	public void clickOnCheckQMoneyPoints() {
		navigationPageOperations.clickOnCheckQMoneyPoints(0);
	}

	public void clickOnRedeemQMoneyPoints() {
		navigationPageOperations.clickOnRedeemQMoneyPoints(0);
	}

	public void clickOnRegisterCustomer() {
		navigationPageOperations.clickOnRegisterCustomer(0);
	}

	public void clickOnReports() {
		navigationPageOperations.clickOnReports(0);
	}

	public void clickOnWithDraw() {
		navigationPageOperations.clickOnWithDraw(0);
	}

	public void clickOnWalletTopup() {
		navigationPageOperations.clickOnWalletTopup(0);
	}

	public void clickOnSellQPower() {
		navigationPageOperations.clickOnSellQPower(0);
	}

	public void clickOnAgentToAgentTransfer() {
		navigationPageOperations.clickOnAgentToAgentTransfer(0);
	}

	public void clickOnAcceptPayments() {
		navigationPageOperations.clickOnAcceptPayments(0);
	}

	public void clickOnRedeemSubscriberPoints() {
		navigationPageOperations.clickOnRedeemSubscriberPoints(0);
	}

	public void clickOnCashIn() {
		navigationPageOperations.clickOnCashIn(0);
	}

	public void clickOnCashTransfer() {
		navigationPageOperations.clickOnCashTransfer(0);
	}

	public void clickOnCallSupport() {
		navigationPageOperations.clickOnCallSupport(0);
	}

	public void clickOnAssistantOnboarding() {
		navigationPageOperations.clickOnAssistantOnboarding(0);
	}

	public void clickOnReceivePayment() {
		navigationPageOperations.clickOnReceivePayment(0);
	}

	public void clickOnEditProfile() {
		navigationPageOperations.clickOnEditProfile(0);
	}

	public void clickOnSideMenuServicesQCellPostPaid() {
		navigationPageOperations.clickOnSideMenuServicesQCellPostPaid(0);
	}

	public void clickOnSideMenuServicesGetLastQPowerToken() {
		navigationPageOperations.clickOnSideMenuServicesGetLastQPowerToken(0);
	}

	public void clickOnSideMenuServicesManageBeneficiary() {
		navigationPageOperations.clickOnSideMenuServicesManageBeneficiary(0);
	}

	public void clickOnSideMenuServicesSendQMoney() {
		navigationPageOperations.clickOnSideMenuServicesSendQMoney(0);
	}

	public void clickOnSideMenu() {
		navigationPageOperations.clickOnSideMenu(0);
	}
	
	public void clickOnMenuProfile() {
		navigationPageOperations.clickOnMenuProfile(0);
	}
	
	public void clickOnMenuProfileViewProfile() {
		navigationPageOperations.clickOnMenuProfileViewProfile(0);
	}
	

	public void clickOnSideMenuServices() {
		navigationPageOperations.clickOnSideMenuServices(0);
	}

	public void clickOnSideMenuSettings() {
		navigationPageOperations.clickOnSideMenuSettings(0);
	}

	public void clickOnSideMenuServicesReceivePayment() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnReceivePayment(0);
	}

	public void clickOnSideMenuServicesMerchantSettlement() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnSideMenuServicesMerchantSettlement(0);
	}

	public void clickOnSideMenuServicesRegisterCustomer() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnRegisterCustomer(0);
	}

	public void clickOnSideMenuServicesAssitantOnboarding() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnAssistantOnboarding(0);
	}

	public void clickOnSideMenuServicesRedeemSubsriberPoints() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnRedeemSubscriberPoints(0);
	}

	public void clickOnSideMenuServicesReports() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnReports(0);
	}

	public void clickOnDashboardAssitantOnboarding() {
		navigationPageOperations.clickOnDashboardAssistantOnboarding(0);
	}

	public void clickOnSideMenuServicesMobileTopUp() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnSideMenuServicesMobileTopUp(0);
	}

	public void clickOnSideMenuServicesWithdraw() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnSideMenuServicesWithdraw(0);
	}

	public void clickOnSideMenuServicesCashIn() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnSideMenuServicesCashIn(0);
	}

	public void clickOnSideMenuServicesWalletTopup() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnSideMenuServicesWalletTopup(0);
	}

	public void clickOnSideMenuServicesAgentToAgentTransfer() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnSideMenuServicesAgentToAgentTransfer(0);
	}

	public void clickOnSideMenuServicesRedeemToken() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnSideMenuServicesRedeemToken(0);
	}

	public void clickOnSideMenuServicesSellQPower() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnSellQPower(0);
	}

	public void clickOnRedeemCashToken() {
		navigationPageOperations.clickOnRedeemCashToken(0);
	}

	public void clickOnAgentOnboarding() {
		navigationPageOperations.clickOnAgentOnboarding(0);
	}

	public void clickOnDashboardCashTransfer() {
		navigationPageOperations.clickOnDashboardCashTransfer(0);

	}

	public void clickOnDashboardCashIn() {
		navigationPageOperations.clickOnDashboardCashIn(0);
	}

	public void clickOnDashboardWithdraw() {
		navigationPageOperations.clickOnDashboardWithdraw(0);
	}

	public void clickOnDashboardWalletTopup() {
		navigationPageOperations.clickOnDashboardWalletTopup(0);
	}

	public void clickOnDashboardSellQPower() {
		navigationPageOperations.clickOnDashboardSellQPower(0);
	}

	public void clickOnDashboardAgentToAgentTransfer() {
		navigationPageOperations.clickOnDashboardAgentToAgentTransfer(0);
	}

	public void clickOnDashboardAcceptPayments() {
		navigationPageOperations.clickOnDashboardAcceptPayments(0);
	}

	public void clickOnDashboardAssistantOnboarding() {
		navigationPageOperations.clickOnDashboardAssistantOnboarding(0);

	}

	public void clickOnSideMenuServicesBLinkForMerchant() {
		navigationPageOperations.clickOnSideMenuServicesBLinkForMerchant(0);
	}

	public void clickOnLogOutForMerchant() {
		navigationPageOperations.clickOnLogOutForMerchant(0);
	}

	public void clickOnSideMenuServicesP2PUnRegisteredUserTransfer() {
		navigationPageOperations.clickOnSideMenuServicesP2PUnRegisteredUserTransfer(0);
	}

	public void clickOnDashboardBuyCredit() {
		navigationPageOperations.clickOnSideMenuServicesBuyCredit(0);
	}

	public void clickOnDashboardSendQMoney() {
		navigationPageOperations.clickOnDashboardSendQMoney(0);
	}

	public void clickOnDashboardBuyQPower() {
		navigationPageOperations.clickOnDashboardBuyQpower(0);
	}

	public void clickOnDashboardQuickPay() {
		navigationPageOperations.clickOnDashboardQuickPay(0);
	}

	public void clickOnDashboardPayBills() {
		navigationPageOperations.clickOnDashboardPayBills(0);
	}

	public void clickOnDashboardQcellPostPaid() {
		navigationPageOperations.clickOnDashboardQcellPostPaid(0);
	}

	public void clickOnSideMenuServicesRedeemQMoneyPoints() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnSideMenuRedeemQMoneyPoints(0);
	}

	public void clickOnDashboardBLink() {
		navigationPageOperations.clickOnDashboardBLink(0);
	}

	public void clickOnDashboardProfileDetail() {
		navigationPageOperations.clickOnDashboardProfileDetail(0);
	}

	public void verifyCustomerSideMenu(int time) {
		verifyVisible(navigationPageOperations.sendQMoney, time);
		setLogSteps(log, "Verify Send QMoney Is Present");
		verifyVisible(navigationPageOperations.buyCredit, time);
		setLogSteps(log, "Verify Buy Credit Is Present");
		verifyVisible(navigationPageOperations.buyQPower, time);
		setLogSteps(log, "Verify Buy QPower Is Present");
		verifyVisible(navigationPageOperations.quickPay, time);
		setLogSteps(log, "Verify Quick Pay Is Present");
		verifyVisible(navigationPageOperations.sideMenucashOut, time);
		setLogSteps(log, "Verify Cash Out Is Present");
		verifyVisible(navigationPageOperations.payBills, time);
		setLogSteps(log, "Verify Pay Bills Is Present");
		verifyVisible(navigationPageOperations.qcellPostPaid, time);
		setLogSteps(log, "Verify QCell Post Paid Is Present");
		verifyVisible(navigationPageOperations.getLastQPowerToken, time);
		setLogSteps(log, "Verify Get Last QR Token Is Present");
		verifyVisible(navigationPageOperations.bLinkForMerchant, time);
		setLogSteps(log, "Verify B-Link Is Present");
		verifyVisible(navigationPageOperations.manageBeneficciary, time);
		setLogSteps(log, "Verify Manage Beneficiary Is Present");
		verifyVisible(navigationPageOperations.redeemQMoneyPoints, time);
		setLogSteps(log, "Verify Redeem QMoney Points Is Present");
		verifyVisible(navigationPageOperations.P2PUnRegisteredTransfer, time);
		setLogSteps(log, "Verify P2P Unregister User Transfer Is Present");
		navigationPageOperations.clickOnSideMenuSettings(0);
		verifyVisible(navigationPageOperations.changeSecretPin, time);
		setLogSteps(log, "Verify Change Secrete PIN Is Present");
		verifyVisible(navigationPageOperations.resetSecretPin, time);
		setLogSteps(log, "Verify Reset Secrete PIN Is Present");
		verifyVisible(navigationPageOperations.changeLoginPassword, time);
		setLogSteps(log, "Verify Change Login Password Is Present");
		verifyVisible(navigationPageOperations.support, time);
		setLogSteps(log, "Verify Support Is Present");
		clickOnElement(navigationPageOperations.sideMenuProfile, 0);
		verifyVisible(navigationPageOperations.profileDetails, time);
		setLogSteps(log, "Verify Profile Details Is Present");
	}

	public void verifyAgentSideMenu(int time) {
		verifyVisible(navigationPageOperations.registerCustomer, time);
		setLogSteps(log, "Verify Register Customer Is Present");
		verifyVisible(navigationPageOperations.checkQMoneyPoints, time);
		setLogSteps(log, "Verify Check QMoney Points Is Present");
		verifyVisible(navigationPageOperations.redeemQMoneyPoints, time);
		setLogSteps(log, "Verify Redeem QMoney Points Is Present");
		verifyVisible(navigationPageOperations.withdraw, time);
		setLogSteps(log, "Verify Withdraw Is Present");
		verifyVisible(navigationPageOperations.walletTopup, time);
		setLogSteps(log, "Verify Wallet Topup Is Present");
		verifyVisible(navigationPageOperations.mobileTopUp, time);
		setLogSteps(log, "Verify Mobile Topup Is Present");
		verifyVisible(navigationPageOperations.reports, time);
		setLogSteps(log, "Verify Reports Is Present");
		verifyVisible(navigationPageOperations.cashIn, time);
		setLogSteps(log, "Verify Cash In Is Present");
		verifyVisible(navigationPageOperations.sideMenucashOut, time);
		setLogSteps(log, "Verify Cash Out Is Present");
		verifyVisible(navigationPageOperations.sellQPower, time);
		setLogSteps(log, "Verify Sell QPower Is Present");
		verifyVisible(navigationPageOperations.acceptPayments, time);
		setLogSteps(log, "Verify Accept Payments Is Present");
		verifyVisible(navigationPageOperations.redeemSubscriberPoints, time);
		setLogSteps(log, "Verify Redeem Subscriber Points Is Present");
		verifyVisible(navigationPageOperations.cashTransfer, time);
		setLogSteps(log, "Verify Cash Transfer Is Present");
		verifyVisible(navigationPageOperations.redeemToken, time);
		setLogSteps(log, "Verify Redeem Token Is Present");
		/*
		 * verifyVisible(navigationPageCommon.bLinkForMerchant, time); setLogSteps(log,
		 * "Verify B-Link Is Present");
		 */
		navigationPageOperations.clickOnSideMenuSettings(0);
		verifyVisible(navigationPageOperations.changeSecretPin, time);
		setLogSteps(log, "Verify Change Secrete PIN Is Present");
		verifyVisible(navigationPageOperations.resetSecretPin, time);
		setLogSteps(log, "Verify Reset Secrete PIN Is Present");
		verifyVisible(navigationPageOperations.changeLoginPassword, time);
		setLogSteps(log, "Verify Change Login Password Is Present");
		verifyVisible(navigationPageOperations.support, time);
		setLogSteps(log, "Verify Support Is Present");
		clickOnElement(navigationPageOperations.sideMenuProfile, 0);
		verifyVisible(navigationPageOperations.profileDetails, time);
		setLogSteps(log, "Verify Profile Details Is Present");
	}

	public void verifyMerchantSideMenu(int time) {
		verifyVisible(navigationPageOperations.registerCustomer, time);
		setLogSteps(log, "Verify Register Customer Is Present");
		verifyVisible(navigationPageOperations.redeemSubscriberPoints, time);
		setLogSteps(log, "Verify Redeem Subscriber Points Is Present");
		verifyVisible(navigationPageOperations.receivePayment, time);
		setLogSteps(log, "Verify Receive Payment Is Present");
		verifyVisible(navigationPageOperations.bLinkForMerchant, time);
		setLogSteps(log, "Verify B-Link Is Present");
		verifyVisible(navigationPageOperations.checkQMoneyPoints, time);
		setLogSteps(log, "Verify Check QMoney Points Is Present");
		verifyVisible(navigationPageOperations.redeemQMoneyPointsMerchant, time);
		setLogSteps(log, "Verify Redeem QMoney Points Is Present");
		verifyVisible(navigationPageOperations.merchantSettlment, time);
		setLogSteps(log, "Verify Merchant Settlement Is Present");
		verifyVisible(navigationPageOperations.assistantOnboarding, time);
		setLogSteps(log, "Verify Assistant Onboarding Is Present");
		verifyVisible(navigationPageOperations.productInformation, time);
		setLogSteps(log, "Verify Product Information Is Present");
		verifyVisible(navigationPageOperations.reports, time);
		setLogSteps(log, "Verify Reports Is Present");
		navigationPageOperations.clickOnSideMenuSettings(0);
		verifyVisible(navigationPageOperations.changeSecretPin, time);
		setLogSteps(log, "Verify Change Secrete PIN Is Present");
		verifyVisible(navigationPageOperations.resetSecretPin, time);
		setLogSteps(log, "Verify Reset Secrete PIN Is Present");
		verifyVisible(navigationPageOperations.changeLoginPassword, time);
		setLogSteps(log, "Verify Change Login Password Is Present");
		verifyVisible(navigationPageOperations.support, time);
		setLogSteps(log, "Verify Support Is Present");
		clickOnElement(navigationPageOperations.sideMenuProfile, time);
		verifyVisible(navigationPageOperations.profileDetails, time);
		setLogSteps(log, "Verify Profile Details Is Present");
	}

	public void verifyCustomerDashbaordIcon(int time) {
		verifyVisible(navigationPageOperations.checkBalance, time);
		setLogSteps(log, "Verify Check Balance Is Present");
		verifyVisible(navigationPageOperations.qrCodeForMerchant, time);
		setLogSteps(log, "Verify QR Code Is Present");
		verifyVisible(navigationPageOperations.passbookForMerchant, time);
		setLogSteps(log, "Verify Passbook Is Present");
		verifyVisible(navigationPageOperations.logOutForMerchant, time);
		setLogSteps(log, "Verify Logout Is Present");
		verifyVisible(navigationPageOperations.dashboardSendQMoney, time);
		setLogSteps(log, "Verify Send QMoney Is Present");
		verifyVisible(navigationPageOperations.dashboardBuyCredit, time);
		setLogSteps(log, "Verify Buy Credit Is Present");
		verifyVisible(navigationPageOperations.dashboardBuyQPower, time);
		setLogSteps(log, "Verify Buy QPower Is Present");
		verifyVisible(navigationPageOperations.dashboardQuickPay, time);
		setLogSteps(log, "Verify Quick Pay Is Present");
		verifyVisible(navigationPageOperations.dashboardCashOut, time);
		setLogSteps(log, "Verify Cash Out Is Present");
		verifyVisible(navigationPageOperations.dashboardBLink, time);
		setLogSteps(log, "Verify B-Link Is Present");
		verifyVisible(navigationPageOperations.dashboardPayBills, time);
		setLogSteps(log, "Verify Pay Bills Is Present");
		verifyVisible(navigationPageOperations.dashboardQcellPostPaid, time);
		setLogSteps(log, "Verify QCell Post Paid Is Present");
		verifyVisible(navigationPageOperations.checkQMoneyPoints, time);
		setLogSteps(log, "Verify Check QMoney Points Is Present");
		verifyVisible(navigationPageOperations.redeemQMoneyPoints, time);
		setLogSteps(log, "Verify Redeem QMoney Points Is Present");
		verifyVisible(navigationPageOperations.callSupport, time);
		setLogSteps(log, "Verify Call Support Is Present");
	}

	public void verifyAgentDashbaordIcon(int time) {
		verifyVisible(navigationPageOperations.checkBalance, time);
		setLogSteps(log, "Verify Check Balance Is Present");
		// verifyVisible(navigationPageCommon.qrCodeForMerchant, time);
		setLogSteps(log, "Verify QR Code Is Present");
		verifyVisible(navigationPageOperations.passbookForMerchant, time);
		setLogSteps(log, "Verify Passbook Is Present");
		verifyVisible(navigationPageOperations.logOutForMerchant, time);
		setLogSteps(log, "Verify Logout Is Present");
		verifyVisible(navigationPageOperations.dashboardRegisterCustomer, time);
		setLogSteps(log, "Verify Register Customer Is Present");
		verifyVisible(navigationPageOperations.cashInDashboard, time);
		setLogSteps(log, "Verify Cash In Is Present");
		verifyVisible(navigationPageOperations.dashboardCashOut, time);
		setLogSteps(log, "Verify Cash Out Is Present");
		verifyVisible(navigationPageOperations.sellQPowerDashboard, time);
		setLogSteps(log, "Verify Sell QPower Is Present");
		verifyVisible(navigationPageOperations.acceptPaymentsDashboard, time);
		setLogSteps(log, "Verify Accept Payments Is Present");
		verifyVisible(navigationPageOperations.dashboardRedeemSubscriberpoint, time);
		setLogSteps(log, "Verify Redeem Subscriber Points Is Present");
		verifyVisible(navigationPageOperations.cashTransferDashboard, time);
		setLogSteps(log, "Verify Cash Transfer Is Present");
		verifyVisible(navigationPageOperations.redeemCashToken, time);
		setLogSteps(log, "Verify Redeem Cash Token Is Present");
		verifyVisible(navigationPageOperations.callSupport, time);
		setLogSteps(log, "Verify Call Support Is Present");
		verifyVisible(navigationPageOperations.dashboardBLink, time);
		setLogSteps(log, "Verify B-Link Is Present");
		verifyVisible(navigationPageOperations.checkQMoneyPoints, time);
		setLogSteps(log, "Verify Check QMoney Points Is Present");
		verifyVisible(navigationPageOperations.redeemQMoneyPoints, time);
		setLogSteps(log, "Verify Redeem QMoney Points Is Present");
		verifyVisible(navigationPageOperations.withdrawDashboard, time);
		setLogSteps(log, "Verify Withdraw Is Present");
		verifyVisible(navigationPageOperations.agentOnboarding, time);
		setLogSteps(log, "Verify Agent Onboarding Is Present");
		verifyVisible(navigationPageOperations.assistantOnboardingDashboard, time);
		setLogSteps(log, "Verify Asssitant Onboarding Is Present");
		verifyVisible(navigationPageOperations.walletTopupDashboard, time);
		setLogSteps(log, "Verify Wallet Topup Is Present");
	}

	public void verifyMerchantDashboardIcon(int time) {
		verifyVisible(navigationPageOperations.checkBalance, time);
		setLogSteps(log, "Verify Check Balance Is Present");
		verifyVisible(navigationPageOperations.qrCodeForMerchant, time);
		setLogSteps(log, "Verify QR Code Is Present");
		verifyVisible(navigationPageOperations.passbookForMerchant, time);
		setLogSteps(log, "Verify Passbook Is Present");
		verifyVisible(navigationPageOperations.logOutForMerchant, time);
		setLogSteps(log, "Verify Logout Is Present");
		verifyVisible(navigationPageOperations.dashboardRegisterCustomer, time);
		setLogSteps(log, "Verify Register Customer Is Present");
		verifyVisible(navigationPageOperations.dashboardRedeemSubscriberpoint, time);
		setLogSteps(log, "Verify Redeem Subscriber Points Is Present");
		verifyVisible(navigationPageOperations.dashboardReceivePayment, time);
		setLogSteps(log, "Verify Receive Payment Is Present");
		verifyVisible(navigationPageOperations.dashboardBLink, time);
		setLogSteps(log, "Verify B-Link Is Present");
		verifyVisible(navigationPageOperations.checkQMoneyPoints, time);
		setLogSteps(log, "Verify Check QMoney Points Is Present");
		verifyVisible(navigationPageOperations.redeemQMoneyPointsMerchant, time);
		setLogSteps(log, "Verify Redeem QMoney Points Is Present");
		verifyVisible(navigationPageOperations.merchantSettlment_dasboard, time);
		setLogSteps(log, "Verify Merchant Settlement Is Present");
		if (userType.toLowerCase().replaceAll("\\s", "").equals("merchantassistant")) {
			verifyVisible(navigationPageOperations.assistantOnboardingDashboard, time);
			setLogSteps(log, "Verify Asssitant Onboarding Is Present");
		}
	}

	public void clickOnDashboardRegisterCustomer() {
		navigationPageOperations.clickOnRegisterCustomerFromDashboard(0);
	}

	public void clickOnDashboardRedeemSubsriberPoints() {
		navigationPageOperations.clickOnRedeemSubscriberPointsFromDashboard(0);
	}

	public void clickOnDashboardReceivePayment() {
		navigationPageOperations.clickOnReceivePaymentFromDashboard(0);
	}

	public void clickOnActivateUserLink() {
		navigationPageOperations.clickOnActivateNowLink(0);
	}

	public void verifyAgentAssistantDashbaordIcon(int time) {
		verifyVisible(navigationPageOperations.checkBalance, time);
		setLogSteps(log, "Verify Check Balance Is Present");
		verifyVisible(navigationPageOperations.qrCodeForMerchant, time);
		setLogSteps(log, "Verify QR Code Is Present");
		verifyVisible(navigationPageOperations.passbookForMerchant, time);
		setLogSteps(log, "Verify Passbook Is Present");
		verifyVisible(navigationPageOperations.logOutForMerchant, time);
		setLogSteps(log, "Verify Logout Is Present");
		verifyVisible(navigationPageOperations.dashboardRegisterCustomer, time);
		setLogSteps(log, "Verify Register Customer Is Present");
		verifyVisible(navigationPageOperations.cashInDashboard, time);
		setLogSteps(log, "Verify Cash In Is Present");
		verifyVisible(navigationPageOperations.dashboardCashOut, time);
		setLogSteps(log, "Verify Cash Out Is Present");
		verifyVisible(navigationPageOperations.sellQPowerDashboard, time);
		setLogSteps(log, "Verify Sell QPower Is Present");
		verifyVisible(navigationPageOperations.acceptPaymentsDashboard, time);
		setLogSteps(log, "Verify Accept Payments Is Present");
		verifyVisible(navigationPageOperations.dashboardRedeemSubscriberpoint, time);
		setLogSteps(log, "Verify Redeem Subscriber Points Is Present");
		verifyVisible(navigationPageOperations.cashTransferDashboard, time);
		setLogSteps(log, "Verify Cash Transfer Is Present");
		verifyVisible(navigationPageOperations.redeemCashToken, time);
		setLogSteps(log, "Verify Redeem Cash Token Is Present");
		verifyVisible(navigationPageOperations.callSupport, time);
		setLogSteps(log, "Verify Call Support Is Present");
		verifyVisible(navigationPageOperations.checkQMoneyPoints, time);
		setLogSteps(log, "Verify Check QMoney Points Is Present");
		verifyVisible(navigationPageOperations.redeemQMoneyPoints, time);
		setLogSteps(log, "Verify Redeem QMoney Points Is Present");
		verifyVisible(navigationPageOperations.withdrawDashboard, time);
		setLogSteps(log, "Verify Withdraw Is Present");
		verifyVisible(navigationPageOperations.walletTopupDashboard, time);
		setLogSteps(log, "Verify Wallet Topup Is Present");
	}

	public void clickOnDashboardMerchantSettlement() {
		navigationPageOperations.clickOnDashboardMerchantSettlement(0);
	}

	public void clickOnSideMenuServicesCashTransfer() {
		navigationPageOperations.clickOnSideMenuServicesCashTransfer(0);
	}

	public void clickOnSideMenuServicesAcceptPayments() {
		navigationPageOperations.clickOnSideMenuServicesAcceptPayments(0);
	}

	public void clickOnSideMenuServicesWithdrawMoney() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnSideMenuServicesWithdrawMoney(0);
	}

	public void clickOnSideMenuServicesB2BTransfer() {
		clickOnSideMenuServices();
		navigationPageOperations.clickOnSideMenuServicesB2BTransfer(0);
	}

	public void clickOnChangePasswordForEnterpriseFromProfile() {
		navigationPageOperations.clickOnChangePasswordForEnterpriseFromProfile(0);
	}

	public void clickOnChangeMPinForEnterpriseFromProfile() {
		navigationPageOperations.clickOnChangeMPinForEnterpriseFromProfile(0);
	}

	public void clickOnResetMPinForEnterpriseFromProfile() {
		navigationPageOperations.clickOnResetMPinForEnterpriseFromProfile(0);
	}

	public void clickOnChangePasswordFromDashboardLink() {
		navigationPageOperations.clickOnChangePasswordForEnterpriseFromDashLink(0);
	}

	public void clickOnChangeMPinFromDashboardLink() {
		navigationPageOperations.clickOnChangeMPinForEnterpriseFromDashLink(0);
	}

	public void clickOnSideMenuProfileViewProfile() {
		navigationPageOperations.clickOnSideMenuProfileViewProfile(0);
	}

	public void clickOnSideMenuSettingsChangeMPIN() {
		navigationPageOperations.clickOnSideMenuSettingsChangeMPIN(0);
	}

	public void clickOnChangeLoginPassword() {
		navigationPageOperations.clickOnChangeLoginPassword(0);
	}

	public void clickOnChangeMPIN() {
		navigationPageOperations.clickOnChangeMPIN(0);
	}
	
	public void clickOnSideMenuePasswordPolicyFromSetings() {
		navigationPageOperations.clickOnSideMenuPasswordPolicyFromSettings(0);
	}

	public void clickOnSideMenueMPINPolicyFromSetings() {
		navigationPageOperations.clickOnSideMenuMPINPolicyFromSettings(0);
	}

	public void clickOnSideMenueChangeMPIN() {
		navigationPageOperations.clickOnSideMenuMPINPolicyChangeMPIN(0);
	}

	public void clickOnDashboardePasswordPolicy() {
		navigationPageOperations.clickOnDashboardPasswordPolicy(0);
	}
	
	public void clickOnPasswordPolicy() {
		navigationPageOperations.clickOPasswordPolicyFromChangePassword(0);
	}
	
	public void clickOnMPINPolicyFromMyProfile() {
		navigationPageOperations.clickOnSideMenuMPINPolicyFromMyProfile(0);
	}

	public void clickOnDashboardeMPINPolicy() {
		navigationPageOperations.clickOnDashboardMPINPolicy(0);
	}

	public void clickOnSideMenuePrivacyPolicyFromSettings() {
		navigationPageOperations.clickOnSideMenuPrivacyPolicyFromSettings(0);
	}

	public void clickOnSideMenueTermsAndConditionsFromProfile() {
		//navigationPageOperations.clickOnSideMenuTermsAndConditionsFromProfile(0);
		
	}

	public void clickOnSideMenueTermsAndConditionsFromSideMenu() {
		navigationPageOperations.clickOnSideMenuTermsAndConditionsFromSideMenu(0);
	}

	public void clickOnDashboardePrivacyPolicy() {
		navigationPageOperations.clickOnDashboardPrivacyPolicy(0);
	}

	public void clickOnDashboardeTermsAndConditions() {
		navigationPageOperations.clickOnDashboardTermsAndConditions(0);
	}
	
	public void clickOnPasswordPolicyFromFooter() {
		navigationPageOperations.clickOnDashboardPasswordPolicy(0);
	}

	public void clickOnSideMenuChangeLanguageFromProfile() {
		navigationPageOperations.clickOnSideMenuChangeLanguageFromProfile(0);
	}

	public void clickOnSideMenuContactUsFromProfile() {
		navigationPageOperations.clickOnSideMenuContactUsFromProfile(0);
	}

	public void clickOnSideMenuAboutUsFromProfile() {
		navigationPageOperations.clickOnSideMenuAboutUsFromProfile(0);
	}

	public void clickOnDashboardChangeLanguage() {
		navigationPageOperations.clickOnDashboardChangeLanguage(0);
	}

	public void clickOnDashboardContactUs() {
		navigationPageOperations.clickOnDashboardContactUs(0);
	}

	public void clickOnDashboardAboutUs() {
		navigationPageOperations.clickOnDashboardAboutUs(0);
	}

	public void clickOnDashboardChangeMPIN() {
		navigationPageOperations.clickOnDashboardChangeMPIN(0);
	}

	public void clickOnDashboardChangePassword() {
		navigationPageOperations.clickOnDashboardChangePassword(0);
	}

	public void clickOnProfileChangePassword() {
		navigationPageOperations.clickOnProfileChangePassword(0);
	}

	public void clickOnNavBarMyTransactions() {
		navigationPageOperations.clickOnNavBarMyTransactions(0);
	}

	public void clickOnSideMenuServicesSalaryDisbursement() {
		navigationPageOperations.clickOnSideMenuServices(0);
		navigationPageOperations.clickOnSideMenuServicesSalaryDisbursement(0);
	}

	public void clickOnSideMenuServicesDisbursementRequestList() {
		navigationPageOperations.clickOnSideMenuServices(0);
		navigationPageOperations.clickOnSideMenuServicesDisbursementRequestList(0);
	}

	public void clickOnSideMenuServicesDisbursementReport() {
		navigationPageOperations.clickOnSideMenuServices(0);
		navigationPageOperations.clickOnSideMenuServicesDisbursementReport(0);
	}

	public void clickOnSideMenuServicesTransactionDetail() {
		navigationPageOperations.clickOnSideMenuServices(0);
		navigationPageOperations.clickOnSideMenuServicesTransactionDetail(0);
	}

	public void clickOnB2BTransfer() {
		navigationPageOperations.clickOnB2BTransfer(0);
	}

	public void clickOnDisbursementReport() {
		navigationPageOperations.clickOnDisbursementReport(0);
	}

	public void clickOnDashboardDisbursementReport() {
		navigationPageOperations.clickOnDashboardDisbursementReport(0);
	}

	public void clickOnDisbursementRequestList() {
		navigationPageOperations.clickOnDisbursementRequestList(0);
	}

	public void clickOnSalaryDisbursement() {
		navigationPageOperations.clickOnSalaryDisbursement(0);
	}

	public void clickOnDashboardSalaryDisbursement() {
		navigationPageOperations.clickOnDashboardSalaryDisbursement(0);
	}

	public void clickOnTransactionDetail() {
		navigationPageOperations.clickOnTransactionDetail(0);
	}

	public void clickOnDashboardTransactionDetail() {
		navigationPageOperations.clickOnDashboardTransactionDetail(0);
	}

	public void clickOnWithdrawMoney() {
		navigationPageOperations.clickOnWithdrawMoney(0);
	}

	public void clickOnChangeMpinfromSideMenu() {
		navigationPageOperations.clickOnChangeMpinfromSideMenu(0);
	}
	
	public void clickOnResetMpinfromSideMenu() {
		navigationPageOperations.clickOnResetMpinfromSideMenu(0);
	}
	

	public void clickOnChangeMpinfromSideMenuForWrongMPIN() {
		navigationPageOperations.clickOnChangeMpinfromSideMenuWorngInput(0);
	}

	public void clickOnChangeSecretWordfromSideMenu() {
		navigationPageOperations.clickOnChangeSecretWordfromSideMenu(0);
	}

	public void clickOnForgotSecretWordfromLogin() {
		navigationPageOperations.clickOnChangeSecretWordfromLogin(0);
	}
	
	public void clickOnForgotPasswordfromLogin() {
		navigationPageOperations.clickOnForgotPasswordfromLogin(0);
	}

	public void clickOnLogOutForNass() {
		navigationPageOperations.clickOnLogOutForNass(0);
	}

	public void clickOnP2PTransferfromFooter() {
		navigationPageOperations.clickOnP2PTransferfromFooter(0);
	}

	public void clickOnSideP2PTransfer() {
		navigationPageOperations.clickOnSideP2PTransfer(0);
	}

	public void clickOnSideP2POffnetTransfer() {
		navigationPageOperations.clickOnSideP2POffnetTransfer(0);
	}

	public void clickOnP2POffnetTransferfromFooter() {
		navigationPageOperations.clickOnP2POffnetTransferfromFooter(0);
	}

	public void clickOnMerchantPayment() {
		navigationPageOperations.clickOnMerchantPayment(0);
	}

	public void clickOnSideMenuMerchantPayment() {
		navigationPageOperations.clickOnSideMenuMerchantPayment(0);
	}

	public void clickOnDashboardMerchantPayment() {
		navigationPageOperations.clickOnDashboardMerchantPayment(0);
	}

	public void clickOnEnterprisePayment() {
		navigationPageOperations.clickOnEnterprisePayment(0);
	}

	public void clickOnSideMenuEnterprisePayment() {
		navigationPageOperations.clickOnSideMenuEnterprisePayment(0);
	}

	public void clickOnDashboardEnterprisePayment() {
		navigationPageOperations.clickOnDashboardEnterprisePayment(0);
	}

	public void clickOnCashOut() {
		navigationPageOperations.clickOnCashOut(0);
	}

	public void clickOntxtAgentAssistedWithdraw() {
		navigationPageOperations.clickOntxtAgentAssistedWithdraw(0);
	}

	public void clickOnContactUs() {
		navigationPageOperations.clickOnDashboardContactUs(0);
	}

	public void clickOnAboutUs() {
		navigationPageOperations.clickOnDashboardAboutUs(0);
	}

	public void clickOnMobileTopup() {
		navigationPageOperations.clickOnMobileTopup(0);
	}

	public void clickOnSideMenuMobileTopup() {
		navigationPageOperations.clickOnSideMenuMobileTopup(0);
	}

	public void clickOnDashboardMobileTopup() {
		navigationPageOperations.clickOnDashboardMobileTopup(0);
	}

	public void clickOnMobilePostpaid() {
		navigationPageOperations.clickOnMobilePostpaid(0);
	}

	public void clickOnSideMenuMobilePostpaid() {
		navigationPageOperations.clickOnSideMenuMobilePostpaid(0);
	}

	public void clickOnDashboardMobilePostpaid() {
		navigationPageOperations.clickOnDashboardMobilePostpaid(0);
	}

	public void clickOnSend() {
		navigationPageOperations.clickOnSend(0);
	}

	public void clickOnNasswalletAccountHolder() {
		navigationPageOperations.clickOnNasswalletAccountHolder(0);
	}

	public void goToHome(int... args) {
		navigationPageOperations.goToHome(args);
	}

	public void clickOnChatOption() {
		navigationPageOperations.clickOnChatOption(0);
	}

	public void clickOnNasswalletMerchant() {
		navigationPageOperations.clickOnNasswalletMerchant(0);
	}

	public void clickOnSideMenuB2BTransfer() {
		navigationPageOperations.clickOnSideMenuB2BTransfer(0);
	}

	public void clickOnDashboardB2BTransfer() {
		navigationPageOperations.clickOnDashboardB2BTransfer(0);
	}

	public void clickOnSideMenuWithdrawMoney() {
		navigationPageOperations.clickOnSideMenuServices(0);
		navigationPageOperations.clickOnSideMenuWithdrawMoney(0);
	}

	public void clickOnDashboardWithdrawMoney() {
		navigationPageOperations.clickOnDashboardWithdrawMoney(0);
	}

	public void clickOnM2MTransfer() {
		navigationPageOperations.clickOnM2MTransfer(0);
	}

	public void clickOnSideMenuM2MTransfer() {
		navigationPageOperations.clickOnSideMenuM2MTransfer(0);
	}

	public void clickOnDashboardM2MTransfer() {
		navigationPageOperations.clickOnDashboardM2MTransfer(0);
	}

	public void clickOnMerchantRefund() {
		navigationPageOperations.clickOnMerchantRefund(0);
	}

	public void clickOnSideMenuMerchantRefund() {
		navigationPageOperations.clickOnSideMenuMerchantRefund(0);
	}

	public void clickOnDashboardMerchantRefund() {
		navigationPageOperations.clickOnDashboardMerchantRefund(0);
	}

	public void clickOnSideMenuAssistantOnboarding() {
		navigationPageOperations.clickOnSideMenuServices(0);
		navigationPageOperations.clickOnSideMenuAssistantOnboarding(0);
	}

	public void clickOnManageAssistant() {
		navigationPageOperations.clickOnManageAssistant(0);
	}

	public void clickOnSideMenuManageAssistant() {
		navigationPageOperations.clickOnSideMenuManageAssistant(0);
	}

	public void clickOnDashboardManageAssistant() {
		navigationPageOperations.clickOnDashboardManageAssistant(0);
	}

	public void clickOnTellerOnboarding() {
		navigationPageOperations.clickOnTellerOnboarding(0);
	}

	public void clickOnSideMenuTellerOnboarding() {
		navigationPageOperations.clickOnSideMenuTellerOnboarding(0);
	}

	public void clickOnDashboardTellerOnboarding() {
		navigationPageOperations.clickOnDashboardTellerOnboarding(0);
	}

	public void clickOnManageTeller() {
		navigationPageOperations.clickOnManageTeller(0);
	}

	public void clickOnSideMenuManageTeller() {
		navigationPageOperations.clickOnSideMenuManageTeller(0);
	}

	public void clickOnDashboardManageTeller() {
		navigationPageOperations.clickOnDashboardManageTeller(0);
	}

	public void clickOnSideMenuServicesCommissionReport() {
		navigationPageOperations.clickOnSideMenuServices(0);
		navigationPageOperations.clickOnSideMenuServicesCommissionReport(0);
	}

	public boolean isLogoutButtonDislay(int... args) {
		return verifyVisible(navigationPageOperations.logOut, args);
	}

	public void clickOnA2ATransfer() {
		navigationPageOperations.clickOnA2ATransfer(0);
	}

	public void clickOnSideMenuA2ATransfer() {
		navigationPageOperations.clickOnSideMenuA2ATransfer(0);
	}

	public void clickOnFooterOptionA2ATransfer() {
		navigationPageOperations.clickOnFooterOptionA2ATransfer(0);
	}

	public void clickOnCashInByAgent() {
		navigationPageOperations.clickOnCashInByAgent(0);
	}

	public void clickOnSideMenuCashInByAgent() {
		navigationPageOperations.clickOnSideMenuCashInByAgent(0);
	}

	public void clickOnDashboardCashInByAgent() {
		navigationPageOperations.clickOnDashboardCashInByAgent(0);
	}

	public void clickOnUpdateCustomerKYC() {
		navigationPageOperations.clickOnUpdateCustomerKYC(0);
	}

	public void clickOnSideMenuUpdateCustomerKYC() {
		navigationPageOperations.clickOnSideMenuUpdateCustomerKYC(0);
	}

	public void clickOnDashboardUpdateCustomerKYC() {
		navigationPageOperations.clickOnDashboardUpdateCustomerKYC(0);
	}

	public void clickOnCustomerOnboarding() {
		navigationPageOperations.clickOnCustomerOnboarding(0);
	}

	public void clickOnSideMenuCustomerOnboarding() {
		navigationPageOperations.clickOnSideMenuCustomerOnboarding(0);
	}

	public void clickOnDashboardCustomerOnboarding() {
		navigationPageOperations.clickOnDashboardCustomerOnboarding(0);
	}

	public void clickOnManageAgent() {
		navigationPageOperations.clickOnManageAgent(0);
	}

	public void clickOnSideMenuManageAgent() {
		navigationPageOperations.clickOnSideMenuManageAgent(0);
	}

	public void clickOnDashboardManageAgent() {
		navigationPageOperations.clickOnDashboardManageAgent(0);
	}

	public void clickOnSideMenuAgentOnboarding() {
		navigationPageOperations.clickOnSideMenuAgentOnboarding(0);
	}

	public void clickOnDashboardAgentOnboarding() {
		navigationPageOperations.clickOnDashboardAgentOnboarding(0);
	}

	public void clickOnTransactionSummary() {
		navigationPageOperations.clickOnTransactionSummary(0);
	}

	public void clickOnDashboardTransactionSummary() {
		navigationPageOperations.clickOnDashboardTransactionSummary(0);
	}

	public void clickOnSideMenuTransactionSummary() {
		navigationPageOperations.clickOnSideMenu(0);
		navigationPageOperations.clickOnSideMenuTransactionSummary(0);
	}

	public void clickOnForgottenMPIN() {
		navigationPageOperations.clickOnForgottenMPIN(0);
	}

	public void clickOnCommissionReport() {
		moveToElement(navigationPageOperations.txtCommissionReport);
		navigationPageOperations.clickOnCommissionReport(0);
	}

	public void clickOnCommissionReportFooter() {
		navigationPageOperations.clickOnDashboardCommissionReport(0);
	}

	public void clickOnForgottenPassword() {
		navigationPageOperations.clickOnForgottenPassword(0);
	}

	public void clickOnNewUser() {
		navigationPageOperations.clickOnNewUser(0);
	}

	public void clickOneVoucher() {
		navigationPageOperations.clickOneVoucher(0);
	}

	public void clickOnArbelaStore() {
		navigationPageOperations.clickOnArbelaStore(0);
	}

	public void clickOnSideMenueVoucher() {
		navigationPageOperations.clickOnSideMenueVoucher(0);
	}

	public void clickOnSideMenuArbelaStore() {
		navigationPageOperations.clickOnSideMenuArbelaStore(0);
	}

	public void clickOnCustomereVoucher() {
		navigationPageOperations.clickOnCustomereVoucher(0);
	}

	public void clickOnAirtimeSale() {
		navigationPageOperations.clickOnMobileTopup(0);
	}

	public void clickOnDashboardAirtimeSale() {
		navigationPageOperations.clickOnDashboardAirtimeSale(0);
	}

	public void clickOnSideMenuAirtimeSale() {
		navigationPageOperations.clickOnSideMenu(0);
		navigationPageOperations.clickOnSideMenuAirtimeSale(0);
	}

	public void clickOnAgentAssistedDeposit() {
		navigationPageOperations.clickOnclickOnAgentAssistedDeposit(0);
	}
	
	public void clickOnAgentAssistedDepositIcon() {
		navigationPageOperations.clickOnclickOnAgentAssistedDepositIcon(0);	
	}
	
	public void clickOnAgentAssistedDepositFromFooter() {
		navigationPageOperations.clickOnclickOnAgentAssistedDepositFooter(0);	
	}

	public void clickOnAgentAssistedDepositFromFooterSidemenu() {
		navigationPageOperations.clickOnclickOnAgentAssistedDepositFromSidemenu(0);	
	}


	public void clickOnSideMenuProfileverifyFAQs(int time) {
		verifyVisible(navigationPageOperations.faqsTitle, time);
		setLogSteps(log, "Verify Check Title");

	}

	public void clickOnPasswordPolicyDash() {
		navigationPageOperations.clickOnDashboardPasswordPolicy(0);
	}

	public void clickOnSideMenueTermsAndConditionsFromSettings() {
		navigationPageOperations.clickOnSideMenu(0);
	}

	public void Verifybalance(double Check_Balance, double Check_Balance_Profile) {
		navigationPageOperations.clickOnDashboardProfileDetail(0);
		setLogSteps(log, "Verify Balance for Dashboard:" + Check_Balance + " and Profile:" + Check_Balance_Profile);
		setLogSteps(log, "Verify Both are Equal");
		assertEquals(Check_Balance, Check_Balance_Profile, GENERAL_TIMEOUT);

	}

	public void VerifyPersonalinfo() {

		navigationPageOperations.clickOnPersonalinfoProfile(0);
		verifyVisible(navigationPageOperations.PersonalinfoProfile, 0);
		setLogSteps(log, "Verify Personal info");

	}

	public void VerifyDocumentinforeligiousworship() {
		navigationPageOperations.clickOnDocumentinforeligiousworshipProfile(0);
		verifyVisible(navigationPageOperations.DocumentinforeligiousworshipProfile, 0);
		setLogSteps(log, "Verify Document info religious worship info ");

	}

	public void clickOnSideMenuProfileMyProfile() {
		navigationPageOperations.clickOnSideMenuProfileMyProfile(0);
	}

	public void clickOnMyProfile() {
		navigationPageOperations.clickOnMyProfile(0);
	}

	public void clickOnForgetMpinfromLogin() {
		navigationPageOperations.clickOnForgetMpinfromLogin(0);
	}
	
	public void clickOnProfileIconSubAgent() {
		navigationPageOperations.clickOnProfileIconSubAgent(0);
	}

	public void VerifyServiceiconsdisplayedFromDashboard() {
		verifyVisible(navigationPageOperations.CustomerCashinicon, 0);
		setLogSteps(log, "Verify Cash in icon in Dashboard ");
		verifyVisible(navigationPageOperations.CustomerP2PTransfericon, 0);
		setLogSteps(log, "Verify P2P Transfer icon in Dashboard ");
		verifyVisible(navigationPageOperations.CustomerWithdrawCashicon, 0);
		setLogSteps(log, "Verify Withdraw Cash icon in Dashboard ");
		verifyVisible(navigationPageOperations.CustomerTopUpBundleicon, 0);
		setLogSteps(log, "Verify TopUp Bundle icon in Dashboard ");
		verifyVisible(navigationPageOperations.CustomerBillPaymenticon, 0);
		setLogSteps(log, "Verify Bll Payment icon in Dashboard ");
		verifyVisible(navigationPageOperations.CustomerTopUpAirtimeicon, 0);
		setLogSteps(log, "VerifyTopUp Airtime icon in Dashboard ");
		verifyVisible(navigationPageOperations.CustomerP2pOffneticon, 0);
		setLogSteps(log, "Verify P2P Offnet icon in Dashboard ");
		verifyVisible(navigationPageOperations.CustomerFinancialServiceicon, 0);
		setLogSteps(log, "Verify Financial Services icon in Dashboard ");
	}
	
	public void VerifyServiceiconsdisplayedFromDashboardSubAgent() {
		verifyVisible(navigationPageOperations.txtAgentAssistedDeposit, 0);
		setLogSteps(log, "Verify Agent Assisted Deposit icon in Dashboard ");
		verifyVisible(navigationPageOperations.txtAgentAssistedWithdraw, 0);
		setLogSteps(log, "Verify Agent Assisted Withdraw icon in Dashboard ");
		verifyVisible(navigationPageOperations.txtA2ATransfer, 0);
		setLogSteps(log, "Verify Agent Transfer icon in Dashboard ");
		verifyVisible(navigationPageOperations.txtCashOut, 0);
		setLogSteps(log, "Verify Withdraw Cash icon in Dashboard ");
		
	}

}
