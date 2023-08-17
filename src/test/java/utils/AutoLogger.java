package utils;

import org.testng.Reporter;

public class AutoLogger {
	private String tag = "";

	private final int ERROR = 0;
	private final int DEBUG = 2;
	private final int INFO = 1;

	public AutoLogger(Class<?> clazz) {
		tag = clazz.getName();
		if (tag.contains(".")) {
			tag = tag.substring(tag.lastIndexOf(".") + 1);
		}
	}

	private void console(String msg) {
		System.out.println(msg);
	}

	public void e(Object msg, Throwable e) {

		String printmsg = "";

		if (msg != null) {
			printmsg += msg.toString() + " ";
		}

		if (e != null) {
			printmsg += "Error: " + e.getMessage() + "<br/>";
			printmsg += getStackTrace(e);
		}

		finalLog(printmsg, ERROR, false);
	}

	private String getStackTrace(Object e) {
		String stackTrace = "";

		for (StackTraceElement ste : ((Throwable) e).getStackTrace()) {
			stackTrace += ste.toString() + "<br/>";
		}

		return "<div style='color:red; font-style:italic; padding-left:5em;'>"
				+ stackTrace + "</div>";
	}

	// Overload for e
	public void e(Exception e) {
		e(null, e);
	}

	// Overload for e
	public void e(Object msg) {
		e(msg, null);
	}

	public void e(String msg, Object... args) {
		e(String.format(msg, args));
	}

	public void i(String msg) {
		finalLog(msg, INFO, false);
	}

	public void i(String msg, Object... args) {
		i(String.format(msg, args));
	}

	public void d(String msg) {
		finalLog(msg, DEBUG, false);
	}

	public void d(String msg, Object... args) {
		d(String.format(msg, args));
	}

	// public void defect(String defectId, String defectSummary) {
	// String msg =
	// "<br/><span style='color:darkmagenta; font-weight:bold; padding-left:3em;'>Defect ("
	// + defectId
	// + ")</span>"
	// +
	// "<br/><span style='color:darkmagenta; padding-left:3em;'><b>Summary: </b>"
	// + defectSummary + "</span>";
	// finalLog(msg, INFO, false);
	// }
	//
	// public void defect(String defectSummary) {
	// defect("New", defectSummary);
	// }

	public void raw(String msg) {
		Reporter.log(msg, INFO);
	}

	private void finalLog(String msg, int level, boolean printConsole) {
		String printmsg = "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";

		/*printmsg += (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"))
				.format(new Date());
		printmsg += " " + tag;*/

		msg = msg.replace("\n", "<br/>");

		switch (level) {
		case DEBUG:
			printmsg += "(d): <span style='color:darkblue'>" + msg + "</span>";
			break;
		case ERROR:
			printmsg += "(e): <span style='color:red'>" + msg + "</span>";
			break;
		case INFO:
			printmsg += "(i): <span style='color:gray'>" + msg + "</span>";
			break;
		default:
			printmsg += "(?): <span style='color:brown'>" + msg + "</span>";
			break;
		}

		Reporter.log(printmsg, level);

		if (printConsole)
			console(printmsg);
	}

}
