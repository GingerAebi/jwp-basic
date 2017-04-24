package core.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gingeraebi on 2017. 4. 20..
 */
public class JdbcTemplate<T> {
    private ResultSet rs = null;

    public void insert(String sql, String... params) throws SQLException {
        try (PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql)) {
            makePstmt(pstmt, params);
            pstmt.executeUpdate();
        }
    }

    public T find(String sql, RowMapper<T> rowMapper, String... params) throws SQLException {
        List<T> typeArray = findAll(sql, rowMapper, params);
        if (typeArray != null) return typeArray.get(0);
        return null;
    }

    public List<T> findAll(String sql, RowMapper<T> rowMapper, String... params) throws SQLException {
        ArrayList<T> resultArray = new ArrayList<T>();
        try (PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql)) {
            makePstmt(pstmt, params);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                resultArray.add(rowMapper.mapRow(rs));
            }
        }
        return resultArray;
    }

    private void makePstmt(PreparedStatement pstmt, String[] params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pstmt.setString(i + 1, params[i]);
        }
    }
}
