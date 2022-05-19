package org.iesfm.closet.client;

import org.iesfm.closet.controllers.mappers.ItemMapper;
import org.iesfm.closet.controllers.pojosApi.ItemRest;
import org.iesfm.closet.pojos.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

public class ItemClient implements ItemsApi {

    private RestTemplate restTemplate;
    private String host;

    @Autowired
    private ItemMapper itemMapper;

    public ItemClient(
            RestTemplate restTemplate,
            @Value("${item.api}") String host) {
        this.restTemplate = restTemplate;
        this.host = host;
    }

    @Override
    public List<ItemRest> listUserItems(int userId, String itemType) {
        HashMap<String, Object> params = new HashMap<>();
        if (itemType != null) {
            params.put("item_type", itemType);
        }
        Item[] items = restTemplate.getForObject(host + "/users/{user_id}/items/{item_type}", Item[].class, params);
        return itemMapper.convert(List.of(items),
                item -> itemMapper.convertToApi(item));
    }

    @Override
    public int insert(ItemRest item, int userId) {
        return restTemplate.postForObject(host + "/users/{user_id}/items", item, int.class);
    }

}
