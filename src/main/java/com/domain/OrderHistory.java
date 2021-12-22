package com.domain;

import com.domain.enums.OrderStatus;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "order_history")
public class OrderHistory {

    @Id
    @GeneratedValue
    @Column(name = "order_history_id")
    int id;

    @ManyToOne()
    @JoinColumn(name = "FK_ORDER_ID")
    Order order;

    @Enumerated(EnumType.STRING)
    OrderStatus status;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate date;

    public OrderHistory(Order order) {
        this.order = order;
    }
}
