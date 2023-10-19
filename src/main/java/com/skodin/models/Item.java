package com.skodin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"item\"")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private User owner;

    @Column(name = "name")
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(User owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
