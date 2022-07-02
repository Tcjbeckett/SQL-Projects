package dev.tcjbeckett.booksapi.util.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class BookController {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Autowired
//    private BookApiService service;
//
//    public BookController(BookApiService bookApiService){
//        this.service = bookApiService;
//    }
//
//    @GetMapping
//    public BookData getBookInfo(){
//
//        return service.getBook("ISBN:9780140328721");
//    }

    @RequestMapping
    public String hi(){
        return "Hi, connection yay";
    }


}
