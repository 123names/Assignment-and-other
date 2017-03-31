package com.example.msi.fastparking;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msi on 6/26/2016.
 */
public class SynSeatsRequest extends StringRequest {
    private static final String SYN_SEAT_REQUEST_URL = "http://123name.comxa.com/getSeats.php";
    private Map<String,String> params;

    public SynSeatsRequest(Response.Listener<String> listener){
        super(Request.Method.POST,SYN_SEAT_REQUEST_URL,listener,null);
        params = new HashMap<>();
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
