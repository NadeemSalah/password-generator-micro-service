package com.sak.passwordgenerator;

public interface PasswordValidator {

    boolean isPasswordMatchesTheRequirements(String password);

    boolean isMatchesTheRequestedLength(String password);
}
