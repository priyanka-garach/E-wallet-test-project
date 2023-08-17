package portals.testCases.Customer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Utility;
import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class ArbelaStore extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "arbelaStore", dataProviderClass = TestDataImport.class)
	public void arbelaStore(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "arbelaStore");
			map.put(MethodName, "arbelaStore");
			co.navigationPage.clickOnArbelaStore();
			map = co.arbelaStorePage.arbelaStore(map);
			setUseCaseVerificationData("eVoucher", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "arbelaStore", dataProviderClass = TestDataImport.class)
	public void arbelaStoreFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "arbelaStoreFromSideMenu");
			map.put(MethodName, "arbelaStore");
			co.navigationPage.clickOnSideMenuArbelaStore();
			map = co.arbelaStorePage.arbelaStore(map);
			setUseCaseVerificationData("eVoucherFromSideMenu",
					verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
}
