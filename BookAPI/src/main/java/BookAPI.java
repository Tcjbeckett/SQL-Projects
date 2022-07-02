import Services.BookAPIService;

public class BookAPI {

    public static BookAPIService bookAPIService = new BookAPIService();

    public static void main(String[] args) {

        BookAPI application = new BookAPI();
        application.run();
    }

    private static void run(){
//        BookAPIService bookAPIService = new BookAPIService();
        bookAPIService.getBook("ISBN:9780140328721");

    }
}
