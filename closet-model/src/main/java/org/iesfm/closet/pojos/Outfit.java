package org.iesfm.closet.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Outfit {

    private int id;
    private String top;
    private String bottom;
    private String shoes;
    // TODO - tags tendria que ser categories
    List<String> tags;

    @JsonCreator
    public Outfit(
            @JsonProperty("id") int id,
            @JsonProperty("top") String top,
            @JsonProperty("bottom") String bottom,
            @JsonProperty("shoes") String shoes,
            @JsonProperty("tags") List<String> tags) {
        this.id = id;
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outfit outfit = (Outfit) o;
        return id == outfit.id &&
                Objects.equals(top, outfit.top) &&
                Objects.equals(bottom, outfit.bottom) &&
                Objects.equals(shoes, outfit.shoes) &&
                Objects.equals(tags, outfit.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, top, bottom, shoes, tags);
    }

    @Override
    public String toString() {
        return "Outfit{" +
                "id=" + id +
                ", top='" + top + '\'' +
                ", bottom='" + bottom + '\'' +
                ", shoes='" + shoes + '\'' +
                ", tags=" + tags +
                '}';
    }
}
