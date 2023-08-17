package portals.pages.Agent;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Agent.ManageAgentPageOperations;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import utils.elasticUtils.elasticwrite;

public class ManageAgentPage extends SetupInit {
	ManageAgentPageOperations manageAgentPageOperations;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public ManageAgentPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		manageAgentPageOperations = new ManageAgentPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void manageAgent(Map<Object, Object> map) {
		dashboardPageCommon.clickOnFilterButton(0);
		dashboardPageCommon.clickOnClearButton(0);
		dashboardPageCommon.clickOnFilterButton(0);
		dashboardPageCommon.enterMobileNumber(map.get(MobileNumber).toString(), 0);
		dashboardPageCommon.enterAgentName(map.get(FullNameInEnglish).toString(), 0);
		manageAgentPageOperations.clickOnsubmitButton(0);
		manageAgentPageOperations.clickOnSearchValue(map.get(MobileNumber).toString(),
				map.get(FullNameInEnglish).toString(), 0);
		manageAgentPageOperations.clickOnPersonal(0);
		verifyVisible(By.xpath(
				String.format(manageAgentPageOperations.VerifyfullnameEnglish, map.get(FullNameInEnglish).toString())),
				0);
		setLogSteps(log, "Verify Full Name In English");
		verifyVisible(By.xpath(String.format(manageAgentPageOperations.VerifyGender, map.get(Gender).toString())), 0);
		setLogSteps(log, "Verify Gender");
		verifyVisible(By.xpath(String.format(manageAgentPageOperations.VerifyPhone, map.get(MobileNumber).toString())),
				0);
		setLogSteps(log, "Verify Phone");
		if (!map.get(EmailID).toString().isEmpty()) {
			verifyVisible(By.xpath(String.format(manageAgentPageOperations.VerifyEmailID, map.get(EmailID).toString())),
					0);
			setLogSteps(log, "Verify Email ID");
		}
		manageAgentPageOperations.clickOnAddress(0);
		verifyVisible(By.xpath(
				String.format(manageAgentPageOperations.VerifyOwnershipStatus, map.get(OwnweShipStatus).toString())),
				0);
		setLogSteps(log, "Verify OwnweShip Status");
		verifyVisible(By.xpath(
				String.format(manageAgentPageOperations.VerifyStreetAddress, map.get(StreetAddress).toString())), 0);
		setLogSteps(log, "Verify Street Address");
		verifyVisible(By.xpath(String.format(manageAgentPageOperations.VerifyAreaorVilllageOrDistict,
				map.get(AreaOrVilllageOrDistrict).toString())), 0);
		setLogSteps(log, "Verify OwnweShip Status");
		verifyVisible(By.xpath(String.format(manageAgentPageOperations.VerifyCity, map.get(City).toString())), 0);
		setLogSteps(log, "Verify City");
		manageAgentPageOperations.clickOnBusiness(0);
		verifyVisible(
				By.xpath(String.format(manageAgentPageOperations.VerifyEntityName, map.get(EntityName).toString())), 0);
		setLogSteps(log, "Verify Entity Name");
		verifyVisible(By.xpath(String.format(manageAgentPageOperations.verifyBusinessRegistationNumber,
				map.get(BusinessRegistrationNumber).toString())), 0);
		setLogSteps(log, "Verify Business Registration Number");
		manageAgentPageOperations.clickOnBank(0);
		if (!map.get(HaveBankAccount).toString().isEmpty()) {
			verifyVisible(By.xpath(String.format(manageAgentPageOperations.verifyHaveBankAccount,
					map.get(HaveBankAccount).toString())), 0);
		}
		manageAgentPageOperations.clickOnNationality(0);
		if (!map.get(ProofOfIdentityIraqi).toString().isEmpty()) {
			verifyVisible(By.xpath(String.format(manageAgentPageOperations.VerifyProofOfIdentityIraqi,
					map.get(ProofOfIdentityIraqi).toString())), 0);
			setLogSteps(log, "Verify Proof Of Identity For Iraqi");
			if (!map.get(ProofOfIdentityIraqi).toString().isEmpty()) {
				verifyVisible(By.xpath(
						String.format(manageAgentPageOperations.VerifyNationalID, map.get(IdOfIdentity).toString())),
						0);
				setLogSteps(log, "Verify Nationl ID");
			} else {
				verifyVisible(By.xpath(
						String.format(manageAgentPageOperations.VerifyCivilID, map.get(IdOfIdentity).toString())), 0);
				setLogSteps(log, "Verify Civil ID");
			}
			verifyVisible(By.xpath(String.format(manageAgentPageOperations.VerifyProofOfAddressIraqi,
					map.get(ProofOfAddressIraqi).toString())), 0);
			setLogSteps(log, "Verify Proof Of Address For Iraqi");
			if (!map.get(ProofOfAddressIraqi).toString().isEmpty()) {
				verifyVisible(By.xpath(String.format(manageAgentPageOperations.VerifyInformationCard,
						map.get(AddressCard).toString())), 0);
				setLogSteps(log, "Verify Information Card");
			} else {
				verifyVisible(By.xpath(
						String.format(manageAgentPageOperations.VerifySupplyCard, map.get(AddressCard).toString())), 0);
				setLogSteps(log, "Verify Supply Card");
			}
		} else {
			verifyVisible(By.xpath(String.format(manageAgentPageOperations.VerifyProofOfIdentityNonIraqi,
					map.get(ProofOfIdentityNonIraqi).toString())), 0);
			setLogSteps(log, "Verify Proof Of Identity For NonIraqi");
			verifyVisible(
					By.xpath(String.format(manageAgentPageOperations.VerifyPassport, map.get(Passport).toString())), 0);
			setLogSteps(log, "Verify Passport");
			verifyVisible(By.xpath(String.format(manageAgentPageOperations.VerifyProofOfAddressNonIraqi,
					map.get(ProofOfresidencyNonIraqi).toString())), 0);
			setLogSteps(log, "Verify Proof Of Address For NonIraqi");
			if (!map.get(ProofOfIdentityNonIraqi).toString().isEmpty()) {
				verifyVisible(By.xpath(
						String.format(manageAgentPageOperations.VerifyEntryStemp, map.get(ResidencyCard).toString())),
						0);
				setLogSteps(log, "Verify Entry Stemp");
			} else {
				verifyVisible(By.xpath(String.format(manageAgentPageOperations.VerifyResidencyCard,
						map.get(ResidencyCard).toString())), 0);
				setLogSteps(log, "Verify Residency Card");
			}
		}
	}
}
