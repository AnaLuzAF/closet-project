package org.iesfm.closet.controllers.pojosApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ItemRest {

    private String itemType;

    @JsonCreator
    public ItemRest(
            @JsonProperty(value = "item_type",required = true) String itemType) {
        this.itemType = itemType;
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
        return Objects.equals(itemType, itemRest.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemType);
    }

    @Override
    public String toString() {
        return "ItemApi{" +
                "itemType='" + itemType + '\'' +
                '}';
    }
}
