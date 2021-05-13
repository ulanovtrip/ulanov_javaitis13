package messages;

import java.time.LocalDate;

public class MessageProcessorTimeImpl implements MessageProcessor {
    @Override
    public String process(String message) {
        return LocalDate.now()+ " " + message;
    }
}
