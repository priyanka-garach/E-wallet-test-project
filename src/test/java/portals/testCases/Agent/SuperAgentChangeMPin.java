package portals.testCases.Agent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class SuperAgentChangeMPin extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "SuperAgent_ChangeMpin", dataProviderClass = TestDataImport.class)
	public void verifyinvalidSuperAgent_ChangeMpinfromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeMpinCustomer");
			co.navigationPage.clickOnChangeMpinfromSideMenuForWrongMPIN();
			co.superagentChangeMpinPage.setnewMpin(map);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
		}
	}

	@Test(dataProvider = "SuperAgent_ChangeMpin", dataProviderClass = TestDataImport.class)
	public void SuperAgent_ChangeMpinfromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeMpinCustomer");
			co.navigationPage.clickOnChangeMpinfromSideMenu();
			// co.superagentChangeMpinPage.setnewMpin(map);
//			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
		}
	}

	@Test
	public void verifyFAQfromSideMenu() {
		try {
			co.navigationPage.clickOnSideMenu();
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenuProfileFAQs();
			co.navigationPage.clickOnSideMenuProfileverifyFAQs(10);
		} catch (Exception e) {
		} finally {
		}
	}

}
