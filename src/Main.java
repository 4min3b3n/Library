import Vues.*;
import Database.*;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws InterruptedException, SQLException, ParseException {

        Database database = new Database();
        
        ConnectionWindow window = new ConnectionWindow(database);
        window.setVisible(true);

    }
}


