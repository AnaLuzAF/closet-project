package org.iesfm.closet.controllers.pojosApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OutfitRest {

    private  int id;
    private String top;
    private String bottom;
    private String shoes;

    @JsonCreator
    public OutfitRest(
            @JsonProperty("id") int id,
            @JsonProperty("top_id") String top,
            @JsonProperty("bottom_id") String bottom,
            @JsonProperty("shoes_id") String shoes) {
        this.id =id;
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        OutfitRest that = (OutfitRest) o;
        return id == that.id && Objects.equals(top, that.top) && Objects.equals(bottom, that.bottom) && Objects.equals(shoes, that.shoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, top, bottom, shoes);
    }

    @Override
    public String toString() {
        return "OutfitRest{" +
                "id=" + id +
                ", top='" + top + '\'' +
                ", bottom='" + bottom + '\'' +
                ", shoes='" + shoes + '\'' +
                '}';
    }
}
