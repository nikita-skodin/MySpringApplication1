package com.skodin.repositories;

import com.skodin.models.Item;
import com.skodin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {

    public List<Item> findByOwner(User owner);

    List<Item> findByName(String name);
}
