package org.eustrosoft.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.eustrosoft.core.model.FileContainer;
import org.eustrosoft.model.Product;

import java.util.Date;

public class ProductDTO {
    @JsonIgnore
    private Long id;
    private Long scopeId;
    private Long userId;
    private String qr;
    private String name;
    private Date creationDate;
    private String price;
    private FileContainer image;
    private FileContainer manual;

    public ProductDTO(Product original) {
        setId(original.getId());
        setName(original.getName());
        setScopeId(original.getScopeId());
        setUserId(original.getUserId());
        setQr(original.getQr());
        setCreationDate(original.getCreationDate());
        setPrice(original.getPrice());
    }

    public static ProductDTO from(Product original) {
        return new ProductDTO(original);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScopeId() {
        return scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public FileContainer getImage() {
        return image;
    }

    public void setImage(FileContainer image) {
        this.image = image;
    }

    public FileContainer getManual() {
        return manual;
    }

    public void setManual(FileContainer manual) {
        this.manual = manual;
    }
}
