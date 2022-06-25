package Model;

public class Inventory {

    private int bookId;

    private int booksAcquired;

    private int booksSold;

    private int inventoryOnHand;

    public Inventory () {}


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

    public int getBooksSold() {
        return booksSold;
    }

    public void setBooksSold(int booksSold) {
        this.booksSold = booksSold;
    }

    public int getInventoryOnHand() {
        return inventoryOnHand;
    }

    public void setInventoryOnHand(int inventoryOnHand) {
        this.inventoryOnHand = inventoryOnHand;
    }
}
