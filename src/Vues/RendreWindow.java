/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import javax.swing.table.*;

import Database.*;
import Emprunt.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RendreWindow extends javax.swing.JFrame {

    Database biblioDB;
    
    int selectedRow;
    
    String username = new String();
    
    String titre = new String();
    
    
    DefaultTableModel model = new DefaultTableModel();
    
    public RendreWindow(Database biblioDB, String username) throws SQLException, ParseException {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.biblioDB = biblioDB;
        this.username = username;
        
        model.addColumn("ISBN");
        model.addColumn("Titre");
        model.addColumn("Date d'emprunt");
        
        EmpruntTable.setModel(model);


        String ISBN_ = new String();
        String dateEmprunt = new String();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        for(Emprunt iEmp: biblioDB.getAllEmpruntNonRendu(username)) {
            

                    dateEmprunt = dateFormat.format(iEmp.getDateEmprunt());

                    ISBN_ = iEmp.getISBN();
                    String titre = biblioDB.getArticleByISBN(ISBN_).getTitre();
                    
                    model.addRow(new Object[]{ISBN_, titre, dateEmprunt});
                    
                    ISBN_ = "";
                    titre = "";
               
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        EmpruntTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        RendreButton = new javax.swing.JButton();
        AnnulerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EmpruntTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        EmpruntTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmpruntTableFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(EmpruntTable);

        jLabel1.setText("                             Rendre un article");

        RendreButton.setText("Rendre");
        RendreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RendreButtonActionPerformed(evt);
            }
        });

        AnnulerButton.setText("Annuler");
        AnnulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AnnulerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RendreButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnnulerButton)
                    .addComponent(RendreButton))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmpruntTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpruntTableFocusLost
        selectedRow = EmpruntTable.getSelectedRow();;
    }//GEN-LAST:event_EmpruntTableFocusLost

    private void RendreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RendreButtonActionPerformed
        String selectedValue = (String) model.getValueAt(selectedRow, 0);
 
        try {
            biblioDB.Return(selectedValue, username);
            model.removeRow(selectedRow);
        } catch (SQLException ex) {
            Logger.getLogger(RendreWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_RendreButtonActionPerformed

    private void AnnulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_AnnulerButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnnulerButton;
    private javax.swing.JTable EmpruntTable;
    private javax.swing.JButton RendreButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
