package portals.testCases.Agent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class UpdateCustomerKYC extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "UpdateCustomerKYC", dataProviderClass = TestDataImport.class)
	public void updateCustomerKYC(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "updateCustomerKYC");
			map.put(MethodName, "updateCustomerKYC");
			co.navigationPage.clickOnUpdateCustomerKYC();
			map = co.updateCustomerKYCPage.updateCustomerKYC(map);
			setUseCaseVerificationData("updateCustomerKYC", verificationData, map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "UpdateCustomerKYC", dataProviderClass = TestDataImport.class)
	public void updateCustomerKYCFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "updateCustomerKYCFromSideMenu");
			map.put(MethodName, "UpdateCustomerKYC");
			co.navigationPage.clickOnSideMenuUpdateCustomerKYC();
			map = co.updateCustomerKYCPage.updateCustomerKYC(map);
			setUseCaseVerificationData("updateCustomerKYCFromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "UpdateCustomerKYC", dataProviderClass = TestDataImport.class)
	public void updateCustomerKYCFromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "updateCustomerKYCFromDashboard");
			map.put(MethodName, "UpdateCustomerKYC");
			co.navigationPage.clickOnDashboardUpdateCustomerKYC();
			map = co.updateCustomerKYCPage.updateCustomerKYC(map);
			setUseCaseVerificationData("updateCustomerKYCFromDashboard", verificationData, map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
}
