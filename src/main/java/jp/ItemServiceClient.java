package jp;

import com.google.gson.Gson;
import jp.model.Item;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.charset.Charset;

public class ItemServiceClient {

    public Item getPersonInformation(String baseUrl)
            throws IOException {

        String response =  Request.Get(baseUrl).execute().returnContent().asString(Charset.forName("UTF-8"));
        Gson gson = new Gson();
        return gson.fromJson(response, Item.class);
    }
}
