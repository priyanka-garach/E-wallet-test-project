package dataProvider;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import base.SetupInit;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestDataImport extends SetupInit {
	private static String TEST_DATA = TESTDATA_FOLDER + File.separator + test_data_file;

	public static Object[][] readExcelFileTo2D(String filepath, String sheetname) {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(filepath));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetname);
		int lastRowNum = sheet.getRows();
		Object[][] object = new Object[lastRowNum - 1][1];
		for (int i = 1; i < lastRowNum; i++) {
			Map<Object, Object> map = new LinkedHashMap<Object, Object>();
			for (int j = 0; j < sheet.getColumns(); j++) {
				map.put(sheet.getCell(j, 0).getContents().toString().trim().replaceAll("\\s", "").toLowerCase(),
						removeExtraSpaces(sheet.getCell(j, i).getContents().toString().trim().replaceAll("\\s", " ")));
			}
			object[i - 1][0] = map;
		}
		return object;
	}

	/**
	 * @author dishant.doshi to remove extra spaces in string
	 * @param string
	 * @return string with one space
	 * @creation date 28/12/2018
	 */
	public static String removeExtraSpaces(String string) {
		return string.replaceAll("\\s+", " ");
	}

	public static int findRow(String fileName, String sheetName, String cellContent) {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(fileName));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getRows();
		for (int i = 1; i < rows; i++) {
			Cell cell = sheet.getCell(0, i);
			if (cell.getContents().toString().equals(cellContent)) {
				return i;
			}
		}
		return 0;
	}

	public static Map<Object, Object> readExcelFileTo2D(String fileName, String sheetName, int rowNumber) {
		File inputWorkbook = new File(fileName);
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(inputWorkbook);
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		Map<Object, Object> map = new LinkedHashMap<Object, Object>();
		Sheet sheet = workbook.getSheet(sheetName);
		int columns = sheet.getColumns();
		for (int j = 0; j < columns; j++) {
			map.put(sheet.getCell(j, 0).getContents().toString().trim().replaceAll("  ", " "),
					sheet.getCell(j, rowNumber).getContents().toString().trim().replaceAll("  ", " "));
		}
		return map;
	}
	

	
	@DataProvider(name = "SubAgentOnboarding")
	public static Object[][] SubAgentOnboarding() {
		return readExcelFileTo2D(TEST_DATA, "SubAgentOnboarding");
	}
	
	@DataProvider(name = "InviteFriends")
	public static Object[][] InviteFriends() {
		return readExcelFileTo2D(TEST_DATA, "InviteFriends");
	}
	
	@DataProvider(name = "LoginStartwithZero")
	public static Object[][] LoginStartwithZero() {
		return readExcelFileTo2D(TEST_DATA, "LoginStartwithZero");
	}
	
	@DataProvider(name = "CustomerOnboard")
	public static Object[][] CustomerOnboard() {
		return readExcelFileTo2D(TEST_DATA, "CustomerOnboard");
	}
	
	@DataProvider(name = "InActiveUser")
	public static Object[][] InActiveUser() {
		return readExcelFileTo2D(TEST_DATA, "InActiveUser");
	}
	
	@DataProvider(name = "ThreeWrongMPINAttempts")
	public static Object[][] ThreeWrongMPINAttempts() {
		return readExcelFileTo2D(TEST_DATA, "ThreeWrongMPINAttempts");
	}
	
	
	@DataProvider(name = "WithdrawCash")
	public static Object[][] WithdrawCashSubAgent() {
		return readExcelFileTo2D(TEST_DATA, "WithdrawCash");
	}
	
	@DataProvider(name = "WithdrawCash And Agent Assisted Withdraw")
	public static Object[][] WithdrawCash() {
		return readExcelFileTo2D(TEST_DATA, "WithdrawCash");
	}
	
	@DataProvider(name = "WithdrawCash And SubAgent Assisted Withdraw")
	public static Object[][] SubAgentAssistedWithdraw() {
		return readExcelFileTo2D(TEST_DATA, "SubAgentAssistedWithdraw");
	}

	@DataProvider(name = "ChangeMpin")
	public static Object[][] ChangeMpin() {
		return readExcelFileTo2D(TEST_DATA, "ChangeMpin");
	}
	
	@DataProvider(name = "ChangeSecretWord")
	public static Object[][] ChangeSecretWord() {
		return readExcelFileTo2D(TEST_DATA, "ChangeSecretWord");
	}
	
	@DataProvider(name = "SuperAgent_ChangeMpin")
	public static Object[][] SuperAgent_ChangeMpin() {
		return readExcelFileTo2D(TEST_DATA, "SuperAgent_ChangeMpin");
	}
	
	@DataProvider(name = "AgentAssistedDeposit")
	public static Object[][] AgentAssistedDeposit() {
		return readExcelFileTo2D(TEST_DATA, "AgentAssistedDeposit");
	}
	
	@DataProvider(name = "QRCode")
	public static Object[][] QRCode() {
		return readExcelFileTo2D(TEST_DATA, "QRCode");
	}

	@DataProvider(name = "Passbook_Filter")
	public static Object[][] Passbook_Filter() {
		return readExcelFileTo2D(TEST_DATA, "Passbook_Filter");
	}

	@DataProvider(name = "verifyProfileDetails")
	public static Object[][] verifyProfileDetails() {
		return readExcelFileTo2D(TEST_DATA, "verifyProfileDetails");
	}

	@DataProvider(name = "Profile_Edit")
	public static Object[][] Profile_Edit() {
		return readExcelFileTo2D(TEST_DATA, "Profile_Edit");
	}

	@DataProvider(name = "P2PTransfer")
	public static Object[][] MoneyTransfer() {
		return readExcelFileTo2D(TEST_DATA, "P2PTransfer");
	}
	
	@DataProvider(name = "P2POffnetTransfer")
	public static Object[][] P2POffnetTransfer() {
		return readExcelFileTo2D(TEST_DATA, "P2POffnetTransfer");
	}

	
	@DataProvider(name = "MobileTopup")
	public static Object[][] MobileTopup() {
		return readExcelFileTo2D(TEST_DATA, "MobileTopup");
	}

	@DataProvider(name = "MobilePostpaid")
	public static Object[][] MobilePostpaid() {
		return readExcelFileTo2D(TEST_DATA, "MobilePostpaid");
	}

	@DataProvider(name = "MerchantPayment")
	public static Object[][] MerchantPayment() {
		return readExcelFileTo2D(TEST_DATA, "MerchantPayment");
	}

	@DataProvider(name = "EnterprisePayment")
	public static Object[][] EnterprisePayment() {
		return readExcelFileTo2D(TEST_DATA, "EnterprisePayment");
	}

	@DataProvider(name = "ChangeLanguage")
	public static Object[][] ChangeLanguage() {
		return readExcelFileTo2D(TEST_DATA, "ChangeLanguage");
	}

	@DataProvider(name = "WithdrawMoney")
	public static Object[][] WithdrawMoney() {
		return readExcelFileTo2D(TEST_DATA, "WithdrawMoney");
	}

	@DataProvider(name = "B2BTransfer")
	public static Object[][] B2BTransfer() {
		return readExcelFileTo2D(TEST_DATA, "B2BTransfer");
	}

	@DataProvider(name = "MerchantRefund")
	public static Object[][] MerchantRefund() {
		return readExcelFileTo2D(TEST_DATA, "MerchantRefund");
	}

	@DataProvider(name = "M2MTransfer")
	public static Object[][] M2MTransfer() {
		return readExcelFileTo2D(TEST_DATA, "M2MTransfer");
	}

	@DataProvider(name = "AssistantOnboarding")
	public static Object[][] AssistantOnboarding() {
		return readExcelFileTo2D(TEST_DATA, "AssistantOnboarding");
	}

	@DataProvider(name = "ManageAssistant")
	public static Object[][] ManageAssistant() {
		return readExcelFileTo2D(TEST_DATA, "ManageAssistant");
	}

	@DataProvider(name = "A2ATransfer")
	public static Object[][] A2ATransfer() {
		return readExcelFileTo2D(TEST_DATA, "A2ATransfer");
	}

	@DataProvider(name = "AgentOnboarding")
	public static Object[][] AgentOnboarding() {
		return readExcelFileTo2D(TEST_DATA, "AgentOnboarding");
	}

	@DataProvider(name = "CashInByAgent")
	public static Object[][] CashInByAgent() {
		return readExcelFileTo2D(TEST_DATA, "CashInByAgent");
	}

	@DataProvider(name = "ManageAgent")
	public static Object[][] ManageAgent() {
		return readExcelFileTo2D(TEST_DATA, "ManageAgent");
	}

	@DataProvider(name = "CustomerOnboarding")
	public static Object[][] CustomerOnboarding() {
		return readExcelFileTo2D(TEST_DATA, "CustomerOnboarding");
	}

	@DataProvider(name = "UpdateCustomerKYC")
	public static Object[][] UpdateCustomerKYC() {
		return readExcelFileTo2D(TEST_DATA, "UpdateCustomerKYC");
	}
	
	@DataProvider(name = "TellerOnboarding")
	public static Object[][] TellerOnboarding() {
		return readExcelFileTo2D(TEST_DATA, "TellerOnboarding");
	}
	@DataProvider(name = "ManageTeller")
	public static Object[][] ManageTeller() {
		return readExcelFileTo2D(TEST_DATA, "ManageTeller");
	}
	
	@DataProvider(name = "ChangePassword")
	public static Object[][] ChangePassword() {
		return readExcelFileTo2D(TEST_DATA, "ChangePassword");
	}
}
