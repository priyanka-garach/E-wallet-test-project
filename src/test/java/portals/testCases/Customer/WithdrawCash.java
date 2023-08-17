package portals.testCases.Customer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;
import portals.pages.Customer.WithdrawCashPage;
import utils.Utility;

public class WithdrawCash extends SetupInit {
	protected CreateObject co;
	
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());
	}

	@Test(dataProvider = "WithdrawCash And Agent Assisted Withdraw", dataProviderClass = TestDataImport.class)
	public void withdrawCashAndAgentAssistedWithdrawfromDashboard(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "withdrawCash");
			map.put(MethodName, "withdrawCash");
			
			co.navigationPage.clickOnCashOut();
			map = co.withdrawCashPage.WithdrawCash(map);
			
			setUseCaseVerificationData("withdrawCash", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedAssistedWithDrawFromDashboardToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCash")) {
			for (Map<Object, Object> map : verificationData.get("withdrawCash")) {
				try {
					pauseInSeconds(3);
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "UserPassbookSuperAgentToUser");
					co.common.verifyTransactionInWebPortalForToUser(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					if (co.navigationPage.isLogoutButtonDislay(3))
						co.navigationPage.clickOnLogOut();
					
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}
	
	@Test
	public void verifyPerformedWithDrawCashtFromDashboardFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCash")) {
			/*if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(2);
				co.navigationPage.clickOnLogOut();
			}*/
			for (Map<Object, Object> map : verificationData.get("withdrawCash")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedWithDrawCashtFromDashboardFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser_NewTab(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}


	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test(dataProvider = "WithdrawCash And Agent Assisted Withdraw", dataProviderClass = TestDataImport.class)
	public void withdrawCashAndAgentAssistedWithdrawfromFooter(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "withdrawCashfromFooter");
			map.put(MethodName, "withdrawCashfromFooter");
			
			co.navigationPage.clickOnWithdrawCashFroomFooter();
			map = co.withdrawCashPage.WithdrawCashFromFooter(map);
			
			setUseCaseVerificationData("withdrawCashfromFooter", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedWithDrawCashtFromFooterFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCashfromFooter")) {
			/*if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(2);
				co.navigationPage.clickOnLogOut();
			}*/
			for (Map<Object, Object> map : verificationData.get("withdrawCashfromFooter")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedWithDrawCashtFromFooterFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser_NewTab(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test
	public void verifyPerformedAssistedWithDrawFromFooterToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCashfromFooter")) {
			for (Map<Object, Object> map : verificationData.get("withdrawCashfromFooter")) {
				try {
					pauseInSeconds(3);
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "UserPassbookSuperAgentToUserfromFooter");
					co.common.verifyTransactionInWebPortalForToUser(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					if (co.navigationPage.isLogoutButtonDislay(3))
						co.navigationPage.clickOnLogOut();
					
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}
	
	@Test(dataProvider = "WithdrawCash And Agent Assisted Withdraw", dataProviderClass = TestDataImport.class)
	public void withdrawCashAndAgentAssistedWithdrawfromSideMenu(Map<Object, Object> map) {
		try {
			
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "withdrawCashfromSideMenu");
			map.put(MethodName, "withdrawCashfromSideMenu");
			
			co.navigationPage.clickOnWithdrawCashFromSideMenu();
			map = co.withdrawCashPage.WithdrawCashFromSideMenu(map);
			
			setUseCaseVerificationData("withdrawCashfromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedWithDrawCashtFromSideMenuFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCashfromSideMenu")) {
			/*if (co.navigationPage.isLogoutButtonDislay(3)) {
				pauseInSeconds(2);
				co.navigationPage.clickOnLogOut();
			}*/
			for (Map<Object, Object> map : verificationData.get("withdrawCashfromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedWithDrawCashtFromSideMenuFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser_NewTab(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}

	@Test
	public void verifyPerformedAssistedWithDrawFromSideMenuToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "withdrawCashfromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("withdrawCashfromSideMenu")) {
				try {
					pauseInSeconds(3);
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "UserPassbookSuperAgentToUserFromSideMenu");
					co.common.verifyTransactionInWebPortalForToUser(map, co.dashboardPage);
					setSuccessParameters(co.datamap);
				} catch (Exception e) {
					setExceptionData(co, e);
				} finally {
					setExcecutionData(co);
					if (co.navigationPage.isLogoutButtonDislay(3))
						co.navigationPage.clickOnLogOut();
					
				}
			}
		} else {
			throw new RuntimeException("verification failed, due to operation failed");
		}
	}
}
