package org.iesfm.closet.controllers;

import org.iesfm.closet.client.UsersApi;
import org.iesfm.closet.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController implements UsersApi {

    @Autowired
    private UserDAO userDAO;

    // PETICIONES REST RequestMapping()...

    /*
    @RequestMapping(method = RequestMethod.POST, path = "/books")
    public void post(@RequestBody Book book) {

        if(!bookDAO.insert(book)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicado");

        }
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/books")
    public List<Book> getBooks(
            @RequestParam(name = "available", required = false) Boolean available,
            @RequestParam(name = "year", required = false) Integer year
    ) {

        if (available != null && year != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se puede filtrar por available y year a la mismo tiempo");
        }
        if (available != null) {
            if (available) {
                return bookDAO.listAvailableBooks();
            } else {
                return bookDAO.listLentBooks();
            }
        } else if (year != null) {
            return bookDAO.bookListByYear(year);
        } else {
            return bookDAO.listAll();
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/author/{author}/books")
    public List<Book> getBooksByAuthor(@PathVariable(name = "author") String author) {
        return bookDAO.lookForBookWithAuthor(author);
    }
    */
}
