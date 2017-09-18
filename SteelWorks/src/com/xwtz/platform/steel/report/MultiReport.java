package com.xwtz.platform.steel.report;

import java.util.LinkedList;
import java.util.List;

/**
 * 将报告事件广播到许多报告实例的报告
 * 
 * @author 10960
 * 
 */
public class MultiReport extends AbstractReport {
	private LinkedList<Report> reports = new LinkedList<Report>();

	public MultiReport() {

	}

	public void addReport(Report report) {
		reports.add(report);
	}

	@Override
	public void report(StringBuilder message) {
		for (Report report : reports) {
			report.report(message);
		}
	}

	@Override
	public void report(String message) {
		for (Report report : reports) {
			report.report(message);
		}
	}

	@Override
	public void report(Throwable t) {
		for (Report report : reports) {
			report.report(t);
		}
	}

	@Override
	public void reportDescription(String message) {
		for (Report report : reports) {
			report.reportDescription(message);
		}
	}

	@Override
	public void report(List<?> columns) {
		for (Report report : reports) {
			report.report(columns);
		}
	}

	@Override
	public void report(List<?> columns, String time) {
		for (Report report : reports) {
			report.report(columns, time);
		}
	}

}
