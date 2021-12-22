package com.domain;

import com.domain.enums.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_preferences")
@EqualsAndHashCode
public class ProductPreference {

    @Id
    @GeneratedValue
    @Column(name = "preference_id")
    int id;

    @OneToOne
    @JoinColumn(name = "FK_USER_ID")
    User user;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate created;

    @ElementCollection(targetClass = ProductType.class)
    @CollectionTable(name = "types")
    @Enumerated(EnumType.STRING)
    List<ProductType> types;

    @ElementCollection(targetClass = Color.class)
    @CollectionTable(name = "color")
    @Enumerated(EnumType.STRING)
    List<Color> color;

    @ElementCollection(targetClass = Sweetness.class)
    @CollectionTable(name = "sweetness")
    @Enumerated(EnumType.STRING)
    List<Sweetness> sweetness;

    @ElementCollection(targetClass = Acidity.class)
    @CollectionTable(name = "acidity")
    @Enumerated(EnumType.STRING)
    List<Acidity> acidity;

    @ElementCollection(targetClass = Alcohol.class)
    @CollectionTable(name = "alcohol")
    @Enumerated(EnumType.STRING)
    List<Alcohol> alcohol;

    @ElementCollection(targetClass = Body.class)
    @CollectionTable(name = "body")
    @Enumerated(EnumType.STRING)
    List<Body> body;

    @ElementCollection(targetClass = Tannin.class)
    @CollectionTable(name = "tannin")
    @Enumerated(EnumType.STRING)
    List<Tannin> tannin;
}
