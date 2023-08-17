package portals.operations.Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.CommonConstants;
import base.SetupInit;
import portals.pages.Common.DashboardPage;
import portals.pages.Common.LoginPage;
import utils.ExcelUtility;
import utils.Utility;
import utils.xmlUtils;
import utils.elasticUtils.elasticwrite;

public class CommonOperations extends SetupInit {
	By btnSubmit = By.xpath("//button[text()='Submit']");
	By btnCancel = By.xpath("//button[text()='Cancel']");
	public By verifyLogo = By.xpath("//*[@class='logo-main']");
	By verifyPasswordPolicyTitle = By.xpath("(//*[text()='Password Policy'])[1]");
	By verifyPasswordPolicyText1 = By.xpath("(//*[text()='Password must have minimum 8 characters.'])");
	By verifyPasswordPolicyText2 = By.xpath("(//*[text()='Password must have maximum 18 characters.'])");
	By verifyPasswordPolicyText3 = By.xpath("(//*[text()='Password must have at least one lower case alphabet.'])");
	By verifyPasswordPolicyText4 = By.xpath("(//*[text()='Password must have at least one upper case alphabet.'])");
	By verifyPasswordPolicyText5 = By.xpath("(//*[text()='Password must have at least one numeric.'])");
	By verifyPasswordPolicyText6 = By.xpath("(//*[text()='Password must have at least one special characters.'])");
	By verifyPasswordPolicyText7 = By.xpath("(//*[text()='List of special character allowed are @,$,#,*,&'])");
	By verifyPasswordPolicyText8 = By.xpath("//*[text()='Password Example']");

	String verifyUser = "(//*[text()='%s'])[last()]";
	By merchant = By.xpath("//*[text()='Merchant']");
	By branch = By.xpath("//*[text()='Branch']");
	By teller = By.xpath("//*[text()='Teller']");
	By agent = By.xpath("//*[text()='Agent']");
	By superAgent = By.xpath("//*[text()='Super Agent']");
	By report = By.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Report']");
	By agentReport = By.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Agent']");
	By customer = By.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Customer']");
	By merchantReport = By.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Merchant']");
	By agentTransactionDetails = By.xpath("//ul[contains(@id,'Agent')]//*[@id='Transaction Details']");
	By customerTransactionDetails = By.xpath("//ul[contains(@id,'Customer')]//*[@id='Transaction Details']");
	By merchantTransactionDetails = By.id("Transaction Details Merchant");
	By txtTransactionID = By.id("TRANSACTION_ID");
	By btnSearch = By.id("searchbutton");
	String verifyTransaction = "//td[normalize-space(text())='%s']";
	By drpTransacionIDArrow = By.xpath("//div[contains(@id,'TRANSACTION_ID')]//span[contains(@class,'arrow')]");
	By contains = By.xpath("//li[text()='Contains']");
	By reportHeader = By.xpath("//th");
	By reportFirstRow = By.xpath("//tr[1]//td");
	By transactionInternalServiceDetailReport = By.id("Transaction Internal Service Detail");
	By clickOnUserDetailIcon = By.xpath("//*[contains(@class,'anticon anticon-user')]");
	By clickOnLogout = By.xpath("//*[contains(@class,'icmn-exit')]");
	Comparator<Entry<String, Integer>> descComparator=new Comparator<Entry<String,Integer>>(){@Override public int compare(Entry<String,Integer>a,Entry<String,Integer>b){int compareWordCount=a.getValue().compareTo(b.getValue());if(compareWordCount==0)return b.getKey().compareToIgnoreCase(a.getKey());return compareWordCount;}};

	Comparator<Entry<String, Integer>> ascComparator=new Comparator<Entry<String,Integer>>(){@Override public int compare(Entry<String,Integer>a,Entry<String,Integer>b){int compareWordCount=a.getValue().compareTo(b.getValue());if(compareWordCount==0)return a.getKey().compareToIgnoreCase(b.getKey());return compareWordCount;}};
	elasticwrite log;
	LoginPage loginPage;
	NavigationPageOperations navigationPageOperations;

