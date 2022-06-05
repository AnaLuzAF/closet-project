package org.iesfm.closet.controllers.pojosApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserRest {

    private int id;
    private String nickname;
    private String password;
    private String email;

    @JsonCreator
    public UserRest(
            @JsonProperty("id") int id,
            @JsonProperty("nickname") String nickname,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRest userRest = (UserRest) o;
        return id == userRest.id && Objects.equals(nickname, userRest.nickname) && Objects.equals(password, userRest.password) && Objects.equals(email, userRest.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, password, email);
    }

    @Override
    public String toString() {
        return "UserRest{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
