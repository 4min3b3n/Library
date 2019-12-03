package Personne;

import java.util.Scanner;

public class Professeur extends Personne {
    
    private String CIN;
    private String matiere;
    
    public Professeur() {
        super();
        super.setNombreEmprunteMax(5);
        this.CIN = "";
        this.matiere = "";
    }
    
    public Professeur(String CIN, String nom, String prenom, int age, String password, String matiere, int nombreEmprunte) {
        super(nom, prenom, age, password, nombreEmprunte);
        super.setNombreEmprunteMax(5);
        this.CIN = CIN;
        this.matiere = matiere;
    }

    public int getNombreEmprunteMax() {
        return nombreEmprunteMax;
    }

    public void setNombreEmprunteMax(int nombreEmprunteMax) {
        this.nombreEmprunteMax = nombreEmprunteMax;
    }
    

    public String getCIN() {
        return CIN;
    }
       
    public String setCIN(String CIN) {
        return this.CIN = CIN;
    }
        
    public String getMatiere() {
        return matiere;
    }
    
    public String setMatiere(String matiere) {
        return this.matiere = matiere;
    }
    
    @Override
    public String toString() {
        return "Professeur\n" + 
               "CIN:    " + getCIN() + "\n" +
               "Nom:    " + super.getFirstName() + "\n" + 
               "Prénom: " + super.getPrenom() + "\n" + 
               "Age:    " + super.getAge() + "\n" + 
               "Matiére: " + getMatiere() + "\n" +
               "Nombre d'empruntes: " + super.getNombreEmprunte() + "/" + super.getNombreEmprunteMax() + "\n";
    }
        

}
