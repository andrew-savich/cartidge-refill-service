package com.andrewsavich.bajter.cartridgerefillservice.service.refill;

import com.andrewsavich.bajter.cartridgerefillservice.model.refill.Refill;

import java.util.List;

public interface RefillService {
    List<Refill> getAllRefills();
    Refill getRefillById(Long id);
    Refill saveRefill(Refill refill);
    void deleteRefill(Refill refill);
}
