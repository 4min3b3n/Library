package Emprunt;

import java.util.Date;

import Interfaces.*;

public class Emprunt implements GestionEmp {
    
    private String ISBN;                    
    
    private int numEmprunt;
    
    private Date dateEmprunt;             
    private Date dateRetour;
    
    private String rendu;
    private String codePersonne;

    
    public Emprunt(String ISBN, Date dateEmprunt, Date dateRetour, String rendu, String codePersonne, int numEmprunt) {
        this.ISBN = ISBN;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.rendu = rendu;
        this.codePersonne = codePersonne;
        this.numEmprunt = numEmprunt;

    }

    public int getNumEmprunt() {
        return numEmprunt;
    }

    public void setNumEmprunt(int numEmprunt) {
        this.numEmprunt = numEmprunt;
    }
    
    public String getISBN() {
        return ISBN;
    }
    
    public String getRendu() {
        return rendu;
    }
    
    public String getCodePersonne() {
        return codePersonne;
    }
    
    public Date getDateEmprunt() {
        return dateEmprunt;
    }
    
    public Date getDateRetour() {
        return dateRetour;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }
    
    public void setDaterRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }
    
    public void setRendu(String typePersonne) {
        this.rendu = typePersonne;
    }
    
    public void setCodePersonne(String codePersonne) {
        this.codePersonne = codePersonne;
    }
    
    @Override
    public String toString() {
        return  "Emprunt n°: " + "\n" + 
                "  ISBN: " + ISBN + "\n" + 
                "  Date d'emprunt: " + dateEmprunt + "\n" + 
                "  Date de retour: " + dateRetour + "\n" + 
                "  CIN: " + codePersonne;
    }
    
}

