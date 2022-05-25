package org.iesfm.closet.client;

import org.iesfm.closet.controllers.pojosApi.ItemRest;

import java.util.List;

public interface ItemsApi {

    List<ItemRest> listUserItems(int userId, String itemType);

    int insert(ItemRest item, int userId);


}
