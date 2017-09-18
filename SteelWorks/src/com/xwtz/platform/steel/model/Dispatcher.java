package com.xwtz.platform.steel.model;

import com.xwtz.platform.steel.report.Report;
import com.xwtz.platform.steel.report.ReportFactory;
import com.xwtz.platform.steel.report.ReportFactoryConsole;


public class Dispatcher {
	private static Report eventReport;
	private static ReportFactory reportFactory = new ReportFactoryConsole();
	private static boolean isReportDisabled;
	private static boolean isRunningUI = false;
	private static boolean exitHookStarted = false;

	public static void setReporter(String eventReportFileName) throws BigDataDealException {
		eventReport = reportFactory.newReport(eventReportFileName);
	}

	public static void disableReport() {
		isReportDisabled = true;
	}

	public static void enableReport() {
		isReportDisabled = false;
	}

	public static boolean isReportDisabled() {
		return isReportDisabled;
	}

	public static Report getReporter() {
		return eventReport;
	}

	public static void setReportFactory(ReportFactory reportFactory) {
		Dispatcher.reportFactory = reportFactory;
	}

	public static ReportFactory getReportFactory() {
		return reportFactory;
	}

	public static boolean isRunningInUI() {
		return isRunningUI;
	}

	public static void setRunningInUI(boolean ui) {
		isRunningUI = ui;
	}

	public static void exit(int code) {
		if (!exitHookStarted) {
			System.exit(code);
		}
	}
	public static void exitHookStarted() {
        exitHookStarted = true;
    }
}
