package com.domain;

import com.domain.enums.Country;
import jdk.jfr.Enabled;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "producers")
public class Producer {

    @Id
    @GeneratedValue
    @Column(name = "producer_id")
    int id;

    String name;

    @Enumerated(EnumType.STRING)
    Country country;

    @Column(length = 1000)
    String description;

}
