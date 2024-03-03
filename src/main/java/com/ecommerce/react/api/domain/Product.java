package com.ecommerce.react.api.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Image imageId;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductDetail productDetail;

    @OneToOne(cascade = CascadeType.ALL)
    private Category category;

    private String status;

    public Product(Long id, String name, String description, Image imageId, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageId = imageId;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageId=" + imageId +
                ", productDetail=" + productDetail +
                ", category=" + category +
                ", status='" + status + '\'' +
                '}';
    }
}
