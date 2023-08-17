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

public class MobilePostpaid extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "MobilePostpaid", dataProviderClass = TestDataImport.class)
	public void mobilePostpaid(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "mobilePostpaid");
			map.put(MethodName, "mobilePostpaid");
			co.navigationPage.clickOnMobilePostpaid();
			map = co.mobilePostpaidPage.mobilePostpaid(map);
			setUseCaseVerificationData("mobilePostpaid", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedMobilePostpaidFromFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "mobilePostpaid")) {
			for (Map<Object, Object> map : verificationData.get("mobilePostpaid")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedMobilePostpaidFromFromUserPassbook");
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

	@Test(dataProvider = "MobilePostpaid", dataProviderClass = TestDataImport.class)
	public void mobilePostpaidFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "mobilePostpaidFromDashboard");
			map.put(MethodName, "mobilePostpaid");
			co.navigationPage.clickOnDashboardMobilePostpaid();
			map = co.mobilePostpaidPage.mobilePostpaid(map);
			setUseCaseVerificationData("mobilePostpaidFromDashboard", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedMobilePostpaidFromDashboardFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "mobilePostpaidFromDashboard")) {
			for (Map<Object, Object> map : verificationData.get("mobilePostpaidFromDashboard")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedMobilePostpaidFromDashboardFromUserPassbook");
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

	@Test(dataProvider = "MobilePostpaid", dataProviderClass = TestDataImport.class)
	public void mobilePostpaidFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "mobilePostpaidFromSideMenu");
			map.put(MethodName, "mobilePostpaid");
			co.navigationPage.clickOnSideMenuMobilePostpaid();
			map = co.mobilePostpaidPage.mobilePostpaid(map);
			setUseCaseVerificationData("mobilePostpaidFromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedMobilePostpaidFromSideMenuFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "mobilePostpaidFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("mobilePostpaidFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedMobilePostpaidFromSideMenuFromUserPassbook");
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
