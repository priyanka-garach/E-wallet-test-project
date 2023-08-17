package portals.pages.Customer;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.Customer.ChangeMpinPageOperations;
import utils.DBUtils;
import utils.elasticUtils.elasticwrite;

public class ChangeMpinPage extends SetupInit {
	ChangeMpinPageOperations changeMpinPage;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;
	String OTP;

	public ChangeMpinPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		changeMpinPage = new ChangeMpinPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void setnewMpin(Map<Object, Object> map) {
		changeMpinPage.entercurrentMpin(map.get(FromMpin).toString(), 0);
		changeMpinPage.enternewMpin(map.get(NewMpin).toString(), 0);
		changeMpinPage.enterconfirmMpin(map.get(NewMpin).toString(), 0);
		changeMpinPage.clickOnsubmitButton();	
	}
	
	public void setnewMpinmyprofile(Map<Object, Object> map) {
		changeMpinPage.entercurrentMpin(map.get(FromMpin).toString(), 0);
		changeMpinPage.enternewMpin(map.get(NewMpinfromProfile).toString(), 0);
		changeMpinPage.enterconfirmMpin(map.get(NewMpinfromProfile).toString(), 0);
		changeMpinPage.clickOnsubmitButton();	
	}
	
	
	
	public void forgotMpinfromLogin(Map<Object, Object> map) {
		
		dashboardPageCommon.enterRegisteredMobileNumberForgotMpin(map.get(FromUserName).toString(), null);
		dashboardPageCommon.enterSecretWord(map.get(FromSecretWord).toString(), null);
		changeMpinPage.clickOnsubmitButton();
		changeMpinPage.clickOnsubmitButton();
		try {
			OTP = DBUtils.getOTPforCustomerOnboard(map.get(FromUserName).toString());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		dashboardPageCommon.enterOTPOnScreen(OTP, 0);
		dashboardPageCommon.clickOnSubmitButton();
		changeMpinPage.enternewMpin(map.get(NewMpinfromLogin).toString(), 0);
		changeMpinPage.enterconfirmMpin(map.get(NewMpinfromLogin).toString(), 0);
		changeMpinPage.clickOnsubmitButton();	

		dashboardPageCommon.verifyMPINChangeSuccessMessage();
		dashboardPageCommon.clickonBacktoLoginBtn();
		
	}
	
	
	
}
