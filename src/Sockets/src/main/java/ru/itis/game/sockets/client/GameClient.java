package ru.itis.game.sockets.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.itis.game.sockets.dto.MessageDto;
import ru.itis.game.sockets.dto.UsernamePasswordDto;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GameClient {

    // посылаем данные на сервер, это поток байтов
    private PrintWriter toServer;
    // получаем с сервера, поток байтов
    private BufferedReader fromServer;
    // для конвертации объектов в json и обратно
    private ObjectMapper objectMapper;
    // имя текущего клиента
    private String from;
    // Socket-клиент, основной компонент для взаимодействия с с сокет-сервером
    private Socket client;

    public GameClient(String host, int port) {
        try {
            // создаём сокет
            this.client = new Socket(host, port);
            // открываем потоки байтов для взаимодействия, т.е. чтения и записи информации
            this.toServer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
            this.fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        // нужен, чтобы передать json строку
        objectMapper = new ObjectMapper();
        // регистрируем модуль для конвертации времени/даты в JSON
        objectMapper.registerModule(new JavaTimeModule());
        // запуск приёма сообщений с сервера
        startReceive();
    }

    // метод вызывает отдельный поток связанный с чтением сообщения от сервера
    private void startReceive() {
        // start() вызывает метод run() из class ReceiveMessagesTask
        // т.е. запускается отдельный поток исполнения для получения сообщений сервера, это слушатель сообщений
        (new ReceiveMessagesTask()).start();
    }

    // отдельный метод для отправки сообщения на сервер
    private void sendMessageAsJson(Object message) {
        try {
            // преобразуем в строку String, т.е. в JSON строку сконвертируем
            String messageToServer = objectMapper.writeValueAsString(message);
            // отправим на сервер, это происходит из потока main
            toServer.println(messageToServer);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    public void sendAuthentication(String nickname, String password) {
        UsernamePasswordDto usernamePasswordDto = UsernamePasswordDto.builder()
                .nickname(nickname)
                .password(password)
                .build();

        // отправка сообщения
        sendMessageAsJson(usernamePasswordDto);
    }

    // метод для отправки сообщений на сервер, отправляется text
    public void sendMessageToServer(String text) {
        // этот код выделяет тэги, которые начинаются с # (#Марсель)

        List<String> tags = null;

        // если текст содержит #, то вытащим их все
        if (text.contains("#")) {
            tags = new ArrayList<>();

            // разобъем текст по пробелам
            String[] parts = text.split(" ");

            // пройдёмся по разбитым частям и вытащим всё, что начинается с #
            for (String part : parts) {
                if (part.startsWith("#")) {
                    tags.add(part.substring(1));
                }
            }
        }

        // создание объекта MessageDto для отправки на сервер
        MessageDto message = MessageDto
                .builder()
                .dispatchDateTime(LocalDateTime.now())
                .text(text)
                .from(from)
                .tags(tags)
                .build();
        // отправка
        sendMessageAsJson(message);
    }

    public boolean isClosed() {
        return client.isClosed();
    }

    public void setFrom(String from) {
        this.from = from;
    }

    // поток для чтения сообщений с сервера
    class ReceiveMessagesTask extends Thread {
        @Override
        public void run() {
            // бесконечно работает
            while (true) {
                try {
                    // читаем сообщение с сервера
                    String messageFromServer = fromServer.readLine();
                    // если от сервера есть сообщение, то
                    if (messageFromServer != null) {
                        // печатаем его в клиенте
                        System.out.println(messageFromServer);
                    } else {
                        // если нет сообщения, то закрываем соединение
                        System.out.println("Thread is Closed");
                        client.close();
                        // и останавливаем цикл
                        break;
                    }
                    System.out.println(messageFromServer);
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }
}
