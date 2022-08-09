package org.eustrosoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import java.io.Serializable;

public abstract class DBObject implements IDBObject, Serializable {
    @Column(name = "ZOID")
    private Long ZOID;
    @Column(name = "ZRID")
    private Long ZRID;
    @Column(name = "ZPID")
    private Long ZPID;
    @Column(name = "ZTYPE")
    private Character ZTYPE;

    @JsonIgnore
    @Override
    public Long getZOID() {
        return this.ZOID;
    }

    @JsonIgnore
    @Override
    public Long getZRID() {
        return this.ZRID;
    }

    @JsonIgnore
    @Override
    public Long getZPID() {
        return this.ZPID;
    }

    @JsonIgnore
    @Override
    public Character getZTYPE() {
        return this.ZTYPE;
    }
}
