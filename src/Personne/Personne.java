package Personne;



public abstract class Personne {
    
    private String firstName;
    private String lastName;
    private int age;
    private String password;
    private int nombreEmprunte;
    int nombreEmprunteMax;
    
    public Personne() {
        
        this.firstName = new String();
        this.lastName = new String();
        this.age = 0;
        this.nombreEmprunte = 0;
        this.password = new String();
        
    }
    
    public Personne(String firstName, String lastName, int age, String password, int nombreEmprunte) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nombreEmprunte = nombreEmprunte;
        this.password = password;
        
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getPrenom() {
        return lastName;
    }
    
    public int getAge() {
        return age;
    }

    public int getNombreEmprunte() {
        return nombreEmprunte;
    }

    public void setNombreEmprunte(int nombreEmprunte) {
        this.nombreEmprunte = nombreEmprunte;
    }

    public int getNombreEmprunteMax() {
        return nombreEmprunteMax;
    }
    
    public void setNombreEmprunteMax(int nombreEmprunteMax) {
        this.nombreEmprunteMax = nombreEmprunteMax;
    }
    
    public String getPassword() {
        return password;
    }
       
    public void setPassword(String password) {
        this.password = password;
    }
    
}
