package ru.polymorphism.impl;

import ru.polymorphism.base.AbstractDeviceInputScannerImpl;

public class DeviceInputWithPrefixScannerImpl extends AbstractDeviceInputScannerImpl {

    String prefix;

    public DeviceInputWithPrefixScannerImpl(String prefix) {
        super();
        this.prefix = prefix;
    }

    @Override
    public String read() {
        return prefix + " " + super.read();
    }

    @Override
    public void printInfo() {
        System.out.println("Реализация входного устр-ва на основе Scanner + Prefix");
    }
}
