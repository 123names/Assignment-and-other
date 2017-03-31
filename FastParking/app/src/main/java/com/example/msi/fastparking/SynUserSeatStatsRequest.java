package com.example.msi.fastparking;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msi on 7/12/2016.
 */
public class SynUserSeatStatsRequest extends StringRequest{
    private static final String SYN_USER_SEAT_STATS_REQUEST_URL = "http://123name.comxa.com/getUserStats.php";
    private Map<String,String> params;

    public SynUserSeatStatsRequest(String username,Response.Listener<String> listener){
        super(Request.Method.POST,SYN_USER_SEAT_STATS_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("username", username);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
