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

    
    @RequestMapping(method = RequestMethod.GET, path = "/users/{user_id}/items")
    public List<Item> listAll( @PathVariable ("user_id") int id) {

        return itemDAO.listAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users/{user_id}/items")
    public void insert(@RequestBody Item item,
                       @PathVariable ("user_id") int id) {

     if(!itemDAO.insert(item)) {
         // TODO - EXCEPTIONS ???
         // lanzar las excepciones correspondientes
         // user not found, bad request si esta mal el item_type
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
     }
    }

}
