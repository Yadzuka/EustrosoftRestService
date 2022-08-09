package org.eustrosoft.dto;

import org.eustrosoft.model.User;

public class UserDTO {
    private Long id;
    private String user;
    private String name;

    public UserDTO(User original) {
        setId(original.getId());
        setName(original.getName());
        setUser(original.getUser());
    }

    public static UserDTO from(User original) {
        return new UserDTO(original);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
