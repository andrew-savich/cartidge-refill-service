package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Group;
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
    public List<Group> getCartridgeGroupList(){
        return cartridgeGroupService.getAllCartridgeGroups();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id){
        Group group = cartridgeGroupService.getCartridgeGroupById(id);

        return ResponseEntity.ok(group);
    }

    @PostMapping("/create")
    public void createGroup(@RequestBody Group group){
        cartridgeGroupService.saveCartridgeGroup(group);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Group> updateGroup(@RequestBody Group changedGroup, @PathVariable Long id){
        Group group = cartridgeGroupService.getCartridgeGroupById(id);
        group.update(changedGroup);

        Group updatedGroup = cartridgeGroupService.saveCartridgeGroup(group);

        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGroup(@PathVariable Long id){
        Group group = cartridgeGroupService.getCartridgeGroupById(id);
        cartridgeGroupService.deleteCartridgeGroup(group);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted", true);

        return ResponseEntity.ok(response);
    }

}