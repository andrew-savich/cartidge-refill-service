package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.CartridgeGroup;
import com.andrewsavich.bajter.cartridgerefillservice.service.group.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/group")
@Slf4j
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/all")
    public List<CartridgeGroup> getGroupList(){
        return groupService.getAllGroups();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CartridgeGroup> getGroupById(@PathVariable Long id){
        CartridgeGroup cartridgeGroup = groupService.getGroupById(id);

        return ResponseEntity.ok(cartridgeGroup);
    }

    @PostMapping("/create")
    public void createGroup(@RequestBody CartridgeGroup cartridgeGroup){
        groupService.saveGroup(cartridgeGroup);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CartridgeGroup> updateGroup(@RequestBody CartridgeGroup changedCartridgeGroup, @PathVariable Long id){
        CartridgeGroup cartridgeGroup = groupService.getGroupById(id);
        cartridgeGroup.update(changedCartridgeGroup);

        CartridgeGroup updatedCartridgeGroup = groupService.saveGroup(cartridgeGroup);

        return ResponseEntity.ok(updatedCartridgeGroup);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGroup(@PathVariable Long id){
        CartridgeGroup cartridgeGroup = groupService.getGroupById(id);
        groupService.deleteGroup(cartridgeGroup);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted", true);

        return ResponseEntity.ok(response);
    }

}