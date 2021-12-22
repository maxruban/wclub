package com.domain;

import com.domain.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    int id;

    @ManyToMany
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "FK_ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_PRODUCT_ID"))
    Set<Product> products;

    @ManyToOne
    @JoinColumn(name = "FK_USER_ID")
    User user;


    /**
     * Use either @JsonFormat or  @JsonDeserialize for deserialization object LocalDate from json
     * */

    @Column(name = "delivery_date")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate deliveryDate;

    BigDecimal total;

    @OneToOne
    @JoinColumn(name = "FK_ADDRESS_ID")
    Address deliveryAddress;

}
