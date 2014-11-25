package com.backup.gui;

import com.backup.app.MyApp;
import com.backup.bean.ScheduledBackup;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import javax.swing.ImageIcon;

/**
 * @author Allan Jacques
 */
public class MyGUITool {

    private static SystemTray sTray;
    private static TrayIcon trayIcon;

    public static void doTraySystemIcon() {
        try {
            sTray = SystemTray.getSystemTray();

            PopupMenu popMenu = new PopupMenu();
            MenuItem miConfig = new MenuItem(MyApp.getAppText().getString("label.configuration"));
            miConfig.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    MyApp.showConfigurationFrame();
                }
            });
            popMenu.add(miConfig);

            MenuItem miCleaner = new MenuItem(MyApp.getAppText().getString("label.trayIconCleaning"));
            miCleaner.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    MyApp.showCleanerFrame();
                }
            });
            popMenu.add(miCleaner);

            MenuItem miExit = new MenuItem(MyApp.getAppText().getString("label.exit"));
            miExit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            popMenu.add(miExit);

            trayIcon = new TrayIcon(new ImageIcon(MyGUITool.class.getResource("images/backuper20.png")).getImage(), MyApp.getAppText().getString("application.name") + " - " + MyApp.getAppText().getString("application.slogan"), popMenu);
            trayIcon.setImageAutoSize(true);
            trayIcon.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        MyApp.showConfigurationFrame();
                    }
                }
            });
            sTray.add(trayIcon);
        } catch (Exception ex) {
            MyApp.log(Level.SEVERE, null, ex);
        }
    }

    public static void showErrorTrayMessage(ScheduledBackup scheduledBackup) {
        if (trayIcon != null) {
            trayIcon.displayMessage(MyApp.getAppText().getString("application.name"), MyApp.getFormattedText("message.trayBackupError", scheduledBackup.getPrefixName()), TrayIcon.MessageType.ERROR);
        }
    }

    public static void showTrayMessage(ScheduledBackup scheduledBackup) {
        if (trayIcon != null) {
            trayIcon.displayMessage(MyApp.getAppText().getString("application.name"), MyApp.getFormattedText("message.trayBackup", scheduledBackup.getPrefixName(), scheduledBackup.getDirectory()), TrayIcon.MessageType.INFO);
        }
    }
}
