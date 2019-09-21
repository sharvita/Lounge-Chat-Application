import java.io.Serializable;

public class ChatMessage implements Serializable {

    private String sender;

    public ChatMessage() {
        this.sender = "USER";
    }

    public ChatMessage(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
