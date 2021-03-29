package ru.polymorphism.impl;

import ru.polymorphism.base.DeviceOutput;
import ru.polymorphism.base.Stream;

import java.time.LocalTime;

public class DeviceOutputWithTimeImpl implements DeviceOutput, Stream {

    @Override
    public void print(String message) {
        System.out.println("Время в : " + LocalTime.now() + " [ сообщение: " + message + "]");
    }

    @Override
    public void printInfo() {
        System.out.println("Реализация выходного устройства с временем");
    }

    @Override
    public void printInfoAboutStream() {
        System.out.println("Используется System.out");
    }
}
