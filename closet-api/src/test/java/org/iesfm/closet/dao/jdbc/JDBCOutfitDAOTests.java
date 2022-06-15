package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.pojos.Item;
import org.iesfm.closet.pojos.Outfit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JDBCOutfitDAOTests {


    @Autowired
    private JDBCOutfitDAO jdbcOutfitDAO;

    //INSERTAR UN OUTFIT EN UNA CATEGORÍA QUE NO EXISTE
    @Test(expected = Exception.class)
    public void insertItemFailTest() {
        jdbcOutfitDAO.insert(1,new Outfit(1,2,3,"test",1));
    }

    //INSERTAR UN OUTFIT
    @Test
    public void insertOutfitTest() {
        jdbcOutfitDAO.insert(1,new Outfit(1,2,3,"sport",1));
    }


}
