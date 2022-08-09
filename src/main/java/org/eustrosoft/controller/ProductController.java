package org.eustrosoft.controller;

import org.eustrosoft.core.service.FileContainerService;
import org.eustrosoft.dto.ProductDTO;
import org.eustrosoft.model.Product;
import org.eustrosoft.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private FileContainerService fileContainerService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable("id") Long id) {
        Product product = productService.getById(id);
        ProductDTO dto = ProductDTO.from(product);
        dto.setImage(fileContainerService.getById(product.getImage()));
        dto.setManual(fileContainerService.getById(product.getManual())); // TODO: create it better way!!!
        return dto;
    }


    @GetMapping("/products/{id}/image")
    public HttpEntity<byte[]> getImage(@PathVariable("id") Long id) { // TODO: create service
        byte[] documentBody = productService.getImage(id);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + System.currentTimeMillis() + ".csv");
        header.setContentLength(documentBody.length);
        return new HttpEntity<>(documentBody, header);
    }
}
