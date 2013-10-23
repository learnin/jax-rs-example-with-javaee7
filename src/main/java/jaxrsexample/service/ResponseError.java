package jaxrsexample.service;

import java.io.Serializable;

public class ResponseError implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
    
    private String detailMessage;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the detailMessage
     */
    public String getDetailMessage() {
        return detailMessage;
    }

    /**
     * @param detailMessage the detailMessage to set
     */
    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }
}
