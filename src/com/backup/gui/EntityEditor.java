package com.backup.gui;

/**
 * @author Allan Jacques
 */
public interface EntityEditor<T> {

    public void insert();

    public void load(final T entity);

    public void setEntityLister(final EntityLister listSelection);

}
