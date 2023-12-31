package net.lavacreeper.vote.domain;

public class LoginMessage {
    private String message;

    private boolean success;

    public LoginMessage() {
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
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

    public LoginMessage(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public LoginMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
