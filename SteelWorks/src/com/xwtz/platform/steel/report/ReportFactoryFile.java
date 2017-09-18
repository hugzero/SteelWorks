package com.xwtz.platform.steel.report;


import java.io.*;

import com.xwtz.platform.steel.model.BigDataDealException;
import com.xwtz.platform.steel.model.Dispatcher;
import com.xwtz.platform.steel.ui.startup.DataDeal;

/**
 * Create a report that write events into the reports directory
 * @author Florent Guiliani
 */
public class ReportFactoryFile implements ReportFactory {
    private final static String FILE_SEP = System.getProperty("file.separator");
    public final static String REPORT_DIR = DataDeal.getAppPath() + FILE_SEP + "reports" + FILE_SEP;

    public Report newReport(String fileName) throws BigDataDealException {
//        PreferencesHolder prefs = PreferencesHolder.getInstance();
//        String reportRendererClass = prefs.get(JBTPreferences.ReportRenderer);

        ReportRenderer renderer;
        try {
//            Class<? extends ReportRenderer> clazz = Class.forName(reportRendererClass).asSubclass(ReportRenderer.class);
//            renderer = clazz.newInstance();
        } catch (Exception e) {
            throw new BigDataDealException(e);
        }

        PrintWriter writer = null;
        if (!Dispatcher.isReportDisabled()) {
            // P.S., change -->
            String fullFileName = fileName;
            if (fullFileName.indexOf(FILE_SEP) < 0) {
                File reportDir = new File(REPORT_DIR);
                if (!reportDir.exists()) {
                    reportDir.mkdir();
                }
            	
//            	fullFileName = REPORT_DIR + fileName + "." + renderer.getFileExtension();
            }
        }

//        return new SingleReport(renderer, writer);
        return null ;
    }

}
