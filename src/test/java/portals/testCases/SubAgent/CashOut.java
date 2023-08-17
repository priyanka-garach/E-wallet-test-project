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

public class CashOut extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "CashOut", dataProviderClass = TestDataImport.class)
	public void cashOut(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "cashOut");
			map.put(MethodName, "cashOut");
			co.navigationPage.clickOnCashOut();
		//	map = co.cashOutPage.agentCashOut(map);
			setUseCaseVerificationData("cashOut", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

//	@Test
//	public void verifyPerformedCashOutFromFromUserPassbook() {
//		if (verifyMethodIsAvail(verificationData, "cashOut")) {
//			for (Map<Object, Object> map : verificationData.get("cashOut")) {
//				try {
//					co.datamap.putAll(map);
//					setTestParameters(co.datamap, "verifyPerformedCashOutFromFromUserPassbook");
//					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
//					setSuccessParameters(co.datamap);
//				} catch (Exception e) {
//					setExceptionData(co, e);
//				} finally {
//					setExcecutionData(co);
//				}
//			}
//		} else {
//			throw new RuntimeException("verification failed, due to operation failed");
//		}
//	}
//
//	@Test
//	public void verifyPerformedCashOutFromToUserPassbook() {
//		if (verifyMethodIsAvail(verificationData, "cashOut")) {
//			for (Map<Object, Object> map : verificationData.get("cashOut")) {
//				try {
//					co.datamap.putAll(map);
//					setTestParameters(co.datamap, "verifyPerformedCashOutFromToUserPassbook");
//					co.common.verifyTransactionInWebPortalForToUser(map, co.dashboardPage);
//					setSuccessParameters(co.datamap);
//				} catch (Exception e) {
//					setExceptionData(co, e);
//				} finally {
//					setExcecutionData(co);
//					if (co.navigationPage.isLogoutButtonDislay(3))
//						co.navigationPage.clickOnLogOut();
//				}
//			}
//		} else {
//			throw new RuntimeException("verification failed, due to operation failed");
//		}
//	}

	@Test(dataProvider = "CashOut", dataProviderClass = TestDataImport.class)
	public void cashOutFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "cashOutFromDashboard");
			map.put(MethodName, "cashOut");
			//co.navigationPage.clickOnDashboardCashOut();
			//map = co.cashOutPage.agentCashOut(map);
			setUseCaseVerificationData("cashOutFromDashboard", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

//	@Test
//	public void verifyPerformedCashOutFromDashboardFromUserPassbook() {
//		if (verifyMethodIsAvail(verificationData, "cashOutFromDashboard")) {
//			for (Map<Object, Object> map : verificationData.get("cashOutFromDashboard")) {
//				try {
//					co.datamap.putAll(map);
//					setTestParameters(co.datamap, "verifyPerformedCashOutFromDashboardFromUserPassbook");
//					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
//					setSuccessParameters(co.datamap);
//				} catch (Exception e) {
//					setExceptionData(co, e);
//				} finally {
//					setExcecutionData(co);
//				}
//			}
//		} else {
//			throw new RuntimeException("verification failed, due to operation failed");
//		}
//	}
//
//	@Test
//	public void verifyPerformedCashOutFromDashboardFromToUserPassbook() {
//		if (verifyMethodIsAvail(verificationData, "cashOutFromDashboard")) {
//			for (Map<Object, Object> map : verificationData.get("cashOutFromDashboard")) {
//				try {
//					co.datamap.putAll(map);
//					setTestParameters(co.datamap, "verifyPerformedCashOutFromDashboardFromToUserPassbook");
//					co.common.verifyTransactionInWebPortalForToUser(map, co.dashboardPage);
//					setSuccessParameters(co.datamap);
//				} catch (Exception e) {
//					setExceptionData(co, e);
//				} finally {
//					setExcecutionData(co);
//					if (co.navigationPage.isLogoutButtonDislay(3))
//						co.navigationPage.clickOnLogOut();
//				}
//			}
//		} else {
//			throw new RuntimeException("verification failed, due to operation failed");
//		}
//	}

	@Test(dataProvider = "CashOut", dataProviderClass = TestDataImport.class)
	public void cashOutFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "cashOutFromSideMenu");
			map.put(MethodName, "cashOut");
			co.navigationPage.clickOnSideMenuCashOut();
			//map = co.cashOutPage.agentCashOut(map);
			setUseCaseVerificationData("cashOutFromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

//	@Test
//	public void verifyPerformedCashOutFromSideMenuFromUserPassbook() {
//		if (verifyMethodIsAvail(verificationData, "cashOutFromSideMenu")) {
//			for (Map<Object, Object> map : verificationData.get("cashOutFromSideMenu")) {
//				try {
//					co.datamap.putAll(map);
//					setTestParameters(co.datamap, "verifyPerformedCashOutFromSideMenuFromUserPassbook");
//					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
//					setSuccessParameters(co.datamap);
//				} catch (Exception e) {
//					setExceptionData(co, e);
//				} finally {
//					setExcecutionData(co);
//				}
//			}
//		} else {
//			throw new RuntimeException("verification failed, due to operation failed");
//		}
//	}
//
//	@Test
//	public void verifyPerformedCashOutFromSideMenuFromToUserPassbook() {
//		if (verifyMethodIsAvail(verificationData, "cashOutFromSideMenu")) {
//			for (Map<Object, Object> map : verificationData.get("cashOutFromSideMenu")) {
//				try {
//					co.datamap.putAll(map);
//					setTestParameters(co.datamap, "verifyPerformedCashOutFromSideMenuFromToUserPassbook");
//					co.common.verifyTransactionInWebPortalForToUser(map, co.dashboardPage);
//					setSuccessParameters(co.datamap);
//				} catch (Exception e) {
//					setExceptionData(co, e);
//				} finally {
//					setExcecutionData(co);
//					if (co.navigationPage.isLogoutButtonDislay(3))
//						co.navigationPage.clickOnLogOut();
//				}
//			}
//		} else {
//			throw new RuntimeException("verification failed, due to operation failed");
//		}
//	}
}
