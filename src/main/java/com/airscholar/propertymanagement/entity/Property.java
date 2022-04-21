package com.airscholar.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "Property_Title", nullable = false)
    private String title;
    private String description;
    private String ownerName;
    @Column(name = "Email", nullable = false)
    private String ownerEmail;
    private Double price;
    private String address;
}
