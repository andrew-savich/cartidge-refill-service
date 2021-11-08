package com.andrewsavich.bajter.cartridgerefillservice.service.cartridge;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Cartridge;

import java.util.List;

public interface CartridgeService {
    List<Cartridge> getAllCartridges();
    Cartridge getCartridgeById(Long id);
    Cartridge getCartridgeUniqueIdentify(String uniqueIdentify);
    Cartridge saveCartridge(Cartridge cartridge);
    void deleteCartridge(Cartridge cartridge);
    boolean isExistCartridgeUniqIdentify(Cartridge checkingCartridge);
    void updateFields(Cartridge oldCartridge, Cartridge newCartridge);
}
