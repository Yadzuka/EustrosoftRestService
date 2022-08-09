package org.eustrosoft.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products", schema = "tis")
public class Product extends DBObject implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "scope_id")
    private Long scopeId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "qr")
    private String qr;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "price")
    private String price;
    @Column(name = "image")
    private Long image;
    @Column(name = "manual")
    private Long manual;

    public Product() {
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

    public Long getImage() {
        return image;
    }

    public void setImage(Long image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getManual() {
        return manual;
    }

    public void setManual(Long manual) {
        this.manual = manual;
    }
}
