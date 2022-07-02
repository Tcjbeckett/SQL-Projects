package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThumbnailUrl {

    @JsonProperty("thumbnail_url")
    private String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
