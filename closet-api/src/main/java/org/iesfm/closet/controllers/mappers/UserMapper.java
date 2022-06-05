package org.iesfm.closet.controllers.mappers;



import org.iesfm.closet.controllers.pojosApi.UserRest;
import org.iesfm.closet.pojos.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class UserMapper {

    public UserRest convertToApi(User user) {
        return new UserRest(
                user.getId(),
                user.getNickname(),
                user.getPassword(),
                user.getEmail()
        );
    }

    public User convertToModel(UserRest user) {
        return new User(
                user.getNickname(),
                user.getPassword(),
                user.getEmail()
        );
    }


    // Conversor generico de tipos:
    public  <T1, T2> List<T2> convert(List<T1> list, Function<T1, T2> fn) {
        return list
                .stream() // stream(t1)
                .map(t1 -> fn.apply(t1)) // stream de t2
                .collect(Collectors.toList()); // vuelves a convertir en una lista (de stream a list)
    }
}
