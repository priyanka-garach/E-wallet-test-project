package portals.testCases.Agent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;
import utils.Utility;

public class WithdrawMoney extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "WithdrawMoney", dataProviderClass = TestDataImport.class)
	public void withdrawMoney(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "withdrawMoney");
			map.put(MethodName, "withdrawMoney");
			co.navigationPage.clickOnWithdrawMoney();
			map = co.agentWithdrawMoneyPage.withdrawMoney(map);
			setUseCaseVerificationData("withdrawMoney", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedWithdrawMoneyFromFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawMoney")) {
			for (Map<Object, Object> map : verificationData.get("withdrawMoney")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedWithdrawMoneyFromFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
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
	public void verifyPerformedWithdrawMoneyFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawMoney")) {
			for (Map<Object, Object> map : verificationData.get("withdrawMoney")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedWithdrawMoneyFromToUserPassbook");
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

	// @Test
	// public void verifyPerformedWithdrawMoneyFromAdmin() {
	// if (verifyMethodIsAvail(verificationData, "WithdrawMoney")) {
	// for (Map<Object, Object> map : verificationData.get("WithdrawMoney")) {
	// try {
	// setTestParameters(co.datamap, "verifyPerformedWithdrawMoneyFromAdmin");
	// co.common.verifyTransactionInAdmin(map.get(TransactionID).toString());
	// setSuccessParameters(co.datamap);
	// } catch (Exception e) {
	// setExceptionData(co, e);
	// } finally {
	// setExcecutionData(co);
	// }
	// }
	// } else {
	// throw new RuntimeException("verification failed, due to operation failed");
	// }
	// }

	@Test(dataProvider = "WithdrawMoney", dataProviderClass = TestDataImport.class)
	public void withdrawMoneyFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "withdrawMoneyFromSideMenu");
			map.put(MethodName, "withdrawMoney");
			co.navigationPage.clickOnSideMenuWithdrawMoney();
			map = co.agentWithdrawMoneyPage.withdrawMoney(map);
			setUseCaseVerificationData("withdrawMoneyFromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedWithdrawMoneyFromSideMenuFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawMoneyFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("withdrawMoneyFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedWithdrawMoneyFromSideMenuFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
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
	public void verifyPerformedWithdrawMoneyFromSideMenuFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawMoneyFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("withdrawMoneyFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedWithdrawMoneyFromSideMenuFromToUserPassbook");
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

	@Test(dataProvider = "WithdrawMoney", dataProviderClass = TestDataImport.class)
	public void withdrawMoneyFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "withdrawMoneyFromDashboard");
			map.put(MethodName, "withdrawMoney");
			co.navigationPage.clickOnDashboardWithdrawMoney();
			map = co.agentWithdrawMoneyPage.withdrawMoney(map);
			setUseCaseVerificationData("withdrawMoneyFromDashboard", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedwithdrawMoneyFromDashboardFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawMoneyFromDashboard")) {
			for (Map<Object, Object> map : verificationData.get("withdrawMoneyFromDashboard")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedwithdrawMoneyFromDashboardFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
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
	public void verifyPerformedwithdrawMoneyFromDashboardFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawMoneyFromDashboard")) {
			for (Map<Object, Object> map : verificationData.get("withdrawMoneyFromDashboard")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedwithdrawMoneyFromDashboardFromToUserPassbook");
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
