package com.matyashdo.creditDetails_ws.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ValidationUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationUtils.class);

    public boolean peselIsValid(String pesel) {
        if (pesel.length() == 11 && isNumeric(pesel)) {
            LOGGER.info("Pesel is valid");
            return true;
        }
        LOGGER.info("Pesel is not valid");
        return false;
    }

    private boolean isNumeric(String pesel) {
        try {
            Long.valueOf(pesel);
        } catch (NumberFormatException e) {
            LOGGER.error("Pesel is not numeric");
            return false;
        }
        return true;
    }
}
