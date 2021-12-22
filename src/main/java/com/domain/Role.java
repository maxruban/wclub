package com.domain;
import com.domain.enums.Roles;
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
@Table(name = "roles")
@EqualsAndHashCode

public class Role {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    Roles role;
}
