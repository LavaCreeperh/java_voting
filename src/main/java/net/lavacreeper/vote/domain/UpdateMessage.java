package net.lavacreeper.vote.domain;

public class UpdateMessage {
    private String message;
    private boolean success;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "UpdateMessage{" +
                "message='" + message + '\'' +
                ", success=" + success +
                '}';
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
