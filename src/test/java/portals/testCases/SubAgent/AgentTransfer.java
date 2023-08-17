package portals.testCases.SubAgent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;
import utils.Utility;

public class AgentTransfer extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();
	public static double Check_Balance;
	public static double Check_Balance_Profile;
	public static double Check_CommissionBalance;
	public static double CommissionBalance_Profile;

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "A2ATransfer", dataProviderClass = TestDataImport.class)
	public void a2aTranfer(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "a2aTranfer");
			map.put(MethodName, "a2aTransfer");
			co.navigationPage.clickOnA2ATransfer();
			map = co.subAgent_AgentTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("a2aTranfer", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedA2ATranferFromFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTranfer")) {
			for (Map<Object, Object> map : verificationData.get("a2aTranfer")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATranferFromFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUserTangereine(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					if (co.navigationPage.isLogoutButtonDislay(3))
						co.navigationPage.clickOnLogOut();
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test
	public void verifyPerformedA2ATransferFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTranfer")) {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				co.navigationPage.clickOnLogOut();
			}
			for (Map<Object, Object> map : verificationData.get("a2aTranfer")) {
				co.loginPage.login(map.get(ToUserName).toString(), map.get(ToPassword).toString(),
						map.get(ToUserType).toString());
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATranferFromToUserPassbook");
					co.common.verifyTransactionInWebPortalForToUser(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					if (co.navigationPage.isLogoutButtonDislay(3))
						co.navigationPage.clickOnLogOut();
				}
			}

		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test(dataProvider = "A2ATransfer", dataProviderClass = TestDataImport.class)
	public void a2aTransferFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "a2aTransferFromSideMenu");
			map.put(MethodName, "a2aTransfer");
			co.navigationPage.clickOnSideMenuA2ATransfer();
			map = co.subAgent_AgentTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("a2aTransferFromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedA2ATransferFromSideMenuFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTransferFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("a2aTransferFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATransferFromSideMenuFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUserTangereine(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test
	public void verifyPerformedA2ATransferFromSideMenuFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTransferFromSideMenu")) {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				co.navigationPage.clickOnLogOut();
			}
			for (Map<Object, Object> map : verificationData.get("a2aTransferFromSideMenu")) {
				co.loginPage.login(map.get(ToUserName).toString(), map.get(ToPassword).toString(),
						map.get(ToUserType).toString());
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATransferFromSideMenuFromToUserPassbook");
					co.common.verifyTransactionInWebPortalForToUser(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					if (co.navigationPage.isLogoutButtonDislay(3))
						co.navigationPage.clickOnLogOut();
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test(dataProvider = "A2ATransfer", dataProviderClass = TestDataImport.class)
	public void a2aTransferFromFooter(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "a2aTransferFromFooter");
			map.put(MethodName, "a2aTransferfromFooter");
			co.navigationPage.clickOnFooterOptionA2ATransfer();
			map = co.subAgent_AgentTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("a2aTransferFromFooter", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedA2ATransferFromFooterFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTransferFromFooter")) {
			for (Map<Object, Object> map : verificationData.get("a2aTransferFromFooter")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATransferFromFooterFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUserTangereine(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test
	public void verifyPerformedA2ATransferFromFooterFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTransferFromFooter")) {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				co.navigationPage.clickOnLogOut();
			}
			for (Map<Object, Object> map : verificationData.get("a2aTransferFromFooter")) {
				co.loginPage.login(map.get(ToUserName).toString(), map.get(ToPassword).toString(),
						map.get(ToUserType).toString());
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATransferFromFooterFromToUserPassbook");
					co.common.verifyTransactionInWebPortalForToUser(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					if (co.navigationPage.isLogoutButtonDislay(3))
						co.navigationPage.clickOnLogOut();
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test
	public void CheckBalanceFormDashboard() {
		try {

			Check_Balance = co.a2aTransferPage.clickOnCheckBalance();
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {

		}
	}

	@Test
	public void CheckCommissionBalanceFormDashboard() {
		try {
				
			Check_CommissionBalance = co.a2aTransferPage.clickOnCheckCommissionBalance();
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {

		}
	}

	@Test
	public void CheckBalanceFormProfile() {
		try {
			co.navigationPage.clickOnSideMenu();
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			Check_Balance_Profile = co.a2aTransferPage.clickOnCheckBalanceFromProfile();
			co.navigationPage.Verifybalance(Check_Balance, Check_Balance_Profile);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {

		}
	}

	@Test
	public void CheckCommissionBalanceFormProfile() {
		try {
			co.navigationPage.clickOnSideMenu();
			co.navigationPage.clickOnMenuProfile();
			co.navigationPage.clickOnMenuProfileViewProfile();
			pauseInSeconds(3);
			CommissionBalance_Profile = co.a2aTransferPage.clickOnCheckCommissionBalanceFromProfile();
			co.navigationPage.Verifybalance(Check_CommissionBalance, CommissionBalance_Profile);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {

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
			co.loginPage.login_With_Invalid(map.get(ToUserName).toString(), map.get(ToPassword).toString(),
					"super agent");
			co.navigationPage.verifyUserNotActive();

		} catch (Exception e) {
			throw new RuntimeException("verification failed, verify User Not Active Message not Found");
		}
	}

	@Test(dataProvider = "ReadOnly", dataProviderClass = TestDataImport.class)
	public void LoginWithReadOnlyuser(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(2);
				co.navigationPage.clickOnLogOut();
			}
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "ReadOnly");
			map.put(MethodName, "ReadOnly");
			co.loginPage.login_With_Invalid(map.get(ToUserName).toString(), map.get(ToPassword).toString(),
					"super agent");
			co.navigationPage.goToHome();

		} catch (Exception e) {
			throw new RuntimeException("verification failed, verify User Not Login");
		}
	}
}
