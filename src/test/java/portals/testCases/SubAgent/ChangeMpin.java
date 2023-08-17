package portals.testCases.SubAgent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class ChangeMpin extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "ChangeMpin", dataProviderClass = TestDataImport.class)
	public void changeMpinFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeMpinSubAgent");
			co.navigationPage.clickOnChangeMpinfromSideMenu();
			co.subAgentChangeMpinPage.setnewMpin(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}


	@Test(dataProvider = "ChangeMpin", dataProviderClass = TestDataImport.class)
	public void changeMpinFromMyProfileSubAgent(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeMpinSubAgent");
			co.navigationPage.clickOnMyProfile();
			co.customerMyProfilePage.clickOnChangeMPINFromMyProfile();
			co.subAgentChangeMpinPage.setnewMpin(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
	
	@Test(dataProvider = "ChangeMpin", dataProviderClass = TestDataImport.class)
	public void ResetMpinFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "ResetMpin");
			co.navigationPage.clickOnChangeMpinfromSideMenu();
			co.subAgentChangeMpinPage.setnewMpin(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
	
	

}
