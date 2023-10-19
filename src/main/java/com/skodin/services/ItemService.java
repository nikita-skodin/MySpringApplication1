package com.skodin.services;

import com.skodin.models.Item;
import com.skodin.models.User;
import com.skodin.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> findAll(){
        return itemsRepository.findAll();
    }

    public Item findOne(int id){
        Optional<Item> optional = itemsRepository.findById(id);

        return optional.orElse(null);
    }

    @Transactional
    public void save(Item user){
        itemsRepository.save(user);
    }

    @Transactional
    public void update(int id, Item user){
        user.setId(id);
        itemsRepository.save(user);
    }

    @Transactional
    public void delete(int id){
        itemsRepository.deleteById(id);
    }

    public List<Item> findByOwner (User user){
        return itemsRepository.findByOwner(user);
    }
    public List<Item> findByName (String name){
        return itemsRepository.findByName(name);
    }

}
