package org.iesfm.closet.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class User {

    private int id;
    private String nickname;
    private String password;
    private String email;
    private List<Item> items;
    private List<Outfit> outfits;

    @JsonCreator
    public User(
            @JsonProperty("id") int id,
            @JsonProperty("nickname") String nickname,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email,
            @JsonProperty("items") List<Item> items,
            @JsonProperty("outfits") List<Outfit> outfits) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.items = items;
        this.outfits = outfits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Outfit> getOutfits() {
        return outfits;
    }

    public void setOutfits(List<Outfit> outfits) {
        this.outfits = outfits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(items, user.items) &&
                Objects.equals(outfits, user.outfits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, password, email, items, outfits);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", items=" + items +
                ", outfits=" + outfits +
                '}';
    }
}
