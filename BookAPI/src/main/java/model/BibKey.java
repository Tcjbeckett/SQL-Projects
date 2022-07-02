package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BibKey {

    public String getBibKey() {
        return bibKey;
    }

    public void setBibKey(String bibKey) {
        this.bibKey = bibKey;
    }

    @JsonProperty("bib_key")
    private String bibKey;
}
