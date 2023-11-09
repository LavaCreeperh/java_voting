package net.lavacreeper.vote.domain;

public class UsernameJson {
    String username;

    @Override
    public String toString() {
        return "UsernameJson{" +
                "username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
