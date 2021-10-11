package com.andrewsavich.bajter.cartridgerefillservice.service.group;


import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.CartridgeGroup;

import java.util.List;

public interface CartridgeGroupService {
    List<CartridgeGroup> getAllCartridgeGroups();
    CartridgeGroup getCartridgeGroupById(Long id);
    CartridgeGroup saveCartridgeGroup(CartridgeGroup cartridgeGroup);
    void deleteCartridgeGroup(CartridgeGroup cartridgeGroup);
    boolean isExistCartridgeGroupTitle(CartridgeGroup cartridgeGroup);
}
