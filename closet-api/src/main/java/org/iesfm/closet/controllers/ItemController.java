package org.iesfm.closet.controllers;

import org.iesfm.closet.client.ItemsApi;
import org.iesfm.closet.dao.ItemDAO;
import org.iesfm.closet.pojos.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(method = RequestMethod.GET, path = "/users/{userId}/items")
    public void getUserItems(@PathVariable ("userId") int userId){
        if (!itemDAO.returnUser(userId)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "user not found"
            );
        }
    }


}
