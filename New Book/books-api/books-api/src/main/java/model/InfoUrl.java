package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoUrl {

    @JsonProperty("info_url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

