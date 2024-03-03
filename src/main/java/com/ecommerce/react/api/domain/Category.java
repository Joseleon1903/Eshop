package com.ecommerce.react.api.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String color;

    private String icon;

    @OneToOne(cascade = CascadeType.ALL)
    private Image imageId;

}
