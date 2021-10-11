package com.andrewsavich.bajter.cartridgerefillservice.service.group;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.CartridgeGroup;
import com.andrewsavich.bajter.cartridgerefillservice.repository.CartridgeGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartridgeGroupServiceImpl implements CartridgeGroupService {

    @Autowired
    private CartridgeGroupRepository cartridgeGroupRepository;

    @Override
    public List<CartridgeGroup> getAllCartridgeGroups() {
        return cartridgeGroupRepository.findAll();
    }

    @Override
    public CartridgeGroup getCartridgeGroupById(Long id) {
        return cartridgeGroupRepository.findById(id).get();
    }

    @Override
    public CartridgeGroup saveCartridgeGroup(CartridgeGroup cartridgeGroup) {
        return cartridgeGroupRepository.save(cartridgeGroup);
    }

    @Override
    public void deleteCartridgeGroup(CartridgeGroup cartridgeGroup) {
        cartridgeGroupRepository.delete(cartridgeGroup);
    }

    @Override
    public boolean isExistCartridgeGroupTitle(CartridgeGroup cartridgeGroup) {
        return false;
    }
}
