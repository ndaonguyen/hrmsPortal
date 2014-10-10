package com.sbg.hrmsportal.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import android.content.Context;


/**
 * Network client specially for json data transfer
 *
 */
public class CNetworkClient
{
	@SuppressWarnings("unused")
	private Context mContext;
	private String mErrorMessage;
//	private ProgressCallbackListener progressCallbackListener;
	
	public CNetworkClient(Context context) {
		mContext = context;
	}
	
    /**
     * Performs an HTTP GET request.  The request is performed inline and this method must not
     *  be called from the UI thread.
     *  
     * @param uri The URI you're sending the GET to
     * @param headers Any extra HTTP headers you want to send; may be null
     * @return a Response structure containing the status, headers, and body. Returns null if the request 
     *   could not be launched due to an IO error or authentication failure; in which case use errorMessage()
     *   to retrieve diagnostic information.
     */
    public CNetworkResponse get(String uri, Map<String, List<String>> headers) {
        GET get;
		try
		{
			get = new GET(new URL(uri), headers);
		} catch (MalformedURLException e)
		{
			this.mErrorMessage = "Malformed URL";
			return null;
		}
        return getOrPost(get);
    }

    /**
     * Performs an HTTP POST request.  The request is performed inline and this method must not
     *  be called from the UI thread.
     *  
     * @param uri The URI you're sending the POST to
     * @param headers Any extra HTTP headers you want to send; may be null
     * @param body The request body to transmit
     * @return a Response structure containing the status, headers, and body. Returns null if the request 
     *   could not be launched due to an IO error or authentication failure; in which case use errorMessage()
     *   to retrieve diagnostic information.
     */
    public CNetworkResponse post(String uri, Map<String, List<String>> headers, byte[] body) {
        POST post;
		try
		{
			post = new POST(new URL(uri), headers, body);
		} catch (MalformedURLException e)
		{
			this.mErrorMessage = "Malformed URL";
			return null;
		}
        return getOrPost(post);
    }
    
    /**
     * Provides an error message should a get() or post() return null.
     * @return the message
     */
    public String errorMessage() {
        return mErrorMessage;
    }

    private CNetworkResponse getOrPost(Request request) {
        mErrorMessage = null;
        HttpURLConnection conn = null;
        CNetworkResponse response = null;
        try {
            conn = (HttpURLConnection) request.uri.openConnection();
            
            if (request.headers != null) {
                for (String header : request.headers.keySet()) {
                    for (String value : request.headers.get(header)) {
                        conn.addRequestProperty(header, value);
                    }
                }
            }
            // To Fix EOF Error in Jelly Bean
            conn.addRequestProperty("Connection", "Close");
            
            if (request instanceof POST) {
                byte[] payload = ((POST) request).body;
                conn.setDoInput(true);
                conn.setDoOutput(true);
//                conn.setRequestProperty("Content-Type", "application/json");
                conn.setConnectTimeout(30 * 1000); //30 seconds timeout
                conn.setFixedLengthStreamingMode(payload.length);
                
                InputStream in = new ByteArrayInputStream(payload);
                OutputStream out = new BufferedOutputStream(conn.getOutputStream());
                //Write stream to send data to server (Upload progress)
                writeStream(in, out);
                
                int status = conn.getResponseCode();
                if (status / 100 != 2) {
                	if (conn.getResponseMessage() != null)
                		response = new CNetworkResponse(status, new Hashtable<String, List<String>>(), conn.getResponseMessage().getBytes());
                	else 
                		response = new CNetworkResponse(status, new Hashtable<String, List<String>>(), "Uncaught error".getBytes());
                }
            }
            if (response == null) {
                BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
                byte[] body = null;
                //Read stream to read data from server
                body = readStream(in);
                response = new CNetworkResponse(conn.getResponseCode(), conn.getHeaderFields(), body);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
            mErrorMessage = ((request instanceof POST) ? "POST " : "GET ") + " " + e.getLocalizedMessage();
        } finally {
            if (conn != null)
                conn.disconnect();
        }
        return response;
    }

    // request structs
    private class Request {
        public URL uri;
        public Map<String, List<String>> headers;
        public Request(URL uri, Map<String, List<String>> headers) {
            this.uri = uri; this.headers = headers;
        }
    }
    private class POST extends Request {
        public byte[] body;
        public POST(URL uri, Map<String, List<String>> headers, byte[] body) {
            super(uri, headers);
            this.body = body; 
        }
    }
    private class GET extends Request {
        public GET(URL uri, Map<String, List<String>> headers) {
            super(uri, headers);
        }
    }
    
    protected void writeStream(InputStream in, OutputStream out)
            throws IOException
    {
        byte abyte0[] = new byte[1024];
        
        int i;
        while((i = in.read(abyte0)) >= 0) {
        	out.write(abyte0, 0, i);
        }
        
        in.close();
        out.flush();
        out.close();
    }

    // utilities
    private static byte[] readStream(InputStream in) 
            throws IOException {
        byte[] buf = new byte[1024];
        int count = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        while ((count = in.read(buf)) != -1)
        {
        	out.write(buf, 0, count);
        }
        return out.toByteArray(); //Get the data from the server
    }

//    private String str(int id) {
//        return mContext.getString(id);
//    }
}
