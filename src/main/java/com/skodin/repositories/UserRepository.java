package com.skodin.repositories;

import com.skodin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Period;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUsername(String username);

    List<User> findByUsernameOrderByAge(String username);

    List<User> findByEmail(String email);

    List<User> findByUsernameStartingWith(String startingWith);

    List<User> findByUsernameOrEmail(String username, String email);

}
