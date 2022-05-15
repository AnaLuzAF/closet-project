package org.iesfm.closet.pojos;


import java.util.Objects;

public class Item {

    private int id;
    private String itemType;

    private String imageItem;
    private int userId;

    public Item(int id, String itemType, String imageItem, int userId) {
        this.id = id;
        this.itemType = itemType;
        this.imageItem = imageItem;
        this.userId = userId;
    }

    public Item(String itemType, String imageItem, int userId) {
        this.itemType = itemType;
        this.imageItem = imageItem;
        this.userId = userId;
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
        Item item = (Item) o;
        return id == item.id && userId == item.userId && Objects.equals(itemType, item.itemType) && Objects.equals(imageItem, item.imageItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemType, imageItem, userId);
    }

    @Override
    public String
    toString() {
        return "Item{" +
                "id=" + id +
                ", itemType='" + itemType + '\'' +
                ", imageItem='" + imageItem + '\'' +
                ", userId=" + userId +
                '}';
    }
}


