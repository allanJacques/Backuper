package com.backup.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Allan Jacques
 */
public class ScheduledBackupList implements Serializable{
    private List<ScheduledBackup> scheduledBackups;

    public ScheduledBackupList() {
        this.scheduledBackups = new ArrayList();
    }

    public List<ScheduledBackup> getScheduledBackups() {
        return scheduledBackups;
    }

    public void setScheduledBackups(List<ScheduledBackup> scheduledBackups) {
        this.scheduledBackups = scheduledBackups;
    }
    
    
}
