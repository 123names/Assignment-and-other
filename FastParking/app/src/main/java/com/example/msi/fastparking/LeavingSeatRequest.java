package com.example.msi.fastparking;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msi on 7/1/2016.
 */
public class LeavingSeatRequest extends StringRequest {
    private static final String LEAVING_REQUEST_URL = "http://123name.comxa.com/leavingSeat.php";
    private Map<String,String> params;

    public LeavingSeatRequest(String Position,String currentUser, Response.Listener<String> listener){
        super(Request.Method.POST,LEAVING_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("position",Position);
        params.put("available","1");
        params.put("currentUser",currentUser);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
