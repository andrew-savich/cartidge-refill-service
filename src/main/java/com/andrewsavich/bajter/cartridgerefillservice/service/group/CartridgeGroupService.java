package com.andrewsavich.bajter.cartridgerefillservice.service.group;


import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Group;

import java.util.List;

public interface CartridgeGroupService {
    List<Group> getAllCartridgeGroups();
    Group getCartridgeGroupById(Long id);
    Group saveCartridgeGroup(Group group);
    void deleteCartridgeGroup(Group group);
    boolean isExistCartridgeGroupTitle(Group group);
}
