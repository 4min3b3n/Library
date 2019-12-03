package Vues;

import Database.*;
import Personne.*;

import java.sql.SQLException;


public class InscriptionPanel extends javax.swing.JPanel {

    Database biblio;
     
   
    private int type = 0;
    private String nom = new String();
    private String prenom = new String();
    private int age = 0;
    private String password = new String();
    
    private String password1 = new String();
    private String password2 = new String();
    private String CIN_CNE = new String();
    private String filiere_matiere = new String();
    
    
    
    boolean retour = false;
    
    javax.swing.JFrame frame;
    
    public InscriptionPanel(Database biblio, javax.swing.JFrame frame) {
        initComponents();
        
        this.biblio = biblio;
        
        this.frame = frame;
        fli_matTextField.setEnabled(false);
    
    }

      public void setType(int type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPernom() {
        return prenom;
    }

    public void setPernom(String pernom) {
        this.prenom = pernom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password) {
        this.password1 = password;
    }
    
    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password) {
        this.password2 = password;
    }

    public String getCIN_CNE() {
        return CIN_CNE;
    }

    public void setCIN_CNE(String CIN_CNE) {
        this.CIN_CNE = CIN_CNE;
    }

    public String getFiliere_matiere() {
        return filiere_matiere;
    }

    public void setFiliere_matiere(String filiere_matiere) {
        this.filiere_matiere = filiere_matiere;
    }

    public boolean isRetour() {
        return retour;
    }

