package ru.itis.game.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.game.dto.MessageDto;
import ru.itis.game.dto.UsernamePasswordDto;
import ru.itis.game.services.GameService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameServer {

    // выделим отдельный вложенный класс под каждого клиента
    class Client extends Thread {

        // номер клиента
        private final int clientNumber;
        // объект, который представляем из себя подключение
        private final Socket client;

        private boolean isAuthenticated = false;
        private boolean isConnected = true;

        // поток байтов для чтения информации от клиента
        private BufferedReader fromClient;
        // поток байтов для записи информации клиенту
        private PrintWriter toClient;

        public Client(Socket socket, int clientNumber) {
            // даём потоку название номера клиента
            super(String.valueOf(clientNumber));
            // запоминаем подключение
            this.client = socket;
            // фиксируем номер
            this.clientNumber = clientNumber;
            // открываем потоки для чтения и записи информации
            initializeClientStreams(socket);
        }

        private void initializeClientStreams(Socket client) {
            try {
                // сюда читаем от клиента
                InputStream fromClientInputStream = client.getInputStream();
                // сюда пишем клиенту
                OutputStream toClientOutputStream = client.getOutputStream();

                // использовали Reader и Writer, чтобы обмениваться сообщениями (текстовыми) с клиентами
                this.fromClient = new BufferedReader(new InputStreamReader(fromClientInputStream));
                this.toClient = new PrintWriter(new OutputStreamWriter(toClientOutputStream), true);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        // логика работы отдельного потока для клиента
        // этот метод вызывается методом start()
        @Override
        public void run() {
            System.out.println("СЕРВЕРНЫЙ ПОТОК " + clientNumber + " поток для клиента запущен");
            // этап аутентификации
            processAuthentication();
            // эта обработки сообщения
            processMessages();
            // закрыть соединение
            closeClient();
        }

        // обработка аутентификации
        private void processAuthentication() {
            // пока пользователь не аутентифицирован
            while (!isAuthenticated) {
                try {
                    // читаю от клиента сообщение, это строка с формате json
                    String authenticationMessage = fromClient.readLine();

                    if (authenticationMessage != null) {
                        System.out.println(authenticationMessage);
                        // тогда нужно сконвертировать в UsernamePasswordDto, т.е. преобразовать в объект UsernamePasswordDto
                        UsernamePasswordDto usernamePasswordDto =
                                objectMapper.readValue(authenticationMessage, UsernamePasswordDto.class);
                        System.out.println(usernamePasswordDto.getNickname());
                        System.out.println(usernamePasswordDto.getPassword());

                        // если аутентифицирован
                        if (gameService.authenticate(usernamePasswordDto)) {
                            // ставим флаг, что аутентифицирован, это выкинет из цикла while (!isAuthenticated)
                            isAuthenticated = true;
                        } else {
                            // если нет, то флаг неаутентифицирован и выходим из цикла
                            isConnected = false;
                            break;
                        }
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        private void processMessages() {
            // сюда зайдёт только если isConnected true, т.е. пока есть подключение
            while (isConnected) {
                try {
                    // считываем от клиента сообщение
                    String messageFromClient = fromClient.readLine();
                    // из json строки преобразуем в полноценный объект
                    MessageDto message = objectMapper.readValue(messageFromClient, MessageDto.class);
                    // сохраняем с БД
                    gameService.saveMessage(message);

                    // проходим по всему списку клиентов
                    for (Client client : clients) {
                        // this != client - пропускает самого себя, чтобы не отправить сообщение себе
                        if (this != client && client.isAuthenticated) {
                            // отправка сообщения клиенту
                            client.toClient.println(messageFromClient);
                        }
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        private void closeClient() {
            // если аутентификация не прошла, то удалим пользователя из списка и закроем его
            clients.remove(this);
            try {
                // закрываем соединение сокета
                client.close();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }


    // сервер, объектная переменная, через которую будет общаться наш сервер
    private ServerSocket server;

    // список клиентов, для каждого клиента создаем отдельный поток исполнения, который привязывается к клиенту
    private List<Client> clients;

    // бизнес-логика нашего приложения
    @Autowired
    private GameService gameService;

    // для конвертации сообщений из json в объект и наоборот
    @Autowired
    private ObjectMapper objectMapper;

    public void start(int port) {
        try {
            // создаём пустой список клиентов
            clients = new ArrayList<>();
            // запускаем сокет-сервер
            server = new ServerSocket(port);
            // создаём отдельный поток для ожидания клиентов
            new Thread(() -> {
                // запускаем бесконечный цикл (потому, что клиентов может быть много и мы ждём каждого)
                while (true) {
                    try {
                        // дождались клиента, accept не даёт отработать дальше, пока не подключится клиент
                        Socket socket = server.accept();
                        // создаем для него объект
                        Client client = new Client(socket, clients.size());

                        // запуск потока для получения сообщений от конкретного клиента
                        // start() запустит метод run() в классе Client
                        client.start();

                        // добавили поток клиента в список
                        clients.add(client);

                        gameService.connect(socket.getRemoteSocketAddress().toString());
                        System.out.println("СЕРВЕРНЫЙ ПОТОК - " + Thread.currentThread().getName() + " КЛИЕНТ ПОДКЛЮЧЕН");
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }, "connectRatsClientsThread").start();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
