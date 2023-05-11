package com.exit.controller;


import com.exit.model.User;
import com.exit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/*
    This controller is used for perform all user related operation like get user, delete user, update user, get all user
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*
        This method is used for create new user
     */
    @PostMapping("/")
    public User createUser(@RequestBody User user)
    {
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("NORMAL");
        return this.userService.createUser(user);
    }

    /*
        This method is used to get a single user by username
     */
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username)
    {
        return this.userService.getUser(username);
    }


    /*
        This method is used fo delete the user by userId
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id")Long id)
    {
        this.userService.deleteUser(id);
    }

    /*
        This method is used to update the user by username
     */
    @PutMapping("/{username}")
    public User updateUser(@PathVariable("username")String username, @RequestBody User user)
    {
        return this.userService.updateUser(username,user);
    }

}
