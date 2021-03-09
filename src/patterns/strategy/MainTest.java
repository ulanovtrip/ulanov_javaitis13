package patterns.strategy;

import patterns.strategy.impl.StrategyDecryptionShiftImpl;
import patterns.strategy.impl.StrategyDecryptionUnicodeImpl;
import patterns.strategy.impl.StrategyEncryptionShiftImpl;
import patterns.strategy.impl.StrategyEncryptionUnicodeImpl;
import patterns.strategy.utils.FileReader;
import patterns.strategy.utils.FileWriter;

public class MainTest {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        DecryptionEncryptionContext context = new DecryptionEncryptionContext();

        fileReader.parsInput(args);
        String operation = fileReader.getOperation();
        switch (operation) {
            case "enc":
                StringBuilder encryptedMess;
                if (fileReader.getTypeOfAlgorithm().equals("unicode")) {
                    context.setEncryptionStrategy(new StrategyEncryptionUnicodeImpl());
                    encryptedMess = context.executeStrategyEncryption(fileReader.getMessage(), fileReader.getKey());
                } else {
                    context.setEncryptionStrategy(new StrategyEncryptionShiftImpl());
                    encryptedMess = context.executeStrategyEncryption(fileReader.getMessage(), fileReader.getKey());
                }

                if (!(fileReader.getPathToReadFile() == null)) {
                    fileWriter.writeDataInFile(encryptedMess.toString(), fileReader.getPathToWriteFile());
                } else {
                    System.out.println(encryptedMess.toString());
                }
                break;

            case "dec":
                StringBuilder decryptedMess;
                if (fileReader.getTypeOfAlgorithm().equals("unicode")) {
                    context.setDecryptionStrategy(new StrategyDecryptionUnicodeImpl());
                    decryptedMess = context.executeStrategyDecryption(fileReader.getMessage(), fileReader.getKey());
                } else {
                    context.setDecryptionStrategy(new StrategyDecryptionShiftImpl());
                    decryptedMess = context.executeStrategyDecryption(fileReader.getMessage(), fileReader.getKey());
                }

                if (!(fileReader.getPathToWriteFile() == null)) {
                    fileWriter.writeDataInFile(decryptedMess.toString(), fileReader.getPathToWriteFile());
                } else {
                    System.out.println(decryptedMess);
                }
                break;
        }
    }
}
