package org.iesfm.closet.client;


import org.iesfm.closet.controllers.mappers.OutfitMapper;
import org.iesfm.closet.controllers.pojosApi.ItemRest;
import org.iesfm.closet.controllers.pojosApi.OutfitRest;

import org.iesfm.closet.pojos.Outfit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

public class OutfitClient implements OutfitsApi{
    private RestTemplate restTemplate;
    private String host;

    @Autowired
    private OutfitMapper outfitMapper;


    public OutfitClient(
            RestTemplate restTemplate,
            @Value("${outfit.api}") String host) {
        this.restTemplate = restTemplate;
        this.host = host;
    }

    //listar todos los outfits y por categoria
    @Override
    public List<OutfitRest> listUserOutfits(int userId, String category) {
        HashMap<String, Object> params = new HashMap<>();
        if (category!=null){
            params.put("category",category);
        }else{
            params.put("user_id",userId);
        }
        Outfit[] outfits = restTemplate
                .getForObject(host + "/users/{user_id}/outfits", Outfit[].class);
        return outfitMapper.convert(List.of(outfits),
                outfit -> outfitMapper.convertToApi(outfit));
    }

    @Override
    public int insert(int userId, String category, OutfitRest outfit) {
        return restTemplate.postForObject(host + "/users/{userId}/outfits", outfit, int.class);
    }

}
