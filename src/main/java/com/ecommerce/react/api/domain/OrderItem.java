package com.ecommerce.react.api.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private Integer Quantity;

    @OneToOne(fetch = FetchType.EAGER)
    private Product product;

}
