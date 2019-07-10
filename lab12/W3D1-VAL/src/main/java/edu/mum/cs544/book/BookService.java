package edu.mum.cs544.book;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

  private BookRepo dao;

  public BookService(BookRepo dao) {
    this.dao = dao;
  }

  public List<Book> getAll() {
    return dao.findAll();
  }

  public void add(Book en) {
    dao.save(en);
  }

  public Book get(Integer id) {
    return dao.findById(id).get();
  }

  public void update(Book en) {
    dao.save(en);
  }

  public void delete(int id) {
    dao.deleteById(id);
  }
}