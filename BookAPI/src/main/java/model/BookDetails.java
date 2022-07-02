package model;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;


public class BookDetails {

    @JsonProperty("number_of_pages")
    private int pageNumbers;

    @JsonProperty("by_statement")
    private String byStatement;

    @JsonProperty("title")
    private String title;

    private String publishers;

    private String description;

    @JsonProperty("physical_format")
    private String format;

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public String getByStatement() {
        return byStatement;
    }

    public void setByStatement(String byStatement) {
        this.byStatement = byStatement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "pageNumbers=" + pageNumbers +
                ", byStatement='" + byStatement + '\'' +
                ", title='" + title + '\'' +
                ", publishers='" + publishers + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
