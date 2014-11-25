package com.backup.io;

import com.backup.bean.Cleaner;
import com.backup.bean.ScheduledBackup;
import com.backup.bean.ScheduledBackupList;
import com.backup.bean.Session;
import com.backup.bean.SessionList;
import com.backup.bean.CleanerList;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Allan Jacques
 */
@XmlRootElement
public class SystemFile implements Serializable {

    private SessionList sessionList;
    private ScheduledBackupList scheduledBackupList;
    private CleanerList cleanerList;

    public SystemFile() {
        ScheduledBackupList scheduledBackupListTemp = new ScheduledBackupList();
        SessionList sessionListTem = new SessionList();
        CleanerList cleanerListTemp = new CleanerList();
        scheduledBackupListTemp.setScheduledBackups(new ArrayList<ScheduledBackup>());
        sessionListTem.setSessions(new ArrayList<Session>());
        cleanerListTemp.setCleaners                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 (new ArrayList<Cleaner>());
        this.setScheduledBackupList(scheduledBackupListTemp);
        this.setSessionList(sessionListTem);
        this.setCleanerList(cleanerListTemp);
    }

    public SessionList getSessionList() {
        return sessionList;
    }

    public final void setSessionList(SessionList sessions) {
        this.sessionList = sessions;
    }

    public ScheduledBackupList getScheduledBackupList() {
        return scheduledBackupList;
    }

    public final void setScheduledBackupList(ScheduledBackupList scheduledBackups) {
        this.scheduledBackupList = scheduledBackups;
    }

    public CleanerList getCleanerList() {
        return cleanerList;
    }

    public final void setCleanerList(CleanerList cleanerList) {
        this.cleanerList = cleanerList;
    }

}
