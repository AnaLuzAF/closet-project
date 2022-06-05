package org.iesfm.closet.client;
import org.iesfm.closet.controllers.mappers.UserMapper;
import org.iesfm.closet.controllers.pojosApi.UserRest;
import org.iesfm.closet.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

public class UserClient implements UserApi {

    private RestTemplate restTemplate;
    private String host;

    @Autowired
    private UserMapper userMapper;

    public UserClient(
            RestTemplate restTemplate,
            @Value("${user.api}") String host) {
        this.restTemplate = restTemplate;
        this.host = host;
    }


    @Override
    public List<UserRest> listAllUsersNickname(String nickname) {
        HashMap<String, Object> params = new HashMap<>();
        if (nickname!= null) {
            params.put("nickname", nickname);
        }
        User[] users = restTemplate.getForObject(host + "/users/{nickname}", User[].class);
        return userMapper.convert(List.of(users),
                user -> userMapper.convertToApi(user));
    }
}
