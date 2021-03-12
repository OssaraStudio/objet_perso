package com.sarus.ojet_perso.Thing;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Thing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    public Thing() {
    }

    public Thing(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Thing(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
