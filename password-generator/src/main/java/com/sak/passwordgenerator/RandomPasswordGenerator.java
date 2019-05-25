package com.sak.passwordgenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomPasswordGenerator implements PasswordGenerator {

    private final PasswordValidator passwordValidator;

    public RandomPasswordGenerator(PasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }

    public String generateRandomPassword() {
        final String preparedRandomPassword = new StringBuilder(generateLetters())
                .append(generateDigits())
                .append(generateSpecialCharacters()).toString();

        return shuffleUntilRandomPasswordMatchesRequirements(preparedRandomPassword);
    }

    private String shuffleUntilRandomPasswordMatchesRequirements(String password) {
        while (!passwordValidator.isPasswordMatchesTheRequirements(password))
            password = shuffleString(password);
        return password;
    }

    private String generateSpecialCharacters() {
        final int REQUESTED_SPECIAL_CHARACTERS_LENGTH = 2;
        final String specialCharacters = "$%_@";
        return shuffleString(specialCharacters)
                .substring(0, REQUESTED_SPECIAL_CHARACTERS_LENGTH);
    }

    private String generateDigits() {
        final int REQUESTED_DIGITS_LENGTH = 3;
        final String digits = "0123456789";
        return shuffleString(digits)
                .substring(0, REQUESTED_DIGITS_LENGTH);
    }

    private String generateLetters() {
        final int REQUESTED_LETTERS_LENGTH = 4;
        final String letters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder requestedLetters = new StringBuilder(shuffleString(letters)
                .substring(0, REQUESTED_LETTERS_LENGTH));
        int pickingPositionType = (int) (Math.random() * 2); // [odd-even] position.

        for (int i = 0; i < requestedLetters.length(); i++) {
            if (i % 2 == pickingPositionType) { //once convert odd once convert even.
                String currentCharacter = toUpperCase(requestedLetters, i);
                requestedLetters.replace(i, i + 1, currentCharacter);
            }
        }
        return shuffleString(requestedLetters.toString());
    }

    private String shuffleString(String str) {
        List<Character> characters = new ArrayList<>();

        for (char c : str.toCharArray()) characters.add(c);

        Collections.shuffle(characters);

        final StringBuilder shuffledString = new StringBuilder(str.length());
        for (int i = 0; i < characters.size(); i++) {
            shuffledString.append(characters.get(i));
        }
        return shuffledString.toString();
    }

    private String toUpperCase(StringBuilder requestedLetters, int i) {
        return String.valueOf(Character.toUpperCase(requestedLetters.charAt(i)));
    }
}