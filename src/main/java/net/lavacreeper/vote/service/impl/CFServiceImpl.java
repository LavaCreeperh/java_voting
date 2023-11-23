package net.lavacreeper.vote.service.impl;

import net.lavacreeper.vote.service.CFService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.service.impl
 * @className: CFServiceImpl
 * @author: LavaCreeper
 * @description: DONE
 * @date: 11/23/23 3:18 PM
 * @version: 1.0
 */
@Service
public class CFServiceImpl implements CFService {
    @Override
    public boolean check(String token) throws IOException {
        URL url = new URL("https://challenges.cloudflare.com/turnstile/v0/siteverify");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpConn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
        writer.write("secret=" + secret_key + "&response=" + token);
        writer.flush();
        writer.close();
        httpConn.getOutputStream().close();

        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        return response.contains("\"success\":true");
    }

}
