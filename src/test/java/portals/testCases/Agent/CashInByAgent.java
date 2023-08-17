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

public class CashInByAgent extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "CashInByAgent", dataProviderClass = TestDataImport.class)
	public void cashInByAgent(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "cashInByAgent");
			map.put(MethodName, "cashInByAgent");
			co.navigationPage.clickOnCashInByAgent();
			map = co.cashInByAgentPage.cashInByAgent(map);
			setUseCaseVerificationData("cashInByAgent", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedCashInByAgentFromFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "cashInByAgent")) {
			for (Map<Object, Object> map : verificationData.get("cashInByAgent")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedCashInByAgentFromFromUserPassbook");
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
	public void verifyPerformedCashInByAgentFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "cashInByAgent")) {
			for (Map<Object, Object> map : verificationData.get("cashInByAgent")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedCashInByAgentFromToUserPassbook");
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
	// public void verifyPerformedCashInByAgentFromAdmin() {
	// if (verifyMethodIsAvail(verificationData, "cashInByAgent")) {
	// for (Map<Object, Object> map : verificationData.get("cashInByAgent")) {
	// try {
	// setTestParameters(co.datamap, "verifyPerformedCashInByAgentFromAdmin");
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

	@Test(dataProvider = "CashInByAgent", dataProviderClass = TestDataImport.class)
	public void cashInByAgentFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "cashInByAgentFromSideMenu");
			map.put(MethodName, "cashInByAgent");
			co.navigationPage.clickOnSideMenuCashInByAgent();
			map = co.cashInByAgentPage.cashInByAgent(map);
			setUseCaseVerificationData("cashInByAgentFromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedCashInByAgentFromSideMenuFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "cashInByAgentFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("cashInByAgentFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedCashInByAgentFromSideMenuFromUserPassbook");
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
	public void verifyPerformedCashInByAgentFromSideMenuFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "cashInByAgentFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("cashInByAgentFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedCashInByAgentFromSideMenuFromToUserPassbook");
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

	@Test(dataProvider = "CashInByAgent", dataProviderClass = TestDataImport.class)
	public void cashInByAgentFromSend(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "cashInByAgentFromSend");
			map.put(MethodName, "cashInByAgent");
			co.navigationPage.clickOnSend();
			map = co.cashInByAgentPage.cashInByAgent(map);
			setUseCaseVerificationData("cashInByAgentFromSend", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedCashInByAgentFromSendFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "cashInByAgentFromSend")) {
			for (Map<Object, Object> map : verificationData.get("cashInByAgentFromSend")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedCashInByAgentFromSendFromUserPassbook");
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
	public void verifyPerformedCashInByAgentFromSendFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "cashInByAgentFromSend")) {
			for (Map<Object, Object> map : verificationData.get("cashInByAgentFromSend")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedCashInByAgentFromSideMenuFromToUserPassbook");
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

	@Test(dataProvider = "CashInByAgent", dataProviderClass = TestDataImport.class)
	public void cashInByAgentFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "cashInByAgentFromDashboard");
			map.put(MethodName, "cashInByAgent");
			co.navigationPage.clickOnDashboardCashInByAgent();
			map = co.cashInByAgentPage.cashInByAgent(map);
			setUseCaseVerificationData("cashInByAgentFromDashboard", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedCashInByAgentFromDashboardFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "cashInByAgentFromDashboard")) {
			for (Map<Object, Object> map : verificationData.get("cashInByAgentFromDashboard")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedCashInByAgentFromDashboardFromUserPassbook");
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
	public void verifyPerformedCashInByAgentFromDashboardFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "cashInByAgentFromDashboard")) {
			for (Map<Object, Object> map : verificationData.get("cashInByAgentFromDashboard")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedCashInByAgentFromDashboardFromToUserPassbook");
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
