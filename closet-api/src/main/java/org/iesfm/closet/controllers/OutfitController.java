package org.iesfm.closet.controllers;

import org.iesfm.closet.controllers.pojosApi.OutfitRest;
import org.iesfm.closet.dao.OutfitDAO;
import org.iesfm.closet.dao.UserDAO;
import org.iesfm.closet.pojos.Outfit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    @RequestMapping(method = RequestMethod.POST, path = "/users/{userId}/categories/{category}/outfits")
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


    @RequestMapping(method = RequestMethod.GET, path = "/users/{userId}/categories/{category}/outfits")
    public List<Outfit> listUserOutfits(@PathVariable("user_id") int userId, @PathVariable("category") String category) {
        if (category.equalsIgnoreCase("all")) {
            return outfitDAO.listUserOutfits();
        } else {
            return outfitDAO.listUserOutfitsFromCategory(category);
        }
    }
*/





        //////////////// conversores de tipos ////////////////

    private OutfitRest convertToApi(Outfit outfit) {
        return new OutfitRest(
                outfit.getTop(),
                outfit.getBottom(),
                outfit.getShoes()
        );
    }

    /*
    private Outfit convertToModel(OutfitRest outfit, String category, int userId) {
        return new Outfit(
                id, // outfit id autogenerado????
                outfit.getTop(),
                outfit.getBottom(),
                outfit.getShoes(),
                category,
                userId
        );
    }*/

    // Conversor generico de tipos:
    public  <T1, T2> List<T2> convert(List<T1> list, Function<T1, T2> fn) {
        return list
                .stream() // stream(t1)
                .map(t1 -> fn.apply(t1)) // stream de t2
                .collect(Collectors.toList()); // vuelves a convertir en una lista (de stream a list)
    }

}
