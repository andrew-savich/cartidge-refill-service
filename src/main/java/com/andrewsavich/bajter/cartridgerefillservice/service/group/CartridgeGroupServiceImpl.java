package com.andrewsavich.bajter.cartridgerefillservice.service.group;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Group;
import com.andrewsavich.bajter.cartridgerefillservice.repository.CartridgeGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartridgeGroupServiceImpl implements CartridgeGroupService {

    @Autowired
    private CartridgeGroupRepository cartridgeGroupRepository;

    @Override
    public List<Group> getAllCartridgeGroups() {
        return cartridgeGroupRepository.findAll();
    }

    @Override
    public Group getCartridgeGroupById(Long id) {
        return cartridgeGroupRepository.findById(id).get();
    }

    @Override
    public Group saveCartridgeGroup(Group group) {
        return cartridgeGroupRepository.save(group);
    }

    @Override
    public void deleteCartridgeGroup(Group group) {
        cartridgeGroupRepository.delete(group);
    }

    @Override
    public boolean isExistCartridgeGroupTitle(Group group) {
        return false;
    }
}
