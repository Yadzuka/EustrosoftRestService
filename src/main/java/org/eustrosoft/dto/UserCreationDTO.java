package org.eustrosoft.dto;

import org.eustrosoft.model.User;

public class UserCreationDTO {
    private String user;
    private String name;

    public UserCreationDTO(String user, String name) {
        this.user = user;
        this.name = name;
    }

    public UserCreationDTO(User original) {
        setName(original.getName());
        setUser(original.getUser());
    }

    public UserCreationDTO from(User original) {
        return new UserCreationDTO(original);
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

    public User toDbObject() {
        User user = new User();
        user.setUser(getUser());
        user.setName(getName());
        return user;
    }
}
