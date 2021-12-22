package com.domain;

import com.domain.enums.City;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "addresses")
@EqualsAndHashCode
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    int id;

    boolean priority;

    @Enumerated(EnumType.STRING)
    City city;


    String street;


    String building;


    String apartment;


    @Column(name = "special_information")
    String specialInformation;

}
