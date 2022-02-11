package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.ModelTitleExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Color;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Model;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Type;
import com.andrewsavich.bajter.cartridgerefillservice.service.model.ModelService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/models", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<Model> getModelList() {
        return modelService.getAllModels();
    }

    @GetMapping("/{modelId}")
    public ResponseEntity<Model> getModelById(@PathVariable Long modelId) {
        Model model = modelService.getModelById(modelId);

        return ResponseEntity.ok(model);
    }

    @GetMapping("/title/{modelTitle}")
    public ResponseEntity<Model> getModelByTitle(@PathVariable String modelTitle) {
        Model model = modelService.getModelByTitle(modelTitle);

        return ResponseEntity.ok(model);
    }

    @GetMapping("/colors")
    public List<Color> getColors() {
        return modelService.getAllColors();
    }

    @GetMapping("/types")
    public List<Type> getTypes() {
        return modelService.getAllTypes();
    }

    @PostMapping
    public void createModel(@RequestBody @Valid Model model) {
        if (modelService.isExistModelTitle(model)) {
            throw new ModelTitleExistsException("Model with title '" + model.getTitle() + "' already exist");
        }

        modelService.createModel(model);
    }

    @PutMapping
    public void updateModel(@RequestBody Model model) {
        if (modelService.isExistModelTitle(model)) {
            throw new ModelTitleExistsException("Model with title '" + model.getTitle() + "' already exist");
        }

        modelService.updateModel(model);
    }

    @DeleteMapping("/{modelId}")
    public void deleteModel(@PathVariable Long modelId) {
        modelService.deleteModelById(modelId);
    }
}
