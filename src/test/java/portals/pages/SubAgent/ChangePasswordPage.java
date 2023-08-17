package portals.pages.SubAgent;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.SubAgent.ChangePasswordPageOperations;
import utils.DBUtils;
import utils.elasticUtils.elasticwrite;

public class ChangePasswordPage extends SetupInit {
	ChangePasswordPageOperations changePasswordPage;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public ChangePasswordPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		changePasswordPage = new ChangePasswordPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void setnewPassword(Map<Object, Object> map) {
		changePasswordPage.enterOldPassword(map.get(FromPassword).toString(), 0);
		changePasswordPage.enternewPassword(map.get(NewPassword).toString(), 0);
		changePasswordPage.enterconfirmPassword(map.get(NewPassword).toString(), 0);
		changePasswordPage.clickOnsubmitButton();	
	}
	
	public void forgotPasswordfromLogin(Map<Object, Object> map) {
		String OTP = "";
		dashboardPageCommon.enterRegisteredMobileNumberForgotMpin(map.get(FromUserName).toString(), null);
		dashboardPageCommon.enterSecretWord(map.get(FromSecretWord).toString(), null);
		changePasswordPage.clickOnsubmitButton();	
		changePasswordPage.clickOnsubmitButton();	
		
		try {
			OTP = DBUtils.getOTPforCustomerOnboard(map.get(FromUserName).toString());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		dashboardPageCommon.enterOTPOnScreen(OTP, 0);
		dashboardPageCommon.clickOnSubmitButton();
		
		dashboardPageCommon.enterNewPassword(map.get(NewPasswordfromLogin).toString(), 0);
		dashboardPageCommon.enterConfirmNewPassword(map.get(NewPasswordfromLogin).toString(), 0);
	
		changePasswordPage.clickOnsubmitButton();	
		dashboardPageCommon.verifyPasswordChangeSuccessMessage();
		dashboardPageCommon.clickonBacktoLoginBtn();
		
	}
}
