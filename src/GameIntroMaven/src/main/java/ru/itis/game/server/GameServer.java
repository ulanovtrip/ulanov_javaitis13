package ru.itis.game.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.game.config.ApplicationConfig;
import ru.itis.game.dto.MessageDto;
import ru.itis.game.dto.UsernamePasswordDto;
import ru.itis.game.services.GameService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class GameServer {
    // выделим отдельный класс под каждого клиента
    class Client extends Thread {
        private int clientNumber;
        private BufferedReader fromClient;
        private PrintWriter toClient;
        private boolean isAuthenticated = false;
        private boolean isConnected = true;
        private Socket client;

        public Client(Socket socket, int clientNumber) {
            super(String.valueOf(clientNumber));
            this.client = socket;
            this.clientNumber = clientNumber;
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

        @Override
        public void run() {
            System.out.println("СЕРВЕРНЫЙ ПОТОК " + clientNumber + " поток для клиента запущен");

            processAuthentication();

            processMessages();

            closeClient();
        }

        private void processAuthentication() {
            while (!isAuthenticated) {
                try {
                    String authenticationMessage = fromClient.readLine();
                    if (authenticationMessage != null) {
                        System.out.println(authenticationMessage);
                        //  тогда нужно сконвертировать в UsernamePasswordDto
                        UsernamePasswordDto usernamePasswordDto = objectMapper.readValue(authenticationMessage, UsernamePasswordDto.class);
                        System.out.println(usernamePasswordDto.getNickname());
                        System.out.println(usernamePasswordDto.getPassword());

                        // если аутентифицирован
                        if (gameService.authenticate(usernamePasswordDto)) {
                            // ставим флаг, что аутентифицирован
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
            // сюда зайдёт только если isConnected true
            while (isConnected) {
                try {
                    String messageFromClient = fromClient.readLine();

                    MessageDto message = objectMapper.readValue(messageFromClient, MessageDto.class);
                    gameService.saveMessage(message);

                    for (Client client : clients) {
                        if (this != client) {
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

    private GameService gameService;
    private ObjectMapper objectMapper;

    public void start(int port) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        this.gameService = context.getBean(GameService.class);
        this.objectMapper = context.getBean(ObjectMapper.class);
        try {
            clients = new ArrayList<>();
            server = new ServerSocket(port);
            new Thread(() -> {
                while (true) {
                    try {
                        // дождались клиента
                        Socket socket = server.accept();
                        // создаем для него объект
                        Client client = new Client(socket, clients.size());
                        client.start();
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
