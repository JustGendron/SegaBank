package jdbc.DAO;

import jdbc.bo.Epargne;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EpargneDAO implements IDAO <Integer, Integer, Epargne> {
    private static final String INSERT_QUERY = "INSERT INTO epargne (id,tauxint) VALUES(?,?)";
    private static final String FIND_ALL_EPARGNE = "SELECT * FROM compte,epargne  WHERE compte.id = epargne.id";

    @Override
    public void create(Epargne compteE) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection
                    .prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setInt( 1, compteE.getId());
                ps.setFloat( 2, compteE.getTauxInteret() );

                ps.executeUpdate();

            }
        }

    }

    @Override
    public Epargne findidbycode(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Epargne> findAll() throws SQLException, IOException, ClassNotFoundException {
        List<Epargne> list = new ArrayList<>();
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_ALL_EPARGNE ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        Epargne epargne = new Epargne();
                        epargne.setCode( rs.getInt( "code" ) );
                        epargne.setSolde( rs.getFloat( "solde" ) );
                        epargne.setIdagence( rs.getInt( "idagence" ) );
                        epargne.setTauxInteret( rs.getInt( "tauxint" ) );


                        list.add( epargne );
                    }
                }
            }
        }
        return list;

    }

    @Override
    public Epargne findById(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Epargne> findByIdList(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public Epargne findByCode(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }
}
