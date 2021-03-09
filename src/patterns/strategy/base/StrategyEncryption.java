package patterns.strategy.base;

public interface StrategyEncryption {
    StringBuilder encryption(String message, int offset);
}
