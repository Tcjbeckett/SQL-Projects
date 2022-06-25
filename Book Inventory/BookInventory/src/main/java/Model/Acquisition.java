package Model;

import java.util.Date;

public class Acquisition {

    private int bookId;

    private int booksAcquired;

    private Date date;

    private int pricePerBook;

    private int totalAcquisitionPrice;

    public Acquisition() {}


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBooksAcquired() {
        return booksAcquired;
    }

    public void setBooksAcquired(int booksAcquired) {
        this.booksAcquired = booksAcquired;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPricePerBook() {
        return pricePerBook;
    }

    public void setPricePerBook(int pricePerBook) {
        this.pricePerBook = pricePerBook;
    }

    public int getTotalAcquisitionPrice() {
        return totalAcquisitionPrice;
    }

    public void setTotalAcquisitionPrice(int totalAcquisitionPrice) {
        this.totalAcquisitionPrice = totalAcquisitionPrice;
    }
}
