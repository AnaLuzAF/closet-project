package org.iesfm.closet.client;

import org.iesfm.closet.controllers.pojosApi.ItemRest;
import org.iesfm.closet.pojos.Item;

import java.util.List;

public interface ItemsApi {

    // crear metodos que va a usar la web

    List<ItemRest> listUserItems(int userId, String itemType);

}
