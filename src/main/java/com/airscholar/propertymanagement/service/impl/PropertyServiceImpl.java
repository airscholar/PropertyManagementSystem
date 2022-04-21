package com.airscholar.propertymanagement.service.impl;

import com.airscholar.propertymanagement.converter.PropertyConverter;
import com.airscholar.propertymanagement.dto.PropertyDTO;
import com.airscholar.propertymanagement.entity.Property;
import com.airscholar.propertymanagement.repository.PropertyRepository;
import com.airscholar.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final PropertyConverter propertyConverter;

    @Autowired
    public PropertyServiceImpl(PropertyConverter propertyConverter, PropertyRepository propertyRepository) {
        this.propertyConverter = propertyConverter;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property createProperty(PropertyDTO propertyDTO) {
        Property property = this.propertyConverter.converToEntity(propertyDTO);
        property = this.propertyRepository.save(property);

        return property ;
    }

    @Override
    public List<Property> getAllProperties() {
        return (List<Property>) this.propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(Long id) {
        Optional<Property> property = this.propertyRepository.findById(id);
        return property.orElse(null);
    }

    @Override
    public Property updateProperty(Long id, PropertyDTO propertyDTO) {
        Property property = this.getPropertyById(id);
        if(property != null){
            Property propEntity = this.propertyConverter.converToEntity(propertyDTO);
            propEntity.setId(property.getId());

            property = this.propertyRepository.save(propEntity);
        }

        return property;
    }

    @Override
    public void deleteProperty(Long id) {
        Property property = this.getPropertyById(id);
        if(property != null){
            this.propertyRepository.delete(property);
        }
    }
}
