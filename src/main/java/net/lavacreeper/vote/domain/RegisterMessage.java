package net.lavacreeper.vote.domain;

public class RegisterMessage {
    String message;
    boolean success;

    public RegisterMessage() {
    }

    public String getMessage() {
        return message;
    }

    public RegisterMessage(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    @Override
    public String toString() {
        return "RegisterMessage{" +
                "message='" + message + '\'' +
                ", success=" + success +
                '}';
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
