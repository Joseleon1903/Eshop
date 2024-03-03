package com.ecommerce.react.api.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class AppUser implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String name;

    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    private ContactInfo contactInfo;

    private Boolean isAdmin;

    private String status;

}
