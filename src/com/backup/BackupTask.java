package com.backup;

import com.backup.app.MyApp;
import com.backup.backuper.MySQLBackuper;
import com.backup.bean.ScheduledBackup;
import java.util.Date;
import java.util.TimerTask;

/**
 * @author Allan Jacques
 */
class BackupTask extends TimerTask {

    private ScheduledBackup scheduledBackup;

    public BackupTask(ScheduledBackup scheduledBackup) {
        this.scheduledBackup = scheduledBackup;
    }

    @Override
    public void run() {
        MyApp.log("Executing \"" + this.scheduledBackup.getPrefixName() + "\" at " + new Date().toString());
        MySQLBackuper mySQLBackuper = new MySQLBackuper(scheduledBackup);
        mySQLBackuper.execute();
    }

    public ScheduledBackup getScheduledBackup() {
        return scheduledBackup;
    }

    public void setScheduledBackup(ScheduledBackup scheduledBackup) {
        this.scheduledBackup = scheduledBackup;
    }

}
