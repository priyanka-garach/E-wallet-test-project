package portals.operations.Agent;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.elasticUtils.elasticwrite;

public class ManageAgentPageOperations extends SetupInit {
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
	By drpBranch = By.id("frm_select_brachSelectid");
	By txtFullNameInEnglish = By.id("frm_text_FULL_NAME_IN_ENGLISHid");
	By txtFullNameInArabic = By.id("frm_text_FULL_NAME_IN_ARABICid");
	By dateOfBirth = By.id("frm_datepicker_DATE_OF_BIRTHid");
	By uploadFileData = By.id("frm_file_DISPLAY_PHOTOGRAPHid");
	By txtAreaOrVillage = By.id("frm_text_AREA/VILLAGE/DISTRICTid");
	By txtEntityName = By.id("frm_text_ENTITY_NAMEid");
	By txtBusinessRegiNumber = By.id("frm_text_BUSINESS_REGISTRATION_NUMBERid");
	By txtDateOfNasswalletSignup = By.id("frm_datepicker_DATE_OF_NASSWALLET_SIGN_UPid");
	By drpTypeOfBusiness = By.id("frm_select_AGENT_TYPE_OF_BUSINESSid");
	By drpBankAccountName = By.id("frm_select_SELECT_BANK_ACCOUNT_NAMEid");
	By txtBankAccountNumber = By.id("frm_text_BANK_ACCOUNT_NUMBERid");
	By uploadPersonalPhoto = By.id("frm_file_PERSONAL_PHOTOGRAPHid");
	By uploadIdentityProofFromFront = By.id("frm_file_IDENTITY_PROOF(FRONTEND)id");
	By uploadIdentityProofFromBack = By.id("frm_file_IDENTITY_PROOF(BACKEND)id");
	By uploadProofofAddress = By.id("frm_file_PROOF_OF_ADDRESS_OR_RESIDENCY_DOCUMENTid");
	By uploadBusinessEntityDoc = By.id("frm_file_BUSINESS_ENTITY_DOCUMENTid");
	By drpProofofIdentity = By.id("frm_select_PROOF_OF_IDENTITY_-IRAQIid");
	By drpProofofAddress = By.id("frm_select_PROOF_OF_ADDRESS_IRAQIid");
	By txtNationalID = By.id("frm_text_NATIONAL_IDid");
	By txtInformationCard = By.id("frm_text_INFORMATION_CARDid");
	public String selectType = "//*[text()='%s']//preceding-sibling::*//a[text()='%s']";
	By drpTeller = By.id("frm_select_tellerSelectid");
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public ManageAgentPageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
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
			clickOnElement(log, By.xpath("//*[text()='%s']"), args);
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

	public void clickOnsubmitButton(int... args) {
		try {
			clickOnElement(this.log, btnSubmit, 0);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Submit Button");
		}
		setLogSteps(log, "Click On Submit Button");
	}

