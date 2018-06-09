package jp.consumer;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import jp.ItemServiceClient;
import jp.PersonServiceClient;
import jp.model.Item;
import jp.model.Person;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemClientTest {

    Map<String, String> headers = Collections.singletonMap("Content-Type", "application/json");

    @Rule
    public PactProviderRule provider = new PactProviderRule("item_prov", "localhost", 8000, this);

    @Pact(provider="item_prov", consumer="item_consumer")
    public PactFragment configurationFragment(PactDslWithProvider builder) {
        return builder
                .given("a person exists")
                .uponReceiving("a request for a specific")
                .path("/itemsObject")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body("{\"name\":\"Daniel\",\"lastname\":\"Ocean\",\"profession\":\"Professional\",\"location\":\"Dallas, TX\",\"contract\":\"American Airlines\",\"employer\":\"Verys\"}")
                .toFragment();
    }

    @PactVerification("test_provider")
    @Test
    public void get_person() throws IOException {
        ItemServiceClient psc = new ItemServiceClient();
        Item response = psc.getPersonInformation("https://ocean-rest-test.herokuapp.com/itemsObject");
        assertThat(response.getDescription(), is(""));

    }
}
