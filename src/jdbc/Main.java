import jdbc.DAO.AgenceDAO;
import DAO.IDAO;
import bo.Agence;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        IDAO<Agence> dao = new AgenceDAO();
        Agence agence = new Agence(2, "rue");
        System.out.println( agence );

        try {
           dao.create( agence );
            System.out.println( agence );
        } catch ( IOException | ClassNotFoundException | SQLException e ) {
            System.err.println( e.getMessage() );
        }



    }
}
