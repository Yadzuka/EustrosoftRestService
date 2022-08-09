package org.eustrosoft.controller;

import org.eustrosoft.dto.UserCreationDTO;
import org.eustrosoft.dto.UserDTO;
import org.eustrosoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.findAll().stream()
                .map(UserDTO::from).collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    public UserDTO getUsers(@PathVariable("id") Long id) {
        return UserDTO.from(userService.getById(id));
    }

    @PostMapping("/users")
    public String createUser(@RequestBody UserCreationDTO dto) {
        userService.createUser(dto.toDbObject());
        return "User created";
    }
}
