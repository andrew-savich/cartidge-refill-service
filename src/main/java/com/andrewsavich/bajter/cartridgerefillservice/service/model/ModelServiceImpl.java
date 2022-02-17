package com.andrewsavich.bajter.cartridgerefillservice.service.model;

import com.andrewsavich.bajter.cartridgerefillservice.exception.model.ModelTitleExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.exception.model.ModelNotFoundException;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Color;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Model;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Type;
import com.andrewsavich.bajter.cartridgerefillservice.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public Model getModelById(Long id) {
        Model model = modelRepository.findById(id).orElse(null);

        if (Objects.isNull(model)) {
            throw new ModelNotFoundException("Model with id '" + id + "' not found");
        }

        return model;
    }

    @Override
    public Model getModelByTitle(String title) {
        Model model = modelRepository.findByTitle(title);

        if (Objects.isNull(model)) {
            throw new ModelNotFoundException("Model with title '" + title + "' not found");
        }

        return model;
    }

    @Override
    public Model saveModel(Model model) {

        if (isExistModelTitle(model)) {
            throw new ModelTitleExistsException("Model with title '" + model.getTitle() + "' exists");
        }

        return modelRepository.save(model);
    }

    @Override
    public void deleteModelById(Long id) {
        modelRepository.deleteById(id);
    }

    private boolean isExistModelTitle(Model checkingModel) {
        Model existingModel = modelRepository.findByTitle(checkingModel.getTitle());

        //case for the creating a new checkingModel without existing same title in the DB
        if (checkingModel.getId() == null) {
            return existingModel != null;
        }

        //case for the updating existing checkingModel
        if (existingModel == null) {
            return false;
        } else {
            return existingModel.getId() != checkingModel.getId();
        }

    }

    @Override
    public List<Color> getAllColors() {
        return Arrays.asList(Color.values());
    }

    @Override
    public List<Type> getAllTypes() {
        return Arrays.asList(Type.values());
    }
}
