package com.project.bookees.database;

import com.project.bookees.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDatabase {

    @Autowired
    private SessionFactory factory;

    public List<Book> getAllBooks()
    {
        Session session = factory.openSession();
        List<Book> bookList = session.createQuery("from Book",Book.class).getResultList();
        session.close();
        return bookList;
    }
}
