package org.iesfm.closet.dao;

import org.iesfm.closet.pojos.Item;

import java.util.List;

public interface ItemDAO {

    boolean insert(Item item);

    List<Item> listAll();

    List listItemById(int id);

    int deleteItem (int id);

    boolean listItemByType(String itemType);

    List<Item> listByType(String itemType);

    //no funciona
    boolean listItem(int id);
}
