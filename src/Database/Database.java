package Database;

import Vues.ConnectionWindow;
import Vues.Introvable;

import Article.*;
import Personne.*;
import Emprunt.*;

import Interfaces.*;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database implements DatabaseManager {
                                                                                            
    protected String username = "amine"; 
    protected String password = "3500";
    protected String server = "localhost";
    protected String port = "3308";
    protected String database = "Library";
    
    Connection connection;
    
    public Database() throws SQLException {
        
        try {
            connection = Connection();
            if (connection == null) {
                System.out.println("Unable to connect to the database.");
            } else
                System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database.");
        }
    }
    
    public Connection Connection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return this.connection = DriverManager.getConnection("jdbc:mysql://"+this.server+":"+this.port+"/"+this.database+"", this.username, this.password);
        } catch (ClassNotFoundException ex) {
           return null;
        } 
    }

    @Override
    public boolean Return(String ISBN, String ID) throws SQLException {
        
        Statement statement = connection.createStatement();
        
        String request = "SELECT * FROM Emprunt WHERE ISBN = '" + ISBN +"' AND codePersonne = '"+ID+"' AND Rendu = 'NO';";
        
        ResultSet result = statement.executeQuery(request);
        
        Date returnDate = new Date();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        if(result.next()) {
            
            this.nombreExemplairePlus(ISBN);
            this.nombreEmpruntMinus(ID);
            
            String rendreRequest = "UPDATE `Emprunt` SET `Returned`= 'YES', `dateRetour`= '" + dateFormat.format(returnDate) + "' WHERE `ISBN`= '"+ISBN+"'AND `codePersonne`='"+ID+"';";
            
            statement.executeUpdate(rendreRequest);

            return true;
        }
        return false;
    }
    
    @Override
    public boolean Borrow(String ISBN, String ID) throws SQLException, ParseException {
        
        int nombreEmprunt = -1;
        
        ArrayList<Emprunt> listeEmpruntnonrendu = this.getAllEmpruntNonRendu(ID);
        
        if (!listeEmpruntnonrendu.stream().noneMatch((iEmp) -> (iEmp.getISBN().equals(ISBN) && iEmp.getCodePersonne().equals(ID)))) {
            return false;
        }

        
        if (this.getAdherent(ID) != null) {
            
            nombreEmprunt = this.getAdherent(ID).getNombreEmprunte();
            
            if (nombreEmprunt < this.getAdherent(ID).getNombreEmprunteMax()) {
            
                if (this.getBook(ISBN).getNombreExemplaires() > 0) {
                    
                    this.nombreEmpruntPlus(ID);
                    this.nombreExemplaireMinus(ISBN);
                    this.NouveauEmprunt(ISBN, ID);
                    
                    return true;
                }
            }
        }
        
        return false;
    }
    
    @Override
    public boolean VerifPassword(String username, String oldPassword) throws SQLException {
        
        if (this.getAdherent(username) != null) {
            if (this.getAdherent(username).getPassword().equals(oldPassword)){
                return true;
            }
        }
        
        return false;
    }
   
    @Override
    public boolean ChangePassword(String username, String newPassword) throws SQLException {
        
        Statement statement = connection.createStatement();
        
        if (this.getAdherent(username) != null) {
            
            String request = "UPDATE `Adherent` SET `Password` = '"+newPassword+"' WHERE `ID` = '"+username+"';";
            
            statement.executeUpdate(request); 
            
            return true;
        }

        return false;
    }
    
    @Override
    public boolean Authentification(String username, String password) {
        
        try {
        
            if (this.getAdherent(username) != null) {
                
                System.out.println("Adherent is found.");
                if (this.getAdherent(username).getPassword().equals(password)) {
                
                    System.out.println("Password is correct");
                    return true;
                
                } else {
                    
                    System.out.println("Password is incorrect");
                    Introvable errorWindow = new Introvable("Password is  ");
                    errorWindow.setVisible(true);
                
                }
            } else {
                
                System.out.println("Adherent is not found.");
                Introvable errorWindow = new Introvable("Username is ");
                errorWindow.setVisible(true);
            
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    @Override
    public Adherent getAdherent(String ID) throws SQLException {
        
        Statement statement = this.connection.createStatement();
        
        String request = "SELECT * FROM Adherent WHERE ID = '" + ID + "';";
        
        ResultSet result = statement.executeQuery(request);
        
        if (result.next()) {
            
            Adherent adherent = new Adherent(result.getString("ID"), result.getString("FirstName"), result.getString("Prenom"),
                                            result.getInt("Age"), result.getString("Password"), result.getInt("nombreEmprunt")); 
            
            return adherent;
        }
        return null;
    }

    @Override
    public ArrayList<Personne> getAllAdherent() throws SQLException {
        
        ArrayList<Personne> listeAdherent = new ArrayList<>();
        
        Statement statement = connection.createStatement();
        
        String request = "SELECT * FROM Adherent;";
        
        ResultSet result = statement.executeQuery(request);
        
        while(result.next()) {
            
            listeAdherent.add(getAdherent(result.getString("ID")));
        
        }
       
        return listeAdherent;
    }
     
    @Override
    public void AddAdherent(Adherent adherent) throws SQLException {
        Statement statement = connection.createStatement();
        
        String request = "INSERT INTO Adherent (ID, FirstName, LastName, Age, Password, nombreEmprunt) "
                       + "VALUES ('" + adherent.getCIN() + "', " + "'" + adherent.getFirstName() + "', " + "'" + adherent.getPrenom() + "', " + 
                                   "'" + adherent.getAge() + "', '" + adherent.getPassword() + "', '" + adherent.getNombreEmprunte() + "');";
        
        statement.executeUpdate(request);
    }
    
    @Override
    public void RemoveAdherent(String ID) throws SQLException {
        
        Statement statement = connection.createStatement();
        
        String rendreRequest = "SELECT * FROM Emprunt WHERE Returned = 'NO' AND codePersonne = '"+ID+"';";
        
        ResultSet result = statement.executeQuery(rendreRequest); 
        
        while (result.next()) {
            this.Return(result.getString("ISBN"), ID);
        }
        
        String request = "DELETE FROM Adherent WHERE ID = '" + ID + "';";
        
        statement.executeUpdate(request);
        
    }
    
    
    
    @Override
    public void AddBook(Book livre) throws SQLException {
        
        Statement statement = connection.createStatement();
    
        String request = "INSERT INTO Books (ISBN, Titre, Auteur, Editeur, Edition, nombreExemplaire, nombrePages, nombreTome, Type) VALUES " + 
                "('" + livre.getISBN() + "', '" + livre.getTitre() + "', '" + livre.getAuteur() + "', '" + livre.getEditeur() + "', '" + livre.getEdition() + "', '" + livre.getNombreExemplaires() + "', '" + livre.getPages() + "', '" + livre.nombreTome() + "', '" + livre.getType() + "');";
    
        statement.executeUpdate(request);
        
    }
    
    
    
    @Override
    public Book getBook(String ISBN) throws SQLException {
        Statement statement = connection.createStatement();
        String request = "SELECT * FROM Books WHERE ISBN = '" + ISBN + "';";
        ResultSet result = statement.executeQuery(request);

        if (result.next()) {
            Book livre = new Book(result.getString("ISBN"),result.getString("Titre"),result.getString("Auteur"),result.getString("Editeur"),result.getInt("Edition"),result.getInt("nombreExemplaire"),result.getInt("nombrePages"),result.getInt("nombreTome"),result.getString("Type"));
            return livre;
        }
        
        return null;
    }
    
    @Override
    public Book getBookByTitle(String Titre) throws SQLException {
        Statement statement = connection.createStatement();
        
        String request = "SELECT * FROM Books WHERE Titre = '" + Titre + "';";
        
        ResultSet result = statement.executeQuery(request);
        
        if (result.next()) {
            Book livre = new Book(result.getString("ISBN"),result.getString("Titre"),result.getString("Auteur"),result.getString("Editeur"),result.getInt("Edition"),result.getInt("nombreExemplaire"),result.getInt("nombrePages"),result.getInt("nombreTome"),result.getString("Type"));
            return livre;
        }

        return null;
    }
    
    @Override
    public Book getBookByAuthor(String Auteur) throws SQLException {
        Statement statement = connection.createStatement();
        
        String request = "SELECT * FROM Books WHERE Auteur = '" + Auteur + "';";
        
        ResultSet result = statement.executeQuery(request);
        
        if (result.next()) {
            Book livre = new Book(result.getString("ISBN"),result.getString("Titre"),result.getString("Auteur"),result.getString("Editeur"),result.getInt("Edition"),result.getInt("nombreExemplaire"),result.getInt("nombrePages"),result.getInt("nombreTome"),result.getString("Type"));
            return livre;
        }

        return null;
    }
    
    
    
    @Override
    public ArrayList<Article> getAllBooks() throws SQLException {
        
        ArrayList<Article> books = new ArrayList<>();
        
        Statement statement = connection.createStatement();
        
        String request = "SELECT * FROM Books;";
        
        ResultSet result = statement.executeQuery(request);
        
        while (result.next()) {
            books.add(getBook(result.getString("ISBN")));
        }

        return books;
    }
    
    
    public Personne getPersonneByCIN(String ID) throws SQLException {
        if (this.getAdherent(ID) != null) {
            return this.getAdherent(ID);
        }
        
        return null;
    }
    
    
    
    @Override
    public int getNombreEmpruntAdherent(String ID) throws SQLException {
        
        Statement statement = connection.createStatement();
        
        String request = "SELECT * FROM Adherent WHERE ID = '" + ID + "';";
        
        ResultSet numEmp = statement.executeQuery(request);
        
        if (numEmp.next()) {
            return numEmp.getInt("nombreEmprunt");
        }
        
        return -1;
    }

    @Override
    public void RemoveBook(String ISBN) throws SQLException {
        Statement statement = connection.createStatement();
        
        String request = "DELETE FROM Book WHERE ISBN = '" + ISBN + "';";
        
        statement.executeUpdate(request);   
    }
    
    

    public void NouveauEmprunt(String ISBN, String codePersonne) throws SQLException {
        Statement statement = connection.createStatement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        int numEmpMax = 0;
        
        String numEmpMaxRequest = "SELECT * FROM Emprunt;";

        ResultSet resultEmpMax = statement.executeQuery(numEmpMaxRequest);
        while(resultEmpMax.next()) {
            numEmpMax = resultEmpMax.getInt("numeroEmprunt");
        }
        System.out.println(numEmpMax);
        
        Date dateEmp = new Date();       
        numEmpMax++;
        
        String request = "INSERT INTO `Emprunt`(`ISBN`, `dateEmprunt`, `Rendu`, `codePersonne`, `numeroEmprunt`) VALUES ('"+ISBN+"', '"+dateFormat.format(dateEmp)+"', 'NON', '"+codePersonne+"','"+ numEmpMax +"');";

        statement.executeUpdate(request);
    }
    
    public void SupprimerEmprunt(int numEmprunt) throws SQLException {
        
        Statement statement = connection.createStatement();
        
        String request = "DELETE FROM Emprunt WHERE numeroEmprunt = '" + numEmprunt + "';";
        
        statement.executeUpdate(request); 
    }
    
    

    public void nombreExemplaireMinus(String ISBN) throws SQLException {
        
        Statement statement = connection.createStatement();
        
        int nombreExemplaire = 0;
        
        if (this.getBook(ISBN) != null) {
            nombreExemplaire = this.getBook(ISBN).getNombreExemplaires();
            String minusRequest = "UPDATE `Books` SET `nombreExemplaire`= '"+(nombreExemplaire-1)+"' WHERE `ISBN`= '"+ISBN+"'";
            statement.executeUpdate(minusRequest);
        } else {
            System.out.println("Error");
        }
        
    }
    
    public void nombreExemplairePlus(String ISBN) throws SQLException {
        
        Statement statement = connection.createStatement();
        
        int nombreExemplaire;
        
        if (this.getBook(ISBN) != null) {
            
            nombreExemplaire = this.getBook(ISBN).getNombreExemplaires();
            
            String request = "UPDATE `Books` SET `nombreExemplaire`= '" + (nombreExemplaire+1) + "' WHERE `ISBN`= '"+ISBN+"';";
            
            statement.executeUpdate(request);
        
        } else {
            
            System.out.println("Error ");
        }
        
    }
    
    
    public void nombreEmpruntMinus(String ID)  throws SQLException {
        
        Statement statement = connection.createStatement();
        
        int nombreEmprunt;
        
        if (this.getAdherent(ID) != null) {
            nombreEmprunt = this.getAdherent(ID).getNombreEmprunte();
            String minusRequest = "UPDATE `Adherent` SET `nombreEmprunt`= '"+(nombreEmprunt-1)+"' WHERE `ID`= '"+ID+"'";
            statement.executeUpdate(minusRequest);
        } else {
            System.out.println("Error");
        }
        
    }
    
    public void nombreEmpruntPlus(String ID) throws SQLException {
        
        Statement statement = connection.createStatement();
        
        int nombreEmprunt;
        
        if (this.getAdherent(ID) != null) {
            nombreEmprunt = this.getAdherent(ID).getNombreEmprunte();
            String minusRequest = "UPDATE `Adherent` SET `nombreEmprunt`= '"+(nombreEmprunt+1)+"' WHERE `ID`= '"+ID+"'";
            statement.executeUpdate(minusRequest);
        } else {
            System.out.println("Error");
        }
        
    }

    
    public Emprunt getEmprunt(String codePersonne) throws SQLException, ParseException {
    
        Statement statement = connection.createStatement();
        
        String request = "SELECT * FROM Emprunt WHERE codePersonne = '" + codePersonne + "';";
        
        ResultSet result = statement.executeQuery(request); 
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        if (result.next()) {
            Date dateEmp = dateFormat.parse(result.getString("dateEmprunt"));
            Date dateRetour = dateFormat.parse(result.getString("dateRetour"));
            Emprunt emprunt = new Emprunt(result.getString("ISBN"),dateEmp,dateRetour,result.getString("Rendu"),result.getString("codePersonne"), result.getInt("numeroEmprunt"));
            emprunt.setNumEmprunt(result.getInt("numeroEmprunt"));
            return emprunt;
        }
        return null;  
    }
    
    public Emprunt getEmpruntNonRendu(String codePersonne) throws SQLException, ParseException {
    
        Statement statement = connection.createStatement();
        
        String request = "SELECT * FROM Emprunt WHERE codePersonne = '" + codePersonne + "';";
        
        ResultSet result = statement.executeQuery(request); 
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        if (result.next()) {
            Date dateEmp = dateFormat.parse(result.getString("dateEmprunt"));
            Date dateRetour = dateFormat.parse(result.getString("dateRetour"));
            Emprunt emprunt = new Emprunt(result.getString("ISBN"),dateEmp,dateRetour,result.getString("Rendu"),result.getString("codePersonne"), result.getInt("numeroEmprunt"));
            emprunt.setNumEmprunt(result.getInt("numeroEmprunt"));
            return emprunt;
        }
        return null;  
    }
    
    
    @Override
    public ArrayList<Emprunt> getAllEmprunt() throws SQLException, ParseException {
        
        ArrayList<Emprunt> listeEmprunt = new ArrayList<>();
        
        Statement statement = connection.createStatement();
        String request = "SELECT * FROM Emprunt;";
        ResultSet result = statement.executeQuery(request);
        
        Date dateEmp, dateRetour;
        
        while(result.next()) {
            
            Emprunt emprunt = null;
            
            dateEmp = new SimpleDateFormat("yyyy-MM-dd").parse(result.getString("dateEmprunt"));
            dateRetour = new SimpleDateFormat("yyyy-MM-dd").parse(result.getString("dateRetour"));
            emprunt = new Emprunt(result.getString("ISBN"),dateEmp,dateRetour,result.getString("Rendu"),result.getString("codePersonne"), result.getInt("numeroEmprunt"));
            listeEmprunt.add(emprunt);
        
        }
        
        return listeEmprunt;
    }
    
    
  
    @Override
    public ArrayList<Emprunt> getAllEmprunt(String codePersonne) throws SQLException, ParseException {
        ArrayList<Emprunt> listeEmprunt = new ArrayList<>();
        
        Statement statement = connection.createStatement();
        String request = "SELECT * FROM Emprunt WHERE codePersonne = '"+codePersonne+"';";
        ResultSet result = statement.executeQuery(request);
        
        Date dateEmp, dateRetour;
        
        while(result.next()) {
            
            Emprunt emprunt;
            
            dateEmp = new SimpleDateFormat("yyyy-MM-dd").parse(result.getString("dateEmprunt"));
            dateRetour = new SimpleDateFormat("yyyy-MM-dd").parse(result.getString("dateRetour"));
            emprunt = new Emprunt(result.getString("ISBN"),dateEmp,dateRetour,result.getString("Rendu"),result.getString("codePersonne"), result.getInt("numeroEmprunt"));
            
            listeEmprunt.add(emprunt);
        }
        
        return listeEmprunt;
    }
    
    /**
     *
     * @param codePersonne
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    @Override
    
    public ArrayList<Emprunt> getAllEmpruntNonRendu(String codePersonne) throws SQLException, ParseException {
        
        ArrayList<Emprunt> listeEmprunt = new ArrayList<>();
        
        Statement statement = connection.createStatement();
        
        String request = "SELECT * FROM Emprunt WHERE codePersonne = '"+codePersonne+"' AND Rendu = 'NON';";
        
        ResultSet result = statement.executeQuery(request);
        
        Date borrowDate, returnDate;
        
        while(result.next()) {
        
            Emprunt emprunt;
            
            borrowDate = new SimpleDateFormat("yyyy-MM-dd").parse(result.getString("dateEmprunt"));
            returnDate = new SimpleDateFormat("yyyy-MM-dd").parse(result.getString("dateRetour"));
            
            emprunt = new Emprunt(result.getString("ISBN"),borrowDate,returnDate,result.getString("Rendu"),result.getString("codePersonne"), result.getInt("numeroEmprunt"));
            
            listeEmprunt.add(emprunt);
        
        }
        
        return listeEmprunt;
    }
    
    
    
    
    
    
    
    

    
    
    
} 


   
    

    
 
