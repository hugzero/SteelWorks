package com.xwtz.platform.steel.ui.dialog;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.xwtz.platform.steel.bean.CokeMonth;
import com.xwtz.platform.steel.bean.SteelSum;
import com.xwtz.platform.steel.bean.SteelworksMonth;
import com.xwtz.platform.steel.dao.IndexDataDao;
import com.xwtz.platform.steel.dao.impl.CokeMonthDataDaoImpl;
import com.xwtz.platform.steel.dao.impl.SteelMonthDataDaoImpl;
import com.xwtz.platform.steel.dao.impl.SumIndexDataDaoImpl;
import com.xwtz.platform.steel.model.BigDataDealException;
import com.xwtz.platform.steel.tablemodel.CokeMonthTableModel;
import com.xwtz.platform.steel.tablemodel.SteelMonthTableModel;
import com.xwtz.platform.steel.tablemodel.SumIndexTableModel;

public class TestJscrollJtable extends JFrame implements ActionListener {
	private JMenuItem exitMenuItem, companydataMenuItem, companydayMenuItem, companymonthMenuItem,
			companyquarterMenuItem;
	private JTable typeTable, dayTypeTable, monthTypeTable, dataTypeJTable, quarterlyTypeTable;
	private JMenu sessionMenu;
	private CardLayout cardLayout;// 卡片布局管理器
	private JScrollPane jsp1, jsp2, jsp3;
	private final SumIndexTableModel sumIndexTableModel;
	private final SteelMonthTableModel steelMonthTableModel;
	private final CokeMonthTableModel cokeMonthTableModel;

	public TestJscrollJtable() throws BigDataDealException {
		sumIndexTableModel = new SumIndexTableModel();
		steelMonthTableModel = new SteelMonthTableModel();
		cokeMonthTableModel = new CokeMonthTableModel();
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
		companydayMenuItem = new JMenuItem("sumIndex");
		companymonthMenuItem = new JMenuItem("steelMonthmonth");
		companyquarterMenuItem = new JMenuItem("cokeMonthquarter");
		configureMenu.add(companydayMenuItem);
		configureMenu.add(companymonthMenuItem);
		configureMenu.add(companyquarterMenuItem);

		// menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(sessionMenu);
		menuBar.add(configureMenu);

		companydayMenuItem.addActionListener(this);
		companymonthMenuItem.addActionListener(this);
		companyquarterMenuItem.addActionListener(this);

		setJMenuBar(menuBar);

		jsp1 = new JScrollPane();
		jsp1.setAutoscrolls(true);
		dayTypeTable = new JTable(sumIndexTableModel);
		dayTypeTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jsp1.getViewport().add(dayTypeTable);
		add(jsp1, BorderLayout.CENTER);

		// jtable3

		jsp2 = new JScrollPane();
		jsp2.setAutoscrolls(true);
		monthTypeTable = new JTable(steelMonthTableModel);
		monthTypeTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jsp2.getViewport().add(monthTypeTable);
		add(jsp2, BorderLayout.CENTER);

		// table4
		jsp3 = new JScrollPane();
		jsp3.setAutoscrolls(true);
		quarterlyTypeTable = new JTable(cokeMonthTableModel);
		quarterlyTypeTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jsp3.getViewport().add(quarterlyTypeTable);
		add(jsp3, BorderLayout.CENTER);

		populateData();
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		this.add(jsp1, "2");
		this.add(jsp2, "3");
		this.add(jsp3, "4");
		this.setSize(590, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// 从数据库获取数据
	public void populateData() throws BigDataDealException {
		// jtable
		IndexDataDao steelSumiIndexDataDao = new SumIndexDataDaoImpl();
		List<SteelSum> queryList = (List<SteelSum>) steelSumiIndexDataDao.getAllList();
		for (int i = 0; i < queryList.size(); i++) {
			sumIndexTableModel.addSteelSum(queryList.get(i));
		}

		IndexDataDao steelmonthDataDao = new SteelMonthDataDaoImpl();
		List<SteelworksMonth> querySmonthList = (List<SteelworksMonth>) steelmonthDataDao.getAllList();
		for (int i = 0; i < querySmonthList.size(); i++) {
			steelMonthTableModel.addSteelworksMonth(querySmonthList.get(i));
		}

		IndexDataDao cokeMonthDataDao = new CokeMonthDataDaoImpl();
		List<CokeMonth> queryCmonthList = (List<CokeMonth>) cokeMonthDataDao.getAllList();
		for (int i = 0; i < queryCmonthList.size(); i++) {
			cokeMonthTableModel.addCokeMonth(queryCmonthList.get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == companydataMenuItem) {
			cardLayout.show(this.getContentPane(), "1");
		} else if (e.getSource() == companydayMenuItem) {
			cardLayout.show(this.getContentPane(), "2");
		} else if (e.getSource() == companymonthMenuItem) {
			cardLayout.show(this.getContentPane(), "3");
		} else if (e.getSource() == companyquarterMenuItem) {
			cardLayout.show(this.getContentPane(), "4");
		}

	}

	public static void main(String[] args) throws BigDataDealException {
		new TestJscrollJtable();
	}

}
