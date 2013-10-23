package jaxrsexample.service;

import jaxrsexample.Book;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.ClassRule;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BooksResourceTest {

    @ClassRule
    public static EmbeddedEJBContainerResource containerResource = new EmbeddedEJBContainerResource();

    public static class 該当するidが存在する場合 {

        @Test
        public void リソースが取得できる() throws Exception {
            BooksResource sut = (BooksResource) containerResource.container.getContext().lookup("java:global/classes/BooksResource");
            Book book = sut.find(1);
            assertThat(book.getId(), is(1));
        }
    }
}