package patterns.strategy;

import patterns.strategy.base.StrategyDecryption;
import patterns.strategy.base.StrategyEncryption;

public class DecryptionEncryptionContext {

    StrategyDecryption strategyDecryption;
    StrategyEncryption strategyEncryption;

    public void setEncryptionStrategy(StrategyEncryption strategyEncryption) {
        this.strategyEncryption = strategyEncryption;
    }

    public void setDecryptionStrategy(StrategyDecryption strategyDecryption) {
        this.strategyDecryption = strategyDecryption;
    }

    public StringBuilder executeStrategyEncryption(String message, int key) {
        return strategyEncryption.encryption(message, key);
    }

    public StringBuilder executeStrategyDecryption(String message, int key) {
        return strategyDecryption.decryption(message, key);
    }
}
