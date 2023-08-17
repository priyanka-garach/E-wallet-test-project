package portals.testCases.Customer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;

public class InviteFriends extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "InviteFriends", dataProviderClass = TestDataImport.class)
	public void InvitFriends(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "changeInviteFriends");
			co.navigationPage.clickOnChangeInviteFriendsfromSideMenu();
			co.inviteFriendsPage.inviteFriend(map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "InviteFriends", dataProviderClass = TestDataImport.class)
	public void InviteFriendsfromDBNotification(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "verify_InviteFriendsfromDBNotification");
			map.put(MethodName, "p2poffnetTranfer");
			co.inviteFriendsPage.inviteFriend_notificationfromDB(map);
			setUseCaseVerificationData("verify_InviteFriendsfromDBNotification", verificationData, map);
			setSuccessParameters(co.datamap);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(3);
				co.navigationPage.clickOnLogOut();
			}

		}
	}
}
