package portals.testCases.Agent;

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
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "verifyProfileDetailsFromDashboard");
			co.navigationPage.clickOnDashboardAboutUs();
			co.agentProfilePage.superAgentVerifyProfileDetails(map);
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
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "verifyProfileDetailsFromSideMenuProfileViewProfile");
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			co.agentProfilePage.superAgentVerifyProfileDetails(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "Profile_Edit", dataProviderClass = TestDataImport.class)
	public void profileEditFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "profileEditFromDashboard");
			co.navigationPage.clickOnDashboardAboutUs();
			if (!co.agentProfilePage.superAgentEditProfile(map)) {
				throw new RuntimeException("Profile Edit Failed");
			}
			// co.dashboardPage.verifyProfileDetails(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "Profile_Edit", dataProviderClass = TestDataImport.class)
	public void profileEditFromSideMenuProfileViewProfile(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "profileEditFromSideMenuProfileViewProfile");
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			if (!co.agentProfilePage.superAgentEditProfile(map)) {
				throw new RuntimeException("Profile Edit Failed");
			}
			// co.dashboardPage.verifyProfileDetails(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "VerifyProfileDetails", dataProviderClass = TestDataImport.class)
	public void verifyAgentProfileDetailsFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "verifyAgentProfileDetailsFromDashboard");
			co.navigationPage.clickOnDashboardAboutUs();
			co.agentProfilePage.agentVerifyProfileDetails(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "verifyProfileDetails", dataProviderClass = TestDataImport.class)
	public void verifyAgentProfileDetailsFromSideMenuProfileViewProfile(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "verifyAgentProfileDetailsFromSideMenuProfileViewProfile");
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			co.agentProfilePage.agentVerifyProfileDetails(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "Profile_Edit", dataProviderClass = TestDataImport.class)
	public void agentProfileEditFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "agentProfileEditFromDashboard");
			co.navigationPage.clickOnDashboardAboutUs();
			if (!co.agentProfilePage.agentEditProfile(map)) {
				throw new RuntimeException("Profile Edit Failed");
			}
			// co.dashboardPage.verifyProfileDetails(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "Profile_Edit", dataProviderClass = TestDataImport.class)
	public void agentProfileEditFromSideMenuProfileViewProfile(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "agentProfileEditFromSideMenuProfileViewProfile");
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			if (!co.agentProfilePage.agentEditProfile(map)) {
				throw new RuntimeException("Profile Edit Failed");
			}
			// co.dashboardPage.verifyProfileDetails(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
}
