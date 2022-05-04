package org.iesfm.closet.controllers;

import org.iesfm.closet.controllers.pojosApi.UserApi;
import org.iesfm.closet.dao.UserDAO;
import org.iesfm.closet.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;
/*
    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public void insert(@RequestBody UserApi user) {

        // convertir y usar el user convertido

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

    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        if (userDAO.deleteUser(id) == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found");
        }
    }*/
}
