package com.sarus.ojet_perso.Thing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/thing")
public class ThingController {

    private final ThingService thingService;

    @Autowired
    public ThingController(ThingService thingService) {
        this.thingService = thingService;
    }

    @GetMapping("/all")
    public List<Thing> getThings(){
        return this.thingService.getThings();
    }

    @GetMapping(path = "/{thingId}")
    public Thing getThing(@PathVariable("thingId") Long thingId){
        return this.thingService.getThing(thingId);
    }

    @PostMapping
    ResponseEntity<String> addThing(@RequestBody Thing thing) {
        return this.thingService.addThing(thing);
    }

    @DeleteMapping(path = "/{thingId}")
    ResponseEntity<String> deleteThing(@PathVariable("thingId") Long thingId){
        return this.thingService.deleteThing(thingId);
    }

    @PutMapping(path = "/{thingId}")
    ResponseEntity<String> updateThing(@PathVariable("thingId") Long thingId,
                                       @RequestBody Thing thing) {
        return this.thingService.updateThing(thingId, thing);
    }
}
