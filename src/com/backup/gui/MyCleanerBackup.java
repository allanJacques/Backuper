package com.backup.gui;

import com.backup.app.MyApp;
import com.backup.io.SystemFileHandler;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import javax.swing.ImageIcon;

/**
 * @author Allan Jacques
 */
public class MyCleanerBackup extends javax.swing.JFrame {

    
    public MyCleanerBackup() {
        initComponents();
        this.cleanerEditor.setEntityLister(this.cleanerList);
        this.cleanerList.setEntityEditor(this.cleanerEditor);
        this.addWindowListener(new OnExit());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cleanerEditor = new com.backup.gui.CleanerEditor();
        cleanerList = new com.backup.gui.CleanerList();

        setTitle(MyApp.getAppText().getString("application.name") + " - " + MyApp.getAppText().getString("application.slogan"));
        setIconImage(new ImageIcon(this.getClass().getResource("images/backuper.png")).getImage());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cleanerEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                    .addComponent(cleanerList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cleanerEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cleanerList, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.backup.gui.CleanerEditor cleanerEditor;
    private com.backup.gui.CleanerList cleanerList;
    // End of variables declaration//GEN-END:variables

    private class OnExit extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            try {
                SystemFileHandler systemFileHandler = SystemFileHandler.getInstance();
                systemFileHandler.save();
            } catch (RuntimeException ex) {
                MyApp.log(Level.SEVERE, null, ex);
            }

        }
    }

}
