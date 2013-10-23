package jaxrsexample.service;

import javax.ejb.embeddable.EJBContainer;
import org.junit.rules.ExternalResource;

public class EmbeddedEJBContainerResource extends ExternalResource {
    
    public EJBContainer container;
    
    @Override
    public void before() {
        container = EJBContainer.createEJBContainer();
    }
    
    @Override
    public void after() {
        container.close();
    }
}
