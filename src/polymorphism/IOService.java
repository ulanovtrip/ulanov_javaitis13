package ru.polymorphism;

import ru.polymorphism.base.DeviceInput;
import ru.polymorphism.base.DeviceOutput;

// Здесь применяется шаблон "Фасад"
public class IOService {

    private DeviceInput input;
    private DeviceOutput output;

    public IOService(DeviceInput input, DeviceOutput output) {
        this.input = input;
        this.output = output;
    }

    public void print(String message) {
        output.print(message);
    }

    public String read() {
        return input.read();
    }

    public void printDeviceInformation() {
        input.printInfo();
        output.printInfo();
    }
}
