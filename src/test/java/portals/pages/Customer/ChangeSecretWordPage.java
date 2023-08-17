package portals.pages.Customer;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.Customer.ChangeSecretWordPageOperations;
import utils.DBUtils;
import utils.elasticUtils.elasticwrite;

public class ChangeSecretWordPage extends SetupInit {
	ChangeSecretWordPageOperations changeSecretWordPage;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public ChangeSecretWordPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		changeSecretWordPage = new ChangeSecretWordPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
		
	}

	public void setnewSecretWord(Map<Object, Object> map) {
		
		changeSecretWordPage.entersecretWord(map.get(FromSecretWord).toString(), 0);
		changeSecretWordPage.clickOnsubmitButton();
		changeSecretWordPage.enternewSecretWord(map.get(NewSecretWord).toString(), 0);
		changeSecretWordPage.enterconfirmSecretWord(map.get(NewSecretWord).toString(), 0);
		changeSecretWordPage.clickOnsubmitButton();	
	}
	
	public void setnewSecretWordFromLogin(Map<Object, Object> map) {
		
		dashboardPageCommon.enterRegisteredMobileNumberForgotMpin(map.get(FromUserName).toString(), null);
		changeSecretWordPage.clickOnsubmitButton();	
		String OTP = "";
		try {
			OTP = DBUtils.getOTPforCustomerOnboard(map.get(FromUserName).toString());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		dashboardPageCommon.otpPIN(OTP, 0);
		dashboardPageCommon.enterSecretWord(map.get(NewSecretWordfromLogin).toString(), null);
		changeSecretWordPage.enterconfirmSecretWord(map.get(NewSecretWordfromLogin).toString(), 0);
		changeSecretWordPage.clickOnsubmitButton();	
		dashboardPageCommon.verifySWChangeSuccessMessage();
		dashboardPageCommon.clickonBacktoLoginBtn(); 
		
	}
}
