package com.matyashdo.creditDetails_ws.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ValidationUtilsTest {

    private static final String PESEL_VALID = "12345678901";
    private static final String PESEL_NOT_VALID = "123456789";
    private static final String PESEL_NOT_NUMERIC = "qwertyuiopa";

    private ValidationUtils validationUtils = new ValidationUtils();

    @Test
    public void testPeselIsValidReturnsFalseWhenWrongPeselLength() {
        boolean isValid = validationUtils.peselIsValid(PESEL_NOT_VALID);
        Assert.assertFalse(isValid);
    }

    @Test
    public void testPeselIsValidReturnsFalseWhenPeselIsNotNumeric() {
        boolean isValid = validationUtils.peselIsValid(PESEL_NOT_NUMERIC);
        Assert.assertFalse(isValid);
    }

    @Test
    public void testPeselIsValidReturnsTrue() {
        boolean isValid = validationUtils.peselIsValid(PESEL_VALID);
        Assert.assertTrue(isValid);
    }
}