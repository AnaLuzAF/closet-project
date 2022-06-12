package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.pojos.Item;
import org.iesfm.closet.pojos.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JDBCItemDAOTest {

    @Autowired
    private JDBCItemDAO jdbcItemDAO;

    // INSERTAR UN ITEM
    @Test
    public void insertItemTest() {
        jdbcItemDAO.insert(new Item("top",3));
    }

}
