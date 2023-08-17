package portals.testCases.SubAgent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;
import utils.Utility;

public class SubAgentOnboard extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "SubAgentOnboarding", dataProviderClass = TestDataImport.class)
	public void SubAgentOnboardFromLogin(Map<Object, Object> map) {
		try {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(3);
				co.navigationPage.clickOnLogOut();
			}
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "SubAgentOnboard");
			map.put(MethodName, "SubAgentOnboard");
			map = co.subagentOnboardPage.SubAgent_Onboard(map);
			setUseCaseVerificationData("SubAgentOnboard", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {

			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
	
	
}
