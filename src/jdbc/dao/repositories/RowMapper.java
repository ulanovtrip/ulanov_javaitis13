package jdbc.dao.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

    // примнимает на вход строку, возвращает объект
    T mapRow(ResultSet row) throws SQLException;
}
