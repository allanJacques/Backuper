package com.backup.gui;

import com.backup.bean.Session;
import com.backup.app.MyApp;
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
public class SessionList extends JPanel implements EntityLister<Session>, ListSelectionListener {

    private EntityEditor entityEditor;
    private List<Session> sessions;
    private SessionListModel model;

    public SessionList() {
        initComponents();
        try {
            this.model = new SessionListModel();
            this.tbSession.setModel(this.model);
            this.tbSession.setDefaultRenderer(Object.class, new SessionListRenderer());
            this.tbSession.setDefaultRenderer(Integer.class, new SessionListRenderer());
            this.tbSession.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            this.tbSession.getSelectionModel().addListSelectionListener(this);
            this.tbSession.getSelectionModel().setSelectionInterval(0, 0);
        } catch (NullPointerException ex) {
            MyApp.log(Level.WARNING, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnScroll = new javax.swing.JScrollPane();
        tbSession = new javax.swing.JTable();

        setOpaque(false);

        pnScroll.setOpaque(false);

        tbSession.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSession.setRowHeight(25);
        tbSession.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        pnScroll.setViewportView(tbSession);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane pnScroll;
    private javax.swing.JTable tbSession;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setUpdated(Session entity) {
        sessions.remove(this.tbSession.getSelectedRow());
        sessions.add(this.tbSession.getSelectedRow(), entity);

        tbSession.setVisible(false);
        tbSession.setVisible(true);
    }

    @Override
    public void setInserted(Session entity) {
        this.model.getSessions().add(entity);
        tbSession.setVisible(false);
        tbSession.setVisible(true);
    }

    @Override
    public void setEntityEditor(EntityEditor entityEditor) {
        this.entityEditor = entityEditor;
        if (!model.getSessions().isEmpty()) {
            this.tbSession.getSelectionModel().setSelectionInterval(0, 0);
            this.entityEditor.load(model.getSessions().get(0));
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (this.entityEditor != null) {
            this.entityEditor.load(this.sessions.get(this.tbSession.getSelectedRow()));
        }
    }

    @Override
    public void refresh() {
        if (this.entityEditor != null && !this.sessions.isEmpty()) {
            this.tbSession.getSelectionModel().setSelectionInterval(0, 0);
            this.entityEditor.load(this.sessions.get(0));
        } else {
            this.entityEditor.insert();
        }
        this.tbSession.setVisible(false);
        this.tbSession.setVisible(true);
    }

    @Override
    public List<Session> getEntityList() {
        return this.sessions;
    }

    private class SessionListModel implements TableModel {

        public SessionListModel() {
            sessions = MyApp.getSystemFile().getSessionList().getSessions();
        }

        public List<Session> getSessions() {
            return sessions;
        }

        @Override
        public int getRowCount() {
            return sessions.size();
        }

        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return MyApp.getAppText().getString("label.name");
                case 1:
                    return MyApp.getAppText().getString("label.host");
                case 2:
                    return MyApp.getAppText().getString("label.port");
                case 3:
                    return MyApp.getAppText().getString("label.user");
                case 4:
                    return MyApp.getAppText().getString("label.password");
                case 5:
                    return MyApp.getAppText().getString("label.database");
                case 6:
                    return MyApp.getAppText().getString("label.local");
                default:
                    return null;
            }

        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 2) {
                return Integer.class;
            } else {
                return String.class;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Session sessionTemp = sessions.get(rowIndex);
            if (sessionTemp == null || columnIndex < 0 || columnIndex > 7) {
                //System.out.println(sessionTemp);
                //System.out.println(columnIndex);
                //System.out.println(rowIndex);
                throw new InvalidParameterException("");
            }

            switch (columnIndex) {
                case 0:
                    return sessionTemp.getName();
                case 1:
                    return sessionTemp.getHost();
                case 2:
                    return sessionTemp.getPort();
                case 3:
                    return sessionTemp.getUser();
                case 4:
                    return sessionTemp.getPassword();
                case 5:
                    return sessionTemp.getDatabaseName();
                case 6:
                    return sessionTemp.getLocalFile();
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

    private class SessionListRenderer extends JLabel implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel returN;
            if (column == 4) {
                String pwd = "*";
                for (int i = 1; i < value.toString().length(); i++) {
                    pwd += "*";
                }
                returN = new JLabel(pwd);
            } else {
                returN = new JLabel(value.toString());
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
