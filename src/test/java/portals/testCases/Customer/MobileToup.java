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

public class MobileToup extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "MobileTopup", dataProviderClass = TestDataImport.class)
	public void mobileTopup(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "mobileTopup");
			map.put(MethodName, "mobileTopup");
			co.navigationPage.clickOnMobileTopup();
			map = co.mobileTopupPage.mobileTopup(map);
			setUseCaseVerificationData("mobileTopup", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedMobileTopupFromFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "mobileTopup")) {
			for (Map<Object, Object> map : verificationData.get("mobileTopup")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedMobileTopupFromFromUserPassbook");
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

	@Test(dataProvider = "MobileTopup", dataProviderClass = TestDataImport.class)
	public void mobileTopupFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "mobileTopupFromDashboard");
			map.put(MethodName, "mobileTopup");
			co.navigationPage.clickOnDashboardMobileTopup();
			map = co.mobileTopupPage.mobileTopup(map);
			setUseCaseVerificationData("mobileTopupFromDashboard", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedMobileTopupFromDashboardFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "mobileTopupFromDashboard")) {
			for (Map<Object, Object> map : verificationData.get("mobileTopupFromDashboard")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedMobileTopupFromDashboardFromUserPassbook");
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

	@Test(dataProvider = "MobileTopup", dataProviderClass = TestDataImport.class)
	public void mobileTopupFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "mobileTopupFromSideMenu");
			map.put(MethodName, "mobileTopup");
			co.navigationPage.clickOnSideMenuMobileTopup();
			map = co.mobileTopupPage.mobileTopup(map);
			setUseCaseVerificationData("mobileTopupFromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedMobileTopupFromSideMenuFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "mobileTopupFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("mobileTopupFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedMobileTopupFromSideMenuFromUserPassbook");
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
}
