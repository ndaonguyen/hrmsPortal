package com.sbg.hrmsportal.helper;

import java.util.List;
import java.util.Map;

/**
 * Represents the result of an AppEngineClient call.
 */
public class CNetworkResponse {
    
    /**
     * The HTTP status code
     */
    public int status;
    
    /**
     * The HTTP headers received in the response
     */
    public  Map<String, List<String>> headers;
    
    /**
     * The response body, if any
     */
    public byte[] body;

    protected CNetworkResponse(int status,  Map<String, List<String>> headers, byte[] body) {
        this.status = status; this.headers = headers; this.body = body;
    }
}