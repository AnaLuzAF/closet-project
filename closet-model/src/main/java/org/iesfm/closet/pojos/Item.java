package org.iesfm.closet.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Item {
    private int id;
    private String modeling;
    private String name;
    private String image;
    private Integer userId;

    @JsonCreator
    public Item(
           @JsonProperty(value = "id", required = true) int id,
           @JsonProperty(value = "modeling",required = true) String modeling,
           @JsonProperty(value = "name",required = true) String name,
           @JsonProperty(value = "image",required = true) String image,
           @JsonProperty(value = "userId") Integer userId) {
        this.id = id;
        this.modeling = modeling;
        this.name = name;
        this.userId = userId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModeling() {
        return modeling;
    }

    public void setModeling(String type) {
        this.modeling = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", modeling='" + modeling + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(modeling, item.modeling) && Objects.equals(name, item.name) && Objects.equals(image, item.image) && Objects.equals(userId, item.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modeling, name, image, userId);
    }
}
