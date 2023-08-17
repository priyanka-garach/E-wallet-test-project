package base;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import portals.pages.Common.LoginPage;
import utils.ReadProperty;
import utils.elasticUtils.LogMatrics;

public class CommonConstants {
	public static String userType;
	public static String subUserType;
	public Map<String, String> labels = new LinkedHashMap<String, String>();
	public static String configurations;
	public String suiteName;
	public static String env;
	public static String projectName = "";
	public static String projectVersion = "";
	public static String latestRelease = "";
	public String defaultPaginationValue = "50";
	static String currentDir = System.getProperty("user.dir");
	public static String elasticIndex;
	// final String elasticIndex = "";
	final String indexType = "doc";
	static final String CONFIG_FILE_NAME = ReadProperty.getPropertyValue("ConfigurationFileName");
	static final String REPORT_FOLDER = ReadProperty.getPropertyValue("REPORT_FOLDER");
	static final String SCREENSHOT_FOLDER = ReadProperty.getPropertyValue("SCREENSHOT_FOLDER");
	static final String VIDEOS_FOLDER = ReadProperty.getPropertyValue("VIDEOS_FOLDER");
	protected static final String TESTDATA_FOLDER = ReadProperty.getPropertyValue("TESTDATA_FOLDER");
	static final String RESOURCES_FOLDER = TESTDATA_FOLDER + "/" + ReadProperty.getPropertyValue("RESOURCES_FOLDER")
			+ "/";
	static final String DOWNLOADS_FOLDER = ReadProperty.getPropertyValue("DOWNLOADS_FOLDER");
//	static final String DEPENDENCIES_FOLDER = (currentDir + File.separator
//			+ ReadProperty.getPropertyValue("DEPENDENCIES_FOLDER")) + File.separator;
	static final String APPLICATIONS_FOLDER = (currentDir + File.separator
			+ ReadProperty.getPropertyValue("APPLICATIONS_FOLDER"));
	protected static String userName;
	protected static String password;
	protected static String otp;
	protected static String pin;
	boolean dataDumpInElastic;
	boolean deleteTestOutPut;
	public static String test_data_file;
	protected String screenshotName;
	public static String taskName = "NA";
	public static String automationCycle;
	static final int DEFAULT_PAUSE_INSECONDS = 2;
	protected static boolean booleanValue = false;
	Boolean failure = false;
	String reason = "None";
	String detailedFailureReason = "None";
	String stacktrace = "None";
	float ScriptExecution = 50;
	long endTime;
	long end = Long.MIN_VALUE;
	long start = Long.MAX_VALUE;
	long startMS;
	protected static int setupCounter = 0;
	protected static int taskCounter = 0;
	protected int GENERAL_TIMEOUT = 30;
	public boolean logDefectAutomated = false;
	String test_data_folder_path;
	String screenshot_folder_path;
	String resources_folder_path;
	String configuaration_folder_path;
	public static String configFilePath;
	int MAX_WAIT_TIME_IN_SEC = Integer.parseInt(ReadProperty.getPropertyValue("MAX_WAIT_TIME_IN_SEC"));
	Date testStartTime;
	public WebDriver driver;
	Wait<WebDriver> wait;
	static URL remote_grid;
	protected static int reloadCounter = 0;
	protected boolean isRemoteEnable;
	// Selenium hub IP
	protected String hubUrl;
	// Selenium hub port
	protected String hubPort;
	public static String testUrl;
	protected String targetBrowser;
	boolean recordSessionVideo = false;
	static boolean incognito;
	protected static String proxyIP;
	protected static String proxyPort;
	String regexTCID;
	String regexAuthor;
	public LoginPage loginPage;
	LogMatrics logMatrics;
	public static final int LOADER_WAIT = 180;
	public static final String FROM_USER = "from";
	public static final String TO_USER = "to";
	public static Map<String, String> accessMatricesGlobalMap = new LinkedHashMap<String, String>();
	protected static String newAccessMatricesFileName;
	protected String newTransactionFileName;
	protected static String accessMatricesSheetName = "Access Matrice";
	protected static String accessMatricesFileName;
	protected String transactionFileName;
	protected String transactionSheetName = "Transaction Template";
	public static final String APPROVER_USER = "approver";

	public enum Condition {
		isDisplayed, isClickable, isPresent, isNotVisible
	}

	protected enum Speed {
		slow
	}

	public Map<String, String> testDataFiles = new LinkedHashMap<String, String>();
	public static String downloadPath = new File(DOWNLOADS_FOLDER).getAbsolutePath();

	public static final String CLICK_ERROR_MESSAGE = "Unable to click on ";
	public static final String SEND_ERROR_MESSAGE = "Unable to enter ";
	public static final String SELECT_ERROR_MESSAGE = "Unable to select ";
	public static final String GET_TEXT_ERROR_MESSAGE = "Unable to get ";
	public static final String LOCATOR_FIND_ERROR_MESSAGE = "Unable to find ";
	public static int pass = 0;
	public static int fail = 0;
	public static int skip = 0;
	protected static int verificationCounter;
	public static String verificationDataFileName;
	protected static int accessMatricesCounter;
}
