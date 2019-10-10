package jdbc.DAO;

import jdbc.bo.Agence;
import jdbc.bo.Compte;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteDAO implements IDAO<Integer,Compte> {

    private static final String INSERT_QUERY = "INSERT INTO compte (solde, idagence, code) VALUES(?,?,?)";
    private static final String FIND_QUERY = "SELECT * FROM compte  WHERE code = ?";


    @Override
    public void create( Compte compte ) throws SQLException, IOException, ClassNotFoundException {

        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection
                    .prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setFloat( 1, compte.getSolde() );
                ps.setInt( 2, compte.getIdagence() );
                ps.setInt( 3, compte.getCode() );
                ps.executeUpdate();

            }
        }
    }

    @Override
    public Compte findidbycode(Integer code ) throws SQLException, IOException, ClassNotFoundException {
        Compte compte = null;
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_QUERY ) ) {
                ps.setInt( 1, code );
                try ( ResultSet rs = ps.executeQuery() ) {
                    if ( rs.next() ) {
                        compte = new Compte();
                        compte.setId( rs.getInt( "id" ) );

                    }
                }
            }
        }
        return compte;
    }

    @Override
    public List<Compte> findAll() throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Compte> findAllS() throws SQLException, IOException, ClassNotFoundException {
        return null;
    }


}
