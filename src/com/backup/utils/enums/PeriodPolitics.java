package com.backup.utils.enums;

import com.backup.app.MyApp;

/**
 * @author Allan Jacques
 */
public enum PeriodPolitics {

    DIARY(MyApp.getAppText().getString("enum.daily")),
    ONCE(MyApp.getAppText().getString("enum.once")),
    PERIODICALLY(MyApp.getAppText().getString("enum.periodically"));

    public String description;

    PeriodPolitics(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

}
