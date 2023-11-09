package net.lavacreeper.vote.domain;

public class Message {
    String message;
    boolean success;

    public Message(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", success=" + success +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
