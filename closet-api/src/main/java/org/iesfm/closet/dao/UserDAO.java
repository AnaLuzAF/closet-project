package org.iesfm.closet.dao;

import org.iesfm.closet.pojos.User;

public interface UserDAO {

    //boolean insert(User user);

    //List<User> listAll();

    //User getUser(int id);

    //int deleteUser(int id);

    //boolean userExists(int id);


    User getUserByNickname(String nickname, String password);
}
