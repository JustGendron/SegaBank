package jdbc.DAO;

import jdbc.bo.Compte;
import jdbc.bo.Simple;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleDAO  implements IDAO<Integer, Simple> {
    private static final String INSERT_QUERY = "INSERT INTO simple (id,decouvert) VALUES(?,?)";
    private static final String FIND_ALL_SIMPLE = "SELECT * FROM compte,simple  WHERE compte.id = simple.id";


    @Override
    public void create( Simple compteS ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection
                    .prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setInt( 1, compteS.getId());
                ps.setFloat( 2, compteS.getDecouvert() );
                ps.executeUpdate();

            }
        }
    }

    @Override
    public Simple findidbycode(Integer aLong) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Simple> findAll() throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Simple> findAllS() throws SQLException, IOException, ClassNotFoundException {
        List<Simple> list = new ArrayList<>();
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_ALL_SIMPLE ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        Simple simple = new Simple();
                        simple.setDecouvert( rs.getInt( "decouvert" ) );
                        simple.setCode( rs.getInt( "code" ) );
                        simple.setIdagence( rs.getInt( "idagence" ) );

                        list.add( simple );
                    }
                }
            }
        }
        return list;
    }
}
