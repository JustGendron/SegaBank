package jdbc.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IDAO<CODE, E> {

        void create( E object ) throws SQLException, IOException, ClassNotFoundException;

        E findidbycode(CODE code ) throws SQLException, IOException, ClassNotFoundException;

        List<E> findAll() throws SQLException, IOException, ClassNotFoundException;

        List<E> findAllS() throws SQLException, IOException, ClassNotFoundException;




}


