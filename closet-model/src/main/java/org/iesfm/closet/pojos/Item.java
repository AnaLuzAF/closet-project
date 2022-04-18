package org.iesfm.closet.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Item {
    private int id;
    private String itemType;
    private String imagename;

    @JsonCreator
    public Item(
           @JsonProperty(value = "id") int id,
           @JsonProperty(value = "item_type",required = true) String itemType,
           @JsonProperty(value = "imagename",required = true) String imagename)
         {
        this.id = id;
        this.itemType = itemType;
        this.imagename=imagename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
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
        return id == item.id && Objects.equals(itemType, item.itemType) && Objects.equals(imagename, item.imagename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemType, imagename);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemType='" + itemType + '\'' +
                ", imagename='" + imagename + '\'' +
                '}';
    }
}
