package com.matyashdo.creditDetails_ws.utils;

import org.springframework.stereotype.Service;

@Service
public class ValidationUtils {

    public boolean peselIsValid(String pesel) {
        if (pesel.length() == 11 && isNumeric(pesel)) {
            return true;
        }
            return false;
    }

    private boolean isNumeric(String pesel) {
        try {
            Long.valueOf(pesel);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
