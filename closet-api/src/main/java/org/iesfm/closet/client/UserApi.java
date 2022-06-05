package org.iesfm.closet.client;
import org.iesfm.closet.controllers.pojosApi.UserRest;

import java.util.List;

public interface UserApi {
    List<UserRest> listAllUsersNickname(String nickname);
}
