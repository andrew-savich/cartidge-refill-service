package com.andrewsavich.bajter.cartridgerefillservice.service.refill;

import com.andrewsavich.bajter.cartridgerefillservice.model.refill.Refill;
import com.andrewsavich.bajter.cartridgerefillservice.repository.RefillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RefillServiceImpl implements RefillService{
    @Autowired
    private RefillRepository refillRepository;

    @Override
    public List<Refill> getAllRefills() {
        return refillRepository.findAll();
    }

    @Override
    public Refill getRefillById(Long id) {
        return refillRepository.findById(id).get();
    }

    @Override
    public Refill saveRefill(Refill refill) {
        if(refill.getRefillDate() == null){
            refill.setRefillDate(new Date());
        }
        return refillRepository.save(refill);
    }

    @Override
    public void deleteRefill(Refill refill) {
        refillRepository.delete(refill);
    }
}
