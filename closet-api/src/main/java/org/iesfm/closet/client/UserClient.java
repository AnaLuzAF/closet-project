package org.iesfm.closet.client;

import org.iesfm.closet.controllers.mappers.UserMapper;
import org.iesfm.closet.controllers.pojosApi.UserRest;
import org.iesfm.closet.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

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
    public UserRest getUserByNickname(String nickname, String password) {
        HashMap<String, Object> params = new HashMap<>();

        params.put("nickname", nickname);
        params.put("password", password);

        User user = restTemplate.getForObject(host + "/users/{nickname}", User.class, params);
        return userMapper.convertToApi(user);
    }

    @Override
    public void insert(UserRest user) {
        restTemplate.postForObject(host + "/users", user, Void.class);
    }
}