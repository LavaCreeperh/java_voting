package net.lavacreeper.vote.service;

import net.lavacreeper.vote.domain.*;

public interface UserService {
    public User getByUsername(String username);
    public User getByEmail(String email);
    public Boolean existsByUsername(String username);
    public Boolean save(User user);

    public LoginMessage login(AuthMessage authMessage);

    public RegisterMessage register(RegisterJson registerJson);

    public IfExistsApiMessage checkIfUsernameExists(String username);

}
