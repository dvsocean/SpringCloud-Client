package jp.consumer;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import jp.PersonServiceClient;
import jp.model.Person;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PersonClientTest {

    Map<String, String> headers = Collections.singletonMap("Content-Type", "application/json");

    @Rule
    public PactProviderRule provider = new PactProviderRule("person", "localhost", 8000, this);

    @Pact(provider="person", consumer="person_consumer")
    public PactFragment configurationFragment(PactDslWithProvider builder) {
        return builder
            .given("a person exists")
            .uponReceiving("a request for a specific")
            .path("/person/1")
            .method("GET")
            .willRespondWith()
            .headers(headers)
            .status(200)
            .body("{\"id\":1,\"name\":\"Jack\",\"surname\":\"Sparrow\"}")
            .toFragment();
    }

    @PactVerification("person")
    @Test
    public void get_person() throws IOException {
        PersonServiceClient psc = new PersonServiceClient();
        Person response = psc.getPersonInformation("http://localhost:8000", 1);
        assertThat(response.getName(), is("Jack"));
        assertThat(response.getSurname(), is("Sparrow"));
        assertThat(response.getId(), is(1L));
    }
}
