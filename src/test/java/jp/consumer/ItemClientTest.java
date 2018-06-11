package jp.consumer;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import jp.ItemServiceClient;
import jp.model.Item;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemClientTest {

    //Map<String, String> headers = Collections.singletonMap("Content-Type", "application/json");

//    @Rule
//    public PactProviderRule provider = new PactProviderRule("item_prov", "localhost", 8000, this);
//
//    @Pact(provider="item_prov", consumer="item_consumer")
//    public PactFragment configurationFragment(PactDslWithProvider builder) {
//        return builder
//                .given("a an item is present")
//                .uponReceiving("a request for a specific item")
//                .path("/item/3")
//                .method("GET")
//                .willRespondWith()
//                //.headers(headers)
//                .status(200)
//                .body("{\"description\":\"Cars\",\"completed\":false,\"belongsTo\":\"Evan\"}")
//                .toFragment();
//    }
//
//    @PactVerification("item_prov")
    @Test
    public void get_person() throws IOException {
        ItemServiceClient psc = new ItemServiceClient();
        Item response = psc.getPersonInformation("http://localhost:8000", 3);
        assertThat(response.getBelongsTo(), is("Evan"));
        assertThat(response.isCompleted(), is(false));
        System.out.println("The owner of this item is --> " + response.getBelongsTo());
        System.out.println("The completed status is --> " + response.isCompleted());
    }
}
