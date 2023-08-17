package portals.testCases.SubAgent;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class MyProfile extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "verifyProfileDetails", dataProviderClass = TestDataImport.class)
	public void verifyProfileDetailsFromDashboard(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				co.navigationPage.clickOnLogOut();
			}
			co.datamap.putAll(map);
			co.loginPage.login(map.get(FromUserName).toString(), map.get(FromPassword).toString(),
					map.get(FromUserType).toString());
			setTestParameters(co.datamap, "verifyProfileDetailsFromDashboard");
			co.navigationPage.clickOnProfileIconSubAgent();
			co.subAgentMyProfilePage.subAgentVerifyProfileDetailsPersonal(map);
			co.subAgentMyProfilePage.subAgentVerifyProfileDetailsDocument(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "verifyProfileDetails", dataProviderClass = TestDataImport.class)
	public void verifyProfileDetailsFromSideMenuProfileViewProfile(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				co.navigationPage.clickOnLogOut();
			}
			co.datamap.putAll(map);
			co.loginPage.login(map.get(FromUserName).toString(), map.get(FromPassword).toString(),
					map.get(FromUserType).toString());
			setTestParameters(co.datamap, "verifyProfileDetailsFromSideMenuProfileViewProfile");
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			co.subAgentMyProfilePage.subAgentVerifyProfileDetailsPersonal(map);
			co.subAgentMyProfilePage.subAgentVerifyProfileDetailsDocument(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
}