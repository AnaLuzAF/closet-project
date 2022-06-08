package org.iesfm.closet.client;

import org.iesfm.closet.controllers.pojosApi.UserRest;
import org.iesfm.closet.pojos.User;

public interface UserApi {
    UserRest getUserByNickname(String nickname, String password);

}
