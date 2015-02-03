package com.backup.utils;

import com.backup.app.MyApp;
import com.backup.bean.ScheduledBackup;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.text.JTextComponent;

/**
 * @author Allan Jacques
 */
public class FileUtils {

    public static File selectLocalFile(final JTextComponent component) {
        JFileChooser fchooser = new JFileChooser();
        fchooser.showDialog(MyApp.getPrincipalFrame(), null);
        File returN = fchooser.getSelectedFile();
        if (returN != null) {
            component.setText(returN.toString());
        }
        return returN;
    }

    public static File selectLocalDirectory(final JTextComponent component) {
        JFileChooser fchooser = new JFileChooser();
        fchooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fchooser.showDialog(MyApp.getPrincipalFrame(), null);
        File returN = fchooser.getSelectedFile();
        if (returN != null) {
            component.setText(returN.toString());
        }
        return returN;
    }

    public static File getBaseDirectory() {
        return new File(System.getProperties().getProperty("user.home") + System.getProperties().getProperty("file.separator") + "Backuper");
    }

    public static File getLogFile() {
        return getLogFile("Backuper.log");
    }

    public static File getLogFile(final String fileName) {
        File logFile = new File(new File(getBaseDirectory(), "LOG"), fileName);
        if (!logFile.getParentFile().exists()) {
            if (!logFile.getParentFile().mkdirs()) {
                MyApp.log(Level.WARNING, "Was not possible to create log file");
            }
        }
        return logFile;
    }

    public static String getFileSeparator() {
        return System.getProperties().getProperty("file.separator");
    }

    public static File getBackupFile(final ScheduledBackup scheduledBackup) {
        if (!scheduledBackup.getDirectory().exists()) {
            scheduledBackup.getDirectory().mkdirs();
        }
        return new File(scheduledBackup.getDirectory(), scheduledBackup.getPrefixName() + "_" + DateUtils.sdfDefaultBackupDateName.format(new Date()) + ".sql");
    }

    public static File getErrorFile(final ScheduledBackup scheduledBackup) {
        return new File(scheduledBackup.getDirectory(), scheduledBackup.getPrefixName() + "_" + DateUtils.sdfDefaultBackupDateName.format(new Date()) + ".err");
    }

    public static File getSystemFile() {
        File returN = new File(System.getProperties().getProperty("user.home") + getFileSeparator() + "Backuper" + getFileSeparator() + "backuper.xml");
        if (!returN.getParentFile().exists()) {
            returN.getParentFile().mkdir();
        }
        return returN;
    }

    public static boolean isValidDirectoryName(final String name) {
        File file = new File(name);
        return (file.mkdirs() || (file.isDirectory() && file.exists()));
    }

    public static File findMysqldump() {
        if (System.getProperty("os.name").contains("Linux")) {
            File tryFile = new File("/usr/bin/mysqldump");
            if (tryFile.exists()) {
                return tryFile;
            }
        } else if (System.getProperty("os.name").contains("Windows")) {
            ArrayList<File> files = new ArrayList<File>();
            find(new File("C:\\Program Files\\MySQL"), ".*mysqldump.exe", files);
            if (!files.isEmpty()) {
                return files.get(0);
            }
        }
        return null;
    }

    private static void find(final File path, final String regex, final ArrayList<File> files) {
        if (!path.exists() || path.listFiles() == null) {
            return;
        }
        for (File fileTemp : path.listFiles()) {
            if (fileTemp.isDirectory()) {
                find(fileTemp, regex, files);
            } else {
                if (!fileTemp.isDirectory() && fileTemp.toString().matches(regex)) {
                    files.add(fileTemp);
                    break;
                }
            }
        }
    }
}
