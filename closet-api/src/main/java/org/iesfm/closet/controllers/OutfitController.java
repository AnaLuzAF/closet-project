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



   /*
    Crear outfit (añadir un outfit a una categoria): POST /users/{userId}/outfits/{category}??
    Ver el outfit : GET /users/{userId}/outfits
    Ver los outfits de una categoria: GET /users/{userId}/outfits/{category}
    */

    @RequestMapping(method = RequestMethod.POST, path = "/users/{user_id}/outfits")
    public int insert(@PathVariable("user_id") int userId, @PathVariable("category") String category, @RequestBody OutfitRest outfit) {

        return outfitDAO.insert(userId, outfitMapper.convertToModel(userId, category, outfit));

        /* if userdao.userexists.. hacer consultas a parte */

    /*
        if(!userDAO.userExists(user_id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        if (!outfitDAO.insert(outfitApi) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
            // lanzar excepciones segun el error:
            // si no encuentra al user
            // si el outfit esta repetido
            // si la categoria no existe
            //throw new ResponseStatusException(HttpStatus.CONFLICT, "Outfit already exists");
            //}
        }*/
    }



    /*
    @RequestMapping(method = RequestMethod.GET, path = "/users/{userId}/categories/{category}/outfits")
    public List<Outfit> listUserOutfits(@PathVariable("user_id") int userId, @PathVariable("category") String category) {
        if (category.equalsIgnoreCase("all")) {
            return outfitDAO.listUserOutfits();
        } else {
            return outfitDAO.listUserOutfitsFromCategory(category);
        }
    }
*/


    //listar todos los outfits
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

