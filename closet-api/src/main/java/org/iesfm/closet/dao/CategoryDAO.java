package org.iesfm.closet.dao;

import org.iesfm.closet.pojos.Category;

import java.util.List;

public interface CategoryDAO {

    boolean addCategory(Category category);

    List<Category> listAll();

    int deleteCategory(String name);

}
