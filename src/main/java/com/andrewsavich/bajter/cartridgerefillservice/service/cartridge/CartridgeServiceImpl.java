package com.andrewsavich.bajter.cartridgerefillservice.service.cartridge;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Cartridge;
import com.andrewsavich.bajter.cartridgerefillservice.repository.CartridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartridgeServiceImpl implements CartridgeService{

    private final String START_UNIQUE_IDENTIFY_NUMBER = "B2500";
    private int lastGeneratedUniqueIdentifyNumber;

    @Autowired
    private CartridgeRepository cartridgeRepository;

    @Override
    public List<Cartridge> getAllCartridges() {
        return cartridgeRepository.findAll();
    }

    @Override
    public Cartridge getCartridgeById(Long id) {
        return cartridgeRepository.findById(id).get();
    }

    @Override
    public Cartridge saveCartridge(Cartridge cartridge) {
        if(cartridge.getUniqueIdentify() == null){
            cartridge.setUniqueIdentify(generateUniqueIdentify());
        }

        if(cartridge.getAddedDate() == null){
            cartridge.setAddedDate(new Date());
        }

        return cartridgeRepository.save(cartridge);
    }

    @Override
    public void deleteCartridge(Cartridge cartridge) {
        cartridgeRepository.delete(cartridge);
    }

    @Override
    public boolean isExistCartridgeUniqIdentify(Cartridge checkingCartridge) {
        Cartridge existingCartridge = cartridgeRepository.findByUniqueIdentify(checkingCartridge.getUniqueIdentify());

        if(checkingCartridge.getId() == null){
            return existingCartridge != null;
        }

        if(existingCartridge == null){
            return false;
        }else{
            return existingCartridge.getId() != checkingCartridge.getId();
        }

    }

    @Override
    public void updateFields(Cartridge oldCartridge, Cartridge newCartridge) {
        oldCartridge.setModel(newCartridge.getModel());
        oldCartridge.setClient(newCartridge.getClient());
        oldCartridge.setDescription(newCartridge.getDescription());
    }

    public String generateUniqueIdentify(){
        List<Cartridge> sortedCartridges = cartridgeRepository.findAll().stream()
                .sorted(Comparator.comparing(Cartridge::getUniqueIdentify)).collect(Collectors.toList());

        if (sortedCartridges.isEmpty()) {
            return START_UNIQUE_IDENTIFY_NUMBER;
        }

        int lastCartridgesIndex = sortedCartridges.size() - 1;

        String lastUniqIdentifyStr = sortedCartridges.get(lastCartridgesIndex).getUniqueIdentify();

        lastGeneratedUniqueIdentifyNumber = Integer.parseInt(lastUniqIdentifyStr.substring(1));

        return "B" + ++lastGeneratedUniqueIdentifyNumber;
    }

}
