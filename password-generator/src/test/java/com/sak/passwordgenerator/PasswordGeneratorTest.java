package com.sak.passwordgenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PasswordGeneratorTest {

    private PasswordValidator passwordValidator;
    private PasswordGenerator passwordGenerator;

    @Before
    public void setUp() {
        this.passwordValidator = new PasswordValidatorImpl();
        this.passwordGenerator = new RandomPasswordGenerator(passwordValidator);
    }

    @Test
    public void givenPasswordGenerator_WhenGenerateRandomPassword_ThenGenerateValidRandomPassword() {
        for (int i = 1; i <= 50; i++) {
            String password = passwordGenerator.generateRandomPassword();
            System.out.printf("Password Sample | %2d | \'%s\'\n", i, password);
            Assert.assertTrue(password, this.passwordValidator.isMatchesTheRequestedLength(password));
            Assert.assertTrue(password, this.passwordValidator.isPasswordMatchesTheRequirements(password));
        }
    }
}