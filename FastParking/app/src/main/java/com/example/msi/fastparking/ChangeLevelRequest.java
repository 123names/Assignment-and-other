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
public class ChangeLevelRequest extends StringRequest {
    private static final String CHANGE_USER_LEVEL_REQUEST_URL = "http://123name.comxa.com/changeAccountLevel.php";
    private Map<String,String> params;

    public ChangeLevelRequest(String level,String username, Response.Listener<String> listener){
        super(Request.Method.POST,CHANGE_USER_LEVEL_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("level",level);
        params.put("username",username);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}