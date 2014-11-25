package com.backup.gui;

import com.backup.app.MyApp;
import com.backup.bean.Cleaner;
import java.awt.Color;
import java.awt.Component;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 * @author Allan Jacques
 */
public class CleanerList extends JPanel implements EntityLister<Cleaner>, ListSelectionListener {

    private EntityEditor entityEditor;
    private CleanerListModel model;
    private List<Cleaner> cleaners;

    public CleanerList() {
        initComponents();
        try {
            this.model = new CleanerListModel();
            this.tbCleaner.setModel(this.model);
            this.tbCleaner.setDefaultRenderer(Object.class, new CleanerListRenderer());
            this.tbCleaner.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            this.tbCleaner.getSelectionModel().addListSelectionListener(this);
            this.tbCleaner.getSelectionModel().setSelectionInterval(0, 0);
        } catch (NullPointerException ex) {
            MyApp.log(Level.WARNING, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbCleaner = new javax.swing.JTable();

        tbCleaner.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbCleaner);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setUpdated(Cleaner entity) {
        cleaners.remove(this.tbCleaner.getSelectedRow());
        cleaners.add(this.tbCleaner.getSelectedRow(), entity);

        tbCleaner.setVisible(false);
        tbCleaner.setVisible(true);
    }

    @Override
    public void setInserted(Cleaner entity) {
        this.model.getCleaners().add(entity);
        tbCleaner.setVisible(false);
        tbCleaner.setVisible(true);
    }

    @Override
    public void setEntityEditor(EntityEditor entityEditor) {
        this.entityEditor = entityEditor;
        if (!model.getCleaners().isEmpty()) {
            this.tbCleaner.getSelectionModel().setSelectionInterval(0, 0);
            this.entityEditor.load(model.getCleaners().get(0));
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (this.entityEditor != null) {
            this.entityEditor.load(this.cleaners.get(this.tbCleaner.getSelectedRow()));
        }
    }

    @Override
    public void refresh() {
        if (this.entityEditor != null && !this.cleaners.isEmpty()) {
            this.tbCleaner.getSelectionModel().setSelectionInterval(0, 0);
            this.entityEditor.load(this.cleaners.get(0));
        } else {
            this.entityEditor.insert();
        }
        this.tbCleaner.setVisible(false);
        this.tbCleaner.setVisible(true);
    }

    @Override
    public List<Cleaner> getEntityList() {
        return this.cleaners;
    }

    private class CleanerListModel implements TableModel {

        public CleanerListModel() {
            cleaners = MyApp.getSystemFile().getCleanerList().getCleaners();
        }

        public List<Cleaner> getCleaners() {
            return cleaners;
        }

        @Override
        public int getRowCount() {
            return cleaners.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {

                case 0:
                    return MyApp.getAppText().getString("label.directory");
                case 1:
                    return MyApp.getAppText().getString("label.limit");
                case 2:
                    return MyApp.getAppText().getString("label.rate");
                case 3:
                    return MyApp.getAppText().getString("label.regex");
                case 4:
                    return MyApp.getAppText().getString("label.recursive");
                default:
                    return null;
            }

        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Cleaner cleanerTemp = cleaners.get(rowIndex);
            if (cleanerTemp == null || columnIndex < 0 || columnIndex > 4) {
                //System.out.println(sessionTemp);
                //System.out.println(columnIndex);
                //System.out.println(rowIndex);
                throw new InvalidParameterException("");
            }

            switch (columnIndex) {
                case 0:
                    return cleanerTemp.getTargetDirectory();
                case 1:
                    return cleanerTemp.getCapacityLimit();
                case 2:
                    return cleanerTemp.getRate();
                case 3:
                    return cleanerTemp.getPatterns();
                case 4:
                    return cleanerTemp.isRecursive();

                default:
                    throw new InvalidParameterException("Invalid column Index");
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

    }

    private class CleanerListRenderer extends JLabel implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel returN;
            returN = new JLabel(value != null ? value.toString() : "");
            returN.setToolTipText(value != null ? value.toString() : "");

            if (row % 2 == 0) {
                returN.setBackground(Color.gray);
                returN.setOpaque(true);
            }

            if (isSelected) {
                returN.setBackground(new Color(184, 207, 229));
                returN.setOpaque(true);
            }
            if (column == 3) {
                returN.setText(getFormatedPatterns((List<String>) value));
                returN.setToolTipText(getFormatedPatterns((List<String>) value));
            }

            if (column == 4) {
                if (value.equals(true)) {
                    returN.setText(MyApp.getAppText().getString("label.yes"));
                    returN.setToolTipText(MyApp.getAppText().getString("label.yes"));
                } else {
                    returN.setText(MyApp.getAppText().getString("label.no"));
                    returN.setToolTipText(MyApp.getAppText().getString("label.no"));
                }
            }

            if (column != 0) {
                returN.setHorizontalAlignment(JLabel.CENTER);
            }
            returN.setVerticalAlignment(JLabel.TOP);
            return returN;
        }

        private String getFormatedPatterns(final List<String> patterns) {
            if (patterns != null && !patterns.isEmpty()) {
                StringBuilder returN = new StringBuilder();

                returN.append("<html>");
                returN.append(patterns.get(0));

                for (int i = 1; i < patterns.size(); i++) {
                    returN.append("<font color=\"red\" face=\"Arial Black\">  ,  </font>");
                    returN.append(patterns.get(i));
                }
                returN.append("</html>");

                return returN.toString();

            } else {
                return null;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCleaner;
    // End of variables declaration//GEN-END:variables
}
