package com.backup.gui;

import com.backup.app.MyApp;
import com.backup.io.SystemFileHandler;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author Allan Jacques
 */
public class MyConfigBackup extends JFrame {

    public MyConfigBackup() {

        initComponents();
        this.sessionEditor.setEntityLister(this.sessionList);
        this.sessionList.setEntityEditor(this.sessionEditor);

        this.scheduledBackupEditor.setEntityLister(scheduleBackupEditorList);
        this.scheduleBackupEditorList.setEntityEditor(scheduledBackupEditor);

        this.addWindowListener(new OnExit());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnScroll = new javax.swing.JScrollPane();
        pnGeneral = new javax.swing.JPanel();
        sessionEditor = new com.backup.gui.SessionEditor();
        sessionList = new com.backup.gui.SessionList();
        scheduledBackupEditor = new com.backup.gui.ScheduledBackupEditor();
        scheduleBackupEditorList = new com.backup.gui.ScheduleBackupList();

        setTitle(MyApp.getAppText().getString("application.name") + " - " + MyApp.getAppText().getString("application.slogan"));
        setIconImage(new ImageIcon(this.getClass().getResource("images/backuper.png")).getImage());

        javax.swing.GroupLayout pnGeneralLayout = new javax.swing.GroupLayout(pnGeneral);
        pnGeneral.setLayout(pnGeneralLayout);
        pnGeneralLayout.setHorizontalGroup(
            pnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
            .addGroup(pnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnGeneralLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sessionEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sessionList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scheduledBackupEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scheduleBackupEditorList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        pnGeneralLayout.setVerticalGroup(
            pnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(pnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnGeneralLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(sessionEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(sessionList, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(scheduledBackupEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scheduleBackupEditorList, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pnScroll.setViewportView(pnGeneral);

        pnScroll.getVerticalScrollBar().setUnitIncrement(35);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnGeneral;
    private javax.swing.JScrollPane pnScroll;
    private com.backup.gui.ScheduleBackupList scheduleBackupEditorList;
    private com.backup.gui.ScheduledBackupEditor scheduledBackupEditor;
    private com.backup.gui.SessionEditor sessionEditor;
    private com.backup.gui.SessionList sessionList;
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
