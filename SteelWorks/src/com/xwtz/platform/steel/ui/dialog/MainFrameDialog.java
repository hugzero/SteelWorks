package com.xwtz.platform.steel.ui.dialog;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.xwtz.platform.steel.bean.CokeMonth;
import com.xwtz.platform.steel.bean.SteelSum;
import com.xwtz.platform.steel.bean.SteelworksMonth;
import com.xwtz.platform.steel.dao.IndexDataDao;
import com.xwtz.platform.steel.dao.impl.CokeMonthDataDaoImpl;
import com.xwtz.platform.steel.dao.impl.SteelMonthDataDaoImpl;
import com.xwtz.platform.steel.dao.impl.SumIndexDataDaoImpl;
import com.xwtz.platform.steel.model.BigDataDealException;
import com.xwtz.platform.steel.ui.startup.DataDeal;

public class MainFrameDialog extends JFrame implements ActionListener {
	private Connection conn = null; // 数据库连接
	private final Toolkit toolkit;
	private JMenuItem exitMenuItem, companydataMenuItem, companydayMenuItem, companymonthMenuItem,
			companyquarterMenuItem;
	private JMenu sessionMenu;
	private boolean flag = false;
	private CardLayout cardLayout;// 卡片布局管理器
	private JScrollPane jScrollPane;// 使用卡片布局管理器的面板

	public MainFrameDialog() throws BigDataDealException {
		toolkit = Toolkit.getDefaultToolkit();
		init();
		populateData();
		setVisible(true);
		flag = true;
	}

	// 从数据库获取数据
	public void populateData() throws BigDataDealException {
		IndexDataDao steelSumiIndexDataDao = new SumIndexDataDaoImpl();
		List<SteelSum> queryList = (List<SteelSum>) steelSumiIndexDataDao.getAllList();
		for (int i = 0; i < queryList.size(); i++) {
		}

		IndexDataDao steelmonthDataDao = new SteelMonthDataDaoImpl();
		List<SteelworksMonth> querySmonthList = (List<SteelworksMonth>) steelmonthDataDao.getAllList();
		for (int i = 0; i < querySmonthList.size(); i++) {
		}

		IndexDataDao cokeMonthDataDao = new CokeMonthDataDaoImpl();
		List<CokeMonth> queryCmonthList = (List<CokeMonth>) cokeMonthDataDao.getAllList();
		for (int i = 0; i < queryCmonthList.size(); i++) {
		}

	}

	private void init() throws BigDataDealException {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		// session menu
		sessionMenu = new JMenu("Session");
		sessionMenu.setMnemonic('S');
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setMnemonic('X');
		sessionMenu.add(exitMenuItem);

		// configure menu
		JMenu configureMenu = new JMenu("CompanyDataFunctionList");
		configureMenu.setMnemonic('C');
		companydataMenuItem = new JMenuItem("companydata");
		companydayMenuItem = new JMenuItem("companyday");
		companymonthMenuItem = new JMenuItem("companymonth");
		companyquarterMenuItem = new JMenuItem("companyquarter");
		companydataMenuItem.setMnemonic('P');
		configureMenu.add(companydataMenuItem);
		configureMenu.add(companydayMenuItem);
		configureMenu.add(companymonthMenuItem);
		configureMenu.add(companyquarterMenuItem);

		// menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(sessionMenu);
		menuBar.add(configureMenu);

		// menuBar.add(helpMenu);
		setJMenuBar(menuBar);

		Image appIcon = Toolkit.getDefaultToolkit().getImage(getImageURL("IdealTrading.png"));
		setIconImage(appIcon);

		JLabel status = new JLabel(" ");
		status.setForeground(Color.GRAY);
		add(status, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(500, 309));
		setTitle(DataDeal.APP_NAME + " " + DataDeal.VERSION);
		pack();
		setLocationRelativeTo(null);
	}

	private URL getImageURL(String imageFileName) throws BigDataDealException {
		URL imgURL = ClassLoader.getSystemResource(imageFileName);
		if (imgURL == null) {
			String msg = "Could not locate " + imageFileName
					+ ". Make sure the /resources directory is in the classpath.";
			throw new BigDataDealException(msg);
		}
		return imgURL;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
