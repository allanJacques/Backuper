package com.backup.gui;

import javax.swing.JPanel;

/**
 * @author Allan Jacques
 */
public abstract class AbstractEntityEditor extends JPanel {

    protected static final short INSERT = 0;
    protected static final short EDIT = 1;
    protected static final short DELETE = 2;
    protected short mode = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    protected boolean isInserting() {
        return this.mode == AbstractEntityEditor.INSERT;
    }

    protected boolean isEditing() {
        return this.mode == AbstractEntityEditor.EDIT;
    }

    protected boolean isDeleting() {
        return this.mode == AbstractEntityEditor.DELETE;
    }

    protected void setInserting() {
        this.mode = AbstractEntityEditor.INSERT;
    }

    protected void setEditing() {
        this.mode = AbstractEntityEditor.EDIT;
    }

    protected void setDeleting() {
        this.mode = AbstractEntityEditor.DELETE;
    }
}
