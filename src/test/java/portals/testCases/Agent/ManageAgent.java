package portals.testCases.Agent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class ManageAgent extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "ManageAgent", dataProviderClass = TestDataImport.class)
	public void manageAgent(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "manageAgent");
			co.navigationPage.clickOnManageAgent();
			co.manageAgentPage.manageAgent(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "ManageAgent", dataProviderClass = TestDataImport.class)
	public void manageAgentFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "manageAgentFromDashboard");
			co.navigationPage.clickOnDashboardManageAgent();
			co.manageAgentPage.manageAgent(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "ManageAgent", dataProviderClass = TestDataImport.class)
	public void manageAgentFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "manageAgentFromSideMenu");
			co.navigationPage.clickOnSideMenuManageAgent();
			co.manageAgentPage.manageAgent(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
}
