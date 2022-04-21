package com.airscholar.propertymanagement.controller;

import com.airscholar.propertymanagement.dto.PropertyDTO;
import com.airscholar.propertymanagement.entity.Property;
import com.airscholar.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }


    @PostMapping("/properties")
    private ResponseEntity<Property> createProperty(@RequestBody() PropertyDTO propertyDTO) {
        Property response = this.propertyService.createProperty(propertyDTO);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    private ResponseEntity<List<Property>> getAllProperties() {
        List<Property> response = this.propertyService.getAllProperties();

        return new ResponseEntity<List<Property>>(response, HttpStatus.OK);
    }
}
