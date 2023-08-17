package portals.pages.Agent;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.MyProfileOperations;
import utils.elasticUtils.elasticwrite;

public class MyProfilePage extends SetupInit {
	MyProfileOperations myProfileCommon;
	CommonOperations common;
	elasticwrite log;

	public MyProfilePage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		myProfileCommon = new MyProfileOperations(this.driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void superAgentVerifyProfileDetails(Map<Object, Object> map) {
		myProfileCommon.clickOnPersonal(0);
		verifyVisible(
				By.xpath(String.format(myProfileCommon.VerifyfullnameEnglish, map.get(FullNameInEnglish).toString())),
				0);
		setLogSteps(log, "Verify Full Name In English");
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyGender, map.get(Gender).toString())), 0);
		setLogSteps(log, "Verify Gender");
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyPhone, map.get(Phone).toString())), 0);
		setLogSteps(log, "Verify Phone");
		if (!map.get(EmailID).toString().isEmpty()) {
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyEmailID, map.get(EmailID).toString())), 0);
			setLogSteps(log, "Verify Email ID");
		}
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyOccupation, map.get(Occupation).toString())), 0);
		setLogSteps(log, "Verify Occupation");
		myProfileCommon.clickOnAddress(0);
		verifyVisible(
				By.xpath(String.format(myProfileCommon.VerifyOwnershipStatus, map.get(OwnweShipStatus).toString())), 0);
		setLogSteps(log, "Verify Ownweship Status");
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyStreetAddress, map.get(StreetAddress).toString())),
				0);
		setLogSteps(log, "Verify Street Address");
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyAreaorVilllageOrDistict,
				map.get(AreaOrVilllageOrDistrict).toString())), 0);
		setLogSteps(log, "Verify Area/Village/District");
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyCity, map.get(City).toString())), 0);
		setLogSteps(log, "Verify City");
		myProfileCommon.clickOnBusiness(0);
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyEntityName, map.get(EntityName).toString())), 0);
		setLogSteps(log, "Verify Entity Name");
		verifyVisible(By.xpath(String.format(myProfileCommon.verifyBusinessRegistationNumber,
				map.get(BusinessRegistrationNumber).toString())), 0);
		setLogSteps(log, "Verify Business Registration Number");
		verifyVisible(By.xpath(
				String.format(myProfileCommon.verifyAgentTypeOfBusiness, map.get(AgentTypeOfBusiness).toString())), 0);
		setLogSteps(log, "Verify Agent Type Of Business");
		myProfileCommon.clickOnBank(0);
		verifyVisible(
				By.xpath(String.format(myProfileCommon.verifyHaveBankAccount, map.get(HaveBankAccount).toString())), 0);
		myProfileCommon.clickOnNationality(0);
		if (!map.get(ProofOfIdentityIraqi).toString().isEmpty()) {
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyProofOfIdentityIraqi,
					map.get(ProofOfIdentityIraqi).toString())), 0);
			setLogSteps(log, "Verify Proof Of Identity For Iraqi");
			if (!map.get(ProofOfIdentityIraqi).toString().isEmpty()) {
				verifyVisible(
						By.xpath(String.format(myProfileCommon.VerifyNationalID, map.get(IdOfIdentity).toString())), 0);
				setLogSteps(log, "Verify Nationl ID");
			} else {
				verifyVisible(By.xpath(String.format(myProfileCommon.VerifyCivilID, map.get(IdOfIdentity).toString())),
						0);
				setLogSteps(log, "Verify Civil ID");
			}
			verifyVisible(By.xpath(
					String.format(myProfileCommon.VerifyProofOfAddressIraqi, map.get(ProofOfAddressIraqi).toString())),
					0);
			setLogSteps(log, "Verify Proof Of Address For Iraqi");
			if (!map.get(ProofOfAddressIraqi).toString().isEmpty()) {
				verifyVisible(
						By.xpath(String.format(myProfileCommon.VerifyInformationCard, map.get(AddressCard).toString())),
						0);
				setLogSteps(log, "Verify Information Card");
			} else {
				verifyVisible(
						By.xpath(String.format(myProfileCommon.VerifySupplyCard, map.get(AddressCard).toString())), 0);
				setLogSteps(log, "Verify Supply Card");
			}
		} else {
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyProofOfIdentityNonIraqi,
					map.get(ProofOfIdentityNonIraqi).toString())), 0);
			setLogSteps(log, "Verify Proof Of Identity For NonIraqi");
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyPassport, map.get(Passport).toString())), 0);
			setLogSteps(log, "Verify Passport");
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyProofOfAddressNonIraqi,
					map.get(ProofOfresidencyNonIraqi).toString())), 0);
			setLogSteps(log, "Verify Proof Of Address For NonIraqi");
			if (!map.get(ProofOfIdentityNonIraqi).toString().isEmpty()) {
				verifyVisible(
						By.xpath(String.format(myProfileCommon.VerifyEntryStemp, map.get(ResidencyCard).toString())),
						0);
				setLogSteps(log, "Verify Entry Stemp");
			} else {
				verifyVisible(
						By.xpath(String.format(myProfileCommon.VerifyResidencyCard, map.get(ResidencyCard).toString())),
						0);
				setLogSteps(log, "Verify Residency Card");
			}
		}
	}

	public boolean superAgentEditProfile(Map<Object, Object> map) {
		myProfileCommon.clickOnEditButton(0);
		// if (!map.get(EmailID).toString().isEmpty()) {
		// myProfileCommon.enterEmailID(map.get(EmailID).toString(), 0);
		// }
		if (!map.get(Occupation).toString().isEmpty()) {
			myProfileCommon.selectOccupation(map.get(Occupation).toString(), 0);
		}
		myProfileCommon.clickOnNextButton(0);
		if (!map.get(StreetAddress).toString().isEmpty()) {
			myProfileCommon.enterStreetAddress(map.get(StreetAddress).toString(), 0);
		}
		if (!map.get(City).toString().isEmpty()) {
			myProfileCommon.selectCity(map.get(City).toString(), 0);
		}
		if (!map.get(AreaOrVilllageOrDistrict).toString().isEmpty()) {
			myProfileCommon.enterAreaOrVillageOrDistrict(map.get(AreaOrVilllageOrDistrict).toString(), 0);
		}
		myProfileCommon.clickOnNextButton(0);
		myProfileCommon.clickOnNextButton(0);
		if (!map.get(HaveBankAccount).toString().isEmpty()) {
			myProfileCommon.selectHaveBankAccount(map.get(HaveBankAccount).toString(), 0);
		}
		myProfileCommon.clickOnNextButton(0);
		myProfileCommon.clickOnsubmitButton();
		if (verifyVisible(myProfileCommon.alert, 5)) {
			setLogSteps(this.log, getElementText(this.log, myProfileCommon.alert, 5));
			myProfileCommon.clickOnCloseButton(0);
			return false;
		}
		return true;
	}

	public void agentVerifyProfileDetails(Map<Object, Object> map) {
		myProfileCommon.clickOnPersonal(0);
		verifyVisible(
				By.xpath(String.format(myProfileCommon.VerifyfullnameEnglish, map.get(FullNameInEnglish).toString())),
				0);
		setLogSteps(log, "Verify Full Name In English");
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyGender, map.get(Gender).toString())), 0);
		setLogSteps(log, "Verify Gender");
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyPhone, map.get(Phone).toString())), 0);
		setLogSteps(log, "Verify Phone");
		if (!map.get(EmailID).toString().isEmpty()) {
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyEmailID, map.get(EmailID).toString())), 0);
			setLogSteps(log, "Verify Email ID");
		}
		myProfileCommon.clickOnAddress(0);
		verifyVisible(
				By.xpath(String.format(myProfileCommon.VerifyOwnershipStatus, map.get(OwnweShipStatus).toString())), 0);
		setLogSteps(log, "Verify Ownership Status");
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyStreetAddress, map.get(StreetAddress).toString())),
				0);
		setLogSteps(log, "Verify Street Address");
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyAreaorVilllageOrDistict,
				map.get(AreaOrVilllageOrDistrict).toString())), 0);
		setLogSteps(log, "Verify Area Or Villlage Or District");
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyCity, map.get(City).toString())), 0);
		setLogSteps(log, "Verify City");
		myProfileCommon.clickOnBusiness(0);
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyEntityName, map.get(EntityName).toString())), 0);
		setLogSteps(log, "Verify Entity Name");
		verifyVisible(By.xpath(String.format(myProfileCommon.verifyBusinessRegistationNumber,
				map.get(BusinessRegistrationNumber).toString())), 0);
		setLogSteps(log, "Verify Business Registration");
		if (!map.get(DateOpenedNasswalletAccount).toString().isEmpty()) {
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyNasswalletAccountOpenDate,
					map.get(DateOpenedNasswalletAccount).toString())), 0);
			setLogSteps(log, "Verify Date of Opened Nasswallet Account");
		}
		myProfileCommon.clickOnBank(0);
		verifyVisible(
				By.xpath(String.format(myProfileCommon.verifyHaveBankAccount, map.get(HaveBankAccount).toString())), 0);
		myProfileCommon.clickOnNationality(0);
		if (!map.get(ProofOfIdentityIraqi).toString().isEmpty()) {
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyProofOfIdentityIraqi,
					map.get(ProofOfIdentityIraqi).toString())), 0);
			setLogSteps(log, "Verify Proof Of Identity For Iraqi");
			if (!map.get(ProofOfIdentityIraqi).toString().isEmpty()) {
				verifyVisible(
						By.xpath(String.format(myProfileCommon.VerifyNationalID, map.get(IdOfIdentity).toString())), 0);
				setLogSteps(log, "Verify Nationl ID");
			} else {
				verifyVisible(By.xpath(String.format(myProfileCommon.VerifyCivilID, map.get(IdOfIdentity).toString())),
						0);
				setLogSteps(log, "Verify Civil ID");
			}
			verifyVisible(By.xpath(
					String.format(myProfileCommon.VerifyProofOfAddressIraqi, map.get(ProofOfAddressIraqi).toString())),
					0);
			setLogSteps(log, "Verify Proof Of Address For Iraqi");
			if (!map.get(ProofOfAddressIraqi).toString().isEmpty()) {
				verifyVisible(
						By.xpath(String.format(myProfileCommon.VerifyInformationCard, map.get(AddressCard).toString())),
						0);
				setLogSteps(log, "Verify Information Card");
			} else {
				verifyVisible(
						By.xpath(String.format(myProfileCommon.VerifySupplyCard, map.get(AddressCard).toString())), 0);
				setLogSteps(log, "Verify Supply Card");
			}
		} else {
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyProofOfIdentityNonIraqi,
					map.get(ProofOfIdentityNonIraqi).toString())), 0);
			setLogSteps(log, "Verify Proof Of Identity For NonIraqi");
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyPassport, map.get(Passport).toString())), 0);
			setLogSteps(log, "Verify Passport");
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyProofOfAddressNonIraqi,
					map.get(ProofOfresidencyNonIraqi).toString())), 0);
			setLogSteps(log, "Verify Proof Of Address For NonIraqi");
			if (!map.get(ProofOfIdentityNonIraqi).toString().isEmpty()) {
				verifyVisible(
						By.xpath(String.format(myProfileCommon.VerifyEntryStemp, map.get(ResidencyCard).toString())),
						0);
				setLogSteps(log, "Verify Entry Stemp");
			} else {
				verifyVisible(
						By.xpath(String.format(myProfileCommon.VerifyResidencyCard, map.get(ResidencyCard).toString())),
						0);
				setLogSteps(log, "Verify Residency Card");
			}
		}
	}

	public boolean agentEditProfile(Map<Object, Object> map) {
		myProfileCommon.clickOnEditButton(0);
		if (!map.get(Occupation).toString().isEmpty()) {
			myProfileCommon.selectOccupation(map.get(Occupation).toString(), 0);
		}
		myProfileCommon.clickOnNextButton(0);
		if (!map.get(StreetAddress).toString().isEmpty()) {
			myProfileCommon.enterStreetAddress(map.get(StreetAddress).toString(), 0);
		}
		if (!map.get(AreaOrVilllageOrDistrict).toString().isEmpty()) {
			myProfileCommon.enterAreaOrVillageOrDistrict(map.get(AreaOrVilllageOrDistrict).toString(), 0);
		}
		if (!map.get(City).toString().isEmpty()) {
			myProfileCommon.selectCity(map.get(City).toString(), 0);
		}
		myProfileCommon.clickOnNextButton(0);
		myProfileCommon.clickOnNextButton(0);
		if (!map.get(HaveBankAccount).toString().isEmpty()) {
			myProfileCommon.selectHaveBankAccount(map.get(HaveBankAccount).toString(), 0);
		}
		myProfileCommon.clickOnNextButton(0);
		myProfileCommon.clickOnsubmitButton();
		if (verifyVisible(myProfileCommon.alert, 5)) {
			setLogSteps(this.log, getElementText(this.log, myProfileCommon.alert, 5));
			myProfileCommon.clickOnCloseButton(0);
			return false;
		}
		return true;
	}
}