	public void clickOnOnboardUserType(String userType, int... args) {
		try {
			clickOnElement(this.log, By.xpath(String.format(drpRequestTypeValue, userType)), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Submit Button");
		}
		setLogSteps(log, "Click On Submit Button");
	}

	public void SelectBranch(String branch, int... args) {
		try {
			selectFromDropDown(log, drpBranch, By.xpath(String.format(drpRequestTypeValue, branch)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Branch");
		}
		setLogSteps(log, "Select Branch");
	}

	public void enterFullNameInEnglish(String fullNameInEnglish, int... args) {
		try {
			sendKeys(log, txtFullNameInEnglish, fullNameInEnglish, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "FullNameInEnglish");
		}
		setLogSteps(log, "Enter FullNameInEnglish : " + fullNameInEnglish);
	}

	public void enterFullNameInArabic(String fullNameInArabic, int... args) {
		try {
			sendKeys(log, txtEmail, fullNameInArabic, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "FullNameInArabic");
		}
		setLogSteps(log, "Enter FullNameInArabic : " + fullNameInArabic);
	}

	public void SelectGender(String gender, int... args) {
		try {
			clickOnElement(this.log, By.xpath(String.format(drpRequestTypeValue, gender)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Gender");
		}
		setLogSteps(log, "Select Gender");
	}

	public void selectDate(String value, int... args) {
		try {
			sendKeys(log, dateOfBirth, value, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "Date Of Birth");
		}
		setLogSteps(log, "Select Date Of Birth:" + value);
	}

	public void UplodeProfilePicture(String value, int... args) {
		try {
			sendKeys(log, dateOfBirth, value, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "FullNameInArabic");
		}
		setLogSteps(log, "Select Date From  Field: " + value + "And Date is: " + value);
	}

	public void enterFileUploadData(String fileName, int... args) {
		File file = new File(".\\TestData\\resources\\" + fileName);
		String absolute = file.getAbsolutePath();
		sendKeys(uploadFileData, absolute, args);
		setLogSteps(log, "Upload File in Field: " + absolute);
	}

	public void selectOwnershipStatus(String status, int... args) {
		try {
			clickOnElement(this.log, By.xpath(String.format(drpRequestTypeValue, status)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "OwnershipStatus");
		}
		setLogSteps(log, "Select Gender");
	}

	public void enterAreaOrVillage(String address, int... args) {
		try {
			sendKeys(log, txtAreaOrVillage, address, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "Area/Village/District");
		}
		setLogSteps(log, "Enter Area/Village/District : " + address);
	}

	public void enterEntityName(String entity, int... args) {
		try {
			sendKeys(log, txtAreaOrVillage, entity, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "Entity Name");
		}
		setLogSteps(log, "Enter EntityName : " + entity);
	}

	public void enterBusinessRegiNumber(String number, int... args) {
		try {
			sendKeys(log, txtBusinessRegiNumber, number, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "Business Registration Number");
		}
		setLogSteps(log, "Enter Business Registration Number : " + number);
	}

	public void selectSignupDate(String value, int... args) {
		try {
			sendKeys(log, txtDateOfNasswalletSignup, value, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "Nasswallet Sigup Date");
		}
		setLogSteps(log, "Select Nasswallet Sigup Date" + value);
	}

	public void SelectTypeOfBusiness(String type, int... args) {
		try {
			selectFromDropDown(log, drpTypeOfBusiness, By.xpath(String.format(drpRequestTypeValue, type)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Type of Business");
		}
		setLogSteps(log, "Select Type of Business" + type);
	}

	public void SelectBusinessAccountName(String type, int... args) {
		try {
			selectFromDropDown(log, drpBankAccountName, By.xpath(String.format(drpRequestTypeValue, type)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Business Account Name");
		}
		setLogSteps(log, "Select Business Account Name" + type);
	}

	public void enterBankAccountNumber(String value, int... args) {
		try {
			sendKeys(log, txtBankAccountNumber, value, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "Bank Account Number");
		}
		setLogSteps(log, "Enter Bank Account Number" + value);
	}

	public void uploadPersonalPhotoGraph(String fileName, int... args) {
		File file = new File(".\\TestData\\resources\\" + fileName);
		String absolute = file.getAbsolutePath();
		sendKeys(uploadPersonalPhoto, absolute, args);
		setLogSteps(log, "Upload Personal Photo in Field: " + absolute);
	}

	public void uploadIdentityProofFromFront(String fileName, int... args) {
		File file = new File(".\\TestData\\resources\\" + fileName);
		String absolute = file.getAbsolutePath();
		sendKeys(uploadIdentityProofFromFront, absolute, args);
		setLogSteps(log, "Upload Identity Proof From Front in Field: " + absolute);
	}

	public void uploadIdentityProofFromBack(String fileName, int... args) {
		File file = new File(".\\TestData\\resources\\" + fileName);
		String absolute = file.getAbsolutePath();
		sendKeys(uploadIdentityProofFromBack, absolute, args);
		setLogSteps(log, "Upload Identity Proof From Back in Field: " + absolute);
	}

	public void uploadBusinessEntityDoc(String fileName, int... args) {
		File file = new File(".\\TestData\\resources\\" + fileName);
		String absolute = file.getAbsolutePath();
		sendKeys(uploadBusinessEntityDoc, absolute, args);
		setLogSteps(log, "Upload Business Entity Document in Field: " + absolute);
	}

	public void uploadProofOfAddress(String fileName, int... args) {
		File file = new File(".\\TestData\\resources\\" + fileName);
		String absolute = file.getAbsolutePath();
		sendKeys(uploadProofofAddress, absolute, args);
		setLogSteps(log, "Upload Proof Of Address in Field: " + absolute);
	}

	public void selectNationality(String nationality, int... args) {
		try {
			clickOnElement(this.log, By.xpath(String.format(drpRequestTypeValue, nationality)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Nationality");
		}
		setLogSteps(log, "Select Nationality");
	}

	public void SelectProofOfIdentity(String type, int... args) {
		try {
			selectFromDropDown(log, drpProofofIdentity, By.xpath(String.format(drpRequestTypeValue, type)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Proof Of Identity");
		}
		setLogSteps(log, "Select Proof Of Identity :" + type);
	}

	public void SelectProofOfAddress(String type, int... args) {
		try {
			selectFromDropDown(log, drpProofofAddress, By.xpath(String.format(drpRequestTypeValue, type)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Proof Of Address");
		}
		setLogSteps(log, "Select Proof Of Address :" + type);
	}

	public void enterNationalID(String value, int... args) {
		try {
			sendKeys(log, txtNationalID, value, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "National ID");
		}
		setLogSteps(log, "Enter National ID :" + value);
	}

	public void enterInformationCard(String value, int... args) {
		try {
			sendKeys(log, txtInformationCard, value, args);
		} catch (Exception e) {
			throw new RuntimeException(SEND_ERROR_MESSAGE + "Information Card");
		}
		setLogSteps(log, "Enter InformationCard :" + value);
	}

	public void clickOnSearchValue(String mobile, String name, int... args) {
		try {
			clickOnElement(this.log, By.xpath(String.format(selectType, mobile, name)), args);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Verify Data");
		}
		setLogSteps(log, "Click On Verify Data: " + name);
	}

	public void SelectTeller(String teller, int... args) {
		try {
			selectFromDropDown(log, drpTeller, By.xpath(String.format(drpRequestTypeValue, teller)), args);
		} catch (Exception e) {
			throw new RuntimeException(SELECT_ERROR_MESSAGE + "Teller");
		}
		setLogSteps(log, "Select Teller");
	}
}
