package com.backup.gui;

import java.util.List;

/**
 * @author Allan Jacques
 * @param <T> All EntityLister is a generics then need for a class
 */
public interface EntityLister<T> {

    public void setUpdated(final T entity);

    public void setInserted(final T entity);

    public void setEntityEditor(final EntityEditor entityEditor);

    public void refresh();

    public List<T> getEntityList();
}
