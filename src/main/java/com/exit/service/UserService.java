package com.exit.service;

import com.exit.model.User;

import java.util.Set;

/*
    this interface is fo all user related operation
 */
public interface UserService {

    public User createUser(User user);

    /*
        fetch user by username
     */
    public User getUser(String username);

    /*
        To delete a particular user
     */
    public void deleteUser(Long userId);

    /*
        update user by usernam
     */
    public User updateUser(String username, User user);


}
