package services;

import messages.MessageProcessor;
import printers.Printer;

public class PrintMessagesServiceImpl implements PrintMessagesService {

    // зависимости
    private MessageProcessor messageProcessor;

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    private Printer printer;

    public PrintMessagesServiceImpl(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @Override
    public void print(String message) {
        String newMessage = messageProcessor.process(message);
        printer.print(newMessage);
    }
}
