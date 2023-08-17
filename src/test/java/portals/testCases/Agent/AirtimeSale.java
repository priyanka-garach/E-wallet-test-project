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

public class AirtimeSale extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "AirtimeSale", dataProviderClass = TestDataImport.class)
	public void airtimeSale(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "airtimeSale");
			map.put(MethodName, "airtimeSale");
			co.navigationPage.clickOnAirtimeSale();
			map = co.airtimeSalePage.airtimeSale(map);
			setUseCaseVerificationData("airtimeSale", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedAirtimeSaleFromFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "airtimeSale")) {
			for (Map<Object, Object> map : verificationData.get("airtimeSale")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedAirtimeSaleFromFromUserPassbook");
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

	@Test(dataProvider = "AirtimeSale", dataProviderClass = TestDataImport.class)
	public void airtimeSaleFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "airtimeSaleFromDashboard");
			map.put(MethodName, "airtimeSale");
			co.navigationPage.clickOnDashboardAirtimeSale();
			map = co.airtimeSalePage.airtimeSale(map);
			setUseCaseVerificationData("airtimeSaleFromDashboard", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedAirtimeSaleFromDashboardFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "airtimeSaleFromDashboard")) {
			for (Map<Object, Object> map : verificationData.get("airtimeSaleFromDashboard")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedAirtimeSaleFromDashboardFromUserPassbook");
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

	@Test(dataProvider = "AirtimeSale", dataProviderClass = TestDataImport.class)
	public void airtimeSaleFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "airtimeSaleFromSideMenu");
			map.put(MethodName, "airtimeSale");
			co.navigationPage.clickOnSideMenuAirtimeSale();
			map = co.airtimeSalePage.airtimeSale(map);
			setUseCaseVerificationData("airtimeSaleFromSideMenu", verificationData, map);
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
		if (verifyMethodIsAvail(verificationData, "airtimeSaleFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("airtimeSaleFromSideMenu")) {
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
