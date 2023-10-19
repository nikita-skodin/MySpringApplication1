package com.skodin.dao;

import com.skodin.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAO {
//    private final SessionFactory sessionFactory;
//
//    @Autowired
//    public UserDAO(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Transactional(readOnly = true)
//    public Optional<User> checkEmail(User user) {
//
//        Session session = sessionFactory.getCurrentSession();
//
//        return session.createNativeQuery(
//                "SELECT * FROM public.\"user\" WHERE email = :? LIMIT 1",
//                User.class).setParameter("?", user.getEmail())
//                .getResultList()
//                .stream()
//                .findAny();
//    }
//
//    @Transactional(readOnly = true)
//    public Optional<User> checkUsername(User user) {
//
//        Session session = sessionFactory.getCurrentSession();
//
//        return session.createNativeQuery(
//                        "SELECT * FROM public.\"user\" WHERE email = :? LIMIT 1",
//                        User.class).setParameter("?", user.getUsername())
//                .getResultList()
//                .stream()
//                .findAny();
//    }
}
