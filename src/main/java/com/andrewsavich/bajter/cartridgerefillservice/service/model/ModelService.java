package com.andrewsavich.bajter.cartridgerefillservice.service.model;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Model;

import java.util.List;

public interface ModelService {
    List<Model> getAllModels();
    Model getModelById(Long id);
    Model saveModel(Model model);
    void deleteModel(Model model);
    boolean isExistModelTitle(Model model);
    void updateFields(Model oldModel, Model newModel);
}
