package portals.pages.SubAgent;

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

	public void subAgentVerifyProfileDetailsPersonal(Map<Object, Object> map) {
		myProfileCommon.clickOnPersonalSubAgent(0);
		verifyVisible(
				By.xpath(String.format(myProfileCommon.VerifyDisplayName, map.get(DisplayName).toString())),
				0);
		setLogSteps(log, "Verify Display Name");
		
		if (!map.get(EmailID).toString().isEmpty()) {
			verifyVisible(By.xpath(String.format(myProfileCommon.VerifyEmailID, map.get(EmailID).toString())), 0);
			setLogSteps(log, "Verify Email ID");
		}
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyMobile, map.get(Mobile).toString())), 0);
		setLogSteps(log, "Verify Mobile");
		
		verifyVisible(
				By.xpath(String.format(myProfileCommon.VerifyCompanyName, map.get(Companyname).toString())), 0);
		setLogSteps(log, "Verify Company Name");
		
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyTinNo, map.get(TinNo).toString())),
				0);
		setLogSteps(log, "Verify Tin no");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyCertificationofIncorporationNumber,
				map.get(CertificationofIncorporationNumber).toString())), 0);
		setLogSteps(log, "Verify Certification of Incorporation Number");
		
		scrollToElement_Tangereine(driver.findElement(By.xpath(String.format(myProfileCommon.VerifyPrimaryUsername, map.get(PrimaryUsername).toString()))));
		
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyPrimaryUsername, map.get(PrimaryUsername).toString())), 0);
		setLogSteps(log, "Verify Primary Username");
		
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyPrimaryUserMobile, map.get(PrimaryUserMobile).toString())), 0);
		setLogSteps(log, "Verify Primary User Mobile");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyAdditonalTerms, map.get(AdditonalTerms).toString())), 0);
		setLogSteps(log, "Verify Additonal Terms");
		
		verifyVisible(By.xpath(
				String.format(myProfileCommon.VerifyAdditonalNotes, map.get(AdditonalNotes).toString())), 0);
		setLogSteps(log, "Verify Additonal Notes");
		
		verifyVisible(By.xpath(
				String.format(myProfileCommon.VerifyBillingCurrency, map.get(BillingCurrency).toString())), 0);
		setLogSteps(log, "Verify BillingCurrency");
		
		verifyVisible(By.xpath(
				String.format(myProfileCommon.VerifyDiscountValue, map.get(DiscountValue).toString())), 0);
		setLogSteps(log, "Verify DiscountValue");
		
		verifyVisible(By.xpath(
				String.format(myProfileCommon.VerifyLandlineNo, map.get(LandlineNo).toString())), 0);
		setLogSteps(log, "Verify LandlineNo");
		
		scrollToElement_Tangereine(driver.findElement(By.xpath(
				String.format(myProfileCommon.VerifyAlternateMobile, map.get(AlternateMobile).toString()))));
		
		verifyVisible(By.xpath(
				String.format(myProfileCommon.VerifyAlternateMobile, map.get(AlternateMobile).toString())), 0);
		setLogSteps(log, "Verify AlternateMobile");
		
		verifyVisible(By.xpath(
				String.format(myProfileCommon.VerifyAddress, map.get(Address).toString())), 0);
		setLogSteps(log, "Verify Address");
		
		
		verifyVisible(By.xpath(
				String.format(myProfileCommon.VerifyPostalCode, map.get(PostalCode).toString())), 0);
		setLogSteps(log, "Verify PostalCode");
		
		
		verifyVisible(By.xpath(
				String.format(myProfileCommon.VerifyCity, map.get(City).toString())), 0);
		setLogSteps(log, "Verify City");
		
		setLogSteps(log, "Personal info religious worship data verified....");
		
	}
	
	public void subAgentVerifyProfileDetailsDocument(Map<Object, Object> map) {
		myProfileCommon.clickOnDocumentSubAgent(0);
		verifyVisible(
				By.xpath(String.format(myProfileCommon.VerifyCertifiedofRegistrationRelatedCompany, map.get(CertifiedofRegistrationRelatedCompany).toString())),
				0);
		setLogSteps(log, "Verify Certified of registration related company");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyCertifiedofRegistrationParentCompany, map.get(CertifiedofRegistrationParentCompany).toString())), 0);
		setLogSteps(log, "Verify Certified of registration parent company ");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyValidIDsofdirectors, map.get(ValidIDsofdirectors).toString())), 0);
		setLogSteps(log, "Verify Valid IDs of directors");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyTaxExemptionCertificate, map.get(TaxExemptionCertificate).toString())), 0);
		setLogSteps(log, "Verify Tax exemption certificate");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyValidIDsofnominatedadministrators, map.get(ValidIDsofNominatedAdministrators).toString())), 0);
		setLogSteps(log, "Verify Valid IDs of nominated administrators");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyValidIDsofpassport, map.get(ValidIDsofPassport).toString())), 0);
		setLogSteps(log, "Verify Valid IDs of passport");
		
		scrollToElement_Tangereine(driver.findElement(By.xpath(String.format(myProfileCommon.VerifyRecommendationletterfromRespectiveSercretariat, map.get(RecommendationLetterfromRespectiveSercretariat).toString()))));
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyRecommendationletterfromRespectiveSercretariat, map.get(RecommendationLetterfromRespectiveSercretariat).toString())), 0);
		setLogSteps(log, "Verify Recommendation letter from respective sercretariat");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyRecommendationletterfromparentEntity, map.get(RecommendationLetterfromParentEntity).toString())), 0);
		setLogSteps(log, "Verify Recommendation letter from parent entity");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyCertifiedbyAuthorisedPersons, map.get(CertifiedbyAuthorisedPersons).toString())), 0);
		setLogSteps(log, "Verify Certified by authorised persons");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyValidIDsofRefugeeid, map.get(ValidIDsofRefugeeid).toString())), 0);
		setLogSteps(log, "Verify Valid IDs of refugeeid");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyValidIDsofRefugeeAttestations, map.get(ValidIDsofRefugeeAttestations).toString())), 0);
		setLogSteps(log, "Verify Valid IDs of refugee attestations");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyRecommendationLetterfromMotherEntity, map.get(RecommendationLetterfromMotherEntity).toString())), 0);
		setLogSteps(log, "Verify Recommendation letter from mother entity");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyRecentUtilityBillsNotOlderThanThreeMonths, map.get(RecentUtilityBillsNotOlderthanThreeMonths).toString())), 0);
		setLogSteps(log, "Verify Recent utility bills not older than three months");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyTenancyAgreement, map.get(TenancyAgreement).toString())), 0);
		setLogSteps(log, "Verify Tenancy agreement");
		
		scrollToElement(driver.findElement(By.xpath(String.format(myProfileCommon.VerifyTenancyAgreement, map.get(TenancyAgreement).toString()))));
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyGovernmentAuthorityBills, map.get(GovernmentAuthorityBills).toString())), 0);
		setLogSteps(log, "Verify Government authority bills");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyLocalAuthorityBills, map.get(LocalAuthorityBills).toString())), 0);
		setLogSteps(log, "Verify Local authority bills");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyBankStatementBearingBusinessAddress, map.get(BankStatementBearingBusinessAddress).toString())), 0);
		setLogSteps(log, "Verify Bank statement bearing business address");
		
		verifyVisible(By.xpath(String.format(myProfileCommon.VerifyStatmentofParticulars, map.get(StatmentofParticulars).toString())), 0);
		setLogSteps(log, "Verify Statment of particulars");
		
		setLogSteps(log, "Document info religious worship data verified....");
	}
	
	
	public void checkBalancefromMyProfile() {
		myProfileCommon.checkBalancefromMyprofile(0);
	}
}
