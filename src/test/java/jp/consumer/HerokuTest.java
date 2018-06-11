package jp.consumer;

import jp.HerokuServiceClient;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class HerokuTest {

    @Test
    public void get_heroku() throws IOException {
        HerokuServiceClient isc = new HerokuServiceClient();
        String response = isc.getHerokuResponse("https://ocean-rest-test.herokuapp.com/itemsObject");
        if(response.contains("Daniel")){
            Assert.assertTrue(true);
        }
        System.out.println("Entire response is --> " + response);
    }
}
