package com.airscholar.propertymanagement.service;

import com.airscholar.propertymanagement.dto.PropertyDTO;
import com.airscholar.propertymanagement.entity.Property;

import java.util.List;

public interface PropertyService {

    Property createProperty(PropertyDTO propertyDTO);
    List<Property> getAllProperties();

}
