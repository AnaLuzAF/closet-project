package org.iesfm.closet.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Item {
    private int id;
    private String item_type;
    private String imagename;

    @JsonCreator
    public Item(
           @JsonProperty(value = "id", required = true) int id,
           @JsonProperty(value = "item_type",required = true) String item_type,
           @JsonProperty(value = "imagename",required = true) String imagename)
         {
        this.id = id;
        this.item_type = item_type;
        this.imagename=imagename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(item_type, item.item_type) && Objects.equals(imagename, item.imagename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item_type, imagename);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", item_type='" + item_type + '\'' +
                ", imagename='" + imagename + '\'' +
                '}';
    }
}
