package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.dao.ItemDAO;
import org.iesfm.closet.pojos.Item;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JDBCItemDAO implements ItemDAO {

    private NamedParameterJdbcTemplate jdbc;


    private final static RowMapper<Item> ITEM_ROW_MAPPER =
            (rs, rowNum) -> new Item(
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getString("name"),
                    rs.getInt("user_id")
            );

    public JDBCItemDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final static String SELECT_ITEMS = "SELECT * FROM item";
    private static final String SELECT_ITEM_BY_ID = "SELECT * FROM item WHERE id = :id ";
    private final static String RETURN_USER = "UPDATE user SET nick_name = :nickName, password =:password, email =:email WHERE id = :id";
    private final static String INSERT_ITEM = "INSERT INTO item(" +
            " type, " +
            " name, " +
            " userId, " +
            ") " +
            "VALUES(" +
            " :type, " +
            " :name, " +
            " :user_id, " +
            ")";

    @Override
    public boolean post(Item item) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("type", item.getType());
            params.put("name", item.getName());
            params.put("user_id", item.getUserId());
            return jdbc.update(INSERT_ITEM, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }

    }


    @Override
    public List<Item> listItem() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(
                SELECT_ITEMS,
                (rs, rowNum) ->
                        new Item(
                                rs.getInt("id"),
                                rs.getString("type"),
                                rs.getString("name"),
                                rs.getInt("user_id")
                        )
        );
    }

    @Override
    public List<Item> listItemById(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.query(SELECT_ITEM_BY_ID, ITEM_ROW_MAPPER);
    }

    @Override
    public boolean returnUser(int userId, String nickName, String password, String email) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", userId);
        params.put("nick_name", nickName);
        params.put("password", password);
        params.put("email", email);
        return jdbc.update(RETURN_USER, params) == 1;
    }


}
