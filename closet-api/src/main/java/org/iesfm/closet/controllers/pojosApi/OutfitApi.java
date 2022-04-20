package org.iesfm.closet.controllers.pojosApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OutfitApi {

    private String top;
    private String bottom;
    private String shoes;

    @JsonCreator
    public OutfitApi(
            @JsonProperty("top_id") String top,
            @JsonProperty("bottom_id") String bottom,
            @JsonProperty("shoes_id") String shoes) {
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
    }

}
