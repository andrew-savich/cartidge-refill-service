package com.andrewsavich.bajter.cartridgerefillservice.service.group;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Group;
import com.andrewsavich.bajter.cartridgerefillservice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void deleteGroup(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public boolean isExistGroupTitle(Group checkingGroup) {
        Group existingGroup = groupRepository.findByTitle(checkingGroup.getTitle());

        //case for the creating a new checkingGroup without existing same title in the DB
        if(checkingGroup.getId() == null){
            return existingGroup != null;
        }

        //case for the updating existing checkingGroup
        if(existingGroup == null){
            return false;
        } else {
            return existingGroup.getId() != checkingGroup.getId();
        }
    }
}
