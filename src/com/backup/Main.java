package com.backup;

import com.backup.app.MyApp;
import com.backup.gui.MyGUITool;
import com.backup.io.SystemFile;
import com.backup.io.SystemFileHandler;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Allan Jacques
 */
public class Main {

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            MyApp.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            MyApp.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            MyApp.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            MyApp.log(java.util.logging.Level.SEVERE, null, ex);
        }

        MyGUITool.doTraySystemIcon();

//        try {
//            this.systemFileHandler = SystemFileHandler.getInstance();
//            this.systemFile = MyApp.getSystemFile();
//        } catch (Exception ex) {
//            MyApp.log(Level.INFO, "Configuration file not found");
//            JOptionPane.showMessageDialog(null, MyApp.getAppText().getString("message.configurationFileNotFound"), MyApp.getAppText().getString("label.alert"), JOptionPane.INFORMATION_MESSAGE);
//            this.systemFile = new SystemFile();
//        }
        try {
            SystemFileHandler systemFileHandler = SystemFileHandler.getInstance();
            SystemFile loaded = systemFileHandler.load();
            MyApp.setSystemFile(loaded);
            BackupFactory.programBackups();
            BackupFactory.programCleaners();
        } catch (RuntimeException ex) {
            MyApp.log(Level.INFO, null, ex);
            if (ex.getCause().getCause() instanceof FileNotFoundException) {
                JOptionPane.showMessageDialog(null, MyApp.getAppText().getString("message.configurationFileNotFound"), MyApp.getAppText().getString("label.alert"), JOptionPane.INFORMATION_MESSAGE);
                MyApp.setSystemFile(new SystemFile());
            }
        }
    }

}
