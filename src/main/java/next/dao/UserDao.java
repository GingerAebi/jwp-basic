package next.dao;

import java.sql.SQLException;
import java.util.List;

import core.jdbc.JdbcTemplate;
import core.jdbc.RowMapper;
import next.model.User;

public class UserDao {
    RowMapper<User> rowMapper = rs -> new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));

    public void insert(User user) throws SQLException {
        JdbcTemplate<User> template = new JdbcTemplate();
        template.insert("INSERT INTO USERS VALUES (?, ?, ?, ?)", user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
    }


    public void update(User user) throws SQLException {
        JdbcTemplate<User> template = new JdbcTemplate();
        template.insert("UPDATE USERS set password = ?, name = ?, email = ? WHERE userId = ?", user.getPassword(), user.getName(), user.getEmail(), user.getUserId());
    }

    public List<User> findAll() throws SQLException {
        JdbcTemplate<User> template = new JdbcTemplate<User>();
        return template.findAll("SELECT * FROM USERS", rowMapper);
    }

    public User findByUserId(String userId) throws SQLException {
        JdbcTemplate<User> template = new JdbcTemplate<User>();
        return template.find("SELECT * FROM USERS WHERE userid = ?", rowMapper, userId);
    }


}
