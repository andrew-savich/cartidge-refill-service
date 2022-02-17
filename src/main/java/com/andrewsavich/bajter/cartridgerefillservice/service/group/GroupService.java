package com.andrewsavich.bajter.cartridgerefillservice.service.group;


import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();

    Group getGroupById(Long id);

    Group getGroupByTitle(String title);

    Group createGroup(Group group);

    Group updateGroup(Group group);

    void deleteGroupById(Long id);
}
