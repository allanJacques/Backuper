package com.backup.utils.enums;

import com.backup.app.MyApp;

/**
 * @author Allan Jacques
 */
public enum Period {

    MINUTES(MyApp.getAppText().getString("enum.minute(s)")),
    HOURS(MyApp.getAppText().getString("enum.hour(s)")),
    DAY(MyApp.getAppText().getString("enum.day(s)"));

    private String description;

    private Period(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
