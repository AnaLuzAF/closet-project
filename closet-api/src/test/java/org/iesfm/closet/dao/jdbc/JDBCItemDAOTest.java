package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.dao.ItemDAO;
import org.iesfm.closet.pojos.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Sql({"schema.sql", "test-data.sql"})
public class JDBCItemDAOTest {

    @Autowired
   private JDBCItemDAO jdbcItemDAO;

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void whenInjectInMemoryDataSource_thenReturnCorrectEmployeeCount() {

        itemDAO.setJdbcTemplate(jdbcTemplate);

        assertEquals(4, itemDAO.listUserItems(1));
    }

    @Test
    public void getUserByItemsTest() {
        List<Item> prendas = jdbcItemDAO.listUserItems(1);
        Assert.assertEquals(1, prendas.get(0).getUserId());
    }


    /*@Test
    public void insertClientTest() {
        clientDAO.insert(new Client(0, "Bob", "Esponja"));
    }*/

    @Test
    public void insertItemTest() {
        jdbcItemDAO.insert(new Item("top",1));

    }

    @Test
    public void getUserItemsByTypeTest(){
        List<Item> prendas = jdbcItemDAO.listUserItemsByType(1,"top");
        Assert.assertEquals("top",prendas.get(0).getItemType());
    }
}




