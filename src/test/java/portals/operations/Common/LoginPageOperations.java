package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class LoginPageOperations extends SetupInit {
	By unmTextBox = By.id("frm_text_usernameid");
	By pwdTextBox = By.xpath("//*[contains(@id,'frm_text_password')]");
	public By loginBtn = By.xpath("//button[text()='Login']");
	public By submitbtn = By.xpath("//button[@name='submit']");
	By txtAdminUser = By.id("inputLoginUsername");
	By txtAdminPwd = By.id("inputLoginPd");
	public By btnAdminLogin = By.id("btnLoginLogin");
	By agent = By.xpath("//*[text()='Agent']");
	By subagent = By.xpath("//*[text()='Sub Agent']");
	By branch = By.xpath("//*[text()='Branch']");
	By merchant = By.xpath("//*[text()='Merchant']");
	By superAgent = By.xpath("//*[text()='Super Agent']");
	By teller = By.xpath("//*[text()='Teller']");
	By otpbox1 = By.xpath("//input[1]");
	By otpbox2 = By.xpath("//input[2]");
	By otpbox3 = By.xpath("//input[3]");
	By otpbox4 = By.xpath("//input[4]");
	By otpbox5 = By.xpath("//input[5]");
	By otpbox6 = By.xpath("//input[6]");
	By OTPlabel = By.xpath("//*[normalize-space(text())='Enter OTP']");
	elasticwrite log;

	public LoginPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public LoginPageOperations(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName(String userName, int... args) {
		try {
			sendKeys(unmTextBox, userName, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "user name");
		}
		if (log != null)
			setLogSteps(log, "Enter user name: " + userName);
	}

	public void enterPassword(String password, int... args) {
		try {
			sendKeys(pwdTextBox, password, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "password");
		}
		if (log != null)
			setLogSteps(log, "Enter password: " + password);
	}

	public void clickOnLogin(int... args) {
		try {
			clickOnElement(loginBtn, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "login");
		}
		if (log != null)
			setLogSteps(log, "Click on Login button");
	}

	public boolean isOTPScreenPresent(int... args) {
		try {
			return isVisible(OTPlabel, 5);
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSubmit(int... args) {
		try {
			clickOnElement(submitbtn, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "submit");
		}
		if (log != null)
			setLogSteps(log, "Click on Submit button");
	}

	public void enterOTP(String getotp, int... args) {

		try {
			char get1 = getotp.charAt(0);
			char get2 = getotp.charAt(1);
			char get3 = getotp.charAt(2);
			char get4 = getotp.charAt(3);
			char get5 = getotp.charAt(4);
			char get6 = getotp.charAt(5);

			String send1 = String.valueOf(get1);
			sendKeys(otpbox1, send1, 0);
			String send2 = String.valueOf(get2);
			sendKeys(otpbox2, send2, 0);
			String send3 = String.valueOf(get3);
			sendKeys(otpbox3, send3, 0);
			String send4 = String.valueOf(get4);
			sendKeys(otpbox4, send4, 0);
			String send5 = String.valueOf(get5);
			sendKeys(otpbox5, send5, 0);
			String send6 = String.valueOf(get6);
			sendKeys(otpbox6, send6, 0);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "OTP Error");
		}
		if (log != null)
			setLogSteps(log, "Enter OTP: " + getotp);
	}

	public void enterUserNameInAdmin(String userName, int... args) {
		try {
			sendKeys(txtAdminUser, userName, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "user name");
		}
		if (log != null)
			setLogSteps(log, "Enter user name: " + userName);
	}

	public void enterPasswordInAdmin(String password, int... args) {
		try {
			sendKeys(txtAdminPwd, password, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "password");
		}
		if (log != null)
			setLogSteps(log, "Enter password: " + password);
	}

	public void clickOnLoginInAdmin(int... args) {
		try {
			clickOnElement(btnAdminLogin, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "login");
		}
		if (log != null)
			setLogSteps(log, "Click on Login button");
	}

	public void selectAgent(int... args) {
		try {
			clickOnElement(agent, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "agent");
		}
		if (log != null)
			setLogSteps(log, "Click on Agent");
	}

	public void selectSubAgent(int... args) {
		try {
			clickOnElement(subagent, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Subagent");
		}
		if (log != null)
			setLogSteps(log, "Click on Sub Agent");
	}

	public void selectSuperAgent(int... args) {
		try {
			clickOnElement(superAgent, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "super agent");
		}
		if (log != null)
			setLogSteps(log, "Click on Super Agent");
	}
	
	public void selectRetailerAgent(int... args) {
		try {
			clickOnElement(By.xpath("//*[text()='Retailer']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Retailer");
		}
		if (log != null)
			setLogSteps(log, "Click on Retailer");
	}
	
	

	public void selectBranch(int... args) {
		try {
			clickOnElement(branch, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "branch");
		}
		if (log != null)
			setLogSteps(log, "Click on Branch");
	}

	public void selectTeller(int... args) {
		try {
			clickOnElement(teller, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "teller");
		}
		if (log != null)
			setLogSteps(log, "Click on Teller");
	}

	public void selectMerchant(int... args) {
		try {
			clickOnElement(merchant, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "merchant");
		}
		if (log != null)
			setLogSteps(log, "Click on Merchant");
	}

}
