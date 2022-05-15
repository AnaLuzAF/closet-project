package org.iesfm.closet.controllers.pojosApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ItemRest {

    private int id;
    private String itemType;
    private String imageItem;


    public ItemRest(
            @JsonProperty(value = "id") int id,
            @JsonProperty(value = "item_type",required = true) String itemType,
            @JsonProperty(value = "image_item",required = true) String imageItem) {
        this.id = id;
        this.itemType = itemType;
        this.imageItem=imageItem;

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

    public String getImageItem() {
        return imageItem;
    }

    public void setImageItem(String imageItem) {
        this.imageItem = imageItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRest itemRest = (ItemRest) o;
        return id == itemRest.id && Objects.equals(itemType, itemRest.itemType) && Objects.equals(imageItem, itemRest.imageItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemType, imageItem);
    }

    @Override
    public String toString() {
        return "ItemRest{" +
                "id=" + id +
                ", itemType='" + itemType + '\'' +
                ", imageItem='" + imageItem + '\'' +
                '}';
    }
}


