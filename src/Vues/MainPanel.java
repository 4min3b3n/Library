package Vues;

import Database.*;
import Emprunt.*;

import javax.swing.*;
import javax.swing.table.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainPanel extends javax.swing.JPanel {
    
    Database database;
    
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    javax.swing.JFrame frame;
    
    String ISBN = new String();
    String titre = new String();
    
    int nubEmp;
    
    DefaultTableModel model = new DefaultTableModel();
    
    public MainPanel(Database database, javax.swing.JFrame frame) throws SQLException, ParseException {
        
        initComponents();
        
        this.database = database;
        this.frame = frame;
        
        System.out.println("Main");
        
        model.addColumn("ISBN");
        model.addColumn("Title");
        model.addColumn("Date d'emprunt");
        model.addColumn("Date de retour");
        
        model.setDataVector(new Object [][] {}, new String [] {"ISBN", "Titre", "Date d'emprunt", "Date de retour"});
        
        String ISBN = new String();
        String dateRetour = new String();
        String dateEmprunt = new String();

        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        ArrayList<Emprunt> listeEmprunt = database.getAllEmprunt((String) username);
        
        try {
         
            for(Emprunt iEmp: listeEmprunt) {
                            
                ISBN = iEmp.getISBN();
                dateEmprunt = dateFormat.format(iEmp.getDateEmprunt());

                if (iEmp.getRendu().equals("NON")) {
                    dateRetour = "0000-00-00";
                } else {
                    dateRetour = dateFormat.format(iEmp.getDateRetour());
                }
                    
                    
        ///        model.addRow(new Object[]{ISBN, database.getArticleByISBN(ISBN).getTitre(), dateEmprunt, dateRetour});
                       
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MesEmprunts.setModel(model);
        
    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RendreButton = new javax.swing.JButton();
        ChangePassword = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        DeconnecterButton = new javax.swing.JButton();
        DesabonnerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        MenuLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ArticlesButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        MesEmprunts = new javax.swing.JTable();

        RendreButton.setText("Return");
        RendreButton.setToolTipText("Return an article back");
        RendreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RendreButtonActionPerformed(evt);
            }
        });

        ChangePassword.setText("Change Password");
        ChangePassword.setToolTipText("Change your password");
        ChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePasswordActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.setToolTipText("Search for articles by ISBN, Title or Author ");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        DeconnecterButton.setText("Log out");
        DeconnecterButton.setToolTipText("Disconnect from tha application");
        DeconnecterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeconnecterButtonActionPerformed(evt);
            }
        });

        DesabonnerButton.setBackground(new java.awt.Color(255, 204, 204));
        DesabonnerButton.setForeground(new java.awt.Color(255, 51, 51));
        DesabonnerButton.setText("Unsubscribe");
        DesabonnerButton.setToolTipText("Your account will be removed compelety.");
        DesabonnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesabonnerButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("My Loans");
        jLabel1.setToolTipText("The history of all your loans.");

        MenuLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        MenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuLabel.setText("Menu");

        jLabel2.setFont(new java.awt.Font("Noteworthy", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Library");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ArticlesButton.setText("Articles");
        ArticlesButton.setToolTipText("List of all the articles available.");
        ArticlesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArticlesButtonActionPerformed(evt);
            }
        });

        MesEmprunts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MesEmprunts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MesEmprunts.setFocusTraversalKeysEnabled(false);
        MesEmprunts.setFocusable(false);
        MesEmprunts.setRequestFocusEnabled(false);
        MesEmprunts.setShowHorizontalLines(false);
        MesEmprunts.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MesEmpruntsMouseMoved(evt);
            }
        });
        MesEmprunts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MesEmpruntsMouseClicked(evt);
            }
        });
        MesEmprunts.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                MesEmpruntsPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(MesEmprunts);
        if (MesEmprunts.getColumnModel().getColumnCount() > 0) {
            MesEmprunts.getColumnModel().getColumn(0).setResizable(false);
            MesEmprunts.getColumnModel().getColumn(1).setResizable(false);
            MesEmprunts.getColumnModel().getColumn(2).setResizable(false);
            MesEmprunts.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DesabonnerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RendreButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DeconnecterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ArticlesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(MenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ArticlesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RendreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeconnecterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DesabonnerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RendreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RendreButtonActionPerformed
        
        RendreWindow rendreWindow;
        try {
            rendreWindow = new RendreWindow(database, username);
            rendreWindow.setVisible(true);
            rendreWindow.setAlwaysOnTop(true);
        } catch (SQLException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_RendreButtonActionPerformed

    private void ChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePasswordActionPerformed
 
        PasswordWindow passwordWindow = new PasswordWindow(database, username);
        passwordWindow.setVisible(true);
        passwordWindow.setAlwaysOnTop(true);
    }//GEN-LAST:event_ChangePasswordActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        
        ChercherWindow chercherWindow = new ChercherWindow(database, username);
        chercherWindow.setVisible(true);
        chercherWindow.setAlwaysOnTop(true);
        
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void DeconnecterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeconnecterButtonActionPerformed
        
        ConnectionWindow newconnection = new ConnectionWindow(database);
        newconnection.setVisible(true);
        
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();

    }//GEN-LAST:event_DeconnecterButtonActionPerformed

    private void DesabonnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesabonnerButtonActionPerformed

        try {
            database.RemoveAdherent(username);
  //          database.SupprimerEtudiant(username);
//            database.SupprimerProfesseur(username);
        } catch (SQLException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        DesabonnerWindow desabonnerWindow = new DesabonnerWindow();
        desabonnerWindow.setVisible(true);
        
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
        
    }//GEN-LAST:event_DesabonnerButtonActionPerformed

    private void ArticlesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArticlesButtonActionPerformed

        ArticlePanel artPane = null;
        try {
            artPane = new ArticlePanel(database, frame, username);
        } catch (SQLException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        frame.setContentPane(artPane);
        frame.pack();
        frame.setVisible(true);  
        
    }//GEN-LAST:event_ArticlesButtonActionPerformed

    private void MesEmpruntsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_MesEmpruntsPropertyChange
   
       
        model.setDataVector(new Object [][] {}, new String [] {"ISBN", "Titre", "Date d'emprunt", "Date de retour"});
        
        String ISBN_ = new String();
        String dateRetour = new String();
        String dateEmprunt = new String();

        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
         
            for(Emprunt iEmp: database.getAllEmprunt((String) username)) {
                
                ISBN_ = ""; dateEmprunt= ""; dateRetour="";

                if (iEmp.getCodePersonne().equals(username)) {
                    
                    ISBN_ = iEmp.getISBN();
    
                    dateEmprunt = dateFormat.format(iEmp.getDateEmprunt());

                    if (iEmp.getRendu().equals("NON")) {
                        dateRetour = "0000-00-00";
                    } else {
                        dateRetour = dateFormat.format(iEmp.getDateRetour());
                    }
                    
                    
//                    model.addRow(new Object[]{ISBN_, database.getArticleByISBN(ISBN_).getTitre(), dateEmprunt, dateRetour});
                    
                }
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }//GEN-LAST:event_MesEmpruntsPropertyChange

    private void MesEmpruntsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MesEmpruntsMouseClicked
       
    }//GEN-LAST:event_MesEmpruntsMouseClicked

    private void MesEmpruntsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MesEmpruntsMouseMoved

        model.setDataVector(new Object [][] {}, new String [] {"ISBN", "Titre", "Date d'emprunt", "Date de retour"});
        
        String ISBN_ = new String();
        String dateRetour = new String();
        String dateEmprunt = new String();

        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
         
            for (Emprunt iEmp : database.getAllEmprunt()) {
                ISBN_ = "";
                dateEmprunt= "";
                dateRetour="";
                if (iEmp.getCodePersonne().equals(username)) {
                    
                    ISBN_ = iEmp.getISBN();
    
                    dateEmprunt = dateFormat.format(iEmp.getDateEmprunt());

                    if (iEmp.getRendu().equals("NON")) {
                        dateRetour = "0000-00-00";
                    } else {
                        dateRetour = dateFormat.format(iEmp.getDateRetour());
                    }
                    
                    
                //    model.addRow(new Object[]{ISBN_, database.getArticleByISBN(ISBN_).getTitre(), dateEmprunt, dateRetour});
                    
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MesEmpruntsMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArticlesButton;
    private javax.swing.JButton ChangePassword;
    private javax.swing.JButton DeconnecterButton;
    private javax.swing.JButton DesabonnerButton;
    private javax.swing.JLabel MenuLabel;
    private javax.swing.JTable MesEmprunts;
    private javax.swing.JButton RendreButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
