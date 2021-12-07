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
    void deleteModel(Model model);
    boolean isExistModelTitle(Model model);
    void updateFields(Model oldModel, Model newModel);
    List<Color> getAllColors();
    List<Type> getAllTypes();
}
