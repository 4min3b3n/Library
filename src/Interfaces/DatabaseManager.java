package Interfaces;

import Article.*;
import Emprunt.*;
import Personne.*;

import java.util.ArrayList;

import java.text.ParseException;
import java.sql.SQLException;

public interface DatabaseManager {
    
    public boolean Return(String ISBN, String codePersonne) throws SQLException;
    
    public boolean Borrow(String ISBN, String codePersonne) throws SQLException, ParseException;
    
    public boolean VerifPassword(String username, String oldPassword) throws SQLException;
    
    public boolean ChangePassword(String username, String newPassword) throws SQLException;
    
    public boolean Authentification(String username, String password);
    
    public Adherent getAdherent(String CIN) throws SQLException;
    
    public ArrayList<Personne> getAllAdherent() throws SQLException;
     
    public void AddAdherent(Adherent adherent) throws SQLException ;
    
    public void RemoveAdherent(String CIN) throws SQLException;
    
    public void AddBook(Book book) throws SQLException;
    
    public Book getBook(String ISBN) throws SQLException;
    
    public Book getBookByTitle(String title) throws SQLException;
    
    public Book getBookByAuthor(String author) throws SQLException ;
    
    public ArrayList<Article> getAllBooks() throws SQLException;
    
    
    
    public int getNombreEmpruntAdherent(String CIN) throws SQLException;
    
    public void RemoveBook(String ISBN) throws SQLException;
    
    
    
    public void NouveauEmprunt(String ISBN, String codePersonne) throws SQLException ;
    
    public void SupprimerEmprunt(int numEmprunt) throws SQLException ;
    
    
    public void nombreExemplaireMinus(String ISBN) throws SQLException;
    
    public void nombreExemplairePlus(String ISBN) throws SQLException;
    
    
    public void nombreEmpruntMinus(String CIN_CNE)  throws SQLException;
    
    public void nombreEmpruntPlus(String CIN_CNE)  throws SQLException;
    
    
    public Emprunt getEmprunt(String codePersonne) throws SQLException, ParseException;
    
    public Emprunt getEmpruntNonRendu(String codePersonne) throws SQLException, ParseException;
    
    public ArrayList<Emprunt> getAllEmprunt() throws SQLException, ParseException;
    public ArrayList<Emprunt> getAllEmprunt(String codePersonne) throws SQLException, ParseException;
    public ArrayList<Emprunt> getAllEmpruntNonRendu(String codePersonne) throws SQLException, ParseException;
    
    

    
    
    
    
    

    
    
}
