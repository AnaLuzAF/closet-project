package org.iesfm.closet.controllers;

import org.iesfm.closet.client.UserApi;
import org.iesfm.closet.controllers.mappers.UserMapper;
import org.iesfm.closet.controllers.pojosApi.UserRest;
import org.iesfm.closet.dao.UserDAO;
import org.iesfm.closet.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserMapper userMapper;


    @RequestMapping(method = RequestMethod.GET, path = "/users/{nickname}")
    public UserRest getUserByNickname(
            @PathVariable("nickname") String nickname,
            @RequestParam(name = "password", required = true) String password) {

        return userMapper.convertToApi(userDAO.getUserByNickname(nickname, password));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public void insert(@RequestBody UserRest user) {

        if (!userDAO.insert(userMapper.convertToModel(user))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Member already exists");
        } else {
            userDAO.insert(userMapper.convertToModel(user));
            throw new ResponseStatusException(HttpStatus.CREATED, "Member inserted");
        }
    }
}
