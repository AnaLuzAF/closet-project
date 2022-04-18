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
                    rs.getString("imagename")
            );

    private final static String SELECT_ITEMS = "SELECT * FROM item";
    private static final String SELECT_ITEM_BY_ID = "SELECT * FROM item WHERE user_id = :id ";

    private final static String INSERT_ITEM = "INSERT INTO item(" +
            " item_type, " +
            " imagename " +
            ") " +
            "VALUES(" +
            " :item_type, " +
            " :imagename "+
            ")";

    @Override
    public boolean insert(Item item) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("item_type", item.getItemType());
            params.put("imagename", item.getImagename());
            return jdbc.update(INSERT_ITEM, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }

    }


    @Override
    public List<Item> listAll() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(
                SELECT_ITEMS,
                (rs, rowNum) ->
                        new Item(
                                rs.getInt("id"),
                                rs.getString("item_type"),
                                rs.getString("imagename")
                        )
        );
    }

    @Override
    public List<Item> listItemById(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.query(SELECT_ITEM_BY_ID, ITEM_ROW_MAPPER);
    }




}
