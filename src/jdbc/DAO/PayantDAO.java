package jdbc.DAO;

import jdbc.bo.Payant;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayantDAO implements IDAO<Integer, Integer, Payant>{
    private static final String INSERT_QUERY = "INSERT INTO payant (id) VALUES(?)";
    private static final String FIND_ALL_PAYANT = "SELECT * FROM compte,payant  WHERE compte.id = payant.id";


    @Override
    public void create(Payant compteP) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection
                    .prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setInt( 1, compteP.getId());

                ps.executeUpdate();

            }
        }

    }

    @Override
    public Payant findidbycode(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }


    @Override
    public List<Payant> findAll() throws SQLException, IOException, ClassNotFoundException {
        List<Payant> list = new ArrayList<>();
        Connection connection = PersistanceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_ALL_PAYANT ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        Payant payant = new Payant();
                        payant.setCode( rs.getInt( "code" ) );
                        payant.setSolde( rs.getFloat( "solde" ) );
                        payant.setIdagence( rs.getInt( "idagence" ) );

                        list.add( payant );
                    }
                }
            }
        }
        return list;

    }

    @Override
    public Payant findById(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Payant> findByIdList(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public Payant findByCode(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }
}
