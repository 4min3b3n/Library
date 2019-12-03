/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Database.*;
import Personne.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ForgotPasswordPanel extends javax.swing.JPanel {

    private int typePersonne = 0;
    private String codePersonneS = new String();
    private String nomPersonneS = new String();
    private String prenomPersonneS = new String();
    
    Personne per = new Personne(){};
    
    Database biblio;
    
    javax.swing.JFrame frame;
    
    public ForgotPasswordPanel(Database biblio, javax.swing.JFrame frame) {
        initComponents();
        
        this.frame = frame;
        this.biblio = biblio;
    }

    public int getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(int typePersonne) {
        this.typePersonne = typePersonne;
    }

    public String getCodePersonneS() {
        return codePersonneS;
    }

    public void setCodePersonneS(String codePersonneS) {
        this.codePersonneS = codePersonneS;
    }

    public String getNomPersonneS() {
        return nomPersonneS;
    }

    public void setNomPersonneS(String nomPersonneS) {
        this.nomPersonneS = nomPersonneS;
    }

    public String getPrenomPersonneS() {
        return prenomPersonneS;
    }

    public void setPrenomPersonneS(String prenomPersonneS) {
        this.prenomPersonneS = prenomPersonneS;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codePersonne = new javax.swing.JTextField();
        nomPersonne = new javax.swing.JTextField();
        prenomPersonne = new javax.swing.JTextField();
        verifier = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        codePersonne.setText("Entrer votre CIN / CNE");
        codePersonne.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                codePersonneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                codePersonneFocusLost(evt);
            }
        });

        nomPersonne.setText("Entre votre nom");
        nomPersonne.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomPersonneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomPersonneFocusLost(evt);
            }
        });

        prenomPersonne.setText("Entrer votre prénom");
        prenomPersonne.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                prenomPersonneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                prenomPersonneFocusLost(evt);
            }
        });

        verifier.setText("Verify");
        verifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifierActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Back");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codePersonne)
                            .addComponent(prenomPersonne)
                            .addComponent(nomPersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(229, 229, 229))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(verifier, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(332, 332, 332))))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jToggleButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(codePersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nomPersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(prenomPersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(verifier, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jToggleButton1)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void verifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifierActionPerformed
        PasswordWindow newPassword = new PasswordWindow(biblio, codePersonneS);
        try {
            per = biblio.getPersonneByCIN(codePersonneS);
            String oldPassword = per.getPassword();
            if (per.getFirstName().equals(this.getNomPersonneS()) && per.getPrenom().equals(this.getPrenomPersonneS())) {
                
                newPassword.setOldPassword(oldPassword);
                newPassword.setVisible(true);
                newPassword.getOldPasswordField().setVisible(false);
                newPassword.getAnnuler().setVisible(false);
                newPassword.getjLabel1().setVisible(false);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPasswordPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (newPassword.isPasswordChanged()) {
                    frame.removeAll();
                    frame.dispose();
        
                    frame.setContentPane(new ConnectionWindow(biblio));
                    frame.pack();
                    frame.repaint();
        }
    }//GEN-LAST:event_verifierActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        frame.removeAll();
        frame.dispose();
        
        frame.setContentPane(new ConnectionWindow(biblio));
        frame.pack();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void codePersonneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codePersonneFocusGained
       if (codePersonne.getText().equals("Entrer votre CIN / CNE")) {
            codePersonne.setText("");
        }
    }//GEN-LAST:event_codePersonneFocusGained

    private void nomPersonneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomPersonneFocusGained
        if (nomPersonne.getText().equals("Entre votre nom")) {
            nomPersonne.setText("");
        }
    }//GEN-LAST:event_nomPersonneFocusGained

    private void prenomPersonneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prenomPersonneFocusGained
        if (prenomPersonne.getText().equals("Entre votre prénom")) {
            prenomPersonne.setText("");
        }
    }//GEN-LAST:event_prenomPersonneFocusGained

    private void codePersonneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codePersonneFocusLost
        this.setCodePersonneS(codePersonne.getText());
    }//GEN-LAST:event_codePersonneFocusLost

    private void nomPersonneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomPersonneFocusLost
        this.setNomPersonneS(nomPersonne.getText());
    }//GEN-LAST:event_nomPersonneFocusLost

    private void prenomPersonneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prenomPersonneFocusLost
        this.setPrenomPersonneS(prenomPersonne.getText());
    }//GEN-LAST:event_prenomPersonneFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codePersonne;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField nomPersonne;
    private javax.swing.JTextField prenomPersonne;
    private javax.swing.JButton verifier;
    // End of variables declaration//GEN-END:variables
}
