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
    private String category;
    private int user_id;

    public Outfit(int id, String top, String bottom, String shoes, String category, int user_id) {
        this.id = id;
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
        this.category = category;
        this.user_id = user_id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outfit outfit = (Outfit) o;
        return id == outfit.id && user_id == outfit.user_id && Objects.equals(top, outfit.top) && Objects.equals(bottom, outfit.bottom) && Objects.equals(shoes, outfit.shoes) && Objects.equals(category, outfit.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, top, bottom, shoes, category, user_id);
    }

    @Override
    public String toString() {
        return "Outfit{" +
                "id=" + id +
                ", top='" + top + '\'' +
                ", bottom='" + bottom + '\'' +
                ", shoes='" + shoes + '\'' +
                ", category='" + category + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
