package Article;

import java.util.ArrayList;
import java.util.Scanner;

public class Book extends Article {
    
    private int nombrePages;
    private int nombreTome;
    private String type;
    
    public Book() {
        super();
        this.nombrePages = 0;
        this.nombreTome = 0;
        this.type = new String();
    }
    
    public Book(String ISBN, String titre, String auteur, String editeur, int edition, int nombreExemplaires, int nombrePages, int nombreTome, String type) {
        super(ISBN, titre, auteur, editeur, edition, nombreExemplaires);
        this.nombrePages = nombrePages;
        this.nombreTome = nombreTome;
        this.type = type;
    }
    
    public int nombreTome() {
        return nombreTome;
    }
    
    
    public int getPages() {
        return nombrePages;
    }
    
    public String getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "Livre\n" + super.toString() + 
                "Nombre de pages: " + nombrePages + "\n" +
                "Nombre de tome: " + nombreTome + "\n" + 
                "Type: " + type + "\n";
    }
    
    @Override
    public void Inserer() {
        super.Inserer();
        Scanner insererScanner = new Scanner(System.in);
        System.out.println("Donner le nombre de pages:   ");
        this.nombrePages = insererScanner.nextInt();
        System.out.println("Donner le nombre de tomes:   ");
        this.nombreTome = insererScanner.nextInt();
        System.out.println("Donner le type:              ");
        this.type = insererScanner.nextLine();
        this.type = insererScanner.nextLine();
    }
    
}
