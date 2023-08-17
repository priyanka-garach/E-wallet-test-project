package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import bsh.This;

public class JenkinsMailService {

	private static Logger logger = Logger.getLogger(JenkinsMailService.class.getName());
	private static Properties PROPERTIES = new Properties();
	// private static String MAIL_SUBJECT = "Test";
	private static final String XPATH_METRICS_SUBJECT = "Hiiii";
	// private static final String TO_MAIL_IDS =
	// "badal.gandhi@panamaxil.com,dishant.doshi@panamaxil.com";
	// private static final String CC_MAIL_IDS =
	// "shivani.patel@panamaxil.com,dharti.patel@panamaxil.com";
	private static final String EMAIL_ID = "qa.panamax@gmail.com";
	private static final String EMAIL_PASSWORD = "Qa.123456";
	private static String taskName = "";
	private static float executionResult = 0;

	static {
		PROPERTIES.put("mail.smtp.auth", "true");
		PROPERTIES.put("mail.smtp.starttls.enable", "true");
		// PROPERTIES.put("mail.smtp.host", "zimbra-india.bankaigroup.com");
		// PROPERTIES.put("mail.smtp.port", "25");
		PROPERTIES.put("mail.smtp.host", "smtp.gmail.com");
		PROPERTIES.put("mail.smtp.port", "465");
		PROPERTIES.put("mail.smtp.socketFactory.port", "465");
		PROPERTIES.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	}

	/**
	 * @param resultMap
	 * @see this method is used to send result mail for xpath metrics
	 */
	public static void prepareAndSendXpthMetricsResult(Map<String, Boolean> resultMap) {
		try {
			Message message = getNewMessage();
			setMailRecipient(message, "dishant.doshi@panamaxil.com");
			setMailSubjectForXpath(message);
			setMailBody("asdasdadads", message);
			sendMail(message);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception in prepareAndSendXpthMetricsResult method", e);
		}
	}

	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\badal.gandhi\\Downloads\\Mobifin_5.0.2_Tangerine_Web_Admin_2020-10-06 17.23.05_Summary_Report.html");
		int count = 0;
		BufferedReader br;
		String style = "<style type=\"text/css\">Table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}td,th {border:1px solid #009;padding:.25em .5em}.result th {vertical-align:bottom}.param th {padding-left:1em;padding-right:1em}.param td {padding-left:.5em;padding-right:2em}.stripeeven td,.stripeodd td,.stripeeven th, .stripeodd th {background-color: #E6EBF9}.numi, .numi_Pass, .numi_Fail, .numi_Skip, .numi_Plain{text-align:center}.numi_Left{text-align:left}.total td {font-weight:bold}.numi_Pass {background-color: #ffffff}.numi_Header {background-color: #6dc6f2}.numi_Plain {background-color: #00802b}.numi_Fail {background-color: #e63900}.numi_Skip {background-color: #e6e600}.passedodd td {background-color: #0A8}.passedeven td {background-color: #8F9}.skippedodd td,.numi_attn {background-color: #CCC}.skippedodd td,.numi_attn {background-color: #DDD}.failedodd td,.numi_attn {background-color: #f47373}.failedeven td,.stripe .numi_attn {background-color: #f47373}.stacktrace {white-space:pre;font-family:monospace}.totop {font-size:85%;text-align:center;border-bottom:2px solid #000}#myBtn {display: none;position: fixed;bottom: 20px;right: 30px; z-index: 99;font-size: 25px;font-weight: bold;border: none;outline: none;background-color: #6dc6f2;color: black;cursor: pointer;padding: 15px;border-radius: 4px;}#myBtn:hover {background-color: #555;}</style>";
		String projectName = "5.0.3_Tangerine";
		String message = "<html><headr><title>Automation Execution Report Of Mobifin " + projectName.replace("_", " ")
				+ " On QA Environment" + "</title>" + style + "<body>";
		message = message + "<b>Hi All,</b></br> </br> <b>Below is the execution summary of</b> <b>Mobifin "
				+ projectName.replace("_", " ") + " On QA Environment" + "</b><b>,</b></br></br>";
		String st;
		try {
			br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
				if (st.contains("testOverview") && st.toLowerCase().contains("table") || count == 1) {
					count = 1;
					message = message + st.toString();
				}
				if (count != 0 && st.toLowerCase().contains("/table"))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		message = message + "</br><b> For more details please check attached execution report.</b></br>";
		message = message
				+ "</br><b>Please <a href=\"http://192.168.33.214:5601/goto/56b4f230b61cb923e0e3024857ac5334\">click here</a> to navigate to kibana dashboard and select following parameters on that</b></br><b>Project Name : Tangerine</b></br><b>Project Version : Mobifin_5.0.3</b></br><b>Automation Type : Web-Admin</b></br><b>Automation Cycle : 06_10_2020</b>";
		message = message + "</br></br><b>Thanks & Regards,</b></br><b> Automation Team</b></body></html>";
		prepareAndSendMail(projectName, "MR09", "nilay.masrani@panamaxil.com,kunal.jadav@panamaxil.com",
				"dishant.doshi@panamaxil.com,badal.gandhi@panamaxil.com,shivani.patel@panamaxil.com", message,
				"Mobifin_5.0.2_Tangerine_Web_Admin_2020-10-06 17.23.05_Summary_Report.html", 87);
		// br.close();
	}

