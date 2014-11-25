package com.backup.backuper;

import com.backup.app.MyApp;
import com.backup.bean.ScheduledBackup;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * @author Allan Jacques
 */
public class MySQLBackuper extends DefaultBackuper {

    public MySQLBackuper(ScheduledBackup scheduledBackup) {
        super(scheduledBackup);
    }

    @Override
    public Process doBackup() throws IOException {
        try {
            StringBuilder exec = new StringBuilder(this.scheduledBackup.getSession().getLocalFile().getPath().isEmpty() ? "mysqldump" : this.scheduledBackup.getSession().getLocalFile().toString());
            exec.append(" -u");
            exec.append(scheduledBackup.getSession().getUser());
            exec.append(" -p");
            exec.append(scheduledBackup.getSession().getPassword());
            exec.append(" --host=");
            exec.append(scheduledBackup.getSession().getHost());
            exec.append(" --port=");
            exec.append(scheduledBackup.getSession().getPort());
            exec.append(" --events");
            exec.append(" --triggers");
            exec.append(" --routines");
            exec.append(" --databases ");
            exec.append(scheduledBackup.getSession().getDatabaseName());
            return Runtime.getRuntime().exec(exec.toString());
        } catch (IOException ex) {
            MyApp.log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public boolean isSuccessfullyBackup() {
        return !this.errorFile.exists();
    }

    @Override
    protected void posExecute() {
        if (this.errorFile.exists()) {
            boolean isPasswordInCommandLineWarning = false;
            Scanner s = null;
            try {
                s = new Scanner(this.errorFile);
                while (s.hasNextLine()) {
                    String line = s.nextLine();
                    if (line.contains("Warning: Using a password on the command line interface can be insecure.") && !s.hasNextLine()) {
                        isPasswordInCommandLineWarning = true;
                    }
                }
            } catch (FileNotFoundException ex) {
                MyApp.log(Level.SEVERE, null, ex);
            } finally {
                if (s != null) {
                    s.close();
                }
            }
            if (isPasswordInCommandLineWarning) {
                this.errorFile.delete();
            }
        }
    }
}
