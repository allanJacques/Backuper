package com.backup;

import com.backup.app.MyApp;
import com.backup.bean.Cleaner;
import com.backup.bean.ScheduledBackup;
import com.backup.bean.Session;
import com.backup.utils.DateUtils;
import com.backup.utils.enums.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.logging.Level;

/**
 * @author Allan Jacques
 */
public class BackupFactory {

    private static final ArrayList<BackupTask> backupTasks = new ArrayList<BackupTask>();
    private static final HashMap<ScheduledBackup, Timer> backupTimers = new HashMap<ScheduledBackup, Timer>();
    private static final ArrayList<CleanerTask> cleanerTasks = new ArrayList<CleanerTask>();
    private static final HashMap<Cleaner, Timer> cleanerTimers = new HashMap<Cleaner, Timer>();

    public static void programBackups() {
        for (ScheduledBackup scheduledBackup : MyApp.getSystemFile().getScheduledBackupList().getScheduledBackups()) {
            BackupFactory.addBackup(scheduledBackup);
        }
    }

    public static void programCleaners() {
        for (Cleaner cleanerTemp : MyApp.getSystemFile().getCleanerList().getCleaners()) {
            BackupFactory.addCleaner(cleanerTemp);
        }
    }

    private static void programPeriodicallyBackup(ScheduledBackup scheduledBackup) {
        MyApp.log(Level.INFO, "Scheduling \"{0}\"...", scheduledBackup.getPrefixName());
        Timer timer = new Timer(scheduledBackup.getPrefixName(), true);
        BackupTask task = new BackupTask(scheduledBackup);
        timer.schedule(task, 0, scheduledBackup.getPeriodValue() * (scheduledBackup.getPeriodType().equals(Period.DAY) ? DateUtils.DAY : (scheduledBackup.getPeriodType().equals(Period.HOURS) ? DateUtils.HOUR : DateUtils.MINUTE)));
        BackupFactory.backupTasks.add(task);
        BackupFactory.backupTimers.put(scheduledBackup, timer);
    }

    private static void programDiaryBackup(final ScheduledBackup scheduledBackup) {
        Timer timer = new Timer(scheduledBackup.getPrefixName(), true);
        BackupTask task = new BackupTask(scheduledBackup);
        if (DateUtils.hourInToday(scheduledBackup.getPeriodValue()).after(Calendar.getInstance())) {
            MyApp.log(Level.INFO, "Scheduling \"{0}\" for today at {1}", new Object[]{scheduledBackup.getPrefixName(), DateUtils.sdfHour.format(new Date(scheduledBackup.getPeriodValue()))});
            timer.schedule(task, (DateUtils.hourInToday(scheduledBackup.getPeriodValue()).getTimeInMillis() - System.currentTimeMillis()), DateUtils.DAY);
        } else {
            MyApp.log(Level.INFO, "Scheduling \"{0}\" for tomorrow at {1}", new Object[]{scheduledBackup.getPrefixName(), DateUtils.sdfHour.format(new Date(scheduledBackup.getPeriodValue()))});
            long timeBackup = DateUtils.hourInTomorrow(scheduledBackup.getPeriodValue()).getTimeInMillis();
            long timeCurrent = System.currentTimeMillis();
            timer.schedule(task, (timeBackup - timeCurrent), DateUtils.DAY);
        }
        BackupFactory.backupTasks.add(task);
        BackupFactory.backupTimers.put(scheduledBackup, timer);
    }

    private static void programOnceBackup(ScheduledBackup scheduledBackup) {
        if (scheduledBackup.getPeriodValue() > System.currentTimeMillis()) {
            MyApp.log(Level.INFO, "Scheduling \"{0}\"...", scheduledBackup.getPrefixName());
            Timer timer = new Timer(scheduledBackup.getPrefixName(), true);
            BackupTask task = new BackupTask(scheduledBackup);
            timer.schedule(task, new Date(scheduledBackup.getPeriodValue()));
            BackupFactory.backupTasks.add(task);
            BackupFactory.backupTimers.put(scheduledBackup, timer);
        } else {
            MyApp.log(Level.INFO, "\"{0}\" will not be scheduled because his time has been exceeded", scheduledBackup.getPrefixName());
        }
    }

    public static void alterBackup(final ScheduledBackup old, final ScheduledBackup neW) {
        BackupFactory.removeBackup(old);
        BackupFactory.addBackup(neW);
    }

    public static void removeBackup(ScheduledBackup scheduledBackup) {
        BackupFactory.backupTimers.get(scheduledBackup).cancel();
        BackupFactory.backupTimers.remove(scheduledBackup);
        for (int i = 0; i < BackupFactory.backupTasks.size(); i++) {
            if (BackupFactory.backupTasks.get(i).getScheduledBackup().equals(scheduledBackup)) {
                BackupFactory.backupTasks.remove(BackupFactory.backupTasks.get(i));
                break;
            }
        }
        MyApp.log(Level.INFO, "The scheduled backup \"{0}\" was removed...", scheduledBackup.getPrefixName());
    }

    public static void addBackup(ScheduledBackup scheduledBackup) {
        switch (scheduledBackup.getPolitic()) {
            case PERIODICALLY:
                programPeriodicallyBackup(scheduledBackup);
                break;
            case DIARY:
                programDiaryBackup(scheduledBackup);
                break;
            case ONCE:
                programOnceBackup(scheduledBackup);
                break;
        }
        MyApp.log(Level.INFO, "The scheduled backup \"{0}\" was added...", scheduledBackup.getPrefixName());
    }

    public static void alterSession(final Session oldSession, final Session newSession) {
        for (BackupTask btTemp : BackupFactory.backupTasks) {
            if (btTemp.getScheduledBackup().getSession().equals(oldSession)) {
                btTemp.getScheduledBackup().setSession(newSession);
            }
        }

    }

    public static void addCleaner(final Cleaner cleaner) {
        MyApp.log(Level.INFO, "Scheduling cleaner for \"{0}\"...", cleaner.getTargetDirectory().toString());
        Timer timer = new Timer(cleaner.getTargetDirectory().toString(), true);
        CleanerTask task = new CleanerTask(cleaner);
        timer.schedule(task, 0, cleaner.getRate() * 1000);
        BackupFactory.cleanerTasks.add(task);
        BackupFactory.cleanerTimers.put(cleaner, timer);
    }

    public static void removeCleaner(final Cleaner cleaner) {
        BackupFactory.cleanerTimers.get(cleaner).cancel();
        BackupFactory.cleanerTimers.remove(cleaner);
        for (int i = 0; i < BackupFactory.cleanerTasks.size(); i++) {
            if (BackupFactory.cleanerTasks.get(i).getCleaner().equals(cleaner)) {
                BackupFactory.cleanerTasks.remove(BackupFactory.cleanerTasks.get(i));
                break;
            }
        }
        MyApp.log(Level.INFO, "The cleaner for \"{0}\" was removed...", cleaner.getTargetDirectory());
    }

    public static void alterCleaner(final Cleaner old, final Cleaner neW) {
        BackupFactory.removeCleaner(old);
        BackupFactory.addCleaner(neW);
    }
}
