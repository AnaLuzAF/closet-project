package org.iesfm.closet.controllers;

import org.iesfm.closet.controllers.pojosApi.ItemRest;
import org.iesfm.closet.dao.ItemDAO;
import org.iesfm.closet.pojos.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class ItemController {

    @Autowired
    private ItemDAO itemDAO;


    @RequestMapping(method = RequestMethod.GET, path = "/users/{userId}/items/{itemType}")
    public List<Item> listUserItems(
            @PathVariable("user_id") int userId,
            @RequestParam("item_type") String itemType) {

        /*
        if (!userDAO.existsUser(user_id)){
            // user not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            //bad request si esta mal el item_type
        }else if (!itemDAO.existsItemType(itemType)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        */

        if(itemType == null) {
            return itemDAO.listUserItems(userId);
        } else {
            return itemDAO.listUserItemsByType(userId, itemType);
        }
    }

/*
    @RequestMapping(method = RequestMethod.POST, path = "/users/{userId}/items")
    public void insert(@RequestBody Item item,
                       @PathVariable("user_id") int id) {

        if (!itemDAO.insert(item)) {
            // lanzar las excepciones correspondientes
            // user not found, bad request si esta mal el item_type
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    //Eliminar una prenda: DELETE /users/{userId}/items/{id}
    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{user_id}/items/{id}")
    public void deleteItem(@PathVariable("id") int id) {
        if (itemDAO.deleteItem(id) == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Item not found");
        }
    }*/







        //////////////// conversores de tipos ////////////////

    private ItemRest convertToApi(Item item) {
        return new ItemRest(
                item.getItemType()
        );
    }

    /*



    private Item convertToModel(ItemRest item, int userId) {
        return new Item(
                // !!!! new item id?
                item.getItemType(),
                userId
        );
    }
*/

    // Conversor generico de tipos:
    public  <T1, T2> List<T2> convert(List<T1> list, Function<T1, T2> fn) {
        return list
                .stream() // stream(t1)
                .map(t1 -> fn.apply(t1)) // stream de t2
                .collect(Collectors.toList()); // vuelves a convertir en una lista (de stream a list)
    }

}
