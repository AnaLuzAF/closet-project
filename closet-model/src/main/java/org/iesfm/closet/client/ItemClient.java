package org.iesfm.closet.client;

import org.iesfm.closet.pojos.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

public class ItemClient implements ItemsApi {

    private RestTemplate restTemplate;
    private String host;

    public ItemClient(
            RestTemplate restTemplate,
            @Value("${item.api}") String host) {
        this.restTemplate = restTemplate;
        this.host = host;
    }

    @Override
    public List<Item> listUserItems(int userId, String itemType) {
        HashMap<String, Object> params = new HashMap<>();
        if (itemType != null) {
            params.put("item_type", itemType);
        }
        Item[] items = restTemplate.getForObject(host + "/users/{user_id}/items/{item_type}", Item[].class, params);
        return List.of(items);
    }
}
