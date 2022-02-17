package com.andrewsavich.bajter.cartridgerefillservice.service.refill;

import com.andrewsavich.bajter.cartridgerefillservice.exception.refill.RefillNotFoundException;
import com.andrewsavich.bajter.cartridgerefillservice.model.refill.Refill;
import com.andrewsavich.bajter.cartridgerefillservice.repository.RefillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class RefillServiceImpl implements RefillService {
    @Autowired
    private RefillRepository refillRepository;

    @Override
    public List<Refill> getAllRefills() {
        return refillRepository.findAll();
    }

    @Override
    public Refill getRefillById(Long id) {
        Refill refill = refillRepository.findById(id).orElse(null);

        if (Objects.isNull(refill)) {
            throw new RefillNotFoundException("Refill with id '" + id + "' not found");
        }

        return refill;
    }

    @Override
    public Refill saveRefill(Refill refill) {

        if (refill.getRefillDate() == null) {
            refill.setRefillDate(new Date());
        }

        return refillRepository.save(refill);
    }

    @Override
    public void deleteRefillById(Long id) {
        Refill refill = refillRepository.findById(id).orElse(null);

        if (Objects.isNull(refill)) {
            throw new RefillNotFoundException("Refill with id '" + id + "' not found");
        }

        refillRepository.delete(refill);
    }

}
