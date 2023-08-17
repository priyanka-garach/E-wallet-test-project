package portals.testCases.Common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class CommonTestCasesCustomer extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}
	
	
	@Test
	public void CheckBalanceFromMyProfile() {
		try {
			setTestParameters(co.datamap, "Check Balance from My Profile");
			co.navigationPage.clickOnMyProfile();
			co.customerMyProfilePage.checkBalancefromMyProfile();
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
	
	@Test(dataProvider = "verifyProfileDetails", dataProviderClass = TestDataImport.class)
	public void CheckPersonalInfoFromMyProfile(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				co.navigationPage.clickOnLogOut();
			pauseInSeconds(3);
			}
			co.loginPage.login(map.get(FromUserName).toString(), map.get(FromPassword).toString(),  map.get(FromUserType).toString());
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "Check Balance from My Profile");
			co.navigationPage.clickOnMyProfile();
			co.customerMyProfilePage.verifyPersonalInfoDetails(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
	
	@Test(dataProvider = "verifyProfileDetails", dataProviderClass = TestDataImport.class)
	public void CheckPersonalInfoFromMyProfileFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "Personal info From My Profile SideMenu");
			co.navigationPage.clickOnSideMenuProfileMyProfile();
			co.customerMyProfilePage.verifyPersonalInfoDetails(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
	
	@Test(dataProvider = "verifyProfileDetails", dataProviderClass = TestDataImport.class)
	public void CheckDocumentInfoFromMyProfile(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "Check Document info From My Profile");
			co.navigationPage.clickOnMyProfile();
			co.customerMyProfilePage.verifyDocInfoDetails(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
	
	@Test(dataProvider = "verifyProfileDetails", dataProviderClass = TestDataImport.class)
	public void CheckDocumentInfoFromMyProfileFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "Document info From My Profile SideMenu");
			co.navigationPage.clickOnSideMenuProfileMyProfile();
			co.customerMyProfilePage.verifyDocInfoDetails(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
}
