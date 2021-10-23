package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.GroupTitleExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Group;
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
    public List<Group> getCartridgeGroupList(){
        return groupService.getAllGroups();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id){
        Group group = groupService.getGroupById(id);

        return ResponseEntity.ok(group);
    }

    @PostMapping("/create")
    public void createGroup(@RequestBody Group group){

        if(groupService.isExistGroupTitle(group)){
            throw new GroupTitleExistsException("Group with title '" + group.getTitle() + "' is exist");
        }

        groupService.saveGroup(group);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Group> updateGroup(@RequestBody Group changedGroup, @PathVariable Long id){
        Group group = groupService.getGroupById(id);
        groupService.updateFields(group, changedGroup);

        Group updatedGroup = groupService.saveGroup(group);

        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGroup(@PathVariable Long id){
        Group group = groupService.getGroupById(id);
        groupService.deleteGroup(group);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted", true);

        return ResponseEntity.ok(response);
    }

}