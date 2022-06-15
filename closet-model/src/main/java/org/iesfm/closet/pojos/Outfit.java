package org.iesfm.closet.pojos;

import java.util.Objects;

public class Outfit {

    private int id;
    private int top;
    private int bottom;
    private int shoes;
    private String category;
    private int userId;

    public Outfit(int id, int top, int bottom, int shoes, String category, int userId) {
        this.id = id;
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
        this.category = category;
        this.userId = userId;
    }

    public Outfit(int top, int bottom, int shoes, String category, int userId) {
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
        this.category = category;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outfit outfit = (Outfit) o;
        return id == outfit.id && top == outfit.top && bottom == outfit.bottom && shoes == outfit.shoes && userId == outfit.userId && Objects.equals(category, outfit.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, top, bottom, shoes, category, userId);
    }

    @Override
    public String toString() {
        return "Outfit{" +
                "id=" + id +
                ", top=" + top +
                ", bottom=" + bottom +
                ", shoes=" + shoes +
                ", category='" + category + '\'' +
                ", userId=" + userId +
                '}';
    }
}