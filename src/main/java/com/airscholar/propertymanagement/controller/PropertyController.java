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
    private ResponseEntity createProperty(@RequestBody() PropertyDTO propertyDTO) {
        Property response = this.propertyService.createProperty(propertyDTO);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    private ResponseEntity getAllProperties() {
        List<Property> response = this.propertyService.getAllProperties();

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/properties/{id}")
    private ResponseEntity getAllProperties(@PathVariable Long id) {
        Property response = this.propertyService.getPropertyById(id);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("/properties/{id}")
    private ResponseEntity UpdateProperty(@PathVariable("id") Long Id, @RequestBody() PropertyDTO propertyDTO){
        Property response = this.propertyService.updateProperty(Id, propertyDTO);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/properties/{id}")
    private ResponseEntity DeleteProperty(@PathVariable("id") Long Id){
        this.propertyService.deleteProperty(Id);

        return new ResponseEntity("Property deleted successfully!", HttpStatus.OK);
    }
}
