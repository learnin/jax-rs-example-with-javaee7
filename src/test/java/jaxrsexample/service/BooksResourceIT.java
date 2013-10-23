package jaxrsexample.service;

import jaxrsexample.Book;
import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class BooksResourceIT {

    @RunWith(Arquillian.class)
    public static class 該当するidが存在する場合 extends AbstractResourceIT {

        @Test
        @RunAsClient
        public void リソースが取得できる(@ArquillianResource URL base) throws Exception {
            Client client = getClient();
            Response response = client.target(base.toURI() + "/api/v1/books/1").request().get();
            assertThat(response.getStatus(), is(200));
            Book book = response.readEntity(Book.class);
            assertThat(book.getId(), is(1));
            client.close();
        }
    }
}
