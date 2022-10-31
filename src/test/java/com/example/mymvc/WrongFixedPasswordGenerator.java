package com.example.mymvc;

public class WrongFixedPasswordGenerator implements PasswordGenerator{
    @Override
    public String generatorPassword() {
        return "ab"; // 8글자
    }
}
