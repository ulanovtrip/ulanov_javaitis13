package ru.polymorphism;

import ru.polymorphism.base.DeviceInput;
import ru.polymorphism.base.DeviceOutput;
import ru.polymorphism.impl.DeviceInputWithPrefixScannerImpl;
import ru.polymorphism.impl.DeviceOutputErrorImpl;

public class MainWithoutIOService {
    public static void main(String[] args) {
        DeviceInput input = new DeviceInputWithPrefixScannerImpl("Считано с консоли :");
        //DeviceInput input = new DeviceInputWithTimeScannerImpl();
        //DeviceOutput output = new DeviceOutputWithTimeImpl();
        DeviceOutput output = new DeviceOutputErrorImpl();
        output.printInfo();
        input.printInfo();
        String i = input.read();
        output.print(i);
    }
}
