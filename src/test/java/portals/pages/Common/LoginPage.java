package portals.pages.Common;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.LoginPageOperations;
import utils.DBUtils;
import utils.elasticUtils.elasticwrite;

public class LoginPage extends SetupInit {
	LoginPageOperations loginPageCommon;
	elasticwrite log;
	public String getotp = null;

	public LoginPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		loginPageCommon = new LoginPageOperations(this.driver, log);
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		loginPageCommon = new LoginPageOperations(this.driver);

	}

	public void login(String userNameVal, String passwordVal, String subUserType) {
		reloadCounter = 0;
		if (subUserType.equalsIgnoreCase("agent"))
			loginPageCommon.selectAgent(0);
		else if (subUserType.equalsIgnoreCase("subagent"))
			loginPageCommon.selectSubAgent(0);
		else if (subUserType.equalsIgnoreCase("super agent"))
			loginPageCommon.selectSuperAgent(0);	
		else if (subUserType.equalsIgnoreCase("retailer"))
			loginPageCommon.selectRetailerAgent(0);
		
		loginPageCommon.enterUserName(userNameVal, 0);
		loginPageCommon.enterPassword(passwordVal, 0);
		loginPageCommon.clickOnLogin(0);
		pauseInSeconds(2);
		try {
			if (loginPageCommon.isOTPScreenPresent()) {
				getotp = DBUtils.getOTP(userNameVal).toString();
				loginPageCommon.enterOTP(getotp, 0);
				loginPageCommon.clickOnSubmit(0);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Instant currentTime = getCurrentTime();
		while (getCurrentURL().contains("login") || getCurrentURL().contains("signin")) {
			pauseInSeconds(1);
			Instant loopingTime = getCurrentTime();
			Duration timeElapsed = Duration.between(currentTime, loopingTime);
			long sec = timeElapsed.toMillis() / 1000;
			int durDiff = (int) sec;
			if (durDiff >= 6000) {
				reloadCounter++;
				if (reloadCounter == 6)
					driver.close();
				if (verifyVisible(loginPageCommon.loginBtn, 5))
					loginPageCommon.clickOnLogin();
			}
		}
	}

	public void loginToPortal(String userNameVal, String passwordVal) {
		if (!projectName.toLowerCase().contains("nasswallet")) {
			if (getCurrentURL().contains("signin")) {
				reloadCounter = 0;
				loginPageCommon.enterUserName(userNameVal, 0);
				loginPageCommon.enterPassword(passwordVal, 0);
				loginPageCommon.clickOnLogin(0);
				Instant currentTime = getCurrentTime();
				while (getCurrentURL().contains("login") || getCurrentURL().contains("signin")) {
					pauseInSeconds(1);
					Instant loopingTime = getCurrentTime();
					Duration timeElapsed = Duration.between(currentTime, loopingTime);
					long sec = timeElapsed.toMillis() / 1000;
					int durDiff = (int) sec;
					if (durDiff >= 6000) {
						reloadCounter++;
						if (reloadCounter == 6)
							driver.close();
						if (verifyVisible(loginPageCommon.loginBtn, 5))
							loginPageCommon.clickOnLogin();
					}
				}
			}
		}
	}

	public void login_With_Invalid(String userNameVal, String passwordVal, String subUserType) {
		reloadCounter = 0;
		if (subUserType.equalsIgnoreCase("agent"))
			loginPageCommon.selectAgent(0);
		else if (subUserType.equalsIgnoreCase("sub agent"))
			loginPageCommon.selectSubAgent(0);
		else if (subUserType.equalsIgnoreCase("super agent"))
			loginPageCommon.selectSuperAgent(0);
		loginPageCommon.enterUserName(userNameVal, 0);
		loginPageCommon.enterPassword(passwordVal, 0);
		loginPageCommon.clickOnLogin(0);
	}

	public void adminLogin(String userName, String password) {
		reloadCounter = 0;
		loginPageCommon.enterUserNameInAdmin(userName, 0);
		loginPageCommon.enterPasswordInAdmin(password, 0);
		loginPageCommon.clickOnLoginInAdmin(0);
		Instant currentTime = getCurrentTime();
		while (getCurrentURL().contains("login")) {
			pauseInSeconds(1);
			Instant loopingTime = getCurrentTime();
			Duration timeElapsed = Duration.between(currentTime, loopingTime);
			long sec = timeElapsed.toMillis() / 1000;
			int durDiff = (int) sec;
			if (durDiff >= 6000) {
				reloadCounter++;
				if (reloadCounter == 6)
					driver.close();
				if (verifyVisible(loginPageCommon.loginBtn, 5))
					loginPageCommon.clickOnLogin();
			}
		}
	}

	public boolean isUserLoggedIn(int... args) {
		return !verifyVisible(loginPageCommon.loginBtn, args);
	}
}
