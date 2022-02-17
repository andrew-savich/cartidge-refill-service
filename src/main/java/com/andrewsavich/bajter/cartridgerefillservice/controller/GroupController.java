package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Group;
import com.andrewsavich.bajter.cartridgerefillservice.service.group.GroupService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/groups", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getCartridgeGroupList() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long groupId) {
        return ResponseEntity.ok(groupService.getGroupById(groupId));
    }

    @GetMapping("/title/{groupTitle}")
    public ResponseEntity<Group> getGroupByTitle(@PathVariable String groupTitle) {
        return ResponseEntity.ok(groupService.getGroupByTitle(groupTitle));
    }

    @PostMapping
    public void createGroup(@RequestBody @Valid Group group) {
        groupService.saveGroup(group);
    }

    @PutMapping
    public void updateGroup(@RequestBody @Valid Group group) {
        groupService.saveGroup(group);
    }

    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) {
        groupService.deleteGroupById(groupId);
    }

}