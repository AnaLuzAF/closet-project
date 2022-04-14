package org.iesfm.closet.dao;

import org.iesfm.closet.pojos.Item;

import java.util.List;

public interface ItemDAO {

    boolean post(Item item);

    List<Item> listItem();

    public List<Item> listItemById(int id);

    boolean returnUser(int userId,String nickName, String password, String email);

}
