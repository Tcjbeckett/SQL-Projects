package Services;

import model.BookDetails;
import model.BookDetails;
import model.BookList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Component
public class BookAPIService {
    public static final String API_BASE_URL = "https://openlibrary.org/api/books?bibkeys=";

    public static final String API_SECONDARY_URL = "&jscmd=details&format=json";

    private RestTemplate restTemplate = new RestTemplate();


    public ArrayList<BookList> getBookList(){

        ArrayList<BookList> bookList = new ArrayList<>();
        return bookList;
    }



    public void getBook(String isbn13){
        String url = API_BASE_URL + isbn13 + API_SECONDARY_URL;
        BookDetails response = restTemplate.getForObject(url, BookDetails.class);

        System.out.println(response);

    }


}
