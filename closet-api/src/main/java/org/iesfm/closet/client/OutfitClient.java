package org.iesfm.closet.client;


import org.iesfm.closet.controllers.mappers.OutfitMapper;
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

    //listar todos los outfits
    @Override
    public List<OutfitRest> listUserOutfits(int userId) {
        Outfit[] outfits = restTemplate
                .getForObject(host + "/users/{user_id}/outfits", Outfit[].class);
        return outfitMapper.convert(List.of(outfits),
                outfit -> outfitMapper.convertToApi(outfit));
    }




    //listar outfit por una categoría
    @Override
    public List<OutfitRest> listUserOutfitsByCategory(int userId, String category) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("user_id",userId);
        params.put("category",category);
        Outfit[] outfits = restTemplate.getForObject(host + "/users/{user_id}/outfits/{category}", Outfit[].class, params);
        return outfitMapper.convert(List.of(outfits),
                outfit -> outfitMapper.convertToApi(outfit));
    }
}
