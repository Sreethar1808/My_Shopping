package com.My_Shopping.My_Shopping.expections;

public class UnAutherized extends RuntimeException{
    public UnAutherized (String message)
    {
        super(message);
    }
}
