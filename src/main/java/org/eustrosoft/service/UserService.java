package org.eustrosoft.service;

import lombok.RequiredArgsConstructor;
import org.eustrosoft.dao.UserDAO;
import org.eustrosoft.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequestScope
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Iterable<User> userIterable = userDAO.findAll();
        userIterable.forEach(userList::add);
        return userList;
    }

    public User getById(Long id) {
        Optional<User> userOptional = userDAO.findById(id);
        return userOptional.orElse(null);
    }

    public void createUser(String user, String name) {
        User newUser = new User(user, name);
        userDAO.save(newUser);
    }

    public void createUser(User user) {
        userDAO.save(user);
    }
}
