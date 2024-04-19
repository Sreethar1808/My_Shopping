package com.My_Shopping.My_Shopping.expections;

public class MailNotSend extends RuntimeException{

    public MailNotSend(String message)
    {
        super(message);
    }
}
