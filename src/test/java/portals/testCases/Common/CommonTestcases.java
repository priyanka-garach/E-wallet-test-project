package portals.testCases.Common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class CommonTestcases extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test
	public void checkBalanceFromDashboardViewBalance() {
		try {
			setTestParameters(co.datamap, "checkBalanceFromDashboardViewBalance");
			co.dashBoardPageOperations.clickOnCheckBalance();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "QRCode", dataProviderClass = TestDataImport.class)
	public void qrCodeFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "qrCodeFromDashboard");
			co.navigationPage.clickOnNavBarQRCode();
			co.dashboardPage.verifyQRcodeData(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "Passbook_Filter", dataProviderClass = TestDataImport.class)
	public void passBookFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "passBookFromDashboard");
			co.navigationPage.clickOnNavBarPassbook();
			co.dashboardPage.selectPassbookFilter(map);
			co.dashboardPage.verifyPassbook(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void VerifyServiceiconsdisplayedFromDashboardCustomer() {
		try {
			co.navigationPage.VerifyServiceiconsdisplayedFromDashboard();

		} catch (Exception e) {
		} finally {
		}
	}

	@Test
	public void verifyDownloadPassbook() {
		try {
			setTestParameters(co.datamap, "verifyDownloadPassbook");
			co.common.clearDownloadsDirectory();
			co.dashboardPage.verifyDownloadPassbook();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void recentTransactionFromDashboard() {
		try {
			setTestParameters(co.datamap, "recentTransactionFromDashboard");
			co.dashboardPage.verifyRecentTransactions();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "LoginStartwithZero", dataProviderClass = TestDataImport.class)
	public void LoginStartwithZero(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(2);
				co.navigationPage.clickOnLogOut();
			}
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "LoginStartwithZero");
			map.put(MethodName, "LoginStartwithZero");
			co.loginPage.login_With_Invalid(map.get(FromUserName).toString(), map.get(FromMpin).toString(), "customer");

			co.navigationPage.verifyLoggedIn();

		} catch (Exception e) {
			throw new RuntimeException("verification failed, verify User Not Active Message not Found");
		}
	}

	@Test(dataProvider = "InActiveUser", dataProviderClass = TestDataImport.class)
	public void LoginWithinvalidLogin(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(2);
				co.navigationPage.clickOnLogOut();
			}
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "InActiveUser");
			map.put(MethodName, "InActiveUser");
			co.loginPage.login_With_Invalid(map.get(FromUserName).toString(), map.get(FromPassword).toString(),
					"customer");
			co.navigationPage.verifyUserNotActive();
		} catch (Exception e) {
			throw new RuntimeException("verification failed, verify User Not Active Message not Found");
		}
	}

	@Test(dataProvider = "ThreeWrongMPINAttempts", dataProviderClass = TestDataImport.class)
	public void ThreeWrongMPINAttempts(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(2);
				co.navigationPage.clickOnLogOut();
			}
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "ThreeWrongMPINAttempts");
			map.put(MethodName, "ThreeWrongMPINAttempts");
			co.loginPage.login_With_Invalid(map.get(FromUserName).toString(), map.get(FromMpin).toString(), "customer");
			co.navigationPage.verifyInvalidCredentials();

			co.loginPage.login_With_Invalid(map.get(FromUserName).toString(), map.get(FromMpin).toString(), "customer");
			co.navigationPage.verifyInvalidCredentials();

			co.loginPage.login_With_Invalid(map.get(FromUserName).toString(), map.get(FromMpin).toString(), "customer");
			co.navigationPage.verifyAccountTempBlocked();

		} catch (Exception e) {
			throw new RuntimeException("verification failed, verify Three Login should fail not working");
		}
	}

	@Test
	public void mpinPolicyFromDashboardFooter() {
		try {
			setTestParameters(co.datamap, "mpinPolicyFromDashboardFooter");
			co.navigationPage.clickOnDashboardeMPINPolicy();
			co.mpinPolicyPage.verifyMpinPolicy();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void mpinPolicyFromSideMenuSettings() {
		try {
			setTestParameters(co.datamap, "mpinPolicyFromSideMenuSettings");
			co.navigationPage.clickOnSideMenu();
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			co.navigationPage.clickOnSideMenueChangeMPIN();
			co.navigationPage.clickOnSideMenueMPINPolicyFromSetings();
			co.mpinPolicyPage.verifyMpinPolicy();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void privacyPolicyFromDashboardFooter() {
		try {
			setTestParameters(co.datamap, "privacyPolicyFromDashboardFooter");
			co.navigationPage.clickOnDashboardePrivacyPolicy();
			co.privacyPolicyPage.verifyPrivacyPolicy();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void privacyPolicyFromSideMenuProfile() {
		try {
			co.navigationPage.clickOnSideMenu();
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenuePrivacyPolicyFromSettings();
			co.privacyPolicyPage.verifyPrivacyPolicy();
		} catch (Exception e) {
		} finally {
		}
	}

	@Test
	public void privacyPolicyFromSideMenuSettings() {
		try {
			co.navigationPage.clickOnSideMenuSettings();
			setTestParameters(co.datamap, "privacyPolicyFromSideMenuSettings");
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenuePrivacyPolicyFromSettings();
			co.privacyPolicyPage.verifyPrivacyPolicy();
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	public void termsAndConditionsFromSideMenuProfile() {
		try {
			co.navigationPage.clickOnSideMenu();
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenueTermsAndConditionsFromProfile();
			setTestParameters(co.datamap, "termsAndConditionsFromSideMenuSettings");
			co.navigationPage.clickOnSideMenueTermsAndConditionsFromSideMenu();
			co.termsAndConditionsPage.verifyTermsAndConditions();
		} catch (Exception e) {
		} finally {
		}
	}

	@Test
	public void termsAndConditionsFromSideMenuSettings() {
		try {
			co.navigationPage.clickOnSideMenueTermsAndConditionsFromSettings();
			co.termsAndConditionsPage.verifyTermsAndConditions();
		} catch (Exception e) {
		} finally {
		}
	}

	@Test
	public void verifyChatOption() {
		try {
			setTestParameters(co.datamap, "verifyChatOption");
			co.navigationPage.clickOnChatOption();
			co.dashboardPage.verifyChatOption();
			co.dashboardPage.verifyUGX_SignAvailable();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void UGX_SignAvailable() {
		try {
			setTestParameters(co.datamap, "UGX_SignAvailable");
			co.dashboardPage.verifyUGX_SignAvailable();
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {

		}
	}

	@Test(dataProvider = "ChangeLanguage", dataProviderClass = TestDataImport.class)
	public void changeLanguageFromDashboardFooter(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeLanguageFromDashboardFooter");
			co.navigationPage.clickOnDashboardChangeLanguage();
			co.changeLanguagePage.changeLanguage(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "ChangeLanguage", dataProviderClass = TestDataImport.class)
	public void changeLanguageFromSideMenuProfile(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeLanguageFromSideMenuProfile");
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenuChangeLanguageFromProfile();
			co.changeLanguagePage.changeLanguage(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void logout() {
		try {
			setTestParameters(co.datamap, "logout");
			if (co.navigationPage.isLogoutButtonDislay(5))
				co.navigationPage.clickOnLogOut();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void transactionDeatilReportFromDashboard() {
		try {
			setTestParameters(co.datamap, "transactionDeatilReportFromDashboard");
			co.navigationPage.clickOnTransactionDetail();
			co.transactionDetailPage.verifyTransactionDetailReport();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void transactionDeatilReportFromDashboardFooter() {
		try {
			setTestParameters(co.datamap, "transactionDeatilReportFromDashboardFooter");
			co.navigationPage.clickOnDashboardTransactionDetail();
			co.transactionDetailPage.verifyTransactionDetailReport();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void transactionDeatilReportFromSideMenuServices() {
		try {
			setTestParameters(co.datamap, "transactionDeatilReportFromSideMenuServices");
			co.navigationPage.clickOnSideMenuServicesTransactionDetail();
			co.transactionDetailPage.verifyTransactionDetailReport();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void transactionSummaryReportFromDashboard() {
		try {
			setTestParameters(co.datamap, "transactionSummaryReportFromDashboard");
			co.navigationPage.clickOnTransactionSummary();
			co.transactionSummaryPage.verifyTransactionSummaryReport();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void transactionSummaryReportFromDashboardFooter() {
		try {
			setTestParameters(co.datamap, "transactionSummaryReportFromDashboardFooter");
			co.navigationPage.clickOnDashboardTransactionSummary();
			co.transactionSummaryPage.verifyTransactionSummaryReport();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void transactionSummaryReportFromSideMenuServices() {
		try {
			setTestParameters(co.datamap, "transactionSummaryReportFromSideMenuServices");
			co.navigationPage.clickOnSideMenuTransactionSummary();
			co.transactionSummaryPage.verifyTransactionSummaryReport();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void commissionReportFromDashboard() {
		try {
			setTestParameters(co.datamap, "commissionReportFromDashboard");
			co.navigationPage.clickOnCommissionReport();
			co.commissionReportPage.verifyCommissionReport();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void commissionReportFromDashboardFooter() {
		try {
			setTestParameters(co.datamap, "commissionReportFromDashboardFooter");
			co.navigationPage.clickOnCommissionReportFooter();
			co.commissionReportPage.verifyCommissionReport();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void commissionReportFromSideMenuServices() {
		try {
			setTestParameters(co.datamap, "commissionReportFromSideMenuServices");
			co.navigationPage.clickOnSideMenuServicesCommissionReport();
			co.commissionReportPage.verifyCommissionReport();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void changeMPinFromDashboardFooter() {
		try {
			setTestParameters(co.datamap, "changeMPinFromDashboardFooter");
			co.navigationPage.clickOnChangeMPin();
			co.commissionReportPage.verifyCommissionReport();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void changeMPinFromSideMenu() {
		try {
			setTestParameters(co.datamap, "changeMPinFromSideMenu");
			co.navigationPage.clickOnSideMenuSettingsChangeMPIN();
			co.commissionReportPage.verifyCommissionReport();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void forgotMPin() {
		try {
			setTestParameters(co.datamap, "forgotMPin");
			co.navigationPage.clickOnLogOut();
			co.navigationPage.clickOnForgottenMPIN();
			co.forgotMPinPage.forgotMpin();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			co.loginPage.login(userName, password, subUserType);
			setExcecutionData(co);
		}
	}

	@Test
	public void forgotPassword() {
		try {
			setTestParameters(co.datamap, "forgotPassword");
			co.navigationPage.clickOnLogOut();
			co.navigationPage.clickOnForgottenPassword();
			co.forgotPasswordPage.forgotPassword();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			co.loginPage.login(userName, password, subUserType);
			setExcecutionData(co);
		}
	}

	@Test
	public void newUser() {
		try {
			setTestParameters(co.datamap, "newUser");
			co.navigationPage.clickOnLogOut();
			co.navigationPage.clickOnNewUser();
			co.newUserPage.newUser();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			co.loginPage.login(userName, password, subUserType);
			setExcecutionData(co);
		}
	}

	@Test
	public void VerifyPasswordPolicyfromChangePassword() {
		try {
			co.navigationPage.clickOnSideMenu();
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			co.navigationPage.clickOnPasswordPolicy();
			co.common.PasswordPolicy(0);
		} catch (Exception e) {
		} finally {

		}
	}

	@Test
	public void VerifyPasswordPolicyfromDashboardFooter() {
		try {
			co.navigationPage.clickOnPasswordPolicy();
			co.common.PasswordPolicy(0);
		} catch (Exception e) {
		} finally {
		}
	}

	@Test
	public void VerifyPersonalinforeligiousworshipFromProfile() {
		try {
			co.navigationPage.clickOnSideMenu();
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			co.navigationPage.VerifyPersonalinfo();

		} catch (Exception e) {
		} finally {
		}
	}

	@Test
	public void VerifyDocumentinforeligiousworshipFromProfile() {
		try {
			co.navigationPage.clickOnSideMenu();
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			co.navigationPage.VerifyDocumentinforeligiousworship();

		} catch (Exception e) {
		} finally {
		}
	}

	@Test
	public void verifyTransactionsInAdmin() {
		try {
			setTestParameters(co.datamap, "verifyTransactionsInAdmin");
			co.common.verifyTransactionInAdmin();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void VerifyServiceiconsdisplayedFromDashboard() {
		try {
			co.navigationPage.VerifyServiceiconsdisplayedFromDashboard();
		} catch (Exception e) {
		} finally {
		}
	}

	@Test(dataProvider = "ChangeSecretWord", dataProviderClass = TestDataImport.class)
	public void changeSecretWord(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "ChangeSecretWord");
			co.navigationPage.clickOnChangeSecretWordfromSideMenu();
			co.changesecretwordpage.setnewSecretWord(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	public void FAQsFromSideMenu() {
		try {
			setTestParameters(co.datamap, "FAQsFromSideMenu");
			co.navigationPage.clickOnSideMenuProfileFAQs();
			co.faqsPage.verifyFAQs();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
}
