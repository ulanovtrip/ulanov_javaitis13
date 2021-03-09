package patterns.strategy.impl;

import patterns.strategy.base.StrategyEncryption;

public class StrategyEncryptionShiftImpl implements StrategyEncryption {

    @Override
    public StringBuilder encryption(String message, int offset) {
        StringBuilder result = new StringBuilder();
        String regexSmallLetter = "[a-z]";

        for (char character : message.toCharArray()) {
            String regexBigLetter = "[A-Z]";
            if (String.valueOf(character).matches(regexSmallLetter)) {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else if (String.valueOf(character).matches(regexBigLetter)) {
                int originalAlphabetPosition = character - 'A';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('A' + newAlphabetPosition);
                result.append(newCharacter);
            } else if (character == ' ' || character == '!') {
                result.append(character);
            }
        }
        return result;
    }
}
