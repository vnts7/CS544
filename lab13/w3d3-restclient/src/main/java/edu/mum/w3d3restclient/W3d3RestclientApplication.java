package edu.mum.w3d3restclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class W3d3RestclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(W3d3RestclientApplication.class, args);
        test();
    }

    static void test() {
        String u1 = "http://localhost:8080/api/book/{id}";
        String u = "http://localhost:8080/api/book";
        RestTemplate r = new RestTemplate();

        Book book = new Book("Title", "978-0-306-40615-7", "Handsome", 300);

//◦ make a call to whatever url you mapped getAll() on and print the result
        System.out.println(
                r.exchange(u, HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                }).getBody()
        );
//◦ make a call to the url that you mapped add() on (giving it a new book)
//        System.out.println(
//                r.postForLocation(u, book)
//        );

        book.setId(r.postForObject(u, book, Integer.class));

//◦ make a call to the url that you mapped update() on (giving it an updated version)
        book.setTitle("Title updated");
        r.put(u,book);

//◦ make a call to the url that you mapped delete() on (deleting one of the books)
        r.delete(u1, 1);

//◦ make a call to the url that you mapped getAll() on and print the result again
        System.out.println(
                r.exchange(u, HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                }).getBody()
        );
//◦ make a call to the url that you mapped get() to check that you can get one book
        System.out.println(
                r.getForObject(u1, Book.class, book.getId())
        );

    }

}
