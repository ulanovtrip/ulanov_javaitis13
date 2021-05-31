package ru.itis.game.sockets;

import ru.itis.game.sockets.client.GameClient;

import java.util.Scanner;

// Старт клиента
public class MainClient {
    public static void main(String[] args) {

        GameClient gameClient = new GameClient("localhost", 7777);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Хотите зарегаться?");
        System.out.println("1. Да.");
        System.out.println("2. Нет.");
        System.out.println("Введите число:");

        int answer = scanner.nextInt();

        String type = answer == 1 ? "signUp" : "signIn";
        scanner.nextLine(); // это надо сделать чтобы пропустить строку

        System.out.println("Введите имя:");
        String nickName = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        // установим никнейм через сеттер
        gameClient.setFrom(nickName);

        // отправляем аутентификацию на сервер, т.е. отправляем логин/пароль на проверку
        gameClient.sendAuthentication(nickName, password, type);

        // пока соединение есть
        // чтобы закрыть соединение, нужно вводить ещё одно сообщение вконце ввода
        while (!gameClient.isClosed()) {
            // считываем текст сообщения из консоли клиента
            String messageToServer = scanner.nextLine();
            // отправляем на сервер
            gameClient.sendMessageToServer(messageToServer);
        }

        System.out.println("Соединение закрыто.");
    }
}
