package base;

import static org.testng.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import portals.interfaces.GetExcelHeaders;
import portals.pages.Common.LoginPage;
import utils.ExcelUtility;
import utils.ReadProperty;
import utils.Utility;
import utils.xmlUtils;
import utils.elasticUtils.LogMatrics;
import utils.elasticUtils.elasticwrite;

public class SetupInit extends CommonConstants implements GetExcelHeaders {
	@Parameters({ "browserType" })
	@BeforeClass
	public void initializeSetupInit(@Optional String browserType, ITestContext testContext) {
		userType = System.getProperty("userType");
		subUserType = System.getProperty("subUserType");
		env = System.getProperty("environment");
		test_data_folder_path = new File(TESTDATA_FOLDER).getAbsolutePath() + File.separator;
		screenshot_folder_path = new File(SCREENSHOT_FOLDER).getAbsolutePath() + File.separator;
		resources_folder_path = new File(RESOURCES_FOLDER).getAbsolutePath() + File.separator;
		configuaration_folder_path = new File("configuration").getAbsolutePath() + File.separator;
		configFilePath = configuaration_folder_path + CONFIG_FILE_NAME;
		elasticIndex = "mobifin_5x";
		projectName = "Tangereine";
		projectVersion = "Mobifin_5.0.3";
		logMatrics = new LogMatrics(elasticIndex, indexType);
		suiteName = testContext.getCurrentXmlTest().getSuite().getName();
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
		LocalDateTime currentDate = LocalDateTime.now();
		String date = dateformatter.format(currentDate);
		dataDumpInElastic = Boolean.parseBoolean(System.getProperty("elasticDataDump"));
		deleteTestOutPut = Boolean.parseBoolean(System.getProperty("deleteTestOutPut"));
		if (dataDumpInElastic) {
			if (taskCounter == 0) {
				taskName = projectName + "_" + date;
				taskName = LogMatrics.getTaskName(taskName);
				taskCounter++;
			}
		}
		Map<Object, Object> elasticData = new LinkedHashMap<Object, Object>();
		elasticData.put("Project Name", projectName);
		elasticData.put("Task Name", taskName);
		elasticData.put("Test Start Time", System.currentTimeMillis());
		elasticData.put("Class Name", this.getClass().getName());
		screenshotName = "";
		if (browserType == null)
			this.targetBrowser = "chrome";
		else
			this.targetBrowser = browserType;
		setProjectCredential(env, userType, subUserType);
		File downloadsDirectoryName = new File(DOWNLOADS_FOLDER);
		if (!downloadsDirectoryName.exists())
			downloadsDirectoryName.mkdir();
		if (deleteTestOutPut) {
			if (setupCounter == 0) {
				Utility.removeFolder(ReadProperty.getPropertyValue("REPORT_FOLDER"));
				Utility.removeFolder("Failure_Screenshots");
				Utility.removeFolder("transaction_calculator");
				Utility.removeFolder("verificationData");
				setupCounter++;
			}
		}
		fetchSuiteConfiguration("Master");
		testStartTime = new Date();
		if (isRemoteEnable) {
			try {
				remote_grid = new URL("http://" + hubUrl + ":" + hubPort + "/wd/hub");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
		if (recordSessionVideo == true) {
			File f = new File(REPORT_FOLDER + VIDEOS_FOLDER);
			if (!f.exists())
				f.mkdirs();
		}
		String accessMatricesDir = "access_matrices";
		switch (userType.toLowerCase().replaceAll("\\s", "")) {
		case "agent":
			accessMatricesFileName = TESTDATA_FOLDER + File.separator + "access-matrices" + File.separator
					+ ReadProperty.getPropertyValue("AGENT_ACCESS_MATRICES_FILE");
			break;
		case "customer":
			accessMatricesFileName = TESTDATA_FOLDER + File.separator + "access-matrices" + File.separator
					+ ReadProperty.getPropertyValue("CUSTOMER_ACCESS_MATRICES_FILE");
			break;
		default:
			throw new RuntimeException("Unable to find access matrices file");
		}
		if (accessMatricesCounter == 0) {
			Utility.removeFolder(accessMatricesDir);
			AccessMatricesConstants.setAccessMatricesData();
			File dir = new File(accessMatricesDir);
			if (!dir.exists())
				dir.mkdir();
			if (userType.equalsIgnoreCase("Customer"))
				newAccessMatricesFileName = accessMatricesDir + File.separator + "Mobifin_Tangerine_" + userType
						+ "_Web_AccessMatrices_"
						+ Utility.getCurrentDateTime().replaceAll(":", "_").replaceAll("-", "_").replaceAll(" ", "_")
						+ ".xls";
			else
				newAccessMatricesFileName = accessMatricesDir + File.separator + "Mobifin_Tangerine_" + userType + "_"
						+ subUserType + "_Web_AccessMatrices_"
						+ Utility.getCurrentDateTime().replaceAll(":", "_").replaceAll("-", "_").replaceAll(" ", "_")
						+ ".xls";
			if (ExcelUtility.createAnExcel(newAccessMatricesFileName, accessMatricesSheetName)) {
				Utility.copyFile(accessMatricesFileName, newAccessMatricesFileName);
			}
			accessMatricesCounter++;
		}
		if (verificationCounter == 0) {
			File dir = new File("verificationData");
			if (!Boolean.parseBoolean(System.getProperty("verification")))
				Utility.removeFolder("verificationData");
			dir.mkdir();
			verificationDataFileName = dir + File.separator + Utility.getCurrentDate("yyyy_MM_dd") + ".txt";
			File file = new File(verificationDataFileName);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			verificationCounter++;
		}
		try {
			setDriver(targetBrowser);
			testContext.setAttribute("WebDriver", this.driver);
			if (testUrl != null)
				this.driver.get(testUrl);
			loginPage = new LoginPage(this.driver);
			loginPage.login(userName, password, subUserType);
//			DBUtils.getOTP(Phone);

		} catch (Exception e) {
			stacktrace = Utility.getStackStrace(e);
			Scanner sc = new Scanner(stacktrace);
			String firstLine = sc.nextLine();
			sc.close();
			elasticData.put("Failure Reason", firstLine);
			elasticData.put("Detail Failure Reason", firstLine);
			elasticData.put("Value", 50);
			if (dataDumpInElastic)
				new LogMatrics(elasticIndex, indexType).logToElasticsearch(elasticData);
		}
	}

	private void setProjectCredential(String env, String userType, String subUserType) {
		switch (env.toLowerCase().trim()) {
		case "qa":
			switch (userType.toLowerCase().replaceAll("\\s", "")) {
			case "agent":
				testUrl = xmlUtils.getChildNodeValue(configFilePath, "URL", "AgentQAUrl");
				switch (subUserType.toLowerCase().replaceAll("\\s", "")) {
				case "agent":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "QA", "AgentTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "QA", "AgentUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "QA", "AgentPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "QA", "AgentPin");
					break;
				case "superagent":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "QA", "SuperAgentTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "QA", "SuperAgentUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "QA", "SuperAgentPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "QA", "SuperAgentPin");
					break;
				case "subagent":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "QA", "SubAgentTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "QA", "SubAgentUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "QA", "SubAgentPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "QA", "SubAgentPin");
					break;
				default:
					throw new RuntimeException("irrelevant sub user type found");
				}
				break;
			case "customer":
				testUrl = xmlUtils.getChildNodeValue(configFilePath, "URL", "CustomerQAUrl");
				test_data_file = xmlUtils.getChildNodeValue(configFilePath, "QA", "CustomerTestData");
				userName = xmlUtils.getChildNodeValue(configFilePath, "QA", "CustomerUser");
				password = xmlUtils.getChildNodeValue(configFilePath, "QA", "CustomerPassword");
				break;
			default:
				throw new RuntimeException("irrelevant user type found");
			}
			break;
		case "dev":
			switch (userType.toLowerCase().replaceAll("\\s", "")) {
			case "agent":
				testUrl = xmlUtils.getChildNodeValue(configFilePath, "URL", "AgentDEVUrl");
				switch (subUserType.toLowerCase().replaceAll("\\s", "")) {
				case "agent":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "Dev", "AgentTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "Dev", "AgentUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "Dev", "AgentPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "Dev", "AgentPin");
					break;
				case "superagent":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "Dev", "SuperAgentTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "Dev", "SuperAgentUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "Dev", "SuperAgentPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "Dev", "SuperAgentPassword");
					break;
				case "subagent":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "Dev", "SubAgentTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "Dev", "SubAgentUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "Dev", "SubAgentPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "Dev", "SubAgentPin");
					break;
				default:
					throw new RuntimeException("irrelevant sub user type found");
				}
				break;
			case "customer":
				testUrl = xmlUtils.getChildNodeValue(configFilePath, "URL", "CustomerDEVUrl");
				test_data_file = xmlUtils.getChildNodeValue(configFilePath, "Dev", "CustomerTestData");
				userName = xmlUtils.getChildNodeValue(configFilePath, "Dev", "CustomerUser");
				password = xmlUtils.getChildNodeValue(configFilePath, "Dev", "CustomerPassword");
				break;
			default:
				throw new RuntimeException("irrelevant user type found");
			}
			break;
		case "uat":
			switch (userType.toLowerCase().replaceAll("\\s", "")) {
			case "agent":
				testUrl = xmlUtils.getChildNodeValue(configFilePath, "URL", "AgentUATUrl");
				switch (subUserType.toLowerCase().replaceAll("\\s", "")) {
				case "agent":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "UAT", "AgentTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "UAT", "AgentUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "UAT", "AgentPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "UAT", "AgentPin");
					break;
				case "superagent":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "UAT", "SuperAgentTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "UAT", "SuperAgentUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "UAT", "SuperAgentPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "UAT", "SuperAgentPin");
					break;
				case "subagent":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "UAT", "SubAgentTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "UAT", "SubAgentUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "UAT", "SubAgentPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "UAT", "SubAgentPin");
					break;
				default:
					throw new RuntimeException("irrelevant sub user type found");
				}
				break;
			case "merchant":
				testUrl = xmlUtils.getChildNodeValue(configFilePath, "URL", "MerchantUATUrl");
				switch (subUserType.toLowerCase().replaceAll("\\s", "")) {
				case "merchant":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "UAT", "MerchantTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "UAT", "MerchantUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "UAT", "MerchantPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "UAT", "MerchantPin");
					break;
				case "branch":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "UAT", "BranchTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "UAT", "BranchUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "UAT", "BranchPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "UAT", "BranchPin");
					break;
				case "teller":
					test_data_file = xmlUtils.getChildNodeValue(configFilePath, "UAT", "TellerTestData");
					userName = xmlUtils.getChildNodeValue(configFilePath, "UAT", "TellerUser");
					password = xmlUtils.getChildNodeValue(configFilePath, "UAT", "TellerPassword");
					pin = xmlUtils.getChildNodeValue(configFilePath, "UAT", "TellerPin");
					break;
				default:
					throw new RuntimeException("irrelevant sub user type found");
				}
				break;
			case "customer":
				testUrl = xmlUtils.getChildNodeValue(configFilePath, "URL", "CustomerUATUrl");
				test_data_file = xmlUtils.getChildNodeValue(configFilePath, "UAT", "CustomerTestData");
				userName = xmlUtils.getChildNodeValue(configFilePath, "UAT", "CustomerUser");
				password = xmlUtils.getChildNodeValue(configFilePath, "UAT", "CustomerPassword");
				pin = xmlUtils.getChildNodeValue(configFilePath, "UAT", "CustomerPin");
				break;
			default:
				throw new RuntimeException("irrelevant user type found");
			}
			break;
		default:
			throw new RuntimeException("irrelevant configuration found");
		}
	}

	public String getportalURL(String env, String userType) {
		switch (env.toLowerCase().trim()) {
		case "qa":
			switch (userType.toLowerCase().replaceAll("\\s", "")) {
			case "agent":
				return xmlUtils.getChildNodeValue(configFilePath, "URL", "AgentQAUrl");
			case "customer":
				return xmlUtils.getChildNodeValue(configFilePath, "URL", "CustomerQAUrl");
			default:
				throw new RuntimeException("irrelevant user type found");
			}
		case "dev":
			switch (userType.toLowerCase().replaceAll("\\s", "")) {
			case "agent":
				return xmlUtils.getChildNodeValue(configFilePath, "URL", "AgentDEVUrl");
			case "customer":
				return xmlUtils.getChildNodeValue(configFilePath, "URL", "CustomerDEVUrl");
			default:
				throw new RuntimeException("irrelevant user type found");
			}
		case "uat":
			switch (userType.toLowerCase().replaceAll("\\s", "")) {
			case "agent":
				return xmlUtils.getChildNodeValue(configFilePath, "URL", "AgentUATUrl");
			case "customer":
				return xmlUtils.getChildNodeValue(configFilePath, "URL", "CustomerUATUrl");
			default:
				throw new RuntimeException("irrelevant user type found");
			}
		default:
			throw new RuntimeException("irrelevant configuration found");
		}
	}

	private void setDriver(String browserType) {
		String toLowerCase = browserType.toLowerCase();
		switch (toLowerCase.hashCode()) {
		case -1361128838:
			if (toLowerCase.equals("chrome")) {
				try {
					this.driver = initChromeDriver();
				} catch (Exception e) {
					System.out.println(e);
				}
				return;
			}
		case -1115062407:
			if (toLowerCase.equals("headless")) {
				this.driver = initChromeHeadlessDriver();
				return;
			}
		case -849452327:
			if (toLowerCase.equals("firefox")) {
				this.driver = initFirefoxDriver();
				return;
			}
		case 3356:
			if (toLowerCase.equals("ie")) {
				this.driver = initIEDriver();
				return;
			}
		case 472085556:
			if (toLowerCase.equals("chromeproxy")) {
				this.driver = initChromeProxyDriver();
				return;
			}
		case -1862645963:
			if (toLowerCase.equals("firefoxproxy")) {
				this.driver = initFirefoxProxyDriver();
				return;
			}
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			this.driver = initFirefoxDriver();
			return;
		}
	}

	private WebDriver initChromeHeadlessDriver() {
//		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments(new String[] { "headless" });
		chromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		chromeOptions.addArguments("--headless", "window-size=1920,1080", "--no-sandbox");
		chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
				"--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	private WebDriver initChromeDriver() {
		System.out.println("Launching google chrome with new profile..");
//		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = setChromeOptions();
		if (isRemoteEnable)
			return new RemoteWebDriver(remote_grid, option);
		return new ChromeDriver(option);
	}

	private ChromeOptions setChromeOptions() {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", Integer.valueOf(0));
		// chromePrefs.put("download.default_directory", DOWNLOADS_FOLDER);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		if (incognito)
			options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extenstions");
		options.addArguments(new String[] { "disable-infobars" });
		options.setExperimentalOption("prefs", chromePrefs);
		// options.setProxy(proxyConfig);
		options.setAcceptInsecureCerts(true);
		DesiredCapabilities capabilities = setChromeCapabilities();
		options.merge(capabilities);
		if (isRemoteEnable)
			capabilities.setCapability("goog:chromeOptions", options);
		return options;
	}

	private DesiredCapabilities setChromeCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		capabilities.setCapability("acceptSslCerts", true);
		return capabilities;
	}

	private WebDriver initFirefoxDriver() {
		System.out.println("Launching Firefox browser..");
//		System.setProperty("webdriver.gecko.driver", DEPENDENCIES_FOLDER + "geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = setFireFoxOptions();
		if (isRemoteEnable)
			return new RemoteWebDriver(remote_grid, options);
		return new FirefoxDriver(options);
	}

	private FirefoxOptions setFireFoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("gecko", true);
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extenstions");
		options.addArguments(new String[] { "disable-infobars" });
		DesiredCapabilities capabilities = setFireFoxCapabilities();
		options.merge(capabilities);
		return options;
	}

