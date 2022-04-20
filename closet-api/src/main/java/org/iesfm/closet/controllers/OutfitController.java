package org.iesfm.closet.controllers;

import org.iesfm.closet.controllers.pojosApi.OutfitApi;
import org.iesfm.closet.dao.OutfitDAO;
import org.iesfm.closet.dao.UserDAO;
import org.iesfm.closet.pojos.Outfit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class OutfitController {

    @Autowired
    private OutfitDAO outfitDAO;
    @Autowired
    private UserDAO userDAO;

    /*
    Crear outfit (añadir un outfit a una categoria): POST /users/{userId}/outfits/{category}??

    Ver el outfit : GET /users/{userId}/outfits

    Ver los outfits de una categoria: GET /users/{userId}/outfits/{category}
    */

    /*
    @RequestMapping(method = RequestMethod.POST, path = "/users/{user_id}/categories/{category}/outfits")
    public void insert(@PathVariable("user_id") int user_id, @PathVariable("category") String category, @RequestBody OutfitApi outfit) {

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
        }
    }


    @RequestMapping(method = RequestMethod.GET, path = "/users/{user_id}/categories/{category}/outfits")
    public List<Outfit> listUserOutfits(@PathVariable("user_id") int user_id, @PathVariable("category") String category) {
        if (category.equalsIgnoreCase("all")) {
            return outfitDAO.listUserOutfits();
        } else {
            return outfitDAO.listUserOutfitsFromCategory(category);
        }
    }
*/
}
