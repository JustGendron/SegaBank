package jdbc.DAO;

import jdbc.bo.Agence;


import jdbc.bo.Agence;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgenceDAO implements IDAO<Integer, Integer, Agence> {
    private static final String INSERT_QUERY = "INSERT INTO agence (code, adresse) VALUES(?,?)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM agence";

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

    @Override
    public Agence findidbycode(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    /*@Override
    public Agence findidbycode(Integer aLong) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }*/

    @Override
    public List<Agence> findAll() throws SQLException, IOException, ClassNotFoundException {
        List<Agence> list = new ArrayList<>();
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_ALL_QUERY ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        Agence agence = new Agence();
                        agence.setIdentifiant( rs.getInt( "id" ) );
                        agence.setCode( rs.getInt( "code" ) );
                        agence.setAdresse( rs.getString( "adresse" ) );
                        list.add( agence );
                    }
                }
            }
        }
        return list;
    }

    @Override
    public Agence findById(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Agence> findByIdList(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }


}
