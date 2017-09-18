package com.xwtz.platform.steel.ui.dialog;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

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
		int width = prefs.getInt(JBTPreferences.MainWindowWidth);
		int height = prefs.getInt(JBTPreferences.MainWindowHeight);
		int x = prefs.getInt(JBTPreferences.MainWindowX);
		int y = prefs.getInt(JBTPreferences.MainWindowY);

		if (width > 0 && height > 0) {
			mainViewDialog.setBounds(x, y, width, height);
		}

		assignListeners();
	}

	private void assignListeners() {
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
