package org.iesfm.closet.client;



import org.iesfm.closet.controllers.pojosApi.OutfitRest;

import java.util.List;

public interface OutfitsApi {
    List<OutfitRest> listUserOutfits(int userId);

    List<OutfitRest> listUserOutfitsByCategory(int userId, String category);
}
