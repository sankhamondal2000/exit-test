package com.exit.repository;

import com.exit.model.Pincode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    This is a repository which will fetch the pincode by the findByPincode method
 */
@Repository
public interface PincodeRepository extends JpaRepository<Pincode, Long> {
    public Pincode findByPincode(Long pincode);
}
