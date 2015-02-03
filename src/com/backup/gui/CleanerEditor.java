package com.backup.gui;

import com.backup.BackupFactory;
import com.backup.app.MyApp;
import com.backup.bean.Cleaner;
import com.backup.io.SystemFileHandler;
import com.backup.utils.FileUtils;
import com.backup.utils.GUIUtils;
import com.backup.utils.enums.MeasureUnitBytes;
import com.backup.utils.enums.MeasureUnitTime;
import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 * @author Allan Jacques
 */
public class CleanerEditor extends AbstractEntityEditor implements EntityEditor<Cleaner> {

    private EntityLister entityLister;
    private Cleaner currentCleaner;

    public CleanerEditor() {
        initComponents();
        this.lsPatterns.setModel(new DefaultListModel());
        this.spnLimit.setModel(new SpinnerNumberModel(0L, 0L, Long.MAX_VALUE, 1L));
        this.spnRate.setModel(new SpinnerNumberModel(0L, 0L, Long.MAX_VALUE, 1L));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTargetDirectory = new javax.swing.JLabel();
        tfTargetDirectory = new javax.swing.JTextField();
        btSelectFile = new javax.swing.JButton();
        ckbRecursive = new javax.swing.JCheckBox();
        lbLimit = new javax.swing.JLabel();
        spnLimit = new javax.swing.JSpinner();
        spnRate = new javax.swing.JSpinner();
        lbRate = new javax.swing.JLabel();
        pnPatterns = new javax.swing.JPanel();
        lbPattern = new javax.swing.JLabel();
        tfPattern = new javax.swing.JTextField();
        scpList = new javax.swing.JScrollPane();
        lsPatterns = new javax.swing.JList();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        lbPatternExplaination = new javax.swing.JLabel();
        pnButtons = new javax.swing.JPanel();
        btNew = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btnCanceEdition = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        lbMessage = new javax.swing.JLabel();
        cbMeasureUnitByte = new javax.swing.JComboBox();
        cbMeasureUnitTime = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder(MyApp.getAppText().getString("label.cleaning"))); // NOI18N

        lbTargetDirectory.setDisplayedMnemonic('d');
        lbTargetDirectory.setLabelFor(tfTargetDirectory);
        lbTargetDirectory.setText(MyApp.getAppText().getString("label.directory")); // NOI18N

