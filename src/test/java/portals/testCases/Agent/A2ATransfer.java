package portals.testCases.Agent;

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

public class A2ATransfer extends SetupInit {
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

	@Test(dataProvider = "A2ATransfer", dataProviderClass = TestDataImport.class)
	public void a2aTranfer(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "a2aTranfer");
			map.put(MethodName, "a2aTransfer");
			co.navigationPage.clickOnA2ATransfer();
			map = co.subAgent_AgentTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("a2aTranfer", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}
	
	@Test(dataProvider = "A2ATransfer", dataProviderClass = TestDataImport.class)
	public void verifya2aTranfercurrencytypes (Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "a2aTranfer");
			map.put(MethodName, "a2aTransfer");
			co.navigationPage.clickOnA2ATransfer();
			map = co.a2aTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("a2aTranfer", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test(dataProvider = "AgentAssistedDeposit", dataProviderClass = TestDataImport.class)
	public void AgentAssistedDeposit(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "AgentAssistedDeposit");
			map.put(MethodName, "AgentAssistedDeposit");
			co.navigationPage.clickOnAgentAssistedDeposit();
			map = co.a2aTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("AgentAssistedDeposit", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
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
	public void verifyPerformedA2ATranferFromFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTranfer")) {
			for (Map<Object, Object> map : verificationData.get("a2aTranfer")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATranferFromFromUserPassbook");
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
	public void verifyPerformedA2ATransferFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTranfer")) {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				co.navigationPage.clickOnLogOut();
			}
			for (Map<Object, Object> map : verificationData.get("a2aTranfer")) {
				co.loginPage.login(map.get(ToUserName).toString(), map.get(ToPassword).toString(), "sub agent");
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATranferFromToUserPassbook");
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


	@Test(dataProvider = "A2ATransfer", dataProviderClass = TestDataImport.class)
	public void a2aTransferFromSideMenu(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "a2aTransferFromSideMenu");
			map.put(MethodName, "a2aTransfer");
			co.navigationPage.clickOnSideMenuA2ATransfer();
			map = co.a2aTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("a2aTransferFromSideMenu", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedA2ATransferFromSideMenuFromUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTransferFromSideMenu")) {
			for (Map<Object, Object> map : verificationData.get("a2aTransferFromSideMenu")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATransferFromSideMenuFromUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
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
	public void verifyPerformedA2ATransferFromSideMenuFromToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTransferFromSideMenu")) {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				co.navigationPage.clickOnLogOut();
			}
			for (Map<Object, Object> map : verificationData.get("a2aTransferFromSideMenu")) {
				co.loginPage.login(map.get(ToUserName).toString(), map.get(ToPassword).toString(), "sub agent");
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATransferFromSideMenuFromToUserPassbook");
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


	@Test(dataProvider = "A2ATransfer", dataProviderClass = TestDataImport.class)
	public void a2aTranferFromFooter(Map<Object, Object> map) {
		try {
			co.datamap.putAll(map);
			setTestParameters(co.datamap, "a2aTranferFromFooter");
			map.put(MethodName, "a2aTransfer");
			co.navigationPage.clickOnFooterOptionA2ATransfer();
			map = co.a2aTransferPage.a2aTransfer(map);
			setUseCaseVerificationData("a2aTranferFromFooter", verificationData, map);
			setSuccessParameters(co.datamap);
			writeVerificationFile(Utility.getJsonStringFromMap(map));
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			setExcecutionData(co);
		}
	}

	@Test
	public void verifyPerformedA2ATranferFromFootertoUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTranferFromFooter")) {
			for (Map<Object, Object> map : verificationData.get("a2aTranferFromFooter")) {
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATranferFromFootertoUserPassbook");
					co.common.verifyTransactionInWebPortalForFromUser(map, co.dashboardPage);
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
	public void verifyPerformedA2ATransferFromFootertoToUserPassbook() {
		if (verifyMethodIsAvail(verificationData, "a2aTranferFromFooter")) {
			if (co.navigationPage.isLogoutButtonDislay(3)) {
				co.navigationPage.clickOnLogOut();
			}
			for (Map<Object, Object> map : verificationData.get("a2aTranferFromFooter")) {
				co.loginPage.login(map.get(ToUserName).toString(), map.get(ToPassword).toString(), "sub agent");
				try {
					co.datamap.putAll(map);
					setTestParameters(co.datamap, "verifyPerformedA2ATransferFromFootertoToUserPassbook");
					co.common.verifyTransactionInWebPortalForToUser(map, co.dashboardPage);
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
	public void CheckBalanceFormDashboard() {
		try {
	
			Check_Balance = co.a2aTransferPage.clickOnCheckBalance(); 
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			
		}
	}
	
	
	
	@Test
	public void CheckCommissionBalanceFormDashboard() {
		try {
	
			Check_CommissionBalance = co.a2aTransferPage.clickOnCheckCommissionBalance(); 
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			
		}
	}

	@Test
	public void CheckBalanceFormProfile() {
		try {
			co.navigationPage.clickOnSideMenu();
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			Check_Balance_Profile = co.a2aTransferPage.clickOnCheckBalanceFromProfile();
			co.navigationPage.Verifybalance(Check_Balance,Check_Balance_Profile);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			
		}
	}
		
		
		
	@Test
	public void CheckCommissionBalanceFormProfile() {
		try {
			co.navigationPage.clickOnSideMenu();
			co.navigationPage.clickOnSideMenuProfile();
			co.navigationPage.clickOnSideMenuProfileViewProfile();
			CommissionBalance_Profile = co.a2aTransferPage.clickOnCheckCommissionBalanceFromProfile();
			co.navigationPage.Verifybalance(Check_CommissionBalance,CommissionBalance_Profile);
		} catch (Exception e) {
			setExceptionData(co, e);
		} finally {
			
		}

	
	}

}
