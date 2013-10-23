package jaxrsexample.service;

import jaxrsexample.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("v{apiVersion: [0-9]+}/books")
@Produces({MediaType.APPLICATION_JSON})
public class BooksResource extends AbstractResource<Book> {

    @PersistenceContext(unitName = "jaxrsexample-pu")
    private EntityManager em;

    public BooksResource() {
        super(Book.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Book entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(Book entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    public Book find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    public List<Book> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
