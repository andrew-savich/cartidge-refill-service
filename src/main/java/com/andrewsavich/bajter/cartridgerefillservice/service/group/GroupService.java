package com.andrewsavich.bajter.cartridgerefillservice.service.group;


import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.CartridgeGroup;

import java.util.List;

public interface GroupService {
    List<CartridgeGroup> getAllGroups();
    CartridgeGroup getGroupById(Long id);
    CartridgeGroup saveGroup(CartridgeGroup cartridgeGroup);
    void deleteGroup(CartridgeGroup cartridgeGroup);
    boolean isExistGroupTitle(CartridgeGroup cartridgeGroup);
}
