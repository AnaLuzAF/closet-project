package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.dao.UserDAO;
import org.iesfm.closet.pojos.User;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class JDBCUserDAO implements UserDAO {

    private NamedParameterJdbcTemplate jdbc;

    public JDBCUserDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    // QUERIES MYSQL

    private final static RowMapper<User> USER_ROW_MAPPER =
            (rs, rowNum) -> new User(
                    rs.getInt("id"),
                    rs.getString("nickname"),
                    rs.getString("password"),
                    rs.getString("email")
            );

    private final static String SELECT_USER_BY_NICKNAME = "SELECT * FROM user WHERE nickname =:nickname AND password =:password";

    private final static String SELECT_USERS = "SELECT * FROM user";

    private final static String DELETE_USER = "DELETE FROM user WHERE id = :id";

    private final static String INSERT_USER = "INSERT INTO user(" +
            " nickname, " +
            " password, " +
            " email" +
            ") " +
            "VALUES(" +
            " :nickname, " +
            " :password, " +
            " :email" +
            ")";


    @Override
    public User getUserByNickname(String nickname, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("nickname", nickname);
        params.put("password", password);
        return jdbc.queryForObject(SELECT_USER_BY_NICKNAME, params,
                USER_ROW_MAPPER
        );
    }

    @Override
    public boolean insert(User user) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("nickname", user.getNickname());
            params.put("password", user.getPassword());
            params.put("email", user.getEmail());
            return jdbc.update(INSERT_USER, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }
}