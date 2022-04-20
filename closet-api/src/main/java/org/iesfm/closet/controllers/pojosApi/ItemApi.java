package org.iesfm.closet.controllers.pojosApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ItemApi {

    private String itemType;

    @JsonCreator
    public ItemApi(
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
        ItemApi itemApi = (ItemApi) o;
        return Objects.equals(itemType, itemApi.itemType);
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
