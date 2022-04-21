package com.airscholar.propertymanagement.controller;

import com.airscholar.propertymanagement.dto.PropertyDTO;
import com.airscholar.propertymanagement.entity.Property;
import com.airscholar.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/properties")
    private Property createProperty(@RequestBody()PropertyDTO propertyDTO){
        Property response = this.propertyService.createProperty(propertyDTO);

        return response;
    }
}
