package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.model.refill.Refill;
import com.andrewsavich.bajter.cartridgerefillservice.service.refill.RefillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/refill")
public class RefillController {
    @Autowired
    private RefillService refillService;

    @GetMapping("/all")
    public List<Refill> getAllRefills() {
        List<Refill> refills = refillService.getAllRefills();
        return refills;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Refill> getRefillById(@PathVariable Long id) {
        Refill refill = refillService.getRefillById(id);

        return ResponseEntity.ok(refill);
    }

    @PostMapping("/create")
    public void createEntity(@RequestBody Refill refill) {
        refillService.saveRefill(refill);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Refill> updateRefill(@RequestBody Refill changedRefill, @PathVariable Long id) {
        Refill updatedRefill = refillService.saveRefill(changedRefill);

        return ResponseEntity.ok(updatedRefill);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRefill(@PathVariable Long id) {
        Refill refill = refillService.getRefillById(id);

        refillService.deleteRefill(refill);

        Map<String, Boolean> response = new HashMap<>();

        return ResponseEntity.ok(response);
    }

}
