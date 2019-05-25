package com.sak.passwordgenerator;

@FunctionalInterface
public interface CharactersGroupSequenceCalculator {

    default int calcCharactersGroupSequence(String password, int charactersGroupLength) {
        int maxCharactersGroupSequence = 0;

        for (int i = 0; i < password.length() - (charactersGroupLength - 1); i++) {
            String pswrdSubstr = password.substring(i, charactersGroupLength + i);
            int charactersSequentially = 0;

            for (int j = 0; j < pswrdSubstr.length(); j++) {
                if (isCharacterOfType(pswrdSubstr.charAt(j)))
                    charactersSequentially++;
            }
            maxCharactersGroupSequence = Math.max(charactersSequentially, maxCharactersGroupSequence);
        }
        return maxCharactersGroupSequence;
    }

    boolean isCharacterOfType(char c);
}