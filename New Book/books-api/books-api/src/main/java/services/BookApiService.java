package services;

import model.BookData;
import org.springframework.web.client.RestTemplate;

public class BookApiService {

    public static final String API_BASE_URL = "https://openlibrary.org/api/books?bibkeys=";

    public static final String API_SECONDARY_URL = "&jscmd=details&format=json";

    private RestTemplate restTemplate = new RestTemplate();


    public BookData getBook(String isbn13){
        String url = API_BASE_URL + isbn13 + API_SECONDARY_URL;
        BookData book = restTemplate.getForObject(url, BookData.class);

        return book;

    }


}
