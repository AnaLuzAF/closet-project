package org.iesfm.closet.dao;

import org.iesfm.closet.pojos.Outfit;

import java.util.List;

public interface OutfitDAO {

    int insert(int userId, Outfit outfit);
    List<Outfit> listUserOutfits(int userId);
    List<Outfit> listUserOutfitsByCategory(int userId, String category);

    //boolean insert(String name, Outfit outfit);

    //List<Outfit> listUserOutfits();

    //List<Outfit> listUserOutfitsFromCategory(String name);


}
