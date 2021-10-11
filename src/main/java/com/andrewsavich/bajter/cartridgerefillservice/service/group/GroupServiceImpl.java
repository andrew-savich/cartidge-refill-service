package com.andrewsavich.bajter.cartridgerefillservice.service.group;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.CartridgeGroup;
import com.andrewsavich.bajter.cartridgerefillservice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<CartridgeGroup> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public CartridgeGroup getGroupById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public CartridgeGroup saveGroup(CartridgeGroup cartridgeGroup) {
        return groupRepository.save(cartridgeGroup);
    }

    @Override
    public void deleteGroup(CartridgeGroup cartridgeGroup) {
        groupRepository.delete(cartridgeGroup);
    }

    @Override
    public boolean isExistGroupTitle(CartridgeGroup cartridgeGroup) {
        return false;
    }
}
