package core.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gingeraebi on 2017. 4. 20..
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}
