package org.iesfm.closet.client;
import org.iesfm.closet.controllers.pojosApi.UserRest;
import org.iesfm.closet.pojos.User;

import java.util.List;

public interface UserApi {
    User getAllFormUser(String nickname, String password);

}
