package com.project.bookees.service;

import com.project.bookees.database.UserDatabase;
import com.project.bookees.dto.LoginDTO;
import com.project.bookees.entity.Book;
import com.project.bookees.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDatabase userDb;
    @Autowired
    private BookService bookService;

    public boolean validateUser(LoginDTO dto) throws Exception {
        if(this.userDb.loginUser(dto))
            return true;
        return false;
    }

    public List<User> getUserList() {
        List<User> userList = this.userDb.getAllUsers();
        System.out.println(userList);
        return userList;
    }

    public String insertUser(User user)
    {
        return this.userDb.addUser(user);
    }

    public boolean updateUser(User user)
    {
        return this.userDb.updateUser(user);
    }
}
