package com.sarus.ojet_perso.People;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> getPeoples() {
        return this.peopleRepository.findAll();
    }

    public People getPeople(Long peopleId) {
        return this.peopleRepository.findById(peopleId).
                orElseThrow(() -> new IllegalStateException("People not found"));
    }

    public ResponseEntity<String> addPeople(People people) {
        this.peopleRepository.save(people);
        return new ResponseEntity<>("Success created people " + people, HttpStatus.CREATED);
    }

    public ResponseEntity<String> deletePeople(Long peopleId) {
        boolean exist = this.peopleRepository.existsById(peopleId);
        if(!exist) {
            throw new IllegalStateException("People not found");
        }
        this.peopleRepository.deleteById(peopleId);
        return new ResponseEntity<>("Successful delete of a resource",
                HttpStatus.OK);
    }
}
