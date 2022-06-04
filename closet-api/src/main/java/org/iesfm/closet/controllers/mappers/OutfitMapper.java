package org.iesfm.closet.controllers.mappers;


import org.iesfm.closet.controllers.pojosApi.OutfitRest;
import org.iesfm.closet.pojos.Outfit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OutfitMapper {

    public OutfitRest convertToApi(Outfit outfit) {
        return new OutfitRest(
                outfit.getId(),
                outfit.getTop(),
                outfit.getBottom(),
                outfit.getShoes(),
                outfit.getCategory()
        );
    }


    public Outfit convertToModel(int userId, OutfitRest outfit) {
        return new Outfit(
                outfit.getTop(),
                outfit.getBottom(),
                outfit.getShoes(),
                outfit.getCategory(),
                userId
        );
    }



    // Conversor generico de tipos:
    public  <T1, T2> List<T2> convert(List<T1> list, Function<T1, T2> fn) {
        return list
                .stream() // stream(t1)
                .map(t1 -> fn.apply(t1)) // stream de t2
                .collect(Collectors.toList()); // vuelves a convertir en una lista (de stream a list)
    }
}
