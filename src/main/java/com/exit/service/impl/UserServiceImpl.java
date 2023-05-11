package com.exit.service.impl;

import com.exit.model.User;
import com.exit.repository.UserRepository;
import com.exit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    UserService implementation class
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /*
        create new user
     */
    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    /*
        get user by username
     */
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    /*
        delete user by userId
     */
    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
    /*
        update user by username
     */
    @Override
    public User updateUser(String username, User user) {

        User user1 = new User();
        user1 = this.userRepository.findByUsername(username);
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setRole(user.getRole());
        return this.userRepository.save(user1);
    }
}
