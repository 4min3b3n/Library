/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vues;

import Database.*;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class PasswordWindow extends javax.swing.JFrame {

    Database biblioBD;
    
    int iPer = -1;
    
    String username = new String();
    String password = new String();
    
    String temPassword1 = new String();
    String temPassword2 = new String();
    
    String oldPassword = new String();
    String newPassword = new String();
    
    boolean passwordChanged = false;
    
    public PasswordWindow(Database biblioBD, String username) {
        initComponents();
        
        this.biblioBD = biblioBD;
        this.username = username;
             
        this.setResizable(false);  
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getTemPassword1() {
        return temPassword1;
    }

    public void setTemPassword1(String temPassword1) {
        this.temPassword1 = temPassword1;
    }

    public String getTemPassword2() {
        return temPassword2;
    }

    public void setTemPassword2(String temPassword2) {
        this.temPassword2 = temPassword2;
    }

    public void setAnnuler(JButton Annuler) {
        this.Annuler = Annuler;
    }

    public void setOldPasswordField(JPasswordField oldPasswordField) {
        this.oldPasswordField = oldPasswordField;
    }

    public JButton getAnnuler() {
        return Annuler;
    }

    public JPasswordField getOldPasswordField() {
        return oldPasswordField;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public boolean isPasswordChanged() {
        return passwordChanged;
    }

    public void setPasswordChanged(boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newPasswordField1 = new javax.swing.JPasswordField();
        newPasswordField2 = new javax.swing.JPasswordField();
        oldPasswordField = new javax.swing.JPasswordField();
        Confirmer = new javax.swing.JButton();
        Annuler = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                newPasswordField1FocusLost(evt);
            }
        });

        newPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                newPasswordField2FocusLost(evt);
            }
        });

        oldPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                oldPasswordFieldFocusLost(evt);
            }
        });

        Confirmer.setText("Confirmer");
        Confirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmerActionPerformed(evt);
            }
        });

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });

        jLabel1.setText("Ancien mot de passe");

        jLabel2.setText("Nouveau mot de passe");

        jLabel3.setText("                           Changer le mot de passe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Annuler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Confirmer)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oldPasswordField)
                            .addComponent(newPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(oldPasswordField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(newPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Confirmer)
                    .addComponent(Annuler))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmerActionPerformed
        if (temPassword2.equals(temPassword1)) {
            newPassword = temPassword2;
            try {
                if (biblioBD.VerifPassword(username, oldPassword)) {
                    biblioBD.ChangePassword(username, newPassword);
                    this.setPasswordChanged(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PasswordWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Introvable a =new Introvable("       Mot de passe ");
            a.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_ConfirmerActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

    private void oldPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldPasswordFieldFocusLost
        this.setOldPassword(String.valueOf(oldPasswordField.getPassword()));
    }//GEN-LAST:event_oldPasswordFieldFocusLost

    private void newPasswordField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newPasswordField1FocusLost
        this.setTemPassword1(String.valueOf(newPasswordField1.getPassword()));
    }//GEN-LAST:event_newPasswordField1FocusLost

    private void newPasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newPasswordField2FocusLost
        this.setTemPassword2(String.valueOf(newPasswordField2.getPassword()));
    }//GEN-LAST:event_newPasswordField2FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JButton Confirmer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField newPasswordField1;
    private javax.swing.JPasswordField newPasswordField2;
    private javax.swing.JPasswordField oldPasswordField;
    // End of variables declaration//GEN-END:variables

}
