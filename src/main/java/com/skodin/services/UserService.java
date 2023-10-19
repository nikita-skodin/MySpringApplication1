package com.skodin.services;

import com.skodin.dao.UserDAO;
import com.skodin.models.Mood;
import com.skodin.models.User;
import com.skodin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserRepository userRepository, UserDAO userDAO) {
        this.userRepository = userRepository;
        this.userDAO = userDAO;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(int id){
        Optional<User> optional = userRepository.findById(id);

        return optional.orElse(null);
    }

    @Transactional
    public void save(User user){
        user.setCreatedAt(new Date());
        user.setMood(Mood.SAD);
        userRepository.save(user);
    }

    @Transactional
    public void update(int id, User user){
        user.setId(id);
        userRepository.save(user);
    }

    @Transactional
    public void delete(int id){
        userRepository.deleteById(id);
    }

    public void test(){
        System.out.println("test method");
    }

}
