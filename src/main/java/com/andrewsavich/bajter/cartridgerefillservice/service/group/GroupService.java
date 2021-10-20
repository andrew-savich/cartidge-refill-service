package com.andrewsavich.bajter.cartridgerefillservice.service.group;


import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    Group getGroupById(Long id);
    Group saveGroup(Group group);
    void deleteGroup(Group group);
    boolean isExistGroupTitle(Group group);
}