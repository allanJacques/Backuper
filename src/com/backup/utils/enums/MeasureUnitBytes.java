package com.backup.utils.enums;

/**
 * @author AllanJacques
 */
public enum MeasureUnitBytes {

    GIGA(((long)Math.pow(1024, 3)), "Gigabytes"),
    MEGA(((long)Math.pow(1024, 2)), "Megabytes"),
    KILO(((long)Math.pow(1024, 1)), "Kilobytes"),
    TERA(((long)Math.pow(1024, 4)), "Terabytes");

    private MeasureUnitBytes(final long bytes, final String description) {
        this.bytes = bytes;
        this.description = description;
    }
    private final long bytes;
    private final String description;

    public long getBytes() {
        return bytes;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }
}
