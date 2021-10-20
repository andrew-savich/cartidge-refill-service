package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.ModelTitleExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Model;
import com.andrewsavich.bajter.cartridgerefillservice.service.model.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/model")
@Slf4j
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/all")
    public List<Model> getModelList(){
        return modelService.getAllModels();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable Long id){
        Model model = modelService.getModelById(id);

        return ResponseEntity.ok(model);
    }

    @PostMapping("/create")
    public void createModel(@RequestBody Model model){

        if(modelService.isExistModelTitle(model)){
            throw new ModelTitleExistsException("Model with title '" + model.getTitle() + "' already exist");
        }

        modelService.saveModel(model);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Model> updateModel(@RequestBody Model changedModel, @PathVariable Long id){
        Model model = modelService.getModelById(id);
        modelService.updateFields(model, changedModel);

        if(modelService.isExistModelTitle(model)){
            throw new ModelTitleExistsException("Model with title '" + model.getTitle() + "' already exist");
        }

        Model updatedModel = modelService.saveModel(model);

        return ResponseEntity.ok(updatedModel);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteModel(@PathVariable Long id){
        Model model = modelService.getModelById(id);
        modelService.deleteModel(model);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", true);

        return ResponseEntity.ok(response);
    }
}
