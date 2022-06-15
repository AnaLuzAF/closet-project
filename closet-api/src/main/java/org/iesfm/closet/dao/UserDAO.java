package org.iesfm.closet.dao;

import org.iesfm.closet.pojos.User;

public interface UserDAO {

    boolean insert(User user);

    User getUserByNickname(String nickname, String password);
}
