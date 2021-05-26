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

    // посылаем данные на сервер
    private PrintWriter toServer;
    // получаем с сервера
    private BufferedReader fromServer;
    private ObjectMapper objectMapper;
    private String from;
    private Socket client;

    public GameClient(String host, int port) {
        try {
            // создаём сокет
            this.client = new Socket("localhost", 7777);
            this.toServer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
            this.fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        // нужен, чтобы передать json строку
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        startReceive();
    }

    // метод вызывает отдельный поток связанный с чтением сообщения от сервера
    private void startReceive() {
        (new ReceiveMessagesTask()).start();
    }

    public void sendAuthentication(String nickname, String password) {
        UsernamePasswordDto usernamePasswordDto = UsernamePasswordDto.builder()
                .nickname(nickname)
                .password(password)
                .build();

        try {
            toServer.println(objectMapper.writeValueAsString(usernamePasswordDto));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    public void sendMessageToServer(String text) {
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

        // собираем сообщение
        MessageDto message = MessageDto
                .builder()
                .dispatchDateTime(LocalDateTime.now())
                .text(text)
                .from(from)
                .tags(tags)
                .build();

        try {
            toServer.println(objectMapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean isClosed() {
        return client.isClosed();
    }

    public void setFrom(String from) {
        this.from = from;
    }

    class ReceiveMessagesTask extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    String messageFromServer = fromServer.readLine();
                    // если от сервера есть сообщение, то
                    if (messageFromServer != null) {
                        System.out.println(messageFromServer);
                    } else {
                        // если нет, то закрываем
                        System.out.println("Thread is Closed");
                        client.close();
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
