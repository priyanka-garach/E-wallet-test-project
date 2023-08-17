package portals.testCases.Agent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class AgentOnboarding extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "AgentOnboarding", dataProviderClass = TestDataImport.class)
	public void agentOnboarding(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "agentOnboarding");
			co.navigationPage.clickOnAgentOnboarding();
			co.agentOnboardingPage.agentOnboarding(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "AgentOnboarding", dataProviderClass = TestDataImport.class)
	public void agentOnboardingFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "agentOnboardingFromDashboard");
			co.navigationPage.clickOnDashboardAgentOnboarding();
			co.agentOnboardingPage.agentOnboarding(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "AgentOnboarding", dataProviderClass = TestDataImport.class)
	public void agentOnboardingFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "agentOnboardingFromSideMenu");
			co.navigationPage.clickOnSideMenuAgentOnboarding();
			co.agentOnboardingPage.agentOnboarding(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
}
