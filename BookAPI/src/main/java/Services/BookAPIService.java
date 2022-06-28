package Services;

import model.Book;
import org.springframework.web.client.RestTemplate;

public class BookAPIService {
    public static final String API_BASE_URL = "https://openlibrary.org/api/books?bibkeys=";

    public static final String API_SECONDARY_URL = "&jscmd=details&format=json";

    private RestTemplate restTemplate = new RestTemplate();

    public Book getBook(int isbn){
        Book books = restTemplate.getForObject(API_BASE_URL + isbn + API_SECONDARY_URL, Book.class);
        return books;
    }
}
