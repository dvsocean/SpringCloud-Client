package jp;

import com.google.gson.Gson;
import jp.model.Person;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.charset.Charset;

public class PersonServiceClient {

    public Person getPersonInformation(String baseUrl, int id)
            throws IOException {

        String response =  Request.Get(baseUrl + "/person/" + id).execute().returnContent().asString(Charset.forName("UTF-8"));
        Gson gson = new Gson();
        return gson.fromJson(response, Person.class);
    }
}
