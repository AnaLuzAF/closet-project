package org.iesfm.closet.dao.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JDBCUserDAOTests {

    @Autowired
    private JDBCUserDAO jdbcUserDAO;

    // TESTS

    /*
    @Test
    public void list() {
        List<Book> books = jdbcBookDAO.listAll();
        Assert.assertEquals(2, books.size());
    }
    */
}
