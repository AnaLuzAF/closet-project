package org.iesfm.closet.controllers;

import org.iesfm.closet.controllers.pojosApi.UserRest;
import org.iesfm.closet.dao.UserDAO;
import org.iesfm.closet.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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





         //////////////// conversores de tipos ////////////////

    private UserRest convertToApi(User user) {
        return new UserRest(
                user.getNickname(),
                user.getPassword(),
                user.getEmail()
        );
    }

    /*
    private User convertToModel(UserRest user) {
        return new User(
                id, // new id??????
                user.getNickname(),
                user.getPassword(),
                user.getEmail()
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
