package com.backup.gui;

import com.backup.BackupFactory;
import com.backup.bean.Session;
import com.backup.app.MyApp;
import com.backup.io.SystemFileHandler;
import com.backup.utils.FileUtils;
import com.backup.utils.GUIUtils;
import java.awt.Toolkit;
import java.io.File;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 * @author Allan Jacques
 */
public class SessionEditor extends AbstractEntityEditor implements EntityEditor<Session> {

    private EntityLister entityLister;
    private Session currentSession;

    public SessionEditor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbURL = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        tfHost = new javax.swing.JTextField();
        tfUser = new javax.swing.JTextField();
        pnButtons = new javax.swing.JPanel();
        btNew = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btnCanceEdition = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        pfPassword = new javax.swing.JPasswordField();
        lbPort = new javax.swing.JLabel();
        lbLocal = new javax.swing.JLabel();
        tfLocalFile = new javax.swing.JTextField();
        btSelectFile = new javax.swing.JButton();
        lbMessage = new javax.swing.JLabel();
        ftfPort = new javax.swing.JFormattedTextField();
        lbDatabase = new javax.swing.JLabel();
        tfDatabase = new javax.swing.JTextField();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(MyApp.getAppText().getString("label.session"))); // NOI18N
        setOpaque(false);

        lbURL.setDisplayedMnemonic('h');
        lbURL.setLabelFor(tfHost);
        lbURL.setText(MyApp.getAppText().getString("label.host")); // NOI18N

        lbUser.setDisplayedMnemonic('u');
        lbUser.setLabelFor(tfUser);
        lbUser.setText(MyApp.getAppText().getString("label.user")); // NOI18N

        lbPassword.setDisplayedMnemonic('a');
        lbPassword.setLabelFor(pfPassword);
        lbPassword.setText(MyApp.getAppText().getString("label.password")); // NOI18N

        pnButtons.setOpaque(false);
        pnButtons.setPreferredSize(new java.awt.Dimension(180, 35));
        pnButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 7, 7));

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/backup/gui/images/add15.png"))); // NOI18N
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

        lbPort.setDisplayedMnemonic('p');
        lbPort.setLabelFor(ftfPort);
        lbPort.setText(MyApp.getAppText().getString("label.port")); // NOI18N

        lbLocal.setDisplayedMnemonic('l');
        lbLocal.setLabelFor(tfLocalFile);
        lbLocal.setText(MyApp.getAppText().getString("label.local")); // NOI18N
        lbLocal.setToolTipText(MyApp.getAppText().getString("message.localFile")); // NOI18N

        tfLocalFile.setToolTipText(MyApp.getAppText().getString("message.localFile")); // NOI18N

        btSelectFile.setFont(new java.awt.Font("Tahoma", 0, 7)); // NOI18N
        btSelectFile.setText(MyApp.getAppText().getString("label.select")); // NOI18N
        btSelectFile.setIconTextGap(0);
        btSelectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectFileActionPerformed(evt);
            }
        });

        lbMessage.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(255, 0, 0));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText(" ");

        ftfPort.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####0"))));

        lbDatabase.setDisplayedMnemonic('e');
        lbDatabase.setLabelFor(tfDatabase);
        lbDatabase.setText(MyApp.getAppText().getString("label.database")); // NOI18N

        lbName.setLabelFor(tfName);
        lbName.setText(MyApp.getAppText().getString("label.name")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnButtons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbLocal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbURL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDatabase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLocalFile)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(lbPort)
                                .addGap(18, 18, 18)
                                .addComponent(ftfPort, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                            .addComponent(tfUser)
                            .addComponent(pfPassword)
                            .addComponent(tfDatabase)
                            .addComponent(tfName))
                        .addGap(5, 5, 5)
                        .addComponent(btSelectFile, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbURL)
                    .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPort)
                    .addComponent(ftfPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUser)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDatabase)
                    .addComponent(tfDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbLocal)
                        .addComponent(tfLocalFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btSelectFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        //try{
            //    this.remove(ftfPort);
            //    MaskFormatter mask = new MaskFormatter("****");
            //    mask.setPlaceholderCharacter('0');
            //    mask.setPlaceholder("0");
            //    mask.setCommitsOnValidEdit(true);
            //    this.ftfPort = new JFormattedTextField(mask);
            //    this.add(ftfPort);
            //}catch(ParseException e){
            //    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            //}
    }// </editor-fold>//GEN-END:initComponents

    private void btSelectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectFileActionPerformed
        FileUtils.selectLocalFile(this.tfLocalFile);
    }//GEN-LAST:event_btSelectFileActionPerformed

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        this.insert();
    }//GEN-LAST:event_btNewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        Session sessionTemp = this.getCreatedValue();
        if (sessionTemp != null) {
            if (isInserting()) {
                this.entityLister.setInserted(sessionTemp);
                this.btNew.setVisible(true);
                this.btDelete.setVisible(true);
                this.setMessage(MessageType.SUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.successfullyInsert"));
                this.currentSession = sessionTemp;
                setEditing();
            } else if (isEditing()) {
                this.entityLister.setUpdated(sessionTemp);
                this.setMessage(MessageType.SUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.successfullyUpdate"));
                SystemFileHandler.getInstance().alterSession(this.currentSession, sessionTemp);
                BackupFactory.alterSession(this.currentSession, sessionTemp);
                this.currentSession = sessionTemp;
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
            this.load(this.currentSession);
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
        this.entityLister.getEntityList().remove(this.currentSession);
        this.entityLister.refresh();
        setMessage(MessageType.SUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.successfullyDelete"));
        if (this.entityLister.getEntityList().isEmpty()) {
            this.insert();
        }
    }//GEN-LAST:event_btDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSelectFile;
    private javax.swing.JButton btnCanceEdition;
    private javax.swing.JFormattedTextField ftfPort;
    private javax.swing.JLabel lbDatabase;
    private javax.swing.JLabel lbLocal;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbPort;
    private javax.swing.JLabel lbURL;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JTextField tfDatabase;
    private javax.swing.JTextField tfHost;
    private javax.swing.JTextField tfLocalFile;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load(Session entity) {
        this.currentSession = entity;
        this.tfName.setText(entity.getName());
        this.tfHost.setText(currentSession.getHost());
        this.tfDatabase.setText(entity.getDatabaseName());
        this.tfLocalFile.setText(currentSession.getLocalFile().toString());
        this.tfUser.setText(currentSession.getUser());
        this.ftfPort.setText(currentSession.getPort().toString());
        this.pfPassword.setText(currentSession.getPassword());
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
        this.tfName.setText(null);
        this.tfHost.setText(null);
        this.tfLocalFile.setText(null);
        this.tfDatabase.setText(null);
        this.ftfPort.setText(null);
        this.tfUser.setText(null);
        this.pfPassword.setText(null);
        this.setMessage(MessageType.CLEAN_MESSAGE, "");
        this.tfName.requestFocus();
    }

    private Session getCreatedValue() {
        if (isValidValue()) {
            Session newSession = new Session();

            newSession.setName(this.tfName.getText());
            newSession.setHost(this.tfHost.getText());
            newSession.setLocalFile(new File(this.tfLocalFile.getText()));
            newSession.setPassword(new String(this.pfPassword.getPassword()));
            newSession.setPort(Integer.parseInt(this.ftfPort.getText()));
            newSession.setUser(this.tfUser.getText());
            newSession.setDatabaseName(this.tfDatabase.getText());

            return newSession;
        }
        return null;
    }

    private boolean isValidValue() {
        if (isInserting()) {
            for (Session sessionTemp : MyApp.getSystemFile().getSessionList().getSessions()) {
                if (sessionTemp.getName().trim().equals(this.tfName.getText().trim())) {
                    this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.duplicateEntity"));
                    this.tfName.requestFocus();
                    return false;
                }
            }
        }
        if (this.tfName.getText().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
            this.tfName.requestFocus();
            return false;
        }
        if (this.tfHost.getText().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
            this.tfHost.requestFocus();
            return false;
        }

        if (this.ftfPort.getText().trim().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
            this.ftfPort.requestFocus();
            return false;
        } else {
            try {
                int port = Integer.parseInt(this.ftfPort.getText());
                if (port < 1 || port > 65535) {
                    throw new NumberFormatException(port + "+");
                }
            } catch (NumberFormatException e) {
                Toolkit.getDefaultToolkit().beep();
                this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.validValueForPort"));
                this.ftfPort.requestFocus();
                return false;
            }
        }

        if (this.tfUser.getText().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
            this.tfUser.requestFocus();
            return false;
        }

        if (this.tfDatabase.getText().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("message.notNullField"));
            this.tfDatabase.requestFocus();
            return false;
        }

        if ((!this.tfLocalFile.getText().isEmpty()) && !(new File(this.tfLocalFile.getText()).exists())) {
            Toolkit.getDefaultToolkit().beep();
            this.setMessage(MessageType.UNSUCCESSFULLY_MESSAGE, MyApp.getAppText().getString("messege.fileNotFound"));
            this.tfLocalFile.requestFocus();
            return false;
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

}
