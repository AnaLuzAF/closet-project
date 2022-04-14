package org.iesfm.closet.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Item {
    private int id;
    private String type;
    private String name;
    private Integer userId;

    @JsonCreator
    public Item(
           @JsonProperty(value = "id", required = true) int id,
           @JsonProperty(value = "type",required = true) String type,
           @JsonProperty(value = "name",required = true) String name,
           @JsonProperty(value = "userId",required = true) Integer userId) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.userId = userId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(type, item.type) && Objects.equals(name, item.name) && Objects.equals(userId, item.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, userId);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
