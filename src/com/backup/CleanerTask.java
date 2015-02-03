package com.backup;

import com.backup.app.MyApp;
import com.backup.bean.Cleaner;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimerTask;
import java.util.logging.Level;

/*
 * @author Allan Jacques
 */
public class CleanerTask extends TimerTask {

    private final Cleaner cleaner;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");

    public CleanerTask(Cleaner cleaner) {
        this.cleaner = cleaner;
    }

    @Override
    public void run() {
        deleteFiles();
    }

    public void deleteFiles() {
        long countBites = 0;
        ArrayList<File> files = new ArrayList<File>();
        ArrayList<File> deleteFiles = new ArrayList<File>();
        files.addAll(this.getFileList());
        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {

                if (isPattern(o1) && !isPattern(o2)) {
                    return -1;
                } else if (!isPattern(o1) && isPattern(o2)) {
                    return 1;
                }

                if (o1.length() < o2.length()) {
                    return 1;
                }

                if (o1.length() > o2.length()) {
                    return -1;
                }

                if (o1.length() == o2.length()) {
                    if (o1.lastModified() < o2.lastModified()) {
                        return 1;
                    }

                    if (o1.lastModified() > o2.lastModified()) {
                        return -1;
                    }

                }
                return 0;
            }
        });
        for (File fTemp : files) {
            countBites += fTemp.length();
            if (countBites > (cleaner.getCapacityLimit() * cleaner.getMeasureUnitBytes().getBytes())) {
                deleteFiles.add(fTemp);
            }
        }
        deleteFiles(deleteFiles);
    }

    private void deleteFiles(ArrayList< File> deleteFiles) {
        for (File fileTemp : deleteFiles) {
            if (!isPattern(fileTemp)) {
                if (fileTemp.delete()) {
                    MyApp.log(Level.INFO, this.sdf.format(new Date()) + "\t" + fileTemp + "   has deleted.");
                } else {
                    MyApp.log(Level.INFO, this.sdf.format(new Date()) + "\t" + fileTemp + "   not has deleted.");
                }
            }
        }
    }

    private Set<File> getFileList() {
        HashSet<File> files = new HashSet<File>();
        getFileList(files, this.cleaner.getTargetDirectory());
        return files;
    }

    private void getFileList(HashSet<File> files, File targetDirectory) {
        System.out.println(targetDirectory);
        if (targetDirectory.canRead() && targetDirectory.listFiles() == null) {
            return;
        }
        for (File fileTemp : targetDirectory.listFiles()) {
            if (fileTemp.isDirectory() && this.cleaner.isRecursive()) {
                getFileList(files, fileTemp);
            } else {
                if (!fileTemp.isDirectory()) {
                    files.add(fileTemp);
                }
            }
        }

    }

    private boolean isPattern(File fileTemp) {
        if (this.cleaner.getPatterns() != null && !this.cleaner.getPatterns().isEmpty()) {
            for (String pattern : this.cleaner.getPatterns()) {
                if (fileTemp.toString().matches(pattern)) {
                    return true;
                }
            }
        }
        return false;
    }

    Object getCleaner() {
        return this.cleaner;
    }
}
