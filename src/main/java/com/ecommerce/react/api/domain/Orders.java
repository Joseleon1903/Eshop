package com.ecommerce.react.api.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String serialId;

    private LocalDateTime createdDate;

    private String shippingAddress;

    private String zip;

    private String city;

    private String country;

    @OneToMany
    private OrderItem[] orderItems;

    @OneToOne
    private AppUser appUser;


}
