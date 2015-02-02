package com.backup.utils.enums;

import com.backup.app.MyApp;

/**
 * @author AllanJacques
 */
public enum MeasureUnitTime {

    SECONDS(1000, MyApp.getAppText().getString("enum.second(s)")),
    MINUTES(1000 * 60, MyApp.getAppText().getString("enum.minute(s)"));

    private MeasureUnitTime(final int time, final String description) {
        this.time = time;
        this.description = description;
    }

    private final int time;
    private final String description;

    public int getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }

}
