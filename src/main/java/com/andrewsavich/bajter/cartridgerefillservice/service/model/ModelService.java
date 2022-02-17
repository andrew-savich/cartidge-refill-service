package com.andrewsavich.bajter.cartridgerefillservice.service.model;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Color;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Model;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Type;

import java.util.List;

public interface ModelService {
    List<Model> getAllModels();

    Model getModelById(Long id);

    Model getModelByTitle(String title);

    Model saveModel(Model model);

    void deleteModelById(Long id);

    List<Color> getAllColors();

    List<Type> getAllTypes();
}
