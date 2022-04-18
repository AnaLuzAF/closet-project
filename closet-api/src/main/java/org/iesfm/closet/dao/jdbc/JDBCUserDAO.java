package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.dao.UserDAO;
import org.iesfm.closet.pojos.Item;
import org.iesfm.closet.pojos.User;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class JDBCUserDAO implements UserDAO {

    private NamedParameterJdbcTemplate jdbc;

    public JDBCUserDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    // QUERIES MYSQL

    private final static String SELECT_USERS = "SELECT * FROM user";

    private final static String SELECT_USER_BY_NICKNAME = "SELECT * FROM user WHERE nickname = :nickname";



    // TODO - hay que poner el id??
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

    // IMPLEMENTACION DE LAS QUERIES

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

    // TODO - hacer pojosApi??? para que al seleccionar un usuario solo salgan
    //  los datos del usuario, no todas sus listas de items y outfits

    /*
    @Override
    public User getUser(String nickname) {
        Map<String, Object> params = new HashMap<>();
        params.put("nickname", nickname);

        try {
            return jdbc.queryForObject(
                    SELECT_USER_BY_NICKNAME,
                    params,
                    (rs, rowNum) -> new User(
                            rs.getString("nickname"),
                            rs.getString("password"),
                            rs.getString("email")
                    )
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
*/

   @Override
    public List<User> listAll() {
        return jdbc.query(
                SELECT_USERS,
                (rs, n) ->
                        new User(
                                rs.getInt("id"),
                                rs.getString("nickname"),
                                rs.getString("password"),
                                rs.getString("email"),
                        )
        );
    }
}
