package services;

import messages.MessageProcessor;
import printers.Printer;

public class PrintMessagesServiceImpl implements PrintMessagesService {

    // зависимости
    private MessageProcessor messageProcessor;
    private Printer printer;

    public PrintMessagesServiceImpl(MessageProcessor messageProcessor, Printer printer) {
        this.messageProcessor = messageProcessor;
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        String newMessage = messageProcessor.process(message);
        printer.print(newMessage);
    }
}
