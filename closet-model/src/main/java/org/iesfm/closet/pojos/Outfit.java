package org.iesfm.closet.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Outfit {

    // todos los campos de la bbdd
    // json aqui no, json en pojosapi
    private int id;
    private String top;
    private String bottom;
    private String shoes;

    //cambiar
    private String category;

    @JsonCreator
    public Outfit(
            @JsonProperty("id") int id,
            @JsonProperty("top_id") String top,
            @JsonProperty("bottom_id") String bottom,
            @JsonProperty("shoes_id") String shoes,
            @JsonProperty("categories") List<String> categories) {
        this.id = id;
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
        this.categories = categories;
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outfit outfit = (Outfit) o;
        return id == outfit.id &&
                Objects.equals(top, outfit.top) &&
                Objects.equals(bottom, outfit.bottom) &&
                Objects.equals(shoes, outfit.shoes) &&
                Objects.equals(categories, outfit.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, top, bottom, shoes, categories);
    }

    @Override
    public String toString() {
        return "Outfit{" +
                "id=" + id +
                ", top='" + top + '\'' +
                ", bottom='" + bottom + '\'' +
                ", shoes='" + shoes + '\'' +
                ", categories=" + categories +
                '}';
    }
}
