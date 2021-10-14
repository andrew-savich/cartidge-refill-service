package com.andrewsavich.bajter.cartridgerefillservice.repository;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartridgeGroupRepository extends JpaRepository<Group, Long> {
}
