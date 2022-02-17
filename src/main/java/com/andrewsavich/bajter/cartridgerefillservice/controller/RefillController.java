package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.model.refill.Refill;
import com.andrewsavich.bajter.cartridgerefillservice.service.refill.RefillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/refills")
public class RefillController {
    @Autowired
    private RefillService refillService;

    @GetMapping
    public List<Refill> getAllRefills() {
        return refillService.getAllRefills();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refill> getRefillById(@PathVariable Long id) {
        return ResponseEntity.ok(refillService.getRefillById(id));
    }

    @PostMapping
    public void createEntity(@RequestBody Refill refill) {
        refillService.saveRefill(refill);
    }

    @PutMapping
    public void updateRefill(@RequestBody Refill changedRefill) {
        refillService.saveRefill(changedRefill);
    }

    @DeleteMapping("/{id}")
    public void deleteRefill(@PathVariable Long id) {
        refillService.deleteRefillById(id);
    }

}
