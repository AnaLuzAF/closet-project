package org.iesfm.closet.dao;

import org.iesfm.closet.pojos.Outfit;

import java.util.List;

public interface OutfitDAO {

    boolean insert(Outfit outfit);

    List<Outfit> listAll();
}
