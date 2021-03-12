package com.sarus.ojet_perso.People;

import com.sarus.ojet_perso.Thing.Thing;

import javax.persistence.*;

@Entity
@Table
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne
    private Thing thing;

    public People() {
    }

    public People(String firstName, String lastName, Thing thing) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.thing = thing;
    }

    public People(Long id, String firstName, String lastName, Thing thing) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.thing = thing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", thing=" + thing +
                '}';
    }
}
