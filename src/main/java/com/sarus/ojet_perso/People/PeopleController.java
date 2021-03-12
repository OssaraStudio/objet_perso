package com.sarus.ojet_perso.People;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/all")
    public List<People> getPeoples(){
        return this.peopleService.getPeoples();
    }

    @GetMapping(path = "{peopleId}")
    public People getPeople(@PathVariable("peopleId") Long peopleId) {
        return this.peopleService.getPeople(peopleId);
    }

    @PostMapping
    ResponseEntity<String> addPeople(@RequestBody People people){
        return this.peopleService.addPeople(people);
    }

    @DeleteMapping(path = "{peopleId}")
    ResponseEntity<String> deletePeople(@PathVariable("peopleId") Long peopleId){
        return this.peopleService.deletePeople(peopleId);
    }
}
