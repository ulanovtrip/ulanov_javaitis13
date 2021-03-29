package ru.polymorphism.impl;

import ru.polymorphism.base.AbstractDeviceInputScannerImpl;

import java.time.LocalTime;

public class DeviceInputWithTimeScannerImpl extends AbstractDeviceInputScannerImpl {


    public DeviceInputWithTimeScannerImpl() {
        super();
    }

    public String read() {
        return super.read() + " - " + LocalTime.now();
    }

    @Override
    public void printInfo() {
        System.out.println("Реализация входного устр-ва со Scanner + время");
    }
}
