package org.eustrosoft.service;

import lombok.RequiredArgsConstructor;
import org.eustrosoft.core.model.DBFile;
import org.eustrosoft.core.service.FileContainerService;
import org.eustrosoft.dao.ProductDAO;
import org.eustrosoft.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequestScope
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private FileContainerService fileContainerService;
    @Autowired
    private ProductDAO productDAO;

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        productDAO.findAll().forEach(products::add);
        return products;
    }

    public Product getById(Long id) {
        Optional<Product> productOptional = productDAO.findById(id);
        return productOptional.orElse(null);
    }

    public byte[] getImage(Long id) {
        Product product = getById(id);
        if (product == null) {
            return new byte[0];
        }
        DBFile dbFile = fileContainerService.getById(product.getImage());
        if (dbFile.getFileId() != null) {
            return fileContainerService.getFileByFileId(dbFile.getFileId());
        }
        return new byte[0];
    }
}
