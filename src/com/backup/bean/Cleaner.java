package com.backup.bean;

import java.io.File;
import java.util.List;

/**
 * @author Allan Jacques
 */
public class Cleaner {

    private File targetDirectory;
    private boolean recursive;
    private List<String> patterns;
    private int capacityLimit;
    private int rate;

    public File getTargetDirectory() {
        return targetDirectory;
    }

    public void setTargetDirectory(File targetDirectory) {
        this.targetDirectory = targetDirectory;
    }

    public boolean isRecursive() {
        return recursive;
    }

    public void setRecursive(boolean recursive) {
        this.recursive = recursive;
    }

    public List<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }

    public int getCapacityLimit() {
        return capacityLimit;
    }

    public void setCapacityLimit(int capacityLimit) {
        this.capacityLimit = capacityLimit;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
