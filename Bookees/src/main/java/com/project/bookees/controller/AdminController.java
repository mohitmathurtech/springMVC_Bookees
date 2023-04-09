package com.project.bookees.controller;


import com.project.bookees.entity.Book;
import com.project.bookees.entity.User;
import com.project.bookees.service.BookService;
import com.project.bookees.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String adminPage(Map<String, List<Book>> mapBooks,
                            Map<String, List<User>> mapUsers)
    {
        mapBooks.put("books", this.bookService.getBookList());

        mapUsers.put("users", this.userService.getUserList());

        System.out.println(" 1 : "+ mapBooks);
        System.out.println(" 2 :" + mapUsers);
        return "admin";
    }

}
