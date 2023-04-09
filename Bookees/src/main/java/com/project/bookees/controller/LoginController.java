package com.project.bookees.controller;

import com.project.bookees.dto.LoginDTO;
import com.project.bookees.entity.Book;
import com.project.bookees.service.BookService;
import com.project.bookees.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @GetMapping("/home")
    public String indexPage(HttpServletRequest request,
                            Map<String, List<Book>> map)
    {
        System.out.println("Loading index file");
        map.put("books", this.bookService.getBookList());
        return "home";
    }

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request,
                            Map<String, String> errormap,
                            @RequestParam(required = false) String error){

        // GET
        if(error != null)
            errormap.put("error", error);
        System.out.println("login request "+request.getMethod());
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("email");
        session.invalidate();
        return "redirect:home";
    }

    @PostMapping("/login")
    public String loginPOstPage(LoginDTO dto,
                                HttpSession session)
    {
        if(dto.getEmail().equals("admin@admin.com") && dto.getPassword().equals(("admin")))
        {
            session.setAttribute("email", dto.getEmail());
            return "redirect:admin";
        }
        try {
            if(this.userService.validateUser(dto))
            {
                session.setAttribute("email", dto.getEmail());
                return "redirect:dashboard";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "redirect:login?error=Invalid credentials";
        }
        // failure => redirect (GET)
        return "redirect:login?error=Invalid credentials";
    }
}
