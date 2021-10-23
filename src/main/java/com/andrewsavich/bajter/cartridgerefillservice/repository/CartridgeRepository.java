package com.andrewsavich.bajter.cartridgerefillservice.repository;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Cartridge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartridgeRepository extends JpaRepository<Cartridge, Long> {
    Cartridge findByUniqueIdentify(String uniqueIdentify);
}
