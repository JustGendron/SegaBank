package jdbc.DAO;

import bo.Agence;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class AgenceDAO implements IDAO<Agence> {
    private static final String INSERT_QUERY = "INSERT INTO agence (code, adresse) VALUES(?,?)";

    @Override
    public void create( Agence agence ) throws SQLException, IOException, ClassNotFoundException {

        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection
                    .prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setInt( 1, agence.getCode() );
                ps.setString( 2, agence.getAdresse() );
                ps.executeUpdate();

            }
        }
    }


}
