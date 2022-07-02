package controller;

import Services.BookAPIService;
import model.BookList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class BookController {

    private BookAPIService service;

    public BookController(BookAPIService service) {
        this.service = service;
    }

    public ArrayList<BookList> getBooks(){
        return service.getBookList();

    }
}
