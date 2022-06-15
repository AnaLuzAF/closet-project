package org.iesfm.closet.controllers.pojosApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OutfitRest {

    private  int id;
    private int top;
    private int bottom;
    private int shoes;
    private String category;

    @JsonCreator
    public OutfitRest(
            @JsonProperty("id") int id,
            @JsonProperty("top_id") int top,
            @JsonProperty("bottom_id") int bottom,
            @JsonProperty("shoes_id") int shoes,
            @JsonProperty("category") String category) {
        this.id =id;
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getShoes() {
        return shoes;
    }

    public void setShoes(int shoes) {
        this.shoes = shoes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutfitRest that = (OutfitRest) o;
        return id == that.id && Objects.equals(top, that.top) && Objects.equals(bottom, that.bottom) && Objects.equals(shoes, that.shoes) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, top, bottom, shoes, category);
    }

    @Override
    public String toString() {
        return "OutfitRest{" +
                "id=" + id +
                ", top='" + top + '\'' +
                ", bottom='" + bottom + '\'' +
                ", shoes='" + shoes + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}