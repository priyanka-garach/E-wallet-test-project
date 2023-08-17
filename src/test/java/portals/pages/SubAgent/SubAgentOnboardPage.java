package portals.pages.SubAgent;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.Common.LoginPageOperations;
import utils.DBUtils;
import utils.elasticUtils.elasticwrite;

public class SubAgentOnboardPage extends SetupInit {
	
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;
	String password, OTP;
	LoginPageOperations loginPageCommon;

	public SubAgentOnboardPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
		loginPageCommon = new LoginPageOperations(this.driver, log);
		
	}

	public Map<Object, Object> SubAgent_Onboard(Map<Object, Object> map) {
		Map<Object, Object> data = new HashMap<Object, Object>();
		try {
			password = DBUtils.getPasswordforSubAgentOnboard(map.get(FromUserName).toString());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		clickOnElement(By.xpath("//*[text()='Sub Agent']"), 0);
		dashboardPageCommon.enterRegisteredMobileNumber(map.get(FromUserName).toString(), 0);
		loginPageCommon.enterPassword(password, 0);
		dashboardPageCommon.clickOnLoginButton(0);
		dashboardPageCommon.clickOnNextButtonUserActivation(0);
		dashboardPageCommon.verifyOTPScreen(0);
		try {
			OTP = DBUtils.getOTPforCustomerOnboard(map.get(FromUserName).toString());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		dashboardPageCommon.enterOTPOnScreen(OTP, 0);
		dashboardPageCommon.clickOnNextButtonUserActivation(0);
		dashboardPageCommon.enterSecretWord(map.get(FromSecretWord).toString(), 0);
		dashboardPageCommon.enterConfirmSecretWord(map.get(FromSecretWord).toString(), 0);
		dashboardPageCommon.clickOnNextButtonUserActivation(0);
		
		dashboardPageCommon.enterNewMpin(map.get(FromMpin).toString(), 0);
		dashboardPageCommon.enterConfirmNewMpin(map.get(FromMpin).toString(), 0);
		dashboardPageCommon.clickOnSubmitButton(0);
		
		dashboardPageCommon.enterNewPassword(map.get(FromPassword).toString(), 0);
		dashboardPageCommon.enterConfirmNewPasswordd(map.get(FromPassword).toString(), 0);
		dashboardPageCommon.clickOnSubmitButton(0);
		
		dashboardPageCommon.verifyActivationSuccessMessage();
		dashboardPageCommon.clickonBacktoLoginBtn();
		
		clickOnElement(By.xpath("//*[text()='Sub Agent']"), 0);
		dashboardPageCommon.enterRegisteredMobileNumber(map.get(FromUserName).toString(), 0);
		loginPageCommon.enterPassword(map.get(FromPassword).toString(), 0);
		dashboardPageCommon.clickOnLoginButton(0);
		setLogSteps(this.log, "Activation sucessfull of new customer onboard : " + map.get(FromUserName).toString());
		
		data.putAll(map);
		data.put(ServiceName, "Subagent Onboard");
		return data;
	}
}
