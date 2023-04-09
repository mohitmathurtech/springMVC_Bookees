package com.project.bookees.database;

import com.project.bookees.dto.LoginDTO;
import com.project.bookees.entity.Book;
import com.project.bookees.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDatabase {

    @Autowired
    private SessionFactory factory;

    public boolean loginUser(LoginDTO dto) throws Exception {
        System.out.println(dto);
        Session session = factory.openSession();
        User user = session.get(User.class,dto.getEmail());
        System.out.println(user);
        if(user != null)
        {
            if(dto.getPassword().equals(user.getPassword()))
                return true;
        }
        throw new Exception("Invalid Credentials");
    }

    public List<User> getAllUsers()
    {
        Session session = factory.openSession();
        List<User> userList = session.createQuery("from User",User.class).getResultList();
        session.close();
        return userList;
    }

    public String addUser(User user)
    {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        String email = (String) session.save(user.getEmail());
        tx.commit();

        session.close();
        return email;
    }

    public boolean updateUser(User user){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();

        session.close();
        return true;
    }
}
