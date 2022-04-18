package org.iesfm.closet.dao;

import org.iesfm.closet.pojos.User;

import java.util.List;

public interface UserDAO {

    boolean insert(User user);

    List<User> listAll();
}
