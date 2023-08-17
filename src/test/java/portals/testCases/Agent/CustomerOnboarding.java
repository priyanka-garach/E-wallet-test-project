package portals.testCases.Agent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class CustomerOnboarding extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "CustomerOnboarding", dataProviderClass = TestDataImport.class)
	public void customerOnboarding(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "customerOnboarding");
			co.navigationPage.clickOnCustomerOnboarding();
//			co.customerOnboardingPage.customerOnboarding(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "CustomerOnboarding", dataProviderClass = TestDataImport.class)
	public void customerOnboardingFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "customerOnboardingFromDashboard");
			co.navigationPage.clickOnDashboardCustomerOnboarding();
//			co.customerOnboardingPage.customerOnboarding(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "CustomerOnboarding", dataProviderClass = TestDataImport.class)
	public void customerOnboardingFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "customerOnboardingFromSideMenu");
			co.navigationPage.clickOnSideMenuCustomerOnboarding();
//			co.customerOnboardingPage.customerOnboarding(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
}
