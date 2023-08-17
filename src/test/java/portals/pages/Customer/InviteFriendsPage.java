package portals.pages.Customer;

import java.sql.SQLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.Customer.InviteFriendsPageOperations;
import utils.DBUtils;
import utils.elasticUtils.elasticwrite;

public class InviteFriendsPage extends SetupInit {
	InviteFriendsPageOperations invitefriendsPage;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public InviteFriendsPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		invitefriendsPage = new InviteFriendsPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void inviteFriend(Map<Object, Object> map) {
		invitefriendsPage.enterMobieNumber(map.get(MobileNumber).toString(), 0);
		invitefriendsPage.enterMpin(map.get(FromMpin).toString(), 0);
		invitefriendsPage.clickOnsubmitButton();	
	}
	
	public void inviteFriend_notificationfromDB(Map<Object, Object> map) {	
		try {
			String message = DBUtils.getMessageforInviteFriends(map.get(FromUserName).toString());
			if(message.contains(map.get(MobileNumber).toString())) {
				setLogSteps(this.log, "Successfully verified Invite Friends notification in Database for Mobile Number: " + map.get(MobileNumber).toString());
			}
		} catch (SQLException e) {
			setLogSteps(this.log, "Unable to do verification for ToUser in DB");
		}
	}
	
	
}
