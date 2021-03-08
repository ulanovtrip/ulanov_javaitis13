package ru.polymorphism.impl;

import ru.polymorphism.base.DeviceOutput;
import ru.polymorphism.base.Stream;

public class DeviceOutputErrorImpl implements DeviceOutput, Stream {

    @Override
    public void print(String output) {
        System.err.println(output);
    }

    @Override
    public void printInfo() {
        System.out.println("Реализация на основе потока System.err");
    }

    @Override
    public void printInfoAboutStream() {
        System.out.println("Используется System.err");
    }
}
