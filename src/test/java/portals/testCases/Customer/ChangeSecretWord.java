package portals.testCases.Customer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class ChangeSecretWord extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "ChangeSecretWord", dataProviderClass = TestDataImport.class)
	public void changeSecretWordCustomer(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(2);
				co.navigationPage.clickOnLogOut();
			}
			co.loginPage.login(map.get(FromUserName).toString(), map.get(FromMpin).toString(), "customer");
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeSecretWordCustomer");
			co.navigationPage.clickOnChangeSecretWordfromSideMenu();
			co.changesecretwordpage.setnewSecretWord(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(2);
				co.navigationPage.clickOnLogOut();
			}
			setExcecutionData(co);
			
		}
	}

	@Test(dataProvider = "ChangeSecretWord", dataProviderClass = TestDataImport.class)	
	public void changeSecretWordCustomerfromLogin(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(2);
				co.navigationPage.clickOnLogOut();
			}
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeSecretWordCustomerfromLogin");
			
			co.navigationPage.clickOnForgotSecretWordfromLogin();
			co.changesecretwordpage.setnewSecretWordFromLogin(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
}
