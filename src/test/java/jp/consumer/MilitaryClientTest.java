package jp.consumer;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import jp.MilitaryServiceClient;
import jp.model.Burner;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MilitaryClientTest {

    @Rule
    public PactProviderRule provider = new PactProviderRule("military", "localhost", 8000, this);

    @Pact(provider="military", consumer="military_consumer")
    public PactFragment configurationFragment(PactDslWithProvider builder) {
        return builder
            .given("hardware exists")
            .uponReceiving("request for a specific hardware")
            .path("/hardware/1")
            .method("GET")
            .willRespondWith()
            //.headers(headers)
            .status(200)
            .body("{\"model\": \"1911 45. ACP\"}")
            .toFragment();
    }

    @PactVerification("military")
    @Test
    public void get_person() throws IOException {
        MilitaryServiceClient msc = new MilitaryServiceClient();
        Burner resp = msc.findBurner("http://localhost:8000", 1L);
        assertThat(resp.getModel(), is("1911 45. ACP"));
        System.out.println("Found burner --> " + resp.getModel());
    }
}
