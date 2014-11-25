package com.backup.backuper;

import com.backup.app.MyApp;
import com.backup.bean.ScheduledBackup;
import com.backup.gui.MyGUITool;
import com.backup.utils.FileUtils;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;

/**
 * @author Allan Jacques
 */
public abstract class DefaultBackuper {

    protected final ScheduledBackup scheduledBackup;
    protected Process process;
    protected FileOutputStream fosBackupFile;
    protected File backupFile;
    protected FileOutputStream fosErrorFile;
    protected File errorFile;
    protected boolean hasError = false;

    protected DefaultBackuper(final ScheduledBackup scheduledBackup) {
        this.scheduledBackup = scheduledBackup;
    }

    public void execute() {
        boolean backFileOpened = false;
        boolean backErrorOpened = false;

        try {
            this.backupFile = FileUtils.getBackupFile(scheduledBackup);
            this.errorFile = FileUtils.getErrorFile(scheduledBackup);
            this.process = this.doBackup();
            int x;
            while ((x = this.process.getInputStream().read()) != -1) {
                if (!backFileOpened) {
                    this.fosBackupFile = new FileOutputStream(this.backupFile);
                    backFileOpened = true;
                }
                this.fosBackupFile.write(x);
            }
            while ((x = this.process.getErrorStream().read()) != -1) {
                if (!backErrorOpened) {
                    this.fosErrorFile = new FileOutputStream(this.errorFile);
                    backErrorOpened = true;
                }
                this.fosErrorFile.write(x);
                if (!hasError) {
                    hasError = true;
                }
            }
            if (this.fosBackupFile != null) {
                this.fosBackupFile.close();
            }
            if (this.fosErrorFile != null) {
                this.fosErrorFile.close();
            }
            this.process.getInputStream().close();
            this.process.getErrorStream().close();
            this.posExecute();
            MyApp.log(Level.INFO, "Analyzing backup\"{0}\"", this.scheduledBackup);
            if (this.isSuccessfullyBackup()) {
                MyApp.log(Level.INFO, "Backup \"{0}\" successfully performed", this.scheduledBackup);
                MyGUITool.showTrayMessage(this.scheduledBackup);
            } else {
                MyApp.log(Level.WARNING, "Backup \"{0}\" not performed", this);
                MyGUITool.showErrorTrayMessage(this.scheduledBackup);
                Desktop.getDesktop().open(this.errorFile);
            }
        } catch (IOException ex) {
            MyApp.log(Level.OFF, null, ex);
            try {
                PrintStream printStream = new PrintStream(this.errorFile);
                ex.printStackTrace(printStream);
            } catch (FileNotFoundException ex1) {
                MyApp.log(Level.SEVERE, null, ex1);
            }

        }
    }

    protected abstract Process doBackup() throws IOException;

    protected abstract boolean isSuccessfullyBackup();

    protected abstract void posExecute();

}
