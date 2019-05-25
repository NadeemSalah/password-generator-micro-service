package com.sak.passwordgenerator;

public class PasswordValidatorImpl implements PasswordValidator {

    private final int REQUESTED_PASSWORD_LENGTH = 9;
    private final int REQUESTED_LETTERS_LENGTH = 4;
    private final int REQUESTED_DIGITS_LENGTH = 3;
    private final int REQUESTED_SPECIAL_CHARACTERS_LENGTH = 2;
    private CharactersGroupSequenceCalculator sequenceCalculator;

    private static boolean isSpecialCharacter(final char c) {
        return (c == '$' || c == '%' || c == '_' || c == '@');
    }

    public boolean isPasswordMatchesTheRequirements(String password) {
        int validityCounter = 0;

        this.sequenceCalculator = Character::isLetter; // letters case
        if (sequenceCalculator
                .calcCharactersGroupSequence(password, REQUESTED_LETTERS_LENGTH) == REQUESTED_LETTERS_LENGTH) {
            validityCounter++;
        }

        this.sequenceCalculator = Character::isDigit; // digits case
        if (sequenceCalculator
                .calcCharactersGroupSequence(password, REQUESTED_DIGITS_LENGTH) == REQUESTED_DIGITS_LENGTH) {
            validityCounter++;
        }

        this.sequenceCalculator = PasswordValidatorImpl::isSpecialCharacter; // special chars case

        if (sequenceCalculator
                .calcCharactersGroupSequence(password, REQUESTED_SPECIAL_CHARACTERS_LENGTH) == REQUESTED_SPECIAL_CHARACTERS_LENGTH) {
            validityCounter++;
        }

        return validityCounter < 2; // doesn't contain multiple sequential groups.
    }

    public boolean isMatchesTheRequestedLength(String password) {
        return password.length() == REQUESTED_PASSWORD_LENGTH;
    }
}
