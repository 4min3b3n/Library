package Vues;

import Database.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChercherWindow extends javax.swing.JFrame {
    
    Database database;

    private int type = 0;
    
    private String ISBN_Titre_Auteur = new String();
    private String username = new String();
    
    public ChercherWindow(Database biblioDB, String username) {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.username = username;
        this.database = biblioDB;
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        rechercheTextArea1.setEditable(false);
 
    }

    public int getType_() {
        return type;
    }

    public void setType_(int type) {
        this.type = type;
    }

    public String getISBN_Titre_Auteur() {
        return ISBN_Titre_Auteur;
    }

    public void setISBN_Titre_Auteur(String ISBN_Titre_Auteur) {
        this.ISBN_Titre_Auteur = ISBN_Titre_Auteur;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        chercherTextFiled = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        chercherButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        EmprunterButton = new javax.swing.JButton();
        AnnulerButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        rechercheTextArea1 = new javax.swing.JTextArea();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISBN", "Titre", "Auteur" }));
        typeComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                typeComboBoxFocusLost(evt);
            }
        });

        chercherTextFiled.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                chercherTextFiledFocusLost(evt);
            }
        });

        chercherButton.setText("Chercher");
        chercherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chercherButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("                    Chercher un article par");

        EmprunterButton.setText("Emprunter");
        EmprunterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmprunterButtonActionPerformed(evt);
            }
        });

        AnnulerButton.setText("Annuler");
        AnnulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerButtonActionPerformed(evt);
            }
        });

        rechercheTextArea1.setEditable(false);
        rechercheTextArea1.setColumns(20);
        rechercheTextArea1.setRows(5);
        jScrollPane2.setViewportView(rechercheTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(chercherTextFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chercherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AnnulerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EmprunterButton)
                        .addGap(49, 49, 49))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(chercherTextFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(chercherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmprunterButton)
                    .addComponent(AnnulerButton))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmprunterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmprunterButtonActionPerformed
        
        try {
            if (database.getBookByTitle(ISBN_Titre_Auteur) != null) {
                this.setISBN_Titre_Auteur(database.getBook(ISBN_Titre_Auteur).getISBN());
            } 
        
        } catch (SQLException ex) {
            Logger.getLogger(ChercherWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            if (database.Borrow(ISBN_Titre_Auteur, username)) {
                
                Message emprunte = new Message("Validation", "        Emprunt a été effectue avec success");
                emprunte.setVisible(true);
                
            } else {
                
                Message emprunte = new Message("Erreur", "          Emprunt n'a pas été effectue avec success");
                emprunte.setVisible(true);
                
            }
            
        } catch (SQLException | ParseException ex) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_EmprunterButtonActionPerformed

    private void typeComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_typeComboBoxFocusLost
        this.setType_(typeComboBox.getSelectedIndex());
        this.setISBN_Titre_Auteur(chercherTextFiled.getText());
    }//GEN-LAST:event_typeComboBoxFocusLost

    private void chercherTextFiledFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chercherTextFiledFocusLost
        this.setISBN_Titre_Auteur(chercherTextFiled.getText());
    }//GEN-LAST:event_chercherTextFiledFocusLost

    private void AnnulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_AnnulerButtonActionPerformed

    private void chercherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chercherButtonActionPerformed
        this.setISBN_Titre_Auteur(chercherTextFiled.getText());
        if (this.getType_() == 0) {
            try {
                if (database.getBook(ISBN_Titre_Auteur) != null) {
                    rechercheTextArea1.setText(database.getBook(ISBN_Titre_Auteur).toString());
                } else {
                    Introvable errorWindow = new Introvable("ISBN saisi ");
                    errorWindow.setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChercherWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (this.getType_() == 1) {
            
            try {
                
                if (database.getBookByTitle(ISBN_Titre_Auteur) != null) {
                    rechercheTextArea1.setText(database.getBookByTitle(ISBN_Titre_Auteur).toString());
                    
                } else {
                    Introvable errorWindow = new Introvable("Titre saisi ");
                    errorWindow.setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChercherWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (this.getType_() == 2) {
            
            try { 
                
                if (database.getBookByAuthor(ISBN_Titre_Auteur) != null) {
                    
                    rechercheTextArea1.setText(database.getBookByAuthor(ISBN_Titre_Auteur).toString());
                } else {
                    Introvable errorWindow = new Introvable("Auteur saisi ");
                    errorWindow.setVisible(true);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ChercherWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_chercherButtonActionPerformed

    
    private javax.swing.JButton AnnulerButton;
    private javax.swing.JButton EmprunterButton;
    private javax.swing.JButton chercherButton;
    private javax.swing.JTextField chercherTextFiled;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea rechercheTextArea1;
    private javax.swing.JComboBox<String> typeComboBox;

}
