package net.lavacreeper.vote.domain;

public class IfExistsApiMessage {
    String message;
    boolean ifExists;

    public IfExistsApiMessage(String message, boolean ifExists) {
        this.message = message;
        this.ifExists = ifExists;
    }

    @Override
    public String toString() {
        return "IfExistsApiMessage{" +
                "message='" + message + '\'' +
                ", ifExists=" + ifExists +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIfExists() {
        return ifExists;
    }

    public void setIfExists(boolean ifExists) {
        this.ifExists = ifExists;
    }
}
