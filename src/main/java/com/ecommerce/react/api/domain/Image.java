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
public class Image implements Serializable {

    @Id
    @GeneratedValue
    private long id;

   private String name;

   private String contentType;

   private String originalFileName;

   private String imageSize;

   private String sizeType;

   private Long length;

   private byte[] imagedt;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                ", originalFileName='" + originalFileName + '\'' +
                ", imageSize=" + imageSize +
                '}';
    }
}
