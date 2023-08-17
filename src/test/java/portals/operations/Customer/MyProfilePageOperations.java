package portals.operations.Customer;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.MyProfileOperations;
import utils.elasticUtils.elasticwrite;

public class MyProfilePageOperations extends SetupInit {
	public String VerifyfullnameEnglish = "//*[text()='Full Name in English']//following-sibling::p[text()='%s']";
	public String VerifyGender = "//*[text()='Gender']//following-sibling::p[text()='%s']";
	public String VerifyPhone = "//*[text()='Phone']//following-sibling::p[text()='%s']";
	public String VerifyEmailID = "//*[text()='Email ID']//following-sibling::p[text()='%s']";
	public String VerifyOccupation = "//*[text()='Occupation']//following-sibling::p[text()='%s']";
	public String VerifyOwnershipStatus = "//*[text()='Ownership status']//following-sibling::p[text()='%s']";
	public String VerifyStreetAddress = "//*[text()='Street Address']//following-sibling::p[text()='%s']";
	public String VerifyAreaorVilllageOrDistict = "//*[text()='Area/Village/District']//following-sibling::p[text()='%s']";
	public String VerifyCity = "//*[text()='City']//following-sibling::p[text()='%s']";
	public String VerifyBranchDetail = "//*[text()='Branch details']//following-sibling::p[text()='%s']";
	public String VerifyBankAccountNumber = "//*[text()='Bank Account Number']//following-sibling::p[text()='%s']";
	public String VerifyBankAccountHolderName = "//*[text()='Bank Account holder Name']//following-sibling::p[text()='%s']";
	public String VerifySwiftCode = "//*[text()='Swift Code']//following-sibling::p[text()='%s']";
	public String VerifyEntityName = "//*[text()='Entity Name']//following-sibling::p[text()='%s']";
	public String VerifyNasswalletAccountOpenDate = "//*[text()='Date opened NassWallet account']//following-sibling::p[text()='%s']";
	public String VerifyNationality = "//*[text()='Nationality']//following-sibling::p[text()='%s']";
	public String VerifyProofOfIdentityIraqi = "//*[text()='Proof of Identity (Iraqi National)']//following::p[text()='%s']";
	public String VerifyNationalID = "//*[text()='National ID']//following::p[text()='%s']";
	public String VerifyCivilID = "//*[text()='Civil ID']//following::p[text()='%s']";
	public String VerifyProofOfAddressIraqi = "//*[text()='Proof of Address (Iraqi National)']//following::p[text()='%s']";
	public String VerifyInformationCard = "//*[text()='Information Card']//following::p[text()='%s']";
	public String VerifySupplyCard = "//*[text()='Supply Card']//following::p[text()='%s']";
	public String VerifyProofOfIdentityNonIraqi = "//*[text()='Proof of Identity (Iraqi National)']//following::p[text()='%s']";
	public String VerifyPassport = "//*[text()='Passport']//following-sibling::p[text()='%s']";
	public String VerifyProofOfAddressNonIraqi = "//*[text()='Proof of Residency (Non Iraqi)']//following-sibling::p[text()='%s']";
	public String VerifyEntryStemp = "//*[text()='Entry Stamp']//following-sibling::p[text()='%s']";
	public String VerifyResidencyCard = "//*[text()='Residency Card']//following-sibling::p[text()='%s']";
	public String verifyHaveBankAccount = "//*[text()='Have Bank Account']//following-sibling::p[text()='%s']";
	public String verifyBusinessRegistationNumber = "//*[text()='Business Registration Number']//following-sibling::p[text()='%s']";
	By txtEmail = By.id("frm_text_EMAIL_IDid");
	By drpOccupation = By.id("frm_select_OCCUPATIONid");
	By txtStreetAddress = By.id("frm_text_STREET_ADDRESSid");
	By drpCity = By.id("frm_select_CITYid");
	public String drpRequestTypeValue = "//*[normalize-space(text())='%s']";
	By btnEdit = By.xpath("//*[text()='Edit']");
	public By btnNext = By.xpath("//*[text()='Next']");
	public By alert = By.id("alert-dialog-slide-description");
	By btnClose = By.xpath("//*[text()='Close']");
	By btnSubmit = By.name("submit");
	MyProfileOperations myProfileCommon;
	CommonOperations common;
	elasticwrite log;

	public MyProfilePageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		myProfileCommon = new MyProfileOperations(this.driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void clickOnPersonal(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Personal']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Personal");
		}
		setLogSteps(log, "Click On Personal");
	}

	public void clickOnAddress(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Address']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Address");
		}
		setLogSteps(log, "Click On Address");
	}

	public void clickOnBank(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Bank']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Bank");
		}
		setLogSteps(log, "Click On Bank");
	}

	public void clickOnGovernment(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Government']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Government");
		}
		setLogSteps(log, "Click On Government");
	}

	public void clickOnNationality(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Nationality']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Nationality");
		}
		setLogSteps(log, "Click On Nationality");
	}

	public void clickOnBusiness(int... args) {
		try {
			clickOnElement(log, By.xpath("//*[contains(@class,'link') and text()='Business']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Business");
		}
		setLogSteps(log, "Click On Business");
	}

	public void enterEmailID(String emailID, int... args) {
		try {
			sendKeys(log, txtEmail, emailID, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "EmailID");
		}
		setLogSteps(log, "Enter Email : " + emailID);
	}

	public void selectOccupation(String occupation, int... args) {
		try {
			selectFromDropDown(log, drpOccupation, By.xpath(String.format(drpRequestTypeValue, occupation)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Occupation");
		}
		setLogSteps(log, "Select Occupation :" + occupation);
	}

	public void enterStreetAddress(String address, int... args) {
		try {
			sendKeys(log, txtStreetAddress, address, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "StreetAddress");
		}
		setLogSteps(log, "Enter Street Address : " + address);
	}

	public void selectCity(String city, int... args) {
		try {
			selectFromDropDown(log, drpCity, By.xpath(String.format(drpRequestTypeValue, city)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "City");
		}
		setLogSteps(log, "Select City :" + city);
	}

	public void selectHaveBankAccount(String account, int... args) {
		try {
			clickOnElement(log, By.xpath("//*[text()='" + account + "']"), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Have Bank Account");
		}
		setLogSteps(log, "Click On Have Bank Account");
	}

	public void clickOnEditButton(int... args) {
		try {
			clickOnElement(btnEdit);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Edit Button");
		}
		setLogSteps(log, "Click On Edit Button");
	}

	public void clickOnNextButton(int... args) {
		try {
			clickOnElement(btnNext, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Next Button");
		}
		setLogSteps(log, "Click On Next button");
	}

	public void clickOnCloseButton(int... args) {
		try {
			clickOnElement(btnClose, args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Close Button");
		}
		setLogSteps(log, "Click On Close Button");
	}

	public void clickOnsubmitButton() {
		try {
			clickOnElement(this.log, btnSubmit, 0);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Submit Button");
		}
		setLogSteps(log, "Click On Submit Button");
	}
}
