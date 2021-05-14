import messages.MessageProcessor;
import messages.MessageProcessorReplacerImpl;
import messages.MessageProcessorTimeImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
//        Printer printer = new PrinterErrorImpl();
//        MessageProcessor messageProcessor = new MessageProcessorTimeImpl();


        // данный код будет работать в любом случае, но с разным результатом
        // это называется слабая связь между компонентами

//        PrintMessagesService printMessagesService = new PrintMessagesServiceImpl(messageProcessor, printer);
//        printMessagesService.print("Cat, bat, rat!");


        // так можно работать, если в  xml описать только бины
//        // сообщаем где находится файл с бинами
//        // ClassPathXmlApplicationContext это реализация ApplicationContext, считывает бины и помещает в контейнер.
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
//        // установка контекста, т.е. тут получаем бин из контекста
//        Printer printer = applicationContext.getBean(Printer.class, "printer");
//        printer.print("Hello, my Rats.");


        // если в xml описать бин сервиса и его конструктор, то можно так
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        PrintMessagesService service = applicationContext.getBean(PrintMessagesServiceImpl.class, "service");
        service.print("Hello, lovely Rats!");

    }
}