	private DesiredCapabilities setFireFoxCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("acceptSslCerts", true);
		return capabilities;
	}

	private WebDriver initIEDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		InternetExplorerOptions options = new InternetExplorerOptions();
		capabilities.setPlatform(Platform.ANY);
		capabilities.setBrowserName("internet explorer");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		capabilities.setJavascriptEnabled(true);
		if (isRemoteEnable)
			return new RemoteWebDriver(remote_grid, capabilities);
		options.merge(capabilities);
		driver = new InternetExplorerDriver(options);
		return driver;
	}

	private WebDriver initChromeProxyDriver() {
		proxyIP = xmlUtils.getChildNodeValue(configFilePath, "Proxy", "ProxyIP");
		proxyPort = xmlUtils.getChildNodeValue(configFilePath, "Proxy", "ProxyPort");
//		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyIP + ":" + proxyPort);
		proxy.setFtpProxy(proxyIP + ":" + proxyPort);
		proxy.setSslProxy(proxyIP + ":" + proxyPort);
		proxy.setSocksProxy(proxyIP + ":" + proxyPort);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setProxy(proxy);
		chromeOptions.addArguments("test-type");
		if (incognito)
			chromeOptions.addArguments("--incognito");
		chromeOptions.addArguments("disable-infobars");
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//		capabilities.setCapability("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setBrowserName("chrome");
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("proxy", proxy);
		chromeOptions.merge(capabilities);
		if (isRemoteEnable) {
			driver = new RemoteWebDriver(remote_grid, capabilities);
			return driver;
		}
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	private WebDriver initFirefoxProxyDriver() {
		FirefoxProfile profile1 = new FirefoxProfile();
		proxyIP = xmlUtils.getChildNodeValue(configFilePath, "Proxy", "ProxyIP");
		proxyPort = xmlUtils.getChildNodeValue(configFilePath, "Proxy", "ProxyPort");
//		System.setProperty("webdriver.gecko.driver", DEPENDENCIES_FOLDER + "geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		profile1.setPreference("dom.max_chrome_script_run_time", "999");
		profile1.setPreference("dom.max_script_run_time", "999");
		profile1.setPreference("browser.download.folderList", 2);
		profile1.setPreference("browser.download.useDownloadDir", true);
		profile1.setPreference("browser.download.manager.showWhenStarting", false);
		profile1.setPreference("javascript.enabled", true);
		profile1.setPreference("network.http.use-cache", false);
		profile1.setPreference("network.proxy.type", 1);
		profile1.setPreference("network.proxy.http", proxyIP);
		profile1.setPreference("network.proxy.http_port", proxyPort);
		profile1.setPreference("network.proxy.ssl", proxyIP);
		profile1.setPreference("network.proxy.ssl_port", proxyPort);
		profile1.setPreference("network.proxy.ftp", proxyIP);
		profile1.setPreference("network.proxy.ftp_port", proxyPort);
		profile1.setPreference("network.proxy.socks", proxyIP);
		profile1.setPreference("network.proxy.socks_port", proxyPort);
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setProfile(profile1);
		options1.setAcceptInsecureCerts(true);
		if (isRemoteEnable) {
			driver = new RemoteWebDriver(remote_grid, options1);
			return driver;
		}
		driver = new FirefoxDriver(options1);
		return driver;
	}

	public boolean verifyVisible(By locator, int... timeOrAssert) {
		WebElement element = findPresentElement(locator, timeOrAssert);
		return element != null ? true : false;
	}

	public boolean verifyDisplayed(By locator, int... timeOrAssert) {
		WebElement element = findVisibleElement(locator, timeOrAssert);
		return element != null ? true : false;
	}

	public boolean isPresent(By locator, int... timeOrAssert) {
		WebElement element = findPresentElement(locator, timeOrAssert);
		return element != null ? element.isDisplayed() : false;
	}

	public boolean isVisible(By locator, int... timeOrAssert) {
		WebElement element = findVisibleElement(locator, timeOrAssert);
		return element != null ? element.isDisplayed() : false;
	}

	public boolean veifyElementIsNotVisible(By locator, int... time) {
		return !verifyVisible(locator, time);
	}

	public List<String> getTextFromElementList(By locator, int... timeOrAssert) {
		List<String> textList = new ArrayList<>();
		for (WebElement element : getElementList(locator, timeOrAssert))
			textList.add(element.getText());
		return textList;
	}

	public List<WebElement> getElementList(By locator, int... timeOrAssert) {
		waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), true);
		String message = "";
		ArrayList<WebElement> elementLst = new ArrayList<>();
		try {
			elementLst = (ArrayList<WebElement>) driver.findElements(locator);
			message = "getElementList passed, locator  by : " + locator;
		} catch (Exception e) {
			message = "getElementList failed: " + getPortableString(e.toString()) + ", locator by : " + locator;
		}
		return elementLst;
	}

	public void selectFromDropDown(elasticwrite log, By dropDownLoc, By valueLoc, int... time) {
		clickOnElement(log, dropDownLoc, time);
		clickOnElement(log, valueLoc, time);
	}

	public String getElementText(elasticwrite log, By locator, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isPresent, getTimeOut(timeOrAssert), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		String text = getElementText(element, timeOrAssert);
		log.steps.add("Text of  " + locator + " is = " + text);
		return text;
	}

	public String getElementText(WebElement element, int... timeOrAssert) {
		try {
			if (element == null)
				throw new Exception();
		} catch (Exception e) {
			String ExceptionMessage = "Get text for element is failed: " + getPortableString(e.toString()) + ": "
					+ " by : " + element;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
		return element.getText();
	}

	public void clickOnElement(elasticwrite log, By locator, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				element.click();
			}
		} catch (Exception e) {
			String ExceptionMessage = "Click on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public void clickOnElement(By locator, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				element.click();
			}
		} catch (Exception e) {
			String ExceptionMessage = "Click on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public void clickOnElementUsingJS(By locator, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
			}
		} catch (Exception e) {
			String ExceptionMessage = "Click on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public void selectFromDropDownUsingSelectTag(elasticwrite log, By locator, String drpValue, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				Select select = new Select(element);
				select.selectByValue(drpValue);
			}
		} catch (Exception e) {
			String ExceptionMessage = "Click on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public void removeReadOnlyProperty(WebElement webElement) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", webElement);
	}

	public void sendKeys(elasticwrite log, By locator, String data, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				waitForLoader();
				element.clear();
				waitForLoader();
				element.sendKeys(data);
			}
		} catch (Exception e) {
			String ExceptionMessage = "Send skeys on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public void sendKeysWithOutClearWithRemoveReadOnlyProperty(elasticwrite log, By locator, String data,
			int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				removeReadOnlyProperty(element);
				waitForLoader();
				element.sendKeys(data);
			}
		} catch (Exception e) {
			String ExceptionMessage = "Send skeys on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public void sendKeys(By locator, String data, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				waitForLoader();
				element.clear();
				waitForLoader();
				element.sendKeys(data);
			}
		} catch (Exception e) {
			String ExceptionMessage = "Send skeys on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public void sendKeysWithRemoveReadOnlyProperty(elasticwrite log, By locator, String data, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				removeReadOnlyProperty(element);
				element.clear();
				element.sendKeys(data);
			}
		} catch (Exception e) {
			String ExceptionMessage = "Send skeys on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public List<String> getElementAttributes(WebElement element) {
		List<String> elementAttributes = new ArrayList<String>();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			Object attribute = executor.executeScript(
					"var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",
					element);
			String[] attributes = attribute.toString().split(",");
			for (int i = 0; i < attributes.length; i++) {
				elementAttributes.add(attributes[i].split("=")[0].replace("{", "").replaceAll(" ", ""));
			}
		} catch (Exception e) {
			log("<b><span style='color:red'> Element " + element
					+ " contaning an attribute having null value </span></b>");
		}
		return elementAttributes;
	}

	public WebElement findVisibleElement(By locator, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), false);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
		} catch (Exception e) {
			String ExceptionMessage = "Element is not displayed failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
		return element;
	}

	public WebElement findPresentElement(By locator, int... time) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isPresent, getTimeOut(time), false);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
		} catch (Exception e) {
			String ExceptionMessage = "Element is not present failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, time);
		}
		return element;
	}

	public WebElement findClickableElement(By locator, int... time) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isClickable, getTimeOut(time), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
		} catch (Exception e) {
			String ExceptionMessage = "Element is not clickable failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, time);
		}
		return element;
	}

	private int getTimeOut(int[] time) {
		int timeOut = MAX_WAIT_TIME_IN_SEC;
		if (time.length != 0)
			if (time[0] > 0)
				timeOut = time[0];
		return timeOut;
	}

	private int getInvisibilityTimeOut(int[] time) {
		int timeOut = 10;
		if (time.length != 0)
			if (time[0] > 0)
				timeOut = time[0];
		return timeOut;
	}

	private Map<WebElement, String> waitForElementState(By locator, Condition condition, int time,
			boolean elementCondition) {
		WebElement element;
		do {
		} while (!waitForLoader());
		do {
		} while (!isAjaxCallCompleted());
		Map<WebElement, String> map = new HashMap<>();
		element = getElement(condition, locator, time, elementCondition);
		String message = "";
		if (element == null) {
			try {
				throw new Exception();
			} catch (Exception e) {
				message = "State = " + condition.toString() + " failed: ";
			}
		} else {
			message = "State = " + condition.toString() + " Passed: ";
		}
		map.put(element, message);
		return map;

	}

	public boolean waitForInvisble(Condition condition, By by, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			switch (condition) {
			case isNotVisible:
				return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			default:
				break;
			}
		} catch (Exception e) {
		}
		return false;
	}

	private WebElement getElement(Condition condition, By by, int time, boolean elementcondition) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebDriverWait wait1 = new WebDriverWait(driver, time / 2);
		try {
			switch (condition) {
			case isClickable:
				element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				if (element == null) {
					return element;
				} else if (element.getAttribute("clickable") == null) {
					return element;
				} else if (element.getAttribute("clickable") != null) {
					element = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(by));
					return element;
				}
				if (!isVisibleInViewport(element) && element != null) {
					scrollToElement(element);
				}
				break;
			case isDisplayed:
				try {
					element = (WebElement) wait1.until(ExpectedConditions.visibilityOfElementLocated(by));
					if (element == null) {
						reloadCurrentPage();
						element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
					}
				} catch (Exception e) {
					if (elementcondition)
						element = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
				}
				if (!isVisibleInViewport(element) && element != null) {
					scrollToElement(element);
				}
				break;
			case isPresent:
				element = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
				break;
			default:
				break;
			}
		} catch (Exception e) {
		}
		return element;
	}

	public void pauseInSeconds(int i) {
		try {
			Thread.sleep(1000 * i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void pauseInMilliSeconds(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void defaultPause() {
		try {
			Thread.sleep(1000 * DEFAULT_PAUSE_INSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		((JavascriptExecutor) driver).executeScript(
				"window.scrollTo(" + element.getLocation().x + "," + (element.getLocation().y - 80) + ");");
	}

	protected void scrollToElement_Tangereine(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean isAjaxCallCompleted() {
		WebDriverWait wait = new WebDriverWait(this.driver, (long) this.GENERAL_TIMEOUT);
		wait.ignoring(StaleElementReferenceException.class);
		try {
			return ((Boolean) wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver inDriver) {
					boolean z = SetupInit.this.isJQueryLoaded() && SetupInit.this.isJSLoaded();
					return Boolean.valueOf(z);
				}

				public String toString() {
					return "Waiting for Ajax call to be completed";
				}
			})).booleanValue();
		} catch (TimeoutException e) {
			return false;
		}
	}

	private boolean isJSLoaded() {
		return ((JavascriptExecutor) this.driver).executeScript("return document.readyState", new Object[0]).toString()
				.equals("complete");
	}

	public boolean isJQueryLoaded() {
		try {
			return ((Long) ((JavascriptExecutor) this.driver).executeScript("return jQuery.active", new Object[0]))
					.longValue() == 0;
		} catch (Exception e) {
			return true;
		}
	}

	protected boolean isVisibleInViewport(WebElement element) {
		return ((Boolean) ((JavascriptExecutor) ((RemoteWebElement) element).getWrappedDriver()).executeScript(
				"var elem = arguments[0],                   box = elem.getBoundingClientRect(),      cx = box.left + box.width / 2,           cy = box.top + box.height / 2,           e = document.elementFromPoint(cx, cy); for (; e; e = e.parentElement) {           if (e === elem)                            return true;                         }                                        return false;                            ",
				new Object[] { element })).booleanValue();
	}

	public boolean isLoderDisplayed(By locator) {
		boolean state = false;
		try {
			state = driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			state = false;
		}
		return state;
	}

	public boolean waitForLoader() {
		reloadCounter = 0;
		pauseInMilliSeconds(900);
		if (isLoderDisplayed(By.xpath("//*[contains(@src,'Lycamobile-GIF-loader')]"))) {
			Instant currentTime = getCurrentTime();
			while (isLoderDisplayed(By.xpath("//*[contains(@src,'Lycamobile-GIF-loader')]"))) {
				Instant loopingTime = getCurrentTime();
				Duration timeElapsed = Duration.between(currentTime, loopingTime);
				long sec = timeElapsed.toMillis() / 1000;
				int durDiff = (int) sec;
				if (durDiff >= LOADER_WAIT) {
					reloadCurrentPage();
					reloadCounter++;
					if (reloadCounter == 6)
						assertTrue(false, "Continuous Loader Displaying");
				}
			}
		}
		pauseInMilliSeconds(900);

		return true;
	}

	public synchronized void log(String message) {
		Reporter.log(message);
		System.out.println(message);
	}

	public String makeScreenshot(String testClassName, String testMethod) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		String currentTime = timeFormat.format(date);
		// String currentDir = System.getProperty("user.dir");
		String folderPath = ".\\" + ReadProperty.getPropertyValue("REPORT_FOLDER") + File.separator + "HTML Reports"
				+ File.separator + "FailureScreenShots" + File.separator + testClassName + File.separator
				+ currentDate.replaceAll("/", "_");
		folderPath = folderPath.trim();
		screenshotName = currentTime.replace(":", "_") + ".png";
		String filePath = folderPath + File.separator + testMethod + "_" + screenshotName;
		filePath = filePath.trim();
		File screenshotLocation = new File(folderPath);
		if (!screenshotLocation.getAbsoluteFile().exists())
			screenshotLocation.mkdir();
		File screenshot;
		WebDriver augmentedDriver = null;
		augmentedDriver = new Augmenter().augment(getDriver());
		screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		try {
			File f = new File(filePath);
			FileUtils.copyFile(screenshot, f);
			return filePath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed to capture a sccreenshot";
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * @author dishant.doshi
	 * @return the current URL
	 * @created on 25/02/2019
	 */
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	/**
	 * @author dishant.doshi to reload current url
	 * @creation date 23/11/2018
	 */
	public void reloadCurrentPage(WebDriver driver) {
		String url = getCurrentURL(driver);
		driver.get(url);
		driver.navigate().refresh();
		pauseInSeconds(5);
	}

	public void reloadCurrentPage() {
		String url = getCurrentURL();
		driver.get(url);
		pauseInSeconds(5);
	}

	@AfterClass
	public void closeBrowser() {
		this.driver.quit();
	}

	@AfterSuite
	public void setAccessMaricesResult() {
		ExcelUtility.setCellDataWithFormate(newAccessMatricesFileName, accessMatricesSheetName, 1, 1,
				String.valueOf(pass));
		ExcelUtility.setCellDataWithFormate(newAccessMatricesFileName, accessMatricesSheetName, 3, 1,
				String.valueOf(skip));
		ExcelUtility.setCellDataWithFormate(newAccessMatricesFileName, accessMatricesSheetName, 2, 1,
				String.valueOf(fail));
		int sum = pass + fail + skip;
		double result = 0.0;
		if (sum != 0)
			result = 100 * pass / sum;
		ExcelUtility.setCellDataWithFormate(newAccessMatricesFileName, accessMatricesSheetName, 1, 2,
				String.valueOf(result));
	}

	// ################ Supporting methods
	// #################################################################

	protected Map<Object, Object> logException(Throwable e, Map<Object, Object> map) {
		// map.put("Steps To Reproduce", logList);
		stacktrace = Utility.getStackStrace(e);
		Scanner sc = new Scanner(stacktrace);
		String firstLine = sc.nextLine();
		sc.close();
		Map<Object, Object> dataMap = getDataMap(map);
		dataMap = addSteps(dataMap);
		String failReason = "";
		if (firstLine.contains("####")) {
			failReason = firstLine.split("####")[1];
		} else {
			failReason = firstLine;
		}
		dataMap.put("Failure Reason", failReason);
		dataMap.put("Datailed Failure Reason", stacktrace);
		endTime = System.currentTimeMillis();
		if (endTime > end)
			end = endTime / 1000;
		if ((Long) dataMap.get("Test Start Time") < start) {
			startMS = (Long) dataMap.get("Test Start Time");
			start = startMS / 1000;
		}
		dataMap.put("Test Start Time", Utility.formatTime(startMS));
		dataMap.put("Test End Time", Utility.formatTime(endTime));
		dataMap.put("Total Execution Time", Utility.millisToTimeConversion(end - start));
		String clsName = dataMap.get("Class Name").toString();
		String className = clsName.contains(".") ? clsName.substring(clsName.lastIndexOf('.') + 1) : clsName;
		String screenShot = makeScreenshot(className, dataMap.get("Method Name").toString());
		dataMap.put("Failed Screenshot path", screenShot);
		log("<br> <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Please click for screenshot - </b>");
		log(createScreenshotLink(screenshotName, screenShot));
		if (dataDumpInElastic)
			logMatrics.logToElasticsearch(dataMap);
		e.printStackTrace();
		return dataMap;
	}

	public void logData(Map<Object, Object> map) {
		Map<Object, Object> dataMap = getDataMap(map);
		String steps = "";
		String manualSteps = "";
		int counter = 1;
		int manualCounter = 1;
		if (dataMap.get("Execution steps") != null) {
			ArrayList<String> finalList = new ArrayList<String>();
			ArrayList<String> al = (ArrayList<String>) dataMap.get("Execution steps");
			for (String s : al) {
				if (!s.trim().equalsIgnoreCase("clicked on")) {
					finalList.add(s.trim());
				}
			}
			for (String s : finalList) {
				steps = steps + counter + "." + s.trim() + "\n";
				counter++;
			}
			dataMap.put("Execution steps", steps);
			System.err.println("======================================");
			System.out.println(steps);
			System.err.println("################################");
		}
		if (dataMap.get("Test Steps") != null) {
			ArrayList<String> finalList = new ArrayList<String>();
			ArrayList<String> al = (ArrayList<String>) dataMap.get("Test Steps");
			for (String s : al) {
				if (!s.trim().equalsIgnoreCase("clicked on")) {
					finalList.add(s.trim());
				}
			}
			for (String s : finalList) {
				manualSteps = manualSteps + manualCounter + "." + s.trim() + "\n";
				manualCounter++;
			}
			dataMap.put("Test Steps", manualSteps);
			System.err.println("======================================");
			System.out.println(manualSteps);
			System.err.println("################################");
		}
		setResultInAccessMatriceFile(dataMap.get("Method Name").toString(), dataMap.get("Value").toString());
		if (dataMap.get("Value") == null) {
			dataMap.put("Value", 50);
			endTime = System.currentTimeMillis();
			if (endTime > end)
				end = endTime / 1000;
			if ((Long) map.get("Test Start Time") < start) {
				startMS = (Long) dataMap.get("Test Start Time");
				start = startMS / 1000;
			}
			dataMap.put("Test Start Time", Utility.formatTime(startMS));
			dataMap.put("Test End Time", Utility.formatTime(endTime));
			dataMap.put("Total Execution Time", Utility.millisToTimeConversion(end - start));
			if (dataDumpInElastic)
				logMatrics.logToElasticsearch(dataMap);
		} else if ((Integer) map.get("Value") == 100) {
			endTime = System.currentTimeMillis();
			if (endTime > end)
				end = endTime / 1000;
			if ((Long) map.get("Test Start Time") < start) {
				startMS = (Long) dataMap.get("Test Start Time");
				start = startMS / 1000;
			}
			dataMap.put("Test Start Time", Utility.formatTime(startMS));
			dataMap.put("Test End Time", Utility.formatTime(endTime));
			dataMap.put("Total Execution Time", Utility.millisToTimeConversion(end - start));
			if (dataDumpInElastic)
				logMatrics.logToElasticsearch(dataMap);
		} else if ((Integer) dataMap.get("Value") == 0) {
			String res = "";
			String fail = dataMap.get("Method Name").toString();
			for (String w : fail.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
				res = res + " " + w;
			}
			String failure = dataMap.get("Failure Reason").toString();
			if (failure.contains("RuntimeException"))
				failure = failure.replaceAll("java.lang.RuntimeException:", "") + " while performing " + res;
			else if (failure.contains("NullPointerException"))
				failure = "Trying to access null object" + " while performing " + res;
			else if (failure.contains("TimeoutException"))
				failure = "Session timeout" + " while performing " + res;
			else if (failure.contains("ArithmeticException"))
				failure = "Trying to devide by zero" + " while performing " + res;
			throw new RuntimeException(failure);
			// }
		}
	}

	private void setResultInAccessMatriceFile(String methodName, String value) {
		if (value == null)
			value = "50";
		String accessName = accessMatricesGlobalMap.get(methodName);
		int rowNum = ExcelUtility.getRowNumber(newAccessMatricesFileName, accessMatricesSheetName, 1, accessName);
		int result = Integer.parseInt(value);
		String currentStatus = "";
		int colNum = 0;
		switch (userType.toLowerCase().replaceAll("\\s", "")) {
		case "agent":
			switch (subUserType.toLowerCase().replaceAll("\\s", "")) {
			case "subagent":
				colNum = 4;
				break;
			case "agent":
				colNum = 3;
				break;
			case "superagent":
				colNum = 2;
			default:
				throw new RuntimeException("irrelevant sub user type found");
			}
			break;
		case "customer":
			colNum = 2;
			break;
		default:
			throw new RuntimeException("irrelevant user type found");
		}
		currentStatus = ExcelUtility.getCellData(newAccessMatricesFileName, accessMatricesSheetName, rowNum, colNum);
		if (rowNum != 0 & !currentStatus.equalsIgnoreCase("fail")) {
			switch (result) {
			case 0:
				ExcelUtility.setCellDataWithFormate(newAccessMatricesFileName, accessMatricesSheetName, rowNum, colNum,
						"Fail");
				fail++;
				break;
			case 50:
				ExcelUtility.setCellDataWithFormate(newAccessMatricesFileName, accessMatricesSheetName, rowNum, colNum,
						"Skip");
				skip++;
				break;
			case 100:
				ExcelUtility.setCellDataWithFormate(newAccessMatricesFileName, accessMatricesSheetName, rowNum, colNum,
						"Pass");
				pass++;
				break;
			default:
				break;
			}
		}
	}

	private Map<Object, Object> addSteps(Map<Object, Object> dataMap) {
		String steps = "";
		int counter = 1;
		if (dataMap.get("Execution steps") != null) {
			ArrayList<String> finalList = new ArrayList<String>();
			finalList.add("Navigated to = " + this.testUrl);
			finalList.add("Entered username = " + this.userName);
			finalList.add("Entered password = " + this.password);
			finalList.add("Clicked on Login");
			ArrayList<String> al = (ArrayList<String>) dataMap.get("Execution steps");
			for (String s : al) {
				if (!s.trim().equalsIgnoreCase("clicked on")) {
					finalList.add(s.trim());
				}
			}
			for (String s : finalList) {
				steps = steps + counter + "." + s.trim() + "\n";
				counter++;
			}
			dataMap.put("Execution steps", steps);
			System.err.println("======================================");
			System.out.println(steps);
			System.err.println("################################");
		}
		return dataMap;

	}

	public Map<Object, Object> getDataMap(Map<Object, Object> map) {
		Map<Object, Object> dataToDump = new HashMap<>();
		for (Map.Entry<Object, Object> e : map.entrySet()) {
			dataToDump.put(e.getKey().toString(), e.getValue());
		}
		dataToDump.put("Executor IP", getIPOfNode());
		return dataToDump;
	}

	public String getIPOfNode() {
		if (isRemoteEnable) {
			pauseInSeconds(1);
			String hostFound = null;
			try {
				HttpCommandExecutor ce = (HttpCommandExecutor) ((RemoteWebDriver) this.driver).getCommandExecutor();
				String hostName = ce.getAddressOfRemoteServer().getHost();
				int port = ce.getAddressOfRemoteServer().getPort();
				HttpHost host = new HttpHost(hostName, port);
				HttpClient client = new DefaultHttpClient();
				URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session="
						+ ((RemoteWebDriver) this.driver).getSessionId());
				BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST",
						sessionURL.toExternalForm());
				HttpResponse response = client.execute(host, r);
				JSONObject object = extractObject(response);
				URL myURL = new URL(object.getString("proxyId"));
				if ((myURL.getHost() != null) && (myURL.getPort() != -1)) {
					hostFound = myURL.getHost();
				}
			} catch (Exception e) {
				System.err.println(e);
			}
			return hostFound;
		} else {
			String inetAddress = null;
			try {
				inetAddress = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException e) {
			}
			return inetAddress;
		}
	}

	public JSONObject extractObject(HttpResponse resp) throws IOException, JSONException {
		InputStream contents = resp.getEntity().getContent();
		StringWriter writer = new StringWriter();
		IOUtils.copy(contents, writer, "UTF8");
		JSONObject objToReturn = new JSONObject(writer.toString());
		return objToReturn;
	}

	public String getCurrentMethodName() {
		return new Throwable().getStackTrace()[0].getMethodName();
	}

	public String createScreenshotLink(String screenShotName, String link_text) {
		return "<br><Strong><font color=#FF0000>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Failed screenshot name = </font></strong><a target='_blank' href='"
				+ "." + link_text.split("HTML Reports")[1] + "'>" + screenShotName + "</a>";
	}

	/**
	 * @author vivek.mishra
	 * @return current time in integer
	 * @created on 25/02/2019
	 */
	public Instant getCurrentTime() {
		return Instant.now();
	}

	private void fetchSuiteConfiguration(String configuration) {
		isRemoteEnable = Boolean
				.parseBoolean(xmlUtils.getChildNodeValue(configFilePath, configuration, "isRemoteEnable"));
		incognito = Boolean.parseBoolean(xmlUtils.getChildNodeValue(configFilePath, configuration, "incognito"));
		if (isRemoteEnable) {
			hubUrl = xmlUtils.getChildNodeValue(configFilePath, configuration, "Hub");
			hubPort = xmlUtils.getChildNodeValue(configFilePath, configuration, "Port");
		}
		logDefectAutomated = new Boolean(
				xmlUtils.getChildNodeValue(configFilePath, configuration, "AutoLogDefectInJira"));
		recordSessionVideo = new Boolean(
				xmlUtils.getChildNodeValue(configFilePath, configuration, "RecordVideoOfTestExecution"));
		regexTCID = xmlUtils.getChildNodeValue(configFilePath, "Configuration", "TestIdRegex");
		regexAuthor = xmlUtils.getChildNodeValue(configFilePath, "Configuration", "TestAuthorRegex");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {
		if (!testResult.isSuccess()) {
			System.out.println(testResult);
			Reporter.setCurrentTestResult(testResult);
		}
	}

	public void exceptionOnFailure(boolean success, String message, int[] assertion) {
		if (!success) {
			if (assertionResult(assertion)) {
				try {
					assertStatus(message, success);
				} catch (Exception e) {
					RuntimeException ex = new RuntimeException(message + " : " + e.getMessage());
					System.out.println("Exception Logging For: " + message);
					ex.setStackTrace(e.getStackTrace());
					throw ex;
				}
			}
		}
	}

	public boolean assertionResult(int[] j) {
		if (j != null) {
			if (j.length > 0) {
				if (j[0] != 0) {
					return false;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isVarArgsPassed(int[] j) {
		if (j != null) {
			if (j.length > 0) {
				if (j[0] > 0)
					return true;
				else
					return false;
			}
		}
		return false;
	}

	public void assertStatus(String message, boolean success) throws Exception {
		if (!success) {
			throw new Exception(message);
		}
	}

	public String getPortableString(String str) {
		if (str.length() > 150) {
			return str.substring(0, 150) + "...";
		} else if (str.length() != 0) {
			return str.substring(0, str.length() - 1) + "...";
		} else {
			return str;
		}
	}

	public void setTestParameters(Map<Object, Object> map, String methodName) {
		map.put("Suite Name", suiteName);
		map.put("Project Name", projectName);
		map.put("Project Version", projectVersion);
		map.put("Task Name", taskName);
		map.put("Project Release", latestRelease);
		automationCycle = taskName.replace(projectName + "_", "").trim();
		map.put("Automation Cycle ID", automationCycle);
		map.put("Automation Type", "Web-Admin");
		map.put("Test Start Time", System.currentTimeMillis());
		String className = this.getClass().getName();
		map.put("Class Name", className.substring(className.lastIndexOf(".") + 1));
		map.put("Method Name", methodName);
	}

	public void writeVerificationFile(String string) {
		FileWriter writer;
		try {
			File file = new File(verificationDataFileName);
			writer = new FileWriter(file, true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			if (string != null)
				bufferedWriter.write(string);
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isVideoRecordingEnable() {
		return Boolean.parseBoolean(System.getProperty("videoRecording"));
	}

	public void setSuccessParameters(Map<Object, Object> map) {
		map.put("Value", 100);
	}

	public void setFailureParameters(Map<Object, Object> map) {
		map.put("Value", 0);
	}

	public void sendKeysWithOutClear(By locator, String data, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				waitForLoader();
				element.sendKeys(data);
				String value = getElementText(element);
				if (value.equals("") || value.equals(null) || value.equals(" ")) {
					List<String> attributes = getElementAttributes(element);
					if (attributes.contains("name") && (!element.getAttribute("name").equals("")
							|| !element.getAttribute("name").equals(null))) {
						value = element.getAttribute("name");
					} else if (attributes.contains("id")
							&& (!element.getAttribute("id").equals("") || !element.getAttribute("id").equals(null))) {
						value = element.getAttribute("id");
					} else if (attributes.contains("class") && (!element.getAttribute("class").equals("")
							|| !element.getAttribute("class").equals(null))) {
						value = element.getAttribute("class");
					} else if (attributes.contains("value") && (!element.getAttribute("value").equals("")
							|| !element.getAttribute("value").equals(null))) {
						value = element.getAttribute("value");
					}
				}
				value = "<b><span style='color:#3f0713'>" + value + "</span></b>";
				data = "<b><span style='color:#418eb5'>" + data + "</span></b>";
				log("Sent text in " + value + ": " + data);
			}
		} catch (Exception e) {
			String ExceptionMessage = "Send skeys on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public void clearText(By locator, String data, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert), true);
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				waitForLoader();
				element.sendKeys(Keys.chord(Keys.CONTROL, "A") + Keys.BACK_SPACE);
				pauseInSeconds(1);
				element.clear();
				pauseInSeconds(1);
			}
		} catch (Exception e) {
			String ExceptionMessage = "Send skeys on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public WebElement removeAnAttributeFromElement(By locator, String attributeName) {
		WebElement element = findPresentElement(locator, 4);
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeName + "')", element);
		return element;
	}

	public void sendKeysToElement(elasticwrite log, WebElement element, String data) {
		element.sendKeys(data);
		log.steps.add("Sent text : " + data);
		log("Sent text : " + data);
	}

	public void setLogSteps(elasticwrite log, String message) {
		log.manualSteps.add(message);
		log(message);
	}

	public void setExceptionData(CreateObject co, Exception e) {
		co.datamap.put("Execution steps", co.log.steps);
		setFailureParameters(co.datamap);
		co.datamap = logException(e, co.datamap);
	}

	public void moveToElement(By locator) {
		WebElement element = findPresentElement(locator, 5);
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void setExcecutionData(CreateObject co) {
		co.datamap.put("Execution steps", co.log.steps);
		co.datamap.put("Test Steps", co.log.manualSteps);
		logData(co.datamap);
		co.log.steps.clear();
		co.datamap.clear();
	}

	public void openNewTabInBrowser() {
		((JavascriptExecutor) driver).executeScript("window.open()");

	}

	public void switchToMainTab(String Window) {
		driver.switchTo().window(Window);
	}

	public String getMainWindow() {
		return driver.getWindowHandle();
	}

	public void switchToTab() {
		// Get handles of the windows
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}

	}

	public void closeCurrentTab(String Window) {
		driver.close();
		driver.switchTo().window(Window);
	}

	public String setTransactionCalculator(String methodName, String fromNumber, String toNumber, String openingBalance,
			String transactionAmount, String fromSurcharge, String fromCommission, String toSurcharge,
			String toCommission, String transactionID, String closingBalance) {
		String transactionDir = "transaction_calculator";
		File file = new File(transactionDir);
		if (!file.exists())
			file.mkdir();
		newTransactionFileName = transactionDir + File.separator + "Tangerine_" + userType + "_" + methodName + "_"
				+ Utility.getCurrentDateTime().replaceAll(":", "_").replaceAll("-", "_").replaceAll(" ", "_") + ".xls";
		if (ExcelUtility.createAnExcel(newTransactionFileName, transactionSheetName)) {
			transactionFileName = TESTDATA_FOLDER + File.separator + "Transaction Templates" + File.separator
					+ "Transaction Templates.xls";
			Utility.copyFile(transactionFileName, newTransactionFileName);
		}
		ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 0, 1, transactionID);
		ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 1, 1, fromNumber);
		ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 2, 1, toNumber);
		ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 0, 4,
				String.format("%.4f", Double.parseDouble(openingBalance)));
		ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 1, 4,
				String.format("%.4f", Double.parseDouble(closingBalance)));
		ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 5, 1, methodName);
		ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 6, 1,
				String.format("%.4f", Double.parseDouble(transactionAmount)));
		if (fromSurcharge.contains("%")) {
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 7, 1, "Percentage (%)");
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 7, 2,
					fromSurcharge.replace("%", ""));
			double fromSur = (Double.parseDouble(fromSurcharge.replace("%", ""))
					* Double.parseDouble(transactionAmount)) / 100;
			String s = String.format("%.4f", fromSur);
			System.out.println(s);
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 7, 3,
					String.format("%.4f", fromSur));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 13, 2,
					String.format("%.4f", fromSur));
		} else {
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 7, 1, "Fix Value");
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 7, 2,
					String.format("%.4f", Double.parseDouble(fromSurcharge)));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 7, 3,
					String.format("%.4f", Double.parseDouble(fromSurcharge)));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 13, 2,
					String.format("%.4f", Double.parseDouble(fromSurcharge)));
		}
		if (fromCommission.contains("%")) {
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 8, 1, "Percentage (%)");
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 8, 2,
					fromCommission.replace("%", ""));
			double fromCom = (Double.parseDouble(fromCommission.replace("%", ""))
					* Double.parseDouble(transactionAmount)) / 100;
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 8, 3,
					String.format("%.4f", fromCom));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 13, 4,
					String.format("%.4f", fromCom));
		} else {
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 8, 1, "Fix Value");
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 8, 2,
					String.format("%.4f", Double.parseDouble(fromCommission)));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 8, 3,
					String.format("%.4f", Double.parseDouble(fromCommission)));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 13, 4,
					String.format("%.4f", Double.parseDouble(fromCommission)));
		}
		if (toSurcharge.contains("%")) {
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 9, 1, "Percentage (%)");
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 9, 2,
					toSurcharge.replace("%", ""));
			double toSur = (Double.parseDouble(toSurcharge.replace("%", "")) * Double.parseDouble(transactionAmount))
					/ 100;
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 9, 3,
					String.format("%.4f", toSur));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 13, 6,
					String.format("%.4f", toSur));
		} else {
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 9, 1, "Fix Value");
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 9, 2,
					String.format("%.4f", Double.parseDouble(toSurcharge)));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 9, 3,
					String.format("%.4f", Double.parseDouble(toSurcharge)));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 13, 6,
					String.format("%.4f", Double.parseDouble(toSurcharge)));
		}
		if (toCommission.contains("%")) {
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 10, 1, "Percentage (%)");
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 10, 2,
					toCommission.replace("%", ""));
			double toCom = (Double.parseDouble(toCommission.replace("%", "")) * Double.parseDouble(transactionAmount))
					/ 100;
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 10, 3,
					String.format("%.4f", toCom));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 13, 8,
					String.format("%.4f", toCom));
		} else {
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 10, 1, "Fix Value");
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 10, 2,
					String.format("%.4f", Double.parseDouble(toCommission)));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 10, 3,
					String.format("%.4f", Double.parseDouble(toCommission)));
			ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 13, 8,
					String.format("%.4f", Double.parseDouble(toCommission)));
		}
		ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 13, 1,
				String.format("%.4f", Double.parseDouble(transactionAmount)));
		double bal = Double.parseDouble(ExcelUtility.getCellData(newTransactionFileName, transactionSheetName, 0, 4))
				- Double.parseDouble(ExcelUtility.getCellData(newTransactionFileName, transactionSheetName, 6, 1))
				- Double.parseDouble(ExcelUtility.getCellData(newTransactionFileName, transactionSheetName, 13, 2))
				+ Double.parseDouble(ExcelUtility.getCellData(newTransactionFileName, transactionSheetName, 13, 4));
		ExcelUtility.setCellDataWithFormate(newTransactionFileName, transactionSheetName, 2, 4,
				String.format("%.4f", bal));
		return newTransactionFileName;
	}

	public void verifyTransactionCalculator(String fileName) {
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 13, 1)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 14, 1)))
			throw new RuntimeException("Transaction Amount Mis-match...");
		else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 1, "Pass");
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 13, 2)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 14, 2)))
			throw new RuntimeException("From Surcharge Mis-match...");
		else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 2, "Pass");
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 13, 4)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 14, 4)))
			throw new RuntimeException("From Commission Mis-match...");
		else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 4, "Pass");
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 13, 6)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 14, 6)))
			throw new RuntimeException("To Surcharge Mis-match...");
		else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 6, "Pass");
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 13, 8)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 14, 8)))
			throw new RuntimeException("To Commission Mis-match...");
		else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 15, 8, "Pass");
		if (!ExcelUtility.getCellData(fileName, transactionSheetName, 1, 4)
				.equals(ExcelUtility.getCellData(fileName, transactionSheetName, 2, 4)))
			throw new RuntimeException("Closing Balance Mis-match...");
		else
			ExcelUtility.setCellDataWithFormate(fileName, transactionSheetName, 3, 4, "Pass");
	}

	public void setUseCaseVerificationData(String methodName, Map<String, ArrayList<Map<Object, Object>>> data,
			Map<Object, Object> map) {
		if (data.get(methodName) != null) {
			data.get(methodName).add(retriveData(map));
		} else {
			ArrayList<Map<Object, Object>> al = new ArrayList<>();
			al.add(retriveData(map));
			data.put(methodName, al);
		}
	}

	public void setUseCaseVerificationDataMultiTransaction(String methodName, String trnId,
			Map<String, ArrayList<Map<Object, Object>>> data, Map<Object, Object> map) {
		if (data.get(methodName) != null) {
			data.get(methodName).add(retriveData(map));
		} else {
			ArrayList<Map<Object, Object>> al = new ArrayList<>();
			al.add(retriveData(map));
			data.put(methodName, al);
		}
	}

	public Map<Object, Object> retriveData(Map<Object, Object> map) {
		Map<Object, Object> dataMap = new LinkedHashMap<>();
		for (Map.Entry<Object, Object> e : map.entrySet()) {
			dataMap.put(e.getKey(), e.getValue());
		}
		return dataMap;
	}

	public boolean verifyMethodIsAvail(Map<String, ArrayList<Map<Object, Object>>> verificationData2,
			String methodName) {
		for (Map.Entry<String, ArrayList<Map<Object, Object>>> m : verificationData2.entrySet()) {
			if (m.getKey().toString().equalsIgnoreCase(methodName))
				return true;
		}
		return false;
	}
}