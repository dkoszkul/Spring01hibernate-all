package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.Collection;

@Controller
@RequestMapping("bookForm")
public class BookFormController {

    private BookDao bookDao;

    private PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("add")
    public String addBookForm(Model model) {
        model.addAttribute(new Book());
        return "bookForm-add";
    }

    @PostMapping("add")
    @ResponseBody
    public String addBook(@ModelAttribute("book")Book book) {
        bookDao.saveBook(book);
        return "book added";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.getList();
    }
}
