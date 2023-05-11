package com.exit.helper;

/*
    This is a self created UserNotFound Exception class
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException()
    {
        super(("user with this name is not found in DB !! try with another one"));
    }
    public UserNotFoundException(String msg)
    {
        super(msg);
    }
}
