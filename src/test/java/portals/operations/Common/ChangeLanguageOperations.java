package portals.operations.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.elasticUtils.elasticwrite;

public class ChangeLanguageOperations extends SetupInit {
	String languageSelect = "//*[text()='%s']";
	String message = "//div[contains(@class,'notification-container')]//span[normalize-space(text())='%s']";
	String arabicMessage = "تم تغيير اللغة بنجاح";
	String kurdishMessage = "زمانەکە بەسەرکەوتوی گۆردرا";
	String englishMessage = "Language change successfully.";
	By btnSubmitArabic = By.xpath("//button//*[text()='ارسال']");
	By btnSubmitKurdish = By.xpath("//button//*[text()='ناردن']");
	By btnSubmitEnglish = By.xpath("//button//*[text()='Submit']");
	elasticwrite log;

	public ChangeLanguageOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
	}

	public void selectLanguage(String language, int... args) {
		try {
			clickOnElement(By.xpath(String.format(languageSelect, language)), args);
			setLogSteps(log, "Click On " + language);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + language);
		}
	}

	public void verifyLanguageChange(String language, int... args) {
		if (language.equalsIgnoreCase("Arabic")) {
			try {
				if (!verifyVisible(By.xpath(String.format(message, arabicMessage)), 5))
					clickOnArabicSubmitButton(5);
				verifyVisible(By.xpath(String.format(message, arabicMessage)), 5);
				setLogSteps(log, "Verify Arabic Popup Message : " + arabicMessage + " Is Present");
			} catch (Exception e) {
				throw new RuntimeException(LOCATOR_FIND_ERROR_MESSAGE + arabicMessage);
			}
		} else if (language.equalsIgnoreCase("Kurdish")) {
			try {
				if (!verifyVisible(By.xpath(String.format(message, kurdishMessage)), 5))
					clickOnKurdishSubmitButton(5);
				verifyVisible(By.xpath(String.format(message, kurdishMessage)), 5);
				setLogSteps(log, "Verify Arabic Popup Message : " + kurdishMessage + " Is Present");
			} catch (Exception e) {
				throw new RuntimeException(LOCATOR_FIND_ERROR_MESSAGE + kurdishMessage);
			}
		} else if (language.equalsIgnoreCase("English")) {
			try {
				if (!verifyVisible(By.xpath(String.format(message, englishMessage)), 5))
					clickOnEnglishSubmitButton(5);
				verifyVisible(By.xpath(String.format(message, englishMessage)), 5);
				setLogSteps(log, "Verify Arabic Popup Message : " + englishMessage + " Is Present");
			} catch (Exception e) {
				throw new RuntimeException(LOCATOR_FIND_ERROR_MESSAGE + englishMessage);
			}
		}
	}

	public void clickOnSubmitButton(String language, int... args) {
		if (language.equalsIgnoreCase("Arabic")) {
			clickOnArabicSubmitButton(args);
		} else if (language.equalsIgnoreCase("Kurdish")) {
			clickOnKurdishSubmitButton(args);
		} else if (language.equalsIgnoreCase("English")) {
			clickOnEnglishSubmitButton(args);
		}
	}

	private void clickOnEnglishSubmitButton(int... args) {
		try {
			clickOnElement(btnSubmitEnglish, args);
			setLogSteps(log, "Click On Submit");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "Submit");
		}
	}

	private void clickOnKurdishSubmitButton(int... args) {
		try {
			clickOnElement(btnSubmitKurdish, args);
			setLogSteps(log, "Click On ناردن");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "ناردن");
		}
	}

	private void clickOnArabicSubmitButton(int... args) {
		try {
			clickOnElement(btnSubmitArabic, args);
			setLogSteps(log, "Click On ارسال");
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "ارسال");
		}
	}
}
