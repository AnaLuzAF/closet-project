package org.iesfm.closet.pojos;


import java.util.Objects;

public class Item {
    private int id;
    private String itemType;
    private int userId;


    public Item(
            int id,
            String itemType,
           int user_id){
        this.id = id;
        this.itemType = itemType;
        this.userId =user_id;
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
        return id == item.id && userId == item.userId && Objects.equals(itemType, item.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemType, userId);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemType='" + itemType + '\'' +
                ", user_id=" + userId +
                '}';
    }
}


