package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Cartridge;
import com.andrewsavich.bajter.cartridgerefillservice.service.cartridge.CartridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/cartridges", produces = MediaType.APPLICATION_JSON_VALUE)
public class CartridgeController {

    @Autowired
    private CartridgeService cartridgeService;

    @GetMapping
    public List<Cartridge> getAllCartridges() {
        return cartridgeService.getAllCartridges();
    }

    @GetMapping("/{cartridgeId}")
    public ResponseEntity<Cartridge> getCartridgeById(@PathVariable Long cartridgeId) {
        return ResponseEntity.ok(cartridgeService.getCartridgeById(cartridgeId));
    }

    @GetMapping("/uniqueIdentify/{uniqueIdentify}")
    public ResponseEntity<Cartridge> getCartridgeUniqueIdentify(@PathVariable String uniqueIdentify) {
        return ResponseEntity.ok(cartridgeService.getCartridgeByUniqueIdentify(uniqueIdentify));
    }

    @PostMapping
    public void createCartridge(@RequestBody Cartridge cartridge) {
        cartridgeService.saveCartridge(cartridge);
    }

    @PutMapping
    public void updateCartridge(@RequestBody Cartridge cartridge) {
        cartridgeService.saveCartridge(cartridge);
    }

    @DeleteMapping("/{cartridgeId}")
    public void deleteCartridge(@PathVariable Long cartridgeId) {
        cartridgeService.deleteCartridgeById(cartridgeId);
    }
}
