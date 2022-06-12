package org.iesfm.closet.client;


import org.iesfm.closet.controllers.pojosApi.OutfitRest;

import java.util.List;

public interface OutfitsApi {

    List<OutfitRest> listUserOutfits(int userId, String category);

    int insert(int userId, OutfitRest outfit );

}


