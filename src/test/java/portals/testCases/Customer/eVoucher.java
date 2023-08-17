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

public class eVoucher extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "eVoucher", dataProviderClass = TestDataImport.class)
	public void eVoucher(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "eVoucher");
			map.put(MethodName, "eVoucher");
			co.navigationPage.clickOneVoucher();
			map = co.eVoucherPage.eVoucher(map);
			setUseCaseVerificationData("eVoucher", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "eVoucher", dataProviderClass = TestDataImport.class)
	public void eVoucherFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "eVoucherFromSideMenu");
			map.put(MethodName, "eVoucher");
			co.navigationPage.clickOnSideMenueVoucher();
			map = co.eVoucherPage.eVoucher(map);
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
