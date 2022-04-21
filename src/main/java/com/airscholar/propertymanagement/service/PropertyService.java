package com.airscholar.propertymanagement.service;

import com.airscholar.propertymanagement.dto.PropertyDTO;
import com.airscholar.propertymanagement.entity.Property;

public interface PropertyService {

    public Property createProperty(PropertyDTO propertyDTO);

}
