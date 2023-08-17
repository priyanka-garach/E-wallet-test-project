package portals.pages.Common;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.ChangeLanguageOperations;
import portals.operations.Common.CommonOperations;
import utils.elasticUtils.elasticwrite;

public class ChangeLanguagePage extends SetupInit {
	ChangeLanguageOperations changeLanguageOperations;
	CommonOperations common;
	elasticwrite log;

	public ChangeLanguagePage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		changeLanguageOperations = new ChangeLanguageOperations(this.driver, this.log);
		common = new CommonOperations(driver, log);
	}

	public void changeLanguage(Map<Object, Object> map) {
		changeLanguageOperations.selectLanguage(map.get(Language).toString(), 0);
		changeLanguageOperations.clickOnSubmitButton("English", 0);
		changeLanguageOperations.verifyLanguageChange(map.get(Language).toString(), 0);
		changeLanguageOperations.selectLanguage("English", 0);
		changeLanguageOperations.clickOnSubmitButton(map.get(Language).toString(), 0);
		changeLanguageOperations.verifyLanguageChange("English", 0);
	}
}
