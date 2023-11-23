package net.lavacreeper.vote.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public interface CFService {
    String secret_key = "1x0000000000000000000000000000000AA";

    boolean check(String token) throws IOException;
}
