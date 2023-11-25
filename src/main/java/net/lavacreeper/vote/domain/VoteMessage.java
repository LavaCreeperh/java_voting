package net.lavacreeper.vote.domain;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.domain
 * @className: VoteMessage
 * @author: LavaCreeper
 * @description: DONE
 * @date: 11/23/23 10:56 PM
 * @version: 1.0
 */
public class VoteMessage {
    Integer id;
    String token;

    @Override
    public String toString() {
        return "VoteMessage{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
