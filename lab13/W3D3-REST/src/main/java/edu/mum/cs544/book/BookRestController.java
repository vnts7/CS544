package edu.mum.cs544.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookRestController {
    @Autowired
    private BookService s;

    @GetMapping("")
    public List<Book> getAll() {
        return s.getAll();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable int id) {
        return s.get(id);
    }

    @PostMapping("")
    public Integer add(@RequestBody Book book) {
        s.add(book);
//        return new RedirectView("/api/book/" + book.getId());
        return book.getId();
    }

    @PutMapping("")
    public void update(@RequestBody Book book) {
        s.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        s.delete(id);
    }

}
