package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.GroupTitleExistsException;
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
        Group group = groupService.getGroupById(groupId);

        return ResponseEntity.ok(group);
    }

    @GetMapping("/title/{groupTitle}")
    public ResponseEntity<Group> getGroupByTitle(@PathVariable String groupTitle) {
        Group group = groupService.getGroupByTitle(groupTitle);

        return ResponseEntity.ok(group);
    }

    @PostMapping
    public void createGroup(@RequestBody @Valid Group group) {
        if (groupService.isExistGroupTitle(group)) {
            throw new GroupTitleExistsException("Group with title '" + group.getTitle() + "' is exist");
        }

        groupService.createGroup(group);
    }

    @PutMapping
    public void updateGroup(@RequestBody @Valid Group group) {
        if (groupService.isExistGroupTitle(group)) {
            throw new GroupTitleExistsException("Group with title '" + group.getTitle() + "' is exist");
        }

        groupService.updateGroup(group);
    }

    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) {
        groupService.deleteGroupById(groupId);
    }

}