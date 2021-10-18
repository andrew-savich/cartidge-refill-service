package com.andrewsavich.bajter.cartridgerefillservice.service.model;

import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Model;
import com.andrewsavich.bajter.cartridgerefillservice.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService{

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public Model getModelById(Long id) {
        return modelRepository.findById(id).get();
    }

    @Override
    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public void deleteModel(Model model) {
        modelRepository.delete(model);
    }

    @Override
    public boolean isExistModelTitle(Model checkingModel) {
        Model existingModel = modelRepository.findByTitle(checkingModel.getTitle());

        //case for the creating a new checkingModel without existing same title in the DB
        if(checkingModel.getId() == null){
            return existingModel != null;
        }

        //case for the updating existing checkingModel
        if(existingModel == null){
            return false;
        } else{
            return existingModel.getId() != checkingModel.getId();
        }

    }
}
