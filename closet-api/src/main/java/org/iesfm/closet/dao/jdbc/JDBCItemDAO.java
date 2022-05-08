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

    public JDBCItemDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final static RowMapper<Item> ITEM_ROW_MAPPER =
            (rs, rowNum) -> new Item(
                    rs.getInt("id"),
                    rs.getString("item_type"),
                    rs.getInt("user_id")
            );

    private final static String SELECT_ALL_ITEMS = "SELECT * FROM item";
    private static final String SELECT_ITEMS_BY_USER_ID = "SELECT * FROM item WHERE user_id = :user_id ";
    private static final String SELECT_ITEM_BY_ITEM_TYPE = "SELECT * FROM item WHERE itemType = :item_type ";
    private static final String DELETE_ITEM="DELETE FROM item WHERE id = :id";
    private final static String INSERT_ITEM = "INSERT INTO item(" +
            " itemType, " +
            " userId" +
            ") " +
            "VALUES(" +
            " :item_type, " +
            " :user_id"+
            ")";

    /*
    @Override
    public boolean insert(Item item) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("item_type", item.getItemType());
            params.put("user_id",item.getUserId());
            return jdbc.update(INSERT_ITEM, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    public List<Item> listAllItems() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(
                SELECT_ALL_ITEMS,
                (rs, rowNum) ->
                        new Item(
                                rs.getInt("id"),
                                rs.getString("item_type"),
                                rs.getInt("user_id")
                        )
        );
    }
    */

    // Get items by userId
    @Override
    public List<Item> listUserItems(int userId){
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", userId);
        return jdbc.query(SELECT_ITEMS_BY_USER_ID, ITEM_ROW_MAPPER);
    }

    /*
    @Override
    public int deleteItem(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.update(DELETE_ITEM, params);

    }
*/
    @Override
    public List<Item> listUserItemsByType(int userId, String itemType) {
        Map<String, Object> params = new HashMap<>();
        params.put("item_type", itemType);
        return jdbc.query(
                SELECT_ITEM_BY_ITEM_TYPE,
                (rs, rowNum) ->
                        new Item(
                                rs.getInt("id"),
                                rs.getString("item_type"),
                                rs.getInt("user_id")
                        )
        );
    }

}
