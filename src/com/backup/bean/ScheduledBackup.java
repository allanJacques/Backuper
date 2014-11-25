package com.backup.bean;

import com.backup.utils.enums.Period;
import com.backup.utils.enums.PeriodPolitics;
import java.io.File;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Allan Jacques
 */
public class ScheduledBackup implements Serializable {

    private String prefixName;
    private File directory;
    private PeriodPolitics politic;
    private Period periodType;
    private long periodValue;
    private Session session;

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(final String prefixName) {
        this.prefixName = prefixName;
    }

    public File getDirectory() {
        return directory;
    }

    public void setDirectory(final File directory) {
        this.directory = directory;
    }

    public PeriodPolitics getPolitic() {
        return politic;
    }

    public void setPolitic(final PeriodPolitics politic) {
        this.politic = politic;
    }

    public Period getPeriodType() {
        return periodType;
    }

    public void setPeriodType(final Period periodType) {
        this.periodType = periodType;
    }

    public long getPeriodValue() {
        return periodValue;
    }

    public void setPeriodValue(final long periodValue) {
        this.periodValue = periodValue;
    }

    public Session getSession() {
        return this.session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.prefixName);
        hash = 79 * hash + Objects.hashCode(this.directory);
        hash = 79 * hash + Objects.hashCode(this.politic);
        hash = 79 * hash + Objects.hashCode(this.periodType);
        hash = 79 * hash + (int) (this.periodValue ^ (this.periodValue >>> 32));
        hash = 79 * hash + Objects.hashCode(this.session);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ScheduledBackup other = (ScheduledBackup) obj;
        if (!Objects.equals(this.prefixName, other.prefixName)) {
            return false;
        }
        if (!Objects.equals(this.directory, other.directory)) {
            return false;
        }
        if (this.politic != other.politic) {
            return false;
        }
        if (this.periodType != other.periodType) {
            return false;
        }
        if (this.periodValue != other.periodValue) {
            return false;
        }
        if (!Objects.equals(this.session, other.session)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.prefixName;
    }

}
