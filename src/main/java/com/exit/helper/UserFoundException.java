package com.exit.helper;

/*
    This is a self created UserAlreadyFound Exception class
 */
public class UserFoundException extends Exception {

    public UserFoundException()
    {
        super(("user with this name is already present in DB !! try with another one"));
    }
    public UserFoundException(String msg)
    {
        super(msg);
    }
}
