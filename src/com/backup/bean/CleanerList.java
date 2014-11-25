package com.backup.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allan Jacques
 */
public class CleanerList {

    private List<Cleaner> cleaners;

    public CleanerList() {
        this.cleaners = new ArrayList<Cleaner>();
    }

    public List<Cleaner> getCleaners() {
        return cleaners;
    }

    public void setCleaners(List<Cleaner> cleanerList) {
        this.cleaners = cleanerList;
    }
}
