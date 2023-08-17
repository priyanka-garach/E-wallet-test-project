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

public class SubAgentWithdrawCash extends SetupInit {
	protected CreateObject co;

	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "WithdrawCash", dataProviderClass = TestDataImport.class)
	public void withdrawCashSubAgentfromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "withdrawCashSubAgentfromDashboard");
			map.put(MethodName, "withdrawCashSubAgentfromDashboard");
			co.navigationPage.clickOnCashOut();
			map = co.withdrawCashPage.WithdrawCashAgenttoAgent(map);
			setUseCaseVerificationData("withdrawCashSubAgentfromDashboard", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedWithDrawCashtFromDashboardFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCashSubAgentfromDashboard")) {
			/*
			 * if (co.navigationPage.isLogoutButtonDislay(3)) { pauseInSeconds(2);
			 * co.navigationPage.clickOnLogOut(); }
			 */
			for (Map<Object, Object> map : verificationData.get("withdrawCashSubAgentfromDashboard")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedwithdrawCashSubAgentfromDashboardFromUserPassbook");
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
	public void verifyPerformedWithDrawFromDashboardToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCashSubAgentfromDashboard")) {
			for (Map<Object, Object> map : verificationData.get("withdrawCashSubAgentfromDashboard")) {
				try {
					pauseInSeconds(3);
					if (co.navigationPage.isLogoutButtonDislay(3)) {
						pauseInSeconds(2);
						co.navigationPage.clickOnLogOut();
					}
					co.datamap.putAll(map);
					co.loginPage.login(map.get(ToUserName).toString(), map.get(ToPassword).toString(), "super agent");
					setTestParameters(co.datamap, "withdrawCashSubAgentfromDashboardToUser");
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

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test(dataProvider = "WithdrawCash", dataProviderClass = TestDataImport.class)
	public void withdrawCashSubAgentfromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "withdrawCashSubAgentfromSideMenu");
			map.put(MethodName, "withdrawCashSubAgentfromSideMenu");
			co.navigationPage.clickOnWithdrawCashFromSideMenu();
			map = co.withdrawCashPage.WithdrawCashAgenttoAgent(map);
			setUseCaseVerificationData("withdrawCashSubAgentfromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedWithDrawCashtFromSideMenuFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCashSubAgentfromSideMenu")) {
			/*
			 * if (co.navigationPage.isLogoutButtonDislay(3)) { pauseInSeconds(2);
			 * co.navigationPage.clickOnLogOut(); }
			 */
			for (Map<Object, Object> map : verificationData.get("withdrawCashSubAgentfromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedwithdrawCashSubAgentfromSideMenuFromUserPassbook");
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
	public void verifyPerformedWithDrawFromSideMenuToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCashSubAgentfromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("withdrawCashSubAgentfromSideMenu")) {
				try {
					pauseInSeconds(3);
					if (co.navigationPage.isLogoutButtonDislay(3)) {
						pauseInSeconds(2);
						co.navigationPage.clickOnLogOut();
					}
					co.datamap.putAll(map);
					co.loginPage.login(map.get(ToUserName).toString(), map.get(ToPassword).toString(), "super agent");
					setTestParameters(co.datamap, "withdrawCashSubAgentfromSideMenuToUser");
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
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test(dataProvider = "WithdrawCash", dataProviderClass = TestDataImport.class)
	public void withdrawCashSubAgentfromFooter(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "withdrawCashSubAgentfromFooter");
			map.put(MethodName, "withdrawCashSubAgentfromFooter");
			co.navigationPage.clickOnWithdrawCashFroomFooter();
			map = co.withdrawCashPage.WithdrawCashAgenttoAgent(map);
			setUseCaseVerificationData("withdrawCashSubAgentfromFooter", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedWithDrawCashtFromFooterFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCashSubAgentfromFooter")) {
			/*
			 * if (co.navigationPage.isLogoutButtonDislay(3)) { pauseInSeconds(2);
			 * co.navigationPage.clickOnLogOut(); }
			 */
			for (Map<Object, Object> map : verificationData.get("withdrawCashSubAgentfromFooter")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedwithdrawCashSubAgentfromFooterFromUserPassbook");
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
	public void verifyPerformedWithDrawFromFooterToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCashSubAgentfromFooter")) {
			for (Map<Object, Object> map : verificationData.get("withdrawCashSubAgentfromFooter")) {
				try {
					pauseInSeconds(3);
					if (co.navigationPage.isLogoutButtonDislay(3)) {
						pauseInSeconds(2);
						co.navigationPage.clickOnLogOut();
					}
					co.datamap.putAll(map);
					co.loginPage.login(map.get(ToUserName).toString(), map.get(ToPassword).toString(), "super agent");
					setTestParameters(co.datamap, "withdrawCashSubAgentfromFooterToUser");
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
}
