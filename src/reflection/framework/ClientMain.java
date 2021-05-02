package reflection.framework;

public class ClientMain {
    public static void main(String[] args) {

        Container container = new Container();
        container.initialize();

        Terminal terminal = (Terminal) container.getComponent("terminal");
        terminal.giveMoney();
    }
}
