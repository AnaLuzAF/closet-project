package org.iesfm.closet.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.iesfm.closet.client.ItemsApi;
import org.iesfm.closet.controllers.mappers.ItemMapper;
import org.iesfm.closet.controllers.pojosApi.ItemRest;
import org.iesfm.closet.dao.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class ItemController implements ItemsApi {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private ItemMapper itemMapper;

    @Value("${library.images.path}")
    private String imagesPath;


    @RequestMapping(method = RequestMethod.GET, path = "/users/{user_id}/items")
    public List<ItemRest> listUserItems(
            @PathVariable("user_id") int userId,
            @RequestParam(name = "item_type", required = false) String itemType) {

        if (itemType == null) {
            return itemMapper.convert(itemDAO.listUserItems(userId),
                    item -> itemMapper.convertToApi(item));
        } else {
            return itemMapper.convert(itemDAO.listUserItemsByType(userId, itemType),
                    item -> itemMapper.convertToApi(item));
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users/{user_id}/items")
    public int insert(@RequestBody ItemRest item,
                      @PathVariable("user_id") int userId) {

        return itemDAO.insert(itemMapper.convertToModel(item, userId));
    }


    @RequestMapping(method = RequestMethod.POST, path = "/users/{user_id}/items/{id}/image")
    public boolean upload(
            @RequestParam("image") MultipartFile image,
            @PathVariable("user_id") int userId,
            @PathVariable("id") int itemId){
        try {
            File file = new File(imagesPath + itemId + ".jpg");
            file.createNewFile();
            IOUtils.copy(image.getInputStream(), new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
