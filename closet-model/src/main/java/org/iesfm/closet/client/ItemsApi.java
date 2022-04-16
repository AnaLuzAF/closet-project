package org.iesfm.closet.client;

import org.iesfm.closet.pojos.Item;

import java.util.List;

public interface ItemsApi {

    //Lista todos los items.
    List<Item> list();

    //Inserta un nuevo item si no existe.
    void insert(Item item);

    //Muestra los datos de un item dado un id.
    List<Item> listById(int id);

    //Devolver un user a través del id del usuario
    void returnUser(int userId);

}
