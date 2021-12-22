package com.domain;

import com.converter.YearConverter;
import com.domain.enums.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.YearDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Year;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "products")
@EqualsAndHashCode
/**
 * author
 */
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    int id;

    @Enumerated(EnumType.STRING)
    ProductType type;

    @ManyToOne
    @JoinColumn(name = "FK_PRODUCER_ID")
    Producer producer;

    String name;

    @Column(length = 1000)
    String description;

    @Column(name = "alc")
    String alcoholByVolume;

    @Enumerated(EnumType.STRING)
    Color color;

    @Enumerated(EnumType.STRING)
    Sweetness sweetness;

    @Enumerated(EnumType.STRING)
    Acidity acidity;

    @Column(name = "alcohol_level")
    @Enumerated(EnumType.STRING)
    Alcohol alcohol;

    @Enumerated(EnumType.STRING)
    Body body;

    @Enumerated(EnumType.STRING)
    Tannin tannin;

    String imageUrl;

    @Convert(converter = YearConverter.class)
    @JsonDeserialize(using = YearDeserializer.class)
    Year vintage;

    BigDecimal price1;

    BigDecimal price2;

    boolean available;
}
