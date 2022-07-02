package dev.tcjbeckett.booksapi.util.services;

import dev.tcjbeckett.booksapi.util.model.BookData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookApiService {

    public static final String API_BASE_URL = "https://openlibrary.org/api/books?bibkeys=";

    public static final String API_SECONDARY_URL = "&jscmd=details&format=json";

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();





    public BookData getBook(String isbn13){
        String url = API_BASE_URL + isbn13 + API_SECONDARY_URL;
        BookData book = restTemplate.getForObject(url, BookData.class);

        return book;

    }


}
