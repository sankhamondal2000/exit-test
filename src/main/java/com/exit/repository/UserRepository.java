package com.exit.repository;

import com.exit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    This repository will perform all user related operation
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
