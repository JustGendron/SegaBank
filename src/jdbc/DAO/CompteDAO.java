package jdbc.DAO;

import jdbc.bo.Agence;
import jdbc.bo.Compte;
import jdbc.bo.Simple;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteDAO implements IDAO<Integer, Integer,Compte> {

    private static final String INSERT_QUERY = "INSERT INTO compte (solde, idagence, code) VALUES(?,?,?)";
    private static final String FIND_QUERY = "SELECT * FROM compte  WHERE code = ?";
    private static final String FIND_QUERY_ID = "SELECT * FROM compte WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM compte,simple,payant where idagence = ?";
    private static final String FIND_ALLSIMPLE_QUERY = "SELECT * FROM compte,simple where compte.id = simple.id";
    private static final String FIND_ALLPAYANT_QUERY = "SELECT * FROM compte,payant where compte.id = payant.id";
    private static final String FIND_ALLEpargne_QUERY = "SELECT * FROM compte,simple where compte.id = simple.id";



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
        List<Compte> listS = new ArrayList<>();
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_ALLSIMPLE_QUERY ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        Simple compte = new Simple();
                        compte.setSolde( rs.getFloat( "solde" ) );
                        compte.setCode( rs.getInt( "code" ) );
                        compte.setIdagence( rs.getInt( "idagence" ) );
                        compte.setDecouvert( rs.getInt( "decouvert" ) );

                        listS.add( compte );
                    }
                }
            }
        }
        return listS;
    }

    @Override
    public Compte findById( Integer id ) throws SQLException, IOException, ClassNotFoundException {
        Compte compte = null;
        Connection connection = PersistanceManager.getConnection();
        if (connection != null) {
            try (PreparedStatement ps = connection.prepareStatement(FIND_QUERY_ID)) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        compte = new Compte();
                        compte.setId(rs.getInt("id"));
                        compte.setSolde(rs.getFloat("solde"));
                       // compte.setCode(rs.getInt("code"));
                        compte.setIdagence(rs.getInt("idagence"));


                    }
                }
            }
        }
        return compte;

    }

    @Override
    public List<Compte> findByIdList(Integer id)  throws SQLException, IOException, ClassNotFoundException {
        List<Compte> list = new ArrayList<>();
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_ALL_QUERY ) ) {
                ps.setLong(1, id);
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        Compte compte = new Compte();
                        compte.setId( rs.getInt( "id" ) );
                        compte.setSolde( rs.getFloat( "solde" ) );
                        compte.setIdagence( rs.getInt( "idagence" ) );
                        list.add( compte );
                    }
                }
            }
        }
        return list;
    }

    @Override
    public Compte findByCode(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public void update(Compte object) throws SQLException, IOException, ClassNotFoundException {

    }

}
