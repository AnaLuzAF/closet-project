package org.iesfm.closet.dao;

import org.iesfm.closet.pojos.Item;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface ItemDAO {

    boolean insert(Item item);

    //int deleteItem (int id);

    List<Item> listUserItemsByType(int userId, String itemType);

    List<Item> listUserItems(int userId);

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}
