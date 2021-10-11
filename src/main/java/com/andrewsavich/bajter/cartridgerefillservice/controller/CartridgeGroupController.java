package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.CartridgeGroup;
import com.andrewsavich.bajter.cartridgerefillservice.service.group.CartridgeGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/cartridge-group")
@Slf4j
public class CartridgeGroupController {

    @Autowired
    private CartridgeGroupService cartridgeGroupService;

    @GetMapping("/all")
    public List<CartridgeGroup> getCartridgeGroupList(){
        return cartridgeGroupService.getAllCartridgeGroups();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CartridgeGroup> getGroupById(@PathVariable Long id){
        CartridgeGroup cartridgeGroup = cartridgeGroupService.getCartridgeGroupById(id);

        return ResponseEntity.ok(cartridgeGroup);
    }

    @PostMapping("/create")
    public void createGroup(@RequestBody CartridgeGroup cartridgeGroup){
        cartridgeGroupService.saveCartridgeGroup(cartridgeGroup);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CartridgeGroup> updateGroup(@RequestBody CartridgeGroup changedCartridgeGroup, @PathVariable Long id){
        CartridgeGroup cartridgeGroup = cartridgeGroupService.getCartridgeGroupById(id);
        cartridgeGroup.update(changedCartridgeGroup);

        CartridgeGroup updatedCartridgeGroup = cartridgeGroupService.saveCartridgeGroup(cartridgeGroup);

        return ResponseEntity.ok(updatedCartridgeGroup);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGroup(@PathVariable Long id){
        CartridgeGroup cartridgeGroup = cartridgeGroupService.getCartridgeGroupById(id);
        cartridgeGroupService.deleteCartridgeGroup(cartridgeGroup);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted", true);

        return ResponseEntity.ok(response);
    }

}