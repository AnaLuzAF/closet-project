package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.dao.UserDAO;
import org.iesfm.closet.pojos.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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

    private final static String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = :id";

    private final static String SELECT_USER_ITEMS =
            "SELECT * FROM item WHERE user_id=:id";

    private final static String SELECT_USER_OUTFITS =
            "SELECT * FROM outfit WHERE user_id=:id";

    private final static String SELECT_ITEMS_BY_USER_ID =
            "SELECT * FROM item WHERE user_id=:id";

    private final static String SELECT_OUTFITS_BY_USER_ID =
            "SELECT * FROM outfit WHERE user_id=:id";

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
    public User getUserByNickname(String nickname,String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("nickname", nickname);
        params.put("password", password);
        return jdbc.queryForObject(SELECT_USER_BY_NICKNAME, params,
                USER_ROW_MAPPER
        );
    }

    // IMPLEMENTACION DE LAS QUERIES

    //getUser comprobación de user y pass

    /*
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


    private List<String> selectUserItems(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", id);
        return jdbc.query(SELECT_USER_ITEMS, params,
                (rs, rownum) ->
                        rs.getString("items")
        );
    }

    private List<String> selectUserOutfits(String nif) {
        Map<String, Object> params = new HashMap<>();
        params.put("nif", nif);
        return jdbc.query(SELECT_USER_OUTFITS, params,
                (rs, rownum) ->
                        rs.getString("role")
        );
    }



    @Override
    public User getUser(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        try {
            return jdbc.queryForObject(
                    SELECT_USER_BY_ID,
                    params,
                    USER_ROW_MAPPER);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private List<Item> getUserItems(int id) {
        Map<String, Object> params = new HashMap<>();
        // TODO - cambiar por id?
        params.put("user_id", id);
        return new LinkedList<>(
                jdbc.query(
                        SELECT_ITEMS_BY_USER_ID,
                        params,
                        (rs, rowNum) -> new Item(
                                rs.getInt("id"),
                                rs.getString("item_type"),
                                rs.getInt("user_id")
                        )
                )
        );
    }

    private List<Outfit> getUserOutfits(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return new LinkedList<>(
                jdbc.query(
                        SELECT_OUTFITS_BY_USER_ID,
                        params,
                        (rs, rowNum) -> new Outfit(
                                rs.getInt("id"),
                                rs.getString("top_id"),
                                rs.getString("bottom_id"),
                                rs.getString("shoes_id"),
                                rs.getString("category"),
                                rs.getInt("user_id")
                        )
                )
        );
    }


    @Override
    public List<User> listAll() {
        return jdbc.query(
                SELECT_USERS,
                USER_ROW_MAPPER);
    }

    @Override
    public int deleteUser(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.update(DELETE_USER, params);
    }

    @Override
    public boolean userExists(int id) {
        return false;
    }

     */


}