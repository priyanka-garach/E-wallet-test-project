package portals.pages.Customer;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.Customer.CustomerOnboardingPageOperations;
import utils.DBUtils;
import utils.elasticUtils.elasticwrite;

public class CustomerOnboardPage extends SetupInit {
	CustomerOnboardingPageOperations customerOnboardingPageOperations;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;
	String mpin, OTP;

	public CustomerOnboardPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		customerOnboardingPageOperations = new CustomerOnboardingPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public Map<Object, Object> CustomerOnboard(Map<Object, Object> map) {
		Map<Object, Object> data = new HashMap<Object, Object>();
		try {
			mpin = DBUtils.getMpinforCustomerOnboard(map.get(FromUserName).toString());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		dashboardPageCommon.enterRegisteredMobileNumber(map.get(FromUserName).toString(), 0);
		dashboardPageCommon.enterMPINInLogin(mpin, 0);
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
		
		dashboardPageCommon.verifyActivationSuccessMessage();
		dashboardPageCommon.clickonBacktoLoginBtn();
		
		dashboardPageCommon.enterRegisteredMobileNumber(map.get(FromUserName).toString(), 0);
		dashboardPageCommon.enterMPINInLogin(map.get(FromMpin).toString(), 0);
		dashboardPageCommon.clickOnLoginButton(0);
		setLogSteps(this.log, "Activation sucessfull of new customer onboard : " + map.get(FromUserName).toString());
		
		data.putAll(map);
		data.put(ServiceName, "Customer Onboard");
		return data;
	}
}
