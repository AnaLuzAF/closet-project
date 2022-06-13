package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.pojos.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JDBCUserDAOTests {

    @Autowired
    private JDBCUserDAO jdbcUserDAO;

    //OBTENER USUARIO POR SU NICKNAME
    @Test
    public void findUserByNicknameTest() {
        User user = jdbcUserDAO.getUserByNickname("tester","test");
        Assert.assertEquals("tester", user.getNickname());
    }


    //INSERTAR UN USUARIO
     @Test
    public void insertUserTest() {
         jdbcUserDAO.insert(new User("tester", "test", "test@gmail.com"));
    }

}
