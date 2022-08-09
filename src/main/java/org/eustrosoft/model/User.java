package org.eustrosoft.model;

import javax.persistence.*;

@Entity
@Table(name = "samusers", schema = "tis")
public class User extends DBObject {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "db_user")
    private String user;
    @Column(name = "name")
    private String name;

    public User() {
    }

    public User(String user, String name) {
        this.user = user;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
