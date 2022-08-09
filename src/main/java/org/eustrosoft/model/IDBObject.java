package org.eustrosoft.model;

import java.io.Serializable;

/**
 * Standard interface for all database objects
 */
public interface IDBObject extends Serializable {
    Long getZOID();

    Long getZRID();

    Long getZPID();

    Character getZTYPE();
}
