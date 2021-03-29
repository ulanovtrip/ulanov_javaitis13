package ru.polymorphism;

import ru.polymorphism.impl.DeviceInputWithPrefixScannerImpl;
import ru.polymorphism.impl.DeviceOutputErrorImpl;

public class MainWithIOService {
    public static void main(String[] args) {
        IOService service = new IOService(
                new DeviceInputWithPrefixScannerImpl("Prefix Fire: "),
                new DeviceOutputErrorImpl()
        );
        service.printDeviceInformation();
        String input = service.read();
        service.print(input);
    }
}
