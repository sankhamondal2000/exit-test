package com.exit.service.impl;

import com.exit.model.Pincode;
import com.exit.repository.PincodeRepository;
import com.exit.service.PincodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    Implement class of PincodeService
 */
@Service
public class PincodeServiceImpl implements PincodeService {

    @Autowired
    private PincodeRepository pincodeRepository;

    /*
        This will find the pincode from database
     */
    @Override
    public Pincode getPincode(Long pincode) {

        Pincode pinObj=pincodeRepository.findByPincode(pincode);

        return pinObj;
    }
}
