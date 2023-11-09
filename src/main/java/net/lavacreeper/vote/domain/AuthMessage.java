package net.lavacreeper.vote.domain;

public class AuthMessage {
    private String username;
    private boolean rememberMe;

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    private String password;

    @Override
    public String toString() {
        return "AuthMessage{" +
                "username='" + username + '\'' +
                ", rememberMe=" + rememberMe +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
