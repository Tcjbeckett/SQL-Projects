package model;

import java.util.Date;

public class Book {

    private int isbn13;
    private String title;
    private int pageNumbers;
    private String authorName;
    private Date publishDate;
    private String publisher;
    private String thumbnailURL;
    private String infoURL;

    public int getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(int isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getInfoURL() {
        return infoURL;
    }

    public void setInfoURL(String infoURL) {
        this.infoURL = infoURL;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn13=" + isbn13 +
                ", title='" + title + '\'' +
                ", pageNumbers=" + pageNumbers +
                ", authorName='" + authorName + '\'' +
                ", publishDate=" + publishDate +
                ", publisher='" + publisher + '\'' +
                ", thumbnailURL='" + thumbnailURL + '\'' +
                ", infoURL='" + infoURL + '\'' +
                '}';
    }
}
