package org.iesfm.closet.dao;

import org.iesfm.closet.pojos.Item;

import java.util.List;

public interface ItemDAO {

    boolean insert(Item item);

    List<Item> listAll();

    List<Item> listItemById(int id);

}
