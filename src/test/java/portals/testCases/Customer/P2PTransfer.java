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

public class P2PTransfer extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "P2PTransfer", dataProviderClass = TestDataImport.class)
	public void p2pTranferFromDashboard(Map<Object, Object> map) {
		try {
			co.common.webPortalLogin(map, "from", 0);
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "p2pTranferFromDashboard");
			map.put(MethodName, "p2pTranferFromDashboard");
			co.navigationPage.clickOnDashboardP2PTransfer();
			map = co.p2pTransferPage.P2PTransfer(map);
			setUseCaseVerificationData("p2pTranferFromDashboard", verificationData, map);
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

	@Test
	public void verifyPerformedp2pTranferFromDashboardFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "p2pTranferFromDashboard")) {
			ArrayList<Map<Object, Object>> temp = verificationData.get("p2pTranferFromDashboard");
			for (Map<Object, Object> map : temp) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedp2pTranferFromDashboardFromUserPassbook");
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
	public void verifyPerformedp2pTranferFromDashboardFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "p2pTranferFromDashboard")) {
			for (Map<Object, Object> map : verificationData.get("p2pTranferFromDashboard")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedp2pTranferFromDashboardFromToUserPassbook");
					co.common.verifyTransactionInWebPortalForToUserTangereine(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					pauseInSeconds(3);
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test(dataProvider = "P2PTransfer", dataProviderClass = TestDataImport.class)
	public void p2pTranferFromSideMenu(Map<Object, Object> map) {
		try {
			
			co.datamap.putAll(map);
			co.common.webPortalLogin(map, "from", 0);
			setTestParameters(co.datamap, "p2pTranferFromSideMenu");
			map.put(MethodName, "p2pTranferFromSideMenu");
			co.navigationPage.clickOnSideP2PTransfer();
			map = co.p2pTransferPage.P2PTransfer(map);
			setUseCaseVerificationData("p2pTranferFromSideMenu", verificationData, map);
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

	@Test
	public void verifyPerformedp2pTranferFromSideMenuFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "p2pTranferFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("p2pTranferFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedp2pTranferFromSideMenuFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUserTangereine(map, co.dashboardPage);
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

	@Test
	public void verifyPerformedp2pTranferFromSideMenuFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "p2pTranferFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("p2pTranferFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedp2pTranferFromSideMenuFromToUserPassbook");
					co.common.verifyTransactionInWebPortalForToUserTangereine(map, co.dashboardPage);
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

	@Test(dataProvider = "P2PTransfer", dataProviderClass = TestDataImport.class)
	public void p2pTranferfromFooter(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "p2pTranferfromFooter");
			map.put(MethodName, "p2pTranferfromFooter");
			co.navigationPage.clickOnP2PTransferfromFooter();
			map = co.p2pTransferPage.P2PTransfer(map);
			setUseCaseVerificationData("p2pTranfer", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedp2pTranferFromFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "p2pTranferfromFooter")) {
			for (Map<Object, Object> map : verificationData.get("p2pTranferfromFooter")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedp2pTranferFromFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUserTangereine(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					if (co.navigationPage.isLogoutButtonDislay(3))
						co.navigationPage.clickOnLogOut();
					pauseInSeconds(3);
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test
	public void verifyPerformedp2pTranferFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "p2pTranferfromFooter")) {
			for (Map<Object, Object> map : verificationData.get("p2pTranferfromFooter")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedp2pTranferToUserPassbook");
					co.common.verifyTransactionInWebPortalForToUserTangereine(map, co.dashboardPage);
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

	@Test(dataProvider = "P2PTransfer", dataProviderClass = TestDataImport.class)
	public void p2pTranferFromSend(Map<Object, Object> map) {
		try {
			pauseInSeconds(5);
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "p2pTranferFromSend");
			map.put(MethodName, "p2pTranfer");
			co.navigationPage.clickOnSend();
			map = co.p2pTransferPage.P2PTransfer(map);
			setUseCaseVerificationData("p2pTranferFromSend", verificationData, map);
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

	@Test
	public void verifyPerformedp2pTranferFromSendFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "p2pTranferFromSend")) {
			for (Map<Object, Object> map : verificationData.get("p2pTranferFromSend")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedp2pTranferFromSendFromUserPassbook");
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
	public void verifyPerformedp2pTranferFromSendFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "p2pTranferFromSend")) {
			for (Map<Object, Object> map : verificationData.get("p2pTranferFromSend")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedp2pTranferFromSideMenuFromToUserPassbook");
					co.common.verifyTransactionInWebPortalForToUserTangereine(map, co.dashboardPage);
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
	
	public void waitForMin() {
		pauseInSeconds(10);
	}
}
