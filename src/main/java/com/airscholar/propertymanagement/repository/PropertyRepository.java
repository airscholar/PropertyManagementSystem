package com.airscholar.propertymanagement.repository;

import com.airscholar.propertymanagement.entity.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, Long> {
}
