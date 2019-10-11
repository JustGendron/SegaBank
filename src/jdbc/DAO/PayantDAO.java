package jdbc.DAO;

import jdbc.bo.Payant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PayantDAO implements IDAO<Integer, Integer, Payant>{
    private static final String INSERT_QUERY = "INSERT INTO payant (id) VALUES(?)";


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

/*    @Override
    public Payant findidbycode(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }*/

    @Override
    public List<Payant> findAll() throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public Payant findById(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Payant> findByIdList(Integer integer) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }
}
