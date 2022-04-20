package org.iesfm.closet.controllers;

import org.iesfm.closet.client.ItemsApi;
import org.iesfm.closet.dao.ItemDAO;
import org.iesfm.closet.pojos.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ItemController implements ItemsApi {

    @Autowired
    private ItemDAO itemDAO;


    @RequestMapping(method = RequestMethod.GET, path = "/users/{user_id}/items/{item_type}")
    public List<Item> listUserItems(
            @PathVariable("user_id") int user_id,
            @RequestParam("item_type") String itemType) {

        if (!userDAO.existsUser(user_id)){
            // user not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            //bad request si esta mal el item_type
        }else if (!itemDAO.existsItemType(itemType)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(itemType == null) {
            return itemDAO.listUserItems(user_id);
        } else {
            return itemDAO.listUserItemsByType(itemType);
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users/{user_id}/items")
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
    }
}
