package com.example.mymvc;

public class CorrectFixedPasswordGenerator implements PasswordGenerator{
    @Override
    public String generatorPassword() {
        return "abcdefgh"; // 8글자
    }
}
