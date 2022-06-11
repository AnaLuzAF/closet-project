package org.iesfm.closet.controllers.pojosApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ItemRest {

    private int id;
    private String itemType;

    public ItemRest(
            @JsonProperty(value = "id") int id,
            @JsonProperty(value = "item_type", required = true) String itemType) {
        this.id = id;
        this.itemType = itemType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRest itemRest = (ItemRest) o;
        return id == itemRest.id && Objects.equals(itemType, itemRest.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemType);
    }

    @Override
    public String toString() {
        return "ItemRest{" +
                "id=" + id +
                ", itemType='" + itemType + '\'' +
                '}';
    }
}
