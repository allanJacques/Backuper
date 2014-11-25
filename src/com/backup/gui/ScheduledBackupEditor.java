package com.backup.gui;

import com.backup.BackupFactory;
import com.backup.app.MyApp;
import com.backup.bean.ScheduledBackup;
import com.backup.bean.Session;
import com.backup.io.SystemFileHandler;
import com.backup.utils.DateUtils;
import com.backup.utils.FileUtils;
import com.backup.utils.GUIUtils;
import com.backup.utils.enums.Period;
import com.backup.utils.enums.PeriodPolitics;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

/**
 * @author AllanJacques
 */
public class ScheduledBackupEditor extends AbstractEntityEditor implements EntityEditor<ScheduledBackup> {

    private EntityLister entityLister;
    private ScheduledBackup currentScheduledBackup;

    public ScheduledBackupEditor() {
        initComponents();
        this.spnValue.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbName = new javax.swing.JLabel();
        tfPrefixName = new javax.swing.JTextField();
        lbMessage = new javax.swing.JLabel();
        lbOut = new javax.swing.JLabel();
        tfOut = new javax.swing.JTextField();
        btSelect = new javax.swing.JButton();
        lbPeriod = new javax.swing.JLabel();
        cbPeriodPolitics = new javax.swing.JComboBox<PeriodPolitics>();
        pnDinamic = new javax.swing.JPanel();
        pnHour = new javax.swing.JPanel();
        lbHour = new javax.swing.JLabel();
        ftfHour = new javax.swing.JFormattedTextField();
        pnTimestamp = new javax.swing.JPanel();
        lbTimestamp = new javax.swing.JLabel();
        ftfTimestamp = new javax.swing.JFormattedTextField();
        pnUnit = new javax.swing.JPanel();
        lbValue = new javax.swing.JLabel();
        spnValue = new javax.swing.JSpinner();
        cbUnit = new javax.swing.JComboBox<Period>();
        lbSession = new javax.swing.JLabel();
        cbSession = new javax.swing.JComboBox();
        pnButtons = new javax.swing.JPanel();
        btNew = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btnCanceEdition = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(MyApp.getAppText().getString("label.scheduleBackup"))); // NOI18N
        setOpaque(false);

        lbName.setDisplayedMnemonic('n');
        lbName.setLabelFor(tfPrefixName);
        lbName.setText(MyApp.getAppText().getString("label.name")); // NOI18N

