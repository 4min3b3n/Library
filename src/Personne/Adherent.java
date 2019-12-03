package Personne;


public class Adherent extends Personne {
    private String CIN;
        
    public Adherent() {
        super();
        this.CIN = "";
        super.setNombreEmprunteMax(1);
    }
    
    public Adherent(String CIN, String firstName, String lastName, int age, String password, int nombreEmprunte) {
        
        super(firstName, lastName, age, password, nombreEmprunte);
        super.setNombreEmprunteMax(1);
        
        this.CIN = CIN; 
    
    }

    
    public String getCIN() {
        return CIN;
    }

    @Override
    public int getNombreEmprunteMax() {
        return nombreEmprunteMax;
    }

    @Override
    public void setNombreEmprunteMax(int nombreEmprunteMax) {
        this.nombreEmprunteMax = nombreEmprunteMax;
    }


}