        btSelectFile.setFont(new java.awt.Font("Tahoma", 0, 7)); // NOI18N
        btSelectFile.setText(MyApp.getAppText().getString("label.select")); // NOI18N
        btSelectFile.setAlignmentX(0.5F);
        btSelectFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSelectFile.setIconTextGap(0);
        btSelectFile.setMaximumSize(new java.awt.Dimension(50, 26));
        btSelectFile.setMinimumSize(new java.awt.Dimension(50, 26));
        btSelectFile.setPreferredSize(new java.awt.Dimension(50, 26));
        btSelectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectFileActionPerformed(evt);
            }
        });

        ckbRecursive.setMnemonic('e');
        ckbRecursive.setText(MyApp.getAppText().getString("label.recursive")); // NOI18N
        ckbRecursive.setAlignmentX(0.5F);

        lbLimit.setDisplayedMnemonic('l');
        lbLimit.setLabelFor(spnLimit);
        lbLimit.setText(MyApp.getAppText().getString("label.limit")); // NOI18N

        lbRate.setDisplayedMnemonic('r');
        lbRate.setLabelFor(spnRate);
        lbRate.setText(MyApp.getAppText().getString("label.rate")); // NOI18N

        pnPatterns.setBorder(javax.swing.BorderFactory.createTitledBorder(MyApp.getAppText().getString("label.patterns"))); // NOI18N

        lbPattern.setDisplayedMnemonic('p');
        lbPattern.setLabelFor(tfPattern);
        lbPattern.setText(MyApp.getAppText().getString("label.pattern")); // NOI18N

        lsPatterns.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scpList.setViewportView(lsPatterns);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/backup/gui/images/add15.png"))); // NOI18N
        btnAdd.setMnemonic('+');
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/backup/gui/images/delete15.png"))); // NOI18N
        btnDel.setMnemonic('-');
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        lbPatternExplaination.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPatternExplaination.setText(MyApp.getAppText().getString("message.patterns")); // NOI18N
        lbPatternExplaination.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPatternExplaination.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPatternExplainationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbPatternExplainationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbPatternExplainationMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnPatternsLayout = new javax.swing.GroupLayout(pnPatterns);
        pnPatterns.setLayout(pnPatternsLayout);
        pnPatternsLayout.setHorizontalGroup(
            pnPatternsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPatternsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPatternsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPatternExplaination)
                    .addGroup(pnPatternsLayout.createSequentialGroup()
                        .addComponent(lbPattern)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPattern, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPatternsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scpList, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnPatternsLayout.setVerticalGroup(
            pnPatternsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPatternsLayout.createSequentialGroup()
                .addComponent(lbPatternExplaination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnPatternsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPatternsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(scpList, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnPatternsLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(pnPatternsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPatternsLayout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(5, 5, 5)
                                .addComponent(btnDel))
                            .addGroup(pnPatternsLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(pnPatternsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbPattern)
                                    .addComponent(tfPattern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnButtons.setOpaque(false);
        pnButtons.setPreferredSize(new java.awt.Dimension(180, 35));
        pnButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 7, 7));

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/backup/gui/images/add15.png"))); // NOI18N
        btNew.setMnemonic('o');
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
        btSave.setMnemonic('s');
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
        btnCanceEdition.setMnemonic('c');
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
        btDelete.setMnemonic('m');
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

        lbMessage.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(255, 0, 0));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText(" ");

        cbMeasureUnitByte.setModel(new DefaultComboBoxModel<MeasureUnitBytes>(MeasureUnitBytes.values()));

        cbMeasureUnitTime.setModel(new DefaultComboBoxModel(MeasureUnitTime.values())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbRate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(spnRate, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(spnLimit)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbMeasureUnitByte, 0, 64, Short.MAX_VALUE)
                                    .addComponent(cbMeasureUnitTime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTargetDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(tfTargetDirectory)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSelectFile, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ckbRecursive)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnPatterns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSelectFile, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTargetDirectory)
                        .addComponent(tfTargetDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLimit)
                    .addComponent(spnLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMeasureUnitByte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRate)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMeasureUnitTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(ckbRecursive)
                .addGap(18, 18, 18)
                .addComponent(pnPatterns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSelectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectFileActionPerformed
        FileUtils.selectLocalDirectory(this.tfTargetDirectory);
    }//GEN-LAST:event_btSelectFileActionPerformed

    private void lbPatternExplainationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPatternExplainationMouseEntered
        lbPatternExplaination.setText(MyApp.getAppText().getString("message.patternsUnderlined"));
    }//GEN-LAST:event_lbPatternExplainationMouseEntered

    private void lbPatternExplainationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPatternExplainationMouseExited
        lbPatternExplaination.setText(MyApp.getAppText().getString("message.patterns"));
    }//GEN-LAST:event_lbPatternExplainationMouseExited

    private void lbPatternExplainationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPatternExplainationMouseClicked

        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop d = Desktop.getDesktop();
            try {
                d.browse(new URL("http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html#construct").toURI());
            } catch (Exception ex) {
                MyApp.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lbPatternExplainationMouseClicked

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        this.insert();
    }//GEN-LAST:event_btNewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        Cleaner cleanerTemp = this.getCreatedValue();
        if (cleanerTemp != null) {
            if (isInserting()) {
                this.entityLister.setInserted(cleanerTemp);
                this.btNew.setVisible(true);
                this.btDelete.setVisible(true);
                this.setMessage(MessageType.SUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.successfullyInsert"));
                this.currentCleaner = cleanerTemp;
                setEditing();
                BackupFactory.addCleaner(cleanerTemp);
            } else if (isEditing()) {
                this.entityLister.setUpdated(cleanerTemp);
                this.setMessage(MessageType.SUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.successfullyUpdate"));
                BackupFactory.alterCleaner(this.currentCleaner, cleanerTemp);
                this.currentCleaner = cleanerTemp;
            }
            try {
                SystemFileHandler.getInstance().save();
            } catch (RuntimeException ex) {
                MyApp.log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, MyApp.getAppText().getString("message.saveConfigurationFileUnsuccessfully"), MyApp.getAppText().getString("label.alert"), JOptionPane.ERROR_MESSAGE);
            }
        }
        this.tfPattern.setText(null);
    }//GEN-LAST:event_btSaveActionPerformed

    private void btnCanceEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanceEditionActionPerformed
        if (isEditing()) {
            this.load(this.currentCleaner);
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
        this.entityLister.getEntityList().remove(this.currentCleaner);
        BackupFactory.removeCleaner(this.currentCleaner);
        this.entityLister.refresh();
        setMessage(MessageType.SUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.successfullyDelete"));
        if (this.entityLister.getEntityList().isEmpty()) {
            this.insert();
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!this.tfPattern.getText().isEmpty()) {
            addPattern();
        }
        this.tfPattern.setText(null);
        this.tfPattern.requestFocus();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        removePattern();
    }//GEN-LAST:event_btnDelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSelectFile;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCanceEdition;
    private javax.swing.JButton btnDel;
    private javax.swing.JComboBox cbMeasureUnitByte;
    private javax.swing.JComboBox cbMeasureUnitTime;
    private javax.swing.JCheckBox ckbRecursive;
    private javax.swing.JLabel lbLimit;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbPattern;
    private javax.swing.JLabel lbPatternExplaination;
    private javax.swing.JLabel lbRate;
    private javax.swing.JLabel lbTargetDirectory;
    private javax.swing.JList lsPatterns;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnPatterns;
    private javax.swing.JScrollPane scpList;
    private javax.swing.JSpinner spnLimit;
    private javax.swing.JSpinner spnRate;
    private javax.swing.JTextField tfPattern;
    private javax.swing.JTextField tfTargetDirectory;
    // End of variables declaration//GEN-END:variables
    @Override
    public void insert() {
        this.currentCleaner = null;
        this.setInserting();
        this.btNew.setVisible(false);
        this.btDelete.setVisible(false);
        this.tfPattern.setText(null);
        this.tfTargetDirectory.setText(null);
        this.spnLimit.setValue(0);
        this.spnRate.setValue(0);
        this.ckbRecursive.setSelected(false);
        this.setMessage(MessageType.CLEAN_MESSAGE, "");
        this.lsPatterns.setModel(new DefaultListModel<Object>());
        this.tfTargetDirectory.requestFocus();
    }

    @Override
    public void load(Cleaner entity) {
        this.currentCleaner = entity;
        this.tfTargetDirectory.setText(entity.getTargetDirectory().toString());
        this.spnLimit.setValue(entity.getCapacityLimit());
        this.spnRate.setValue(entity.getRate());
        this.tfPattern.setText(null);
        this.ckbRecursive.setSelected(entity.isRecursive());

        DefaultListModel model = (DefaultListModel) this.lsPatterns.getModel();
        model.removeAllElements();
        if (entity.getPatterns() != null && !entity.getPatterns().isEmpty()) {
            for (int i = 0; i < entity.getPatterns().size(); i++) {
                model.add(i, entity.getPatterns().get(i));
            }
        }

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

    private Cleaner getCreatedValue() {
        if (isValidValue()) {
            Cleaner newCleaner = new Cleaner();
            try {
                newCleaner.setCapacityLimit(((Double) this.spnLimit.getValue()).intValue());
                newCleaner.setRate(((Double) this.spnRate.getValue()).intValue());
            } catch (ClassCastException cce) {
                newCleaner.setCapacityLimit(((Integer) this.spnLimit.getValue()));
                newCleaner.setRate(((Integer) this.spnRate.getValue()));
            }
            newCleaner.setMeasureUnitBytes((MeasureUnitBytes) this.cbMeasureUnitByte.getModel().getSelectedItem());
            newCleaner.setMeasureUnitTime((MeasureUnitTime) this.cbMeasureUnitTime.getModel().getSelectedItem());
            newCleaner.setRecursive(this.ckbRecursive.isSelected());
            newCleaner.setTargetDirectory(new File(this.tfTargetDirectory.getText()));
            newCleaner.setPatterns(new ArrayList<String>());
            DefaultListModel<String> listModel = (DefaultListModel<String>) this.lsPatterns.getModel();
            for (int i = 0; i < listModel.size(); i++) {
                newCleaner.getPatterns().add(listModel.get(i));
            }
            return newCleaner;
        }
        return null;
    }

    private boolean isValidValue() {
        if (this.tfTargetDirectory.getText().isEmpty()) {
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
            this.tfTargetDirectory.requestFocus();
            return false;
        } else if (!(new File(this.tfTargetDirectory.getText()).exists())) {
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getFormattedText("messege.directoryNotFound", this.tfTargetDirectory.getText()));
            this.tfTargetDirectory.requestFocus();
            return false;
        }
        try {
            if ((((Double) this.spnLimit.getValue())) < 0.0) {
                this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getFormattedText("message.positiveNumberRequired"));
                this.spnLimit.requestFocus();
                return false;
            }
            if ((((Double) this.spnRate.getValue())) < 0.0) {
                this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getFormattedText("message.positiveNumberRequired"));
                this.spnRate.requestFocus();
                return false;
            }
        } catch (ClassCastException cce) {
            if ((((Integer) this.spnLimit.getValue())) < 0.0) {
                this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getFormattedText("message.positiveNumberRequired"));
                this.spnLimit.requestFocus();
                return false;
            }
            if ((((Integer) this.spnRate.getValue())) < 0.0) {
                this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getFormattedText("message.positiveNumberRequired"));
                this.spnRate.requestFocus();
                return false;
            }
        }

        return true;
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

    private void removePattern() {
        DefaultListModel listModel = ((DefaultListModel) this.lsPatterns.getModel());

        for (int i = this.lsPatterns.getSelectedIndices().length - 1; i >= 0; i--) {
            listModel.remove(this.lsPatterns.getSelectedIndices()[i]);
        }
        if (this.currentCleaner != null) {
            this.currentCleaner.setPatterns(new ArrayList<String>());
            Enumeration elements = listModel.elements();
            while (elements.hasMoreElements()) {
                this.currentCleaner.getPatterns().add(elements.nextElement().toString());
            }
        }
    }

    private void addPattern() {
        if (isValidPattern()) {
            DefaultListModel listModel = ((DefaultListModel) this.lsPatterns.getModel());
            listModel.add(listModel.getSize(), this.tfPattern.getText());
            if (this.currentCleaner != null) {
                this.currentCleaner.setPatterns(new ArrayList<String>());
                Enumeration elements = listModel.elements();
                while (elements.hasMoreElements()) {
                    this.currentCleaner.getPatterns().add(elements.nextElement().toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(MyApp.getPrincipalFrame(), MyApp.getAppText().getString("message.invalidPattern"), MyApp.getAppText().getString("message.invalidPattern"), JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isValidPattern() {
        try {
            "test".matches(this.tfPattern.getText());
        } catch (Exception e) {
            MyApp.log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

}
