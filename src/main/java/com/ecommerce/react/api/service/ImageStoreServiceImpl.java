package com.ecommerce.react.api.service;

import com.ecommerce.react.api.domain.Image;
import com.ecommerce.react.api.repository.ImageRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageStoreServiceImpl implements ImageStoreService{

    private static Logger logger = LogManager.getLogger(ImageStoreService.class);

    private final ImageRepository imageRepository;

    @Autowired
    public ImageStoreServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image storeImage(Image imag) {
        logger.info("Entering in storeImage");
        logger.info("param : "+ imag );
        Image img = imageRepository.save(imag);
        logger.info("Stored : "+ imag );
        return img;
    }

    @Override
    public Optional<Image> getImageById(Long id) {
        logger.info("Entering in getImageById");
        Image img = imageRepository.findById(id).get();
        return Optional.of(img);
    }
}
