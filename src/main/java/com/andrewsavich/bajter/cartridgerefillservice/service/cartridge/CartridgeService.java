package com.andrewsavich.bajter.cartridgerefillservice.service.cartridge;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Cartridge;

import java.util.List;

public interface CartridgeService {
    List<Cartridge> getAllCartridges();

    Cartridge getCartridgeById(Long id);

    Cartridge getCartridgeByUniqueIdentify(String uniqueIdentify);

    Cartridge saveCartridge(Cartridge cartridge);

    void deleteCartridgeById(Long id);

}
