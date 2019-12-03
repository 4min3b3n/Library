
package Vues;

import Article.*;
import Database.*;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

public class ArticlePanel extends javax.swing.JPanel {

    Database database;
    Connection connection;
    DefaultTableModel model = new DefaultTableModel();
    javax.swing.JFrame frame;
    
    private int selectedRow;
    private final String username;

    private String selectedValue;

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }
    
    
    public ArticlePanel(Database database, javax.swing.JFrame frame, String username) throws SQLException {
        
        initComponents();
        
        this.frame = frame;
        this.username = username;
        this.database = database;
        
        model.addColumn("ISBN");
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Editor");
        model.addColumn("Edition");
        model.addColumn("Number of copies");
        
        model.setDataVector(new Object [][] {}, new String [] {"ISBN", "Title", "Author", "Editor", "Edition", "Number of copies"});
    
        AllArti.setModel(model);
        
        ArrayList<Article> books = new ArrayList<>();
        
        books = database.getAllBooks();
        
        
        for(Article iArti: books) {
            if (iArti.getISBN() != null && iArti.getTitre() != null && iArti.getAuteur() != null && iArti.getEditeur() != null) {
                model.addRow(new Object[]{iArti.getISBN(), iArti.getTitre(), iArti.getAuteur(), iArti.getEditeur(), iArti.getEdition(), iArti.getNombreExemplaires()});           
            }   
        }
        
        
    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        AllArti = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        AllArti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        AllArti.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AllArtiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                AllArtiFocusLost(evt);
            }
        });
        AllArti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AllArtiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AllArti);

        jLabel1.setText("List of all articles available:");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Noteworthy", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Library");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrow");
        jButton2.setToolTipText("Borrow the selected article.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        MainPanel mainPanel = null;
        
        try {
            
            mainPanel = new MainPanel(database, frame);
            
            mainPanel.setUsername(username);
        
            frame.setContentPane(mainPanel);
            frame.pack();
            frame.setVisible(true);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(ArticlePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            if(database.Borrow(selectedValue, username)) {
                Message emprunte = new Message("Validation", "        Emprunt a été effectue avec success");
                this.repaint();
                this.revalidate();
                emprunte.setVisible(true);
            } else {
                Message emprunte = new Message("Erreur", "          Emprunt n'a pas été effectue avec success");
                emprunte.setVisible(true);
            }
            
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(ArticlePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AllArtiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllArtiMouseClicked
        selectedRow = AllArti.getSelectedRow();
        selectedValue = (String) model.getValueAt(selectedRow, 0);
    }//GEN-LAST:event_AllArtiMouseClicked

    private void AllArtiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AllArtiFocusLost
        selectedRow = AllArti.getSelectedRow();
        selectedValue = (String) model.getValueAt(selectedRow, 0);
    }//GEN-LAST:event_AllArtiFocusLost

    private void AllArtiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AllArtiFocusGained
        selectedRow = AllArti.getSelectedRow();
        selectedValue = (String) model.getValueAt(selectedRow, 0);
    }//GEN-LAST:event_AllArtiFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AllArti;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
