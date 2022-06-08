package org.iesfm.closet.controllers;

import org.iesfm.closet.client.UserApi;
import org.iesfm.closet.controllers.mappers.UserMapper;
import org.iesfm.closet.controllers.pojosApi.UserRest;
import org.iesfm.closet.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserMapper userMapper;


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

    @RequestMapping(method = RequestMethod.GET, path = "/users/{nickname}")
    public UserRest getUserByNickname(
            @PathVariable("nickname") String nickname,
            @RequestParam(name = "password", required = false) String password) {

        return userMapper.convertToApi(userDAO.getUserByNickname(nickname, password));
    }
}
