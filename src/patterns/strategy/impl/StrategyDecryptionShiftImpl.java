package patterns.strategy.impl;

import patterns.strategy.base.StrategyDecryption;
import patterns.strategy.base.StrategyEncryption;

public class StrategyDecryptionShiftImpl implements StrategyDecryption {

    StrategyEncryption strategyEncryptionShift;

    public StrategyDecryptionShiftImpl() {
        strategyEncryptionShift = new StrategyEncryptionShiftImpl();
    }

    @Override
    public StringBuilder decryption(String message, int offset) {
        return strategyEncryptionShift.encryption(message, 26 - (offset % 26));
    }
}
