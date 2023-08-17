package listeners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.collections.Lists;
import org.testng.internal.Utils;
import org.testng.xml.XmlSuite;

import utils.Utility;

public class HtmlReport implements IReporter {
	public static LinkedHashMap<String, LinkedHashSet<String>> passedMap = new LinkedHashMap<>();
	public static LinkedHashMap<String, LinkedHashSet<String>> failedMap = new LinkedHashMap<>();
	public static LinkedHashMap<String, LinkedHashSet<String>> skipedMap = new LinkedHashMap<>();
	private PrintWriter out;
	private Integer testIndex;
	static int passRecords = 0;
	static int failRecords = 0;
	static int skipRecords = 0;
	static int passCaseCount = 0;
	static int failCaseCount = 0;
	static int skipCaseCount = 0;
	Map<String, Integer> passedData;
	Map<String, Integer> failedData;
	Map<String, Integer> skippedData;
	private String projectName = "Tangerine";
	private String userType = System.getProperty("userType");
	private String subUserType = System.getProperty("subUserType");
	private String buildNumber = System.getProperty("latestRelease");
	private String automationType = "Web - Portal";
	private Scanner scanner;
	private static int counter;
	public static String executor;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		outputDirectory = outputDirectory + File.separator + "HTML Reports";
		File f = new File(outputDirectory);
		if (!f.exists())
			f.mkdir();
		Utility.copyFolder(new File("./dependencies/html report"), new File(outputDirectory));
		List<ISuite> temp = new ArrayList<ISuite>();
		Map<Date, ISuite> map = new LinkedHashMap<Date, ISuite>();
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> tests = suite.getResults();
			for (ISuiteResult r : tests.values()) {
				ITestContext overview = r.getTestContext();
				map.put(overview.getStartDate(), suite);
			}
		}
		Set<Date> keySet = map.keySet();
		List<Date> keys = new ArrayList<Date>(keySet);
		Collections.sort(keys);
		for (int i = 0; i < keys.size(); i++) {
			temp.add(map.get(keys.get(i)));
		}
		LinkedHashSet<ISuite> hashSet = new LinkedHashSet<ISuite>(temp);
		ArrayList<ISuite> listWithoutDuplicates = new ArrayList<ISuite>(hashSet);
		suites = listWithoutDuplicates;
		generateSuiteSummaryReport(suites, outputDirectory);
		generateMethodDetailReport(suites, outputDirectory);
	}

	private void generateSuiteSummaryReport(List<ISuite> suites, String outdir) {
		try {
			out = createWriter(outdir, "index.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		startHTML("Automation Execution Summary");
		setExecutionConfigurationsDetails(suites);
		out.println("");
		addPieChart();
		out.println("");
		out.println("");
		new DecimalFormat("#,##0.0");
		passCaseCount = 0;
		skipCaseCount = 0;
		failCaseCount = 0;
		long time_start = Long.MAX_VALUE;
		long time_end = Long.MIN_VALUE;
		testIndex = 1;
		passedData = getPassedData(suites);
		failedData = getFailedData(suites);
		skippedData = getSkipedData(suites);
		for (ISuite suite : suites) {
			out.println("<section class='content'>");
			out.println("<div class='container-fluid'>");
			out.println("<div class='row'>");
			out.println("<div class='col-18'>");
			out.println("<div class='card'>");
			out.println("<div class='card-header'>");
			out.println("<h3 class='card-title'>" + suite.getName() + "</h3>");
			out.println("</div>");
			out.println("<!-- /.card-header -->");
			out.println("<div class='card-body'>");
			out.println("<table id='example1' class='table table-bordered table-striped'>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th>Test</th>");
			out.println("<th>Passed Cases</th>");
			out.println("<th>Failed Cases</th>");
			out.println("<th>Skipped Cases</th>");
			out.println("<th>Passed Records</th>");
			out.println("<th>Failed Record</th>");
			out.println("<th>Skipped Record</th>");
			out.println("<th>Start Time</th>");
			out.println("<th>End Time</th>");
			out.println("<th>Total Time (hh:mm:ss)</th>");
			out.println("");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			Map<String, ISuiteResult> tests = suite.getResults();
			Set<String> keySet = tests.keySet();
			List<String> keys = new ArrayList<String>(keySet);
			List<Date> list = new ArrayList<Date>();
			int count = 0;
			for (ISuiteResult r : tests.values()) {
				ITestContext overview = r.getTestContext();
				IResultMap skippedMethods = overview.getSkippedTests();
				IResultMap passedMethods = overview.getPassedTests();
				IResultMap failedMethods = overview.getFailedTests();
				for (ITestNGMethod a : passedMethods.getAllMethods()) {
					if (failedMethods.toString().contains(a.toString()))
						passedMethods.removeResult(a);
				}
				list.add(overview.getStartDate());
				int q = 0;
				Collection<ITestNGMethod> passMethodForExcel = setExcelMap(passedMap, passedMethods, suite);
				Collection<ITestNGMethod> failMethodForExcel = setExcelMap(failedMap, failedMethods, suite);
				Collection<ITestNGMethod> skipMethodForExcel = setExcelMap(skipedMap, skippedMethods, suite);
				q = passMethodForExcel.size();
				passCaseCount += q;
				out.println("<tr>");
				out.println("<td>" + overview.getName() + "</td>");
				out.println("<td>" + q + "");
				q = failMethodForExcel.size();
				failCaseCount += q;
				out.println("</td>");
				out.println("<td>" + q + "</td>");
				q = skipMethodForExcel.size();
				skipCaseCount += q;
				out.println("<td>" + q + "</td>");
				out.println("<td>" + passedData.get(keys.get(count)) + "</td>");
				passRecords = passRecords + passedData.get(keys.get(count));
				out.println("<td>" + failedData.get(keys.get(count)) + "</td>");
				failRecords = failRecords + failedData.get(keys.get(count));
				out.println("<td>" + skippedData.get(keys.get(count)) + "</td>");
				skipRecords = skipRecords + skippedData.get(keys.get(count));
				SimpleDateFormat summaryFormat = new SimpleDateFormat("hh:mm:ss");
				out.println("<td>" + summaryFormat.format(overview.getStartDate()) + "</td>");
				out.println("<td>" + summaryFormat.format(overview.getEndDate()) + "</td>");
				time_start = Math.min(overview.getStartDate().getTime(), time_start);
				time_end = Math.max(overview.getEndDate().getTime(), time_end);
				out.println("<td>"
						+ millisToTimeConversion(
								(overview.getEndDate().getTime() - overview.getStartDate().getTime()) / 1000)
						+ "</td>");
				out.println("</tr>");
				out.println("");
				out.println("");
				testIndex++;
				count++;
			}
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<!-- /.card-body -->");
		out.println("</div>");
		out.println("<!-- /.card -->");
		out.println("</div>");
		out.println("<!-- /.col -->");
		out.println("</div>");
		out.println("<!-- /.row -->");
		out.println("</div>");
		out.println("<!-- /.container-fluid -->");
		out.println("</section>");
		setSummarisedExecutionDetails(time_start, time_end);
		setFooter();
		endIndexHTML();
		out.flush();
		out.close();
	}

	private double getSuccessPercentage(List<ISuite> suites) {
		LinkedHashMap<String, LinkedHashSet<String>> passedMap = new LinkedHashMap<>();
		LinkedHashMap<String, LinkedHashSet<String>> failedMap = new LinkedHashMap<>();
		LinkedHashMap<String, LinkedHashSet<String>> skipedMap = new LinkedHashMap<>();
		new DecimalFormat("#,##0.0");
		int passCaseCount = 0;
		int skipCaseCount = 0;
		int failCaseCount = 0;
		int passRecords = 0;
		int failRecords = 0;
		int skipRecords = 0;
		Map<String, Integer> passedData = getPassedData(suites);
		Map<String, Integer> failedData = getFailedData(suites);
		Map<String, Integer> skippedData = getSkipedData(suites);
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> tests = suite.getResults();
			Set<String> keySet = tests.keySet();
			List<String> keys = new ArrayList<String>(keySet);
			List<Date> list = new ArrayList<Date>();
			int count = 0;
			for (ISuiteResult r : tests.values()) {
				ITestContext overview = r.getTestContext();
				IResultMap skippedMethods = overview.getSkippedTests();
				IResultMap passedMethods = overview.getPassedTests();
				IResultMap failedMethods = overview.getFailedTests();
				for (ITestNGMethod a : passedMethods.getAllMethods()) {
					if (failedMethods.toString().contains(a.toString()))
						passedMethods.removeResult(a);
				}
				list.add(overview.getStartDate());
				int q = 0;
				Collection<ITestNGMethod> passMethodForExcel = setExcelMap(passedMap, passedMethods, suite);
				Collection<ITestNGMethod> failMethodForExcel = setExcelMap(failedMap, failedMethods, suite);
				Collection<ITestNGMethod> skipMethodForExcel = setExcelMap(skipedMap, skippedMethods, suite);
				q = passMethodForExcel.size();
				passCaseCount += q;
				q = failMethodForExcel.size();
				failCaseCount += q;
				q = skipMethodForExcel.size();
				skipCaseCount += q;
				passRecords = passRecords + passedData.get(keys.get(count));
				failRecords = failRecords + failedData.get(keys.get(count));
				skipRecords = skipRecords + skippedData.get(keys.get(count));
				count++;
			}
		}
		return (100 * passCaseCount) / (passCaseCount + failCaseCount + skipCaseCount);
	}

	private void setSummarisedExecutionDetails(long time_start, long time_end) {
		out.println("<section class='content'>");
		out.println("");
		out.println("<div class='row'>");
		out.println("<div class='col-md-12'>");
		out.println("<div class='card'>");
		out.println("<div class='card-header'>");
		out.println("<h5 class='card-title'>Summarised Execution Details</h5>");
		out.println("");
		out.println("");
		out.println("</div>");
		out.println("<!-- /.card-header -->");
		out.println(" ");
		out.println("<!-- ./card-body -->");
		out.println("<div class='card-footer'>");
		out.println("<div class='row'>");
		out.println("<div class='col-sm-3 col-6'>");
		out.println("<div class='description-block border-right'>");
		out.println("<h5 class='description-header text-success'>" + passCaseCount + "</h5>");
		out.println("<span class='description-text'>Total Passed Cases</span>");
		out.println("</div>");
		out.println("<!-- /.description-block -->");
		out.println("</div>");
		out.println("<!-- /.col -->");
		out.println("<div class='col-sm-3 col-6'>");
		out.println("<div class='description-block border-right'>");
		out.println("<h5 class='description-header text-danger'>" + failCaseCount + "</h5>");
		out.println("<span class='description-text'>Total Failed Cases</span>");
		out.println("</div>");
		out.println("<!-- /.description-block -->");
		out.println("</div>");
		out.println("<!-- /.col -->");
		out.println("<div class='col-sm-3 col-6'>");
		out.println("<div class='description-block border-right'>");
		out.println("");
		out.println("<h5 class='description-header text-warning'>" + skipCaseCount + "</h5>");
		out.println("<span class='description-text'>Total Skipped Cases</span>");
		out.println("</div>");
		out.println("<!-- /.description-block -->");
		out.println("</div>");
		out.println("<!-- /.col -->");
		out.println("<div class='col-sm-3 col-6'>");
		out.println("<div class='description-block border-right'>");
		out.println("<h5 class='description-header text-success'>" + passRecords + "</h5>");
		out.println("<span class='description-text'>Total Passed Records</span>");
		out.println("</div>");
		out.println("<!-- /.description-block -->");
		out.println("</div>");
		out.println("<!-- /.col -->");
		out.println("<div class='col-sm-3 col-6'>");
		out.println("<div class='description-block border-right'>");
		out.println("<h5 class='description-header text-danger'>" + failRecords + "</h5>");
		out.println("<span class='description-text'>Total Failed Records</span>");
		out.println("</div>");
		out.println("<!-- /.description-block -->");
		out.println("</div>");
		out.println("<!-- /.col -->");
		out.println("<div class='col-sm-3 col-6'>");
		out.println("<div class='description-block border-right'>");
		out.println("");
		out.println("<h5 class='description-header text-warning'>" + skipRecords + "</h5>");
		out.println("<span class='description-text'>Total Skipped Records</span>");
		out.println("</div>");
		out.println("<!-- /.description-block -->");
		out.println("</div>");
		out.println("<!-- /.col -->");
		out.println("<div class='col-sm-3 col-6'>");
		out.println("<div class='description-block'>");
		out.println(" ");
		out.println(
				"<h5 class='description-header'>" + millisToTimeConversion(((time_end - time_start) / 1000)) + "</h5>");
		out.println("<span class='description-text'>Total Execution time (hh:mm:ss)</span>");
		out.println("</div>");
		out.println("<!-- /.description-block -->");
		out.println("</div>");
		out.println("</div>");
		out.println("<!-- /.row -->");
		out.println("</div>");
		out.println("<!-- /.card-footer -->");
		out.println("</div>");
		out.println("<!-- /.card -->");
		out.println("</div>");
		out.println("<!-- /.col -->");
		out.println("</div>");
		out.println("<!-- /.row -->");
		out.println("");
		out.println("</section>");
		out.println("</div>");
	}

	private void addPieChart() {
		out.println("<section class='content'>");
		out.println("");
		out.println("<div class='row'>");
		out.println("<div class='col-md-6'>");
		out.println("<div class='container-fluid'>");
		out.println("<!-- PIE CHART -->");
		out.println("<div class='card card-info'>");
		out.println("<div class='card-header'>");
		out.println("<h3 class='card-title'>Record Wise Ratio</h3>");
		out.println("");
		out.println("");
		out.println("</div>");
		out.println("<div class='card-body'>");
		out.println(
				"<canvas id='record' style='min-height: 250px; height: 250px; max-height: 250px; max-width: 100%;'></canvas>");
		out.println("</div>");
		out.println("<!-- /.card-body -->");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class='col-md-6'>");
		out.println("<div class='container-fluid'>");
		out.println("<div class='card card-info'>");
		out.println("<div class='card-header'>");
		out.println("<h3 class='card-title'>Test Sase Wise Ratio</h3>");
		out.println("");
		out.println("");
		out.println("</div>");
		out.println("<div class='card-body'>");
		out.println(
				"<canvas id='testcasewiseRatio' style='min-height: 250px; height: 250px; max-height: 250px; max-width: 100%;'></canvas>");
		out.println("</div>");
		out.println("<!-- /.card-body -->");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("");
		out.println("</section>");
	}

	private void generateMethodDetailReport(List<ISuite> suites, String outdir) {
		try {
			out = createWriter(outdir, "DetailedAnalysisData.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		startHTML("Detail Execution Summary");
		out.println("<section class='content'>");
		out.println("<div class='container-fluid'>");
		out.println("");
		out.println("");
		out.println("");
		out.println("<!-- /.row -->");
		out.println("");
		out.println("");
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> r = suite.getResults();
			for (ISuiteResult r2 : r.values()) {
				counter = 0;
				ITestContext testContext = r2.getTestContext();
				out.println("<div class='row'>");
				out.println("<div class='col-12'>");
				out.println("<div class='card'>");
				out.println("<div class='card-header'>");
				out.println(" <h3 class='card-title'>" + testContext.getName() + " </h3> <br>");
				out.println("</div>");
				out.println("<!-- ./card-header -->");
				out.println("<div class='card-body'>");
				resultDetail(sortMethod(testContext.getFailedTests()), testContext);
				resultDetail(sortMethod(testContext.getSkippedTests()), testContext);
				resultDetail(sortMethod(testContext.getPassedTests()), testContext);
				out.println("</tbody>");
				out.println("</table>");
				out.println("</div>");
				out.println("<!-- /.card-body -->");
				out.println("</div>");
				out.println("<!-- /.card -->");
				out.println("</div>");
				out.println("</div>");
				out.println("<!-- /.row -->");
			}
		}
		out.println("");
		out.println("</div><!-- /.container-fluid -->");
		out.println("</section>");
		out.println("</div>");
		setFooter();
		endSummaryHTML();
		out.flush();
		out.close();
	}

	private void setFooter() {
		out.println("<footer class='main-footer'>");
		out.println("<div class='float-right d-none d-sm-block'>");
		out.println("<b>Developed by</b> Automation Team");
		out.println("</div>");
		out.println(
				"<strong>Copyright &copy;<a href='https://www.panamaxil.com/' target=#>Panamax Infotech Ltd</a>.</strong> All rights reserved.");
		out.println("</footer>");
	}

	private void endSummaryHTML() {
		out.print("<script src='plugins/jquery/jquery.min.js'></script>");
		out.print("<!-- Bootstrap 4 -->");
		out.print("<script src='plugins/bootstrap/js/bootstrap.bundle.min.js'></script>");
		out.print("<!-- AdminLTE App -->");
		out.print("<script src='dist/js/adminlte.min.js'></script>");
		out.print("<!-- AdminLTE for demo purposes -->");
		out.print("<script src='dist/js/demo.js'></script>");
		out.print("");
		out.print("</body>");
		out.print("</html>");
	}

	protected PrintWriter createWriter(String outdir, String reportFile) throws IOException {
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, reportFile))));
	}

	private void startHTML(String title) {
		InetAddress inetAddress = null;
		try {
			inetAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			out.println("IP address not available");
		}
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("<title>" + title + "</title>");
		out.println("");
		out.println("<!-- Google Font: Source Sans Pro -->");
		out.println(
				"<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback'>");
		out.println("<!-- Font Awesome -->");
		out.println("<link rel='stylesheet' href='plugins/fontawesome-free/css/all.min.css'>");
		out.println("<!-- DataTables -->");
		out.println("<link rel='stylesheet' href='plugins/datatables-bs4/css/dataTables.bootstrap4.min.css'>");
		out.println("<link rel='stylesheet' href='plugins/datatables-responsive/css/responsive.bootstrap4.min.css'>");
		out.println("<link rel='stylesheet' href='plugins/datatables-buttons/css/buttons.bootstrap4.min.css'>");
		out.println("<!-- Theme style -->");
		out.println("<link rel='stylesheet' href='dist/css/adminlte.min.css'>");
		out.println("</head>");
		out.println("<body class='hold-transition sidebar-mini'>");

		out.println("<div class='wrapper'>");
		out.println("<!-- Navbar -->");
		out.println("<nav class='main-header navbar navbar-expand navbar-white navbar-light'>");
		out.println("<!-- Left navbar links -->");
		out.println("<ul class='navbar-nav'>");
		out.println("<li class='nav-item'>");
		out.println(
				"<a class='nav-link' data-widget='pushmenu' href='#' role='button'> <img src='dist/img/menu.png' /></a>");
		out.println("</li>");
		out.println("");
		out.println("</ul>");
		out.println("");
		out.println("");
		out.println("");
		out.println("<!-- Right navbar links -->");
		out.println("<ul class='navbar-nav ml-auto'>");
		out.println("<!-- Messages Dropdown Menu -->");
		out.println("");
		out.println("<li class='nav-item'>");
		out.println("<a class='nav-link' data-widget='fullscreen' href='#' role='button'>");
		out.println("<img src='dist/img/fs.png' />");
		out.println("</a>");
		out.println("</li>");
		out.println("");
		out.println("</ul>");
		out.println("</nav>");
		out.println("<!-- /.navbar -->");
		out.println("");
		out.println("<!-- Main Sidebar Container -->");
		out.println("<aside class='main-sidebar sidebar-dark-primary elevation-4'>");
		out.println("<!-- Brand Logo -->");
		out.println("<a href='#' class='brand-link'>");
		out.println(
				"<img src='dist/img/logo.png' alt='Panamax Logo' class='brand-image img-circle elevation-3' style='opacity: .8'>");
		out.println("<span class='brand-text font-weight-light'>Panamax Infotech Ltd</span>");
		out.println("</a>");
		out.println("");
		out.println("<!-- Sidebar -->");
		out.println("<div class='sidebar'>");
		out.println("<!-- Sidebar user (optional) -->");
		out.println("");
		out.println("");
		out.println(" ");
		out.println("");
		out.println("<!-- Sidebar Menu -->");
		out.println("<nav class='mt-2'>");
		out.println(
				"<ul class='nav nav-pills nav-sidebar flex-column' data-widget='treeview' role='menu' data-accordion='false'>");
		out.println("<!-- Add icons to the links using the .nav-icon class");
		out.println(" with font-awesome or any other icon font library -->");
		out.println("<li class='nav-item'>");
		out.println("<a href='Index.html' class='nav-link'>");
		out.println(" <i class='nav-icon fas fa-tachometer-alt'></i>");
		out.println("<p>");
		out.println("Summary");
		out.println("");
		out.println("</p>");
		out.println("</a>");
		out.println("");
		out.println("</li>");
		out.println("");
		out.println("");
		out.println("");
		out.println("<li class='nav-item'>");
		out.println("<a href='DetailedAnalysisData.html' class='nav-link'>");
		out.println("<i class='nav-icon fas fa-table'></i>");
		out.println("<p>");
		out.println("Detailed Execution Result");
		out.println(" ");
		out.println("</p>");
		out.println("</a>");
		out.println("</li>");
		out.println("");
		out.println("");
		// out.println("<li class='nav-item'>");
		// out.println("<a href='AccessMetrics.html' class='nav-link'>");
		// out.println("<i class='nav-icon fas fa-copy'></i>");
		// out.println("<p>");
		// out.println("Accessibility Metrics");
		// out.println("");
		// out.println("</p>");
		// out.println("</a>");
		// out.println("</li>");
		out.println("</ul>");
		out.println("</nav>");
		out.println("<!-- /.sidebar-menu -->");
		out.println("</div>");
		out.println("<!-- /.sidebar -->");
		out.println("</aside>");
		out.println("");
		out.println("");
		out.println("");
		out.println("<!-- Content Wrapper. Contains page content -->");
		out.println("<div class='content-wrapper'>");
		out.println("<!-- Content Header (Page header) -->");
		out.println("<section class='content-header'>");
		out.println("<div class='container-fluid'>");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("<div class='row mb-2'>");
		out.println("<div class='col-sm-6'>");
		out.println("<h1 class='m-0'>" + title + "</h1>");
		out.println("</div><!-- /.col -->");
		out.println("<div class='col-sm-6'>");
		out.println("<ol class='breadcrumb float-sm-right'>");
		out.println("<li class='breadcrumb-item'>Execution Date</li>");
		out.println("<li class='breadcrumb-item'>Executor IP</li>");
		out.println("<li class='breadcrumb-item'>Executor Name</li>");
		out.println("</ol>");
		out.println("<ol class='breadcrumb float-sm-right'>");
		out.println("<li class='breadcrumb-item'>" + Utility.getCurrentDateTime("dd:MM:yyyy hh:mm:ss") + "</li>");
		out.println("<li class='breadcrumb-item'>" + inetAddress.getHostAddress() + "</li>");
		try {
			out.println("<li class='breadcrumb-item'>" + InetAddress.getLocalHost().getHostName() + "</li>");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</ol>");
		out.println("</div><!-- /.col -->");
		out.println("</div><!-- /.row -->");
		out.println("</div><!-- /.container-fluid -->");
		out.println("</section>");
		out.println("");
		out.println("");
		out.println("");
	}

	private void endIndexHTML() {
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("<!-- REQUIRED SCRIPTS -->");
		out.println("<!-- jQuery -->");
		out.println("<script src='plugins/jquery/jquery.min.js'></script>");
		out.println("<!-- Bootstrap -->");
		out.println("<script src='plugins/bootstrap/js/bootstrap.bundle.min.js'></script>");
		out.println("");
		out.println("<!-- AdminLTE App -->");
		out.println("<script src='dist/js/adminlte.js'></script>");
		out.println("");
		out.println("<!-- PAGE /plugins -->");
		out.println("");
		out.println("");
		out.println("<!-- AdminLTE for demo purposes -->");
		out.println("<script src='dist/js/demo.js'></script>");
		out.println("<!-- AdminLTE dashboard demo (This is only for demo purposes) -->");
		out.println("<script src='dist/js/pages/dashboard2.js'></script>");
		out.println("");
		out.println("");
		out.println("");
		out.println("</div>");
		out.println("<!-- ./wrapper -->");
		out.println("");
		out.println("<!-- jQuery -->");
		out.println("<script src='plugins/jquery/jquery.min.js'></script>");
		out.println("<!-- Bootstrap 4 -->");
		out.println("<script src='plugins/bootstrap/js/bootstrap.bundle.min.js'></script>");
		out.println("<!-- ChartJS -->");
		out.println("<script src='plugins/chart.js/Chart.min.js'></script>");
		out.println("<!-- AdminLTE App -->");
		out.println("<script src='dist/js/adminlte.min.js'></script>");
		out.println("<!-- AdminLTE for demo purposes -->");
		out.println("<script src='dist/js/demo.js'></script>");
		out.println("");
		out.println("");
		out.println(" ");
		out.println("<!-- /.control-sidebar -->");
		out.println("</div>");
		out.println("<!-- ./wrapper -->");
		out.println("");
		out.println("<!-- DataTables& Plugins -->");
		out.println("<script src='plugins/datatables/jquery.dataTables.min.js'></script>");
		out.println("<script src='plugins/datatables-bs4/js/dataTables.bootstrap4.min.js'></script>");
		out.println("");
		out.println("<script src='plugins/datatables-responsive/js/dataTables.responsive.min.js'></script>");
		out.println("<script src='plugins/datatables-responsive/js/responsive.bootstrap4.min.js'></script>");
		out.println("");
		out.println("");
		out.println("");
		out.println("<script src='plugins/jszip/jszip.min.js'></script>");
		out.println("");
		out.println("<script src='plugins/pdfmake/pdfmake.min.js'></script>");
		out.println("<script src='plugins/pdfmake/vfs_fonts.js'></script>");
		out.println("");
		out.println("<script src='plugins/datatables-buttons/js/buttons.html5.min.js'></script>");
		out.println("<script src='plugins/datatables-buttons/js/buttons.print.min.js'></script>");
		out.println("<script src='plugins/datatables-buttons/js/buttons.colVis.min.js'></script>");
		out.println("<script src='plugins/datatables-buttons/js/dataTables.buttons.min.js'></script>");
		out.println("<script src='plugins/datatables-buttons/js/buttons.bootstrap4.min.js'></script>");
		out.println("<!-- AdminLTE App -->");
		out.println("<script src='dist/js/adminlte.min.js'></script>");
		out.println("<!-- AdminLTE for demo purposes -->");
		out.println("<script src='dist/js/demo.js'></script>");
		out.println("<!-- Page specific script -->");
		out.println("");
		out.println("");
		out.println("<script>");
		out.println("$(function () {");
		out.println("/* ChartJS");
		out.println(" * -------");
		out.println(" * Here we will create a few charts using ChartJS");
		out.println(" */");
		out.println("");
		out.println("var donutData= {");
		out.println("labels: [");
		out.println("'Pass',");
		out.println("'Fail',");
		out.println("'Skip',");
		out.println("],");
		out.println("datasets: [");
		out.println("{");
		out.println("data: [" + passCaseCount + "," + failCaseCount + "," + skipCaseCount + ",],");
		out.println("backgroundColor : ['#00a65a','#f56954', '#f39c12'],");
		out.println("}");
		out.println("]");
		out.println("}");
		out.println("");
		out.println("var testcaseWiseRecords= {");
		out.println("labels: [");
		out.println("'Pass',");
		out.println("'Fail',");
		out.println("'Skip',");
		out.println("],");
		out.println("datasets: [");
		out.println("{");
		out.println("data: [" + passRecords + "," + failRecords + "," + skipRecords + ",],");
		out.println("backgroundColor : ['#00a65a','#f56954', '#f39c12'],");
		out.println("}");
		out.println("]");
		out.println("}");
		out.println(" ");
		out.println("");
		out.println("");
		out.println("//-------------");
		out.println("//- PIE CHART -");
		out.println("//-------------");
		out.println("// Get context with jQuery - using jQuery's .get() method.");
		out.println("var pieChartCanvas = $('#record').get(0).getContext('2d')");
		out.println("var pieData= donutData;");
		out.println("var pieOptions = {");
		out.println("maintainAspectRatio : false,");
		out.println("responsive : true,");
		out.println("}");
		out.println("//Create pie or douhnut chart");
		out.println("// You can switch between pie and douhnut using the method below.");
		out.println("var pieChart = new Chart(pieChartCanvas, {");
		out.println("type: 'pie',");
		out.println("data: pieData,");
		out.println("options: pieOptions");
		out.println("})");
		out.println("");
		out.println("//-------------");
		out.println("//- Test cases -");
		out.println("//-------------");
		out.println("// Get context with jQuery - using jQuery's .get() method.");
		out.println("var pieChartCanvas1 = $('#testcasewiseRatio').get(0).getContext('2d')");
		out.println("var pieData1= testcaseWiseRecords;");
		out.println("var pieOptions1 = {");
		out.println("maintainAspectRatio : false,");
		out.println("responsive : true,");
		out.println("}");
		out.println("//Create pie or douhnut chart");
		out.println("// You can switch between pie and douhnut using the method below.");
		out.println("var pieChart = new Chart(pieChartCanvas1, {");
		out.println("type: 'pie',");
		out.println("data: pieData1,");
		out.println("options: pieOptions1");
		out.println("})");
		out.println("");
		out.println("");
		out.println(" ");
		out.println("})");
		out.println("</script>");
		out.println("<script>");
		out.println("$(function () {");
		out.println("$('#example1').DataTable({");
		out.println("'responsive': true, 'lengthChange': true, 'autoWidth': true,");
		out.println("'buttons': ['copy', 'csv', 'excel', 'pdf', 'print', 'colvis']");
		out.println("}).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');");
		out.println("");
		out.println("});");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}

	private String millisToTimeConversion(long seconds) {
		final int MINUTES_IN_AN_HOUR = 60;
		final int SECONDS_IN_A_MINUTE = 60;
		int minutes = (int) (seconds / SECONDS_IN_A_MINUTE);
		seconds -= minutes * SECONDS_IN_A_MINUTE;
		int hours = minutes / MINUTES_IN_AN_HOUR;
		minutes -= hours * MINUTES_IN_AN_HOUR;
		return prefixZeroToDigit(hours) + ":" + prefixZeroToDigit(minutes) + ":" + prefixZeroToDigit((int) seconds);
	}

	private String prefixZeroToDigit(int num) {
		int number = num;
		if (number <= 9) {
			String sNumber = "0" + number;
			return sNumber;
		} else
			return "" + number;
	}

	private void setExecutionConfigurationsDetails(List<ISuite> suites) {
		out.println("<section class='content'>");
		out.println("<div class='container-fluid'>");
		out.println("<!-- Info boxes -->");
		out.println(" <div class='row'>");
		out.println("<div class='col-12'>");
		out.println("<div class='card'>");
		out.println("<div class='card-header'>");
		out.println("<h3 class='card-title'>Execution entities and details</h3>");
		out.println("</div>");
		out.println("<!-- /.card-header -->");
		out.println("<div class='card-body'>");
		out.println("<table class='table table-bordered'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th >Project Name</th>");
		out.println("<th>Access Channel</th>");
		out.println("<th >User Type</th>");
		out.println("<th >Access Channel Type</th>");
		out.println("<th>MR / Build Version</th>");
		out.println("<th >Execution result (%)</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		out.println("");
		out.println("");
		out.println("<tr>");
		out.println("<td class='align-middle'>" + projectName + "</td>");
		out.println("<td text-align='center'> " + userType + "</td>");
		out.println("<td text-align='center'>" + subUserType + "</td>");
		out.println("<td text-align='center'>" + automationType + "</td>");
		out.println("<td class='align-middle'> " + buildNumber + " </td>");
		out.println("<td text-align='center'> " + getSuccessPercentage(suites) + " %</td>");
		out.println("</tr>");
		out.println("");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("");
		out.println("</div>");
		out.println("<!-- /.card -->");
		out.println("");
		out.println(" ");
		out.println("<!-- /.row -->");
		out.println("");
		out.println("</div>");
		out.println("");
		out.println("</section>");
	}

	private Map<String, Integer> getPassedData(List<ISuite> suites) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (ISuite suite : suites) {
			int count = 0;
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			Set<String> keySet = suiteResults.keySet();
			List<String> keys = new ArrayList<String>(keySet);
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				map.put(keys.get(count), tc.getPassedTests().getAllResults().size());
				count++;
			}
		}
		return map;
	}

	private Map<String, Integer> getFailedData(List<ISuite> suites) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (ISuite suite : suites) {
			int count = 0;
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			Set<String> keySet = suiteResults.keySet();
			List<String> keys = new ArrayList<String>(keySet);
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				map.put(keys.get(count), tc.getFailedTests().getAllResults().size());
				count++;
			}
		}
		return map;
	}

	private Map<String, Integer> getSkipedData(List<ISuite> suites) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (ISuite suite : suites) {
			int count = 0;
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			Set<String> keySet = suiteResults.keySet();
			List<String> keys = new ArrayList<String>(keySet);
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				map.put(keys.get(count), tc.getSkippedTests().getAllResults().size());
				count++;
			}
		}
		return map;
	}

	private Collection<ITestNGMethod> setExcelMap(LinkedHashMap<String, LinkedHashSet<String>> map,
			IResultMap resultMap, ISuite suite) {
		Collection<ITestNGMethod> iTestNGMethodCollection = getMethodSet(resultMap, suite);
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = iTestNGMethodCollection.iterator(); iterator.hasNext();) {
			ITestNGMethod iTestNGMethod = (ITestNGMethod) iterator.next();
			ITestClass testClassName = iTestNGMethod.getTestClass();
			String className = testClassName.getName();
			String methodName = iTestNGMethod.getMethodName();
			if (map.get(className.trim()) == null) {
				LinkedHashSet<String> methodSet = new LinkedHashSet<String>();
				methodSet.add(methodName.trim());
				map.put(className, methodSet);
			} else {
				LinkedHashSet<String> tempSet = map.get(className);
				tempSet.add(methodName);
				map.put(className, tempSet);
			}
		}
		return iTestNGMethodCollection;
	}

	private Collection<ITestNGMethod> getMethodSet(IResultMap tests, ISuite suite) {
		List<IInvokedMethod> r = Lists.newArrayList();
		List<IInvokedMethod> invokedMethods = suite.getAllInvokedMethods();
		Collection<ITestNGMethod> allInvokedTestMethods = tests.getAllMethods();
		for (IInvokedMethod im : invokedMethods) {
			if (allInvokedTestMethods.contains(im.getTestMethod()))
				r.add(im);
		}
		List<ITestNGMethod> result = Lists.newArrayList();
		for (IInvokedMethod m : r) {
			for (ITestNGMethod temp : result) {
				if (!temp.equals(m.getTestMethod()))
					result.add(m.getTestMethod());
			}
		}
		List<ITestNGMethod> allMethods = new ArrayList<ITestNGMethod>(allInvokedTestMethods);
		for (ITestNGMethod m : allMethods) {
			if (!result.contains(m))
				result.add(m);
		}
		return result;
	}

	private void resultDetail(IResultMap tests, ITestContext testContext) {
		Set<ITestResult> testResults = tests.getAllResults();
		List<ITestResult> list = new ArrayList<ITestResult>(testResults);
		for (int i = 0; i < list.size(); i++) {
			ITestNGMethod method = list.get(i).getMethod();
			String cname = method.getTestClass().getName();
			long end = Long.MIN_VALUE;
			long start = Long.MAX_VALUE;
			long startMS = 0;
			String firstLine = "";
			if (list.get(i).getEndMillis() > end)
				end = list.get(i).getEndMillis() / 1000;
			if (list.get(i).getStartMillis() < start) {
				startMS = list.get(i).getStartMillis();
				start = startMS / 1000;
			}
			Throwable exception = list.get(i).getThrowable();
			boolean hasThrowable = exception != null;
			if (hasThrowable) {
				String str = Utils.stackTrace(exception, true)[0];
				scanner = new Scanner(str);
				firstLine = scanner.nextLine();
			}
			DateFormat formatter = new SimpleDateFormat("kk:mm:ss");
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(startMS);
			if (counter == 0) {
				out.println("<h5 class='card-title'><b>Test Class:</b> " + cname + " </h5> <br><br>");
				out.println("<table class='table table-bordered table-hover'>");
				out.println("<thead>");
				out.println("<tr>");
				out.println("");
				out.println("<th>Test Scenario</th>");
				out.println("<th>Status</th>");
				out.println("<th>Failure Reason</th>");
				out.println("<th>Start Time (hh:mm:ss)</th>");
				out.println("<th>Execution Time (hh:mm:ss)</th>");
				out.println("</tr>");
				out.println("</thead>");
				out.println("<tbody>");
				counter++;
			}
			out.println("<tr data-widget='expandable-table' aria-expanded='false'>");
			out.println("");
			out.println("<td>" + method.getMethodName() + "</td>");
			switch (list.get(i).getStatus()) {
			case 1:
				out.println("<td ><center> <span class='badge bg-success' > Pass </span> </center></td>");
				break;
			case 2:
				out.println("<td ><center> <span class='badge bg-danger' > Fail </span> </center></td>");
				break;
			case 3:
				out.println("<td ><center> <span class='badge bg-warning' > Skip </span> </center></td>");
				break;
			}
			out.println("<td>" + firstLine + "</td>");
			out.println("<td>" + formatter.format(calendar.getTime()) + "</td>");
			out.println("<td>" + millisToTimeConversion(end - start) + "</td>");
			out.println("</tr>");
			out.println("<tr class='expandable-body'>");
			out.println("<td colspan='6'>");
			out.println(" <!-- /.card-header -->");
			out.println("<div class='card-body'>");
			out.println("<h5 class='card-title'><b>Test Data:</b></h5> <br>");
			Set<ITestResult> resultSet = tests.getResults(method);
			generateForResult(list.get(i), method, resultSet.size());
		}
	}

	private void generateForResult(ITestResult iTestResult, ITestNGMethod method, int size) {
		List<String> headers;
		List<String> values = null;
		Object[] parameters = iTestResult.getParameters();
		boolean hasParameters = parameters != null && parameters.length > 0;
		if (hasParameters) {
			headers = new ArrayList<String>();
			values = new ArrayList<String>();
			String[] valueSet = Utils.escapeHtml(Utils.toString(parameters)).toString().split(",");
			for (int i = 0; i < valueSet.length; i++) {
				if (valueSet[i].contains("=")) {
					String[] valuesArray = valueSet[i].split("=");
					headers.add(valuesArray[0].replace("[{", ""));
					try {
						values.add(valuesArray[1].replace("}]", ""));
					} catch (ArrayIndexOutOfBoundsException e) {
						values.add("");
					}
				} else {
					String appendValue = values.get(values.size() - 1).concat(", ").concat(valueSet[i]);
					values.set(values.size() - 1, appendValue);
				}
			}
			out.println("<table class='table table-bordered'>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("");
			out.println("<th> Field Name</th>");
			out.println("<th>Value</th>");
			out.println("");
			out.println("");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			for (int x = 0; x < headers.size() && x < values.size(); x++) {
				out.println("<tr>");
				out.println("<td>" + headers.get(x) + "</td>");
				out.println("<td>" + values.get(x) + "</td>");
				out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("</div>");
			out.println("<div class='card-body'>");
		}
		out.println("<h5 class='card-title'><b>Performed Test Steps:</b></h5> <br>");
		out.println("<p>");
		List<String> msgs = Reporter.getOutput(iTestResult);
		boolean hasReporterOutput = msgs.size() > 0;
		Throwable exception = iTestResult.getThrowable();
		boolean hasThrowable = exception != null;
		if (hasReporterOutput || hasThrowable) {
			if (hasReporterOutput) {
				for (String line : msgs) {
					out.println(line + "<br/>");
				}
			}
			if (hasThrowable) {
				boolean wantsMinimalOutput = iTestResult.getStatus() == ITestResult.SUCCESS;
				if (hasReporterOutput) {
					out.println("<h5 class='card-title text-danger'>Failure Exception:</h5> <br>");
					out.println((wantsMinimalOutput ? "Expected Exception" : exception) + "</h2></b>");
				}
				// generateExceptionReport(exception, method);
			}
		}
	}

	private IResultMap sortMethod(IResultMap resultMap) {
		Map<ITestResult, ITestNGMethod> m_map = new LinkedHashMap<>();
		IResultMap resultMap1 = new IResultMap() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public int size() {
				return m_map.size();
			}

			@Override
			public void removeResult(ITestResult r) {
				m_map.remove(r);
			}

			@Override
			public void removeResult(ITestNGMethod m) {
				for (Entry<ITestResult, ITestNGMethod> entry : m_map.entrySet()) {
					if (entry.getValue().equals(m)) {
						m_map.remove(entry.getKey());
						return;
					}
				}
			}

			@Override
			public Set<ITestResult> getResults(ITestNGMethod method) {
				Set<ITestResult> result = new HashSet<>();
				for (Map.Entry<ITestResult, ITestNGMethod> entry : m_map.entrySet()) {
					if (entry.getValue().equals(method)) {
						result.add(entry.getKey());
					}
				}
				return result;
			}

			@Override
			public Set<ITestResult> getAllResults() {
				return m_map.keySet();
			}

			@Override
			public Collection<ITestNGMethod> getAllMethods() {
				return m_map.values();
			}

			@Override
			public void addResult(ITestResult result, ITestNGMethod method) {
				m_map.put(result, method);
			}
		};
		Set<ITestResult> result = resultMap.getAllResults();
		TreeMap<Object, ITestResult> map = new TreeMap<Object, ITestResult>();
		for (ITestResult tr : result) {
			map.put(tr.getStartMillis(), tr);
		}
		for (Map.Entry<Object, ITestResult> m : map.entrySet()) {
			resultMap1.addResult(m.getValue(), m.getValue().getMethod());
		}
		return resultMap1;
	}
}