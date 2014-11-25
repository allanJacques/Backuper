package com.backup.app;

import com.backup.gui.MyCleanerBackup;
import com.backup.gui.MyConfigBackup;
import com.backup.io.SystemFile;
import com.backup.utils.FileUtils;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JFrame;

/**
 * @author Allan Jacques
 */
public class MyApp {

    private final static ResourceBundle stringTexts = ResourceBundle.getBundle("com/messages/text_strings");
    private static JFrame principalFrame;
    private static JFrame cleanerFrame;
    private static SystemFile systemFile;
    private static final Logger logger = Logger.getLogger("Backuper");
    private static FileHandler fh;

    static {
        try {
            fh = new FileHandler(FileUtils.getLogFile().toString(), true);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
            logger.addHandler(fh);
        } catch (IOException ex) {
            Logger.getLogger(MyApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(MyApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResourceBundle getAppText() {
        return stringTexts;
    }

    public static String getFormattedText(final String key, final Object... params) {
        return MessageFormat.format(MyApp.getAppText().getString(key), params);
    }

    public static void setSystemFile(SystemFile systemFile) {
        if (MyApp.systemFile == null) {
            MyApp.systemFile = systemFile;
        } else {
            throw new RuntimeException("This object can't be defined again");
        }
    }

    public static SystemFile getSystemFile() {
        return MyApp.systemFile;
    }

    public static JFrame getPrincipalFrame() {
        return principalFrame;
    }

    public static void showConfigurationFrame() {
        if (principalFrame == null) {
            principalFrame = new MyConfigBackup();
        }
        principalFrame.setState(JFrame.ICONIFIED);
        principalFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        principalFrame.requestFocus();
        principalFrame.setVisible(true);
    }

    public static void showCleanerFrame() {
        if (cleanerFrame == null) {
            cleanerFrame = new MyCleanerBackup();
        }
        cleanerFrame.setState(JFrame.ICONIFIED);
        cleanerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cleanerFrame.requestFocus();
        cleanerFrame.setVisible(true);
    }

    public static void log(final Level level, final String msn, Object params) {
        MyApp.logger.log(level, msn, params);
        fh.flush();
    }

    public static void log(final Level level, final String msn, Object[] params) {
        MyApp.logger.log(level, msn, params);
        fh.flush();
    }

    public static void log(final Level level, final String msn, Throwable throwable) {
        MyApp.logger.log(level, msn, throwable);
        fh.flush();
    }

    public static void log(final Level level, final String msn) {
        MyApp.logger.log(level, msn);
        fh.flush();
    }

    public static void log(final String msn) {
        MyApp.logger.log(Level.INFO, msn);
        fh.flush();
    }
}
