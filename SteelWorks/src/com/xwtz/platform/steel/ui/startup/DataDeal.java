package com.xwtz.platform.steel.ui.startup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import com.birosoft.liquid.LiquidLookAndFeel;
import com.xwtz.platform.steel.model.BigDataDealException;
import com.xwtz.platform.steel.model.Dispatcher;
import com.xwtz.platform.steel.ui.dialog.MainFrameController;
import com.xwtz.platform.steel.util.MessageDialog;

public class DataDeal {
	public static final String APP_NAME = "DataDeal";
	public static final String VERSION = "1.01";
	public static final String RELEASE_DATE = "Sept 15, 2017";
	private static String appPath;

	/**
	 * 实例化应用程序必要部分，应用程序模型，视图和控制器
	 * 
	 * @throws BigDataDealException
	 */
	private DataDeal() throws BigDataDealException {
		try {
			LiquidLookAndFeel.setLiquidDecorations(true, "mac");
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Throwable t) {
			String msg = t.getMessage()
					+ ": Unable to set custom look & feel. The default L&F will be used.";
			MessageDialog.showMessage(null, msg);
		}

		// Set the color scheme explicitly
		ColorUIResource color = new ColorUIResource(102, 102, 153);
		UIManager.put("Label.foreground", color);
		UIManager.put("TitledBorder.titleColor", color);

		new MainFrameController();
	}

	public static void main(String[] args) {
		try {
			File file = new File(System.getProperty("user.home"), APP_NAME
					+ ".tmp");
			FileChannel channel = new RandomAccessFile(file, "rw").getChannel();

			if (channel.tryLock() == null) {
				throw new BigDataDealException(APP_NAME
						+ " is already running.");
			}

			if (args.length >= 1) {
//				setAppPath(args[0]);
//				Dispatcher.setReportFactory(new ReportFactoryFile());
//				Dispatcher.setReporter("EventReport");
//				Dispatcher.setRunningInUI(true);
				// Launch JBT GUI
				new DataDeal();
			} else {
				throw new BigDataDealException(
						"You omit to pass the JBT path in command line argument.");
			}
		} catch (Throwable t) {
			MessageDialog.showError(null, t.getMessage());
			if (Dispatcher.getReporter() != null) {
				Dispatcher.getReporter().report(t);
			}
			System.exit(-1);
		}

	}

	public static String getAppPath() {
		return DataDeal.appPath;
	}

	public static void setAppPath(String appPath) {
		DataDeal.appPath = appPath;
	}
}
