package jdbc.DAO;

import jdbc.bo.Simple;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleDAO  implements IDAO<Integer, Integer, Simple> {
    private static final String INSERT_QUERY = "INSERT INTO simple (id,decouvert) VALUES(?,?)";
    private static final String FIND_ALL_SIMPLE = "SELECT * FROM compte,simple  WHERE compte.id = simple.id";
    private static final String FIND_QUERY_ID = "SELECT * FROM compte,simple  WHERE compte.id = simple.id and compte.idagence = ?";
    private static final String FIND_QUERY_CODE = "SELECT * FROM compte,simple  WHERE compte.id = simple.id and compte.code = ?";


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
    public Simple findidbycode(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }


    @Override
    public List<Simple> findAll() throws SQLException, IOException, ClassNotFoundException {
        List<Simple> list = new ArrayList<>();
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_ALL_SIMPLE ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        Simple simple = new Simple();
                        simple.setCode( rs.getInt("code"));
                        simple.setSolde( rs.getFloat( "solde" ) );
                        simple.setDecouvert( rs.getInt( "decouvert" ) );
                        simple.setIdagence( rs.getInt( "idagence" ) );

                        list.add( simple );
                    }
                }
            }
        }
        return list;

    }

    @Override
    public List<Simple> findByIdList(Integer id) throws SQLException, IOException, ClassNotFoundException {
        List<Simple> list = new ArrayList<>();
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_QUERY_ID ) ) {
                ps.setLong(1, id);
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        Simple simple = new Simple();
                        simple.setCode( rs.getInt("code"));
                        simple.setSolde( rs.getFloat( "solde" ) );
                        simple.setDecouvert( rs.getInt( "decouvert" ) );
                        simple.setIdagence( rs.getInt( "idagence" ) );

                        list.add( simple );
                    }
                }
            }
        }
        return list;
    }

    @Override
    public Simple findByCode(Integer code) throws SQLException, IOException, ClassNotFoundException {
        Simple simple = null;
        Connection connection = PersistanceManager.getConnection();
        if (connection != null) {
            try (PreparedStatement ps = connection.prepareStatement(FIND_QUERY_CODE)) {
                ps.setLong(1, code);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        simple = new Simple();
                        simple.setSolde( rs.getFloat( "solde" ) );
                        simple.setDecouvert( rs.getInt( "decouvert" ) );
                        simple.setIdagence( rs.getInt( "idagence" ) );

                    }
                }
            }
        }
        return simple;
    }

    @Override
    public Simple findById(Integer id) throws SQLException, IOException, ClassNotFoundException {
        Simple simple = null;
        Connection connection = PersistanceManager.getConnection();
        if (connection != null) {
            try (PreparedStatement ps = connection.prepareStatement(FIND_QUERY_ID)) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        simple = new Simple();
                        simple.setId(rs.getInt("id"));
                        simple.setDecouvert(rs.getFloat("decouvert"));

                    }
                }
            }
        }
        return simple;
    }
}
