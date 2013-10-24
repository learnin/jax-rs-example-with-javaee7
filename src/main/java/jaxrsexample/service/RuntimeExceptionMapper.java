package jaxrsexample.service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException e) {
        ResponseErrors errors = new ResponseErrors();
        ResponseError error = new ResponseError();
        error.setMessage("Internal Server Error");
        Throwable th = e;
        while (true) {
            if (th.getCause() == null) {
                break;
            }
            th = th.getCause();
        }
        error.setDetailMessage(th.getMessage());
        errors.add(error);
        return Response.serverError().entity(errors).type(MediaType.APPLICATION_JSON).build();
    }
    
}
