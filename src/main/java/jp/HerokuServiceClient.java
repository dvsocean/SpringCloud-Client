package jp;

import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class HerokuServiceClient {

    public String getHerokuResponse(String url)
            throws IOException {

        String response = Request.Get(url).execute().returnContent().asString();
        Gson gson = new Gson();
        return gson.toJson(response);

    }
}
