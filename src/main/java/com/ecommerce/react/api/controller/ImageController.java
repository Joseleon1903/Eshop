package com.ecommerce.react.api.controller;

import com.ecommerce.react.api.domain.Image;
import com.ecommerce.react.api.domain.Product;
import com.ecommerce.react.api.service.ImageStoreService;
import com.ecommerce.react.api.service.ProductService;
import com.ecommerce.react.api.util.ConstantUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value= "/api/v0.1/image")
public class ImageController {

    private static Logger logger = LogManager.getLogger(ImageController.class);

    private final ImageStoreService imageStoreService;

    private final ProductService productService;

    @Autowired
    public ImageController(ImageStoreService imageStoreService, ProductService productService) {
        this.imageStoreService = imageStoreService;
        this.productService = productService;
    }

    @PostMapping("/upload/{productId}")
    public ResponseEntity uploadImage(@PathVariable("productId") Long productId, @RequestParam("file") MultipartFile file) {
        logger.info("Entering in uploadFile");

        logger.info("Find product...");
        Product prod = productService.findProduct(productId).get();
        logger.info("product found : "+ prod);

        try {
            Image img = new Image();
            img.setName(file.getName());
            img.setContentType(file.getContentType());
            img.setOriginalFileName(img.getOriginalFileName());
            img.setImagedt(file.getBytes());
            img.setImageSize(ConstantUtil.humanReadableByteCountSI(file.getSize()));
            img.setSizeType(ConstantUtil.IMAGE_SIZE_TYPE);
            img.setLength(file.getSize());
            logger.info("Store image product...");
            Image result = imageStoreService.storeImage(img);
            logger.info("returning "+ result);
            prod.setImageId(result);
            productService.updateProduct(prod);

            return ResponseEntity.ok(result);

        }catch (IOException e) {
            logger.error("Error: "+ e.getMessage());
            return ResponseEntity.ok("Error trye to convert image");
        }
    }

    @GetMapping(value = "/view/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> viewFile(@PathVariable("id") Long id) {
        logger.info("Entering in uploadFile");

        String contentType = "application/octet-stream";
        logger.info("contentType : "+contentType);
        Image img = imageStoreService.getImageById(id).get();
        InputStream streamIn = new ByteArrayInputStream(img.getImagedt());
        return ResponseEntity.ok()
                .contentLength(img.getImagedt().length)
                .contentType(MediaType.parseMediaType( MediaType.IMAGE_JPEG_VALUE))
                .body(new InputStreamResource(streamIn));
    }


}
