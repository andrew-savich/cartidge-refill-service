package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.model.refill.Refill;
import com.andrewsavich.bajter.cartridgerefillservice.service.refill.RefillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/refill")
@Slf4j
public class RefillController {
    @Autowired
    private RefillService refillService;

    @GetMapping("/all")
    public List<Refill> getAllRefills(){
        log.info("Getting all refills");
        List<Refill> refills = refillService.getAllRefills();
        return refills;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Refill> getRefillById(@PathVariable Long id){
        log.info("Getting refill with id: " + id);

        Refill refill = refillService.getRefillById(id);

        return ResponseEntity.ok(refill);
    }

    @PostMapping("/create")
    public void createEntity(@RequestBody Refill refill){
        log.info("Creating refill: " + refill);

        refillService.saveRefill(refill);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Refill> updateRefill(@RequestBody Refill changedRefill, @PathVariable Long id){
        log.info("Updating refill: " + changedRefill);

        Refill updatedRefill = refillService.saveRefill(changedRefill);

        return ResponseEntity.ok(updatedRefill);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRefill(@PathVariable Long id){
        Refill refill = refillService.getRefillById(id);
        log.info("Deleting refill: " + refill);

        refillService.deleteRefill(refill);

        Map<String, Boolean> response = new HashMap<>();

        return ResponseEntity.ok(response);
    }

}
