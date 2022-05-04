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

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutfitApi outfitApi = (OutfitApi) o;
        return Objects.equals(top, outfitApi.top) &&
                Objects.equals(bottom, outfitApi.bottom) &&
                Objects.equals(shoes, outfitApi.shoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(top, bottom, shoes);
    }

    @Override
    public String toString() {
        return "OutfitApi{" +
                "top='" + top + '\'' +
                ", bottom='" + bottom + '\'' +
                ", shoes='" + shoes + '\'' +
                '}';
    }
}
