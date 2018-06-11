package jp.consumer;

import jp.MilitaryServiceClient;
import jp.model.Burner;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MilitaryClientTest {

    @Test
    public void get_person() throws IOException {
        MilitaryServiceClient msc = new MilitaryServiceClient();
        Burner resp = msc.findBurner("http://localhost:8000", 1L);
        assertThat(resp.getModel(), is("1911 45. ACP"));
        System.out.println("Found burner --> " + resp.getModel());
    }
}
