import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalTime.now;

public class TxtMessage extends ChatMessage implements Serializable {

    private String message;

    /**
     * Constructor
     * @param sender
     * @param message
     */
    public TxtMessage(String sender, String message) {
        super(sender);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return "@" + dtf.format(now())+ " " + getSender() +  ": " + message;
    }

    public String toLowerCase() {
        return message.toLowerCase();
    }


    /**
     * Not exactly an override
     * @param obj
     * @return
     */
    public boolean equals(TxtMessage obj) {
        return this.message.equals((obj).message);
    }

    /**
     * TxtMessage can "equal" a String
     * @param obj
     * @return
     */
    public boolean equals(String obj) {
        return this.message.equals(obj);
    }

    public boolean contains(String obj) {
        return this.message.contains(obj);
    }
}
