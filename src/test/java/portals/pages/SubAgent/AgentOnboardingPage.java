package portals.pages.SubAgent;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Agent.AgentOnboardingPageOperations;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.Utility;
import utils.elasticUtils.elasticwrite;

public class AgentOnboardingPage extends SetupInit {
	AgentOnboardingPageOperations agentOnboardingPageOperations;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public AgentOnboardingPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		agentOnboardingPageOperations = new AgentOnboardingPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public boolean agentOnboarding(Map<Object, Object> map) {
		// agentOnboardingPageOperations.clickOnsubmitButton();
		agentOnboardingPageOperations.selectDate(map.get(DateOfBirth)
				.toString(), 0);
		clickOnElement(agentOnboardingPageOperations.txtMobileNumber, 0);
		String phone = "75" + String.valueOf(Utility.getRandomInt(1111, 9999))
				+ String.valueOf(Utility.getRandomInt(1111, 9999));
		agentOnboardingPageOperations.enterMobileNumber(phone, 0);
		if (!map.get(FullNameInEnglish).toString().isEmpty()) {
			agentOnboardingPageOperations.enterFullNameInEnglish(
					map.get(FullNameInEnglish).toString(), 0);
		}
		if (!map.get(FullNameInArabic).toString().isEmpty()) {
			agentOnboardingPageOperations.enterFullNameInArabic(
					map.get(FullNameInArabic).toString(), 0);
		}
		agentOnboardingPageOperations.SelectGender(map.get(Gender).toString(),
				0);
		if (!map.get(EmailID).toString().isEmpty()) {
			agentOnboardingPageOperations.enterEmailID(map.get(EmailID)
					.toString(), 0);
		}
		if (!map.get(Occupation).toString().isEmpty()) {
			agentOnboardingPageOperations.selectOccupation(map.get(Occupation)
					.toString(), 0);
		}
		if (!map.get(ProfilePicture).toString().isEmpty()) {
			agentOnboardingPageOperations.enterFileUploadData(map.get(ProfilePicture).toString(), 0);
		}
		agentOnboardingPageOperations.clickOnNextButton(0);
		agentOnboardingPageOperations.selectOwnershipStatus(map.get(OwnweShipStatus).toString(), 0);
		if (!map.get(StreetAddress).toString().isEmpty()) {
			agentOnboardingPageOperations.enterStreetAddress(map.get(StreetAddress).toString(), 0);
		}
		agentOnboardingPageOperations.enterAreaOrVillage(map.get(AreaOrVilllageOrDistrict).toString(), 0);
		if (!map.get(City).toString().isEmpty()) {
			agentOnboardingPageOperations.selectCity(map.get(City).toString(), 0);
		}
		agentOnboardingPageOperations.clickOnNextButton(0);
		agentOnboardingPageOperations.enterEntityName(map.get(EntityName).toString(), 0);
		agentOnboardingPageOperations.enterBusinessRegiNumber(map.get(BusinessRegistrationNumber).toString(), 0);
		agentOnboardingPageOperations.selectSignupDate(map.get(DateOpenedNasswalletAccount).toString(), 0);
		agentOnboardingPageOperations.SelectTypeOfBusiness(map.get(TypeOfBusiness).toString(), 0);
		agentOnboardingPageOperations.clickOnNextButton(0);
		if (!map.get(HaveBankAccount).toString().isEmpty()) {
			agentOnboardingPageOperations.selectHaveBankAccount(map.get(HaveBankAccount).toString(), 0);
		}
		if (!map.get(HaveBankAccount).toString().equalsIgnoreCase("no")) {
			agentOnboardingPageOperations.SelectBusinessAccountName(map.get(SelectBankAccountName).toString(), 0);
			agentOnboardingPageOperations.enterBankAccountNumber(map.get(BankAccountNumber).toString(), 0);
		}
		agentOnboardingPageOperations.clickOnNextButton(0);
		agentOnboardingPageOperations.uploadPersonalPhotoGraph(map.get(PersonalPhoto).toString(), 0);
		agentOnboardingPageOperations.uploadIdentityProofFromFront(map.get(IdentityProofFromFront).toString(), 0);
		agentOnboardingPageOperations.uploadIdentityProofFromBack(map.get(IdentityProofFromBack).toString(), 0);
		agentOnboardingPageOperations.uploadProofOfAddress(map.get(ProofOfAddress).toString(), 0);
		agentOnboardingPageOperations.uploadBusinessEntityDoc(map.get(BusinessDocument).toString(), 0);
		agentOnboardingPageOperations.clickOnNextButton(0);
		if (!map.get(ProofOfIdentityIraqi).toString().isEmpty()) {
			agentOnboardingPageOperations.selectNationality(map.get(Nationality).toString(), 0);
			if (map.get(Nationality).toString().equalsIgnoreCase(Iraqi)) {
				agentOnboardingPageOperations.SelectProofOfIdentity(map.get(ProofOfIdentityIraqi).toString(), 0);
				agentOnboardingPageOperations.enterNationalID(map.get(IdOfIdentity).toString(), 0);
				agentOnboardingPageOperations.SelectProofOfAddress(map.get(ProofOfAddressIraqi).toString(), 0);
				agentOnboardingPageOperations.enterInformationCard(map.get(AddressCard).toString(), 0);
			}
		}
		agentOnboardingPageOperations.clickOnsubmitButton(0);
		dashboardPageCommon.clickOnConfirmBtn(0);
		if (verifyVisible(dashboardPageCommon.alert, 5)) {
			String message = getElementText(this.log, dashboardPageCommon.alert, 5);
			setLogSteps(this.log, message);
			dashboardPageCommon.clickOnCloseButton(0);
			if (message.contains("Account Identifier already exist")) {
				setLogSteps(this.log, "Account Identifier already exist");
				return true;
			} else {
				return false;
			}
		} else {
			dashboardPageCommon.verifyOnboardSuccessText(0);
			setLogSteps(log, "Verify Onboarded Successfully");
			return true;
		}
	}
}
