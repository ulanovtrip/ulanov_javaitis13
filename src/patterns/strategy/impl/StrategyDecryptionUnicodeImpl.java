package patterns.strategy.impl;

import patterns.strategy.base.StrategyDecryption;

public class StrategyDecryptionUnicodeImpl implements StrategyDecryption {

    @Override
    public StringBuilder decryption(String message, int key) {
        char[] chars = message.toCharArray();
        StringBuilder output = new StringBuilder();

        for (char aChar : chars) {
            int valueCurrSym = aChar - key;
            char convertInChar = (char) valueCurrSym;
            output.append(convertInChar);
        }

        return output;
    }
}
