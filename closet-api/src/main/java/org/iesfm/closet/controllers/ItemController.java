package org.iesfm.closet.controllers;

import org.iesfm.closet.client.ItemsApi;
import org.iesfm.closet.controllers.mappers.ItemMapper;
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
public class ItemController implements ItemsApi {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private ItemMapper itemMapper;


    @RequestMapping(method = RequestMethod.GET, path = "/users/{user_id}/items")
    public List<ItemRest> listUserItems(
            @PathVariable("user_id") int userId,
            @RequestParam(name = "item_type", required = false) String itemType) {

        /*
        if (!userDAO.existsUser(user_id)){
            // user not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            //bad request si esta mal el item_type
        } else if (!itemDAO.existsItemType(itemType)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        */

        if(itemType == null) {
            return itemMapper.convert(itemDAO.listUserItems(userId),
                    item -> itemMapper.convertToApi(item));
        } else {
            return itemMapper.convert(itemDAO.listUserItemsByType(userId, itemType),
                    item -> itemMapper.convertToApi(item));
        }
    }


    @RequestMapping(method = RequestMethod.POST, path = "/users/{user_id}/items")
    public boolean insert(@RequestBody ItemRest item,
                       @PathVariable("user_id") int userId) {

        return itemDAO.insert(itemMapper.convertToModel(item, userId));
    }


    /*

    //Eliminar una prenda: DELETE /users/{userId}/items/{id}
    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{user_id}/items/{id}")
    public void deleteItem(@PathVariable("id") int id) {
        if (itemDAO.deleteItem(id) == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Item not found");
        }
    }*/



}
