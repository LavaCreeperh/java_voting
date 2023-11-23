package net.lavacreeper.vote.domain;

public class RegisterJson {
    String username;
    String password;

    @Override
    public String toString() {
        return "RegisterJson{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", turnstileToken='" + turnstileToken + '\'' +
                '}';
    }

    String email;
    String turnstileToken;

    public String getTurnstileToken() {
        return turnstileToken;
    }

    public void setTurnstileToken(String turnstileToken) {
        this.turnstileToken = turnstileToken;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
