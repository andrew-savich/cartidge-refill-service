package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.CartridgeUniqueIdentifyException;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Cartridge;
import com.andrewsavich.bajter.cartridgerefillservice.service.cartridge.CartridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/cartridge")
public class CartridgeController {

    @Autowired
    private CartridgeService cartridgeService;

    @GetMapping("/all")
    public List<Cartridge> getAllCartridges() {
        return cartridgeService.getAllCartridges();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Cartridge> getCartridgeById(@PathVariable Long id) {
        Cartridge cartridge = cartridgeService.getCartridgeById(id);

        return ResponseEntity.ok(cartridge);
    }

    @GetMapping("/getByUniqueIdentify/{uniqueIdentify}")
    public ResponseEntity<Cartridge> getCartridgeUniqueIdentify(@PathVariable String uniqueIdentify) {
        Cartridge cartridge = cartridgeService.getCartridgeUniqueIdentify(uniqueIdentify);

        return ResponseEntity.ok(cartridge);
    }

    @PostMapping("/create")
    public void createCartridge(@RequestBody Cartridge cartridge) {
        if (cartridgeService.isExistCartridgeUniqIdentify(cartridge)) {
            throw new CartridgeUniqueIdentifyException("Cartridge with '" + cartridge.getUniqueIdentify() + "' exists");
        }

        cartridgeService.saveCartridge(cartridge);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cartridge> updateCartridge(@RequestBody Cartridge changedCartridge, @PathVariable Long id) {
        Cartridge cartridge = cartridgeService.getCartridgeById(id);
        cartridgeService.updateFields(cartridge, changedCartridge);

        if (cartridgeService.isExistCartridgeUniqIdentify(cartridge)) {
            throw new CartridgeUniqueIdentifyException("Cartridge with '" + cartridge.getUniqueIdentify() + "' exists");
        }

        Cartridge updatedCartridge = cartridgeService.saveCartridge(cartridge);
        return ResponseEntity.ok(updatedCartridge);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCartridge(@PathVariable Long id) {
        Cartridge cartridge = cartridgeService.getCartridgeById(id);
        cartridgeService.deleteCartridge(cartridge);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", true);

        return ResponseEntity.ok(response);
    }
}
