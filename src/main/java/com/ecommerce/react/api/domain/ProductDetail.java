package com.ecommerce.react.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class ProductDetail {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private BigDecimal price;

    private Integer discount;

    private String brand;

    private Integer countInStock;

    private LocalDateTime createdDate;

    private Integer rate;

    public ProductDetail(Long id, String description, BigDecimal price, Integer discount, Integer rate) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", rate=" + rate +
                '}';
    }
}
