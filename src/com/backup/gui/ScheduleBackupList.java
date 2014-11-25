package com.backup.gui;

import com.backup.bean.ScheduledBackup;
import com.backup.app.MyApp;
import com.backup.utils.enums.PeriodPolitics;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 * @author Allan Jacques
 */
public class ScheduleBackupList extends JPanel implements EntityLister<ScheduledBackup>, ListSelectionListener {

    private EntityEditor entityEditor;
    private List<ScheduledBackup> scheduledBackups;
    private ScheduledBackupListModel model;

    public ScheduleBackupList() {
        initComponents();
        try {
            this.model = new ScheduledBackupListModel();
            this.tbScheduledBackups.setModel(this.model);
            this.tbScheduledBackups.setDefaultRenderer(Object.class, new ScheduledBackupListRenderer());
            this.tbScheduledBackups.getSelectionModel().addListSelectionListener(this);
            this.tbScheduledBackups.getSelectionModel().setSelectionInterval(0, 0);
        } catch (NullPointerException ex) {
            MyApp.log(Level.WARNING, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnScroll = new javax.swing.JScrollPane();
        tbScheduledBackups = new javax.swing.JTable();

        setOpaque(false);

        tbScheduledBackups.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbScheduledBackups.setGridColor(java.awt.Color.black);
        tbScheduledBackups.setRowHeight(25);
        pnScroll.setViewportView(tbScheduledBackups);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane pnScroll;
    private javax.swing.JTable tbScheduledBackups;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setUpdated(ScheduledBackup entity) {
        scheduledBackups.remove(this.tbScheduledBackups.getSelectedRow());
        scheduledBackups.add(this.tbScheduledBackups.getSelectedRow(), entity);

        tbScheduledBackups.setVisible(false);
        tbScheduledBackups.setVisible(true);
    }

    @Override
    public void setInserted(ScheduledBackup entity) {
        this.model.getScheduledBackups().add(entity);
        tbScheduledBackups.setVisible(false);
        tbScheduledBackups.setVisible(true);
    }

    @Override
    public void setEntityEditor(EntityEditor entityEditor) {
        this.entityEditor = entityEditor;
        if (!model.getScheduledBackups().isEmpty()) {
            this.tbScheduledBackups.getSelectionModel().setSelectionInterval(0, 0);
            this.entityEditor.load(model.getScheduledBackups().get(0));
        }
    }

    @Override
    public void refresh() {
        if (this.entityEditor != null && !this.scheduledBackups.isEmpty()) {
            this.tbScheduledBackups.getSelectionModel().setSelectionInterval(0, 0);
            this.entityEditor.load(this.scheduledBackups.get(0));
        } else {
            this.entityEditor.insert();
        }
        this.tbScheduledBackups.setVisible(false);
        this.tbScheduledBackups.setVisible(true);
    }

    @Override
    public List<ScheduledBackup> getEntityList() {
        return this.scheduledBackups;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (this.entityEditor != null) {
            this.entityEditor.load(this.scheduledBackups.get(this.tbScheduledBackups.getSelectedRow()));
        }
    }

    private class ScheduledBackupListModel implements TableModel {

        public ScheduledBackupListModel() {
            scheduledBackups = MyApp.getSystemFile().getScheduledBackupList().getScheduledBackups();
        }

        @Override
        public int getRowCount() {
            return scheduledBackups.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return MyApp.getAppText().getString("label.name");
                case 1:
                    return MyApp.getAppText().getString("label.directory");
                case 2:
                    return MyApp.getAppText().getString("label.period");
                case 3:
                    return MyApp.getAppText().getString("label.valueOrTimestamp");
                case 4:
                    return MyApp.getAppText().getString("label.session");
                default:
                    return "";
            }
        }

        @Override
        public Class<Object> getColumnClass(int columnIndex) {
            return Object.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ScheduledBackup scheduleBackupTemp = scheduledBackups.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return scheduleBackupTemp.getPrefixName();
                case 1:
                    return scheduleBackupTemp.getDirectory();
                case 2:
                    return scheduleBackupTemp.getPolitic();
                case 3:
                    return scheduleBackupTemp;
                case 4:
                    return scheduleBackupTemp.getSession();
                default:
                    return null;
            }

        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
        }

        private List<ScheduledBackup> getScheduledBackups() {
            return scheduledBackups;
        }

    }

    private class ScheduledBackupListRenderer extends JLabel implements TableCellRenderer {

        private final SimpleDateFormat diaryFormat = new SimpleDateFormat("HH:mm");
        private final SimpleDateFormat onceFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel returN = value != null ? new JLabel(value.toString()) : new JLabel();
            if (column == 3) {
                ScheduledBackup scheduledBackupTemp = (ScheduledBackup) value;
                if (scheduledBackupTemp.getPolitic().equals(PeriodPolitics.DIARY)) {
                    returN.setText(diaryFormat.format(new Date(scheduledBackupTemp.getPeriodValue())));
                } else if (scheduledBackupTemp.getPolitic().equals(PeriodPolitics.ONCE)) {
                    returN.setText(onceFormat.format(new Date(scheduledBackupTemp.getPeriodValue())));
                } else if (scheduledBackupTemp.getPolitic().equals(PeriodPolitics.PERIODICALLY)) {
                    returN.setText(MyApp.getAppText().getString("label.each") + " " + scheduledBackupTemp.getPeriodValue() + " " + scheduledBackupTemp.getPeriodType());
                }
            }
            if (row % 2 == 0) {
                returN.setBackground(Color.gray);
                returN.setOpaque(true);
            }
            if (isSelected) {
                returN.setBackground(new Color(184, 207, 229));
                returN.setOpaque(true);
            }
            return returN;
        }
    }

}
