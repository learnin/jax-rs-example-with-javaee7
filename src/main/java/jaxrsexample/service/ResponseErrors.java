package jaxrsexample.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseErrors implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<ResponseError> errors = new ArrayList<>();

    public void add(ResponseError error) {
        getErrors().add(error);
    }

    /**
     * @return the errors
     */
    public List<ResponseError> getErrors() {
        return errors;
    }
}
