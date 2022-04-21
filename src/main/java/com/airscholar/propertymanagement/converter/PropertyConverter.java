package com.airscholar.propertymanagement.converter;

import com.airscholar.propertymanagement.dto.PropertyDTO;
import com.airscholar.propertymanagement.entity.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public Property converToEntity(PropertyDTO propertyDTO){
        Property property = new Property();
        property.setTitle(propertyDTO.getTitle());
        property.setAddress(propertyDTO.getAddress());
        property.setOwnerName(propertyDTO.getOwnerName());
        property.setOwnerEmail(propertyDTO.getOwnerEmail());
        property.setDescription(propertyDTO.getDescription());
        property.setPrice(propertyDTO.getPrice());

        return property;
    }
}
