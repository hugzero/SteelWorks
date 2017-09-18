package com.xwtz.platform.steel.util;


import javax.swing.*;

import com.xwtz.platform.steel.ui.startup.DataDeal;


import java.awt.*;

/**
 * Utility class to display message and error dialogs.
 */
public class MessageDialog {

    private static boolean consoleMode = false;
    
    public static void showMessage(Component parent, String msg) {
        if(consoleMode) {
            System.err.println("INFO: "+msg);
        } else {
			JOptionPane.showMessageDialog(parent, msg, DataDeal.APP_NAME, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void showError(Component parent, String msg) {
        if(consoleMode) {
            System.err.println("ERROR: "+msg);            
        } else {
            JOptionPane.showMessageDialog(parent, msg, DataDeal.APP_NAME, JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void setConsoleMode(boolean activated) {
        consoleMode = activated;       
    }

}
