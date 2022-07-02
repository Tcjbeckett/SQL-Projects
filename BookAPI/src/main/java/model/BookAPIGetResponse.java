package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookAPIGetResponse {

    @JsonProperty("bib_key")
    private BibKey bibKey;
    @JsonProperty("info_url")
    private InfoUrl infoUrl;
    @JsonProperty("thumbnail_url")
    private ThumbnailUrl thumbnailUrl;

    public BibKey getBibKey() {
        return bibKey;
    }

    public void setBibKey(BibKey bibKey) {
        this.bibKey = bibKey;
    }

    public InfoUrl getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(InfoUrl infoUrl) {
        this.infoUrl = infoUrl;
    }

    public ThumbnailUrl getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(ThumbnailUrl thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public BookDetails getDetails() {
        return details;
    }

    public void setDetails(BookDetails details) {
        this.details = details;
    }

    private BookDetails details;

}
