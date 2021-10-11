package com.andrewsavich.bajter.cartridgerefillservice.repository;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.CartridgeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<CartridgeGroup, Long> {
}
