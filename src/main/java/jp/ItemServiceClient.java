package jp;

import com.google.gson.Gson;
import jp.model.Item;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class ItemServiceClient {

    public Item getPersonInformation(String baseUrl, int id)
            throws IOException {

        String response = Request.Get(baseUrl + "/item/" + id).execute().returnContent().asString();
        Gson gson = new Gson();
        return gson.fromJson(response, Item.class);
    }

    public void getResponseFromHeroku(String url) throws IOException {
        String response =  Request.Get(url).execute().returnContent().asString();
        System.out.println("Output from herokuApp --> " + response);
    }
}
