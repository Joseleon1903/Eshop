package com.ecommerce.react.api.service;

import com.ecommerce.react.api.domain.Image;

import java.util.Optional;

public interface ImageStoreService {

    Image storeImage(Image imag);

    Optional<Image> getImageById(Long id);

}
