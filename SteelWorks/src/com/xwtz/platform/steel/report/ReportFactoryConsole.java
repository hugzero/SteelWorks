package com.xwtz.platform.steel.report;

import java.io.PrintWriter;

import com.xwtz.platform.steel.model.BigDataDealException;


/**
 * 创建一个报告，在标准输出和报告目录中写入事件
 * 
 * @author 10960
 * 
 */
public class ReportFactoryConsole implements ReportFactory {

	@Override
	public Report newReport(String fileName) throws BigDataDealException {
		MultiReport multireport = new MultiReport();
		multireport.addReport(new SingleReport(new TextReportRenderer(),
				new PrintWriter(System.out)));
		multireport.addReport(new ReportFactoryFile().newReport(fileName));
		return multireport;
	}

}
