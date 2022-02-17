package com.andrewsavich.bajter.cartridgerefillservice.service.cartridge;

import com.andrewsavich.bajter.cartridgerefillservice.exception.cartridge.CartridgeNotFoundException;
import com.andrewsavich.bajter.cartridgerefillservice.exception.cartridge.CartridgeUniqueIdentifyException;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Cartridge;
import com.andrewsavich.bajter.cartridgerefillservice.repository.CartridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CartridgeServiceImpl implements CartridgeService {

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
        Cartridge cartridge = cartridgeRepository.findById(id).orElse(null);

        if (Objects.isNull(cartridge)) {
            throw new CartridgeNotFoundException("Cartridge with id '" + id + "' not found");
        }

        return cartridge;
    }

    @Override
    public Cartridge getCartridgeByUniqueIdentify(String uniqueIdentify) {
        Cartridge cartridge = cartridgeRepository.findByUniqueIdentify(uniqueIdentify);

        if (Objects.isNull(cartridge)) {
            throw new CartridgeNotFoundException("Cartridge with uniqueIdentify '" + uniqueIdentify + "' not found");
        }

        return cartridge;
    }

    @Override
    public Cartridge saveCartridge(Cartridge cartridge) {

        if (isExistCartridgeUniqIdentify(cartridge)) {
            throw new CartridgeUniqueIdentifyException("Cartridge with unique identify ' " + cartridge.getUniqueIdentify() + "' exists");
        }

        if (Objects.isNull(cartridge.getUniqueIdentify())) {
            cartridge.setUniqueIdentify(generateUniqueIdentify());
            cartridge.setAddedDate(new Date());
        }

        return cartridgeRepository.save(cartridge);
    }

    @Override
    public void deleteCartridgeById(Long id) {
        Cartridge cartridge = cartridgeRepository.findById(id).orElse(null);

        if (Objects.isNull(cartridge)) {
            throw new CartridgeNotFoundException("Cartridge with id '" + id + "' not found");
        }

        cartridgeRepository.delete(cartridge);
    }


    private boolean isExistCartridgeUniqIdentify(Cartridge checkingCartridge) {
        Cartridge existingCartridge = cartridgeRepository.findByUniqueIdentify(checkingCartridge.getUniqueIdentify());

        if (checkingCartridge.getId() == null) {
            return existingCartridge != null;
        }

        if (existingCartridge == null) {
            return false;
        } else {
            return existingCartridge.getId() != checkingCartridge.getId();
        }

    }

    private String generateUniqueIdentify() {
        List<Cartridge> sortedCartridges = cartridgeRepository.findAll().stream().sorted(Comparator.comparing(Cartridge::getUniqueIdentify)).collect(Collectors.toList());

        if (sortedCartridges.isEmpty()) {
            return START_UNIQUE_IDENTIFY_NUMBER;
        }

        int lastCartridgesIndex = sortedCartridges.size() - 1;

        String lastUniqIdentifyStr = sortedCartridges.get(lastCartridgesIndex).getUniqueIdentify();

        lastGeneratedUniqueIdentifyNumber = Integer.parseInt(lastUniqIdentifyStr.substring(1));
        ++lastGeneratedUniqueIdentifyNumber;

        return "B" + lastGeneratedUniqueIdentifyNumber;
    }

}
