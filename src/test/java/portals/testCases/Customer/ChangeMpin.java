package portals.testCases.Customer;

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
	public void changeMpinCustomer(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeMpinCustomer");
			co.navigationPage.clickOnChangeMpinfromSideMenu();
			co.changeMpinPage.setnewMpin(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}


	@Test(dataProvider = "ChangeMpin", dataProviderClass = TestDataImport.class)
	public void changeMpinFromMyProfileCustomer(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeMpinCustomer");
			co.navigationPage.clickOnMyProfile();
			co.customerMyProfilePage.clickOnChangeMPINFromMyProfile();
			co.changeMpinPage.setnewMpinmyprofile(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
	
	@Test(dataProvider = "ChangeMpin", dataProviderClass = TestDataImport.class)
	public void changeMpinFromLoginCustomer(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(3);
				co.navigationPage.clickOnLogOut();
			}
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeMpinCustomer");
			co.navigationPage.clickOnForgetMpinfromLogin();
			co.changeMpinPage.forgotMpinfromLogin(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
	
	

}
