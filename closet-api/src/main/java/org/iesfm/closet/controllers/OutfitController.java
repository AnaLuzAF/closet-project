package org.iesfm.closet.controllers;

import org.iesfm.closet.client.OutfitsApi;
import org.iesfm.closet.dao.OutfitDAO;
import org.iesfm.closet.pojos.Category;
import org.iesfm.closet.pojos.Outfit;
import org.iesfm.closet.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class OutfitController implements OutfitsApi {

    @Autowired
    private OutfitDAO outfitDAO;

    /*
    Crear outfit (añadir un outfit a una categoria): POST /users/{userId}/outfits/{category}?? pueden ser varias --> PathVariable(“tags”) List<Tag> tags ???

    Ver el outfit : GET /users/{userId}/outfits

    Ver los outfits de una categoria: GET /users/{userId}/outfits/{category}
    */

    @RequestMapping(method = RequestMethod.POST, path = "/users/{userId}/categories/{name}/outfits")
    public void insert(@PathVariable("id") int userId, @PathVariable("name") String name, @RequestBody Outfit outfit) {


        if (!outfitDAO.insert(outfit)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Some of the parameters are missing");

            // lanzar excepciones segun el error:
            // si no encuentra al user
            // si el outfit esta repetido
            // si la categoria no existe

            //throw new ResponseStatusException(HttpStatus.CONFLICT, "Outfit already exists");
            //}
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users/{userId}/outfits")
    public List<Outfit> getOutfits(@PathVariable("id") int userId) {
        return outfitDAO.listAll();
    }

// get all outfits / outfits from selected category (puedes poner all o el nombre de la categoria)
    @RequestMapping(method = RequestMethod.GET, path = "/users/{user_id}/categories/{name}/outfits")
    public List<Outfit> listAll(@PathVariable("user_id") int user_id, @PathVariable("name") String name) {
        if (name.equalsIgnoreCase("all")) {
            return outfitDAO.listAll();
        } else {
            return outfitDAO.listOutfitsFromCategory(name);
        }
    }

}
