package com.airscholar.propertymanagement.service.impl;

import com.airscholar.propertymanagement.converter.PropertyConverter;
import com.airscholar.propertymanagement.dto.PropertyDTO;
import com.airscholar.propertymanagement.entity.Property;
import com.airscholar.propertymanagement.repository.PropertyRepository;
import com.airscholar.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
