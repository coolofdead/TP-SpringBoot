package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Ms1 {

    @Autowired
    Entity1Repository Entity1Repository;

    @GetMapping("/all")
    public Iterable<Entity1> getAllEntities(){
        return Entity1Repository.findAll();
    }

    @GetMapping("/createFromRoute")
    public ResponseEntity<Entity1> createFromRoute(@RequestParam String property1, @RequestParam int property2) {
        Entity1 entity1 = new Entity1(property1, property2);
        Entity1Repository.save(entity1);
        return new ResponseEntity<>(entity1, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Entity1> update(@RequestBody Entity1 entity1) {
        Entity1Repository.save(entity1);
        return new ResponseEntity<>(entity1, HttpStatus.OK);
    }

    @GetMapping("/deleteById")
    public ResponseEntity<Entity1> deleteEntityById(@RequestParam Long id) {
        Optional<Entity1> entityToDelete = Entity1Repository.findById(id);

        entityToDelete.ifPresent(entity1 -> Entity1Repository.delete(entity1));

        return new ResponseEntity<>(entityToDelete.isPresent() ? HttpStatus.ACCEPTED : HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Entity1> createEntity1(@RequestBody Entity1 entity1) {
        Entity1Repository.save(entity1);
        return new ResponseEntity<>(entity1, HttpStatus.OK);
    }
}