        lbMessage.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(255, 0, 0));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbOut.setDisplayedMnemonic('i');
        lbOut.setLabelFor(tfOut);
        lbOut.setText(MyApp.getAppText().getString("label.out")); // NOI18N

        btSelect.setFont(new java.awt.Font("Tahoma", 0, 7)); // NOI18N
        btSelect.setText(MyApp.getAppText().getString("label.select")); // NOI18N
        btSelect.setMaximumSize(new java.awt.Dimension(3000, 3000));
        btSelect.setMinimumSize(new java.awt.Dimension(59, 21));
        btSelect.setPreferredSize(new java.awt.Dimension(59, 21));
        btSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectActionPerformed(evt);
            }
        });

        lbPeriod.setDisplayedMnemonic('d');
        lbPeriod.setLabelFor(cbPeriodPolitics);
        lbPeriod.setText(MyApp.getAppText().getString("label.period")); // NOI18N

        cbPeriodPolitics.setModel(new DefaultComboBoxModel(PeriodPolitics.values()));
        cbPeriodPolitics.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPeriodPoliticsItemStateChanged(evt);
            }
        });

        pnDinamic.setOpaque(false);
        pnDinamic.setPreferredSize(new java.awt.Dimension(549, 26));
        pnDinamic.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        pnHour.setOpaque(false);
        pnHour.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lbHour.setText(MyApp.getAppText().getString("label.timestamp")); // NOI18N
        lbHour.setPreferredSize(new java.awt.Dimension(60, 14));
        pnHour.add(lbHour);

        ftfHour.setPreferredSize(new java.awt.Dimension(120, 26));
        ftfHour.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ftfHourFocusGained(evt);
            }
        });
        pnHour.add(ftfHour);
        try{
            pnHour.remove(ftfHour);
            ftfHour = new JFormattedTextField(new MaskFormatter("##:##"));
            ftfHour.setPreferredSize(new java.awt.Dimension(120, 26));
            pnHour.add(ftfHour);
            ftfHour.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    ftfHourFocusGained(evt);
                }
            });
        }catch(ParseException e ){
            MyApp.log(Level.SEVERE, null, e);
        }

        pnDinamic.add(pnHour);
        pnHour.setVisible(true);

        pnTimestamp.setOpaque(false);
        pnTimestamp.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lbTimestamp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTimestamp.setText(MyApp.getAppText().getString("label.timestamp")); // NOI18N
        lbTimestamp.setPreferredSize(new java.awt.Dimension(60, 14));
        pnTimestamp.add(lbTimestamp);

        ftfTimestamp.setPreferredSize(new java.awt.Dimension(120, 26));
        ftfTimestamp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ftfTimestampFocusGained(evt);
            }
        });
        pnTimestamp.add(ftfTimestamp);
        try{
            pnTimestamp.remove(this.ftfTimestamp);
            this.ftfTimestamp  = new JFormattedTextField(new MaskFormatter("##:## ##/##/##"));
            this.ftfTimestamp.setPreferredSize(new java.awt.Dimension(120, 26));
            this.pnTimestamp.add(this.ftfTimestamp);
            ftfTimestamp.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    ftfTimestampFocusGained(evt);
                }
            });
        }catch(ParseException e){
            MyApp.log(Level.SEVERE, null, e);
        }

        pnDinamic.add(pnTimestamp);
        pnTimestamp.setVisible(false);

        pnUnit.setOpaque(false);
        pnUnit.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lbValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbValue.setText(MyApp.getAppText().getString("label.value")); // NOI18N
        lbValue.setPreferredSize(new java.awt.Dimension(60, 14));
        pnUnit.add(lbValue);

        spnValue.setPreferredSize(new java.awt.Dimension(100, 26));
        spnValue.setValue(1);
        pnUnit.add(spnValue);

        cbUnit.setPreferredSize(new java.awt.Dimension(100, 26));
        pnUnit.add(cbUnit);
        cbUnit.setModel(new DefaultComboBoxModel(Period.values()));

        pnDinamic.add(pnUnit);
        pnUnit.setVisible(false);

        lbSession.setDisplayedMnemonic('o');
        lbSession.setLabelFor(cbSession);
        lbSession.setText(MyApp.getAppText().getString("label.session")); // NOI18N

        cbSession.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbSessionFocusGained(evt);
            }
        });

        pnButtons.setOpaque(false);
        pnButtons.setPreferredSize(new java.awt.Dimension(180, 35));
        pnButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 7, 7));

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/backup/gui/images/add15.png"))); // NOI18N
        btNew.setMnemonic('n');
        btNew.setText(MyApp.getAppText().getString("label.new")); // NOI18N
        btNew.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btNew.setIconTextGap(12);
        btNew.setPreferredSize(new java.awt.Dimension(130, 25));
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        pnButtons.add(btNew);

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/backup/gui/images/save12.png"))); // NOI18N
        btSave.setMnemonic('v');
        btSave.setText(MyApp.getAppText().getString("label.save")); // NOI18N
        btSave.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btSave.setIconTextGap(12);
        btSave.setPreferredSize(new java.awt.Dimension(130, 25));
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        pnButtons.add(btSave);

        btnCanceEdition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/backup/gui/images/cancel15.png"))); // NOI18N
        btnCanceEdition.setMnemonic('l');
        btnCanceEdition.setText(MyApp.getAppText().getString("label.cancel")); // NOI18N
        btnCanceEdition.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCanceEdition.setIconTextGap(12);
        btnCanceEdition.setPreferredSize(new java.awt.Dimension(130, 25));
        btnCanceEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanceEditionActionPerformed(evt);
            }
        });
        pnButtons.add(btnCanceEdition);

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/backup/gui/images/delete15.png"))); // NOI18N
        btDelete.setMnemonic('e');
        btDelete.setText(MyApp.getAppText().getString("label.delete")); // NOI18N
        btDelete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btDelete.setIconTextGap(12);
        btDelete.setPreferredSize(new java.awt.Dimension(130, 25));
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        pnButtons.add(btDelete);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfPrefixName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbOut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfOut))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbPeriodPolitics, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(pnDinamic, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbSession, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbSession, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(tfPrefixName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbOut)
                    .addComponent(tfOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbPeriod)
                        .addComponent(cbPeriodPolitics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnDinamic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSession)
                    .addComponent(cbSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectActionPerformed
        FileUtils.selectLocalDirectory(this.tfOut);
    }//GEN-LAST:event_btSelectActionPerformed

    private void cbPeriodPoliticsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPeriodPoliticsItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            switch ((PeriodPolitics) this.cbPeriodPolitics.getSelectedItem()) {
                case DIARY:
                    selectPanel(this.pnHour);
                    break;
                case ONCE:
                    selectPanel(this.pnTimestamp);
                    break;
                case PERIODICALLY:
                    selectPanel(this.pnUnit);
                    break;
            }
        }

    }//GEN-LAST:event_cbPeriodPoliticsItemStateChanged

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
//        this.setMessage(MessageType.SUCCESSFULLY_MESSAGE, "");
        this.insert();
    }//GEN-LAST:event_btNewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        ScheduledBackup scheduledBackupTemp = this.getCreatedValue();
        if (scheduledBackupTemp != null) {
            if (isInserting()) {
                this.entityLister.setInserted(scheduledBackupTemp);
                this.btNew.setVisible(true);
                this.btDelete.setVisible(true);
                this.setMessage(MessageType.SUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.successfullyInsert"));
                this.currentScheduledBackup = scheduledBackupTemp;
                setEditing();
                BackupFactory.addBackup(scheduledBackupTemp);
            } else if (isEditing()) {
                this.entityLister.setUpdated(scheduledBackupTemp);
                this.setMessage(MessageType.SUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.successfullyUpdate"));
                BackupFactory.alterBackup(this.currentScheduledBackup, scheduledBackupTemp);
                this.currentScheduledBackup = scheduledBackupTemp;
            }
            try {
                SystemFileHandler.getInstance().save();
            } catch (RuntimeException ex) {
                MyApp.log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, MyApp.getAppText().getString("message.saveConfigurationFileUnsuccessfully"), MyApp.getAppText().getString("label.alert"), JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btnCanceEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanceEditionActionPerformed
        if (isEditing()) {
            this.load(this.currentScheduledBackup);
        } else if (isInserting()) {
            this.insert();
            this.btNew.setVisible(true);
            this.btDelete.setVisible(true);
            if (this.entityLister.getEntityList().isEmpty()) {
                this.btDelete.setVisible(false);
            }
        }
        this.entityLister.refresh();
        this.setMessage(MessageType.CLEAN_MESSAGE, "");
    }//GEN-LAST:event_btnCanceEditionActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        this.entityLister.getEntityList().remove(this.currentScheduledBackup);
        BackupFactory.removeBackup(currentScheduledBackup);
        this.entityLister.refresh();
        setMessage(MessageType.SUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.successfullyDelete"));
        if (this.entityLister.getEntityList().isEmpty()) {
            this.insert();
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void ftfHourFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfHourFocusGained
        this.selectAll((JTextField) evt.getSource());
    }//GEN-LAST:event_ftfHourFocusGained

    private void ftfTimestampFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfTimestampFocusGained
        this.selectAll((JTextField) evt.getSource());
    }//GEN-LAST:event_ftfTimestampFocusGained

    private void cbSessionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbSessionFocusGained
        this.loadSessions();    }//GEN-LAST:event_cbSessionFocusGained

    private void selectPanel(final Container container) {
        for (Component c : container.getParent().getComponents()) {
            c.setVisible(c.equals(container));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSelect;
    private javax.swing.JButton btnCanceEdition;
    private javax.swing.JComboBox cbPeriodPolitics;
    private javax.swing.JComboBox cbSession;
    private javax.swing.JComboBox cbUnit;
    private javax.swing.JFormattedTextField ftfHour;
    private javax.swing.JFormattedTextField ftfTimestamp;
    private javax.swing.JLabel lbHour;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbOut;
    private javax.swing.JLabel lbPeriod;
    private javax.swing.JLabel lbSession;
    private javax.swing.JLabel lbTimestamp;
    private javax.swing.JLabel lbValue;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnDinamic;
    private javax.swing.JPanel pnHour;
    private javax.swing.JPanel pnTimestamp;
    private javax.swing.JPanel pnUnit;
    private javax.swing.JSpinner spnValue;
    private javax.swing.JTextField tfOut;
    private javax.swing.JTextField tfPrefixName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load(ScheduledBackup entity) {
        this.currentScheduledBackup = entity;

        this.tfPrefixName.setText(entity.getPrefixName());
        this.tfOut.setText(entity.getDirectory().toString());
        this.spnValue.setValue(entity.getPeriodValue());
        this.cbPeriodPolitics.setSelectedItem(entity.getPolitic());
        this.loadSessions();
        this.cbSession.setSelectedItem(entity.getSession());
        this.cbUnit.setSelectedItem(entity.getPeriodType());
        this.ftfHour.setText(DateUtils.sdfHour.format(new Date(entity.getPeriodValue())));
        this.ftfTimestamp.setText(DateUtils.sdfTimestamp.format(new Date(entity.getPeriodValue())));
        this.setMessage(MessageType.CLEAN_MESSAGE, "");
        this.setEditing();
        this.btNew.setVisible(true);
        this.btDelete.setVisible(true);
    }

    @Override
    public void setEntityLister(EntityLister entityLister) {
        this.entityLister = entityLister;
        if (this.entityLister.getEntityList().isEmpty()) {
            insert();
        }

    }

    @Override
    public void insert() {
        this.setInserting();
        this.btNew.setVisible(false);

        this.btDelete.setVisible(false);
        this.tfPrefixName.setText(null);
        this.tfOut.setText(null);
        this.cbPeriodPolitics.setSelectedIndex(0);
        this.loadSessions();
        this.ftfHour.setText(null);
        this.ftfTimestamp.setText(null);
        this.spnValue.setValue(1);
        this.cbUnit.setSelectedIndex(0);
        this.tfPrefixName.requestFocus();
        this.setMessage(MessageType.CLEAN_MESSAGE, "");
    }

    private void setMessage(MessageType messageType, String message) {
        this.lbMessage.setIcon(messageType.getIcon());
        this.lbMessage.setText(message);
        if (MessageType.SUCCESSFULLY_MESSAGE.equals(messageType)) {
            this.lbMessage.setForeground(GUIUtils.SUCCESSFULLY_MESSAGE);
        } else if (MessageType.UNSUCCESSFULLY_MESSAGE.equals(messageType)) {
            this.lbMessage.setForeground(GUIUtils.UNSUCCESSFULLY_MESSAGE);
        }
    }

    private ScheduledBackup getCreatedValue() {
        if (this.isValidValue()) {
            ScheduledBackup scheduledBackupTemp = new ScheduledBackup();

            scheduledBackupTemp.setPrefixName(this.tfPrefixName.getText());
            scheduledBackupTemp.setDirectory(new File(this.tfOut.getText()));
            scheduledBackupTemp.setPolitic((PeriodPolitics) this.cbPeriodPolitics.getSelectedItem());
            scheduledBackupTemp.setSession((Session) cbSession.getSelectedItem());
            if (this.cbPeriodPolitics.getSelectedItem().equals(PeriodPolitics.DIARY)) {
                try {
                    scheduledBackupTemp.setPeriodValue(DateUtils.sdfHour.parse(this.ftfHour.getText()).getTime());
                } catch (ParseException ex) {
                    MyApp.log(Level.SEVERE, null, ex);
                    scheduledBackupTemp.setPeriodValue(System.currentTimeMillis());
                }
            } else if (this.cbPeriodPolitics.getSelectedItem().equals(PeriodPolitics.ONCE)) {
                try {
                    scheduledBackupTemp.setPeriodValue(DateUtils.sdfTimestamp.parse(this.ftfTimestamp.getText()).getTime());
                } catch (ParseException ex) {
                    MyApp.log(Level.SEVERE, null, ex);
                    scheduledBackupTemp.setPeriodValue(System.currentTimeMillis());
                }
            } else {
                scheduledBackupTemp.setPeriodType((Period) this.cbUnit.getSelectedItem());
                scheduledBackupTemp.setPeriodValue(new Long(this.spnValue.getValue() + ""));
            }
            return scheduledBackupTemp;
        }
        return null;
    }

    private boolean isValidValue() {
        if (isInserting()) {
            for (ScheduledBackup sbTemp : MyApp.getSystemFile().getScheduledBackupList().getScheduledBackups()) {
                if (sbTemp.getPrefixName().trim().equals(this.tfPrefixName.getText().trim())) {
                    this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.duplicateEntity"));
                    this.tfPrefixName.requestFocus();
                    return false;
                }
            }
        }

        if (this.tfPrefixName.getText().isEmpty()) {
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
            this.tfPrefixName.requestFocus();
            return false;
        }

        if (this.tfOut.getText().isEmpty()) {
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
            this.tfOut.requestFocus();
            return false;
        } else if (!FileUtils.isValidDirectoryName(this.tfOut.getText())) {
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getFormattedText("message.invalidDirectoryName", this.tfOut.getText()));
            this.tfOut.requestFocus();
            return false;
        }

        if (this.cbSession.getSelectedItem() == null) {
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
            this.cbSession.requestFocus();
            return false;
        }

        if (this.cbPeriodPolitics.getSelectedItem().equals(PeriodPolitics.DIARY)) {
            if (ftfHour.getText().isEmpty()) {
                this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
                this.ftfHour.requestFocus();
                return false;
            } else {
                try {
                    DateUtils.sdfHour.parse(this.ftfHour.getText());
                } catch (ParseException e) {
                    MyApp.log(Level.OFF, null, e);
                    this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.invalidTimestampFormat"));
                    this.ftfHour.requestFocus();
                    return false;
                }
            }
        } else if (this.cbPeriodPolitics.getSelectedItem().equals(PeriodPolitics.ONCE)) {
            if (ftfTimestamp.getText().isEmpty()) {
                this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
                this.ftfTimestamp.requestFocus();
                return false;
            } else {
                try {
                    Date dateTemp = DateUtils.sdfTimestamp.parse(this.ftfTimestamp.getText());
                    if (dateTemp.before(new Date())) {
                        this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.invalidDate"));
                        this.ftfTimestamp.requestFocus();
                        return false;
                    }
                } catch (ParseException e) {
                    MyApp.log(Level.OFF, null, e);
                    this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.invalidTimestampFormat"));
                    this.ftfTimestamp.requestFocus();
                    return false;
                }
            }
        } else {
            if (this.cbUnit.getSelectedItem() == null) {
                this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
                this.cbUnit.requestFocus();
                return false;
            }
        }

        return true;
    }

    private void selectAll(final JTextField source) {
        source.setSelectionStart(0);
        source.setSelectionEnd(source.getText().length());
    }

    private void loadSessions() {
        this.cbSession.setModel(new DefaultComboBoxModel(MyApp.getSystemFile().getSessionList().getSessions().toArray()));
    }

}
