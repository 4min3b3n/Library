package Personne;

public class Etudiant extends Personne {
    
    String CNE;
    private String filiere;
    
    public Etudiant() {
        super();
        super.setNombreEmprunteMax(3);
        this.CNE = "";
        this.filiere = "";
    }
    
    public Etudiant(String CNE, String nom, String prenom, int age, String password, String filiere, int nombreEmprunte) {
        super(nom, prenom, age, password, nombreEmprunte);
        this.CNE = CNE;
        this.filiere = filiere;
        super.setNombreEmprunteMax(3);
    }
    
    public String getCNE() {
        return CNE;
    }
    
    public String getFiliere() {
        return filiere;
    }

    public int getNombreEmprunteMax() {
        return nombreEmprunteMax;
    }

    public void setNombreEmprunteMax(int nombreEmprunteMax) {
        this.nombreEmprunteMax = nombreEmprunteMax;
    }
    
    
}