	public static String getHead() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<head><title>Device List</title>");
		buffer.append(
				"<style type=\"text/css\"> table { border-collapse: collapse;border: 1px solid black;}th {background-color: #4CAF50;");
		buffer.append(
				"color: white;}th, td {padding: 10px;text-align: left;border: 1px solid black;}tr:hover {background-color: #f5f5f5;}");
		buffer.append("table.textFormat tr td th{font-size: 16px;}</style></head>");
		return buffer.toString();
	}

	/**
	 * @param toMailsIds
	 * @param ccMailIds
	 * @param message2
	 * @param attachment
	 * @param percentageBeforeReRun
	 * @param webType
	 * @see This method will prepare and send mail
	 */
	public static void prepareAndSendMail(String projectName, String release, String toMailsIds, String ccMailIds,
			String messageContent, String attachment, int percentageBeforeReRun) {
		try {
			// sStoreExecutionMailInFile(messageContent);
			Message message = getNewMessage();
			setMailRecipient(toMailsIds, message);
			if (!ccMailIds.isEmpty() && !ccMailIds.equals("na"))
				setCCMailRecipient(ccMailIds, message);
			setMailSubject(projectName, release, message, percentageBeforeReRun);
			setMailBody(message, messageContent, attachment);
			// setAttachment(message);
			sendMail(message);
		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		}
	}

	/**
	 * @see This method will return new message which has associated from email id
	 * @return Message
	 */
	public static Message getNewMessage() throws Exception {
		Session session = Session.getInstance(PROPERTIES, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL_ID, EMAIL_PASSWORD);
			}
		});
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(EMAIL_ID));
		return message;
	}

	/**
	 * @see This method will send mail
	 * @param message
	 */
	public static void sendMail(Message message) throws Exception {
		Transport.send(message);
	}

	/**
	 * @see This method will set mail recipient to message
	 * @param message
	 * @param TO_MAIL_IDS
	 */
	public static void setMailRecipient(String TO_MAIL_IDS, Message message) throws Exception {
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO_MAIL_IDS));
	}

	public static void setCCMailRecipient(String CC_MAIL_IDS, Message message) throws Exception {
		message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(CC_MAIL_IDS));
	}

	public static void setMailRecipient(Message message, String toEmailIds) throws Exception {
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailIds));
	}

	/**
	 * @param projectName
	 * @see This method will set mail subject to message
	 * @param message
	 * @param failRecord
	 * @param skipRecrd
	 * @param passRecrd
	 * @param failCase
	 * @param skipCase
	 * @param passCase
	 * @param percentageBeforeReRun
	 * @param latestRelease
	 * @throws MessagingException
	 */
	private static void setMailSubject(String projectName, String latestRelease, Message message,
			int percentageBeforeReRun) throws MessagingException {
		message.setSubject(
				"Automation job of " + projectName + " successfully executed.Result : " + percentageBeforeReRun + "%");
	}

	/**
	 * @see This method will set mail subject to message
	 * @param message
	 */
	private static void setMailSubjectForXpath(Message message) throws Exception {
		message.setSubject(XPATH_METRICS_SUBJECT);
	}

	/**
	 * @see This method will set mail body to message
	 * @param message
	 * @param attachment
	 * @param filename
	 */
	private static void setMailBody(Message message, String messageContent, String reportFile) throws Exception {
		String reportDir = "./test-output/";
		// String reportDir = "C:\\Users\\badal.gandhi\\Downloads\\";
		message.setContent(messageContent, "text/html");
		// This mail has 2 part, the BODY and the embedded image
		MimeMultipart multipart = new MimeMultipart("related");
		// first part (the html)
		BodyPart messageBodyPart = new MimeBodyPart();
		BodyPart messageBodyPart2 = new MimeBodyPart();
		// String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
		messageBodyPart.setContent(messageContent, "text/html");
		DataSource source = new FileDataSource(reportDir + reportFile);
		messageBodyPart2.setDataHandler(new DataHandler(source));
		messageBodyPart2.setFileName(reportFile);
		// add it
		multipart.addBodyPart(messageBodyPart);
		multipart.addBodyPart(messageBodyPart2);
		// second part (the image)
		messageBodyPart = new MimeBodyPart();
		File file = new File(reportDir + reportFile);
		DataSource fds = new FileDataSource(file);
		messageBodyPart.setDataHandler(new DataHandler(fds));
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
	}

	/**
	 * @see This method will set mail body to message
	 * @param message
	 */
	private static void setMailBody(String content, Message message) throws Exception {
		message.setContent(content, "text/html");
	}

	public static void StoreExecutionMailInFile(String data) {
		String currentDir = System.getProperty("user.dir");
		String folder = currentDir + "//ExecutionReportMail";
		try {
			File directory = new File(folder);
			if (!directory.exists()) {
				directory.mkdir();
			}
			String timeStamp = new SimpleDateFormat("dd_MM_YYYY").format(new Date());
			String fileName = folder + "//" + taskName + "--" + executionResult + "%_" + timeStamp + ".htm";

			File f = new File(fileName);
			if (!f.exists()) {
				f.createNewFile();
			}
			String head = taskName + "--" + executionResult + "%";
			String header = "<center><h3>" + head + "</center></h3>";
			Files.write(Paths.get(fileName), header.getBytes(), StandardOpenOption.APPEND);
			Files.write(Paths.get(fileName), data.getBytes(), StandardOpenOption.APPEND);
		} catch (Exception e) {
		}
	}
}
