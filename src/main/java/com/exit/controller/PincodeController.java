package com.exit.controller;


import com.exit.model.Pincode;
import com.exit.service.PincodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/*
    Controller to check the pincode whether the product is deliverable or not
 */
@RestController
@RequestMapping("/checkservice")
@CrossOrigin("*")
public class PincodeController {

    @Autowired
    private PincodeService pincodeService;
    /*
        method to fetch the user defined pincode from url with pathvariable annotation
     */
    @GetMapping("/{pincode}")
    public ResponseEntity<Pincode> getProductByPincode(@PathVariable("pincode")Long pincode)
    {
        Pincode pin = this.pincodeService.getPincode(pincode);
        if (pin==null)
        {
            System.out.println("Pincode not found");
            /*
                It will return 500 internal server error if there is no pincode present in the database
             */
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        /*
            it will return true value if pincode is present in the database
         */
        return ResponseEntity.of(Optional.of(pin));
    }
}
