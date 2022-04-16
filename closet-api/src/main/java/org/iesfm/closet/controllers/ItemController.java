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


    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/items")
    public List<Item> list() {
        return itemDAO.listItem();
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, path = "/items")
    public void insert(@RequestBody Item item) {
     itemDAO.post(item);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, path = "/users/{userId}/items")
    public void returnUser(@PathVariable ("userId") int userId){
        if (!itemDAO.returnUser(userId)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "user not found"
            );
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/users/{userId}/items")
    public List<Item> listById(@PathVariable(value = "id") int id) {
        return itemDAO.listItemById(id);
    }

}