    public void setRetour(boolean retour) {
        this.retour = retour;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        fli_matTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        confirmerButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        annulerButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        nomTextField_ = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cin_cneTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        prenomTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(18, 1, 120, 1));
        jSpinner1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jSpinner1FocusLost(evt);
            }
        });

        jLabel3.setText("Prénom");

        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusLost(evt);
            }
        });

        jLabel9.setText("Filiere ou Matiere");

        jPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusLost(evt);
            }
        });

        jLabel4.setText("Age");

        fli_matTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fli_matTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fli_matTextFieldFocusLost(evt);
            }
        });
        fli_matTextField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fli_matTextFieldPropertyChange(evt);
            }
        });
        fli_matTextField.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                fli_matTextFieldVetoableChange(evt);
            }
        });

        jLabel5.setText("Mot de passe");

        confirmerButton.setText("Confirmer");
        confirmerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmerButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Confirmer le mot de passe");

        annulerButton.setText("Annuler");
        annulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerButtonActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("Seulement pour étudiant et professseur");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adhérent", "Etudiant", "Professeur" }));
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox1FocusLost(evt);
            }
        });

        jLabel7.setText("Type d'adhérent");

        nomTextField_.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomTextField_FocusLost(evt);
            }
        });

        jLabel1.setText("                                                                                         Inscription");

        cin_cneTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cin_cneTextFieldFocusLost(evt);
            }
        });

        jLabel2.setText("Nom");

        prenomTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prenomTextFieldFocusLost(evt);
            }
        });

        jLabel8.setText("CIN ou CNE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(annulerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(41, 41, 41)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(prenomTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(nomTextField_, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4)
                                .addGap(110, 110, 110)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPasswordField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cin_cneTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(fli_matTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomTextField_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(prenomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cin_cneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(fli_matTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(annulerButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(confirmerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinner1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jSpinner1FocusLost
        this.setAge((Integer) jSpinner1.getValue());
        
    }//GEN-LAST:event_jSpinner1FocusLost

    private void jPasswordField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusLost
        this.setPassword1(String.valueOf(jPasswordField1.getPassword()));
    }//GEN-LAST:event_jPasswordField1FocusLost

    private void jPasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusLost
        this.setPassword2(String.valueOf(jPasswordField2.getPassword()));
    }//GEN-LAST:event_jPasswordField2FocusLost

    private void fli_matTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fli_matTextFieldFocusLost
        this.setFiliere_matiere(fli_matTextField.getText());
    }//GEN-LAST:event_fli_matTextFieldFocusLost

    private void confirmerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmerButtonActionPerformed

        age = (Integer) jSpinner1.getValue();

        if (this.getPassword1().equals(this.getPassword2())) {
            this.setPassword(this.getPassword1());
        }
        if (nom != null && prenom != null && password != null && CIN_CNE != null) {
            if (type == 0) {
                fli_matTextField.setEnabled(false);
                

                Adherent adherent = new Adherent(CIN_CNE, nom, prenom, age, password, 0);
                try {
                    if (biblio.getAdherent(CIN_CNE) == null && biblio.getEtudiant(CIN_CNE) == null && biblio.getProfesseur(CIN_CNE) == null) {
                        biblio.AddAdherent(adherent);
                        
                        frame.dispose();
                      
                        ConnectionWindow a = new ConnectionWindow(biblio);
                        
                    } else if (biblio.getAdherent(CIN_CNE) != null || biblio.getEtudiant(CIN_CNE) != null || biblio.getProfesseur(CIN_CNE) != null) {
                        Exsitant win = new Exsitant("Adhérent");
                        win.setVisible(true);
                    }
                } catch (SQLException ex) {
                    
                }

            } else if (filiere_matiere != null) {
                if (type == 1) {
                    Etudiant etudiant = new Etudiant(CIN_CNE, nom, prenom, age, password, filiere_matiere, 0);
                    fli_matTextField.setEnabled(true);
                    try {
                        if (biblio.getAdherent(CIN_CNE) == null && biblio.getEtudiant(CIN_CNE) == null && biblio.getProfesseur(CIN_CNE) == null) {
                            biblio.AjouterEtudiant(etudiant);
                            
                            frame.dispose();
                      
                            ConnectionWindow a = new ConnectionWindow(biblio);
                            
                        frame.setContentPane(a);
                        
                        } else if (biblio.getAdherent(CIN_CNE) != null || biblio.getEtudiant(CIN_CNE) != null || biblio.getProfesseur(CIN_CNE) != null) {
                            Exsitant win = new Exsitant("Etudiant");
                            win.setVisible(true);
                        }
                    } catch (SQLException ex) {
                        
                    }

                } else if (type == 2) {
                    Professeur professeur = new Professeur(CIN_CNE, nom, prenom, age, password, filiere_matiere, 0);
                    fli_matTextField.setEnabled(true);
                    try {
                        if (biblio.getAdherent(CIN_CNE) == null && biblio.getEtudiant(CIN_CNE) == null && biblio.getProfesseur(CIN_CNE) == null) {
                            biblio.AjouterProfesseur(professeur);
                            
                            frame.dispose();
                      
                            ConnectionWindow a = new ConnectionWindow(biblio);
                        
                        } else if (biblio.getAdherent(CIN_CNE) != null || biblio.getEtudiant(CIN_CNE) != null || biblio.getProfesseur(CIN_CNE) != null) {
                            Exsitant win = new Exsitant("Professeur");
                            win.setVisible(true);
                        }

                    } catch (SQLException ex) {
                        
                    }

                }
            }
        }
    }//GEN-LAST:event_confirmerButtonActionPerformed

    private void annulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerButtonActionPerformed
        
        frame.removeAll();
        frame.dispose();
        
        frame = (new ConnectionWindow(biblio));
//        frame.pack();
        
    }//GEN-LAST:event_annulerButtonActionPerformed

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        this.setType(jComboBox1.getSelectedIndex());
        if (jComboBox1.getSelectedIndex() == 0) {
            fli_matTextField.setEnabled(false);
        } else if (jComboBox1.getSelectedIndex() == 1) {
            fli_matTextField.setEnabled(true);
        } else if (jComboBox1.getSelectedIndex() == 2) {
            fli_matTextField.setEnabled(true);
        } 
    }//GEN-LAST:event_jComboBox1FocusLost

    private void nomTextField_FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomTextField_FocusLost
        this.setNom(nomTextField_.getText());
        if (jComboBox1.getSelectedIndex() == 0) {
            fli_matTextField.setEnabled(false);
        } else if (jComboBox1.getSelectedIndex() == 1) {
            fli_matTextField.setEnabled(true);
        } else if (jComboBox1.getSelectedIndex() == 2) {
            fli_matTextField.setEnabled(true);
        } 
    }//GEN-LAST:event_nomTextField_FocusLost

    private void cin_cneTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cin_cneTextFieldFocusLost
        this.setCIN_CNE(cin_cneTextField.getText());
        if (jComboBox1.getSelectedIndex() == 0) {
            fli_matTextField.setEnabled(false);
        } else if (jComboBox1.getSelectedIndex() == 1) {
            fli_matTextField.setEnabled(true);
        } else if (jComboBox1.getSelectedIndex() == 2) {
            fli_matTextField.setEnabled(true);
        } 
    }//GEN-LAST:event_cin_cneTextFieldFocusLost

    private void prenomTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prenomTextFieldFocusLost
        this.setPernom(prenomTextField.getText());
        if (jComboBox1.getSelectedIndex() == 0) {
            fli_matTextField.setEnabled(false);
        } else if (jComboBox1.getSelectedIndex() == 1) {
            fli_matTextField.setEnabled(true);
        } else if (jComboBox1.getSelectedIndex() == 2) {
            fli_matTextField.setEnabled(true);
        } 
    }//GEN-LAST:event_prenomTextFieldFocusLost

    private void fli_matTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fli_matTextFieldFocusGained
        if (jComboBox1.getSelectedIndex() == 0) {
            fli_matTextField.setEnabled(false);
        } else if (jComboBox1.getSelectedIndex() == 1) {
            fli_matTextField.setEnabled(true);
        } else if (jComboBox1.getSelectedIndex() == 2) {
            fli_matTextField.setEnabled(true);
        } 
    }//GEN-LAST:event_fli_matTextFieldFocusGained

    private void fli_matTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fli_matTextFieldPropertyChange
if (jComboBox1.getSelectedIndex() == 0) {
            fli_matTextField.setEnabled(false);
        } else if (jComboBox1.getSelectedIndex() == 1) {
            fli_matTextField.setEnabled(true);
        } else if (jComboBox1.getSelectedIndex() == 2) {
            fli_matTextField.setEnabled(true);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_fli_matTextFieldPropertyChange

    private void fli_matTextFieldVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_fli_matTextFieldVetoableChange
       if (jComboBox1.getSelectedIndex() == 0) {
            fli_matTextField.setEnabled(false);
        } else if (jComboBox1.getSelectedIndex() == 1) {
            fli_matTextField.setEnabled(true);
        } else if (jComboBox1.getSelectedIndex() == 2) {
            fli_matTextField.setEnabled(true);
        }  // TODO add your handling code here:
    }//GEN-LAST:event_fli_matTextFieldVetoableChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annulerButton;
    private javax.swing.JTextField cin_cneTextField;
    private javax.swing.JButton confirmerButton;
    private javax.swing.JTextField fli_matTextField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField nomTextField_;
    private javax.swing.JTextField prenomTextField;
    // End of variables declaration//GEN-END:variables
}
