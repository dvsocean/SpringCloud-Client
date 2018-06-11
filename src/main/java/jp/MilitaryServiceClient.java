package jp;

import com.google.gson.Gson;
import jp.model.Burner;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class MilitaryServiceClient {

    public Burner findBurner(String url, Long id) throws IOException {
        String res = Request.Get(url + "/hardware/" + id).execute().returnContent().asString();
        Gson gson = new Gson();
        return gson.fromJson(res, Burner.class);
    }
}
