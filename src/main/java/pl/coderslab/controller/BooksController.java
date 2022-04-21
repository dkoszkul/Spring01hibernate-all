package pl.coderslab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("books")
public class BooksController {

    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    public BooksController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("add")
    public String addBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Name 1");
        publisherDao.save(publisher);

        Author a1 = authorDao.findById(1);
        Author a2 = authorDao.findById(2);


        Book book = new Book();
        book.setPublisher(publisher);
        book.setAuthors(List.of(a1, a2));
        book.setTitle("Title 1");
        book.setDescription("Description 1");
        book.setRating(3);
        bookDao.saveBook(book);

        return "book id is " + book.getId();
    }

    @GetMapping("get/{id}")
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @GetMapping("update/{id}/{title}")
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }

    @Transactional
    @GetMapping("get/all")
    public String findAll() {
        return bookDao.findAll().stream().map(Book::toString).collect(Collectors.joining("\n"));
    }
}
