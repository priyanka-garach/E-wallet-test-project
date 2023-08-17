package portals.pages.SubAgent;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import portals.operations.Common.CommonOperations;
import portals.operations.Common.DashBoardPageOperations;
import portals.operations.SubAgent.ChangeMpinPageOperations;
import utils.elasticUtils.elasticwrite;

public class ChangeMpinPage extends SetupInit {
	ChangeMpinPageOperations changeMpinPage;
	DashBoardPageOperations dashboardPageCommon;
	CommonOperations common;
	elasticwrite log;

	public ChangeMpinPage(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		changeMpinPage = new ChangeMpinPageOperations(this.driver, log);
		dashboardPageCommon = new DashBoardPageOperations(driver, log);
		common = new CommonOperations(this.driver, log);
	}

	public void setnewMpin(Map<Object, Object> map) {
		changeMpinPage.entercurrentMpin(map.get(FromMpin).toString(), 0);
		changeMpinPage.enternewMpin(map.get(NewMpin).toString(), 0);
		changeMpinPage.enterconfirmMpin(map.get(NewMpin).toString(), 0);
		changeMpinPage.clickOnsubmitButton();	
	}

}
