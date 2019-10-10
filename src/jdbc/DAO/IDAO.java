package DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

    public interface IDAO<E> {

        void create( E object ) throws SQLException, IOException, ClassNotFoundException;
    }


