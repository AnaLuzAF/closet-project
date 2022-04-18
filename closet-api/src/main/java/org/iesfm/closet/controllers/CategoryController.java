package org.iesfm.closet.controllers;

import org.iesfm.closet.client.CategoriesApi;
import org.iesfm.closet.dao.CategoryDAO;
import org.iesfm.closet.pojos.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CategoryController implements CategoriesApi {

    @Autowired
    private CategoryDAO categoryDAO;


    @RequestMapping(method = RequestMethod.POST, path = "/users/{user_id}/categories")
    public void addCategory(@PathVariable("user_id") int user_id, @RequestBody Category category) {
        if (!categoryDAO.addCategory(category)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create category");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users/{user_id}/categories")
    public List<Category> listAll(@PathVariable("user_id") int user_id) {
        return categoryDAO.listAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{user_id}/categories/{name}")
    public void deleteCategory(@PathVariable("name") String name) {
        if (categoryDAO.deleteCategory(name) == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }


}
