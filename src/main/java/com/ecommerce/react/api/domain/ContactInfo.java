package com.ecommerce.react.api.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class ContactInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String street;

    private String apartment;

    private String city;

    private String zip;

    private String country;

    private String phoneNumber;

    private String secondPhoneNumber;

    public ContactInfo(Long id, String street, String apartment, String zip, String country, String phoneNumber, String secondPhoneNumber) {
        this.id = id;
        this.street = street;
        this.apartment = apartment;
        this.zip = zip;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", apartment='" + apartment + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", secondPhoneNumber='" + secondPhoneNumber + '\'' +
                '}';
    }
}
