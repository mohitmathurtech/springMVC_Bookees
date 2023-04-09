package com.project.bookees.service;

import com.project.bookees.database.BookDatabase;
import com.project.bookees.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDatabase booksDb;

    public List<Book> getBookList() {
        List<Book> bookList = this.booksDb.getAllBooks();
        System.out.println(bookList);
        return bookList;
    }
}
