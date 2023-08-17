package portals.testCases.SubAgent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;
import utils.DBUtils;

public class ChangePassword extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "ChangePassword", dataProviderClass = TestDataImport.class)
	public void changePasswordFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changePasswordFromSideMenu");
			co.navigationPage.clickOnSideMenuSettings();
			co.navigationPage.clickOnChangePassword();
			co.changePasswordPage.setnewPassword(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}


	@Test(dataProvider = "ChangePassword", dataProviderClass = TestDataImport.class)
	public void changePasswordFromMyProfileSubAgent(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changePasswordFromMyProfileSubAgent");
			co.navigationPage.clickOnMyProfile();
			co.customerMyProfilePage.clickOnChangePasswordFromMyProfile();
			co.changePasswordPage.setnewPassword(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
	
	@Test(dataProvider = "ChangePassword", dataProviderClass = TestDataImport.class)	
	public void changePasswordSubAgentfromLogin(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(2);
				co.navigationPage.clickOnLogOut();
			}
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeSecretWordSubAgentfromLogin");
			clickOnElement(By.xpath("//*[text()='Sub Agent']"), 0);
			co.navigationPage.clickOnForgotPasswordfromLogin();
			co.changePasswordPage.forgotPasswordfromLogin(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}


}