	public CommonOperations(WebDriver driver, elasticwrite log) {
		this.log = log;
		this.driver = driver;
		loginPage = new LoginPage(driver, log);
		navigationPageOperations = new NavigationPageOperations(driver, log);
	}

	public void clickOnSubmitButton(int... args) {
		clickOnElement(this.log, btnSubmit, args);
	}

	public String getUIText(By element) {
		return findPresentElement(element).getText().trim();
	}

	public void clearDownloadsDirectory() {
		File dir = new File(CommonConstants.downloadPath);
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			files[i].delete();
		}
	}

	public boolean verifyFileExist() {
		boolean flag = false;
		File dir = new File(CommonConstants.downloadPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}
		for (int i = 0; i < files.length; i++) {
			System.out.println("Downloaded File Name : " + files[i].getName());
			System.out.println("Downloaded File Size : " + files[i].length());
			if (files[i].length() > 0 && files[i].exists()) {
				return true;
			}
		}
		return flag;
	}

	public boolean verifyFileExistandExtension(String fileExtesion) {
		boolean flag = false;
		File dir = new File(CommonConstants.downloadPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}
		for (int i = 0; i < files.length; i++) {
			System.out.println("Downloaded File Name : " + files[i].getName());
			System.out.println("Downloaded File Size : " + files[i].length());
			String downloadFileExtension = FilenameUtils.getExtension(files[i].getName());
			if (files[i].length() > 0 && files[i].exists() && downloadFileExtension.equals(fileExtesion)) {
				return true;
			}
		}
		return flag;
	}

	public boolean verifyDownloadedFileWithExtension(String fileNameWithExtension) {
		boolean flag = false;
		File dir = new File(CommonConstants.downloadPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}
		System.out.println("Current FileName : " + fileNameWithExtension);
		String currentFileName = FilenameUtils.getBaseName(fileNameWithExtension);
		String currentFileExtension = FilenameUtils.getExtension(fileNameWithExtension);
		for (int i = 0; i < files.length; i++) {
			System.out.println("Downloaded File Name : " + files[i].getName());
			System.out.println("Downloaded File Size : " + files[i].length());
			String downloadFileExtension = FilenameUtils.getExtension(files[i].getName());
			String downloadFileName = FilenameUtils.getBaseName(files[i].getName());
			if (downloadFileName.startsWith(currentFileName) && downloadFileExtension.equals(currentFileExtension)
					&& files[i].length() > 0) {
				return true;
			}
		}
		return flag;
	}

	public void webPortalLogin(Map<Object, Object> map, String userType, int... args) {
		String portalName = null;
		String user = null;
		String pass = null;
		String portalUserType = null;
		if (userType.toLowerCase().equals("from")) {
			portalName = map.get(FromPortalName).toString();
			user = map.get(FromUserName).toString();
			pass = map.get(FromPassword).toString();
			portalUserType = map.get(FromUserType).toString();
		} else if (userType.toLowerCase().equals("to")) {
			portalName = map.get(ToPortalName).toString();
			user = map.get(ToUserName).toString();
			pass = map.get(ToPassword).toString();
			portalUserType = map.get(ToUserType).toString();
		} else if (userType.toLowerCase().equals("approver")) {
			portalName = map.get(ApproverPortalName).toString();
			user = map.get(ApproverUserName).toString();
			pass = map.get(ApproverPassword).toString();
			portalUserType = map.get(ApproverUserType).toString();
		}
		if (!verifyVisible(By.xpath(String.format(verifyUser, user)), 3)) {
			navigationPageOperations.clickOnLogOut(3);
			portalLogin(portalName, user, pass, portalUserType, args);
		}
	}

	public void webPortalLoginforNewTab(Map<Object, Object> map, String userType, int... args) {
		String portalName = null;
		String user = null;
		String pass = null;
		String portalUserType = null;
		if (userType.toLowerCase().equals("from")) {
			portalName = map.get(FromPortalName).toString();
			user = map.get(FromUserName).toString();
			pass = map.get(FromPassword).toString();
			portalUserType = map.get(FromUserType).toString();
		} else if (userType.toLowerCase().equals("to")) {
			portalName = map.get(ToPortalName).toString();
			user = map.get(ToUserName).toString();
			pass = map.get(ToPassword).toString();
			portalUserType = map.get(ToUserType).toString();
		} else if (userType.toLowerCase().equals("approver")) {
			portalName = map.get(ApproverPortalName).toString();
			user = map.get(ApproverUserName).toString();
			pass = map.get(ApproverPassword).toString();
			portalUserType = map.get(ApproverUserType).toString();
		}
		if (!verifyVisible(By.xpath(String.format(verifyUser, user)), 3)) {
			portalLogin(portalName, user, pass, portalUserType, args);
		}
	}

	public void portalLogin(String portalName, String user, String pass, String portalUserType, int... args) {
		String url = getportalURL(env, portalName);
		getDriver().get(url);
		loginPage.login(user, pass, portalUserType);
	}

	public void adminLogin(String env) {
		switch (env.toLowerCase().trim()) {
		case "qa":
			testUrl = xmlUtils.getChildNodeValue(configFilePath, "URL", "AdminQAUrl");
			userName = xmlUtils.getChildNodeValue(configFilePath, "QA", "AdminUser");
			password = xmlUtils.getChildNodeValue(configFilePath, "QA", "AdminPassword");
			break;
		case "dev":
			testUrl = xmlUtils.getChildNodeValue(configFilePath, "URL", "AdminDEVUrl");
			userName = xmlUtils.getChildNodeValue(configFilePath, "DEV", "AdminUser");
			password = xmlUtils.getChildNodeValue(configFilePath, "DEV", "AdminPassword");
			break;
		case "uat":
			testUrl = xmlUtils.getChildNodeValue(configFilePath, "URL", "AdminUATUrl");
			userName = xmlUtils.getChildNodeValue(configFilePath, "UAT", "AdminUser");
			password = xmlUtils.getChildNodeValue(configFilePath, "UAT", "AdminPassword");
			break;
		default:
			throw new RuntimeException("irrelevant configuration found");
		}
		getDriver().get(testUrl);
		loginPage = new LoginPage(this.driver);
		setLogSteps(log, "Login in Admin");
		loginPage.adminLogin(userName, password);
	}

	public void navigateToReport(String userType, int... args) {
		clickOnReport(args);
		if (userType.equalsIgnoreCase("agent")) {
			clickOnAgentTransactionDetailReport(args);
		} else if (userType.equalsIgnoreCase("customer")) {
			clickOnCustomerTransactionDetailReport(args);
		} else if (userType.equalsIgnoreCase("merchant")) {
			clickOnMerchantTransactionDetailReport(args);
		}
	}

	public void clickOnReport(int... args) {
		clickOnElement(log, report, args);
		setLogSteps(log, "Click On <b style='color:#02563d'>Report</b> Menu");
	}

	public void clickOnAgent(int... args) {
		clickOnElement(log, agentReport, args);
		setLogSteps(log, "Click On <b style='color:#02563d'>Agent</b>");
	}

	public void clickOnCustomer(int... args) {
		clickOnElement(log, customer, args);
		setLogSteps(log, "Click On <b style='color:#02563d'>Customer</b>");
	}

	public void clickOnMerchant(int... args) {
		clickOnElement(log, merchantReport, args);
		setLogSteps(log, "Click On <b style='color:#02563d'>Merchant</b>");
	}

	public void clickOnAgentTransactionDetailReport(int... args) {
		clickOnAgent(args);
		clickOnElement(log, agentTransactionDetails, args);
		setLogSteps(log, "Click On <b style='color:#02563d'>Transaction Details</b>");
	}

	public void clickOnCustomerTransactionDetailReport(int... args) {
		clickOnCustomer(args);
		clickOnElement(log, customerTransactionDetails, args);
		setLogSteps(log, "Click On <b style='color:#02563d'>Transaction Details</b>");
	}

	public void clickOnMerchantTransactionDetailReport(int... args) {
		clickOnMerchant(args);
		clickOnElement(log, merchantTransactionDetails, args);
		setLogSteps(log, "Click On <b style='color:#02563d'>Transaction Details Merchant</b>");
	}

	public void enterTransactionID(String transactionID, int... args) {
		sendKeys(log, txtTransactionID, transactionID, args);
		setLogSteps(log, "Enter Transaction ID : <b style='color:#02563d'>" + transactionID + "</b>");
	}

	public void clickOnSearchButton(int... args) {
		clickOnElement(log, btnSearch, args);
		setLogSteps(log, "Click On <b style='color:#02563d'>Search</b> Button");
	}

	public void verifyTransaction(String userType, String transactionID, int... args) {
		navigateToReport(userType, args);
		selectContains(args);
		enterTransactionID(transactionID.split("_")[1], args);
		clickOnSearchButton(args);
		verifyVisible(By.xpath(String.format(verifyTransaction, transactionID.trim())), args);
		setLogSteps(log, "<b style='color:#02563d'>Transaction ID : " + transactionID + " Is Present</b>");
	}

	public void generateTransactionCalculationFile(String transactionID, String fileName) {
		Map<Object, Object> transactionDetailMap = getTransactionDetails(transactionID);
		setReportDataInTransactionCalculator(transactionDetailMap, transactionID, fileName);
	}

	public void selectContains(int... args) {
		clickOnElement(log, drpTransacionIDArrow, args);
		setLogSteps(log, "Click On <b style='color:#02563d'>Transaction Id Dropdown</b>");
		clickOnElement(log, contains, args);
		setLogSteps(log, "Click On <b style='color:#02563d'>Contains</b>");
	}

	public Map<Object, Object> getReportDetail() {
		Map<Object, Object> map = new LinkedHashMap<Object, Object>();
		List<WebElement> elements = getElementList(reportHeader, 0);
		List<WebElement> details = getElementList(reportFirstRow, 0);
		for (int i = 0; i < elements.size(); i++) {
			map.put(getElementText(elements.get(i), 0), getElementText(details.get(i), 0));
		}
		return map;
	}

	public Map<Object, Object> getTransactionDetails(String transactionID, int... args) {
		clickOnReport(args);
		clickOnTransactionInternalServiceDetailReport(args);
		selectContains(args);
		enterTransactionID(transactionID.split("_")[1], args);
		clickOnSearchButton(args);
		return getReportDetail();
	}

	public void clickOnTransactionInternalServiceDetailReport(int... args) {
		clickOnElement(log, transactionInternalServiceDetailReport, args);
		setLogSteps(log, "Click On <b style='color:#02563d'>Transaction Internal Service Detail</b>");
	}

	public void adminLogOut() {
		try {
			clickOnElement(clickOnUserDetailIcon);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "user detail");
		}
		try {
			clickOnElement(clickOnLogout);
		} catch (Exception e) {
			throw new RuntimeException(CLICK_ERROR_MESSAGE + "logout");
		}
		setLogSteps(log, "Click On Logout");
	}

	public void setReportDataInTransactionCalculator(Map<Object, Object> transactionDetailMap, String transactionId,
			String fileName) {
		ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 14, 1,
				transactionDetailMap.get("Transaction Amount").toString());
		ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 14, 2,
				transactionDetailMap.get("From Surcharge").toString());
		ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 14, 4,
				transactionDetailMap.get("From Commission").toString());
		ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 14, 6,
				transactionDetailMap.get("To Surcharge").toString());
		ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 14, 8,
				transactionDetailMap.get("To Commission").toString());
		verifyTransactionCalculator(fileName);
	}

	public void verifyTransactionCalculator(String fileName) {
		String message = "";
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 13, 1)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 14, 1))) {
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 1, "Fail");
			message = "Transaction Amount Mis-match...";
		} else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 1, "Pass");
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 13, 2)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 14, 2))) {
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 2, "Fail");
			message = "From Surcharge Mis-match...";
		} else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 2, "Pass");
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 13, 4)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 14, 4))) {
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 4, "Fail");
			message = "From Commission Mis-match...";
		} else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 4, "Pass");
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 13, 6)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 14, 6))) {
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 6, "Fail");
			message = "To Surcharge Mis-match...";
		} else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 6, "Pass");
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 13, 8)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 14, 8))) {
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 8, "Fail");
			message = "To Commission Mis-match...";
		} else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 8, "Pass");
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 1, 4)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 2, 4))) {
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 3, 4, "Fail");
			message = "Closing Balance Mis-match...";
		} else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 3, 4, "Pass");
		if (!message.isEmpty())
			throw new RuntimeException(message);
	}

	public void verifyTransactionInAdmin() {
		adminLogin(env);
		// if (!map.get(ToUserType).toString().replaceAll("\\s",
		// "").equalsIgnoreCase("enterprise")
		// && !map.get(ToUserType).toString().replaceAll("\\s",
		// "").equalsIgnoreCase("trustaccount")) {
		// verifyTransaction(map.get(ToPortalName).toString(), transactionId, 0);
		// setLogSteps(log, "Search Transaction from Filter Search");
		// generateTransactionCalculationFile(transactionId,
		// map.get(TransactionFile).toString());
		// }
		// setLogSteps(log, "Successfully Transaction verify in Admin");
		// adminLogOut();

		FileReader fr;
		Map<String, Boolean> status = new LinkedHashMap<String, Boolean>();
		try {
			fr = new FileReader(verificationDataFileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				Map<Object, Object> map = Utility.getMapFromJsonString(line);
				try {
					verifyTransaction(map.get(FromPortalName).toString(), map.get(TransactionID).toString(), 0);
					setLogSteps(log, "<b style='color:#02563d'>" + map.get(TransactionID).toString()
							+ " Is Successfully Verified In Admin For From User...</b>");
					status.put(map.get(MethodName).toString() + "For From User", true);
				} catch (Exception e) {
					status.put(map.get(MethodName).toString() + "For From User", false);
					setLogSteps(log, "<b style='color:#e63900'>" + map.get(TransactionID).toString()
							+ " Verification Failed In Admin For From User...</b>");
				}
				try {
					if (map.get(FromPortalName).toString().equalsIgnoreCase(map.get(ToPortalName).toString())) {
						setLogSteps(log, "<b style='color:#02563d'>" + map.get(TransactionID).toString()
								+ " Is not Verified</b>");
					} else {
						if (!map.get(ToUserType).toString().replaceAll("\\s", "").equalsIgnoreCase("enterprise") && !map
								.get(ToUserType).toString().replaceAll("\\s", "").equalsIgnoreCase("trustaccount")) {
							verifyTransaction(map.get(ToPortalName).toString(), map.get(TransactionID).toString(), 0);
							setLogSteps(log, "<b style='color:#02563d'>" + map.get(TransactionID).toString()
									+ " Is Successfully Verified In Admin For To User...</b>");
						} else {
							setLogSteps(log, "<b style='color:#02563d'>" + map.get(TransactionID).toString()
									+ " Is not Verified</b>");
						}
						status.put(map.get(MethodName).toString() + "For To User", true);
					}
				} catch (Exception e) {
					status.put(map.get(MethodName).toString() + "For To User", false);
					setLogSteps(log, "<b style='color:#e63900'>" + map.get(TransactionID).toString()
							+ " Verification Failed In Admin For To User...</b>");
				}
				try {
					generateTransactionCalculationFile(map.get(TransactionID).toString(),
							map.get(TransactionFile).toString());
				} catch (Exception e) {
					setLogSteps(log, "<b style='color:#e63900'>" + map.get(TransactionID).toString()
							+ " Is Failed Due To " + e.toString() + "</b>");
				}
				log("=====================================================================================================");
				line = br.readLine();
			}
			br.close();
			for (Map.Entry<String, Boolean> m : status.entrySet()) {
				if (m.getValue() == false)
					throw new RuntimeException(m.getKey() + "verification failed in admin");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void verifyTransactionInWebPortalForToUser(Map<Object, Object> map, DashboardPage dashBoardPageOperations) {
		if (!map.get(ToUserType).toString().replaceAll("\\s", "").equalsIgnoreCase("ta")
				&& !map.get(ToUserType).toString().replaceAll("\\s", "").equalsIgnoreCase("trustaccount")) {
			webPortalLogin(map, "to", 0);
			dashBoardPageOperations.passbookVerification("", map.get(TransactionID).toString());
			setLogSteps(log, "Successfully Transaction verify in To User");
		}
	}

	public void verifyTransactionInWebPortalForFromUser(Map<Object, Object> map,
			DashboardPage dashBoardPageOperations) {
		webPortalLogin(map, "from", 0);
		dashBoardPageOperations.passbookVerification(map.get(ServiceName).toString(),
				map.get(TransactionID).toString());
		setLogSteps(log, "Successfully Transaction verify in From User");
	}

	public void verifyTransactionInWebPortalForToUserTangereine(Map<Object, Object> map,
			DashboardPage dashBoardPageOperations) {
		if (!map.get(ToUserType).toString().replaceAll("\\s", "").equalsIgnoreCase("ta")
				&& !map.get(ToUserType).toString().replaceAll("\\s", "").equalsIgnoreCase("trustaccount")) {

			webPortalLogin(map, "to", 0);

			dashBoardPageOperations.passbookVerification(map.get(ServiceName).toString(),
					map.get(TransactionID).toString());
			clickOnElement(By.xpath("//*[normalize-space(text())='" + map.get(TransactionID).toString() + "']"), 0);
			setLogSteps(log, "Clicked on transaction ID:" + map.get(TransactionID).toString());
			//verifyVisible(By.xpath("//*[normalize-space(text())='" + map.get(TransactionID).toString() + "']"), 0);
			if (map.get(FromUserName).toString().startsWith("0")) {
				String fromuname = map.get(FromUserName).toString().replace("0", "256");
				String touname = map.get(ToUserName).toString().replace("0", "256");
				verifyVisible(By.xpath("(//*[contains(text(),'Wallet ID')])[1]//parent::*//parent::p[contains(text(),'"+fromuname+"')]"), 0);
				setLogSteps(log, "From User verified sucessfully in passbook.");
				verifyVisible(By.xpath("(//*[contains(text(),'Wallet ID')])[2]//parent::*//parent::p[contains(text(),'"+touname+"')]"), 0);
				setLogSteps(log, "To User verified sucessfully in passbook.");
			} else {
				
				String fromuname = getElementText(log, By.xpath("(//*[contains(text(),'Wallet ID')])[1]//parent::*//parent::p//text()[2]"), 0);
				if(fromuname.equalsIgnoreCase(map.get(FromUserName).toString())) {
					setLogSteps(log, "From User verified sucessfully in passbook.");
				}
				
				//verifyVisible(By.xpath("(//*[contains(text(),'Wallet ID')])[1]//parent::*//parent::p[contains(text(),'"+map.get(FromUserName)+"')]"), 0);
				
				verifyVisible(By.xpath("(//*[contains(text(),'Wallet ID')])[2]//parent::*//parent::p[contains(text(),'"+map.get(ToUserName)+"')]"), 0);
				setLogSteps(log, "To User verified sucessfully in passbook.");
			}
		}
		setLogSteps(log, "Successfully Transaction verify in To User");

	}

	public void verifyTransactionInWebPortalForFromUserTangereine(Map<Object, Object> map,
			DashboardPage dashBoardPageOperations) {
		webPortalLogin(map, "from", 0);
		dashBoardPageOperations.passbookVerification(map.get(ServiceName).toString(),
				map.get(TransactionID).toString());
		clickOnElement(By.xpath("//*[text()='" + map.get(TransactionID).toString() + "']"), 0);
		setLogSteps(log, "Clicked on transaction ID:" + map.get(TransactionID).toString());
		verifyVisible(By.xpath("//*[text()='" + map.get(TransactionID).toString() + "']"), 0);
		if (map.get(FromUserName).toString().startsWith("0")) {
			String fromuname = map.get(FromUserName).toString().replace("0", "256");
			String touname = map.get(ToUserName).toString().replace("0", "256");
			verifyVisible(By.xpath("//*[text()='" + fromuname + "']"), 0);
			setLogSteps(log, "From User verified sucessfully in passbook.");
			verifyVisible(By.xpath("//*[contains(text(),'" + touname + "')]"), 0);
			setLogSteps(log, "To User verified sucessfully in passbook.");
		} else {
			verifyVisible(By.xpath("//*[text()='" + map.get(FromUserName).toString() + "']"), 0);
			setLogSteps(log, "From User verified sucessfully in passbook.");
			verifyVisible(By.xpath("//*[contains(text(),'" + map.get(ToUserName).toString() + "')]"), 0);
			setLogSteps(log, "To User verified sucessfully in passbook.");
		}
		setLogSteps(log, "Successfully Transaction verify in From User");

	}

	public void verifyTransactionInWebPortalForFromUser_NewTab(Map<Object, Object> map,
			DashboardPage dashBoardPageOperations) {
		webPortalLoginforNewTab(map, "from", 0);
		dashBoardPageOperations.passbookVerification(map.get(ServiceName).toString(),
				map.get(TransactionID).toString());
		setLogSteps(log, "Successfully Transaction verify in From User");
	}

	public void verifyTransactionInWebPortalForFromUserwithoutTransactionID(Map<Object, Object> map,
			DashboardPage dashBoardPageOperations) {
		webPortalLogin(map, "from", 0);
		dashBoardPageOperations.passbookVerification(map.get(ServiceName).toString(),
				map.get(TransactionID).toString());
		setLogSteps(log, "Successfully Transaction verify in From User");
	}

	public String getCurrentDate() {
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime currentDate = LocalDateTime.now();
		String date = dateformatter.format(currentDate);
		return date;
	}

	public void PasswordPolicy(int... args) {
		verifyVisible(verifyPasswordPolicyTitle, args);
		setLogSteps(log, "Verify Password Policy Title");

		verifyVisible(verifyPasswordPolicyText1, args);
		setLogSteps(log, "Verify text >>  Password must have minimum 8 characters ");
		verifyVisible(verifyPasswordPolicyText2, args);
		setLogSteps(log, "Verify text >>  Password must have maximum 18 characters ");
		verifyVisible(verifyPasswordPolicyText3, args);
		setLogSteps(log, "Verify text >>  Password must have at least one lower case alphabet ");
		verifyVisible(verifyPasswordPolicyText4, args);
		setLogSteps(log, "Verify text >>  Password must have at least one lower case alphabet ");
		verifyVisible(verifyPasswordPolicyText5, args);
		setLogSteps(log, "Verify text >>  Password must have at least one numeric ");
		verifyVisible(verifyPasswordPolicyText6, args);
		setLogSteps(log, "Verify text >> Password must have at least one special characters ");
		verifyVisible(verifyPasswordPolicyText7, args);
		setLogSteps(log, "Verify text >> List of special character allowed are @,$,#,*,& ");
		verifyVisible(verifyPasswordPolicyText8, args);
		setLogSteps(log, "Verify text >> Password Example");

	}

}
