package com.andrewsavich.bajter.cartridgerefillservice.service.group;

import com.andrewsavich.bajter.cartridgerefillservice.exception.group.GroupNotFoundException;
import com.andrewsavich.bajter.cartridgerefillservice.exception.group.GroupTitleExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Group;
import com.andrewsavich.bajter.cartridgerefillservice.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Long id) {
        Group group = groupRepository.findById(id).orElse(null);

        if (Objects.isNull(group)) {
            throw new GroupNotFoundException("Group with id '" + id + "' not found");
        }

        return group;
    }

    @Override
    public Group getGroupByTitle(String title) {
        Group group = groupRepository.findByTitle(title);

        if (Objects.isNull(group)) {
            throw new GroupNotFoundException("Group with title '" + title + "' not found");
        }

        return group;
    }

    @Override
    public Group saveGroup(Group group) {

        if (isExistGroupTitle(group)) {
            throw new GroupTitleExistsException("Group with title '" + group.getTitle() + "' exists");
        }

        return groupRepository.save(group);
    }

    @Override
    public void deleteGroupById(Long id) {
        Group group = groupRepository.findById(id).orElse(null);

        if (Objects.isNull(group)) {
            throw new GroupNotFoundException("Group with id '" + id + "' not found");
        }

        groupRepository.delete(group);
    }

    private boolean isExistGroupTitle(Group checkingGroup) {
        Group existingGroup = groupRepository.findByTitle(checkingGroup.getTitle());

        //case for the creating a new checkingGroup without existing same title in the DB
        if (checkingGroup.getId() == null) {
            return existingGroup != null;
        }

        //case for the updating existing checkingGroup
        if (existingGroup == null) {
            return false;
        } else {
            return existingGroup.getId() != checkingGroup.getId();
        }
    }

}
