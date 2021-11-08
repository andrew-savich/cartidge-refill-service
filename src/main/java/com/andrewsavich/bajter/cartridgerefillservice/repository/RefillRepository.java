package com.andrewsavich.bajter.cartridgerefillservice.repository;

import com.andrewsavich.bajter.cartridgerefillservice.model.refill.Refill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefillRepository extends JpaRepository<Refill, Long> {
}
