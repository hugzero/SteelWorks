package com.xwtz.platform.steel.ui.dialog;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.xwtz.platform.steel.model.BigDataDealException;
import com.xwtz.platform.steel.model.Dispatcher;
import com.xwtz.platform.steel.preference.JBTPreferences;
import com.xwtz.platform.steel.preference.PreferencesHolder;
import com.xwtz.platform.steel.ui.startup.DataDeal;

public class MainFrameController {
	private final MainFrameDialog mainViewDialog;
	private final PreferencesHolder prefs = PreferencesHolder.getInstance();

	public MainFrameController() throws BigDataDealException {
		mainViewDialog = new MainFrameDialog();
		// int width = prefs.getInt(JBTPreferences.MainWindowWidth);
		// int height = prefs.getInt(JBTPreferences.MainWindowHeight);
		int x = prefs.getInt(JBTPreferences.MainWindowX);
		int y = prefs.getInt(JBTPreferences.MainWindowY);
		// 得到显示器屏幕的宽高
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		// 定义窗体的宽高
		int windowsWedth = 600;
		int windowsHeight = 600;
		// 定义窗体的宽高
		if (width > 0 && height > 0) {
			// mainViewDialog.setBounds(x, y, width, height);
			// 设置窗体位置和大小
			mainViewDialog.setBounds((width - windowsWedth) / 2, (height - windowsHeight) / 2, windowsWedth,
					windowsHeight);
		}

		assignListeners();
	}

	private void assignListeners() {
		mainViewDialog.exitAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});

	}

	private void exit() {
		String question = "Are you sure you want to exit IdealTrading?";
		int answer = JOptionPane.showConfirmDialog(mainViewDialog, question, DataDeal.APP_NAME,
				JOptionPane.YES_NO_OPTION);
		if (answer == JOptionPane.YES_OPTION) {
			prefs.set(JBTPreferences.MainWindowWidth, mainViewDialog.getSize().width);
			prefs.set(JBTPreferences.MainWindowHeight, mainViewDialog.getSize().height);
			prefs.set(JBTPreferences.MainWindowX, mainViewDialog.getX());
			prefs.set(JBTPreferences.MainWindowY, mainViewDialog.getY());
			Dispatcher.exit(0);
		}
	}
}
