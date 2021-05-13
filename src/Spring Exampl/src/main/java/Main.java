import messages.MessageProcessor;
import messages.MessageProcessorReplacerImpl;
import messages.MessageProcessorTimeImpl;
import printers.Printer;
import printers.PrinterErrorImpl;
import printers.PrinterStandardImpl;
import services.PrintMessagesService;
import services.PrintMessagesServiceImpl;

public class Main {
    public static void main(String[] args) {
        // один вариант реализации компонентов
        //Printer printer = new PrinterStandardImpl();
        //MessageProcessor messageProcessor = new MessageProcessorReplacerImpl("bat");

        // другой вариант
        Printer printer = new PrinterErrorImpl();
        MessageProcessor messageProcessor = new MessageProcessorTimeImpl();


        // данный код будет работать в любом случае, но с разным результатом
        // это называется слабая связь между компонентами
        PrintMessagesService printMessagesService = new PrintMessagesServiceImpl(messageProcessor, printer);
        printMessagesService.print("Cat, bat, rat!");
    }
}
