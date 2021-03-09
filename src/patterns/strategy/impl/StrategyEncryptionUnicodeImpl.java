package patterns.strategy.impl;

import patterns.strategy.base.StrategyEncryption;

public class StrategyEncryptionUnicodeImpl implements StrategyEncryption {

    private static final char[] ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int START = ALPHABET_UPPER[0];
    private static final int END = ALPHABET_UPPER[ALPHABET_UPPER.length - 1];

    @Override
    public StringBuilder encryption(String message, int offset) {
        char[] chars = message.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (char aChar : chars) {
            String regexForUpLetters = "[A-Z]";
            String regexForLowLetters = "[a-z]";
            if (!String.valueOf(aChar).matches(regexForUpLetters) || !String.valueOf(aChar).matches(regexForLowLetters)) {
                char encNonSymbol = (char) ((int) aChar + offset);
                stringBuilder.append(encNonSymbol);
            } else {
                if ((int) aChar <= END && (int) aChar >= START) {
                    int newIndex = (int) aChar + offset;
                    if (newIndex > END) {
                        int sub = newIndex % 122;
                        newIndex = (sub + START) - 1;
                    }

                    char encryptSym = (char) (newIndex);
                    stringBuilder.append(encryptSym);
                }
            }
        }
        return stringBuilder;
    }
}
