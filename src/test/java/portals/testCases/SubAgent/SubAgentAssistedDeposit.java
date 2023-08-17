package portals.testCases.SubAgent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateObject;
import base.SetupInit;
import dataProvider.TestDataImport;
import portals.operations.Common.DashBoardPageOperations;
import utils.Utility;

public class SubAgentAssistedDeposit extends SetupInit {
	protected CreateObject co;
	Map<String, ArrayList<Map<Object, Object>>> verificationData = new LinkedHashMap<>();
	public static double Check_Balance;
	public static double Check_Balance_Profile;
	public static double Check_CommissionBalance;
	public static double CommissionBalance_Profile;

	@BeforeMethod
	public void beforeMethod() {
		co = new CreateObject(getDriver());

	}

	@Test(dataProvider = "AgentAssistedDeposit", dataProviderClass = TestDataImport.class)
	public void AgentAssistedDeposits(Map<Object, Object> map) {

		try {
			co.datamap.putAll(map);
			co.common.webPortalLogin(map, "from", 0);
			setTestParameters(co.datamap, "AgentAssistedDeposit");
			map.put(MethodName, "AgentAssistedDeposit");
			co.navigationPage.clickOnAgentAssistedDeposit();
			map = co.subAgent_AgentTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("AgentAssistedDeposit", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
			if (co.navigationPage.isLogoutButtonDislay(3))
				co.navigationPage.clickOnLogOut();
		}

	}

	@Test
	public void verifyPerformedAgentAssistedDepositFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "AgentAssistedDeposit")) {
			for (Map<Object, Object> map : verificationData.get("AgentAssistedDeposit")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedAgentAssistedDepositFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
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
	public void verifyPerformedAgentAssistedDepositFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "AgentAssistedDeposit")) {
			for (Map<Object, Object> map : verificationData.get("AgentAssistedDeposit")) {
				co.common.webPortalLogin(map, "to", 0);
				co.datamap.putAll(map);
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedAgentAssistedDepositFromUserPassbook");
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

	@Test(dataProvider = "AgentAssistedDeposit", dataProviderClass = TestDataImport.class)
	public void AgentAssistedDepositsDashboardIcon(Map<Object, Object> map) {

		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "AgentAssistedDepositIcon");
			map.put(MethodName, "AgentAssistedDepositIcon");
			co.navigationPage.clickOnAgentAssistedDepositIcon();
			map = co.subAgent_AgentTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("AgentAssistedDepositIcon", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}

	}

	@Test
	public void verifyPerformedAgentAssistedDepositFromUserPassbookIcon() {
		if (verifyMethodIsAvail(verificationData, "AgentAssistedDepositIcon")) {
			for (Map<Object, Object> map : verificationData.get("AgentAssistedDepositIcon")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedAgentAssistedDepositFromUserPassbookIcon");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
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
	public void verifyPerformedAgentAssistedDepositFromToUserPassbookIcon() {
		if (verifyMethodIsAvail(verificationData, "AgentAssistedDepositIcon")) {
			for (Map<Object, Object> map : verificationData.get("AgentAssistedDepositIcon")) {
				co.common.webPortalLogin(map, "to", 0);
				co.datamap.putAll(map);
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedAgentAssistedDepositFromToUserPassbookIcon");
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

	@Test(dataProvider = "AgentAssistedDeposit", dataProviderClass = TestDataImport.class)
	public void AgentAssistedDepositsDashboardFromFooter(Map<Object, Object> map) {

		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "AgentAssistedDepositFromFooter");
			map.put(MethodName, "AgentAssistedDepositFromFooter");
			co.navigationPage.clickOnAgentAssistedDepositFromFooter();
			map = co.subAgent_AgentTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("AgentAssistedDepositFromFooter", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}

	}

	@Test
	public void verifyPerformedAgentAssistedDepositFromUserPassbookFromFooter() {
		if (verifyMethodIsAvail(verificationData, "AgentAssistedDepositFromFooter")) {
			for (Map<Object, Object> map : verificationData.get("AgentAssistedDepositFromFooter")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedAgentAssistedDepositFromUserPassbookIconFromFooter");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
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
	public void verifyPerformedAgentAssistedDepositFromToUserPassbookFromFooter() {
		if (verifyMethodIsAvail(verificationData, "AgentAssistedDepositFromFooter")) {
			for (Map<Object, Object> map : verificationData.get("AgentAssistedDepositFromFooter")) {
				co.common.webPortalLogin(map, "to", 0);
				co.datamap.putAll(map);
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap,
							"verifyPerformedAgentAssistedDepositFromToUserPassbookIconFromFooter");
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

	@Test(dataProvider = "AgentAssistedDeposit", dataProviderClass = TestDataImport.class)
	public void AgentAssistedDepositsDashboardFromSideMenu(Map<Object, Object> map) {

		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "AgentAssistedDepositFromSideMenu");
			map.put(MethodName, "AgentAssistedDepositFromSideMenu");
			co.navigationPage.clickOnAgentAssistedDepositFromFooter();
			map = co.subAgent_AgentTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("AgentAssistedDepositFromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}

	}

	@Test
	public void verifyPerformedAgentAssistedDepositFromUserPassbookSideMenu() {
		if (verifyMethodIsAvail(verificationData, "AgentAssistedDepositFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("AgentAssistedDepositFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedAgentAssistedDepositFromUserPassbookSideMenu");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
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
	public void verifyPerformedAgentAssistedDepositFromToUserPassbookSideMenu() {
		if (verifyMethodIsAvail(verificationData, "AgentAssistedDepositFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("AgentAssistedDepositFromSideMenu")) {
				co.common.webPortalLogin(map, "to", 0);
				co.datamap.putAll(map);
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedAgentAssistedDepositFromToUserPassbookSideMenu");
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
