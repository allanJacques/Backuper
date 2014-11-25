package com.backup.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Allan Jacques
 */
public class DateUtils {

    public static final SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat sdfTimestamp = new SimpleDateFormat("HH:mm dd/MM/yy");
    public static final SimpleDateFormat sdfDefaultBackupDateName = new SimpleDateFormat("dd.MM.yyyy-HH.mm.ss");

    public static final long MINUTE = 1000 * 60;
    public static final long HOUR = MINUTE * 60;
    public static final long DAY = HOUR * 24;

    static {
        DateUtils.sdfHour.setLenient(false);
        DateUtils.sdfTimestamp.setLenient(false);
    }

    public static Calendar hourInToday(final long date) {
        return hourInToday(new Date(date));
    }

    public static Calendar hourInToday(final Date date) {
        Calendar hourInToday = Calendar.getInstance();
        Calendar scheduledDate = Calendar.getInstance();
        scheduledDate.setTime(date);
        hourInToday.set(Calendar.HOUR_OF_DAY, scheduledDate.get(Calendar.HOUR_OF_DAY));
        hourInToday.set(Calendar.MINUTE, scheduledDate.get(Calendar.MINUTE));
        hourInToday.set(Calendar.SECOND, 0);
        return hourInToday;
    }

    public static Calendar hourInTomorrow(final long date) {
        return hourInTomorrow(new Date(date));
    }

    public static Calendar hourInTomorrow(final Date date) {
        long today = DateUtils.hourInToday(date).getTimeInMillis();
        today += DAY;
        Calendar returN = Calendar.getInstance();
        returN.setTimeInMillis(today);
        return returN;
    }
}
