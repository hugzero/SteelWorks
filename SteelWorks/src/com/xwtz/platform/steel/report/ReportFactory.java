package com.xwtz.platform.steel.report;

import com.xwtz.platform.steel.model.BigDataDealException;


public interface ReportFactory {
	Report newReport(String fileName) throws BigDataDealException;
}
