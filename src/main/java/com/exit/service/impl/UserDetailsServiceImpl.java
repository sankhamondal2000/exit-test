package com.exit.service.impl;

import com.exit.model.User;
import com.exit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
    UserDetailsService implementation class
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /*
        This method is fetch the user by username
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(username);
        if (user==null)
        {
            System.out.println("User Not Found !!");
            throw new UsernameNotFoundException("no user found");
        }
        return user;
    }
}
