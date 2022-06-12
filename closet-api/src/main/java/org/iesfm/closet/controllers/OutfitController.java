package org.iesfm.closet.controllers;


import org.iesfm.closet.client.OutfitsApi;
import org.iesfm.closet.controllers.mappers.OutfitMapper;
import org.iesfm.closet.controllers.pojosApi.ItemRest;
import org.iesfm.closet.controllers.pojosApi.OutfitRest;
import org.iesfm.closet.dao.OutfitDAO;
import org.iesfm.closet.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class OutfitController implements OutfitsApi {

    @Autowired
    private OutfitDAO outfitDAO;

    @Autowired
    private OutfitMapper outfitMapper;


    @RequestMapping(method = RequestMethod.POST, path = "/users/{user_id}/outfits")
    public int insert(@PathVariable("user_id") int userId, @RequestBody OutfitRest outfit) {

        return outfitDAO.insert(userId, outfitMapper.convertToModel(userId, outfit));

    }

    //listar outfits
    @RequestMapping(method = RequestMethod.GET, path = "/users/{user_id}/outfits")
    public List<OutfitRest> listUserOutfits(
            @PathVariable("user_id") int userId,
            @RequestParam(name = "category", required = false) String category) {

        if (category == null) {
            return outfitMapper.convert(outfitDAO.listUserOutfits(userId),
                    outfit -> outfitMapper.convertToApi(outfit));
        } else {
            return outfitMapper.convert(outfitDAO.listUserOutfitsByCategory(userId, category),
                    outfit -> outfitMapper.convertToApi(outfit));
        }
    }
}

