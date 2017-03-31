package com.example.msi.fastparking;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msi on 7/14/2016.
 */
public class SynUserRequest extends StringRequest {
    private static final String SYN_USER_REQUEST_URL = "http://123name.comxa.com/getUserManager.php";
    private Map<String,String> params;

    public SynUserRequest(Response.Listener<String> listener){
        super(Request.Method.POST,SYN_USER_REQUEST_URL,listener,null);
        params = new HashMap<>();
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}