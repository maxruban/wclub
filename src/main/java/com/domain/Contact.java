package com.domain;

import com.domain.enums.TypeOfContact;
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
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue
    @Column(name = "contact_id")
    int id;

    String number;

    @Enumerated(EnumType.STRING)
    TypeOfContact type;

}
