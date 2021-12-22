package com.domain;

import com.domain.enums.Discount;
import com.domain.enums.ExpertLevel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    int id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "middle_name")
    String middleName;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate dob;

    @Enumerated(EnumType.STRING)
    ExpertLevel expertLevel;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
    @JoinTable(name = "USER_ADDRESS",
            joinColumns = @JoinColumn(name = "FK_USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_ADDRESS_ID"))
    Set<Address> addresses;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
    @JoinTable(name = "USER_CONTACT",
            joinColumns = @JoinColumn(name = "FK_USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_CONTACT_ID"))
    Set<Contact> contacts;

    @Column(unique = true)
    String email;

    @ManyToMany
    @JoinTable(name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "FK_USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_ROLE_ID"))
    Set<Role> roles;

    String login;

    String password;

    @Enumerated(EnumType.STRING)
    Discount discount;

    @JsonProperty(value = "active")
    boolean isActive;

}
