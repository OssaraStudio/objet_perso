package com.sarus.ojet_perso.Thing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ThingService {

    private final ThingRepository thingRepository;

    @Autowired
    public ThingService(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    public List<Thing> getThings() {
        return this.thingRepository.findAll();
    }

    public Thing getThing(Long thingId) {
        return this.thingRepository.findById(thingId).
                orElseThrow(() -> new IllegalStateException("Thing not found"));
    }

    public ResponseEntity<String> addThing(Thing thing) {
        this.thingRepository.save(thing);
        return new ResponseEntity<>("Successful creation of a resource " + thing,
                HttpStatus.CREATED);
    }

    ResponseEntity<String> deleteThing(Long thingId) {
        boolean exist = this.thingRepository.existsById(thingId);
        if(!exist) {
            throw new IllegalStateException("Thing not found");
        }
        this.thingRepository.deleteById(thingId);
        return new ResponseEntity<>("Successful delete of a resource",
                HttpStatus.OK);
    }

    @Transactional
    ResponseEntity<String> updateThing(Long thingId, Thing oldThing) {
        Thing thing = this.thingRepository.findById(thingId).
                orElseThrow(() -> new IllegalStateException("Thing not found"));
        if(oldThing.getName() != null && oldThing.getName().length() > 0
                && !Objects.equals(thing.getName(), oldThing.getName())){
            thing.setName(oldThing.getName());
        }
        return new ResponseEntity<>("Successful update of a resource " + thing,
                HttpStatus.CREATED);
    }
}
