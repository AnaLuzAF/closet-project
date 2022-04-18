package org.iesfm.closet.controllers;

import org.iesfm.closet.client.UsersApi;
import org.iesfm.closet.dao.UserDAO;
import org.iesfm.closet.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController implements UsersApi {

    @Autowired
    private UserDAO userDAO;


    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public void insert(@RequestBody User user) {

        if(!userDAO.insert(user)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<User> listAll() {

        return userDAO.listAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
    public User getUser(@PathVariable("id") int id) {

        return userDAO.getUser(id);
    }

}
