package com.example.test.isrty.produitprosoftmobile;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by isrty on 27-Nov-17.
 */

public class putajout {

    protected void dowhenexe(){

        try {
       URL   url = new URL("http://localhost:3000/posts");
        HttpURLConnection hurl = (HttpURLConnection) url.openConnection();
        hurl.setRequestMethod("PUT");
        hurl.setDoOutput(true);
        hurl.setRequestProperty("Content-Type", "application/json");
        hurl.setRequestProperty("Accept", "application/json");

        String payload =
                    "{'pos'" +
                     ":{" +
                          "\"id\": 2, \"title\": \"json-server\", \"author\": \"typicode\"" +
                      "}" +
                    "}";

        OutputStreamWriter osw = new OutputStreamWriter(hurl.getOutputStream());
        osw.write(payload);
        osw.flush();
        osw.close();
    } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


    }

}
