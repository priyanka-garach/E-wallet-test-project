package portals.testCases.Customer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;
import utils.Utility;

public class P2POffnetTransfer extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}
	@Test(invocationCount = 10, priority = 1)

	@Test(dataProvider = "P2POffnetTransfer", dataProviderClass = TestDataImport.class)
	public void p2pOfffnetTranferFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "P2POffnetFromDashboard");
			map.put(MethodName, "p2poffnetTranfer");
			co.navigationPage.clickOnDashboardP2POffnet();
			map = co.p2pOffnetPage.P2POffnetTransfer(map);
			setUseCaseVerificationData("P2POffnetFromDashboard", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedp2pOffnetTranferFromDashboardFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "P2POffnetFromDashboard")) {
			for (Map<Object, Object> map : verificationData.get("P2POffnetFromDashboard")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedp2pTranferFromDashboardFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					if (co.navigationPage.isLogoutButtonDislay(3)) {
						pauseInSeconds(3);
						co.navigationPage.clickOnLogOut();
					}
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test(dataProvider = "P2POffnetTransfer", dataProviderClass = TestDataImport.class)
	public void verifyPerformedp2pOffnetFromDashboard_NotificationVerication(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "verifyPerformedp2pOffnetFromDashboard_NotificationVerication");
			map.put(MethodName, "p2poffnetTranfer");
			co.p2pOffnetPage.P2pTouser(map);
			setUseCaseVerificationData("verifyPerformedp2pOffnetFromDashboard_NotificationVerication", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(3);
				co.navigationPage.clickOnLogOut();
			}
		}
	}

	@Test(dataProvider = "P2POffnetTransfer", dataProviderClass = TestDataImport.class)
	public void p2pOfffnetFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "p2pOfffnetFromSideMenu");
			map.put(MethodName, "p2pOfffnetFromSideMenu");
			co.navigationPage.clickOnSideP2POffnetTransfer();
			map = co.p2pOffnetPage.P2POffnetTransfer(map);
			setUseCaseVerificationData("p2pOfffnetFromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedp2poffnetTranferFromSideMenuFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "p2pOfffnetFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("p2pOfffnetFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedp2poffnetTranferFromSideMenuFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					if (co.navigationPage.isLogoutButtonDislay(3)) {
						pauseInSeconds(3);
						co.navigationPage.clickOnLogOut();
					}
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test(dataProvider = "P2POffnetTransfer", dataProviderClass = TestDataImport.class)
	public void verifyPerformedp2pOffnetFromSideMenu_NotificationVerication(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "verifyPerformedp2pOffnetFromSideMenu_NotificationVerication");
			map.put(MethodName, "p2pOfffnetFromSideMenu");
			co.p2pOffnetPage.P2pTouser(map);
			setUseCaseVerificationData("verifyPerformedp2pOffnetFromSideMenu_NotificationVerication", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(3);
				co.navigationPage.clickOnLogOut();
			}
		}
	}

	@Test(dataProvider = "P2POffnetTransfer", dataProviderClass = TestDataImport.class)
	public void p2pOffnetTranferfromFooter(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "p2pOffnetTranferfromFooter");
			map.put(MethodName, "p2pOffnetTranferfromFooter");
			co.navigationPage.clickOnP2POffnetTransferfromFooter();
			map = co.p2pOffnetPage.P2POffnetTransfer(map);
			setUseCaseVerificationData("p2pOffnetTranferfromFooter", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedp2pOffnetTranferFromFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "p2pOffnetTranferfromFooter")) {
			for (Map<Object, Object> map : verificationData.get("p2pOffnetTranferfromFooter")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedp2pOffnetTranferFromFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					if (co.navigationPage.isLogoutButtonDislay(3)) {
						pauseInSeconds(3);
						co.navigationPage.clickOnLogOut();
					}
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}
	
	@Test(dataProvider = "P2POffnetTransfer", dataProviderClass = TestDataImport.class)
	public void verifyPerformedp2pOffnetFromFooter_NotificationVerication(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "verifyPerformedp2pOffnetFromFooter_NotificationVerication");
			map.put(MethodName, "p2pOffnetTranferfromFooter");
			co.p2pOffnetPage.P2pTouser(map);
			setUseCaseVerificationData("verifyPerformedp2pOffnetFromFooter_NotificationVerication", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(3);
				co.navigationPage.clickOnLogOut();
			}
		}
	}

}
